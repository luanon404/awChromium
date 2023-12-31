// HostResolveOperation.java is auto generated by mojom_bindings_generator.py, do not edit


// Copyright 2014 The Chromium Authors
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.

// This file is autogenerated by:
//     mojo/public/tools/bindings/mojom_bindings_generator.py
// For:
//     services/proxy_resolver/public/mojom/proxy_resolver.mojom
//

package org.chromium.proxy_resolver.mojom;

import androidx.annotation.IntDef;

public final class HostResolveOperation {
    private static final boolean IS_EXTENSIBLE = false;
    @IntDef({

        HostResolveOperation.DNS_RESOLVE,
        HostResolveOperation.DNS_RESOLVE_EX,
        HostResolveOperation.MY_IP_ADDRESS,
        HostResolveOperation.MY_IP_ADDRESS_EX})
    public @interface EnumType {}

    public static final int DNS_RESOLVE = 0;
    public static final int DNS_RESOLVE_EX = 1;
    public static final int MY_IP_ADDRESS = 2;
    public static final int MY_IP_ADDRESS_EX = 3;
    public static final int MIN_VALUE = 0;
    public static final int MAX_VALUE = 3;

    public static boolean isKnownValue(int value) {
        return value >= 0 && value <= 3;
    }

    public static void validate(int value) {
        if (IS_EXTENSIBLE || isKnownValue(value)) return;
        throw new org.chromium.mojo.bindings.DeserializationException("Invalid enum value.");
    }

    public static int toKnownValue(int value) {
      return value;
    }

    private HostResolveOperation() {}
}