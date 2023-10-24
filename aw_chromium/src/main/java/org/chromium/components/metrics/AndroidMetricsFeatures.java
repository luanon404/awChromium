// Copyright 2023 The Chromium Authors
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.

package org.chromium.components.metrics;

/**
 * Contains features that are specific to android metrics.
 */
public final class AndroidMetricsFeatures {


    // This following string constants were inserted by
    //     java_cpp_features.py
    // From
    //     ../../components/embedder_support/android/metrics/features.cc
    // Into
    //     ../../components/embedder_support/android/metrics/java_templates/AndroidMetricsFeatures.java.tmpl


    public static final String ANDROID_METRICS_ASYNC_METRIC_LOGGING = "AndroidMetricsAsyncMetricLogging";

    // Prevents instantiation.
    private AndroidMetricsFeatures() {
    }
}
