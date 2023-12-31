// CookieExclusionReason.java is auto generated by mojom_bindings_generator.py, do not edit


// Copyright 2014 The Chromium Authors
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.

// This file is autogenerated by:
//     mojo/public/tools/bindings/mojom_bindings_generator.py
// For:
//     third_party/blink/public/mojom/devtools/inspector_issue.mojom
//

package org.chromium.blink.mojom;

import androidx.annotation.IntDef;

public final class CookieExclusionReason {
    private static final boolean IS_EXTENSIBLE = false;
    @IntDef({

        CookieExclusionReason.EXCLUDE_SAME_SITE_UNSPECIFIED_TREATED_AS_LAX,
        CookieExclusionReason.EXCLUDE_SAME_SITE_NONE_INSECURE,
        CookieExclusionReason.EXCLUDE_SAME_SITE_LAX,
        CookieExclusionReason.EXCLUDE_SAME_SITE_STRICT,
        CookieExclusionReason.EXCLUDE_DOMAIN_NON_ASCII,
        CookieExclusionReason.EXCLUDE_THIRD_PARTY_PHASEOUT})
    public @interface EnumType {}

    public static final int EXCLUDE_SAME_SITE_UNSPECIFIED_TREATED_AS_LAX = 0;
    public static final int EXCLUDE_SAME_SITE_NONE_INSECURE = 1;
    public static final int EXCLUDE_SAME_SITE_LAX = 2;
    public static final int EXCLUDE_SAME_SITE_STRICT = 3;
    public static final int EXCLUDE_DOMAIN_NON_ASCII = 4;
    public static final int EXCLUDE_THIRD_PARTY_PHASEOUT = 5;
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

    private CookieExclusionReason() {}
}