// ProxyScheme.java is auto generated by mojom_bindings_generator.py, do not edit


// Copyright 2014 The Chromium Authors
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.

// This file is autogenerated by:
//     mojo/public/tools/bindings/mojom_bindings_generator.py
// For:
//     services/network/public/mojom/network_param.mojom
//

package org.chromium.network.mojom;

import androidx.annotation.IntDef;

public final class ProxyScheme {
    private static final boolean IS_EXTENSIBLE = false;
    @IntDef({

        ProxyScheme.INVALID,
        ProxyScheme.DIRECT,
        ProxyScheme.HTTP,
        ProxyScheme.SOCKS4,
        ProxyScheme.SOCKS5,
        ProxyScheme.HTTPS,
        ProxyScheme.QUIC})
    public @interface EnumType {}

    public static final int INVALID = 0;
    public static final int DIRECT = 1;
    public static final int HTTP = 2;
    public static final int SOCKS4 = 3;
    public static final int SOCKS5 = 4;
    public static final int HTTPS = 5;
    public static final int QUIC = 6;
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

    private ProxyScheme() {}
}