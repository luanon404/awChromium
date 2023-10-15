// Copyright 2016 The Chromium Authors. All rights reserved.
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.
package org.chromium.ui

import org.chromium.android_webview.R

/**
 * Base implementation of DropdownItem which is used to get default settings to
 * show the item.
 */
open class DropdownItemBase : DropdownItem {
    override val label: String?
        get() = null
    override val sublabel: String?
        get() = null
    override val iconId: Int
        get() = 0
    override val itemTag: String?
        get() = null
    override val isEnabled: Boolean
        get() = true
    override val isGroupHeader: Boolean
        get() = false
    override val isMultilineLabel: Boolean
        get() = false
    override val isBoldLabel: Boolean
        get() = false
    override val labelFontColorResId: Int
        get() = R.color.default_text_color_list
    override val sublabelFontSizeResId: Int
        get() = R.dimen.text_size_small
    override val isIconAtStart: Boolean
        get() = false
    override val iconSizeResId: Int
        get() = 0
    override val iconMarginResId: Int
        get() = R.dimen.dropdown_icon_margin
}