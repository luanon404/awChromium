// Copyright 2012 The Chromium Authors. All rights reserved.
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.
package org.chromium.base.annotations

/**
 * Used by the JNI generator to create the necessary JNI bindings and expose this method to native
 * code.
 *
 *
 * Any uncaught Java exceptions will crash the current process. This is generally the desired
 * behavior, since most exceptions indicate an unexpected error. If your java method expects an
 * exception, we recommend refactoring to catch exceptions and indicate errors with special return
 * values instead. If this is not possible, see [CalledByNativeUnchecked] instead.
 */
@Target(
    AnnotationTarget.CONSTRUCTOR,
    AnnotationTarget.FUNCTION,
    AnnotationTarget.PROPERTY_GETTER,
    AnnotationTarget.PROPERTY_SETTER
)
@Retention(
    AnnotationRetention.BINARY
)
annotation class CalledByNative( /*
     *  If present, tells which inner class the method belongs to.
     */
                                 val value: String = ""
)