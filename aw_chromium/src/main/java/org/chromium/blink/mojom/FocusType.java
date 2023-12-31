// FocusType.java is auto generated by mojom_bindings_generator.py, do not edit


// Copyright 2014 The Chromium Authors
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.

// This file is autogenerated by:
//     mojo/public/tools/bindings/mojom_bindings_generator.py
// For:
//     third_party/blink/public/mojom/input/focus_type.mojom
//

package org.chromium.blink.mojom;

import androidx.annotation.IntDef;

public final class FocusType {
    private static final boolean IS_EXTENSIBLE = false;
    @IntDef({

        FocusType.NONE,
        FocusType.SCRIPT,
        FocusType.FORWARD,
        FocusType.BACKWARD,
        FocusType.SPATIAL_NAVIGATION,
        FocusType.MOUSE,
        FocusType.ACCESS_KEY,
        FocusType.PAGE})
    public @interface EnumType {}

    public static final int NONE = 0;
    public static final int SCRIPT = 1;
    public static final int FORWARD = 2;
    public static final int BACKWARD = 3;
    public static final int SPATIAL_NAVIGATION = 4;
    public static final int MOUSE = 5;
    public static final int ACCESS_KEY = 6;
    public static final int PAGE = 7;
    public static final int MIN_VALUE = 0;
    public static final int MAX_VALUE = 7;

    public static boolean isKnownValue(int value) {
        return value >= 0 && value <= 7;
    }

    public static void validate(int value) {
        if (IS_EXTENSIBLE || isKnownValue(value)) return;
        throw new org.chromium.mojo.bindings.DeserializationException("Invalid enum value.");
    }

    public static int toKnownValue(int value) {
      return value;
    }

    private FocusType() {}
}