// Copyright 2012 The Chromium Authors. All rights reserved.
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.
package org.chromium.base.annotations

/**
 * @JNINamespace is used by the JNI generator to create the necessary JNI
 * bindings and expose this method to native code using the specified namespace.
 */
@Target(AnnotationTarget.CLASS)
@Retention(AnnotationRetention.RUNTIME)
annotation class JNINamespace(val value: String)