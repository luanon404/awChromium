// Copyright 2014 The Chromium Authors. All rights reserved.
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.
package org.chromium.android_webview

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.content.res.Configuration
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.Rect
import android.os.Bundle
import android.view.KeyEvent
import android.view.MotionEvent
import android.view.View
import android.view.accessibility.AccessibilityNodeProvider
import android.view.inputmethod.EditorInfo
import android.view.inputmethod.InputConnection
import android.widget.FrameLayout

/**
 * A view that is used to render the web contents in fullscreen mode, ie.
 * html controls and subtitles, over the [ContentVideoView].
 */
@SuppressLint("ViewConstructor")
class FullScreenView(context: Context?, awViewMethods: AwViewMethods?, awContents: AwContents) :
    FrameLayout(
        context!!
    ) {
    private var mAwViewMethods: AwViewMethods? = null
    private val mAwContents: AwContents
    val internalAccessAdapter: InternalAccessAdapter

    init {
        setAwViewMethods(awViewMethods)
        mAwContents = awContents
        internalAccessAdapter = InternalAccessAdapter()
    }

    fun setAwViewMethods(awViewMethods: AwViewMethods?) {
        mAwViewMethods = awViewMethods
    }

    public override fun onDraw(canvas: Canvas) {
        mAwViewMethods!!.onDraw(canvas)
    }

    public override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        mAwViewMethods!!.onMeasure(widthMeasureSpec, heightMeasureSpec)
    }

    override fun requestFocus(direction: Int, previouslyFocusedRect: Rect): Boolean {
        mAwViewMethods!!.requestFocus()
        return super.requestFocus(direction, previouslyFocusedRect)
    }

    override fun setLayerType(layerType: Int, paint: Paint?) {
        super.setLayerType(layerType, paint)
        mAwViewMethods!!.setLayerType(layerType, paint)
    }

    override fun onCreateInputConnection(outAttrs: EditorInfo): InputConnection {
        return mAwViewMethods!!.onCreateInputConnection(outAttrs)!!
    }

    override fun onKeyUp(keyCode: Int, event: KeyEvent): Boolean {
        return mAwViewMethods!!.onKeyUp(keyCode, event)
    }

    override fun dispatchKeyEvent(event: KeyEvent): Boolean {
        if (event.keyCode == KeyEvent.KEYCODE_BACK && event.action == KeyEvent.ACTION_UP && mAwContents.isFullScreen) {
            mAwContents.requestExitFullscreen()
            return true
        }
        return mAwViewMethods!!.dispatchKeyEvent(event)
    }

    @SuppressLint("ClickableViewAccessibility")
    override fun onTouchEvent(event: MotionEvent): Boolean {
        return mAwViewMethods!!.onTouchEvent(event)
    }

    override fun onHoverEvent(event: MotionEvent): Boolean {
        return mAwViewMethods!!.onHoverEvent(event)
    }

    override fun onGenericMotionEvent(event: MotionEvent): Boolean {
        return mAwViewMethods!!.onGenericMotionEvent(event)
    }

    public override fun onConfigurationChanged(newConfig: Configuration) {
        mAwViewMethods!!.onConfigurationChanged(newConfig)
    }

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
        mAwViewMethods!!.onAttachedToWindow()
    }

    public override fun onDetachedFromWindow() {
        super.onDetachedFromWindow()
        mAwViewMethods!!.onDetachedFromWindow()
    }

    override fun onWindowFocusChanged(hasWindowFocus: Boolean) {
        super.onWindowFocusChanged(hasWindowFocus)
        mAwViewMethods!!.onWindowFocusChanged(hasWindowFocus)
    }

    public override fun onFocusChanged(
        focused: Boolean, direction: Int,
        previouslyFocusedRect: Rect?
    ) {
        super.onFocusChanged(focused, direction, previouslyFocusedRect)
        mAwViewMethods!!.onFocusChanged(
            focused, direction, previouslyFocusedRect
        )
    }

    public override fun onSizeChanged(w: Int, h: Int, ow: Int, oh: Int) {
        super.onSizeChanged(w, h, ow, oh)
        mAwViewMethods!!.onSizeChanged(w, h, ow, oh)
    }

    override fun onVisibilityChanged(changedView: View, visibility: Int) {
        super.onVisibilityChanged(changedView, visibility)
        mAwViewMethods!!.onVisibilityChanged(changedView, visibility)
    }

    public override fun onWindowVisibilityChanged(visibility: Int) {
        super.onWindowVisibilityChanged(visibility)
        mAwViewMethods!!.onWindowVisibilityChanged(visibility)
    }

    public override fun onOverScrolled(
        scrollX: Int,
        scrollY: Int,
        clampedX: Boolean,
        clampedY: Boolean
    ) {
        mAwViewMethods!!.onContainerViewOverScrolled(scrollX, scrollY, clampedX, clampedY)
    }

    public override fun onScrollChanged(l: Int, t: Int, oldl: Int, oldt: Int) {
        super.onScrollChanged(l, t, oldl, oldt)
        mAwViewMethods!!.onContainerViewScrollChanged(l, t, oldl, oldt)
    }

    public override fun computeHorizontalScrollRange(): Int {
        return mAwViewMethods!!.computeHorizontalScrollRange()
    }

    public override fun computeHorizontalScrollOffset(): Int {
        return mAwViewMethods!!.computeHorizontalScrollOffset()
    }

    public override fun computeVerticalScrollRange(): Int {
        return mAwViewMethods!!.computeVerticalScrollRange()
    }

    public override fun computeVerticalScrollOffset(): Int {
        return mAwViewMethods!!.computeVerticalScrollOffset()
    }

    public override fun computeVerticalScrollExtent(): Int {
        return mAwViewMethods!!.computeVerticalScrollExtent()
    }

    override fun computeScroll() {
        mAwViewMethods!!.computeScroll()
    }

    override fun getAccessibilityNodeProvider(): AccessibilityNodeProvider {
        return mAwViewMethods!!.accessibilityNodeProvider!!
    }

    override fun performAccessibilityAction(action: Int, arguments: Bundle?): Boolean {
        return mAwViewMethods!!.performAccessibilityAction(action, arguments)
    }

    // AwContents.InternalAccessDelegate implementation --------------------------------------
    inner class InternalAccessAdapter : AwContents.InternalAccessDelegate {
        override fun super_onKeyUp(keyCode: Int, event: KeyEvent): Boolean {
            return super@FullScreenView.onKeyUp(keyCode, event)
        }

        override fun super_dispatchKeyEvent(event: KeyEvent): Boolean {
            return super@FullScreenView.dispatchKeyEvent(event)
        }

        override fun super_onGenericMotionEvent(event: MotionEvent): Boolean {
            return super@FullScreenView.onGenericMotionEvent(event)
        }

        override fun super_onConfigurationChanged(newConfig: Configuration) {
            // Intentional no-op
        }

        override fun super_getScrollBarStyle(): Int {
            return super@FullScreenView.getScrollBarStyle()
        }

        override fun super_startActivityForResult(intent: Intent, requestCode: Int) {
            throw RuntimeException(
                "FullScreenView InternalAccessAdapter shouldn't call startActivityForResult. "
                        + "See AwContents#startActivityForResult"
            )
        }

        override fun onScrollChanged(lPix: Int, tPix: Int, oldlPix: Int, oldtPix: Int) {
            this@FullScreenView.onScrollChanged(lPix, tPix, oldlPix, oldtPix)
        }

        override fun overScrollBy(
            deltaX: Int, deltaY: Int, scrollX: Int, scrollY: Int,
            scrollRangeX: Int, scrollRangeY: Int, maxOverScrollX: Int,
            maxOverScrollY: Int, isTouchEvent: Boolean
        ) {
            this@FullScreenView.overScrollBy(
                deltaX, deltaY, scrollX, scrollY, scrollRangeX,
                scrollRangeY, maxOverScrollX, maxOverScrollY, isTouchEvent
            )
        }

        override fun super_scrollTo(scrollX: Int, scrollY: Int) {
            super@FullScreenView.scrollTo(scrollX, scrollY)
        }

        override fun setMeasuredDimension(measuredWidth: Int, measuredHeight: Int) {
            this@FullScreenView.setMeasuredDimension(measuredWidth, measuredHeight)
        }
    }
}