// Copyright 2013 The Chromium Authors. All rights reserved.
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.
package org.chromium.android_webview

import android.content.Context
import android.graphics.Canvas
import android.view.View
import android.widget.EdgeEffect
import kotlin.math.max
import kotlin.math.min

/**
 * This class manages the edge glow effect when a WebView is flung or pulled beyond the edges.
 */
internal class OverScrollGlow(context: Context?, private val mHostView: View) {
    private val mEdgeGlowTop: EdgeEffect
    private val mEdgeGlowBottom: EdgeEffect
    private val mEdgeGlowLeft: EdgeEffect
    private val mEdgeGlowRight: EdgeEffect
    private var mOverScrollDeltaX = 0
    private var mOverScrollDeltaY = 0
    private var mShouldPull = false

    init {
        mEdgeGlowTop = EdgeEffect(context)
        mEdgeGlowBottom = EdgeEffect(context)
        mEdgeGlowLeft = EdgeEffect(context)
        mEdgeGlowRight = EdgeEffect(context)
    }

    fun setShouldPull(shouldPull: Boolean) {
        mShouldPull = shouldPull
    }

    /**
     * Pull leftover touch scroll distance into one of the edge glows as appropriate.
     *
     * @param oldX Old X scroll offset
     * @param oldY Old Y scroll offset
     * @param maxX Maximum range for horizontal scrolling
     * @param maxY Maximum range for vertical scrolling
     */
    fun pullGlow(oldX: Int, oldY: Int, maxX: Int, maxY: Int) {
        if (!mShouldPull) return
        // Only show overscroll bars if there was no movement in any direction
        // as a result of scrolling.
        if (oldX == mHostView.scrollX && oldY == mHostView.scrollY) {
            // Don't show left/right glows if we fit the whole content.
            // Also don't show if there was vertical movement.
            if (maxX > 0) {
                val pulledToX = oldX + mOverScrollDeltaX
                if (pulledToX < 0) {
                    mEdgeGlowLeft.onPull(mOverScrollDeltaX.toFloat() / mHostView.width)
                    if (!mEdgeGlowRight.isFinished) {
                        mEdgeGlowRight.onRelease()
                    }
                } else if (pulledToX > maxX) {
                    mEdgeGlowRight.onPull(mOverScrollDeltaX.toFloat() / mHostView.width)
                    if (!mEdgeGlowLeft.isFinished) {
                        mEdgeGlowLeft.onRelease()
                    }
                }
                mOverScrollDeltaX = 0
            }
            if (maxY > 0 || mHostView.overScrollMode == View.OVER_SCROLL_ALWAYS) {
                val pulledToY = oldY + mOverScrollDeltaY
                if (pulledToY < 0) {
                    mEdgeGlowTop.onPull(mOverScrollDeltaY.toFloat() / mHostView.height)
                    if (!mEdgeGlowBottom.isFinished) {
                        mEdgeGlowBottom.onRelease()
                    }
                } else if (pulledToY > maxY) {
                    mEdgeGlowBottom.onPull(mOverScrollDeltaY.toFloat() / mHostView.height)
                    if (!mEdgeGlowTop.isFinished) {
                        mEdgeGlowTop.onRelease()
                    }
                }
                mOverScrollDeltaY = 0
            }
        }
    }

    /**
     * Absorb leftover fling velocity into one of the edge glows as appropriate.
     *
     * @param x Current X scroll offset
     * @param y Current Y scroll offset
     * @param oldX Old X scroll offset
     * @param oldY Old Y scroll offset
     * @param rangeX Maximum range for horizontal scrolling
     * @param rangeY Maximum range for vertical scrolling
     * @param currentFlingVelocity Current fling velocity
     */
    fun absorbGlow(
        x: Int, y: Int, oldX: Int, oldY: Int, rangeX: Int, rangeY: Int, currentFlingVelocity: Float
    ) {
        if (mShouldPull) {
            // Not absorb the glow because the user is pulling the glow now.
            // TODO(hush): crbug.com/501556. Do not use "mShouldPull" to switch
            // between absorbGlow and pullGlow. Use the velocity instead.
            return
        }
        if (rangeY > 0 || mHostView.overScrollMode == View.OVER_SCROLL_ALWAYS) {
            if (y < 0 && oldY >= 0) {
                mEdgeGlowTop.onAbsorb(currentFlingVelocity.toInt())
                if (!mEdgeGlowBottom.isFinished) {
                    mEdgeGlowBottom.onRelease()
                }
            } else if (rangeY in oldY..<y) {
                mEdgeGlowBottom.onAbsorb(currentFlingVelocity.toInt())
                if (!mEdgeGlowTop.isFinished) {
                    mEdgeGlowTop.onRelease()
                }
            }
        }
        if (rangeX > 0) {
            if (x < 0 && oldX >= 0) {
                mEdgeGlowLeft.onAbsorb(currentFlingVelocity.toInt())
                if (!mEdgeGlowRight.isFinished) {
                    mEdgeGlowRight.onRelease()
                }
            } else if (rangeX in oldX..<x) {
                mEdgeGlowRight.onAbsorb(currentFlingVelocity.toInt())
                if (!mEdgeGlowLeft.isFinished) {
                    mEdgeGlowLeft.onRelease()
                }
            }
        }
    }

