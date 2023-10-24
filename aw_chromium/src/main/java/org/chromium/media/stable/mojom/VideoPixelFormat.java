// VideoPixelFormat.java is auto generated by mojom_bindings_generator.py, do not edit


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

public final class VideoPixelFormat {
    private static final boolean IS_EXTENSIBLE = true;

    @IntDef({VideoPixelFormat.PIXEL_FORMAT_UNKNOWN, VideoPixelFormat.PIXEL_FORMAT_I420, VideoPixelFormat.PIXEL_FORMAT_YV12, VideoPixelFormat.PIXEL_FORMAT_I422, VideoPixelFormat.PIXEL_FORMAT_I420A, VideoPixelFormat.PIXEL_FORMAT_I444, VideoPixelFormat.PIXEL_FORMAT_NV12, VideoPixelFormat.PIXEL_FORMAT_NV21, VideoPixelFormat.PIXEL_FORMAT_UYVY, VideoPixelFormat.PIXEL_FORMAT_YUY2, VideoPixelFormat.PIXEL_FORMAT_ARGB, VideoPixelFormat.PIXEL_FORMAT_XRGB, VideoPixelFormat.PIXEL_FORMAT_RGB24, VideoPixelFormat.PIXEL_FORMAT_MJPEG, VideoPixelFormat.PIXEL_FORMAT_YUV420P9, VideoPixelFormat.PIXEL_FORMAT_YUV420P10, VideoPixelFormat.PIXEL_FORMAT_YUV422P9, VideoPixelFormat.PIXEL_FORMAT_YUV422P10, VideoPixelFormat.PIXEL_FORMAT_YUV444P9, VideoPixelFormat.PIXEL_FORMAT_YUV444P10, VideoPixelFormat.PIXEL_FORMAT_YUV420P12, VideoPixelFormat.PIXEL_FORMAT_YUV422P12, VideoPixelFormat.PIXEL_FORMAT_YUV444P12, VideoPixelFormat.PIXEL_FORMAT_Y16, VideoPixelFormat.PIXEL_FORMAT_ABGR, VideoPixelFormat.PIXEL_FORMAT_XBGR, VideoPixelFormat.PIXEL_FORMAT_P016LE, VideoPixelFormat.PIXEL_FORMAT_XR30, VideoPixelFormat.PIXEL_FORMAT_XB30, VideoPixelFormat.PIXEL_FORMAT_BGRA, VideoPixelFormat.PIXEL_FORMAT_RGBAF16, VideoPixelFormat.PIXEL_FORMAT_I422A, VideoPixelFormat.PIXEL_FORMAT_I444A, VideoPixelFormat.PIXEL_FORMAT_YUV420AP10, VideoPixelFormat.PIXEL_FORMAT_YUV422AP10, VideoPixelFormat.PIXEL_FORMAT_YUV444AP10, VideoPixelFormat.PIXEL_FORMAT_NV12A})
    public @interface EnumType {
    }

    public static final int PIXEL_FORMAT_UNKNOWN = 0;
    public static final int PIXEL_FORMAT_I420 = 1;
    public static final int PIXEL_FORMAT_YV12 = 2;
    public static final int PIXEL_FORMAT_I422 = 3;
    public static final int PIXEL_FORMAT_I420A = 4;
    public static final int PIXEL_FORMAT_I444 = 5;
    public static final int PIXEL_FORMAT_NV12 = 6;
    public static final int PIXEL_FORMAT_NV21 = 7;
    public static final int PIXEL_FORMAT_UYVY = 8;
    public static final int PIXEL_FORMAT_YUY2 = 9;
    public static final int PIXEL_FORMAT_ARGB = 10;
    public static final int PIXEL_FORMAT_XRGB = 11;
    public static final int PIXEL_FORMAT_RGB24 = 12;
    public static final int PIXEL_FORMAT_MJPEG = 14;
    public static final int PIXEL_FORMAT_YUV420P9 = 16;
    public static final int PIXEL_FORMAT_YUV420P10 = 17;
    public static final int PIXEL_FORMAT_YUV422P9 = 18;
    public static final int PIXEL_FORMAT_YUV422P10 = 19;
    public static final int PIXEL_FORMAT_YUV444P9 = 20;
    public static final int PIXEL_FORMAT_YUV444P10 = 21;
    public static final int PIXEL_FORMAT_YUV420P12 = 22;
    public static final int PIXEL_FORMAT_YUV422P12 = 23;
    public static final int PIXEL_FORMAT_YUV444P12 = 24;
    public static final int PIXEL_FORMAT_Y16 = 26;
    public static final int PIXEL_FORMAT_ABGR = 27;
    public static final int PIXEL_FORMAT_XBGR = 28;
    public static final int PIXEL_FORMAT_P016LE = 29;
    public static final int PIXEL_FORMAT_XR30 = 30;
    public static final int PIXEL_FORMAT_XB30 = 31;
    public static final int PIXEL_FORMAT_BGRA = 32;
    public static final int PIXEL_FORMAT_RGBAF16 = 33;
    public static final int PIXEL_FORMAT_I422A = 34;
    public static final int PIXEL_FORMAT_I444A = 35;
    public static final int PIXEL_FORMAT_YUV420AP10 = 36;
    public static final int PIXEL_FORMAT_YUV422AP10 = 37;
    public static final int PIXEL_FORMAT_YUV444AP10 = 38;
    public static final int PIXEL_FORMAT_NV12A = 39;
    public static final int MIN_VALUE = 0;
    public static final int MAX_VALUE = 39;
    public static final int DEFAULT_VALUE = 0;

    public static boolean isKnownValue(int value) {
        switch (value) {
            case 0:
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            case 14:
            case 16:
            case 17:
            case 18:
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
            case 24:
            case 26:
            case 27:
            case 28:
            case 29:
            case 30:
            case 31:
            case 32:
            case 33:
            case 34:
            case 35:
            case 36:
            case 37:
            case 38:
            case 39:
                return true;
        }
        return false;
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

    private VideoPixelFormat() {
    }
}