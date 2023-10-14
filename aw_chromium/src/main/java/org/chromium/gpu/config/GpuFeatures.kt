// Copyright 2020 The Chromium Authors. All rights reserved.
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.
package org.chromium.gpu.config

/**
 * Constants for the names of GPU Features.
 */
object GpuFeatures {
    // This following string constants were inserted by
    //     java_cpp_features.py
    // From
    //     ../../gpu/config/gpu_finch_features.cc
    // Into
    //     ../../gpu/config/android/java/src/org/chromium/gpu/config/GpuFeatures.java.tmpl
    // Used to limit GL version to 2.0 for skia raster on Android.
    const val USE_GLES2_FOR_OOP_R = "UseGles2ForOopR"

    // Hardware Overlays for WebView.
    const val WEBVIEW_SURFACE_CONTROL = "WebViewSurfaceControl"

    // If webview-draw-functor-uses-vulkan is set, use vulkan for composite and
    // raster.
    const val WEBVIEW_VULKAN = "WebViewVulkan"

    // Used to enable/disable zero copy video path on webview for MCVD.
    const val WEBVIEW_ZERO_COPY_VIDEO = "WebViewZeroCopyVideo"

}