// SecurePaymentConfirmationRequest.java is auto generated by mojom_bindings_generator.py, do not edit


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


public final class SecurePaymentConfirmationRequest extends org.chromium.mojo.bindings.Struct {

    private static final int STRUCT_SIZE = 80;
    private static final org.chromium.mojo.bindings.DataHeader[] VERSION_ARRAY = new org.chromium.mojo.bindings.DataHeader[] {new org.chromium.mojo.bindings.DataHeader(80, 0)};
    private static final org.chromium.mojo.bindings.DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
    public byte[][] credentialIds;
    public byte[] challenge;
    public org.chromium.blink.mojom.PaymentCredentialInstrument instrument;
    public org.chromium.mojo_base.mojom.TimeDelta timeout;
    public org.chromium.url.internal.mojom.Origin payeeOrigin;
    public String payeeName;
    public String rpId;
    public org.chromium.blink.mojom.AuthenticationExtensionsClientInputs extensions;
    public boolean showOptOut;

    private SecurePaymentConfirmationRequest(int version) {
        super(STRUCT_SIZE, version);
    }

    public SecurePaymentConfirmationRequest() {
        this(0);
    }

    public static SecurePaymentConfirmationRequest deserialize(org.chromium.mojo.bindings.Message message) {
        return decode(new org.chromium.mojo.bindings.Decoder(message));
    }

    /**
     * Similar to the method above, but deserializes from a |ByteBuffer| instance.
     *
     * @throws org.chromium.mojo.bindings.DeserializationException on deserialization failure.
     */
    public static SecurePaymentConfirmationRequest deserialize(java.nio.ByteBuffer data) {
        return deserialize(new org.chromium.mojo.bindings.Message(
                data, new java.util.ArrayList<org.chromium.mojo.system.Handle>()));
    }

    @SuppressWarnings("unchecked")
    public static SecurePaymentConfirmationRequest decode(org.chromium.mojo.bindings.Decoder decoder0) {
        if (decoder0 == null) {
            return null;
        }
        decoder0.increaseStackDepth();
        SecurePaymentConfirmationRequest result;
        try {
            org.chromium.mojo.bindings.DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
            final int elementsOrVersion = mainDataHeader.elementsOrVersion;
            result = new SecurePaymentConfirmationRequest(elementsOrVersion);
                {
                    
                org.chromium.mojo.bindings.Decoder decoder1 = decoder0.readPointer(8, false);
                {
                    org.chromium.mojo.bindings.DataHeader si1 = decoder1.readDataHeaderForPointerArray(org.chromium.mojo.bindings.BindingsHelper.UNSPECIFIED_ARRAY_LENGTH);
                    result.credentialIds = new byte[si1.elementsOrVersion][];
                    for (int i1 = 0; i1 < si1.elementsOrVersion; ++i1) {
                        
                        result.credentialIds[i1] = decoder1.readBytes(org.chromium.mojo.bindings.DataHeader.HEADER_SIZE + org.chromium.mojo.bindings.BindingsHelper.POINTER_SIZE * i1, org.chromium.mojo.bindings.BindingsHelper.NOTHING_NULLABLE, org.chromium.mojo.bindings.BindingsHelper.UNSPECIFIED_ARRAY_LENGTH);
                    }
                }
                }
                {
                    
                result.challenge = decoder0.readBytes(16, org.chromium.mojo.bindings.BindingsHelper.NOTHING_NULLABLE, org.chromium.mojo.bindings.BindingsHelper.UNSPECIFIED_ARRAY_LENGTH);
                }
                {
                    
                org.chromium.mojo.bindings.Decoder decoder1 = decoder0.readPointer(24, false);
                result.instrument = org.chromium.blink.mojom.PaymentCredentialInstrument.decode(decoder1);
                }
                {
                    
                org.chromium.mojo.bindings.Decoder decoder1 = decoder0.readPointer(32, true);
                result.timeout = org.chromium.mojo_base.mojom.TimeDelta.decode(decoder1);
                }
                {
                    
                org.chromium.mojo.bindings.Decoder decoder1 = decoder0.readPointer(40, true);
                result.payeeOrigin = org.chromium.url.internal.mojom.Origin.decode(decoder1);
                }
                {
                    
                result.payeeName = decoder0.readString(48, true);
                }
                {
                    
                result.rpId = decoder0.readString(56, false);
                }
                {
                    
                org.chromium.mojo.bindings.Decoder decoder1 = decoder0.readPointer(64, true);
                result.extensions = org.chromium.blink.mojom.AuthenticationExtensionsClientInputs.decode(decoder1);
                }
                {
                    
                result.showOptOut = decoder0.readBoolean(72, 0);
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
        
        if (this.credentialIds == null) {
            encoder0.encodeNullPointer(8, false);
        } else {
            org.chromium.mojo.bindings.Encoder encoder1 = encoder0.encodePointerArray(this.credentialIds.length, 8, org.chromium.mojo.bindings.BindingsHelper.UNSPECIFIED_ARRAY_LENGTH);
            for (int i0 = 0; i0 < this.credentialIds.length; ++i0) {
                
                encoder1.encode(this.credentialIds[i0], org.chromium.mojo.bindings.DataHeader.HEADER_SIZE + org.chromium.mojo.bindings.BindingsHelper.POINTER_SIZE * i0, org.chromium.mojo.bindings.BindingsHelper.NOTHING_NULLABLE, org.chromium.mojo.bindings.BindingsHelper.UNSPECIFIED_ARRAY_LENGTH);
            }
        }
        
        encoder0.encode(this.challenge, 16, org.chromium.mojo.bindings.BindingsHelper.NOTHING_NULLABLE, org.chromium.mojo.bindings.BindingsHelper.UNSPECIFIED_ARRAY_LENGTH);
        
        encoder0.encode(this.instrument, 24, false);
        
        encoder0.encode(this.timeout, 32, true);
        
        encoder0.encode(this.payeeOrigin, 40, true);
        
        encoder0.encode(this.payeeName, 48, true);
        
        encoder0.encode(this.rpId, 56, false);
        
        encoder0.encode(this.extensions, 64, true);
        
        encoder0.encode(this.showOptOut, 72, 0);
    }
}