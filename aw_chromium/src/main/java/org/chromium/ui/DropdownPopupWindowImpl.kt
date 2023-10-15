// Copyright 2018 The Chromium Authors. All rights reserved.
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.
package org.chromium.ui

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Rect
import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.View
import android.view.View.MeasureSpec
import android.view.View.OnLayoutChangeListener
import android.view.ViewGroup
import android.view.accessibility.AccessibilityEvent
import android.widget.AdapterView.OnItemClickListener
import android.widget.FrameLayout
import android.widget.LinearLayout
import android.widget.ListAdapter
import android.widget.ListView
import android.widget.PopupWindow
import org.chromium.android_webview.R
import org.chromium.base.ApiCompatibilityUtils
import org.chromium.ui.UiUtils.computeMaxWidthOfListAdapterItems
import org.chromium.ui.widget.AnchoredPopupWindow
import org.chromium.ui.widget.AnchoredPopupWindow.LayoutObserver
import org.chromium.ui.widget.ViewRectProvider
import kotlin.math.max

/**
 * The dropdown popup window for use on Lollipop+. Internally uses an AnchoredPopupWindow
 * anchored to a view to display a list of options.
 * Creates an DropdownPopupWindowImpl with specified parameters.
 * @param mContext Application context.
 * @param mAnchorView Popup view to be anchored.
 */
