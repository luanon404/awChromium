// UsbTransferStatus.java is auto generated by mojom_bindings_generator.py, do not edit


// Copyright 2014 The Chromium Authors
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.

// This file is autogenerated by:
//     mojo/public/tools/bindings/mojom_bindings_generator.py
// For:
//     services/device/public/mojom/usb_device.mojom
//

package org.chromium.device.mojom;

import androidx.annotation.IntDef;

public final class UsbTransferStatus {
    private static final boolean IS_EXTENSIBLE = false;

    @IntDef({UsbTransferStatus.COMPLETED, UsbTransferStatus.TRANSFER_ERROR, UsbTransferStatus.TIMEOUT, UsbTransferStatus.CANCELLED, UsbTransferStatus.STALLED, UsbTransferStatus.DISCONNECT, UsbTransferStatus.BABBLE, UsbTransferStatus.SHORT_PACKET, UsbTransferStatus.PERMISSION_DENIED})
    public @interface EnumType {
    }

    public static final int COMPLETED = 0;
    public static final int TRANSFER_ERROR = 1;
    public static final int TIMEOUT = 2;
    public static final int CANCELLED = 3;
    public static final int STALLED = 4;
    public static final int DISCONNECT = 5;
    public static final int BABBLE = 6;
    public static final int SHORT_PACKET = 7;
    public static final int PERMISSION_DENIED = 8;
    public static final int MIN_VALUE = 0;
    public static final int MAX_VALUE = 8;

    public static boolean isKnownValue(int value) {
        return value >= 0 && value <= 8;
    }

    public static void validate(int value) {
        if (IS_EXTENSIBLE || isKnownValue(value)) return;
        throw new org.chromium.mojo.bindings.DeserializationException("Invalid enum value.");
    }

    public static int toKnownValue(int value) {
        return value;
    }

    private UsbTransferStatus() {
    }
}