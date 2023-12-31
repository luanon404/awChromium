// CdmSessionClosedReason.java is auto generated by mojom_bindings_generator.py, do not edit


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

public final class CdmSessionClosedReason {
    private static final boolean IS_EXTENSIBLE = false;
    @IntDef({

        CdmSessionClosedReason.INTERNAL_ERROR,
        CdmSessionClosedReason.CLOSE,
        CdmSessionClosedReason.RELEASE_ACKNOWLEDGED,
        CdmSessionClosedReason.HARDWARE_CONTEXT_RESET,
        CdmSessionClosedReason.RESOURCE_EVICTED})
    public @interface EnumType {}

    public static final int INTERNAL_ERROR = 0;
    public static final int CLOSE = 1;
    public static final int RELEASE_ACKNOWLEDGED = 2;
    public static final int HARDWARE_CONTEXT_RESET = 3;
    public static final int RESOURCE_EVICTED = 4;
    public static final int MIN_VALUE = 0;
    public static final int MAX_VALUE = 4;

    public static boolean isKnownValue(int value) {
        return value >= 0 && value <= 4;
    }

    public static void validate(int value) {
        if (IS_EXTENSIBLE || isKnownValue(value)) return;
        throw new org.chromium.mojo.bindings.DeserializationException("Invalid enum value.");
    }

    public static int toKnownValue(int value) {
      return value;
    }

    private CdmSessionClosedReason() {}
}