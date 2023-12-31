// FulfillTrustTokenIssuanceAnswer.java is auto generated by mojom_bindings_generator.py, do not edit


// Copyright 2014 The Chromium Authors
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.

// This file is autogenerated by:
//     mojo/public/tools/bindings/mojom_bindings_generator.py
// For:
//     services/network/public/mojom/trust_tokens.mojom
//

package org.chromium.network.mojom;

import androidx.annotation.IntDef;


public final class FulfillTrustTokenIssuanceAnswer extends org.chromium.mojo.bindings.Struct {

    private static final int STRUCT_SIZE = 24;
    private static final org.chromium.mojo.bindings.DataHeader[] VERSION_ARRAY = new org.chromium.mojo.bindings.DataHeader[] {new org.chromium.mojo.bindings.DataHeader(24, 0)};
    private static final org.chromium.mojo.bindings.DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

    public static final class Status {
        private static final boolean IS_EXTENSIBLE = false;
        @IntDef({

            Status.OK,
            Status.NOT_FOUND,
            Status.UNKNOWN_ERROR})
        public @interface EnumType {}

        public static final int OK = 0;
        public static final int NOT_FOUND = 1;
        public static final int UNKNOWN_ERROR = 2;
        public static final int MIN_VALUE = 0;
        public static final int MAX_VALUE = 2;

        public static boolean isKnownValue(int value) {
            return value >= 0 && value <= 2;
        }

        public static void validate(int value) {
            if (IS_EXTENSIBLE || isKnownValue(value)) return;
            throw new org.chromium.mojo.bindings.DeserializationException("Invalid enum value.");
        }

        public static int toKnownValue(int value) {
          return value;
        }

        private Status() {}
    }
    public int status;
    public String response;

    private FulfillTrustTokenIssuanceAnswer(int version) {
        super(STRUCT_SIZE, version);
    }

    public FulfillTrustTokenIssuanceAnswer() {
        this(0);
    }

    public static FulfillTrustTokenIssuanceAnswer deserialize(org.chromium.mojo.bindings.Message message) {
        return decode(new org.chromium.mojo.bindings.Decoder(message));
    }

    /**
     * Similar to the method above, but deserializes from a |ByteBuffer| instance.
     *
     * @throws org.chromium.mojo.bindings.DeserializationException on deserialization failure.
     */
    public static FulfillTrustTokenIssuanceAnswer deserialize(java.nio.ByteBuffer data) {
        return deserialize(new org.chromium.mojo.bindings.Message(
                data, new java.util.ArrayList<org.chromium.mojo.system.Handle>()));
    }

    @SuppressWarnings("unchecked")
    public static FulfillTrustTokenIssuanceAnswer decode(org.chromium.mojo.bindings.Decoder decoder0) {
        if (decoder0 == null) {
            return null;
        }
        decoder0.increaseStackDepth();
        FulfillTrustTokenIssuanceAnswer result;
        try {
            org.chromium.mojo.bindings.DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
            final int elementsOrVersion = mainDataHeader.elementsOrVersion;
            result = new FulfillTrustTokenIssuanceAnswer(elementsOrVersion);
                {
                    
                result.status = decoder0.readInt(8);
                    FulfillTrustTokenIssuanceAnswer.Status.validate(result.status);
                    result.status = FulfillTrustTokenIssuanceAnswer.Status.toKnownValue(result.status);
                }
                {
                    
                result.response = decoder0.readString(16, false);
                }

        } finally {
            decoder0.decreaseStackDepth();
        }
        return result;
    }

    @SuppressWarnings("unchecked")
    @Override
    protected final void encode(org.chromium.mojo.bindings.Encoder encoder) {
        org.chromium.mojo.bindings.Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
        
        encoder0.encode(this.status, 8);
        
        encoder0.encode(this.response, 16, false);
    }
}