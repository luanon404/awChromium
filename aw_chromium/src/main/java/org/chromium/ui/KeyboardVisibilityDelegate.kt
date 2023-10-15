// Copyright 2018 The Chromium Authors. All rights reserved.
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.
package org.chromium.ui

import android.content.Context
import android.graphics.Rect
import android.view.View
import org.chromium.base.ObserverList

/**
 * A delegate that can be overridden to change the methods to figure out and change the current
 * state of Android's soft keyboard.
 */
@Suppress("DEPRECATION")
open class KeyboardVisibilityDelegate
/**
 * Only classes that override the delegate may instantiate it and set it using
 * [.setInstance].
 */
protected constructor() {
    /**
     * An interface to notify listeners of changes in the soft keyboard's visibility.
     */
    interface KeyboardVisibilityListener {
        /**
         * Called whenever the keyboard might have changed.
         * @param isShowing A boolean that's true if the keyboard is now visible.
         */
        fun keyboardVisibilityChanged(isShowing: Boolean)
    }

    private val mKeyboardVisibilityListeners = ObserverList<KeyboardVisibilityListener>()
    protected open fun registerKeyboardVisibilityCallbacks() {}
    protected open fun unregisterKeyboardVisibilityCallbacks() {}

    /**
     * Calculates the keyboard height based on the bottom margin it causes for the given
     * rootView. It is used to determine whether the keyboard is visible.
     * @param rootView A [View].
     * @return The size of the bottom margin which most likely is exactly the keyboard size.
     */
    private fun calculateKeyboardHeight(rootView: View): Int {
        val appRect = Rect()
        rootView.getWindowVisibleDisplayFrame(appRect)

        // Assume status bar is always at the top of the screen.
        val statusBarHeight = appRect.top
        var bottomMargin = rootView.height - (appRect.height() + statusBarHeight)

        // If there is no bottom margin, the keyboard is not showing.
        if (bottomMargin <= 0) return 0
        val insets = rootView.rootWindowInsets
        if (insets != null) { // Either not supported or the rootView isn't attached.
            bottomMargin -= insets.stableInsetBottom
        }
        return bottomMargin // This might include a bottom navigation.
    }

    private fun calculateKeyboardDetectionThreshold(context: Context, rootView: View): Int {
        val appRect = Rect()
        rootView.getWindowVisibleDisplayFrame(appRect)

        // If the display frame width is < root view width, controls are on the side of
        // the screen. The inverse is not necessarily true; i.e. if navControlsOnSide is
        // false, it doesn't mean the controls are not on the side or that they _are_ at
        // the bottom. It might just mean the app is not responsible for drawing their
        // background.
        val navControlsOnSide = appRect.width() != rootView.width
        // If the Android nav controls are on the sides instead of at the bottom, its
        // height is not needed.
        if (navControlsOnSide) return 0

        // Since M, window insets provide a good keyboard height - no guessing the nav required.
        // return 0

        // In the event we couldn't get the bottom nav height, use a best guess
        // of the keyboard height. In certain cases this also means including
        // the height of the Android navigation.
        val density = context.resources.displayMetrics.density
        return (KEYBOARD_DETECT_BOTTOM_THRESHOLD_DP * density).toInt()
    }

    /**
     * Returns whether the keyboard is showing.
     * @param context A [Context] instance.
     * @param view    A [View].
     * @return        Whether or not the software keyboard is visible.
     */
    fun isKeyboardShowing(context: Context, view: View): Boolean {
        return isAndroidSoftKeyboardShowing(context, view)
    }

    /**
     * Detects whether or not the keyboard is showing. This is a best guess based on the height
     * of the keyboard as there is no standardized/foolproof way to do this.
     * This template method simplifies mocking and the access to the soft keyboard in subclasses.
     * @param context A [Context] instance.
     * @param view    A [View].
     * @return        Whether or not the software keyboard is visible.
     */
    private fun isAndroidSoftKeyboardShowing(context: Context, view: View): Boolean {
        val rootView = view.rootView
        return (rootView != null && calculateKeyboardHeight(rootView) > calculateKeyboardDetectionThreshold(
            context,
            rootView
        ))
    }

    /**
     * To be called when the keyboard visibility state might have changed. Informs listeners of the
     * state change IFF there actually was a change.
     * @param isShowing The current (guesstimated) state of the keyboard.
     */
    protected fun notifyListeners(isShowing: Boolean) {
        for (listener in mKeyboardVisibilityListeners) {
            listener.keyboardVisibilityChanged(isShowing)
        }
    }

    companion object {

        /** The minimum size of the bottom margin below the app to detect a keyboard.  */
        private const val KEYBOARD_DETECT_BOTTOM_THRESHOLD_DP = 100f
        /**
         * Prefer using [org.chromium.ui.base.WindowAndroid.getKeyboardDelegate] over this
         * method. Both return a delegate which allows checking and influencing the keyboard state.
         * @return the global [KeyboardVisibilityDelegate].
         */
        /**
         * Allows setting a new strategy to override the default [KeyboardVisibilityDelegate].
         * Caution while using it as it will take precedence over the currently set strategy.
         * If two delegates are added, the newer one will try to handle any call. If it can't an older
         * one is called. New delegates can call |method| of a predecessor with `super.|method|`.
         */
        /** The delegate to determine keyboard visibility.  */
        var instance = KeyboardVisibilityDelegate()
    }
}