// Copyright 2014 The Chromium Authors. All rights reserved.
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.
package org.chromium.android_webview

import android.content.res.Configuration
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.Rect
import android.os.Bundle
import android.view.DragEvent
import android.view.KeyEvent
import android.view.MotionEvent
import android.view.View
import android.view.accessibility.AccessibilityNodeProvider
import android.view.inputmethod.EditorInfo
import android.view.inputmethod.InputConnection

/**
 * An interface that defines a subset of the [View] functionality.
 *
 *
 * This interface allows us to hook up drawing and input related methods to the
 * [AwContents]'s consumer in embedded mode, and to the [FullScreenView]
 * in fullscreen mode.
 */
interface AwViewMethods {
    /**
     * @see android.view.View.onDraw
     */
    fun onDraw(canvas: Canvas?)

    /**
     * @see android.view.View.onMeasure
     */
    fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int)

    /**
     * @see android.view.View.requestFocus
     */
    fun requestFocus()

    /**
     * @see android.view.View.setLayerType
     */
    fun setLayerType(layerType: Int, paint: Paint?)

    /**
     * @see android.view.View.onCreateInputConnection
     */
    fun onCreateInputConnection(outAttrs: EditorInfo?): InputConnection?

    /**
     * @see android.view.View.onDragEvent
     */
    fun onDragEvent(event: DragEvent?): Boolean

    /**
     * @see android.view.View.onKeyUp
     */
    fun onKeyUp(keyCode: Int, event: KeyEvent?): Boolean

    /**
     * @see android.view.View.dispatchKeyEvent
     */
    fun dispatchKeyEvent(event: KeyEvent?): Boolean

    /**
     * @see android.view.View.onTouchEvent
     */
    fun onTouchEvent(event: MotionEvent?): Boolean

    /**
     * @see android.view.View.onHoverEvent
     */
    fun onHoverEvent(event: MotionEvent?): Boolean

    /**
     * @see android.view.View.onGenericMotionEvent
     */
    fun onGenericMotionEvent(event: MotionEvent?): Boolean

    /**
     * @see android.view.View.onConfigurationChanged
     */
    fun onConfigurationChanged(newConfig: Configuration?)

    /**
     * @see android.view.View.onAttachedToWindow
     */
    fun onAttachedToWindow()

    /**
     * @see android.view.View.onDetachedFromWindow
     */
    fun onDetachedFromWindow()

    /**
     * @see android.view.View.onWindowFocusChanged
     */
    fun onWindowFocusChanged(hasWindowFocus: Boolean)

    /**
     * @see android.view.View.onFocusChanged
     */
    fun onFocusChanged(focused: Boolean, direction: Int, previouslyFocusedRect: Rect?)

    /**
     * @see android.view.View.onSizeChanged
     */
    fun onSizeChanged(w: Int, h: Int, ow: Int, oh: Int)

    /**
     * @see android.view.View.onVisibilityChanged
     */
    fun onVisibilityChanged(changedView: View?, visibility: Int)

    /**
     * @see android.view.View.onWindowVisibilityChanged
     */
    fun onWindowVisibilityChanged(visibility: Int)

    /**
     * @see android.view.View.onScrollChanged
     */
    fun onContainerViewScrollChanged(l: Int, t: Int, oldl: Int, oldt: Int)

    /**
     * @see android.view.View.onOverScrolled
     */
    fun onContainerViewOverScrolled(
        scrollX: Int, scrollY: Int, clampedX: Boolean, clampedY: Boolean
    )

    /**
     * @see android.view.View.computeHorizontalScrollRange
     */
    fun computeHorizontalScrollRange(): Int

    /**
     * @see android.view.View.computeHorizontalScrollOffset
     */
    fun computeHorizontalScrollOffset(): Int

    /**
     * @see android.view.View.computeVerticalScrollRange
     */
    fun computeVerticalScrollRange(): Int

    /**
     * @see android.view.View.computeVerticalScrollOffset
     */
    fun computeVerticalScrollOffset(): Int

    /**
     * @see android.view.View.computeVerticalScrollExtent
     */
    fun computeVerticalScrollExtent(): Int

    /**
     * @see android.view.View.computeScroll
     */
    fun computeScroll()

    /**
     * @see android.view.View.onCheckIsTextEditor
     */
    fun onCheckIsTextEditor(): Boolean

    /**
     * @see android.view.View.getAccessibilityNodeProvider
     */
    val accessibilityNodeProvider: AccessibilityNodeProvider?

    /**
     * @see android.view.View.performAccessibilityAction
     */
    fun performAccessibilityAction(action: Int, arguments: Bundle?): Boolean
}