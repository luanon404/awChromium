// ImageDecodeAcceleratorType.java is auto generated by mojom_bindings_generator.py, do not edit


// Copyright 2014 The Chromium Authors
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.

// This file is autogenerated by:
//     mojo/public/tools/bindings/mojom_bindings_generator.py
// For:
//     gpu/ipc/common/gpu_info.mojom
//

package org.chromium.gpu.mojom;

import androidx.annotation.IntDef;

public final class ImageDecodeAcceleratorType {
    private static final boolean IS_EXTENSIBLE = false;
    @IntDef({

        ImageDecodeAcceleratorType.JPEG,
        ImageDecodeAcceleratorType.WEB_P,
        ImageDecodeAcceleratorType.UNKNOWN})
    public @interface EnumType {}

    public static final int JPEG = 0;
    public static final int WEB_P = 1;
    public static final int UNKNOWN = 2;
    public static final int MIN_VALUE = 0;
    public static final int MAX_VALUE = 2;

    public static boolean isKnownValue(int value) {
        return value >= 0 && value <= 2;
    }

    public static void validate(int value) {
        if (IS_EXTENSIBLE || isKnownValue(value)) return;
        throw new org.chromium.mojo.bindings.DeserializationException("Invalid enum value.");
    }

    public static int toKnownValue(int value) {
      return value;
    }

    private ImageDecodeAcceleratorType() {}
}