// PreferredContrast.java is auto generated by mojom_bindings_generator.py, do not edit


// Copyright 2014 The Chromium Authors
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.

// This file is autogenerated by:
//     mojo/public/tools/bindings/mojom_bindings_generator.py
// For:
//     third_party/blink/public/mojom/css/preferred_contrast.mojom
//

package org.chromium.blink.mojom;

import androidx.annotation.IntDef;

public final class PreferredContrast {
    private static final boolean IS_EXTENSIBLE = false;
    @IntDef({

        PreferredContrast.MORE,
        PreferredContrast.LESS,
        PreferredContrast.NO_PREFERENCE,
        PreferredContrast.CUSTOM})
    public @interface EnumType {}

    public static final int MORE = 0;
    public static final int LESS = 1;
    public static final int NO_PREFERENCE = 2;
    public static final int CUSTOM = 3;
    public static final int MIN_VALUE = 0;
    public static final int MAX_VALUE = 3;

    public static boolean isKnownValue(int value) {
        return value >= 0 && value <= 3;
    }

    public static void validate(int value) {
        if (IS_EXTENSIBLE || isKnownValue(value)) return;
        throw new org.chromium.mojo.bindings.DeserializationException("Invalid enum value.");
    }

    public static int toKnownValue(int value) {
      return value;
    }

    private PreferredContrast() {}
}