// Copyright 2013 The Chromium Authors. All rights reserved.
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.
@file:Suppress("DEPRECATION")

package org.chromium.android_webview

import android.annotation.SuppressLint
import android.view.Gravity
import android.view.View
import android.widget.FrameLayout
import android.widget.ZoomButtonsController
import android.widget.ZoomButtonsController.OnZoomListener

// This class is visible purely for tests.
class AwZoomControls internal constructor(private val mAwContents: AwContents) {
    // It is advised to use getZoomController() where possible.
    private var mZoomButtonsController: ZoomButtonsController? = null
    private var mCanZoomIn = false
    private var mCanZoomOut = false

    @Suppress("DEPRECATION")
    fun invokeZoomPicker() {
        val zoomController = zoomController
        if (zoomController != null) {
            zoomController.isVisible = true
        }
    }

    fun dismissZoomPicker() {
        val zoomController = zoomController
        if (zoomController != null) {
            zoomController.isVisible = false
        }
    }

    fun updateZoomControls() {
        val zoomController = zoomController ?: return
        mCanZoomIn = mAwContents.canZoomIn()
        mCanZoomOut = mAwContents.canZoomOut()
        if (!mCanZoomIn && !mCanZoomOut) {
            // Hide the zoom in and out buttons if the page cannot zoom
            zoomController.zoomControls.visibility = View.GONE
        } else {
            // Set each one individually, as a page may be able to zoom in or out
            zoomController.setZoomInEnabled(mCanZoomIn)
            zoomController.setZoomOutEnabled(mCanZoomOut)
        }
    }

    val zoomControlsViewForTest: View?
        // This method is used in tests. It doesn't modify the state of zoom controls.
        get() = if (mZoomButtonsController != null) mZoomButtonsController!!.zoomControls else null

    @get:SuppressLint("RtlHardcoded")
    private val zoomController: ZoomButtonsController?
        get() {
            if (mZoomButtonsController == null && mAwContents.settings.shouldDisplayZoomControls()) {
                mZoomButtonsController = ZoomButtonsController(mAwContents.containerView)
                mZoomButtonsController!!.setOnZoomListener(ZoomListener())
                // ZoomButtonsController positions the buttons at the bottom, but in
                // the middle. Change their layout parameters so they appear on the
                // right.
                val controls = mZoomButtonsController!!.zoomControls
                val params = controls.layoutParams
                if (params is FrameLayout.LayoutParams) {
                    params.gravity = Gravity.RIGHT
                }
            }
            return mZoomButtonsController
        }

    private inner class ZoomListener : OnZoomListener {
        @Deprecated("Deprecated in Java")
        override fun onVisibilityChanged(visible: Boolean) {
            if (visible) {
                // Bring back the hidden zoom controls.
                mZoomButtonsController!!.zoomControls.visibility = View.VISIBLE
                updateZoomControls()
            }
        }

        @Deprecated("Deprecated in Java")
        override fun onZoom(zoomIn: Boolean) {
            if (zoomIn) {
                mAwContents.zoomIn()
            } else {
                mAwContents.zoomOut()
            }
            // ContentView will call updateZoomControls after its current page scale
            // is got updated from the native code.
        }
    }
}