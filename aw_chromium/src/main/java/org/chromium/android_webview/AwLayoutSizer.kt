// Copyright 2012 The Chromium Authors. All rights reserved.
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.
package org.chromium.android_webview

import android.view.View
import android.view.View.MeasureSpec

/**
 * Helper methods used to manage the layout of the View that contains AwContents.
 */
class AwLayoutSizer
/**
 * Default constructor. Note: both setDelegate and setDIPScale must be called before the class
 * is ready for use.
 */
{
    // These are used to prevent a re-layout if the content size changes within a dimension that is
    // fixed by the view system.
    private var mWidthMeasurementIsFixed = false
    private var mHeightMeasurementIsFixed = false

    // Size of the rendered content, as reported by native.
    private var mContentHeightCss = 0
    private var mContentWidthCss = 0

    // Page scale factor.
    private var mPageScaleFactor = 1.0f

    // Whether to postpone layout requests.
    private var mFreezeLayoutRequests = false

    // Did we try to request a layout since the last time mPostponeLayoutRequests was set to true.
    private var mFrozenLayoutRequestPending = false
    private var mDIPScale = 0.0

    // Was our height larger than the AT_MOST constraint the last time onMeasure was called?
    private var mHeightMeasurementLimited = false

    // If mHeightMeasurementLimited is true then this contains the height limit.
    private var mHeightMeasurementLimit = 0

    // Callback object for interacting with the View.
    private var mDelegate: Delegate? = null

    /**
     * Delegate interface through which the AwLayoutSizer communicates with the view it's sizing.
     */
    interface Delegate {
        fun requestLayout()
        fun setMeasuredDimension(measuredWidth: Int, measuredHeight: Int)
        val isLayoutParamsHeightWrapContent: Boolean
        fun setForceZeroLayoutHeight(forceZeroHeight: Boolean)
    }

    fun setDelegate(delegate: Delegate?) {
        mDelegate = delegate
    }

    fun setDIPScale(dipScale: Double) {
        mDIPScale = dipScale
    }

    /**
     * Postpone requesting layouts till unfreezeLayoutRequests is called.
     */
    fun freezeLayoutRequests() {
        mFreezeLayoutRequests = true
        mFrozenLayoutRequestPending = false
    }

    /**
     * Stop postponing layout requests and request layout if such a request would have been made
     * had the freezeLayoutRequests method not been called before.
     */
    fun unfreezeLayoutRequests() {
        mFreezeLayoutRequests = false
        if (mFrozenLayoutRequestPending) {
            mFrozenLayoutRequestPending = false
            mDelegate!!.requestLayout()
        }
    }

    /**
     * Update the contents size.
     * This should be called whenever the content size changes (due to DOM manipulation or page
     * load, for example).
     */
    fun onContentSizeChanged(widthCss: Int, heightCss: Int) {
        doUpdate(widthCss, heightCss, mPageScaleFactor)
    }

    /**
     * Update the contents page scale.
     * This should be called whenever the content page scale factor changes (due to pinch zoom, for
     * example).
     */
    fun onPageScaleChanged(pageScaleFactor: Float) {
        doUpdate(mContentWidthCss, mContentHeightCss, pageScaleFactor)
    }

    private fun doUpdate(widthCss: Int, heightCss: Int, pageScaleFactor: Float) {
        // We want to request layout only if the size or scale change, however if any of the
        // measurements are 'fixed', then changing the underlying size won't have any effect, so we
        // ignore changes to dimensions that are 'fixed'.
        val heightPix = (heightCss * mPageScaleFactor * mDIPScale).toInt()
        val pageScaleChanged = mPageScaleFactor != pageScaleFactor
        val contentHeightChangeMeaningful = (!mHeightMeasurementIsFixed
                && (!mHeightMeasurementLimited || heightPix < mHeightMeasurementLimit))
        val pageScaleChangeMeaningful = !mWidthMeasurementIsFixed || contentHeightChangeMeaningful
        val layoutNeeded =
            mContentWidthCss != widthCss && !mWidthMeasurementIsFixed || mContentHeightCss != heightCss && contentHeightChangeMeaningful || pageScaleChanged && pageScaleChangeMeaningful
        mContentWidthCss = widthCss
        mContentHeightCss = heightCss
        mPageScaleFactor = pageScaleFactor
        if (layoutNeeded) {
            if (mFreezeLayoutRequests) {
                mFrozenLayoutRequestPending = true
            } else {
                mDelegate!!.requestLayout()
            }
        }
    }

    /**
     * Calculate the size of the view.
     * This is designed to be used to implement the android.view.View#onMeasure() method.
     */
    fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        val heightMode = MeasureSpec.getMode(heightMeasureSpec)
        val heightSize = MeasureSpec.getSize(heightMeasureSpec)
        val widthMode = MeasureSpec.getMode(widthMeasureSpec)
        val widthSize = MeasureSpec.getSize(widthMeasureSpec)
        val contentHeightPix = (mContentHeightCss * mPageScaleFactor * mDIPScale).toInt()
        val contentWidthPix = (mContentWidthCss * mPageScaleFactor * mDIPScale).toInt()
        var measuredHeight = contentHeightPix
        var measuredWidth = contentWidthPix

        // Always use the given size unless unspecified. This matches WebViewClassic behavior.
        mWidthMeasurementIsFixed = widthMode != MeasureSpec.UNSPECIFIED
        mHeightMeasurementIsFixed = heightMode == MeasureSpec.EXACTLY
        mHeightMeasurementLimited =
            heightMode == MeasureSpec.AT_MOST && contentHeightPix > heightSize
        mHeightMeasurementLimit = heightSize
        if (mHeightMeasurementIsFixed || mHeightMeasurementLimited) {
            measuredHeight = heightSize
        }
        if (mWidthMeasurementIsFixed) {
            measuredWidth = widthSize
        }
        if (measuredHeight < contentHeightPix) {
            measuredHeight = measuredHeight or View.MEASURED_STATE_TOO_SMALL
        }
        if (measuredWidth < contentWidthPix) {
            measuredWidth = measuredWidth or View.MEASURED_STATE_TOO_SMALL
        }
        mDelegate!!.setMeasuredDimension(measuredWidth, measuredHeight)
    }

    /**
     * Notify the AwLayoutSizer that the size of the view has changed.
     * This should be called by the Android view system after onMeasure if the view's size has
     * changed.
     */
    fun onSizeChanged() {
        updateLayoutSettings()
    }

    /**
     * Notify the AwLayoutSizer that the layout pass requested via Delegate.requestLayout has
     * completed.
     * This should be called after onSizeChanged regardless of whether the size has changed or not.
     */
    fun onLayoutParamsChange() {
        updateLayoutSettings()
    }

    // This needs to be called every time either the physical size of the view is changed or layout
    // params are updated.
    private fun updateLayoutSettings() {
        mDelegate!!.setForceZeroLayoutHeight(mDelegate!!.isLayoutParamsHeightWrapContent)
    }
}