// UsbControlTransferParams.java is auto generated by mojom_bindings_generator.py, do not edit


// Copyright 2014 The Chromium Authors
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.

// This file is autogenerated by:
//     mojo/public/tools/bindings/mojom_bindings_generator.py
// For:
//     services/device/public/mojom/usb_device.mojom
//

package org.chromium.device.mojom;

import androidx.annotation.IntDef;


public final class UsbControlTransferParams extends org.chromium.mojo.bindings.Struct {

    private static final int STRUCT_SIZE = 24;
    private static final org.chromium.mojo.bindings.DataHeader[] VERSION_ARRAY = new org.chromium.mojo.bindings.DataHeader[] {new org.chromium.mojo.bindings.DataHeader(24, 0)};
    private static final org.chromium.mojo.bindings.DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

    
    public static final String SECURITY_KEY_AOA_MODEL = (String) "12eba9f901039b36";

    public int type;
    public int recipient;
    public byte request;
    public short value;
    public short index;

    private UsbControlTransferParams(int version) {
        super(STRUCT_SIZE, version);
    }

    public UsbControlTransferParams() {
        this(0);
    }

    public static UsbControlTransferParams deserialize(org.chromium.mojo.bindings.Message message) {
        return decode(new org.chromium.mojo.bindings.Decoder(message));
    }

    /**
     * Similar to the method above, but deserializes from a |ByteBuffer| instance.
     *
     * @throws org.chromium.mojo.bindings.DeserializationException on deserialization failure.
     */
    public static UsbControlTransferParams deserialize(java.nio.ByteBuffer data) {
        return deserialize(new org.chromium.mojo.bindings.Message(
                data, new java.util.ArrayList<org.chromium.mojo.system.Handle>()));
    }

    @SuppressWarnings("unchecked")
    public static UsbControlTransferParams decode(org.chromium.mojo.bindings.Decoder decoder0) {
        if (decoder0 == null) {
            return null;
        }
        decoder0.increaseStackDepth();
        UsbControlTransferParams result;
        try {
            org.chromium.mojo.bindings.DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
            final int elementsOrVersion = mainDataHeader.elementsOrVersion;
            result = new UsbControlTransferParams(elementsOrVersion);
                {
                    
                result.type = decoder0.readInt(8);
                    UsbControlTransferType.validate(result.type);
                    result.type = UsbControlTransferType.toKnownValue(result.type);
                }
                {
                    
                result.recipient = decoder0.readInt(12);
                    UsbControlTransferRecipient.validate(result.recipient);
                    result.recipient = UsbControlTransferRecipient.toKnownValue(result.recipient);
                }
                {
                    
                result.request = decoder0.readByte(16);
                }
                {
                    
                result.value = decoder0.readShort(18);
                }
                {
                    
                result.index = decoder0.readShort(20);
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
        
        encoder0.encode(this.type, 8);
        
        encoder0.encode(this.recipient, 12);
        
        encoder0.encode(this.request, 16);
        
        encoder0.encode(this.value, 18);
        
        encoder0.encode(this.index, 20);
    }
}