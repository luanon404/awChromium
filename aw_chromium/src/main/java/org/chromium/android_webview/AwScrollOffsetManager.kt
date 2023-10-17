// Copyright 2013 The Chromium Authors. All rights reserved.
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.
package org.chromium.android_webview

import android.graphics.Rect
import kotlin.math.abs
import kotlin.math.max
import kotlin.math.min

/**
 * Takes care of syncing the scroll offset between the Android View system and the
 * InProcessViewRenderer.
 *
 * Unless otherwise values (sizes, scroll offsets) are in physical pixels.
 */
class AwScrollOffsetManager(private val mDelegate: Delegate) {
    /**
     * The interface that all users of AwScrollOffsetManager should implement.
     *
     * The unit of all the values in this delegate are physical pixels.
     */
    interface Delegate {
        // Call View#overScrollBy on the containerView.
        fun overScrollContainerViewBy(
            deltaX: Int, deltaY: Int, scrollX: Int, scrollY: Int,
            scrollRangeX: Int, scrollRangeY: Int, isTouchEvent: Boolean
        )

        // Call View#scrollTo on the containerView.
        fun scrollContainerViewTo(x: Int, y: Int)

        // Store the scroll offset in the native side. This should really be a simple store
        // operation, the native side shouldn't synchronously alter the scroll offset from within
        // this call.
        fun scrollNativeTo(x: Int, y: Int)

        /**
         * Smooth scrolls the view to targetX, targetY, within durationMs.
         * @param targetX x-coordinate of target scroll position.
         * @param targetY y-coordinate of target scroll position.
         * @param durationMs the animation duration in milliseconds.
         */
        fun smoothScroll(targetX: Int, targetY: Int, durationMs: Long)
        val containerViewScrollX: Int
        val containerViewScrollY: Int
        fun invalidate()
        fun cancelFling()
    }

    // Scroll offset as seen by the native side.
    var scrollX = 0
        private set
    var scrollY = 0
        private set

    // How many pixels can we scroll in a given direction.
    private var mMaxHorizontalScrollOffset = 0
    private var mMaxVerticalScrollOffset = 0

    // Size of the container view.
    private var mContainerViewWidth = 0
    private var mContainerViewHeight = 0

    // Whether we're in the middle of processing a touch event.
    private var mProcessingTouchEvent = false

    // Whether (and to what value) to update the native side scroll offset after we've finished
    // processing a touch event.
    private var mApplyDeferredNativeScroll = false
    private var mDeferredNativeScrollX = 0
    private var mDeferredNativeScrollY = 0

    //----- Scroll range and extent calculation methods -------------------------------------------
    fun computeHorizontalScrollRange(): Int {
        return mContainerViewWidth + mMaxHorizontalScrollOffset
    }

    fun computeMaximumHorizontalScrollOffset(): Int {
        return mMaxHorizontalScrollOffset
    }

    fun computeHorizontalScrollOffset(): Int {
        return mDelegate.containerViewScrollX
    }

    fun computeVerticalScrollRange(): Int {
        return mContainerViewHeight + mMaxVerticalScrollOffset
    }

    fun computeMaximumVerticalScrollOffset(): Int {
        return mMaxVerticalScrollOffset
    }

    fun computeVerticalScrollOffset(): Int {
        return mDelegate.containerViewScrollY
    }

    fun computeVerticalScrollExtent(): Int {
        return mContainerViewHeight
    }
    //---------------------------------------------------------------------------------------------
    /**
     * Called when the scroll range changes. This needs to be the size of the on-screen content.
     */
    fun setMaxScrollOffset(width: Int, height: Int) {
        mMaxHorizontalScrollOffset = width
        mMaxVerticalScrollOffset = height
    }

    /**
     * Called when the physical size of the view changes.
     */
    fun setContainerViewSize(width: Int, height: Int) {
        mContainerViewWidth = width
        mContainerViewHeight = height
    }

    fun syncScrollOffsetFromOnDraw() {
        // Unfortunately apps override onScrollChanged without calling super which is why we need
        // to sync the scroll offset on every onDraw.
        onContainerViewScrollChanged(
            mDelegate.containerViewScrollX,
            mDelegate.containerViewScrollY
        )
    }

    fun setProcessingTouchEvent(processingTouchEvent: Boolean) {
        assert(mProcessingTouchEvent != processingTouchEvent)
        mProcessingTouchEvent = processingTouchEvent
        if (!mProcessingTouchEvent && mApplyDeferredNativeScroll) {
            mApplyDeferredNativeScroll = false
            scrollNativeTo(mDeferredNativeScrollX, mDeferredNativeScrollY)
        }
    }

