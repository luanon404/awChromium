// Copyright 2021 The Chromium Authors. All rights reserved.
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.
package org.chromium.android_webview.variations

import org.chromium.android_webview.common.SafeModeAction
import org.chromium.android_webview.common.variations.VariationsUtils.newSeedFile
import org.chromium.android_webview.common.variations.VariationsUtils.seedFile
import org.chromium.android_webview.common.variations.VariationsUtils.stampFile
import org.chromium.base.Log
import java.io.File

/**
 * A [SafeModeAction] to delete the variations seed.
 */
class VariationsSeedSafeModeAction : SafeModeAction {
    override val id: String
        get() = "delete_variations_seed"

    override fun execute() {
        deleteIfExists(seedFile)
        deleteIfExists(newSeedFile)
        deleteIfExists(stampFile)
    }

    companion object {
        private const val TAG = "WebViewSafeMode"

        private fun deleteIfExists(file: File) {
            if (!file.exists()) {
                Log.i(TAG, "File does not exist (skipping): %s", file)
                return
            }
            if (file.delete()) {
                Log.i(TAG, "Successfully deleted %s", file)
            } else {
                Log.e(TAG, "Failed to delete %s", file)
            }
        }
    }
}