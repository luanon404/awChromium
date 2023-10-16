// Copyright 2018 The Chromium Authors. All rights reserved.
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.
package org.chromium.android_webview.common.variations

import androidx.annotation.VisibleForTesting
import org.chromium.base.BuildInfo
import org.chromium.base.CommandLine
import org.chromium.base.Log
import org.chromium.base.PathUtils
import java.io.Closeable
import java.io.File
import java.io.IOException
import java.util.Date
import java.util.concurrent.TimeUnit

/**
 * Utilities for manipulating variations seeds, used by both WebView and WebView's services.
 */
object VariationsUtils {
    private const val TAG = "VariationsUtils"
    private const val SEED_FILE_NAME = "variations_seed"
    private const val NEW_SEED_FILE_NAME = "variations_seed_new"
    private const val STAMP_FILE_NAME = "variations_stamp"
    fun closeSafely(c: Closeable?) {
        if (c != null) {
            try {
                c.close()
            } catch (e: IOException) {
                Log.e(TAG, "Failed to close $c")
            }
        }
    }

    val seedFile: File
        // Both the WebView variations service and apps using WebView keep a pair of seed files in their
        get() = File(PathUtils.getDataDirectory(), SEED_FILE_NAME)
    val newSeedFile: File
        get() = File(PathUtils.getDataDirectory(), NEW_SEED_FILE_NAME)

    fun replaceOldWithNewSeed() {
        val oldSeedFile = seedFile
        val newSeedFile = newSeedFile
        if (!newSeedFile.renameTo(oldSeedFile)) {
            Log.e(
                TAG, "Failed to replace old seed $oldSeedFile with new seed $newSeedFile"
            )
        }
    }

    val stampFile: File
        // There's a 3rd timestamp file whose modification time is the time of the last seed request. In
        get() = File(PathUtils.getDataDirectory(), STAMP_FILE_NAME)
    val stampTime: Long
        // Get the timestamp, in milliseconds since epoch, or 0 if the file doesn't exist.
        get() = stampFile.lastModified()

    // Creates/updates the timestamp with the current time.
    fun updateStampTime() {
        updateStampTime(Date().time)
    }

    // Creates/updates the timestamp with the specified time.
    @VisibleForTesting
    fun updateStampTime(now: Long) {
        val file = stampFile
        try {
            if (!file.createNewFile()) {
                file.setLastModified(now)
            }
        } catch (e: IOException) {
            Log.e(TAG, "Failed to write $file")
        }
    }

    // Returns the value of the |switchName| flag converted from seconds to milliseconds. If the
    // |switchName| flag isn't present, or contains an invalid value, |defaultValueMillis| will be
    // returned.
    fun getDurationSwitchValueInMillis(switchName: String, defaultValueMillis: Long): Long {
        val cli = CommandLine.getInstance()
        return if (!cli.hasSwitch(switchName)) {
            defaultValueMillis
        } else try {
            TimeUnit.SECONDS.toMillis(cli.getSwitchValue(switchName).toLong())
        } catch (e: NumberFormatException) {
            Log.e(TAG, "Invalid value for flag $switchName", e)
            defaultValueMillis
        }
    }

    // Logs an INFO message if running in a debug build of Android.
    fun debugLog(message: String?) {
        if (BuildInfo.isDebugAndroid()) {
            Log.i(TAG, message)
        }
    }
}