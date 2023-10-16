// AlphaType.java is auto generated by mojom_bindings_generator.py, do not edit
// Copyright 2014 The Chromium Authors. All rights reserved.
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.
// This file is autogenerated by:
//     mojo/public/tools/bindings/mojom_bindings_generator.py
// For:
//     skia/public/mojom/image_info.mojom
//
package org.chromium.skia.mojom

import androidx.annotation.IntDef
import org.chromium.mojo.bindings.DeserializationException

object AlphaType {
    private const val IS_EXTENSIBLE = false
    const val UNKNOWN = 0
    const val ALPHA_TYPE_OPAQUE = 1
    const val PREMUL = 2
    const val UNPREMUL = 3
    const val MIN_VALUE = 0
    const val MAX_VALUE = 3
    fun isKnownValue(value: Int): Boolean {
        return value in 0..3
    }

    fun validate(value: Int) {
        if (IS_EXTENSIBLE || isKnownValue(value)) return
        throw DeserializationException("Invalid enum value.")
    }

    fun toKnownValue(value: Int): Int {
        return value
    }

    @IntDef(UNKNOWN, ALPHA_TYPE_OPAQUE, PREMUL, UNPREMUL)
    annotation class EnumType
}