@SuppressLint("InflateParams")
internal class DropdownPopupWindowImpl(
    private val mContext: Context, private val mAnchorView: View
) : LayoutObserver, DropdownPopupWindowInterface {
    private var mRtl = false
    private var mInitialSelection = -1
    private val mLayoutChangeListener: OnLayoutChangeListener
    private var mDescription: CharSequence? = null
    private val mAnchoredPopupWindow: AnchoredPopupWindow
    private var mAdapter: ListAdapter? = null
    private val mContentView: LinearLayout

    /**
     * @return The [ListView] displayed within the popup window.
     */
    override val listView: ListView
    private val mFooterView: FrameLayout
    private val mBackground: Drawable
    private val mHorizontalPadding: Int

    init {
        mAnchorView.id = R.id.dropdown_popup_window
        mAnchorView.tag = this
        mLayoutChangeListener =
            OnLayoutChangeListener { v, _, _, _, _, _, _, _, _ -> if (v === mAnchorView) show() }
        mAnchorView.addOnLayoutChangeListener(mLayoutChangeListener)
        mContentView =
            LayoutInflater.from(mContext).inflate(R.layout.dropdown_window, null) as LinearLayout
        listView = mContentView.findViewById<View>(R.id.dropdown_body_list) as ListView
        mFooterView = mContentView.findViewById<View>(R.id.dropdown_footer) as FrameLayout
        val rectProvider = ViewRectProvider(mAnchorView)
        rectProvider.setIncludePadding(true)
        mBackground = ApiCompatibilityUtils.getDrawable(
            mContext.resources, R.drawable.popup_bg_tinted
        )
        mAnchoredPopupWindow = AnchoredPopupWindow(
            mContext, mAnchorView, mBackground, mContentView, rectProvider
        )
        val onDismissLitener = PopupWindow.OnDismissListener {
            mAnchoredPopupWindow.dismiss()
            mAnchorView.removeOnLayoutChangeListener(mLayoutChangeListener)
            mAnchorView.tag = null
        }
        mAnchoredPopupWindow.addOnDismissListener(onDismissLitener)
        mAnchoredPopupWindow.setLayoutObserver(this)
        mAnchoredPopupWindow.setElevation(
            mContext.resources.getDimensionPixelSize(R.dimen.dropdown_elevation).toFloat()
        )
        val paddingRect = Rect()
        mBackground.getPadding(paddingRect)
        rectProvider.setInsetPx(0,  /* top= */paddingRect.bottom, 0,  /* bottom= */paddingRect.top)
        mHorizontalPadding = paddingRect.right + paddingRect.left
        mAnchoredPopupWindow.setPreferredHorizontalOrientation(
            AnchoredPopupWindow.HorizontalOrientation.CENTER
        )
        mAnchoredPopupWindow.setUpdateOrientationOnChange(true)
        mAnchoredPopupWindow.setOutsideTouchable(true)
    }

    /**
     * Sets the adapter that provides the data and the views to represent the data
     * in this popup window.
     *
     * @param adapter The adapter to use to create this window's content.
     */
    override fun setAdapter(adapter: ListAdapter?) {
        mAdapter = adapter
        listView.adapter = adapter
        mAnchoredPopupWindow.onRectChanged()
    }

    override fun onPreLayoutChange(
        positionBelow: Boolean, x: Int, y: Int, width: Int, height: Int, anchorRect: Rect
    ) {
        mBackground.bounds = anchorRect
        mAnchoredPopupWindow.setBackgroundDrawable(
            ApiCompatibilityUtils.getDrawable(
                mContext.resources, R.drawable.popup_bg_tinted
            )
        )
    }

    /**
     * Sets the initial selection.
     *
     * @param initialSelection The index of the initial item to select.
     */
    override fun setInitialSelection(initialSelection: Int) {
        mInitialSelection = initialSelection
    }

    /**
     * Shows the popup. The adapter should be set before calling this method.
     */
    override fun show() {
        assert(mAdapter != null) { "Set the adapter before showing the popup." }
        val wasShowing = mAnchoredPopupWindow.isShowing
        mAnchoredPopupWindow.setVerticalOverlapAnchor(false)
        mAnchoredPopupWindow.setHorizontalOverlapAnchor(true)
        val windowWidthPx = mContext.resources.displayMetrics.widthPixels
        val contentWidth = measureContentWidth()
        if (windowWidthPx < contentWidth + mHorizontalPadding) {
            mAnchoredPopupWindow.setMaxWidth(windowWidthPx - mHorizontalPadding)
        } else if (mAnchorView.width < contentWidth) {
            mAnchoredPopupWindow.setMaxWidth(contentWidth + mHorizontalPadding)
        } else {
            mAnchoredPopupWindow.setMaxWidth(mAnchorView.width + mHorizontalPadding)
        }
        mAnchoredPopupWindow.show()
        listView.dividerHeight = 0
        val layoutDirection = if (mRtl) View.LAYOUT_DIRECTION_RTL else View.LAYOUT_DIRECTION_LTR
        listView.layoutDirection = layoutDirection
        if (!wasShowing) {
            listView.contentDescription = mDescription
            listView.sendAccessibilityEvent(AccessibilityEvent.TYPE_WINDOW_STATE_CHANGED)
        }
        if (mInitialSelection >= 0) {
            listView.setSelection(mInitialSelection)
            mInitialSelection = -1
        }
    }

    /**
     * Set a listener to receive a callback when the popup is dismissed.
     *
     * @param listener Listener that will be notified when the popup is dismissed.
     */
    override fun setOnDismissListener(listener: PopupWindow.OnDismissListener?) {
        mAnchoredPopupWindow.addOnDismissListener(listener)
    }

    /**
     * Sets the text direction in the dropdown. Should be called before show().
     * @param isRtl If true, then dropdown text direction is right to left.
     */
    override fun setRtl(isRtl: Boolean) {
        mRtl = isRtl
    }

    /**
     * Disable hiding on outside tap so that tapping on a text input field associated with the popup
     * will not hide the popup.
     */
    override fun disableHideOnOutsideTap() {
        mAnchoredPopupWindow.setDismissOnTouchInteraction(false)
    }

    /**
     * Sets the content description to be announced by accessibility services when the dropdown is
     * shown.
     * @param description The description of the content to be announced.
     */
    override fun setContentDescriptionForAccessibility(description: CharSequence?) {
        mDescription = description
    }

    /**
     * Sets a listener to receive events when a list item is clicked.
     *
     * @param clickListener Listener to register
     */
    override fun setOnItemClickListener(clickListener: OnItemClickListener?) {
        listView.onItemClickListener = clickListener
    }

    override fun setFooterView(footerView: View?) {
        val hasFooter = footerView != null
        val divider = mContentView.findViewById<View>(R.id.dropdown_body_footer_divider)
        divider.visibility = if (hasFooter) View.VISIBLE else View.GONE
        mFooterView.removeAllViews()
        if (hasFooter) {
            mFooterView.addView(footerView)
        }
    }

    /**
     * Show the popup. Will have no effect if the popup is already showing.
     * Post a [.show] call to the UI thread.
     */
    override fun postShow() {
        mAnchoredPopupWindow.show()
    }

    /**
     * Disposes of the popup window.
     */
    override fun dismiss() {
        mAnchoredPopupWindow.dismiss()
    }

    override val isShowing: Boolean
        /**
         * @return Whether the popup is currently showing.
         */
        get() = mAnchoredPopupWindow.isShowing

    /**
     * Measures the width of the list content. The adapter should not be null.
     * @return The popup window width in pixels.
     */
    private fun measureContentWidth(): Int {
        assert(mAdapter != null) { "Set the adapter before showing the popup." }
        val adapterWidth: Int = computeMaxWidthOfListAdapterItems(mAdapter)
        if (mFooterView.childCount > 0) {
            if (mFooterView.layoutParams == null) {
                mFooterView.layoutParams = FrameLayout.LayoutParams(
                    ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT
                )
            }
            val measureSpec = MeasureSpec.makeMeasureSpec(0, MeasureSpec.UNSPECIFIED)
            mFooterView.measure(measureSpec, measureSpec)
            return max(mFooterView.measuredWidth, adapterWidth)
        }
        return adapterWidth
    }
}