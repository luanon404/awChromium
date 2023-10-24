// MakeCredentialAuthenticatorResponse.java is auto generated by mojom_bindings_generator.py, do not edit


// Copyright 2014 The Chromium Authors
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.

// This file is autogenerated by:
//     mojo/public/tools/bindings/mojom_bindings_generator.py
// For:
//     third_party/blink/public/mojom/webauthn/authenticator.mojom
//

package org.chromium.blink.mojom;


public final class MakeCredentialAuthenticatorResponse extends org.chromium.mojo.bindings.Struct {

    private static final int STRUCT_SIZE = 72;
    private static final org.chromium.mojo.bindings.DataHeader[] VERSION_ARRAY = new org.chromium.mojo.bindings.DataHeader[] {new org.chromium.mojo.bindings.DataHeader(72, 0)};
    private static final org.chromium.mojo.bindings.DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
    public CommonCredentialInfo info;
    public int authenticatorAttachment;
    public byte[] attestationObject;
    public int[] transports;
    public boolean echoHmacCreateSecret;
    public boolean hmacCreateSecret;
    public boolean echoPrf;
    public boolean prf;
    public PrfValues prfResults;
    public boolean echoCredBlob;
    public boolean credBlob;
    public byte[] publicKeyDer;
    public int publicKeyAlgo;
    public boolean echoCredProps;
    public boolean hasCredPropsRk;
    public boolean credPropsRk;
    public boolean echoLargeBlob;
    public boolean supportsLargeBlob;
    public DevicePublicKeyResponse devicePublicKey;

    private MakeCredentialAuthenticatorResponse(int version) {
        super(STRUCT_SIZE, version);
    }

    public MakeCredentialAuthenticatorResponse() {
        this(0);
    }

    public static MakeCredentialAuthenticatorResponse deserialize(org.chromium.mojo.bindings.Message message) {
        return decode(new org.chromium.mojo.bindings.Decoder(message));
    }

    /**
     * Similar to the method above, but deserializes from a |ByteBuffer| instance.
     *
     * @throws org.chromium.mojo.bindings.DeserializationException on deserialization failure.
     */
    public static MakeCredentialAuthenticatorResponse deserialize(java.nio.ByteBuffer data) {
        return deserialize(new org.chromium.mojo.bindings.Message(
                data, new java.util.ArrayList<org.chromium.mojo.system.Handle>()));
    }

    @SuppressWarnings("unchecked")
    public static MakeCredentialAuthenticatorResponse decode(org.chromium.mojo.bindings.Decoder decoder0) {
        if (decoder0 == null) {
            return null;
        }
        decoder0.increaseStackDepth();
        MakeCredentialAuthenticatorResponse result;
        try {
            org.chromium.mojo.bindings.DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
            final int elementsOrVersion = mainDataHeader.elementsOrVersion;
            result = new MakeCredentialAuthenticatorResponse(elementsOrVersion);
                {
                    
                org.chromium.mojo.bindings.Decoder decoder1 = decoder0.readPointer(8, false);
                result.info = CommonCredentialInfo.decode(decoder1);
                }
                {
                    
                result.authenticatorAttachment = decoder0.readInt(16);
                    AuthenticatorAttachment.validate(result.authenticatorAttachment);
                    result.authenticatorAttachment = AuthenticatorAttachment.toKnownValue(result.authenticatorAttachment);
                }
                {
                    
                result.echoHmacCreateSecret = decoder0.readBoolean(20, 0);
                }
                {
                    
                result.hmacCreateSecret = decoder0.readBoolean(20, 1);
                }
                {
                    
                result.echoPrf = decoder0.readBoolean(20, 2);
                }
                {
                    
                result.prf = decoder0.readBoolean(20, 3);
                }
                {
                    
                result.echoCredBlob = decoder0.readBoolean(20, 4);
                }
                {
                    
                result.credBlob = decoder0.readBoolean(20, 5);
                }
                {
                    
                result.echoCredProps = decoder0.readBoolean(20, 6);
                }
                {
                    
                result.hasCredPropsRk = decoder0.readBoolean(20, 7);
                }
                {
                    
                result.credPropsRk = decoder0.readBoolean(21, 0);
                }
                {
                    
                result.echoLargeBlob = decoder0.readBoolean(21, 1);
                }
                {
                    
                result.supportsLargeBlob = decoder0.readBoolean(21, 2);
                }
                {
                    
                result.attestationObject = decoder0.readBytes(24, org.chromium.mojo.bindings.BindingsHelper.NOTHING_NULLABLE, org.chromium.mojo.bindings.BindingsHelper.UNSPECIFIED_ARRAY_LENGTH);
                }
                {
                    
                result.transports = decoder0.readInts(32, org.chromium.mojo.bindings.BindingsHelper.NOTHING_NULLABLE, org.chromium.mojo.bindings.BindingsHelper.UNSPECIFIED_ARRAY_LENGTH);
                {
                    for (int i1 = 0; i1 < result.transports.length; ++i1) {
                        AuthenticatorTransport.validate(result.transports[i1]);
                    }
                }
                }
                {
                    
                org.chromium.mojo.bindings.Decoder decoder1 = decoder0.readPointer(40, true);
                result.prfResults = PrfValues.decode(decoder1);
                }
                {
                    
                result.publicKeyDer = decoder0.readBytes(48, org.chromium.mojo.bindings.BindingsHelper.ARRAY_NULLABLE, org.chromium.mojo.bindings.BindingsHelper.UNSPECIFIED_ARRAY_LENGTH);
                }
                {
                    
                result.publicKeyAlgo = decoder0.readInt(56);
                }
                {
                    
                org.chromium.mojo.bindings.Decoder decoder1 = decoder0.readPointer(64, true);
                result.devicePublicKey = DevicePublicKeyResponse.decode(decoder1);
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
        
        encoder0.encode(this.info, 8, false);
        
        encoder0.encode(this.authenticatorAttachment, 16);
        
        encoder0.encode(this.echoHmacCreateSecret, 20, 0);
        
        encoder0.encode(this.hmacCreateSecret, 20, 1);
        
        encoder0.encode(this.echoPrf, 20, 2);
        
        encoder0.encode(this.prf, 20, 3);
        
        encoder0.encode(this.echoCredBlob, 20, 4);
        
        encoder0.encode(this.credBlob, 20, 5);
        
        encoder0.encode(this.echoCredProps, 20, 6);
        
        encoder0.encode(this.hasCredPropsRk, 20, 7);
        
        encoder0.encode(this.credPropsRk, 21, 0);
        
        encoder0.encode(this.echoLargeBlob, 21, 1);
        
        encoder0.encode(this.supportsLargeBlob, 21, 2);
        
        encoder0.encode(this.attestationObject, 24, org.chromium.mojo.bindings.BindingsHelper.NOTHING_NULLABLE, org.chromium.mojo.bindings.BindingsHelper.UNSPECIFIED_ARRAY_LENGTH);
        
        encoder0.encode(this.transports, 32, org.chromium.mojo.bindings.BindingsHelper.NOTHING_NULLABLE, org.chromium.mojo.bindings.BindingsHelper.UNSPECIFIED_ARRAY_LENGTH);
        
        encoder0.encode(this.prfResults, 40, true);
        
        encoder0.encode(this.publicKeyDer, 48, org.chromium.mojo.bindings.BindingsHelper.ARRAY_NULLABLE, org.chromium.mojo.bindings.BindingsHelper.UNSPECIFIED_ARRAY_LENGTH);
        
        encoder0.encode(this.publicKeyAlgo, 56);
        
        encoder0.encode(this.devicePublicKey, 64, true);
    }
}