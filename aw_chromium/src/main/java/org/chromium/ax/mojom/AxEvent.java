// AxEvent.java is auto generated by mojom_bindings_generator.py, do not edit


// Copyright 2014 The Chromium Authors
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.

// This file is autogenerated by:
//     mojo/public/tools/bindings/mojom_bindings_generator.py
// For:
//     ui/accessibility/mojom/ax_event.mojom
//

package org.chromium.ax.mojom;

import androidx.annotation.IntDef;


public final class AxEvent extends org.chromium.mojo.bindings.Struct {

    private static final int STRUCT_SIZE = 40;
    private static final org.chromium.mojo.bindings.DataHeader[] VERSION_ARRAY = new org.chromium.mojo.bindings.DataHeader[] {new org.chromium.mojo.bindings.DataHeader(40, 0)};
    private static final org.chromium.mojo.bindings.DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
    public int eventType;
    public int id;
    public int eventFrom;
    public int eventFromAction;
    public EventIntent[] eventIntents;
    public int actionRequestId;

    private AxEvent(int version) {
        super(STRUCT_SIZE, version);
    }

    public AxEvent() {
        this(0);
    }

    public static AxEvent deserialize(org.chromium.mojo.bindings.Message message) {
        return decode(new org.chromium.mojo.bindings.Decoder(message));
    }

    /**
     * Similar to the method above, but deserializes from a |ByteBuffer| instance.
     *
     * @throws org.chromium.mojo.bindings.DeserializationException on deserialization failure.
     */
    public static AxEvent deserialize(java.nio.ByteBuffer data) {
        return deserialize(new org.chromium.mojo.bindings.Message(
                data, new java.util.ArrayList<org.chromium.mojo.system.Handle>()));
    }

    @SuppressWarnings("unchecked")
    public static AxEvent decode(org.chromium.mojo.bindings.Decoder decoder0) {
        if (decoder0 == null) {
            return null;
        }
        decoder0.increaseStackDepth();
        AxEvent result;
        try {
            org.chromium.mojo.bindings.DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
            final int elementsOrVersion = mainDataHeader.elementsOrVersion;
            result = new AxEvent(elementsOrVersion);
                {
                    
                result.eventType = decoder0.readInt(8);
                    Event.validate(result.eventType);
                    result.eventType = Event.toKnownValue(result.eventType);
                }
                {
                    
                result.id = decoder0.readInt(12);
                }
                {
                    
                result.eventFrom = decoder0.readInt(16);
                    EventFrom.validate(result.eventFrom);
                    result.eventFrom = EventFrom.toKnownValue(result.eventFrom);
                }
                {
                    
                result.eventFromAction = decoder0.readInt(20);
                    Action.validate(result.eventFromAction);
                    result.eventFromAction = Action.toKnownValue(result.eventFromAction);
                }
                {
                    
                org.chromium.mojo.bindings.Decoder decoder1 = decoder0.readPointer(24, false);
                {
                    org.chromium.mojo.bindings.DataHeader si1 = decoder1.readDataHeaderForPointerArray(org.chromium.mojo.bindings.BindingsHelper.UNSPECIFIED_ARRAY_LENGTH);
                    result.eventIntents = new EventIntent[si1.elementsOrVersion];
                    for (int i1 = 0; i1 < si1.elementsOrVersion; ++i1) {
                        
                        org.chromium.mojo.bindings.Decoder decoder2 = decoder1.readPointer(org.chromium.mojo.bindings.DataHeader.HEADER_SIZE + org.chromium.mojo.bindings.BindingsHelper.POINTER_SIZE * i1, false);
                        result.eventIntents[i1] = EventIntent.decode(decoder2);
                    }
                }
                }
                {
                    
                result.actionRequestId = decoder0.readInt(32);
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
        
        encoder0.encode(this.eventType, 8);
        
        encoder0.encode(this.id, 12);
        
        encoder0.encode(this.eventFrom, 16);
        
        encoder0.encode(this.eventFromAction, 20);
        
        if (this.eventIntents == null) {
            encoder0.encodeNullPointer(24, false);
        } else {
            org.chromium.mojo.bindings.Encoder encoder1 = encoder0.encodePointerArray(this.eventIntents.length, 24, org.chromium.mojo.bindings.BindingsHelper.UNSPECIFIED_ARRAY_LENGTH);
            for (int i0 = 0; i0 < this.eventIntents.length; ++i0) {
                
                encoder1.encode(this.eventIntents[i0], org.chromium.mojo.bindings.DataHeader.HEADER_SIZE + org.chromium.mojo.bindings.BindingsHelper.POINTER_SIZE * i0, false);
            }
        }
        
        encoder0.encode(this.actionRequestId, 32);
    }
}