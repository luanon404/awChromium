// Copyright 2020 The Chromium Authors. All rights reserved.
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.
package org.chromium.android_webview.metrics

import org.chromium.android_webview.proto.MetricsBridgeRecords.HistogramRecord
import org.chromium.android_webview.proto.MetricsBridgeRecords.HistogramRecord.RecordType
import org.chromium.base.Log
import org.chromium.base.metrics.UmaRecorderHolder

/**
 * Replay the recorded method calls recorded by [AwProcessUmaRecorder].
 *
 * Should be used in processes which have initialized Uma, such as the browser process.
 */
object AwNonembeddedUmaReplayer {
    private const val TAG = "AwNonembedUmaReplay"

    /**
     * Extract method arguments from the given [HistogramRecord] and call
     * [org.chromium.base.metrics.UmaRecorder.recordBooleanHistogram].
     */
    private fun replayBooleanHistogram(proto: HistogramRecord) {
        assert(proto.recordType == RecordType.HISTOGRAM_BOOLEAN)
        val sample = proto.sample
        if (sample != 0 && sample != 1) {
            Log.d(TAG, "Expected BooleanHistogram to have sample of 0 or 1, but was $sample")
            return
        }
        UmaRecorderHolder.get().recordBooleanHistogram(
            proto.histogramName, proto.sample != 0
        )
    }

    /**
     * Extract method arguments from the given [HistogramRecord] and call
     * [org.chromium.base.metrics.UmaRecorder.recordExponentialHistogram].
     */
    private fun replayExponentialHistogram(proto: HistogramRecord) {
        assert(proto.recordType == RecordType.HISTOGRAM_EXPONENTIAL)
        UmaRecorderHolder.get().recordExponentialHistogram(
            proto.histogramName,
            proto.sample, proto.min, proto.max, proto.numBuckets
        )
    }

    /**
     * Extract method arguments from the given [HistogramRecord] and call
     * [org.chromium.base.metrics.UmaRecorder.recordLinearHistogram].
     */
    private fun replayLinearHistogram(proto: HistogramRecord) {
        assert(proto.recordType == RecordType.HISTOGRAM_LINEAR)
        UmaRecorderHolder.get().recordLinearHistogram(
            proto.histogramName, proto.sample,
            proto.min, proto.max, proto.numBuckets
        )
    }

    /**
     * Extract method arguments from the given [HistogramRecord] and call
     * [org.chromium.base.metrics.UmaRecorder.recordSparseHistogram].
     */
    private fun replaySparseHistogram(proto: HistogramRecord) {
        assert(proto.recordType == RecordType.HISTOGRAM_SPARSE)
        UmaRecorderHolder.get().recordSparseHistogram(proto.histogramName, proto.sample)
    }

    /**
     * Extract method arguments from the given [HistogramRecord] and call
     * [org.chromium.base.metrics.UmaRecorder.recordUserAction].
     */
    private fun replayUserAction(proto: HistogramRecord) {
        assert(proto.recordType == RecordType.USER_ACTION)
        UmaRecorderHolder.get().recordUserAction(
            proto.histogramName, proto.elapsedRealtimeMillis
        )
    }

    /**
     * Replay UMA API call record by calling that API method.
     *
     * @param methodCall [android.os.Bundle] that contains the UMA API type and arguments.
     */
    @JvmStatic
    fun replayMethodCall(methodCall: HistogramRecord) {
        when (methodCall.recordType) {
            RecordType.HISTOGRAM_BOOLEAN -> replayBooleanHistogram(methodCall)
            RecordType.HISTOGRAM_EXPONENTIAL -> replayExponentialHistogram(methodCall)
            RecordType.HISTOGRAM_LINEAR -> replayLinearHistogram(methodCall)
            RecordType.HISTOGRAM_SPARSE -> replaySparseHistogram(methodCall)
            RecordType.USER_ACTION -> replayUserAction(methodCall)
            else -> Log.d(TAG, "Unrecognized record type")
        }
    }
}