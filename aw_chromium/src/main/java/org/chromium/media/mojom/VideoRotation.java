// VideoRotation.java is auto generated by mojom_bindings_generator.py, do not edit


// Copyright 2014 The Chromium Authors
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.

// This file is autogenerated by:
//     mojo/public/tools/bindings/mojom_bindings_generator.py
// For:
//     media/mojo/mojom/media_types.mojom
//

package org.chromium.media.mojom;

import androidx.annotation.IntDef;

public final class VideoRotation {
    private static final boolean IS_EXTENSIBLE = false;
    @IntDef({

        VideoRotation.VIDEO_ROTATION0,
        VideoRotation.VIDEO_ROTATION90,
        VideoRotation.VIDEO_ROTATION180,
        VideoRotation.VIDEO_ROTATION270})
    public @interface EnumType {}

    public static final int VIDEO_ROTATION0 = 0;
    public static final int VIDEO_ROTATION90 = 1;
    public static final int VIDEO_ROTATION180 = 2;
    public static final int VIDEO_ROTATION270 = 3;
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

    private VideoRotation() {}
}