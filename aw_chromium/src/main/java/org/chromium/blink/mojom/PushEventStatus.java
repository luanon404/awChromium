// PushEventStatus.java is auto generated by mojom_bindings_generator.py, do not edit


// Copyright 2014 The Chromium Authors
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.

// This file is autogenerated by:
//     mojo/public/tools/bindings/mojom_bindings_generator.py
// For:
//     third_party/blink/public/mojom/push_messaging/push_messaging_status.mojom
//

package org.chromium.blink.mojom;

import androidx.annotation.IntDef;

public final class PushEventStatus {
    private static final boolean IS_EXTENSIBLE = false;
    @IntDef({

        PushEventStatus.SUCCESS,
        PushEventStatus.UNKNOWN_APP_ID,
        PushEventStatus.PERMISSION_DENIED,
        PushEventStatus.NO_SERVICE_WORKER,
        PushEventStatus.SERVICE_WORKER_ERROR,
        PushEventStatus.EVENT_WAITUNTIL_REJECTED,
        PushEventStatus.TIMEOUT,
        PushEventStatus.PERMISSION_REVOKED_ABUSIVE,
        PushEventStatus.NO_APP_LEVEL_PERMISSION_IGNORE,
        PushEventStatus.NO_APP_LEVEL_PERMISSION_UNSUBSCRIBE,
        PushEventStatus.PERMISSION_REVOKED_DISRUPTIVE})
    public @interface EnumType {}

    public static final int SUCCESS = 0;
    public static final int UNKNOWN_APP_ID = 2;
    public static final int PERMISSION_DENIED = 3;
    public static final int NO_SERVICE_WORKER = 4;
    public static final int SERVICE_WORKER_ERROR = 5;
    public static final int EVENT_WAITUNTIL_REJECTED = 6;
    public static final int TIMEOUT = 7;
    public static final int PERMISSION_REVOKED_ABUSIVE = 8;
    public static final int NO_APP_LEVEL_PERMISSION_IGNORE = 9;
    public static final int NO_APP_LEVEL_PERMISSION_UNSUBSCRIBE = 10;
    public static final int PERMISSION_REVOKED_DISRUPTIVE = 11;
    public static final int MIN_VALUE = 0;
    public static final int MAX_VALUE = 11;

    public static boolean isKnownValue(int value) {
        switch (value) {
            case 0:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
                return true;
        }
        return false;
    }

    public static void validate(int value) {
        if (IS_EXTENSIBLE || isKnownValue(value)) return;
        throw new org.chromium.mojo.bindings.DeserializationException("Invalid enum value.");
    }

    public static int toKnownValue(int value) {
      return value;
    }

    private PushEventStatus() {}
}