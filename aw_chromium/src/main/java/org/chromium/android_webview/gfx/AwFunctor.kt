// Copyright 2018 The Chromium Authors. All rights reserved.
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.
package org.chromium.android_webview.gfx

import android.graphics.Canvas

/**
 * Interface for functor implementation. This allows client to avoid differentiating between GL and
 * Vulkan implementations.
 */
interface AwFunctor {
    /** Insert draw functor into recording canvas  */
    fun requestDraw(canvas: Canvas?): Boolean

    /** Return the raw native pointer to CompositorFrameConsumer  */
    val nativeCompositorFrameConsumer: Long

    /** Free memory  */
    fun trimMemory()

    /** Destroy on UI thread. Client should stop using CompositorFrameConsumer before this  */
    fun destroy()
}