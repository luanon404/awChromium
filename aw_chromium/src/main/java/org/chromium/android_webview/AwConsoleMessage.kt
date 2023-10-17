// Copyright 2017 The Chromium Authors. All rights reserved.
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.
package org.chromium.android_webview

import androidx.annotation.IntDef
import androidx.annotation.Keep

/**
 *
 * See [android.webkit.ConsoleMessage].  */
class AwConsoleMessage(
    private val mMessage: String,
    @field:MessageLevel @param:MessageLevel private val mLevel: Int
) {
    @Retention(AnnotationRetention.SOURCE)
    @IntDef(
        MESSAGE_LEVEL_TIP,
        MESSAGE_LEVEL_LOG,
        MESSAGE_LEVEL_WARNING,
        MESSAGE_LEVEL_ERROR,
        MESSAGE_LEVEL_DEBUG
    )
    annotation class MessageLevel

    @Keep
    @MessageLevel
    fun messageLevel(): Int {
        /** I don't know this is important or not */
        return mLevel
    }

    fun message(): String {
        return mMessage
    }

    companion object {
        const val MESSAGE_LEVEL_TIP = 0
        const val MESSAGE_LEVEL_LOG = 1
        const val MESSAGE_LEVEL_WARNING = 2
        const val MESSAGE_LEVEL_ERROR = 3
        const val MESSAGE_LEVEL_DEBUG = 4
    }
}