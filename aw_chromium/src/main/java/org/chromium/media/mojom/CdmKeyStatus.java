// CdmKeyStatus.java is auto generated by mojom_bindings_generator.py, do not edit


// Copyright 2014 The Chromium Authors
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.

// This file is autogenerated by:
//     mojo/public/tools/bindings/mojom_bindings_generator.py
// For:
//     media/mojo/mojom/content_decryption_module.mojom
//

package org.chromium.media.mojom;

import androidx.annotation.IntDef;

public final class CdmKeyStatus {
    private static final boolean IS_EXTENSIBLE = false;
    @IntDef({

        CdmKeyStatus.USABLE,
        CdmKeyStatus.INTERNAL_ERROR,
        CdmKeyStatus.EXPIRED,
        CdmKeyStatus.OUTPUT_RESTRICTED,
        CdmKeyStatus.OUTPUT_DOWNSCALED,
        CdmKeyStatus.KEY_STATUS_PENDING,
        CdmKeyStatus.RELEASED})
    public @interface EnumType {}

    public static final int USABLE = 0;
    public static final int INTERNAL_ERROR = 1;
    public static final int EXPIRED = 2;
    public static final int OUTPUT_RESTRICTED = 3;
    public static final int OUTPUT_DOWNSCALED = 4;
    public static final int KEY_STATUS_PENDING = 5;
    public static final int RELEASED = 6;
    public static final int MIN_VALUE = 0;
    public static final int MAX_VALUE = 6;

    public static boolean isKnownValue(int value) {
        return value >= 0 && value <= 6;
    }

    public static void validate(int value) {
        if (IS_EXTENSIBLE || isKnownValue(value)) return;
        throw new org.chromium.mojo.bindings.DeserializationException("Invalid enum value.");
    }

    public static int toKnownValue(int value) {
      return value;
    }

    private CdmKeyStatus() {}
}