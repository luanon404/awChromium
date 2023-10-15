// Copyright 2014 The Chromium Authors. All rights reserved.
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.
package org.chromium.ui

/**
 * Dropdown item interface used to access all the information needed to show the item.
 */
interface DropdownItem {
    /**
     * Returns the label that should be shown in the dropdown.
     */
    val label: String?

    /**
     * Returns the sublabel that should be shown in the dropdown.
     */
    val sublabel: String?

    /**
     * Returns the item tag that should be shown in the dropdown.
     */
    val itemTag: String?

    /**
     * Returns the drawable id of the icon that should be shown in the dropdown, or NO_ICON.
     */
    val iconId: Int

    /**
     * Returns true if the item should be enabled in the dropdown.
     */
    val isEnabled: Boolean

    /**
     * Returns true if the item should be a group header in the dropdown.
     */
    val isGroupHeader: Boolean

    /**
     * Returns whether the label should be displayed over multiple lines.
     */
    val isMultilineLabel: Boolean

    /**
     * Returns whether the label should be displayed in bold.
     */
    val isBoldLabel: Boolean

    /**
     * Returns resource ID of label's font color.
     */
    val labelFontColorResId: Int

    /**
     * Returns resource ID of sublabel's font size.
     */
    val sublabelFontSizeResId: Int

    /**
     * Returns whether the icon should be displayed at the start, before label
     * and sublabel.
     */
    val isIconAtStart: Boolean

    /**
     * Returns the resource ID of the icon's size, or 0 to use WRAP_CONTENT.
     */
    val iconSizeResId: Int

    /**
     * Returns the resource ID of the icon's margin size.
     */
    val iconMarginResId: Int

    companion object {
        // A stand in for a resource ID which indicates no icon should be shown.
        const val NO_ICON = 0
    }
}