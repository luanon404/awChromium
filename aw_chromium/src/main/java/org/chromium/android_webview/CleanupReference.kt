// Copyright 2012 The Chromium Authors. All rights reserved.
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.
package org.chromium.android_webview

import android.annotation.SuppressLint
import android.os.Handler
import android.os.Looper
import android.os.Message
import org.chromium.base.Log
import org.chromium.base.ThreadUtils
import org.chromium.base.TraceEvent
import java.lang.ref.ReferenceQueue
import java.lang.ref.WeakReference

/**
 * Handles running cleanup tasks when an object becomes eligible for GC. Cleanup tasks
 * are always executed on the main thread. In general, classes should not have
 * finalizers and likewise should not use this class for the same reasons. The
 * exception is where public APIs exist that require native side resources to be
 * cleaned up in response to java side GC of API objects. (Private/internal
 * interfaces should always favor explicit resource releases / destroy()
 * protocol for this rather than depend on GC to trigger native cleanup).
 * NOTE this uses WeakReference rather than PhantomReference, to avoid delaying the
 * cleanup processing until after finalizers (if any) have run. In general usage of
 * this class indicates the client does NOT use finalizers anyway (Good), so this should
 * not be a visible difference in practice.
 * @param obj the object whose loss of reachability should trigger the
 * cleanup task.
 * @param cleanupTask the task to run once obj loses reachability.
 */
class CleanupReference(obj: Any?, cleanupTask: Runnable?) : WeakReference<Any?>(obj, sGcQueue) {
    /**
     * This [Handler] polls [.sRefs], looking for cleanup tasks that
     * are ready to run.
     * This is lazily initialized as ThreadUtils.getUiThreadLooper() may not be
     * set yet early in startup.
     */
    @SuppressLint("HandlerLeak")
    private object LazyHolder {
        val sHandler: Handler = object : Handler(ThreadUtils.getUiThreadLooper()) {
            override fun handleMessage(msg: Message) {
                try {
                    TraceEvent.begin("CleanupReference.LazyHolder.handleMessage")
                    var ref = msg.obj as CleanupReference
                    when (msg.what) {
                        ADD_REF -> sRefs.add(ref)
                        REMOVE_REF -> ref.runCleanupTaskInternal()
                        else -> Log.e(TAG, "Bad message=%d", msg.what)
                    }
                    if (DEBUG) Log.d(TAG, "will try and cleanup; max = %d", sRefs.size)
                    synchronized(sCleanupMonitor) {

                        // Always run the cleanup loop here even when adding or removing refs, to
                        // avoid falling behind on rapid garbage allocation inner loops.
                        synchronized(sCleanupMonitor) {

                            // Always run the cleanup loop here even when adding or removing refs, to
                            // avoid falling behind on rapid garbage allocation inner loops.
                            while (sGcQueue.poll()?.also { ref = it as CleanupReference } != null) {
                                ref.runCleanupTaskInternal()
                            }
                            sCleanupMonitor.notifyAll()
                        }
                        sCleanupMonitor.notifyAll()
                    }
                } finally {
                    TraceEvent.end("CleanupReference.LazyHolder.handleMessage")
                }
            }
        }
    }

    private var mCleanupTask: Runnable?

    init {
        if (DEBUG) Log.d(TAG, "+++ CREATED ONE REF")
        mCleanupTask = cleanupTask
        handleOnUiThread(ADD_REF)
    }

    /**
     * Clear the cleanup task [Runnable] so that nothing will be done
     * after garbage collection.
     */
    fun cleanupNow() {
        handleOnUiThread(REMOVE_REF)
    }

    fun hasCleanedUp(): Boolean {
        return mCleanupTask == null
    }

    private fun handleOnUiThread(what: Int) {
        val msg = Message.obtain(LazyHolder.sHandler, what, this)
        if (Looper.myLooper() == msg.target.looper) {
            msg.target.handleMessage(msg)
            msg.recycle()
        } else {
            msg.sendToTarget()
        }
    }

    private fun runCleanupTaskInternal() {
        if (DEBUG) Log.d(TAG, "runCleanupTaskInternal")
        sRefs.remove(this)
        val cleanupTask = mCleanupTask
        mCleanupTask = null
        if (cleanupTask != null) {
            if (DEBUG) Log.i(TAG, "--- CLEANING ONE REF")
            cleanupTask.run()
        }
        clear()
    }

    companion object {
        private const val TAG = "CleanupReference"
        private const val DEBUG = false // Always check in as false!

        // The VM will enqueue CleanupReference instance onto sGcQueue when it becomes eligible for
        // garbage collection (i.e. when all references to the underlying object are nullified).
        // |sReaperThread| processes this queue by forwarding the references on to the UI thread
        // (via REMOVE_REF message) to perform cleanup.
        private val sGcQueue = ReferenceQueue<Any?>()
        private val sCleanupMonitor = Object()
        private val sReaperThread: Thread = object : Thread(TAG) {
            override fun run() {
                while (true) {
                    try {
                        val ref = sGcQueue.remove() as CleanupReference
                        if (DEBUG) Log.d(TAG, "removed one ref from GC queue")
                        synchronized(sCleanupMonitor) {
                            Message.obtain(LazyHolder.sHandler, REMOVE_REF, ref).sendToTarget()
                            // Give the UI thread chance to run cleanup before looping around and
                            // taking the next item from the queue, to avoid Message bombing it.
                            sCleanupMonitor.wait(500)
                        }
                    } catch (e: Exception) {
                        Log.e(TAG, "Queue remove exception:", e)
                    }
                }
            }
        }

        init {
            sReaperThread.isDaemon = true
            sReaperThread.start()
        }

        // Message's sent in the |what| field to |sHandler|.
        // Add a new reference to sRefs. |msg.obj| is the CleanupReference to add.
        private const val ADD_REF = 1

        // Remove reference from sRefs. |msg.obj| is the CleanupReference to remove.
        private const val REMOVE_REF = 2

        /**
         * Keep a strong reference to [CleanupReference] so that it will
         * actually get enqueued.
         * Only accessed on the UI thread.
         */
        private val sRefs: MutableSet<CleanupReference> = HashSet()
    }
}