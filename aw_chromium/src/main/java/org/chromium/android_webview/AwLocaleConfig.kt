// Copyright 2019 The Chromium Authors. All rights reserved.
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.
package org.chromium.android_webview

/**
 * Simple class that provides access to the array of uncompressed pak locales. See
 * //android_webview/BUILD.gn for more details.
 */
object AwLocaleConfig {
    val webViewSupportedPakLocales: Array<String>
        get() = ProductConfig.LOCALES
}