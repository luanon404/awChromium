// ResolutionBitrateLimit.java is auto generated by mojom_bindings_generator.py, do not edit


// Copyright 2014 The Chromium Authors
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.

// This file is autogenerated by:
//     mojo/public/tools/bindings/mojom_bindings_generator.py
// For:
//     media/mojo/mojom/video_encoder_info.mojom
//

package org.chromium.media.mojom;

import androidx.annotation.IntDef;


public final class ResolutionBitrateLimit extends org.chromium.mojo.bindings.Struct {

    private static final int STRUCT_SIZE = 32;
    private static final org.chromium.mojo.bindings.DataHeader[] VERSION_ARRAY = new org.chromium.mojo.bindings.DataHeader[] {new org.chromium.mojo.bindings.DataHeader(32, 0)};
    private static final org.chromium.mojo.bindings.DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
    public org.chromium.gfx.mojom.Size frameSize;
    public int minStartBitrateBps;
    public int minBitrateBps;
    public int maxBitrateBps;

    private ResolutionBitrateLimit(int version) {
        super(STRUCT_SIZE, version);
    }

    public ResolutionBitrateLimit() {
        this(0);
    }

    public static ResolutionBitrateLimit deserialize(org.chromium.mojo.bindings.Message message) {
        return decode(new org.chromium.mojo.bindings.Decoder(message));
    }

    /**
     * Similar to the method above, but deserializes from a |ByteBuffer| instance.
     *
     * @throws org.chromium.mojo.bindings.DeserializationException on deserialization failure.
     */
    public static ResolutionBitrateLimit deserialize(java.nio.ByteBuffer data) {
        return deserialize(new org.chromium.mojo.bindings.Message(
                data, new java.util.ArrayList<org.chromium.mojo.system.Handle>()));
    }

    @SuppressWarnings("unchecked")
    public static ResolutionBitrateLimit decode(org.chromium.mojo.bindings.Decoder decoder0) {
        if (decoder0 == null) {
            return null;
        }
        decoder0.increaseStackDepth();
        ResolutionBitrateLimit result;
        try {
            org.chromium.mojo.bindings.DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
            final int elementsOrVersion = mainDataHeader.elementsOrVersion;
            result = new ResolutionBitrateLimit(elementsOrVersion);
                {
                    
                org.chromium.mojo.bindings.Decoder decoder1 = decoder0.readPointer(8, false);
                result.frameSize = org.chromium.gfx.mojom.Size.decode(decoder1);
                }
                {
                    
                result.minStartBitrateBps = decoder0.readInt(16);
                }
                {
                    
                result.minBitrateBps = decoder0.readInt(20);
                }
                {
                    
                result.maxBitrateBps = decoder0.readInt(24);
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
        
        encoder0.encode(this.frameSize, 8, false);
        
        encoder0.encode(this.minStartBitrateBps, 16);
        
        encoder0.encode(this.minBitrateBps, 20);
        
        encoder0.encode(this.maxBitrateBps, 24);
    }
}