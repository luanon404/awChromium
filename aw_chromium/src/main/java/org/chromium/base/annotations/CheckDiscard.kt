// Copyright 2019 The Chromium Authors. All rights reserved.
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.
package org.chromium.base.annotations

/**
 * Causes build to assert that annotated classes / methods / fields are
 * optimized away in release builds (without dcheck_always_on).
 *
 * Note that @RemovableInRelease implies @CheckDiscard.
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
annotation class CheckDiscard(
    /**
     * Describes why the element should be discarded.
     * @return reason for discarding (crbug links are preferred unless reason is trivial).
     */
    val value: String
)