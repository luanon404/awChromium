// FrameDeadline.java is auto generated by mojom_bindings_generator.py, do not edit


// Copyright 2014 The Chromium Authors
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.

// This file is autogenerated by:
//     mojo/public/tools/bindings/mojom_bindings_generator.py
// For:
//     services/viz/public/mojom/compositing/frame_deadline.mojom
//

package org.chromium.viz.mojom;

import androidx.annotation.IntDef;


public final class FrameDeadline extends org.chromium.mojo.bindings.Struct {

    private static final int STRUCT_SIZE = 32;
    private static final org.chromium.mojo.bindings.DataHeader[] VERSION_ARRAY = new org.chromium.mojo.bindings.DataHeader[] {new org.chromium.mojo.bindings.DataHeader(32, 0)};
    private static final org.chromium.mojo.bindings.DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
    public org.chromium.mojo_base.mojom.TimeTicks frameStartTime;
    public int deadlineInFrames;
    public org.chromium.mojo_base.mojom.TimeDelta frameInterval;
    public boolean useDefaultLowerBoundDeadline;

    private FrameDeadline(int version) {
        super(STRUCT_SIZE, version);
    }

    public FrameDeadline() {
        this(0);
    }

    public static FrameDeadline deserialize(org.chromium.mojo.bindings.Message message) {
        return decode(new org.chromium.mojo.bindings.Decoder(message));
    }

    /**
     * Similar to the method above, but deserializes from a |ByteBuffer| instance.
     *
     * @throws org.chromium.mojo.bindings.DeserializationException on deserialization failure.
     */
    public static FrameDeadline deserialize(java.nio.ByteBuffer data) {
        return deserialize(new org.chromium.mojo.bindings.Message(
                data, new java.util.ArrayList<org.chromium.mojo.system.Handle>()));
    }

    @SuppressWarnings("unchecked")
    public static FrameDeadline decode(org.chromium.mojo.bindings.Decoder decoder0) {
        if (decoder0 == null) {
            return null;
        }
        decoder0.increaseStackDepth();
        FrameDeadline result;
        try {
            org.chromium.mojo.bindings.DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
            final int elementsOrVersion = mainDataHeader.elementsOrVersion;
            result = new FrameDeadline(elementsOrVersion);
                {
                    
                org.chromium.mojo.bindings.Decoder decoder1 = decoder0.readPointer(8, false);
                result.frameStartTime = org.chromium.mojo_base.mojom.TimeTicks.decode(decoder1);
                }
                {
                    
                result.deadlineInFrames = decoder0.readInt(16);
                }
                {
                    
                result.useDefaultLowerBoundDeadline = decoder0.readBoolean(20, 0);
                }
                {
                    
                org.chromium.mojo.bindings.Decoder decoder1 = decoder0.readPointer(24, false);
                result.frameInterval = org.chromium.mojo_base.mojom.TimeDelta.decode(decoder1);
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
        
        encoder0.encode(this.frameStartTime, 8, false);
        
        encoder0.encode(this.deadlineInFrames, 16);
        
        encoder0.encode(this.useDefaultLowerBoundDeadline, 20, 0);
        
        encoder0.encode(this.frameInterval, 24, false);
    }
}