// Copyright 2023 The Chromium Authors
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.

package org.chromium.services.tracing;

/**
 * Contains features that are specific to Tracing Service.
 */
public final class TracingServiceFeatures {


    // This following string constants were inserted by
    //     java_cpp_features.py
    // From
    //     ../../services/tracing/public/cpp/tracing_features.cc
    // Into
    //     ../../services/tracing/public/java/src/org/chromium/services/network/public/TracingServiceFeatures.java.tmpl

    // Runs the tracing service as an in-process browser service.
    public static final String TRACING_SERVICE_IN_PROCESS = "TracingServiceInProcess";


    public static final String ENABLE_PERFETTO_SYSTEM_TRACING = "EnablePerfettoSystemTracing";

    // Do not instantiate this class.
    private TracingServiceFeatures() {}
}
