// Copyright 2016 The Chromium Authors. All rights reserved.
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.
package org.chromium.android_webview

import android.view.View
import android.view.ViewGroup
import android.widget.AbsoluteLayout
import android.widget.FrameLayout
import androidx.annotation.VisibleForTesting
import org.chromium.ui.base.ViewAndroidDelegate
import kotlin.math.roundToInt

/**
 * Implementation of the abstract class [ViewAndroidDelegate] for WebView.
 */
class AwViewAndroidDelegate @VisibleForTesting constructor(
    containerView: ViewGroup?, private val mContentsClient: AwContentsClient,
    private val mScrollManager: AwScrollOffsetManager
) : ViewAndroidDelegate(containerView) {
    /**
     * List of anchor views stored in the order in which they were acquired mapped
     * to their position.
     */
    private val mAnchorViews: MutableMap<View, Position?> = LinkedHashMap()

    /**
     * Represents the position of an anchor view.
     */
    @VisibleForTesting
    private class Position(
        val mX: Float, val mY: Float, val mWidth: Float, val mHeight: Float, val mLeftMargin: Int,
        val mTopMargin: Int
    )

    override fun acquireView(): View? {
        val containerView = containerViewGroup ?: return null
        val anchorView = View(containerView.context)
        containerView.addView(anchorView)
        // |mAnchorViews| will be updated with the right view position in |setViewPosition|.
        mAnchorViews[anchorView] = null
        return anchorView
    }

    override fun removeView(anchorView: View) {
        mAnchorViews.remove(anchorView)
        val containerView = containerViewGroup
        containerView?.removeView(anchorView)
    }

    override fun updateAnchorViews(oldContainerView: ViewGroup) {
        // Transfer existing anchor views from the old to the new container view.
        for ((anchorView, position) in mAnchorViews) {
            oldContainerView.removeView(anchorView)
            mContainerView.addView(anchorView)
            if (position != null) {
                setViewPosition(
                    anchorView, position.mX, position.mY, position.mWidth,
                    position.mHeight, position.mLeftMargin, position.mTopMargin
                )
            }
        }
    }

    override fun setViewPosition(
        anchorView: View, x: Float, y: Float, width: Float, height: Float,
        leftMargin: Int, topMargin: Int
    ) {
        val containerView = containerViewGroup
        if (!mAnchorViews.containsKey(anchorView) || containerView == null) return
        mAnchorViews[anchorView] = Position(
            x,
            y,
            width,
            height,
            leftMargin,
            topMargin
        )
        if (containerView is FrameLayout) {
            super.setViewPosition(anchorView, x, y, width, height, leftMargin, topMargin)
            return
        }
        // This fixes the offset due to a difference in scrolling model of WebView vs. Chrome.
        @Suppress("DEPRECATION")
        val lp = AbsoluteLayout.LayoutParams(
            width.roundToInt(),
            height.roundToInt(),
            leftMargin + mScrollManager.scrollX,
            topMargin + mScrollManager.scrollY
        )
        anchorView.layoutParams = lp
    }

    override fun onBackgroundColorChanged(color: Int) {
        mContentsClient.onBackgroundColorChanged(color)
    }

}