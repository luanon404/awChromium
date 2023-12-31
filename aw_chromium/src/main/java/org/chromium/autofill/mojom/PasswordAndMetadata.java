// PasswordAndMetadata.java is auto generated by mojom_bindings_generator.py, do not edit


// Copyright 2014 The Chromium Authors
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.

// This file is autogenerated by:
//     mojo/public/tools/bindings/mojom_bindings_generator.py
// For:
//     components/autofill/core/common/mojom/autofill_types.mojom
//

package org.chromium.autofill.mojom;

import androidx.annotation.IntDef;


public final class PasswordAndMetadata extends org.chromium.mojo.bindings.Struct {

    private static final int STRUCT_SIZE = 40;
    private static final org.chromium.mojo.bindings.DataHeader[] VERSION_ARRAY = new org.chromium.mojo.bindings.DataHeader[] {new org.chromium.mojo.bindings.DataHeader(40, 0)};
    private static final org.chromium.mojo.bindings.DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
    public org.chromium.mojo_base.mojom.String16 usernameValue;
    public org.chromium.mojo_base.mojom.String16 passwordValue;
    public String realm;
    public boolean usesAccountStore;

    private PasswordAndMetadata(int version) {
        super(STRUCT_SIZE, version);
    }

    public PasswordAndMetadata() {
        this(0);
    }

    public static PasswordAndMetadata deserialize(org.chromium.mojo.bindings.Message message) {
        return decode(new org.chromium.mojo.bindings.Decoder(message));
    }

    /**
     * Similar to the method above, but deserializes from a |ByteBuffer| instance.
     *
     * @throws org.chromium.mojo.bindings.DeserializationException on deserialization failure.
     */
    public static PasswordAndMetadata deserialize(java.nio.ByteBuffer data) {
        return deserialize(new org.chromium.mojo.bindings.Message(
                data, new java.util.ArrayList<org.chromium.mojo.system.Handle>()));
    }

    @SuppressWarnings("unchecked")
    public static PasswordAndMetadata decode(org.chromium.mojo.bindings.Decoder decoder0) {
        if (decoder0 == null) {
            return null;
        }
        decoder0.increaseStackDepth();
        PasswordAndMetadata result;
        try {
            org.chromium.mojo.bindings.DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
            final int elementsOrVersion = mainDataHeader.elementsOrVersion;
            result = new PasswordAndMetadata(elementsOrVersion);
                {
                    
                org.chromium.mojo.bindings.Decoder decoder1 = decoder0.readPointer(8, false);
                result.usernameValue = org.chromium.mojo_base.mojom.String16.decode(decoder1);
                }
                {
                    
                org.chromium.mojo.bindings.Decoder decoder1 = decoder0.readPointer(16, false);
                result.passwordValue = org.chromium.mojo_base.mojom.String16.decode(decoder1);
                }
                {
                    
                result.realm = decoder0.readString(24, false);
                }
                {
                    
                result.usesAccountStore = decoder0.readBoolean(32, 0);
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
        
        encoder0.encode(this.usernameValue, 8, false);
        
        encoder0.encode(this.passwordValue, 16, false);
        
        encoder0.encode(this.realm, 24, false);
        
        encoder0.encode(this.usesAccountStore, 32, 0);
    }
}