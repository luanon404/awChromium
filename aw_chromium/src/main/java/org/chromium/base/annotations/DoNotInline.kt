// Copyright 2018 The Chromium Authors. All rights reserved.
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.
package org.chromium.base.annotations

/**
 * The annotated method or class should never be inlined.
 *
 * The annotated method (or methods on the annotated class) are guaranteed not to be inlined by
 * Proguard. Other optimizations may still apply. Do not use this annotation to fix class
 * verification errors - use the @VerifiesOnX annotations instead.
 */
@Target(
    AnnotationTarget.CONSTRUCTOR,
    AnnotationTarget.FIELD,
    AnnotationTarget.FUNCTION,
    AnnotationTarget.PROPERTY_GETTER,
    AnnotationTarget.PROPERTY_SETTER,
    AnnotationTarget.CLASS
)
@Retention(
    AnnotationRetention.BINARY
)
annotation class DoNotInline 