    /**
     * Set touch delta values indicating the current amount of overscroll.
     *
     * @param deltaX
     * @param deltaY
     */
    fun setOverScrollDeltas(deltaX: Int, deltaY: Int) {
        mOverScrollDeltaX += deltaX
        mOverScrollDeltaY += deltaY
    }

    /**
     * Draw the glow effect along the sides of the widget.
     *
     * @param canvas Canvas to draw into, transformed into view coordinates.
     * @param maxScrollX maximum horizontal scroll offset
     * @param maxScrollY maximum vertical scroll offset
     * @return true if glow effects are still animating and the view should invalidate again.
     */
    fun drawEdgeGlows(canvas: Canvas, maxScrollX: Int, maxScrollY: Int): Boolean {
        val scrollX = mHostView.scrollX
        val scrollY = mHostView.scrollY
        val width = mHostView.width
        val height = mHostView.height
        var invalidateForGlow = false
        if (!mEdgeGlowTop.isFinished) {
            val restoreCount = canvas.save()
            canvas.translate(scrollX.toFloat(), min(0, scrollY).toFloat())
            mEdgeGlowTop.setSize(width, height)
            invalidateForGlow = invalidateForGlow or mEdgeGlowTop.draw(canvas)
            canvas.restoreToCount(restoreCount)
        }
        if (!mEdgeGlowBottom.isFinished) {
            val restoreCount = canvas.save()
            canvas.translate(
                (-width + scrollX).toFloat(), (max(maxScrollY, scrollY) + height).toFloat()
            )
            canvas.rotate(180f, width.toFloat(), 0f)
            mEdgeGlowBottom.setSize(width, height)
            invalidateForGlow = invalidateForGlow or mEdgeGlowBottom.draw(canvas)
            canvas.restoreToCount(restoreCount)
        }
        if (!mEdgeGlowLeft.isFinished) {
            val restoreCount = canvas.save()
            canvas.rotate(270f)
            canvas.translate((-height - scrollY).toFloat(), min(0, scrollX).toFloat())
            mEdgeGlowLeft.setSize(height, width)
            invalidateForGlow = invalidateForGlow or mEdgeGlowLeft.draw(canvas)
            canvas.restoreToCount(restoreCount)
        }
        if (!mEdgeGlowRight.isFinished) {
            val restoreCount = canvas.save()
            canvas.rotate(90f)
            canvas.translate(scrollY.toFloat(), -(max(scrollX, maxScrollX) + width).toFloat())
            mEdgeGlowRight.setSize(height, width)
            invalidateForGlow = invalidateForGlow or mEdgeGlowRight.draw(canvas)
            canvas.restoreToCount(restoreCount)
        }
        return invalidateForGlow
    }

    val isAnimating: Boolean
        /**
         * @return True if any glow is still animating
         */
        get() = (!mEdgeGlowTop.isFinished || !mEdgeGlowBottom.isFinished || !mEdgeGlowLeft.isFinished || !mEdgeGlowRight.isFinished)

    /**
     * Release all glows from any touch pulls in progress.
     */
    fun releaseAll() {
        mEdgeGlowTop.onRelease()
        mEdgeGlowBottom.onRelease()
        mEdgeGlowLeft.onRelease()
        mEdgeGlowRight.onRelease()
    }
}