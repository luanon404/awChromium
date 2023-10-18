// Copyright 2014 The Chromium Authors. All rights reserved.
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.
package org.chromium.base

import androidx.annotation.IntDef
import org.chromium.base.ActivityState

/**
 * A set of states that represent the last state change of an Activity.
 */
@Retention(AnnotationRetention.SOURCE)
@IntDef(
    ActivityState.CREATED,
    ActivityState.STARTED,
    ActivityState.RESUMED,
    ActivityState.PAUSED,
    ActivityState.STOPPED,
    ActivityState.DESTROYED
)
annotation class ActivityState {
    companion object {
        /**
         * Represents Activity#onCreate().
         */
        const val CREATED = 1

        /**
         * Represents Activity#onStart().
         */
        const val STARTED = 2

        /**
         * Represents Activity#onResume().
         */
        const val RESUMED = 3

        /**
         * Represents Activity#onPause().
         */
        const val PAUSED = 4

        /**
         * Represents Activity#onStop().
         */
        const val STOPPED = 5

        /**
         * Represents Activity#onDestroy().  This is also used when the state of an Activity is unknown.
         */
        const val DESTROYED = 6
    }
}