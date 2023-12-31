// Impression.java is auto generated by mojom_bindings_generator.py, do not edit


// Copyright 2014 The Chromium Authors
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.

// This file is autogenerated by:
//     mojo/public/tools/bindings/mojom_bindings_generator.py
// For:
//     third_party/blink/public/mojom/conversions/conversions.mojom
//

package org.chromium.blink.mojom;

import androidx.annotation.IntDef;


public final class Impression extends org.chromium.mojo.bindings.Struct {

    private static final int STRUCT_SIZE = 24;
    private static final org.chromium.mojo.bindings.DataHeader[] VERSION_ARRAY = new org.chromium.mojo.bindings.DataHeader[] {new org.chromium.mojo.bindings.DataHeader(24, 0)};
    private static final org.chromium.mojo.bindings.DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
    public AttributionSrcToken attributionSrcToken;
    public org.chromium.network.mojom.AttributionReportingRuntimeFeatures runtimeFeatures;

    private Impression(int version) {
        super(STRUCT_SIZE, version);
    }

    public Impression() {
        this(0);
    }

    public static Impression deserialize(org.chromium.mojo.bindings.Message message) {
        return decode(new org.chromium.mojo.bindings.Decoder(message));
    }

    /**
     * Similar to the method above, but deserializes from a |ByteBuffer| instance.
     *
     * @throws org.chromium.mojo.bindings.DeserializationException on deserialization failure.
     */
    public static Impression deserialize(java.nio.ByteBuffer data) {
        return deserialize(new org.chromium.mojo.bindings.Message(
                data, new java.util.ArrayList<org.chromium.mojo.system.Handle>()));
    }

    @SuppressWarnings("unchecked")
    public static Impression decode(org.chromium.mojo.bindings.Decoder decoder0) {
        if (decoder0 == null) {
            return null;
        }
        decoder0.increaseStackDepth();
        Impression result;
        try {
            org.chromium.mojo.bindings.DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
            final int elementsOrVersion = mainDataHeader.elementsOrVersion;
            result = new Impression(elementsOrVersion);
                {
                    
                org.chromium.mojo.bindings.Decoder decoder1 = decoder0.readPointer(8, false);
                result.attributionSrcToken = AttributionSrcToken.decode(decoder1);
                }
                {
                    
                org.chromium.mojo.bindings.Decoder decoder1 = decoder0.readPointer(16, false);
                result.runtimeFeatures = org.chromium.network.mojom.AttributionReportingRuntimeFeatures.decode(decoder1);
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
        
        encoder0.encode(this.attributionSrcToken, 8, false);
        
        encoder0.encode(this.runtimeFeatures, 16, false);
    }
}