// Copyright 2018 The Chromium Authors. All rights reserved.
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.
package org.chromium.ui

import android.view.View
import android.widget.AdapterView.OnItemClickListener
import android.widget.ListAdapter
import android.widget.ListView
import android.widget.PopupWindow

/**
 * The interface for dropdown popup window.
 */
interface DropdownPopupWindowInterface {
    /**
     * Sets the adapter that provides the data and the views to represent the data
     * in this popup window.
     *
     * @param adapter The adapter to use to create this window's content.
     */
    fun setAdapter(adapter: ListAdapter?)

    /**
     * Sets the initial selection.
     *
     * @param initialSelection The index of the initial item to select.
     */
    fun setInitialSelection(initialSelection: Int)

    /**
     * Shows the popup. The adapter should be set before calling this method.
     */
    fun show()

    /**
     * Set a listener to receive a callback when the popup is dismissed.
     *
     * @param listener Listener that will be notified when the popup is dismissed.
     */
    fun setOnDismissListener(listener: PopupWindow.OnDismissListener?)

    /**
     * Sets the text direction in the dropdown. Should be called before show().
     * @param isRtl If true, then dropdown text direction is right to left.
     */
    fun setRtl(isRtl: Boolean)

    /**
     * Disable hiding on outside tap so that tapping on a text input field associated with the popup
     * will not hide the popup.
     */
    fun disableHideOnOutsideTap()

    /**
     * Sets the content description to be announced by accessibility services when the dropdown is
     * shown.
     * @param description The description of the content to be announced.
     */
    fun setContentDescriptionForAccessibility(description: CharSequence?)

    /**
     * Sets a listener to receive events when a list item is clicked.
     *
     * @param clickListener Listener to register.
     */
    fun setOnItemClickListener(clickListener: OnItemClickListener?)

    /**
     * Adds a non-scrolling View beneath the list. This View will be separated from the main list
     * by a single divider.
     * TODO(crbug.com/896349): This currently only works when called before show().
     */
    fun setFooterView(footerView: View?)

    /**
     * Show the popup. Will have no effect if the popup is already showing.
     * Post a [.show] call to the UI thread.
     */
    fun postShow()

    /**
     * Disposes of the popup window.
     */
    fun dismiss()

    /**
     * @return The [ListView] displayed within the popup window.
     */
    val listView: ListView?

    /**
     * @return Whether the popup is currently showing.
     */
    val isShowing: Boolean
}