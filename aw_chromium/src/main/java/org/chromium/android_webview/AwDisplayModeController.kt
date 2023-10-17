// Copyright 2020 The Chromium Authors. All rights reserved.
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.
package org.chromium.android_webview

import android.annotation.SuppressLint
import android.graphics.Matrix
import android.graphics.Rect
import android.view.View
import org.chromium.base.Log
import org.chromium.blink.mojom.DisplayMode

/**
 * Display mode controller for WebView.
 *
 * Display mode will be used for display cutout controller's internal implementation since we only
 * apply display cutout to fullscreen mode. Also, display mode will be reported as CSS property.
 */
class AwDisplayModeController
/**
 * Constructor for AwDisplayModeController.
 *
 * @param mDelegate The delegate.
 * @param mContainerView The container view (WebView).
 */(private val mDelegate: Delegate, private var mContainerView: View) {
    /**
     * This is a delegate that the embedder needs to implement.
     */
    interface Delegate {
        /** @return The display width.
         */
        val displayWidth: Int

        /** @return The display height.
         */
        val displayHeight: Int
    }

    val displayMode: Int
        get() =// We currently do not support other display modes.
            if (isDisplayInFullscreen) DisplayMode.FULLSCREEN else DisplayMode.BROWSER
    private val isDisplayInFullscreen: Boolean
        get() {
            getViewRectOnScreen(mContainerView, sCachedViewRect)
            getViewRectOnScreen(mContainerView.rootView, sCachedWindowRect)

            // Get display coordinates.
            val displayWidth = mDelegate.displayWidth
            val displayHeight = mDelegate.displayHeight
            sCachedDisplayRect[0, 0, displayWidth] = displayHeight
            if (DEBUG) {
                Log.i(
                    TAG,
                    "isDisplayInFullscreen. view rect: " + sCachedViewRect + ", display rect: "
                            + sCachedDisplayRect + ", window rect: " + sCachedWindowRect
                )
            }

            // Display is in fullscreen only when webview is occupying the entire window and display.
            // Checking the window rect is more complicated and therefore not doing it for now, but
            // there can still be cases where the window is a bit off.
            if (sCachedViewRect != sCachedDisplayRect) {
                if (DEBUG) {
                    Log.i(TAG, "WebView is not occupying the entire screen.")
                }
                return false
            } else if (sCachedViewRect != sCachedWindowRect) {
                if (DEBUG) {
                    Log.i(TAG, "WebView is not occupying the entire window.")
                }
                return false
            } else if (hasTransform()) {
                if (DEBUG) {
                    Log.i(TAG, "WebView is rotated or scaled.")
                }
                return false
            }
            return true
        }

    @SuppressLint("NewApi") // need this exception since we will try using Q API in P
    private fun hasTransform(): Boolean {
        sCachedMatrix.reset() // set to identity
        // Check if a view coordinates transforms to screen coordinates that is not an identity
        // matrix, which means that view is rotated or scaled in regards to the screen.
        // This API got hidden from L, and readded in API 29 (Q). It seems that we can call this
        // on P most of the time, but adding try-catch just in case.
        try {
            mContainerView.transformMatrixToGlobal(sCachedMatrix)
        } catch (e: Throwable) {
            Log.w(TAG, "Error checking transform for display mode: ", e)
            return true
        }
        return !sCachedMatrix.isIdentity
    }

    /**
     * Set the current container view.
     *
     * @param containerView The current container view.
     */
    fun setCurrentContainerView(containerView: View) {
        if (DEBUG) Log.i(TAG, "setCurrentContainerView: $containerView")
        mContainerView = containerView
    }

    companion object {
        private const val DEBUG = false
        private const val TAG = "DisplayMode"

        // Reuse these structures to minimize memory impact.
        private val sCachedLocationOnScreen = intArrayOf(0, 0)
        private val sCachedViewRect = Rect()
        private val sCachedWindowRect = Rect()
        private val sCachedDisplayRect = Rect()
        private val sCachedMatrix = Matrix()
        private fun getViewRectOnScreen(view: View?, rect: Rect) {
            if (view == null) {
                rect[0, 0, 0] = 0
                return
            }
            view.getLocationOnScreen(sCachedLocationOnScreen)
            val width = view.measuredWidth
            val height = view.measuredHeight
            rect[sCachedLocationOnScreen[0], sCachedLocationOnScreen[1], sCachedLocationOnScreen[0] + width] =
                sCachedLocationOnScreen[1] + height
        }
    }
}