// Copyright 2018 The Chromium Authors
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.

package org.chromium.ui;

import android.view.View;

import androidx.core.view.WindowInsetsCompat;

import org.chromium.base.ObserverList;
import org.chromium.base.TraceEvent;

/**
 * A delegate that can be overridden to change the methods to figure out and change the current
 * state of Android's soft keyboard.
 */
public class KeyboardVisibilityDelegate {

    /**
     * The delegate to determine keyboard visibility.
     */
    private static KeyboardVisibilityDelegate sInstance = new KeyboardVisibilityDelegate();

    /**
     * An interface to notify listeners of changes in the soft keyboard's visibility.
     */
    public interface KeyboardVisibilityListener {
        /**
         * Called whenever the keyboard might have changed.
         *
         * @param isShowing A boolean that's true if the keyboard is now visible.
         */
        void keyboardVisibilityChanged(boolean isShowing);
    }

    private final ObserverList<KeyboardVisibilityListener> mKeyboardVisibilityListeners = new ObserverList<>();

    /**
     * Allows setting a new strategy to override the default {@link KeyboardVisibilityDelegate}.
     * Caution while using it as it will take precedence over the currently set strategy.
     * If two delegates are added, the newer one will try to handle any call. If it can't an older
     * one is called. New delegates can call |method| of a predecessor with {@code super.|method|}.
     *
     * @param delegate A {@link KeyboardVisibilityDelegate} instance.
     */
    public static void setInstance(KeyboardVisibilityDelegate delegate) {
        sInstance = delegate;
    }

    /**
     * Prefer using {@link org.chromium.ui.base.WindowAndroid#getKeyboardDelegate()} over this
     * method. Both return a delegate which allows checking and influencing the keyboard state.
     *
     * @return the global {@link KeyboardVisibilityDelegate}.
     */
    public static KeyboardVisibilityDelegate getInstance() {
        return sInstance;
    }

    /**
     * Only classes that override the delegate may instantiate it and set it using
     * {@link #setInstance(KeyboardVisibilityDelegate)}.
     */
    protected KeyboardVisibilityDelegate() {
    }

    /**
     * Calculates the keyboard height based on the bottom margin it causes for the given
     * rootView. It is used to determine whether the keyboard is visible.
     *
     * @param rootView A {@link View}.
     * @return The size of the bottom margin which most likely is exactly the keyboard size.
     */
    public int calculateKeyboardHeight(View rootView) {
        try (TraceEvent ignored = TraceEvent.scoped("KeyboardVisibilityDelegate.calculateKeyboardHeight")) {
            if (rootView == null || rootView.getRootWindowInsets() == null) return 0;
            WindowInsetsCompat windowInsetsCompat = WindowInsetsCompat.toWindowInsetsCompat(rootView.getRootWindowInsets(), rootView);
            int imeHeightIncludingNavigationBar = windowInsetsCompat.getInsets(WindowInsetsCompat.Type.ime()).bottom;
            if (imeHeightIncludingNavigationBar == 0) return 0;
            int navigationBarHeight = windowInsetsCompat.getInsets(WindowInsetsCompat.Type.navigationBars()).bottom;
            return imeHeightIncludingNavigationBar - navigationBarHeight;
        }
    }

    /**
     * Returns whether the keyboard is showing.
     *
     * @param view    A {@link View}.
     * @return Whether or not the software keyboard is visible.
     */
    public boolean isKeyboardShowing(View view) {
        return isAndroidSoftKeyboardShowing(view);
    }

    /**
     * Detects whether or not the keyboard is showing. This is a best guess based on the height
     * of the keyboard as there is no standardized/foolproof way to do this.
     * This template method simplifies mocking and the access to the soft keyboard in subclasses.
     *
     * @param view    A {@link View}.
     * @return Whether or not the software keyboard is visible.
     */
    protected boolean isAndroidSoftKeyboardShowing(View view) {
        View rootView = view.getRootView();
        return rootView != null && calculateKeyboardHeight(rootView) > 0;
    }

    /**
     * To be called when the keyboard visibility state might have changed. Informs listeners of the
     * state change IFF there actually was a change.
     *
     * @param isShowing The current (guesstimated) state of the keyboard.
     */
    protected void notifyListeners(boolean isShowing) {
        for (KeyboardVisibilityListener listener : mKeyboardVisibilityListeners) {
            listener.keyboardVisibilityChanged(isShowing);
        }
    }

}