    // Called by the native side to scroll the container view.
    fun scrollContainerViewTo(x: Int, y: Int) {
        scrollX = x
        scrollY = y
        val scrollX = mDelegate.containerViewScrollX
        val scrollY = mDelegate.containerViewScrollY
        val deltaX = x - scrollX
        val deltaY = y - scrollY
        val scrollRangeX = computeMaximumHorizontalScrollOffset()
        val scrollRangeY = computeMaximumVerticalScrollOffset()

        // We use overScrollContainerViewBy to be compatible with WebViewClassic which used this
        // method for handling both over-scroll as well as in-bounds scroll.
        mDelegate.overScrollContainerViewBy(
            deltaX, deltaY, scrollX, scrollY,
            scrollRangeX, scrollRangeY, mProcessingTouchEvent
        )
    }

    // Called by the native side to over-scroll the container view.
    fun overScrollBy(deltaX: Int, deltaY: Int) {
        // TODO(mkosiba): Once http://crbug.com/260663 and http://crbug.com/261239 are fixed it
        // should be possible to uncomment the following asserts:
        // if (deltaX < 0) assert mDelegate.getContainerViewScrollX() == 0;
        // if (deltaX > 0) assert mDelegate.getContainerViewScrollX() ==
        //          computeMaximumHorizontalScrollOffset();
        scrollBy(deltaX, deltaY)
    }

    private fun scrollBy(deltaX: Int, deltaY: Int) {
        if (deltaX == 0 && deltaY == 0) return
        val scrollX = mDelegate.containerViewScrollX
        val scrollY = mDelegate.containerViewScrollY
        val scrollRangeX = computeMaximumHorizontalScrollOffset()
        val scrollRangeY = computeMaximumVerticalScrollOffset()

        // The android.view.View.overScrollBy method is used for both scrolling and over-scrolling
        // which is why we use it here.
        mDelegate.overScrollContainerViewBy(
            deltaX, deltaY, scrollX, scrollY,
            scrollRangeX, scrollRangeY, mProcessingTouchEvent
        )
    }

    private fun clampHorizontalScroll(scrollX: Int): Int {
        return min(computeMaximumHorizontalScrollOffset(), max(0, scrollX))
    }

    private fun clampVerticalScroll(scrollY: Int): Int {
        return min(computeMaximumVerticalScrollOffset(), max(0, scrollY))
    }

    // Called by the View system as a response to the mDelegate.overScrollContainerViewBy call.
    fun onContainerViewOverScrolled(
        scrollX: Int, scrollY: Int
    ) {
        // Clamp the scroll offset at (0, max).
        mDelegate.scrollContainerViewTo(clampHorizontalScroll(scrollX), clampVerticalScroll(scrollY))

        // This is only necessary if the containerView scroll offset ends up being different
        // than the one set from native in which case we want the value stored on the native side
        // to reflect the value stored in the containerView (and not the other way around).
        scrollNativeTo(mDelegate.containerViewScrollX, mDelegate.containerViewScrollY)
    }

    // Called by the View system when the scroll offset had changed. This might not get called if
    // the embedder overrides WebView#onScrollChanged without calling super.onScrollChanged. If
    // this method does get called it is called both as a response to the embedder scrolling the
    // view as well as a response to mDelegate.scrollContainerViewTo.
    fun onContainerViewScrollChanged(x: Int, y: Int) {
        scrollNativeTo(x, y)
    }

    private fun scrollNativeTo(x: Int, y: Int) {
        /** Origin name is x, y */
        val correctX = clampHorizontalScroll(x)
        val correctY = clampVerticalScroll(y)

        // We shouldn't do the store to native while processing a touch event since that confuses
        // the gesture processing logic.
        if (mProcessingTouchEvent) {
            mDeferredNativeScrollX = correctX
            mDeferredNativeScrollY = correctY
            mApplyDeferredNativeScroll = true
            return
        }
        if (correctX == scrollX && correctY == scrollY) return

        // The scrollNativeTo call should be a simple store, so it's OK to assume it always
        // succeeds.
        scrollX = correctX
        scrollY = correctY
        mDelegate.scrollNativeTo(correctX, correctY)
    }

    private fun animateScrollTo(x: Int, y: Int): Boolean {
        val scrollX = mDelegate.containerViewScrollX
        val scrollY = mDelegate.containerViewScrollY
        val dx = clampHorizontalScroll(x) - scrollX
        val dy = clampVerticalScroll(y) - scrollY
        if (dx == 0 && dy == 0) return false
        mDelegate.smoothScroll(
            scrollX + dx,
            scrollY + dy,
            computeDurationInMilliSec(dx, dy).toLong()
        )
        mDelegate.invalidate()
        return true
    }

