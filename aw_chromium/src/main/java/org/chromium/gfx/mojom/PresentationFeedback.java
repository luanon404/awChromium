// PresentationFeedback.java is auto generated by mojom_bindings_generator.py, do not edit


// Copyright 2014 The Chromium Authors
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.

// This file is autogenerated by:
//     mojo/public/tools/bindings/mojom_bindings_generator.py
// For:
//     ui/gfx/mojom/presentation_feedback.mojom
//

package org.chromium.gfx.mojom;

import androidx.annotation.IntDef;


public final class PresentationFeedback extends org.chromium.mojo.bindings.Struct {

    private static final int STRUCT_SIZE = 64;
    private static final org.chromium.mojo.bindings.DataHeader[] VERSION_ARRAY = new org.chromium.mojo.bindings.DataHeader[] {new org.chromium.mojo.bindings.DataHeader(64, 0)};
    private static final org.chromium.mojo.bindings.DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
    public org.chromium.mojo_base.mojom.TimeTicks timestamp;
    public org.chromium.mojo_base.mojom.TimeDelta interval;
    public int flags;
    public org.chromium.mojo_base.mojom.TimeTicks availableTimestamp;
    public org.chromium.mojo_base.mojom.TimeTicks readyTimestamp;
    public org.chromium.mojo_base.mojom.TimeTicks latchTimestamp;
    public org.chromium.mojo_base.mojom.TimeTicks writesDoneTimestamp;

    private PresentationFeedback(int version) {
        super(STRUCT_SIZE, version);
    }

    public PresentationFeedback() {
        this(0);
    }

    public static PresentationFeedback deserialize(org.chromium.mojo.bindings.Message message) {
        return decode(new org.chromium.mojo.bindings.Decoder(message));
    }

    /**
     * Similar to the method above, but deserializes from a |ByteBuffer| instance.
     *
     * @throws org.chromium.mojo.bindings.DeserializationException on deserialization failure.
     */
    public static PresentationFeedback deserialize(java.nio.ByteBuffer data) {
        return deserialize(new org.chromium.mojo.bindings.Message(
                data, new java.util.ArrayList<org.chromium.mojo.system.Handle>()));
    }

    @SuppressWarnings("unchecked")
    public static PresentationFeedback decode(org.chromium.mojo.bindings.Decoder decoder0) {
        if (decoder0 == null) {
            return null;
        }
        decoder0.increaseStackDepth();
        PresentationFeedback result;
        try {
            org.chromium.mojo.bindings.DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
            final int elementsOrVersion = mainDataHeader.elementsOrVersion;
            result = new PresentationFeedback(elementsOrVersion);
                {
                    
                org.chromium.mojo.bindings.Decoder decoder1 = decoder0.readPointer(8, false);
                result.timestamp = org.chromium.mojo_base.mojom.TimeTicks.decode(decoder1);
                }
                {
                    
                org.chromium.mojo.bindings.Decoder decoder1 = decoder0.readPointer(16, false);
                result.interval = org.chromium.mojo_base.mojom.TimeDelta.decode(decoder1);
                }
                {
                    
                result.flags = decoder0.readInt(24);
                }
                {
                    
                org.chromium.mojo.bindings.Decoder decoder1 = decoder0.readPointer(32, false);
                result.availableTimestamp = org.chromium.mojo_base.mojom.TimeTicks.decode(decoder1);
                }
                {
                    
                org.chromium.mojo.bindings.Decoder decoder1 = decoder0.readPointer(40, false);
                result.readyTimestamp = org.chromium.mojo_base.mojom.TimeTicks.decode(decoder1);
                }
                {
                    
                org.chromium.mojo.bindings.Decoder decoder1 = decoder0.readPointer(48, false);
                result.latchTimestamp = org.chromium.mojo_base.mojom.TimeTicks.decode(decoder1);
                }
                {
                    
                org.chromium.mojo.bindings.Decoder decoder1 = decoder0.readPointer(56, false);
                result.writesDoneTimestamp = org.chromium.mojo_base.mojom.TimeTicks.decode(decoder1);
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
        
        encoder0.encode(this.timestamp, 8, false);
        
        encoder0.encode(this.interval, 16, false);
        
        encoder0.encode(this.flags, 24);
        
        encoder0.encode(this.availableTimestamp, 32, false);
        
        encoder0.encode(this.readyTimestamp, 40, false);
        
        encoder0.encode(this.latchTimestamp, 48, false);
        
        encoder0.encode(this.writesDoneTimestamp, 56, false);
    }
}