// Copyright 2020 The Chromium Authors. All rights reserved.
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.
package org.chromium.blink_public.common

/**
 * Constants for the names of Blink Features.
 */
object BlinkFeatures {

    // Enable TableNG
    const val LAYOUT_NG_TABLE = "LayoutNGTable"

    // Enables small accelerated canvases for webview (crbug.com/1004304)
    const val WEBVIEW_ACCELERATE_SMALL_CANVASES = "WebviewAccelerateSmallCanvases"

    // The AppCache feature is a kill-switch for the entire AppCache feature,
    // both backend and API.  If disabled, then it will turn off the backend and
    // api, regardless of the presence of valid origin trial tokens.  Disabling
    // AppCache will also delete any AppCache data from the profile directory.
    const val APP_CACHE = "AppCache"

}