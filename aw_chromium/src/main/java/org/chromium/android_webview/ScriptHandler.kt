// Copyright 2020 The Chromium Authors. All rights reserved.
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.
package org.chromium.android_webview

import org.chromium.base.ThreadUtils
import java.lang.ref.WeakReference

/**
 * Used for Js Java interaction, to delete the document start JavaScript snippet.
 */
class ScriptHandler(awContents: AwContents?, scriptId: Int) {
    private val mAwContentsRef: WeakReference<AwContents?>
    private val mScriptId: Int

    init {
        assert(scriptId >= 0)
        mAwContentsRef = WeakReference<AwContents?>(awContents)
        mScriptId = scriptId
    }

    // Must be called on UI thread.
    fun remove() {
        ThreadUtils.checkUiThread()
        val awContents = mAwContentsRef.get() ?: return
        awContents.removeDocumentStartJavaScript(mScriptId)
    }
}