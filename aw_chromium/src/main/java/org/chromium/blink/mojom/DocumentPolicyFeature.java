// DocumentPolicyFeature.java is auto generated by mojom_bindings_generator.py, do not edit


// Copyright 2014 The Chromium Authors
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.

// This file is autogenerated by:
//     mojo/public/tools/bindings/mojom_bindings_generator.py
// For:
//     third_party/blink/public/mojom/permissions_policy/document_policy_feature.mojom
//

package org.chromium.blink.mojom;

import androidx.annotation.IntDef;

public final class DocumentPolicyFeature {
    private static final boolean IS_EXTENSIBLE = false;
    @IntDef({

        DocumentPolicyFeature.DEFAULT,
        DocumentPolicyFeature.FONT_DISPLAY,
        DocumentPolicyFeature.LOSSLESS_IMAGES_MAX_BPP,
        DocumentPolicyFeature.FORCE_LOAD_AT_TOP,
        DocumentPolicyFeature.LOSSLESS_IMAGES_STRICT_MAX_BPP,
        DocumentPolicyFeature.LOSSY_IMAGES_MAX_BPP,
        DocumentPolicyFeature.OVERSIZED_IMAGES,
        DocumentPolicyFeature.UNSIZED_MEDIA,
        DocumentPolicyFeature.LAYOUT_ANIMATIONS,
        DocumentPolicyFeature.DOCUMENT_WRITE,
        DocumentPolicyFeature.SYNC_SCRIPT,
        DocumentPolicyFeature.JS_PROFILING,
        DocumentPolicyFeature.SYNC_XHR})
    public @interface EnumType {}

    public static final int DEFAULT = 0;
    public static final int FONT_DISPLAY = 1;
    public static final int LOSSLESS_IMAGES_MAX_BPP = 2;
    public static final int FORCE_LOAD_AT_TOP = 3;
    public static final int LOSSLESS_IMAGES_STRICT_MAX_BPP = 4;
    public static final int LOSSY_IMAGES_MAX_BPP = 5;
    public static final int OVERSIZED_IMAGES = 6;
    public static final int UNSIZED_MEDIA = 7;
    public static final int LAYOUT_ANIMATIONS = 8;
    public static final int DOCUMENT_WRITE = 9;
    public static final int SYNC_SCRIPT = 10;
    public static final int JS_PROFILING = 11;
    public static final int SYNC_XHR = 12;
    public static final int MIN_VALUE = 0;
    public static final int MAX_VALUE = 12;

    public static boolean isKnownValue(int value) {
        return value >= 0 && value <= 12;
    }

    public static void validate(int value) {
        if (IS_EXTENSIBLE || isKnownValue(value)) return;
        throw new org.chromium.mojo.bindings.DeserializationException("Invalid enum value.");
    }

    public static int toKnownValue(int value) {
      return value;
    }

    private DocumentPolicyFeature() {}
}