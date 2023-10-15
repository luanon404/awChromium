// Copyright 2014 The Chromium Authors. All rights reserved.
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.
package org.chromium.ui

import android.content.Context
import android.view.View
import android.widget.AdapterView.OnItemClickListener
import android.widget.ListAdapter
import android.widget.ListView
import android.widget.PopupWindow

/**
 * The dropdown popup window that decides what widget should be used for the popup.
 * For Android K+, DropdownPopupWindow is used, which is based on AnchoredPopupWindow.
 * For devices before Android K, DropdowPopupWindowJellyBean is used, which is based
 * on ListPopupWindow.
 * Note that AnchoredPopupWindow can not be used on Android J due to a focus issue
 * that blocks user from selecting the items.
 * Creates an DropdownPopupWindow with specified parameters.
 * @param context Application context.
 * @param anchorView Popup view to be anchored.
 */
open class DropdownPopupWindow(context: Context, anchorView: View) {
    private val mPopup: DropdownPopupWindowInterface


    init {
        mPopup = DropdownPopupWindowImpl(context, anchorView)
    }

    /**
     * Sets the adapter that provides the data and the views to represent the data
     * in this popup window.
     *
     * @param adapter The adapter to use to create this window's content.
     */
    fun setAdapter(adapter: ListAdapter?) {
        mPopup.setAdapter(adapter)
    }

    fun setInitialSelection(initialSelection: Int) {
        mPopup.setInitialSelection(initialSelection)
    }

    /**
     * Shows the popup. The adapter should be set before calling this method.
     */
    fun show() {
        mPopup.show()
    }

    /**
     * Set a listener to receive a callback when the popup is dismissed.
     *
     * @param listener Listener that will be notified when the popup is dismissed.
     */
    fun setOnDismissListener(listener: PopupWindow.OnDismissListener?) {
        mPopup.setOnDismissListener(listener)
    }

    /**
     * Sets the text direction in the dropdown. Should be called before show().
     * @param isRtl If true, then dropdown text direction is right to left.
     */
    fun setRtl(isRtl: Boolean) {
        mPopup.setRtl(isRtl)
    }

    /**
     * Disable hiding on outside tap so that tapping on a text input field associated with the popup
     * will not hide the popup.
     */
    fun disableHideOnOutsideTap() {
        mPopup.disableHideOnOutsideTap()
    }

    /**
     * Sets the content description to be announced by accessibility services when the dropdown is
     * shown.
     * @param description The description of the content to be announced.
     */
    fun setContentDescriptionForAccessibility(description: CharSequence?) {
        mPopup.setContentDescriptionForAccessibility(description)
    }

    /**
     * Sets a listener to receive events when a list item is clicked.
     *
     * @param clickListener Listener to register
     */
    fun setOnItemClickListener(clickListener: OnItemClickListener?) {
        mPopup.setOnItemClickListener(clickListener)
    }

    /**
     * Show the popup. Will have no effect if the popup is already showing.
     * Post a [.show] call to the UI thread.
     */
    fun postShow() {
        mPopup.postShow()
    }

    /**
     * Disposes of the popup window.
     */
    fun dismiss() {
        mPopup.dismiss()
    }

    val listView: ListView?
        /**
         * @return The [ListView] displayed within the popup window.
         */
        get() = mPopup.listView
    val isShowing: Boolean
        /**
         * @return Whether the popup is currently showing.
         */
        get() = mPopup.isShowing

    /**
     * See [DropdownPopupWindowInterface.setFooterView].
     */
    protected fun setFooterView(footerItem: View?) {
        mPopup.setFooterView(footerItem)
    }
}