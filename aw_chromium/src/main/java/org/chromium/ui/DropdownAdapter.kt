// Copyright 2014 The Chromium Authors. All rights reserved.
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.
package org.chromium.ui

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Color
import android.graphics.Typeface
import android.text.TextUtils
import android.util.TypedValue
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.ViewGroup.MarginLayoutParams
import android.widget.AbsListView
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.content.res.AppCompatResources
import androidx.core.view.MarginLayoutParamsCompat
import androidx.core.view.ViewCompat
import org.chromium.android_webview.R
import org.chromium.base.ApiCompatibilityUtils

/**
 * Dropdown item adapter for DropdownPopupWindow.
 * @param mContext Application Context.
 * @param items List of labels and icons to display.
 * @param separators Set of positions that separate `items`.
 */
class DropdownAdapter(
    private val mContext: Context, items: List<DropdownItem?>?, separators: Set<Int>?
) : ArrayAdapter<DropdownItem?>(
    mContext, R.layout.dropdown_item
) {
    private val mSeparators: Set<Int>?
    private val mAreAllItemsEnabled: Boolean
    private val mLabelMargin: Int


    init {
        addAll(items!!)
        mSeparators = separators
        mAreAllItemsEnabled = checkAreAllItemsEnabled()
        mLabelMargin = mContext.resources.getDimensionPixelSize(R.dimen.dropdown_item_label_margin)
    }

    private fun checkAreAllItemsEnabled(): Boolean {
        for (i in 0 until count) {
            val item = getItem(i)
            if (item!!.isEnabled && !item.isGroupHeader) {
                return false
            }
        }
        return true
    }

    @SuppressLint("InflateParams")
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var layout = convertView
        if (convertView == null) {
            val inflater =
                mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            layout = inflater.inflate(R.layout.dropdown_item, null)
            layout.background = DropdownDividerDrawable( /*backgroundColor=*/null)
        }
        val divider = layout!!.background as DropdownDividerDrawable
        var height = mContext.resources.getDimensionPixelSize(R.dimen.dropdown_item_height)
        if (position == 0) {
            divider.setDividerColor(Color.TRANSPARENT)
        } else {
            val dividerHeight = mContext.resources.getDimensionPixelSize(
                R.dimen.dropdown_item_divider_height
            )
            height += dividerHeight
            divider.setHeight(dividerHeight)
            val dividerColor: Int = if (mSeparators != null && mSeparators.contains(position)) {
                ApiCompatibilityUtils.getColor(
                    mContext.resources, R.color.dropdown_dark_divider_color
                )
            } else {
                ApiCompatibilityUtils.getColor(
                    mContext.resources, R.color.dropdown_divider_color
                )
            }
            divider.setDividerColor(dividerColor)
        }
        val item = getItem(position)

        // Note: trying to set the height of the root LinearLayout breaks accessibility,
        // so we have to adjust the height of this LinearLayout that wraps the TextViews instead.
        // If you need to modify this layout, don't forget to test it with TalkBack and make sure
        // it doesn't regress.
        // http://crbug.com/429364
        val wrapper = layout.findViewById<View>(R.id.dropdown_label_wrapper) as LinearLayout
        if (item!!.isMultilineLabel) height = AbsListView.LayoutParams.WRAP_CONTENT
        wrapper.orientation = LinearLayout.VERTICAL
        wrapper.layoutParams = LinearLayout.LayoutParams(0, height, 1f)

        // Layout of the main label view.
        val labelView = layout.findViewById<View>(R.id.dropdown_label) as TextView
        labelView.text = item.label
        labelView.isSingleLine = !item.isMultilineLabel
        if (item.isMultilineLabel) {
            // If there is a multiline label, we add extra padding at the top and bottom because
            // WRAP_CONTENT, defined above for multiline labels, leaves none.
            val existingStart = ViewCompat.getPaddingStart(labelView)
            val existingEnd = ViewCompat.getPaddingEnd(labelView)
            ViewCompat.setPaddingRelative(
                labelView, existingStart, mLabelMargin, existingEnd, mLabelMargin
            )
        }
        labelView.isEnabled = item.isEnabled
        if (item.isGroupHeader || item.isBoldLabel) {
            labelView.setTypeface(null, Typeface.BOLD)
        } else {
            labelView.setTypeface(null, Typeface.NORMAL)
        }
        labelView.setTextColor(
            ApiCompatibilityUtils.getColor(
                mContext.resources, item.labelFontColorResId
            )
        )
        labelView.setTextSize(
            TypedValue.COMPLEX_UNIT_PX, mContext.resources.getDimension(R.dimen.text_size_large)
        )

        // Layout of the sublabel view, which has a smaller font and usually sits below the main
        // label.
        val sublabelView = layout.findViewById<View>(R.id.dropdown_sublabel) as TextView
        val sublabel: CharSequence? = item.sublabel
        if (TextUtils.isEmpty(sublabel)) {
            sublabelView.visibility = View.GONE
        } else {
            sublabelView.text = sublabel
            sublabelView.setTextSize(
                TypedValue.COMPLEX_UNIT_PX,
                mContext.resources.getDimension(item.sublabelFontSizeResId)
            )
            sublabelView.visibility = View.VISIBLE
        }
        val iconViewStart = layout.findViewById<View>(R.id.start_dropdown_icon) as ImageView
        val iconViewEnd = layout.findViewById<View>(R.id.end_dropdown_icon) as ImageView
        if (item.isIconAtStart) {
            iconViewEnd.visibility = View.GONE
        } else {
            iconViewStart.visibility = View.GONE
        }
        val iconView = if (item.isIconAtStart) iconViewStart else iconViewEnd
        if (item.iconId == DropdownItem.NO_ICON) {
            iconView.visibility = View.GONE
        } else {
            val iconSizeResId = item.iconSizeResId
            val iconSize =
                if (iconSizeResId == 0) AbsListView.LayoutParams.WRAP_CONTENT else mContext.resources.getDimensionPixelSize(
                    iconSizeResId
                )
            val iconLayoutParams = iconView.layoutParams as MarginLayoutParams
            iconLayoutParams.width = iconSize
            iconLayoutParams.height = iconSize
            val iconMargin = mContext.resources.getDimensionPixelSize(item.iconMarginResId)
            MarginLayoutParamsCompat.setMarginStart(iconLayoutParams, iconMargin)
            MarginLayoutParamsCompat.setMarginEnd(iconLayoutParams, iconMargin)
            iconView.layoutParams = iconLayoutParams
            iconView.setImageDrawable(AppCompatResources.getDrawable(mContext, item.iconId))
            iconView.visibility = View.VISIBLE
        }
        return layout
    }

    override fun areAllItemsEnabled(): Boolean {
        return mAreAllItemsEnabled
    }

    override fun isEnabled(position: Int): Boolean {
        if (position < 0 || position >= count) return false
        val item = getItem(position)
        return item!!.isEnabled && !item.isGroupHeader
    }
}