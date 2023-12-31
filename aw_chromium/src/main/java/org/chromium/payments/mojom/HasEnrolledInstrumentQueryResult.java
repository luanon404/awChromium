// HasEnrolledInstrumentQueryResult.java is auto generated by mojom_bindings_generator.py, do not edit


// Copyright 2014 The Chromium Authors
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.

// This file is autogenerated by:
//     mojo/public/tools/bindings/mojom_bindings_generator.py
// For:
//     third_party/blink/public/mojom/payments/payment_request.mojom
//

package org.chromium.payments.mojom;

import androidx.annotation.IntDef;

public final class HasEnrolledInstrumentQueryResult {
    private static final boolean IS_EXTENSIBLE = false;
    @IntDef({

        HasEnrolledInstrumentQueryResult.HAS_ENROLLED_INSTRUMENT,
        HasEnrolledInstrumentQueryResult.HAS_NO_ENROLLED_INSTRUMENT,
        HasEnrolledInstrumentQueryResult.QUERY_QUOTA_EXCEEDED,
        HasEnrolledInstrumentQueryResult.WARNING_HAS_ENROLLED_INSTRUMENT,
        HasEnrolledInstrumentQueryResult.WARNING_HAS_NO_ENROLLED_INSTRUMENT})
    public @interface EnumType {}

    public static final int HAS_ENROLLED_INSTRUMENT = 0;
    public static final int HAS_NO_ENROLLED_INSTRUMENT = 1;
    public static final int QUERY_QUOTA_EXCEEDED = 2;
    public static final int WARNING_HAS_ENROLLED_INSTRUMENT = 3;
    public static final int WARNING_HAS_NO_ENROLLED_INSTRUMENT = 4;
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

    private HasEnrolledInstrumentQueryResult() {}
}