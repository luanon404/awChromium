// Copyright 2019 The Chromium Authors. All rights reserved.
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.
package org.chromium.base.metrics

/** Common interface for code recording UMA metrics.  */
interface UmaRecorder {
    /** Records a single sample of a boolean histogram.  */
    fun recordBooleanHistogram(name: String?, sample: Boolean)

    /**
     * Records a single sample of a histogram with exponentially scaled buckets. See
     * [ ]
     *
     *
     * This is the default histogram type used by "counts", "times" and "memory" histograms in
     * `base/metrics/histogram_functions.h`
     *
     * @param min the smallest value recorded in the first bucket; should be greater than zero.
     * @param max the smallest value recorded in the overflow bucket.
     * @param numBuckets number of histogram buckets: Two buckets are used for underflow and
     * overflow, and the remaining buckets cover the range `[min, max)`; `numBuckets` should be `100` or less.
     */
    fun recordExponentialHistogram(name: String?, sample: Int, min: Int, max: Int, numBuckets: Int)

    /**
     * Records a single sample of a histogram with evenly spaced buckets. See
     * [ ]
     *
     *
     * This histogram type is best suited for recording enums, percentages and ratios.
     *
     * @param min the smallest value recorded in the first bucket; should be equal to one, but will
     * work with values greater than zero.
     * @param max the smallest value recorded in the overflow bucket.
     * @param numBuckets number of histogram buckets: Two buckets are used for underflow and
     * overflow, and the remaining buckets evenly cover the range `[min, max)`; `numBuckets` should be `100` or less.
     */
    fun recordLinearHistogram(name: String?, sample: Int, min: Int, max: Int, numBuckets: Int)

    /**
     * Records a single sample of a sparse histogram. See
     * [ ]
     */
    fun recordSparseHistogram(name: String?, sample: Int)

    /**
     * Records a user action. Action names must be documented in `actions.xml`. See [ ]
     *
     * @param name Name of the user action.
     * @param elapsedRealtimeMillis Value of [] when
     * the action was observed.
     */
    fun recordUserAction(name: String?, elapsedRealtimeMillis: Long)
}