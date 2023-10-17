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
 * No-op implementation of [AwViewMethods] that follows the null object pattern.
 * This [NullAwViewMethods] is hooked up to the WebView in fullscreen mode, and
 * to the [FullScreenView] in embedded mode, but not to both at the same time.
 */
internal class NullAwViewMethods(
    private val mAwContents: AwContents,
    private val mInternalAccessAdapter: AwContents.InternalAccessDelegate,
    private val mContainerView: View
) : AwViewMethods {
    override fun onDraw(canvas: Canvas?) {
        canvas!!.drawColor(mAwContents.effectiveBackgroundColor)
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        // When the containerView is using the NullAwViewMethods then it is not
        // attached to the AwContents. As such, we don't have any contents to measure
        // and using the last measured dimension is the best we can do.
        mInternalAccessAdapter.setMeasuredDimension(
            mContainerView.measuredWidth, mContainerView.measuredHeight
        )
    }

    override fun requestFocus() {
        // Intentional no-op.
    }

    override fun setLayerType(layerType: Int, paint: Paint?) {
        // Intentional no-op.
    }

    override fun onCreateInputConnection(outAttrs: EditorInfo?): InputConnection? {
        return null // Intentional no-op.
    }

    override fun onDragEvent(event: DragEvent?): Boolean {
        return false // Intentional no-op.
    }

    override fun onKeyUp(keyCode: Int, event: KeyEvent?): Boolean {
        return false // Intentional no-op.
    }

    override fun dispatchKeyEvent(event: KeyEvent?): Boolean {
        return false // Intentional no-op.
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        return false // Intentional no-op.
    }

    override fun onHoverEvent(event: MotionEvent?): Boolean {
        return false // Intentional no-op.
    }

    override fun onGenericMotionEvent(event: MotionEvent?): Boolean {
        return false // Intentional no-op.
    }

    override fun onConfigurationChanged(newConfig: Configuration?) {
        // Intentional no-op.
    }

    override fun onAttachedToWindow() {
        // Intentional no-op.
    }

    override fun onDetachedFromWindow() {
        // Intentional no-op.
    }

    override fun onWindowFocusChanged(hasWindowFocus: Boolean) {
        // Intentional no-op.
    }

    override fun onFocusChanged(focused: Boolean, direction: Int, previouslyFocusedRect: Rect?) {
        // Intentional no-op.
    }

    override fun onSizeChanged(w: Int, h: Int, ow: Int, oh: Int) {
        // Intentional no-op.
    }

    override fun onVisibilityChanged(changedView: View?, visibility: Int) {
        // Intentional no-op.
    }

    override fun onWindowVisibilityChanged(visibility: Int) {
        // Intentional no-op.
    }

    override fun onContainerViewScrollChanged(l: Int, t: Int, oldl: Int, oldt: Int) {
        // Intentional no-op.
    }

    override fun onContainerViewOverScrolled(
        scrollX: Int, scrollY: Int, clampedX: Boolean, clampedY: Boolean
    ) {
        // Intentional no-op.
    }

    override fun computeHorizontalScrollRange(): Int {
        return 0
    }

    override fun computeHorizontalScrollOffset(): Int {
        return 0
    }

    override fun computeVerticalScrollRange(): Int {
        return 0
    }

    override fun computeVerticalScrollOffset(): Int {
        return 0
    }

    override fun computeVerticalScrollExtent(): Int {
        return 0
    }

    override fun computeScroll() {
        // Intentional no-op.
    }

    override fun onCheckIsTextEditor(): Boolean {
        return false
    }

    override val accessibilityNodeProvider: AccessibilityNodeProvider?
        get() = null

    override fun performAccessibilityAction(action: Int, arguments: Bundle?): Boolean {
        return false
    }
}