// Copyright 2020 The Chromium Authors. All rights reserved.
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.
package org.chromium.gpu.config

/**
 * Contains all of the command line switches that are specific to the gpu/ layer.
 */
object GpuSwitches {
    // This following string constants were inserted by
    //     java_cpp_strings.py
    // From
    //     ../../gpu/config/gpu_switches.cc
    // Into
    //     ../../gpu/config/android/java/src/org/chromium/gpu/config/GpuSwitches.java.tmpl
    // Disable GPU rasterization, i.e. rasterize on the CPU only.
    // Overrides the kEnableGpuRasterization flag.
    const val DISABLE_GPU_RASTERIZATION = "disable-gpu-rasterization"

    // Ignores GPU blocklist.
    const val IGNORE_GPU_BLOCKLIST = "ignore-gpu-blocklist"

}