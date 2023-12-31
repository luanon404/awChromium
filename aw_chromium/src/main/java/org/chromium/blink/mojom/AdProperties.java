// AdProperties.java is auto generated by mojom_bindings_generator.py, do not edit


// Copyright 2014 The Chromium Authors
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.

// This file is autogenerated by:
//     mojo/public/tools/bindings/mojom_bindings_generator.py
// For:
//     third_party/blink/public/mojom/parakeet/ad_request.mojom
//

package org.chromium.blink.mojom;

import androidx.annotation.IntDef;


public final class AdProperties extends org.chromium.mojo.bindings.Struct {

    private static final int STRUCT_SIZE = 56;
    private static final org.chromium.mojo.bindings.DataHeader[] VERSION_ARRAY = new org.chromium.mojo.bindings.DataHeader[] {new org.chromium.mojo.bindings.DataHeader(56, 0)};
    private static final org.chromium.mojo.bindings.DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
    public String width;
    public String height;
    public String slot;
    public String lang;
    public String adType;
    public double bidFloor;

    private AdProperties(int version) {
        super(STRUCT_SIZE, version);
    }

    public AdProperties() {
        this(0);
    }

    public static AdProperties deserialize(org.chromium.mojo.bindings.Message message) {
        return decode(new org.chromium.mojo.bindings.Decoder(message));
    }

    /**
     * Similar to the method above, but deserializes from a |ByteBuffer| instance.
     *
     * @throws org.chromium.mojo.bindings.DeserializationException on deserialization failure.
     */
    public static AdProperties deserialize(java.nio.ByteBuffer data) {
        return deserialize(new org.chromium.mojo.bindings.Message(
                data, new java.util.ArrayList<org.chromium.mojo.system.Handle>()));
    }

    @SuppressWarnings("unchecked")
    public static AdProperties decode(org.chromium.mojo.bindings.Decoder decoder0) {
        if (decoder0 == null) {
            return null;
        }
        decoder0.increaseStackDepth();
        AdProperties result;
        try {
            org.chromium.mojo.bindings.DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
            final int elementsOrVersion = mainDataHeader.elementsOrVersion;
            result = new AdProperties(elementsOrVersion);
                {
                    
                result.width = decoder0.readString(8, false);
                }
                {
                    
                result.height = decoder0.readString(16, false);
                }
                {
                    
                result.slot = decoder0.readString(24, false);
                }
                {
                    
                result.lang = decoder0.readString(32, false);
                }
                {
                    
                result.adType = decoder0.readString(40, false);
                }
                {
                    
                result.bidFloor = decoder0.readDouble(48);
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
        
        encoder0.encode(this.width, 8, false);
        
        encoder0.encode(this.height, 16, false);
        
        encoder0.encode(this.slot, 24, false);
        
        encoder0.encode(this.lang, 32, false);
        
        encoder0.encode(this.adType, 40, false);
        
        encoder0.encode(this.bidFloor, 48);
    }
}