// Copyright 2012 The Chromium Authors. All rights reserved.
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.
package com.luanon.webview

import android.content.Context
import org.chromium.android_webview.R
import org.chromium.android_webview.common.AwResource

/**
 * Registers resources for the Android webview shell.
 */
object AwShellResourceProvider {
    private var sInitialized = false

    @JvmStatic
    fun registerResources(context: Context) {
        if (sInitialized) {
            return
        }
        AwResource.setResources(context.resources)
        AwResource.setConfigKeySystemUuidMapping(R.array.config_key_system_uuid_mapping)
        sInitialized = true
    }

}