// Copyright 2014 The Chromium Authors. All rights reserved.
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.
package org.chromium.ui

import android.os.Handler
import android.os.Looper
import android.view.Choreographer
import android.view.Choreographer.FrameCallback
import org.chromium.base.TraceEvent

/**
 * Notifies clients of the default displays's vertical sync pulses.
 * Constructs a VSyncMonitor
 * @param mListener The listener receiving VSync notifications.
 */
@Suppress("NAME_SHADOWING", "DEPRECATION")
class VSyncMonitor(private val mListener: Listener?, refreshRate: Float) {
    // Conservative guess about vsync's consecutivity.
    // If true, next tick is guaranteed to be consecutive.
    private var mConsecutiveVSync = false

    /**
     * VSync listener class
     */
    interface Listener {
        /**
         * Called very soon after the start of the display's vertical sync period.
         * @param monitor The VSyncMonitor that triggered the signal.
         * @param vsyncTimeMicros Absolute frame time in microseconds.
         */
        fun onVSync(monitor: VSyncMonitor?, vsyncTimeMicros: Long)
    }

    // Display refresh rate as reported by the system.
    private var mRefreshPeriodNano: Long = 0
    private var mUseEstimatedRefreshRate = false
    private var mHaveRequestInFlight = false
    private val mChoreographer: Choreographer
    private val mVSyncFrameCallback: FrameCallback
    private var mGoodStartingPointNano: Long = 0L

    // If the monitor is activated after having been idle, we synthesize the first vsync to reduce
    // latency.
    private val mHandler = Handler()


    init {
        updateRefreshRate(refreshRate)
        mChoreographer = Choreographer.getInstance()
        mVSyncFrameCallback = FrameCallback { frameTimeNanos ->
            TraceEvent.begin("VSync")
            if (mUseEstimatedRefreshRate && mConsecutiveVSync) {
                // Display.getRefreshRate() is unreliable on some platforms.
                // Adjust refresh period- initial value is based on Display.getRefreshRate()
                // after that it asymptotically approaches the real value.
                val lastRefreshDurationNano = frameTimeNanos - mGoodStartingPointNano
                val lastRefreshDurationWeight = 0.1f
                mRefreshPeriodNano += (lastRefreshDurationWeight * (lastRefreshDurationNano - mRefreshPeriodNano)).toLong()
            }
            mGoodStartingPointNano = frameTimeNanos
            onVSyncCallback(frameTimeNanos)
            TraceEvent.end("VSync")
        }
        mGoodStartingPointNano = currentNanoTime
    }

    fun updateRefreshRate(refreshRate: Float) {
        var refreshRate = refreshRate
        mUseEstimatedRefreshRate = refreshRate < 30
        if (refreshRate <= 0) refreshRate = 60f
        mRefreshPeriodNano = (NANOSECONDS_PER_SECOND / refreshRate).toLong()
    }

    val vSyncPeriodInMicroseconds: Long
        /**
         * Returns the time interval between two consecutive vsync pulses in microseconds.
         */
        get() = mRefreshPeriodNano / NANOSECONDS_PER_MICROSECOND

    /**
     * Request to be notified of the closest display vsync events. This should
     * always be called on the same thread used to create the VSyncMonitor.
     * Listener.onVSync() will be called soon after the upcoming vsync pulses.
     */
    fun requestUpdate() {
        assert(mHandler.looper == Looper.myLooper())
        postCallback()
    }

    private val currentNanoTime: Long
        get() = System.nanoTime()

    private fun onVSyncCallback(frameTimeNanos: Long) {
        assert(mHaveRequestInFlight)
        sInsideVSync.set(true)
        mHaveRequestInFlight = false
        try {
            mListener?.onVSync(this, frameTimeNanos / NANOSECONDS_PER_MICROSECOND)
        } finally {
            sInsideVSync.set(false)
        }
    }

    private fun postCallback() {
        if (mHaveRequestInFlight) return
        mHaveRequestInFlight = true
        mConsecutiveVSync = sInsideVSync.get() == true
        mChoreographer.postFrameCallback(mVSyncFrameCallback)
    }

    companion object {
        private const val NANOSECONDS_PER_SECOND: Long = 1000000000
        private const val NANOSECONDS_PER_MICROSECOND: Long = 1000
        private val sInsideVSync: ThreadLocal<Boolean> = object : ThreadLocal<Boolean>() {
            override fun initialValue(): Boolean {
                return java.lang.Boolean.FALSE
            }
        }

        /**
         * @return true if any onVSync handler is executing on the current thread.
         * If onVSync handler introduces invalidations, View#invalidate() should be
         * called. If View#postInvalidateOnAnimation is called instead, the
         * corresponding onDraw will be delayed by one frame. The embedder of
         * VSyncMonitor should check this value if it wants to post an invalidation.
         */
        fun isInsideVSync(): Boolean {
            return sInsideVSync.get() == true
        }
    }
}