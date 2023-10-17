// Copyright 2019 The Chromium Authors. All rights reserved.
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.
package org.chromium.android_webview

import android.content.Context
import android.os.Build
import android.os.Process
import android.system.ErrnoException
import android.system.Os
import android.system.OsConstants
import org.chromium.base.ContextUtils
import org.chromium.base.Log
import org.chromium.base.PathUtils
import org.chromium.base.StrictModeContext
import org.chromium.base.metrics.ScopedSysTraceEvent
import java.io.File
import java.io.IOException
import java.io.RandomAccessFile
import java.nio.channels.FileLock

/**
 * Handles locking the WebView's data directory, to prevent concurrent use from
 * more than one process.
 */
internal object AwDataDirLock {
    private const val TAG = "AwDataDirLock"
    private const val EXCLUSIVE_LOCK_FILE = "webview_data.lock"

    // This results in a maximum wait time of 1.5s
    private const val LOCK_RETRIES = 16
    private const val LOCK_SLEEP_MS = 100
    private var sLockFile: RandomAccessFile? = null
    private var sExclusiveFileLock: FileLock? = null
    @JvmStatic
    fun lock(appContext: Context) {
        ScopedSysTraceEvent.scoped("AwDataDirLock.lock").use {
            StrictModeContext.allowDiskWrites().use {
                if (sExclusiveFileLock != null) {
                    // We have already called lock() and successfully acquired the lock in this process.
                    // This shouldn't happen, but is likely to be the result of an app catching an
                    // exception thrown during initialization and discarding it, causing us to later
                    // attempt to initialize WebView again. There's no real advantage to failing the
                    // locking code when this happens; we may as well count this as the lock being
                    // acquired and let init continue (though the app may experience other problems
                    // later).
                    return
                }

                // If we already called lock() but didn't succeed in getting the lock, it's possible the
                // app caught the exception and tried again later. As above, there's no real advantage
                // to failing here, so only open the lock file if we didn't already open it before.
                if (sLockFile == null) {
                    val dataPath = PathUtils.getDataDirectory()
                    val lockFile = File(dataPath, EXCLUSIVE_LOCK_FILE)
                    try {
                        // Note that the file is kept open intentionally.
                        sLockFile = RandomAccessFile(lockFile, "rw")
                    } catch (e: IOException) {
                        // Failing to create the lock file is always fatal; even if multiple processes
                        // are using the same data directory we should always be able to access the file
                        // itself.
                        throw RuntimeException("Failed to create lock file $lockFile", e)
                    }
                }

                // Android versions before 11 have edge cases where a new instance of an app process can
                // be started while an existing one is still in the process of being killed. This can
                // still happen on Android 11+ because the platform has a timeout for waiting, but it's
                // much less likely. Retry the lock a few times to give the old process time to fully go
                // away.
                for (attempts in 1..LOCK_RETRIES) {
                    try {
                        sExclusiveFileLock = sLockFile!!.channel.tryLock()
                    } catch (e: IOException) {
                        // Older versions of Android incorrectly throw IOException when the flock()
                        // call fails with EAGAIN, instead of returning null. Just ignore it.
                    }
                    if (sExclusiveFileLock != null) {
                        // We got the lock; write out info for debugging.
                        writeCurrentProcessInfo(sLockFile)
                        return
                    }

                    // If we're not out of retries, sleep and try again.
                    if (attempts == LOCK_RETRIES) break
                    try {
                        Thread.sleep(LOCK_SLEEP_MS.toLong())
                    } catch (_: InterruptedException) {
                    }
                }

                // We failed to get the lock even after retrying.
                // Many existing apps rely on this even though it's known to be unsafe.
                // Make it fatal when on P for apps that target P or higher
                val error = getLockFailureReason(sLockFile)
                val dieOnFailure = (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P
                        && appContext.applicationInfo.targetSdkVersion >= Build.VERSION_CODES.P)
                if (dieOnFailure) {
                    throw RuntimeException(error)
                } else {
                    Log.w(TAG, error)
                }
            }
        }
    }

    private fun writeCurrentProcessInfo(file: RandomAccessFile?) {
        try {
            // Truncate the file first to get rid of old data.
            file!!.setLength(0)
            file.writeInt(Process.myPid())
            file.writeUTF(ContextUtils.getProcessName())
        } catch (e: IOException) {
            // Don't crash just because something failed here, as it's only for debugging.
            Log.w(TAG, "Failed to write info to lock file", e)
        }
    }

    private fun getLockFailureReason(file: RandomAccessFile?): String {
        val error = StringBuilder(
            "Using WebView from more than one process at "
                    + "once with the same data directory is not supported. https://crbug.com/558377 "
                    + ": Current process "
        )
        error.append(ContextUtils.getProcessName())
        error.append(" (pid ").append(Process.myPid()).append("), lock owner ")
        try {
            val pid = file!!.readInt()
            val processName = file.readUTF()
            error.append(processName).append(" (pid ").append(pid).append(")")

            // Check the status of the pid holding the lock by sending it a null signal.
            // This doesn't actually send a signal, just runs the kernel access checks.
            try {
                Os.kill(pid, 0)

                // No exception means the process exists and has the same uid as us, so is
                // probably an instance of the same app. Leave the message alone.
            } catch (e: ErrnoException) {
                when (e.errno) {
                    OsConstants.ESRCH -> {
                        // pid did not exist - the lock should have been released by the kernel,
                        // so this process info is probably wrong.
                        error.append(" doesn't exist!")
                    }
                    OsConstants.EPERM -> {
                        // pid existed but didn't have the same uid as us.
                        // Most likely the pid has just been recycled for a new process
                        error.append(" pid has been reused!")
                    }
                    else -> {
                        // EINVAL is the only other documented return value for kill(2) and should never
                        // happen for signal 0, so just complain generally.
                        error.append(" status unknown!")
                    }
                }
            }
        } catch (e: IOException) {
            // We'll get IOException if we failed to read the pid and process name; e.g. if the
            // lockfile is from an old version of WebView or an IO error occurred somewhere.
            error.append(" unknown")
        }
        return error.toString()
    }
}