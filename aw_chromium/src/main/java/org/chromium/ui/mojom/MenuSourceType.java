// MenuSourceType.java is auto generated by mojom_bindings_generator.py, do not edit


// Copyright 2014 The Chromium Authors
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.

// This file is autogenerated by:
//     mojo/public/tools/bindings/mojom_bindings_generator.py
// For:
//     ui/base/mojom/ui_base_types.mojom
//

package org.chromium.ui.mojom;

import androidx.annotation.IntDef;

public final class MenuSourceType {
    private static final boolean IS_EXTENSIBLE = true;

    @IntDef({MenuSourceType.NONE, MenuSourceType.MOUSE, MenuSourceType.KEYBOARD, MenuSourceType.TOUCH, MenuSourceType.TOUCH_EDIT_MENU, MenuSourceType.LONG_PRESS, MenuSourceType.LONG_TAP, MenuSourceType.TOUCH_HANDLE, MenuSourceType.STYLUS, MenuSourceType.ADJUST_SELECTION, MenuSourceType.ADJUST_SELECTION_RESET})
    public @interface EnumType {
    }

    public static final int NONE = 0;
    public static final int MOUSE = 1;
    public static final int KEYBOARD = 2;
    public static final int TOUCH = 3;
    public static final int TOUCH_EDIT_MENU = 4;
    public static final int LONG_PRESS = 5;
    public static final int LONG_TAP = 6;
    public static final int TOUCH_HANDLE = 7;
    public static final int STYLUS = 8;
    public static final int ADJUST_SELECTION = 9;
    public static final int ADJUST_SELECTION_RESET = 10;
    public static final int MIN_VALUE = 0;
    public static final int MAX_VALUE = 10;
    public static final int DEFAULT_VALUE = 0;

    public static boolean isKnownValue(int value) {
        return value >= 0 && value <= 10;
    }

    public static void validate(int value) {
        if (IS_EXTENSIBLE || isKnownValue(value)) return;
        throw new org.chromium.mojo.bindings.DeserializationException("Invalid enum value.");
    }

    public static int toKnownValue(int value) {
        if (isKnownValue(value)) {
            return value;
        }
        return DEFAULT_VALUE;
    }

    private MenuSourceType() {
    }
}