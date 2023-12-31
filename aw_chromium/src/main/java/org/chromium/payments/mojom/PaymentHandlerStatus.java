// PaymentHandlerStatus.java is auto generated by mojom_bindings_generator.py, do not edit


// Copyright 2014 The Chromium Authors
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.

// This file is autogenerated by:
//     mojo/public/tools/bindings/mojom_bindings_generator.py
// For:
//     third_party/blink/public/mojom/payments/payment_app.mojom
//

package org.chromium.payments.mojom;

import androidx.annotation.IntDef;

public final class PaymentHandlerStatus {
    private static final boolean IS_EXTENSIBLE = false;
    @IntDef({

        PaymentHandlerStatus.SUCCESS,
        PaymentHandlerStatus.NOT_FOUND,
        PaymentHandlerStatus.NO_ACTIVE_WORKER,
        PaymentHandlerStatus.STORAGE_OPERATION_FAILED,
        PaymentHandlerStatus.FETCH_INSTRUMENT_ICON_FAILED,
        PaymentHandlerStatus.FETCH_PAYMENT_APP_INFO_FAILED})
    public @interface EnumType {}

    public static final int SUCCESS = 0;
    public static final int NOT_FOUND = 1;
    public static final int NO_ACTIVE_WORKER = 2;
    public static final int STORAGE_OPERATION_FAILED = 3;
    public static final int FETCH_INSTRUMENT_ICON_FAILED = 4;
    public static final int FETCH_PAYMENT_APP_INFO_FAILED = 5;
    public static final int MIN_VALUE = 0;
    public static final int MAX_VALUE = 5;

    public static boolean isKnownValue(int value) {
        return value >= 0 && value <= 5;
    }

    public static void validate(int value) {
        if (IS_EXTENSIBLE || isKnownValue(value)) return;
        throw new org.chromium.mojo.bindings.DeserializationException("Invalid enum value.");
    }

    public static int toKnownValue(int value) {
      return value;
    }

    private PaymentHandlerStatus() {}
}