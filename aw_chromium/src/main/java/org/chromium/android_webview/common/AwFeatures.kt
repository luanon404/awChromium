// Copyright 2019 The Chromium Authors. All rights reserved.
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.
package org.chromium.android_webview.common

/**
 * Constants for the names of WebView Features.
 */
object AwFeatures {
    // This following string constants were inserted by
    //     java_cpp_features.py
    // From
    //     ../../android_webview/common/aw_features.cc
    // Into
    //     ../../android_webview/java/src/org/chromium/android_webview/common/AwFeatures.java.tmpl
    // Enable brotli compression support in WebView.
    const val WEBVIEW_BROTLI_SUPPORT = "WebViewBrotliSupport"

    // Use the SafeBrowsingApiHandler which uses the connectionless GMS APIs. This
    // Feature is checked and used in downstream internal code.
    const val WEBVIEW_CONNECTIONLESS_SAFE_BROWSING = "WebViewConnectionlessSafeBrowsing"

    // Restricts WebView child processes to use only LITTLE cores on big.LITTLE
    // architectures.
    const val WEBVIEW_CPU_AFFINITY_RESTRICT_TO_LITTLE_CORES =
        "WebViewCpuAffinityRestrictToLittleCores"

    // Enable display cutout support for Android P and above.
    const val WEBVIEW_DISPLAY_CUTOUT = "WebViewDisplayCutout"

    // When enabled, passive mixed content (Audio/Video/Image subresources loaded
    // over HTTP on HTTPS sites) will be autoupgraded to HTTPS, and the load will be
    // blocked if the resource fails to load over HTTPS. This only affects apps that
    // set the mixed content mode to MIXED_CONTENT_COMPATIBILITY_MODE, autoupgrades
    // are always disabled for MIXED_CONTENT_NEVER_ALLOW and
    // MIXED_CONTENT_ALWAYS_ALLOW modes.
    const val WEBVIEW_MIXED_CONTENT_AUTOUPGRADES = "WebViewMixedContentAutoupgrades"

    // Only allow extra headers added via loadUrl() to be sent to the original
    // origin; strip them from the request if a cross-origin redirect occurs.
    const val WEBVIEW_EXTRA_HEADERS_SAME_ORIGIN_ONLY = "WebViewExtraHeadersSameOriginOnly"

    // Enable the new Java/JS Bridge code path with mojo implementation.
    const val WEBVIEW_JAVA_JS_BRIDGE_MOJO = "WebViewJavaJsBridgeMojo"

    // Measure the number of pixels occupied by one or more WebViews as a
    // proportion of the total screen size. Depending on the number of
    // WebVieaws and the size of the screen this might be expensive so
    // hidden behind a feature flag until the true runtime cost can be
    // measured.
    const val WEBVIEW_MEASURE_SCREEN_COVERAGE = "WebViewMeasureScreenCoverage"

    // Field trial feature for controlling support of Origin Trials on WebView.
    const val WEBVIEW_ORIGIN_TRIALS = "WebViewOriginTrials"

    // Restricts all of WebView's out-of-process renderer threads to use only LITTLE
    // cores on big.LITTLE architectures when the power mode is idle.
    const val WEBVIEW_POWER_SCHEDULER_THROTTLE_IDLE = "WebViewPowerSchedulerThrottleIdle"

}