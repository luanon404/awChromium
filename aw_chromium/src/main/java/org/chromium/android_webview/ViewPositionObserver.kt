// Copyright 2013 The Chromium Authors. All rights reserved.
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.
package org.chromium.android_webview

import android.view.View
import android.view.ViewTreeObserver

/**
 * Used to register listeners that can be notified of changes to the position of a view.
 * @param mView The view to observe.
 */
class ViewPositionObserver(private val mView: View) {
    /**
     * Called during predraw if the position of the underlying view has changed.
     */
    interface Listener {
        fun onPositionChanged(positionX: Int, positionY: Int)
    }

    // Absolute position of the container view relative to its parent window.
    private val mPosition = IntArray(2)
    private val mListeners: ArrayList<Listener> = ArrayList()
    private val mPreDrawListener: ViewTreeObserver.OnPreDrawListener

    init {
        updatePosition()
        mPreDrawListener = ViewTreeObserver.OnPreDrawListener {
            updatePosition()
            true
        }
    }

    val positionX: Int
        /**
         * @return The current x position of the observed view.
         */
        get() {
            // The stored position may be out-of-date. Get the real current position.
            updatePosition()
            return mPosition[0]
        }
    val positionY: Int
        /**
         * @return The current y position of the observed view.
         */
        get() {
            // The stored position may be out-of-date. Get the real current position.
            updatePosition()
            return mPosition[1]
        }

    /**
     * Register a listener to be called when the position of the underlying view changes.
     */
    fun addListener(listener: Listener) {
        if (mListeners.contains(listener)) return
        if (mListeners.isEmpty()) {
            mView.viewTreeObserver.addOnPreDrawListener(mPreDrawListener)
            updatePosition()
        }
        mListeners.add(listener)
    }

    private fun notifyListeners() {
        for (i in mListeners.indices) {
            mListeners[i].onPositionChanged(mPosition[0], mPosition[1])
        }
    }

    private fun updatePosition() {
        val previousPositionX = mPosition[0]
        val previousPositionY = mPosition[1]
        mView.getLocationInWindow(mPosition)
        if (mPosition[0] != previousPositionX || mPosition[1] != previousPositionY) {
            notifyListeners()
        }
    }

    /**
     * Clears installed listener(s).
     */
    fun clearListener() {
        mListeners.clear()
    }
}