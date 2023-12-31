// ColorSpacePrimaryId.java is auto generated by mojom_bindings_generator.py, do not edit


// Copyright 2014 The Chromium Authors
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.

// This file is autogenerated by:
//     mojo/public/tools/bindings/mojom_bindings_generator.py
// For:
//     media/mojo/mojom/stable/stable_video_decoder_types.mojom
//

package org.chromium.media.stable.mojom;

import androidx.annotation.IntDef;

public final class ColorSpacePrimaryId {
    private static final boolean IS_EXTENSIBLE = true;
    @IntDef({

        ColorSpacePrimaryId.INVALID,
        ColorSpacePrimaryId.BT709,
        ColorSpacePrimaryId.BT470M,
        ColorSpacePrimaryId.BT470BG,
        ColorSpacePrimaryId.SMPTE170M,
        ColorSpacePrimaryId.SMPTE240M,
        ColorSpacePrimaryId.FILM,
        ColorSpacePrimaryId.BT2020,
        ColorSpacePrimaryId.SMPTEST428_1,
        ColorSpacePrimaryId.SMPTEST431_2,
        ColorSpacePrimaryId.SMPTEST432_1,
        ColorSpacePrimaryId.XYZ_D50,
        ColorSpacePrimaryId.ADOBE_RGB,
        ColorSpacePrimaryId.APPLE_GENERIC_RGB,
        ColorSpacePrimaryId.WIDE_GAMUT_COLOR_SPIN,
        ColorSpacePrimaryId.CUSTOM})
    public @interface EnumType {}

    public static final int INVALID = 0;
    public static final int BT709 = 1;
    public static final int BT470M = 2;
    public static final int BT470BG = 3;
    public static final int SMPTE170M = 4;
    public static final int SMPTE240M = 5;
    public static final int FILM = 6;
    public static final int BT2020 = 7;
    public static final int SMPTEST428_1 = 8;
    public static final int SMPTEST431_2 = 9;
    public static final int SMPTEST432_1 = 10;
    public static final int XYZ_D50 = 11;
    public static final int ADOBE_RGB = 12;
    public static final int APPLE_GENERIC_RGB = 13;
    public static final int WIDE_GAMUT_COLOR_SPIN = 14;
    public static final int CUSTOM = 15;
    public static final int MIN_VALUE = 0;
    public static final int MAX_VALUE = 15;
    public static final int DEFAULT_VALUE = 0;

    public static boolean isKnownValue(int value) {
        return value >= 0 && value <= 15;
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

    private ColorSpacePrimaryId() {}
}