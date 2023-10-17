// Copyright 2017 The Chromium Authors. All rights reserved.
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.
package org.chromium.android_webview.safe_browsing

/**
 * Container to hold the application's response to WebViewClient#onSafeBrowsingHit().
 */
class AwSafeBrowsingResponse(private val mAction: Int, private val mReporting: Boolean) {
    fun action(): Int {
        return mAction
    }

    fun reporting(): Boolean {
        return mReporting
    }
}