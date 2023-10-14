// Copyright 2020 The Chromium Authors. All rights reserved.
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.
package org.chromium.base.annotations

/**
 * Annotation used to mark field that may contain Strings referring to fully qualified class names
 * and methods whose arguments may be fully qualified class names. These classes may then be
 * obfuscated by R8. A couple caveats when using this:
 * - This only obfuscates the string, it does not actually check that the class exists.
 * - If a field has this annotation, it must be non-final, otherwise javac will inline the constant
 * and R8 won't obfuscate it.
 * - Any field/method must be assigned/called with a String literal or a variable R8 can easily
 * trace to a String literal.
 *
 *
 * Usage example:<br></br>
 * `public static final String LOGGING_TAG = "com.google.android.apps.foo.FooActivity";
 *
 * // In this example, both className and message are treated as identifier name strings, but will
 * // only be obfuscated if the string points to a real class.
 *
 * public void doSomeLogging(String className, String message) { ... }
` *
 */
@Target(
    AnnotationTarget.FIELD,
    AnnotationTarget.FUNCTION,
    AnnotationTarget.PROPERTY_GETTER,
    AnnotationTarget.PROPERTY_SETTER
)
@Retention(
    AnnotationRetention.BINARY
)
annotation class IdentifierNameString 