// Copyright 2014 The Chromium Authors. All rights reserved.
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.
package org.chromium.base.annotations

/**
 * Annotation used for marking methods and fields that are called by reflection.
 * Useful for keeping components that would otherwise be removed by Proguard.
 * Use the value parameter to mention a file that calls this method.
 *
 * Note that adding this annotation to a method is not enough to guarantee that
 * it is kept - either its class must be referenced elsewhere in the program, or
 * the class must be annotated with this as well.
 */
@Target(
    AnnotationTarget.FUNCTION,
    AnnotationTarget.PROPERTY_GETTER,
    AnnotationTarget.PROPERTY_SETTER,
    AnnotationTarget.FIELD,
    AnnotationTarget.CLASS,
    AnnotationTarget.CONSTRUCTOR
)
annotation class UsedByReflection(val value: String)