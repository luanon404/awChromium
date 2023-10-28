// Copyright 2022 The Chromium Authors
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.

package org.chromium.components.metrics;

/**
 * Contains features that are specific to metrics.
 */
public final class MetricsFeatures {


    // This following string constants were inserted by
    //     java_cpp_features.py
    // From
    //     ../../components/metrics/metrics_features.cc
    // Into
    //     ../../components/metrics/android/java_templates/MetricsFeatures.java.tmpl


    public static final String METRICS_SERVICE_ALLOW_EARLY_LOG_CLOSE = "MetricsServiceAllowEarlyLogClose";


    public static final String STRUCTURED_METRICS = "EnableStructuredMetrics";


    public static final String MERGE_SUBPROCESS_METRICS_ON_BG_AND_FG = "MergeSubprocessMetricsOnBgAndFg";


    public static final String SUBPROCESS_METRICS_ASYNC = "SubprocessMetricsAsync";


    public static final String FLUSH_PERSISTENT_SYSTEM_PROFILE_ON_WRITE = "FlushPersistentSystemProfileOnWrite";


    public static final String METRICS_SERVICE_DELTA_SNAPSHOT_IN_BG = "MetricsServiceDeltaSnapshotInBg";

    // Prevents instantiation.
    private MetricsFeatures() {}
}