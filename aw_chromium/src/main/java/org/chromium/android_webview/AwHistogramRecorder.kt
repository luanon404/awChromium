// Copyright 2019 The Chromium Authors. All rights reserved.
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.
package org.chromium.android_webview

import androidx.annotation.IntDef
import org.chromium.base.metrics.RecordHistogram

/**
 * Collect information about Android WebView usage. Adding metrics to this class can be helpful if
 * you need to log the same metric from different call sites in different Java classes.
 *
 *
 * If you only need to log at a single call site, prefer calling [RecordHistogram] methods
 * directly.
 */
object AwHistogramRecorder {
    @JvmStatic
    fun recordCallbackInvocation(@WebViewCallbackType result: Int) {
        RecordHistogram.recordEnumeratedHistogram(
            "Android.WebView.Callback.Counts", result, WebViewCallbackType.NUM_ENTRIES
        )
    }

    @Retention(AnnotationRetention.SOURCE)
    @IntDef(
        WebViewCallbackType.ON_RECEIVED_LOGIN_REQUEST,
        WebViewCallbackType.ON_RECEIVED_CLIENT_CERT_REQUEST,
        WebViewCallbackType.ON_RECEIVED_HTTP_AUTH_REQUEST,
        WebViewCallbackType.ON_DOWNLOAD_START,
        WebViewCallbackType.ON_PAGE_STARTED,
        WebViewCallbackType.ON_PAGE_FINISHED,
        WebViewCallbackType.ON_LOAD_RESOURCE,
        WebViewCallbackType.ON_PAGE_COMMIT_VISIBLE,
        WebViewCallbackType.SHOULD_OVERRIDE_URL_LOADING,
        WebViewCallbackType.NUM_ENTRIES
    )
    annotation class WebViewCallbackType {
        companion object {
            // These values are used for UMA. Don't reuse or reorder values.
            // If you add something, update NUM_ENTRIES.
            const val ON_RECEIVED_LOGIN_REQUEST = 0
            const val ON_RECEIVED_CLIENT_CERT_REQUEST = 1
            const val ON_RECEIVED_HTTP_AUTH_REQUEST = 2
            const val ON_DOWNLOAD_START = 3
            const val ON_PAGE_STARTED = 4
            const val ON_PAGE_FINISHED = 5
            const val ON_LOAD_RESOURCE = 6
            const val ON_PAGE_COMMIT_VISIBLE = 7
            const val SHOULD_OVERRIDE_URL_LOADING = 8
            const val NUM_ENTRIES = 9
        }
    }
}