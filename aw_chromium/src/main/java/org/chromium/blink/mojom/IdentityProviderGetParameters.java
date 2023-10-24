// IdentityProviderGetParameters.java is auto generated by mojom_bindings_generator.py, do not edit


// Copyright 2014 The Chromium Authors
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.

// This file is autogenerated by:
//     mojo/public/tools/bindings/mojom_bindings_generator.py
// For:
//     third_party/blink/public/mojom/webid/federated_auth_request.mojom
//

package org.chromium.blink.mojom;


public final class IdentityProviderGetParameters extends org.chromium.mojo.bindings.Struct {

    private static final int STRUCT_SIZE = 24;
    private static final org.chromium.mojo.bindings.DataHeader[] VERSION_ARRAY = new org.chromium.mojo.bindings.DataHeader[] {new org.chromium.mojo.bindings.DataHeader(24, 0)};
    private static final org.chromium.mojo.bindings.DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
    public IdentityProvider[] providers;
    public int context;
    public int mode;

    private IdentityProviderGetParameters(int version) {
        super(STRUCT_SIZE, version);
    }

    public IdentityProviderGetParameters() {
        this(0);
    }

    public static IdentityProviderGetParameters deserialize(org.chromium.mojo.bindings.Message message) {
        return decode(new org.chromium.mojo.bindings.Decoder(message));
    }

    /**
     * Similar to the method above, but deserializes from a |ByteBuffer| instance.
     *
     * @throws org.chromium.mojo.bindings.DeserializationException on deserialization failure.
     */
    public static IdentityProviderGetParameters deserialize(java.nio.ByteBuffer data) {
        return deserialize(new org.chromium.mojo.bindings.Message(
                data, new java.util.ArrayList<org.chromium.mojo.system.Handle>()));
    }

    @SuppressWarnings("unchecked")
    public static IdentityProviderGetParameters decode(org.chromium.mojo.bindings.Decoder decoder0) {
        if (decoder0 == null) {
            return null;
        }
        decoder0.increaseStackDepth();
        IdentityProviderGetParameters result;
        try {
            org.chromium.mojo.bindings.DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
            final int elementsOrVersion = mainDataHeader.elementsOrVersion;
            result = new IdentityProviderGetParameters(elementsOrVersion);
                {
                    
                org.chromium.mojo.bindings.Decoder decoder1 = decoder0.readPointer(8, false);
                {
                    org.chromium.mojo.bindings.DataHeader si1 = decoder1.readDataHeaderForPointerArray(org.chromium.mojo.bindings.BindingsHelper.UNSPECIFIED_ARRAY_LENGTH);
                    result.providers = new IdentityProvider[si1.elementsOrVersion];
                    for (int i1 = 0; i1 < si1.elementsOrVersion; ++i1) {
                        
                        result.providers[i1] = IdentityProvider.decode(decoder1, org.chromium.mojo.bindings.DataHeader.HEADER_SIZE + 
                        org.chromium.mojo.bindings.BindingsHelper.UNION_SIZE * i1);
                    }
                }
                }
                {
                    
                result.context = decoder0.readInt(16);
                    RpContext.validate(result.context);
                    result.context = RpContext.toKnownValue(result.context);
                }
                {
                    
                result.mode = decoder0.readInt(20);
                    RpMode.validate(result.mode);
                    result.mode = RpMode.toKnownValue(result.mode);
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
        
        if (this.providers == null) {
            encoder0.encodeNullPointer(8, false);
        } else {
            org.chromium.mojo.bindings.Encoder encoder1 = encoder0.encodeUnionArray(this.providers.length, 8, org.chromium.mojo.bindings.BindingsHelper.UNSPECIFIED_ARRAY_LENGTH);
            for (int i0 = 0; i0 < this.providers.length; ++i0) {
                
                encoder1.encode(this.providers[i0], org.chromium.mojo.bindings.DataHeader.HEADER_SIZE + 
                org.chromium.mojo.bindings.BindingsHelper.UNION_SIZE * i0, false);
            }
        }
        
        encoder0.encode(this.context, 16);
        
        encoder0.encode(this.mode, 20);
    }
}