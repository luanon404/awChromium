// Copyright 2020 The Chromium Authors. All rights reserved.
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.
package org.chromium.android_webview.common

/**
 * Contains command line switches that are specific to Android WebView.
 */
object AwSwitches {
    // This following string constants were inserted by
    //     java_cpp_strings.py
    // From
    //     ../../android_webview/common/aw_switches.cc
    // Into
    //     ../../android_webview/java/src/org/chromium/android_webview/common/AwSwitches.java.tmpl
    const val WEBVIEW_LOG_JS_CONSOLE_MESSAGES = "webview-log-js-console-messages"
    const val WEBVIEW_SANDBOXED_RENDERER = "webview-sandboxed-renderer"

    // used to disable safebrowsing functionality in webview
    const val WEBVIEW_DISABLE_SAFEBROWSING_SUPPORT = "webview-disable-safebrowsing-support"

    // Highlight the contents (including web contents) of all WebViews with a yellow
    // tint. This is useful for identifying WebViews in an Android application.
    const val HIGHLIGHT_ALL_WEBVIEWS = "highlight-all-webviews"

    // WebView will log additional debugging information to logcat, such as
    // variations and commandline state.
    const val WEBVIEW_VERBOSE_LOGGING = "webview-verbose-logging"

    // The length of time in seconds that an app's copy of the variations seed
    // should be considered fresh. If an app's seed is older than this, a new seed
    // will be requested from WebView's IVariationsSeedServer.
    const val FINCH_SEED_EXPIRATION_AGE = "finch-seed-expiration-age"

    // Forces WebView's service to always schedule a new variations seed download
    // job, even if one is already pending.
    const val FINCH_SEED_IGNORE_PENDING_DOWNLOAD = "finch-seed-ignore-pending-download"

    // The minimum amount of time in seconds that WebView's service will wait
    // between two variations seed downloads from the variations server.
    const val FINCH_SEED_MIN_DOWNLOAD_PERIOD = "finch-seed-min-download-period"

    // The minimum amount of time in seconds that the embedded WebView
    // implementation will wait between two requests to WebView's service for a new
    // variations seed.
    const val FINCH_SEED_MIN_UPDATE_PERIOD = "finch-seed-min-update-period"

    // Enables modern SameSite cookie behavior (as opposed to legacy behavior). This
    // is used for WebView versions prior to when the modern behavior will be
    // enabled by default. This enables the same-site-by-default-cookies,
    // cookies-without-SameSite-must-be-secure, and schemeful-same-site features.
    const val WEBVIEW_ENABLE_MODERN_COOKIE_SAME_SITE = "webview-enable-modern-cookie-same-site"
}