    /**
     * See [android.webkit.WebView.pageUp]
     */
    fun pageUp(top: Boolean): Boolean {
        val scrollX = mDelegate.containerViewScrollX
        val scrollY = mDelegate.containerViewScrollY
        if (top) {
            // go to the top of the document
            return animateScrollTo(scrollX, 0)
        }
        var dy = -mContainerViewHeight / 2
        if (mContainerViewHeight > 2 * PAGE_SCROLL_OVERLAP) {
            dy = -mContainerViewHeight + PAGE_SCROLL_OVERLAP
        }
        // animateScrollTo clamps the argument to the scrollable range so using (scrollY + dy) is
        // fine.
        return animateScrollTo(scrollX, scrollY + dy)
    }

    /**
     * See [android.webkit.WebView.pageDown]
     */
    fun pageDown(bottom: Boolean): Boolean {
        val scrollX = mDelegate.containerViewScrollX
        val scrollY = mDelegate.containerViewScrollY
        if (bottom) {
            return animateScrollTo(scrollX, computeVerticalScrollRange())
        }
        var dy = mContainerViewHeight / 2
        if (mContainerViewHeight > 2 * PAGE_SCROLL_OVERLAP) {
            dy = mContainerViewHeight - PAGE_SCROLL_OVERLAP
        }
        // animateScrollTo clamps the argument to the scrollable range so using (scrollY + dy) is
        // fine.
        return animateScrollTo(scrollX, scrollY + dy)
    }

    /**
     * See [android.webkit.WebView.requestChildRectangleOnScreen]
     */
    fun requestChildRectangleOnScreen(
        childOffsetX: Int, childOffsetY: Int, rect: Rect,
        immediate: Boolean
    ): Boolean {
        // TODO(mkosiba): WebViewClassic immediately returns false if a zoom animation is
        // in progress. We currently can't tell if one is happening.. should we instead cancel any
        // scroll animation when the size/pageScaleFactor changes?

        // TODO(mkosiba): Take scrollbar width into account in the screenRight/screenBotton
        // calculations. http://crbug.com/269032
        val scrollX = mDelegate.containerViewScrollX
        val scrollY = mDelegate.containerViewScrollY
        rect.offset(childOffsetX, childOffsetY)
        val screenTop = scrollY
        val screenBottom = scrollY + mContainerViewHeight
        var scrollYDelta = 0
        if (rect.bottom > screenBottom) {
            val oneThirdOfScreenHeight = mContainerViewHeight / 3
            scrollYDelta = if (rect.width() > 2 * oneThirdOfScreenHeight) {
                // If the rectangle is too tall to fit in the bottom two thirds
                // of the screen, place it at the top.
                rect.top - screenTop
            } else {
                // If the rectangle will still fit on screen, we want its
                // top to be in the top third of the screen.
                rect.top - (screenTop + oneThirdOfScreenHeight)
            }
        } else if (rect.top < screenTop) {
            scrollYDelta = rect.top - screenTop
        }
        val screenLeft = scrollX
        val screenRight = scrollX + mContainerViewWidth
        var scrollXDelta = 0
        if (rect.right > screenRight && rect.left > screenLeft) {
            scrollXDelta += if (rect.width() > mContainerViewWidth) {
                rect.left - screenLeft
            } else {
                rect.right - screenRight
            }
        } else if (rect.left < screenLeft) {
            scrollXDelta -= screenLeft - rect.left
        }
        if (scrollYDelta == 0 && scrollXDelta == 0) {
            return false
        }
        return if (immediate) {
            scrollBy(scrollXDelta, scrollYDelta)
            true
        } else {
            animateScrollTo(scrollX + scrollXDelta, scrollY + scrollYDelta)
        }
    }

    companion object {
        // Values taken from WebViewClassic.
        // The amount of content to overlap between two screens when using pageUp/pageDown methiods.
        private const val PAGE_SCROLL_OVERLAP = 24

        // Standard animated scroll speed.
        private const val STD_SCROLL_ANIMATION_SPEED_PIX_PER_SEC = 480

        // Time for the longest scroll animation.
        private const val MAX_SCROLL_ANIMATION_DURATION_MILLISEC = 750
        private fun computeDurationInMilliSec(dx: Int, dy: Int): Int {
            val distance = max(abs(dx), abs(dy))
            val duration = distance * 1000 / STD_SCROLL_ANIMATION_SPEED_PIX_PER_SEC
            return min(duration, MAX_SCROLL_ANIMATION_DURATION_MILLISEC)
        }
    }
}