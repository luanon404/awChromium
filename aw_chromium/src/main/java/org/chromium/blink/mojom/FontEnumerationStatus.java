// FontEnumerationStatus.java is auto generated by mojom_bindings_generator.py, do not edit


// Copyright 2014 The Chromium Authors
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.

// This file is autogenerated by:
//     mojo/public/tools/bindings/mojom_bindings_generator.py
// For:
//     third_party/blink/public/mojom/font_access/font_access.mojom
//

package org.chromium.blink.mojom;

import androidx.annotation.IntDef;

public final class FontEnumerationStatus {
    private static final boolean IS_EXTENSIBLE = false;
    @IntDef({

        FontEnumerationStatus.OK,
        FontEnumerationStatus.UNIMPLEMENTED,
        FontEnumerationStatus.UNEXPECTED_ERROR,
        FontEnumerationStatus.NEEDS_USER_ACTIVATION,
        FontEnumerationStatus.NOT_VISIBLE,
        FontEnumerationStatus.PERMISSION_DENIED})
    public @interface EnumType {}

    public static final int OK = 0;
    public static final int UNIMPLEMENTED = 1;
    public static final int UNEXPECTED_ERROR = 2;
    public static final int NEEDS_USER_ACTIVATION = 3;
    public static final int NOT_VISIBLE = 4;
    public static final int PERMISSION_DENIED = 5;
    public static final int MIN_VALUE = 0;
    public static final int MAX_VALUE = 5;

    public static boolean isKnownValue(int value) {
        return value >= 0 && value <= 5;
    }

    public static void validate(int value) {
        if (IS_EXTENSIBLE || isKnownValue(value)) return;
        throw new org.chromium.mojo.bindings.DeserializationException("Invalid enum value.");
    }

    public static int toKnownValue(int value) {
      return value;
    }

    private FontEnumerationStatus() {}
}