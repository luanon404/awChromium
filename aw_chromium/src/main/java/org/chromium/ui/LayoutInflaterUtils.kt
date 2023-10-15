// Copyright 2020 The Chromium Authors. All rights reserved.
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.
package org.chromium.ui

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import org.chromium.base.StrictModeContext

/**
 * [LayoutInflater] wrapper class which suppresses strict mode violations. A helper class is
 * used for strict mode suppression instead of
 * [org.chromium.components.strictmode.browser.ThreadStrictModeInterceptor.Builder]
 * because we only want to suppress strict mode violations caused by Chromium usage of
 * LayoutInflater and not usage by embedders of Web Layer or Web View.
 */
object LayoutInflaterUtils {
    @JvmOverloads
    fun inflate(
        context: Context?, resource: Int, root: ViewGroup?, attachToRoot: Boolean = root != null
    ): View {
        return inflateImpl(LayoutInflater.from(context), resource, root, attachToRoot)
    }

    @JvmOverloads
    fun inflate(
        window: Window, resource: Int, root: ViewGroup?, attachToRoot: Boolean = root != null
    ): View {
        return inflateImpl(window.layoutInflater, resource, root, attachToRoot)
    }

    private fun inflateImpl(
        inflater: LayoutInflater, resource: Int, root: ViewGroup?, attachToRoot: Boolean
    ): View {
        // LayoutInflater may trigger accessing disk.
        StrictModeContext.allowDiskReads()
            .use { return inflater.inflate(resource, root, attachToRoot) }
    }
}