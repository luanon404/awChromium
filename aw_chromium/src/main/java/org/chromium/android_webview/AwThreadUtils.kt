// Copyright 2020 The Chromium Authors. All rights reserved.
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.
package org.chromium.android_webview

import android.os.Handler
import android.os.Looper
import org.chromium.base.ThreadUtils

/**
 * Provides WebView-specific threading utilities.
 */
object AwThreadUtils {
    /**
     * Post a task to the current thread, ensuring that it runs on the underlying Android looper
     * without any native code present on the stack. This allows uncaught Java exceptions to be
     * handled correctly by Android's crash reporting mechanisms.
     */
    @JvmStatic
    fun postToCurrentLooper(r: Runnable?) {
        Handler(Looper.getMainLooper()).post(r!!)
    }

    /**
     * Post a task to the UI thread, ensuring that it runs on the underlying Android looper without
     * any native code present on the stack. This allows uncaught Java exceptions to be handled
     * correctly by Android's crash reporting mechanisms.
     */
    @JvmStatic
    fun postToUiThreadLooper(r: Runnable?) {
        ThreadUtils.getUiThreadHandler().post(r!!)
    }
}