// Copyright 2012 The Chromium Authors. All rights reserved.
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.
package org.chromium.base.annotations

/**
 * Similar to [CalledByNative], this also exposes JNI bindings to native code. The main
 * difference is this **will not** crash the browser process if the Java method throws an
 * exception. However, the C++ caller **must** handle and clear the exception before calling into
 * any other Java code, otherwise the next Java method call will crash (with the previous call's
 * exception, which leads to a very confusing debugging experience).
 *
 *
 * Usage of this annotation should be very rare; due to the complexity of correctly handling
 * exceptions in C++, prefer using [CalledByNative].
 */
@Target(
    AnnotationTarget.FUNCTION,
    AnnotationTarget.PROPERTY_GETTER,
    AnnotationTarget.PROPERTY_SETTER
)
@Retention(
    AnnotationRetention.BINARY
)
annotation class CalledByNativeUnchecked( /*
     *  If present, tells which inner class the method belongs to.
     */
                                          val value: String = ""
)