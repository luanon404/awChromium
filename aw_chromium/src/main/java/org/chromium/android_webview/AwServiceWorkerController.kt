// Copyright 2016 The Chromium Authors. All rights reserved.
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.
package org.chromium.android_webview

import android.content.Context

/**
 * Manages clients and settings for Service Workers.
 */
class AwServiceWorkerController(applicationContext: Context?, browserContext: AwBrowserContext) {

    /**
     * Returns the current settings for Service Worker.
     */
    private val awServiceWorkerSettings: AwServiceWorkerSettings
    private val mBrowserContext: AwBrowserContext

    init {
        awServiceWorkerSettings = AwServiceWorkerSettings(applicationContext)
        mBrowserContext = browserContext
    }

}