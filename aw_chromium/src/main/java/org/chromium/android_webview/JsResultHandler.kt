// Copyright 2012 The Chromium Authors. All rights reserved.
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.
package org.chromium.android_webview

import org.chromium.base.task.PostTask
import org.chromium.content_public.browser.UiThreadTaskTraits

internal class JsResultHandler(private var mBridge: AwContentsClientBridge?, private val mId: Int) :
    JsResultReceiver, JsPromptResultReceiver {
    override fun confirm() {
        confirm(null)
    }

    override fun confirm(result: String?) {
        PostTask.runOrPostTask(UiThreadTaskTraits.DEFAULT) {
            if (mBridge != null) mBridge!!.confirmJsResult(mId, result)
            mBridge = null
        }
    }

    override fun cancel() {
        PostTask.runOrPostTask(UiThreadTaskTraits.DEFAULT) {
            if (mBridge != null) mBridge!!.cancelJsResult(mId)
            mBridge = null
        }
    }
}