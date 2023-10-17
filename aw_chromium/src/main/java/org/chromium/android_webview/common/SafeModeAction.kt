// Copyright 2021 The Chromium Authors. All rights reserved.
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.
package org.chromium.android_webview.common

/**
 * An interface for defining a precaution WebView may take during SafeMode.
 */
interface SafeModeAction {
    /**
     * Returns a unique identifier for this action. This must not be used by any other registered
     * action.
     */
    val id: String

    /**
     * Executes the given action. Implementations of this method should be  Java-only (no JNI/C++)
     * because the native library may not yet be loaded.
     */
    fun execute()
}