// Copyright 2020 The Chromium Authors. All rights reserved.
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.
package org.chromium.android_webview.common.variations

import android.os.Bundle

/**
 * Stores values related to the collection of variations service metrics.
 *
 * The values maintained by this class can be initialized from and serialized to a dedicated
 * variations SharedPreferences, or from a Bundle suitable for sending in AIDL IPC calls.
 */
class VariationsServiceMetricsHelper private constructor(private val mBundle: Bundle) {

    fun hasJobInterval(): Boolean {
        return mBundle.containsKey(JOB_INTERVAL)
    }

    var jobInterval: Long
        get() = mBundle.getLong(JOB_INTERVAL)
        set(seedFetchTime) {
            mBundle.putLong(JOB_INTERVAL, seedFetchTime)
        }

    fun hasJobQueueTime(): Boolean {
        return mBundle.containsKey(JOB_QUEUE_TIME)
    }

    var jobQueueTime: Long
        get() = mBundle.getLong(JOB_QUEUE_TIME)
        set(seedFetchTime) {
            mBundle.putLong(JOB_QUEUE_TIME, seedFetchTime)
        }

    companion object {

        // The time in milliseconds between the start of the two most recent seed downloads.
        private const val JOB_INTERVAL = "job_interval"

        // The time in milliseconds between scheduling and executing the last seed download job.
        private const val JOB_QUEUE_TIME = "job_queue_time"

        /**
         * Creates a new VariationsServiceMetricsHelper instance initialized with the contents of the
         * given Bundle.
         */
        fun fromBundle(bundle: Bundle): VariationsServiceMetricsHelper {
            return VariationsServiceMetricsHelper(bundle)
        }

    }
}