// Copyright 2014 The Chromium Authors. All rights reserved.
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.
package org.chromium.base.library_loader

import androidx.annotation.IntDef

/**
 * These are the possible failures from the LibraryLoader
 */
@IntDef(
    LoaderErrors.NORMAL_COMPLETION,
    LoaderErrors.FAILED_TO_REGISTER_JNI,
    LoaderErrors.NATIVE_LIBRARY_LOAD_FAILED,
    LoaderErrors.NATIVE_LIBRARY_WRONG_VERSION,
    LoaderErrors.NATIVE_STARTUP_FAILED
)
@Retention(
    AnnotationRetention.SOURCE
)
annotation class LoaderErrors {
    companion object {
        const val NORMAL_COMPLETION = 0
        const val FAILED_TO_REGISTER_JNI = 1
        const val NATIVE_LIBRARY_LOAD_FAILED = 2
        const val NATIVE_LIBRARY_WRONG_VERSION = 3
        const val NATIVE_STARTUP_FAILED = 4
    }
}