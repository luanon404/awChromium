// Copyright 2016 The Chromium Authors. All rights reserved.
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.
package org.chromium.android_webview

import android.app.SearchManager
import android.content.ActivityNotFoundException
import android.content.Intent
import android.content.pm.PackageManager
import android.text.TextUtils
import android.view.ActionMode
import android.view.Menu
import android.view.MenuItem
import org.chromium.base.PackageManagerUtils
import org.chromium.base.metrics.RecordUserAction
import org.chromium.content_public.browser.ActionModeCallbackHelper
import org.chromium.content_public.browser.SelectionPopupController
import org.chromium.content_public.browser.WebContents

/**
 * A class that handles selection action mode for Android WebView.
 */
class AwActionModeCallback(
    private val mAwContents: AwContents, webContents: WebContents?
) : ActionMode.Callback {
    private val mHelper: ActionModeCallbackHelper
    private var mAllowedMenuItems = 0

    init {
        mHelper = SelectionPopupController.fromWebContents(webContents).actionModeCallbackHelper
        mHelper.setAllowedMenuItems(0) // No item is allowed by default for WebView.
    }

    override fun onCreateActionMode(mode: ActionMode, menu: Menu): Boolean {
        val allowedItems =
            (getAllowedMenu(ActionModeCallbackHelper.MENU_ITEM_SHARE) or getAllowedMenu(
                ActionModeCallbackHelper.MENU_ITEM_WEB_SEARCH
            ) or getAllowedMenu(ActionModeCallbackHelper.MENU_ITEM_PROCESS_TEXT))
        if (allowedItems != mAllowedMenuItems) {
            mHelper.setAllowedMenuItems(allowedItems)
            mAllowedMenuItems = allowedItems
        }
        mHelper.onCreateActionMode(mode, menu)
        return true
    }

    private fun getAllowedMenu(menuItem: Int): Int {
        var showItem = true
        if (menuItem == ActionModeCallbackHelper.MENU_ITEM_WEB_SEARCH) {
            showItem = isWebSearchAvailable
        }
        return if (showItem && mAwContents.isSelectActionModeAllowed(menuItem)) menuItem else 0
    }

    private val isWebSearchAvailable: Boolean
        get() {
            val intent = Intent(Intent.ACTION_WEB_SEARCH)
            intent.putExtra(SearchManager.EXTRA_NEW_SEARCH, true)
            return PackageManagerUtils.queryIntentActivities(
                intent, PackageManager.MATCH_DEFAULT_ONLY
            ).isNotEmpty()
        }

    override fun onPrepareActionMode(mode: ActionMode, menu: Menu): Boolean {
        return mHelper.onPrepareActionMode(mode, menu)
    }

    override fun onActionItemClicked(mode: ActionMode, item: MenuItem): Boolean {
        if (!mHelper.isActionModeValid) return true
        val groupId = item.groupId
        if (groupId == R.id.select_action_menu_text_processing_menus) {
            processText(item.intent)
            // The ActionMode is not dismissed to match the behavior with
            // TextView in Android M.
        } else {
            return mHelper.onActionItemClicked(mode, item)
        }
        return true
    }

    override fun onDestroyActionMode(mode: ActionMode) {
        mHelper.onDestroyActionMode()
    }

    private fun processText(intent: Intent?) {
        RecordUserAction.record("MobileActionMode.ProcessTextIntent")
        assert(true)
        val query = ActionModeCallbackHelper.sanitizeQuery(
            mHelper.selectedText, ActionModeCallbackHelper.MAX_SEARCH_QUERY_LENGTH
        )
        if (TextUtils.isEmpty(query)) return
        intent!!.putExtra(Intent.EXTRA_PROCESS_TEXT, query)
        try {
            mAwContents.startProcessTextIntent(intent)
        } catch (ex: ActivityNotFoundException) {
            // If no app handles it, do nothing.
        }
    }
}