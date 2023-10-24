// Copyright 2022 The Chromium Authors
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.

package org.chromium.blink_scheduler;

/**
 * Constants for the names of Blink Scheduler Features.
 */
public final class BlinkSchedulerFeatures {


    // This following string constants were inserted by
    //     java_cpp_features.py
    // From
    //     ../../third_party/blink/renderer/platform/scheduler/common/features.cc
    // Into
    //     ../../third_party/blink/renderer/platform/scheduler/common/android/java_templates/BlinkSchedulerFeatures.java.tmpl


    public static final String THREADED_SCROLL_PREVENT_RENDERING_STARVATION = "ThreadedScrollPreventRenderingStarvation";


    public static final String PRIORITIZE_COMPOSITING_AFTER_DELAY_TRIALS = "PrioritizeCompositingAfterDelayTrials";

    // Do not instantiate this class.
    private BlinkSchedulerFeatures() {
    }
}
