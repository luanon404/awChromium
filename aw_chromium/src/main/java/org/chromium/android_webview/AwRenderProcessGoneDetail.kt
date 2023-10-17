// Copyright 2017 The Chromium Authors. All rights reserved.
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.
package org.chromium.android_webview

import org.chromium.android_webview.renderer_priority.RendererPriority

/**
 * This class provides more specific information about why the render process
 * exited. It is peer of android.webkit.RenderProcessGoneDetail.
 */
class AwRenderProcessGoneDetail(
    private val mDidCrash: Boolean,
    @field:RendererPriority @param:RendererPriority private val mRendererPriority: Int
) {
    fun didCrash(): Boolean {
        return mDidCrash
    }

    @RendererPriority
    fun rendererPriority(): Int {
        return mRendererPriority
    }
}