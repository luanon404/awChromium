// Copyright 2020 The Chromium Authors. All rights reserved.
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.
package org.chromium.base.compat

import android.annotation.TargetApi
import android.content.Context
import android.hardware.input.InputManager
import android.net.Uri
import android.os.Build
import android.os.storage.StorageManager
import android.view.Display
import android.view.InputEvent
import android.view.VerifiedInputEvent
import org.chromium.base.annotations.VerifiesOnR
import java.io.File

/**
 * Utility class to use new APIs that were added in R (API level 30). These need to exist in a
 * separate class so that Android framework can successfully verify classes without
 * encountering the new APIs.
 */
@VerifiesOnR
@TargetApi(Build.VERSION_CODES.R)
object ApiHelperForR {
    @JvmStatic
    @Throws(UnsupportedOperationException::class)
    fun getDisplay(context: Context): Display? {
        return context.display
    }

    /**
     * See [StorageManager.getStorageVolume].
     * See [File.getAbsolutePath].
     */
    @JvmStatic
    fun getVolumeDir(manager: StorageManager, uri: Uri?): File? {
        return manager.getStorageVolume(uri!!).directory
    }

    /**
     * See [InputManager.verifyInputEvent].
     */
    fun verifyInputEvent(manager: InputManager, inputEvent: InputEvent?): VerifiedInputEvent? {
        return manager.verifyInputEvent(inputEvent!!)
    }
}