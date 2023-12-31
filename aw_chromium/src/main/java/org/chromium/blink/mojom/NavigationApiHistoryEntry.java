// NavigationApiHistoryEntry.java is auto generated by mojom_bindings_generator.py, do not edit


// Copyright 2014 The Chromium Authors
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.

// This file is autogenerated by:
//     mojo/public/tools/bindings/mojom_bindings_generator.py
// For:
//     third_party/blink/public/mojom/navigation/navigation_api_history_entry_arrays.mojom
//

package org.chromium.blink.mojom;

import androidx.annotation.IntDef;


public final class NavigationApiHistoryEntry extends org.chromium.mojo.bindings.Struct {

    private static final int STRUCT_SIZE = 56;
    private static final org.chromium.mojo.bindings.DataHeader[] VERSION_ARRAY = new org.chromium.mojo.bindings.DataHeader[] {new org.chromium.mojo.bindings.DataHeader(56, 0)};
    private static final org.chromium.mojo.bindings.DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
    public org.chromium.mojo_base.mojom.String16 key;
    public org.chromium.mojo_base.mojom.String16 id;
    public org.chromium.mojo_base.mojom.String16 url;
    public long itemSequenceNumber;
    public long documentSequenceNumber;
    public org.chromium.mojo_base.mojom.String16 state;

    private NavigationApiHistoryEntry(int version) {
        super(STRUCT_SIZE, version);
    }

    public NavigationApiHistoryEntry() {
        this(0);
    }

    public static NavigationApiHistoryEntry deserialize(org.chromium.mojo.bindings.Message message) {
        return decode(new org.chromium.mojo.bindings.Decoder(message));
    }

    /**
     * Similar to the method above, but deserializes from a |ByteBuffer| instance.
     *
     * @throws org.chromium.mojo.bindings.DeserializationException on deserialization failure.
     */
    public static NavigationApiHistoryEntry deserialize(java.nio.ByteBuffer data) {
        return deserialize(new org.chromium.mojo.bindings.Message(
                data, new java.util.ArrayList<org.chromium.mojo.system.Handle>()));
    }

    @SuppressWarnings("unchecked")
    public static NavigationApiHistoryEntry decode(org.chromium.mojo.bindings.Decoder decoder0) {
        if (decoder0 == null) {
            return null;
        }
        decoder0.increaseStackDepth();
        NavigationApiHistoryEntry result;
        try {
            org.chromium.mojo.bindings.DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
            final int elementsOrVersion = mainDataHeader.elementsOrVersion;
            result = new NavigationApiHistoryEntry(elementsOrVersion);
                {
                    
                org.chromium.mojo.bindings.Decoder decoder1 = decoder0.readPointer(8, false);
                result.key = org.chromium.mojo_base.mojom.String16.decode(decoder1);
                }
                {
                    
                org.chromium.mojo.bindings.Decoder decoder1 = decoder0.readPointer(16, false);
                result.id = org.chromium.mojo_base.mojom.String16.decode(decoder1);
                }
                {
                    
                org.chromium.mojo.bindings.Decoder decoder1 = decoder0.readPointer(24, false);
                result.url = org.chromium.mojo_base.mojom.String16.decode(decoder1);
                }
                {
                    
                result.itemSequenceNumber = decoder0.readLong(32);
                }
                {
                    
                result.documentSequenceNumber = decoder0.readLong(40);
                }
                {
                    
                org.chromium.mojo.bindings.Decoder decoder1 = decoder0.readPointer(48, true);
                result.state = org.chromium.mojo_base.mojom.String16.decode(decoder1);
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
        
        encoder0.encode(this.key, 8, false);
        
        encoder0.encode(this.id, 16, false);
        
        encoder0.encode(this.url, 24, false);
        
        encoder0.encode(this.itemSequenceNumber, 32);
        
        encoder0.encode(this.documentSequenceNumber, 40);
        
        encoder0.encode(this.state, 48, true);
    }
}