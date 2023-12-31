// WheelData.java is auto generated by mojom_bindings_generator.py, do not edit


// Copyright 2014 The Chromium Authors
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.

// This file is autogenerated by:
//     mojo/public/tools/bindings/mojom_bindings_generator.py
// For:
//     third_party/blink/public/mojom/input/input_handler.mojom
//

package org.chromium.blink.mojom;

import androidx.annotation.IntDef;


public final class WheelData extends org.chromium.mojo.bindings.Struct {

    private static final int STRUCT_SIZE = 40;
    private static final org.chromium.mojo.bindings.DataHeader[] VERSION_ARRAY = new org.chromium.mojo.bindings.DataHeader[] {new org.chromium.mojo.bindings.DataHeader(40, 0)};
    private static final org.chromium.mojo.bindings.DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
    public float deltaX;
    public float deltaY;
    public float wheelTicksX;
    public float wheelTicksY;
    public float accelerationRatioX;
    public float accelerationRatioY;
    public byte phase;
    public byte momentumPhase;
    public int cancelable;
    public byte eventAction;
    public byte deltaUnits;

    private WheelData(int version) {
        super(STRUCT_SIZE, version);
    }

    public WheelData() {
        this(0);
    }

    public static WheelData deserialize(org.chromium.mojo.bindings.Message message) {
        return decode(new org.chromium.mojo.bindings.Decoder(message));
    }

    /**
     * Similar to the method above, but deserializes from a |ByteBuffer| instance.
     *
     * @throws org.chromium.mojo.bindings.DeserializationException on deserialization failure.
     */
    public static WheelData deserialize(java.nio.ByteBuffer data) {
        return deserialize(new org.chromium.mojo.bindings.Message(
                data, new java.util.ArrayList<org.chromium.mojo.system.Handle>()));
    }

    @SuppressWarnings("unchecked")
    public static WheelData decode(org.chromium.mojo.bindings.Decoder decoder0) {
        if (decoder0 == null) {
            return null;
        }
        decoder0.increaseStackDepth();
        WheelData result;
        try {
            org.chromium.mojo.bindings.DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
            final int elementsOrVersion = mainDataHeader.elementsOrVersion;
            result = new WheelData(elementsOrVersion);
                {
                    
                result.deltaX = decoder0.readFloat(8);
                }
                {
                    
                result.deltaY = decoder0.readFloat(12);
                }
                {
                    
                result.wheelTicksX = decoder0.readFloat(16);
                }
                {
                    
                result.wheelTicksY = decoder0.readFloat(20);
                }
                {
                    
                result.accelerationRatioX = decoder0.readFloat(24);
                }
                {
                    
                result.accelerationRatioY = decoder0.readFloat(28);
                }
                {
                    
                result.phase = decoder0.readByte(32);
                }
                {
                    
                result.momentumPhase = decoder0.readByte(33);
                }
                {
                    
                result.eventAction = decoder0.readByte(34);
                }
                {
                    
                result.deltaUnits = decoder0.readByte(35);
                }
                {
                    
                result.cancelable = decoder0.readInt(36);
                    DispatchType.validate(result.cancelable);
                    result.cancelable = DispatchType.toKnownValue(result.cancelable);
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
        
        encoder0.encode(this.deltaX, 8);
        
        encoder0.encode(this.deltaY, 12);
        
        encoder0.encode(this.wheelTicksX, 16);
        
        encoder0.encode(this.wheelTicksY, 20);
        
        encoder0.encode(this.accelerationRatioX, 24);
        
        encoder0.encode(this.accelerationRatioY, 28);
        
        encoder0.encode(this.phase, 32);
        
        encoder0.encode(this.momentumPhase, 33);
        
        encoder0.encode(this.eventAction, 34);
        
        encoder0.encode(this.deltaUnits, 35);
        
        encoder0.encode(this.cancelable, 36);
    }
}