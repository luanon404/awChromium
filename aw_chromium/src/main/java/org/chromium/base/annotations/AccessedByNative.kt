// Copyright 2012 The Chromium Authors. All rights reserved.
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.
package org.chromium.base.annotations

/**
 * Applied to fields that are accessed from native via JNI. Causes R8 to not
 * rename them.
 */
@Target(AnnotationTarget.FIELD)
@Retention(AnnotationRetention.BINARY)
annotation class AccessedByNative(val value: String = "")