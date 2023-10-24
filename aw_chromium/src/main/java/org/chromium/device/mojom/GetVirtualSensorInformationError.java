// GetVirtualSensorInformationError.java is auto generated by mojom_bindings_generator.py, do not edit


// Copyright 2014 The Chromium Authors
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.

// This file is autogenerated by:
//     mojo/public/tools/bindings/mojom_bindings_generator.py
// For:
//     services/device/public/mojom/sensor_provider.mojom
//

package org.chromium.device.mojom;

import androidx.annotation.IntDef;

public final class GetVirtualSensorInformationError {
    private static final boolean IS_EXTENSIBLE = false;

    @IntDef({GetVirtualSensorInformationError.SENSOR_TYPE_NOT_OVERRIDDEN})
    public @interface EnumType {
    }

    public static final int SENSOR_TYPE_NOT_OVERRIDDEN = 0;
    public static final int MIN_VALUE = 0;
    public static final int MAX_VALUE = 0;

    public static boolean isKnownValue(int value) {
        return value >= 0 && value <= 0;
    }

    public static void validate(int value) {
        if (IS_EXTENSIBLE || isKnownValue(value)) return;
        throw new org.chromium.mojo.bindings.DeserializationException("Invalid enum value.");
    }

    public static int toKnownValue(int value) {
        return value;
    }

    private GetVirtualSensorInformationError() {
    }
}