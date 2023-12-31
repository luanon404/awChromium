// VideoDecoderType.java is auto generated by mojom_bindings_generator.py, do not edit


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

public final class VideoDecoderType {
    private static final boolean IS_EXTENSIBLE = true;
    @IntDef({

        VideoDecoderType.UNKNOWN,
        VideoDecoderType.VAAPI,
        VideoDecoderType.VDA,
        VideoDecoderType.V4L2,
        VideoDecoderType.TESTING})
    public @interface EnumType {}

    public static final int UNKNOWN = 0;
    public static final int VAAPI = 1;
    public static final int VDA = 2;
    public static final int V4L2 = 3;
    public static final int TESTING = 4;
    public static final int MIN_VALUE = 0;
    public static final int MAX_VALUE = 4;
    public static final int DEFAULT_VALUE = 0;

    public static boolean isKnownValue(int value) {
        return value >= 0 && value <= 4;
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

    private VideoDecoderType() {}
}