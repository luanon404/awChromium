// DragItemBinary.java is auto generated by mojom_bindings_generator.py, do not edit


// Copyright 2014 The Chromium Authors
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.

// This file is autogenerated by:
//     mojo/public/tools/bindings/mojom_bindings_generator.py
// For:
//     third_party/blink/public/mojom/drag/drag.mojom
//

package org.chromium.blink.mojom;

import androidx.annotation.IntDef;


public final class DragItemBinary extends org.chromium.mojo.bindings.Struct {

    private static final int STRUCT_SIZE = 56;
    private static final org.chromium.mojo.bindings.DataHeader[] VERSION_ARRAY = new org.chromium.mojo.bindings.DataHeader[] {new org.chromium.mojo.bindings.DataHeader(56, 0)};
    private static final org.chromium.mojo.bindings.DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
    public org.chromium.mojo_base.mojom.BigBuffer data;
    public boolean isImageAccessible;
    public org.chromium.url.mojom.Url sourceUrl;
    public org.chromium.mojo_base.mojom.FilePath filenameExtension;
    public String contentDisposition;

    private DragItemBinary(int version) {
        super(STRUCT_SIZE, version);
    }

    public DragItemBinary() {
        this(0);
    }

    public static DragItemBinary deserialize(org.chromium.mojo.bindings.Message message) {
        return decode(new org.chromium.mojo.bindings.Decoder(message));
    }

    /**
     * Similar to the method above, but deserializes from a |ByteBuffer| instance.
     *
     * @throws org.chromium.mojo.bindings.DeserializationException on deserialization failure.
     */
    public static DragItemBinary deserialize(java.nio.ByteBuffer data) {
        return deserialize(new org.chromium.mojo.bindings.Message(
                data, new java.util.ArrayList<org.chromium.mojo.system.Handle>()));
    }

    @SuppressWarnings("unchecked")
    public static DragItemBinary decode(org.chromium.mojo.bindings.Decoder decoder0) {
        if (decoder0 == null) {
            return null;
        }
        decoder0.increaseStackDepth();
        DragItemBinary result;
        try {
            org.chromium.mojo.bindings.DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
            final int elementsOrVersion = mainDataHeader.elementsOrVersion;
            result = new DragItemBinary(elementsOrVersion);
                {
                    
                result.data = org.chromium.mojo_base.mojom.BigBuffer.decode(decoder0, 8);
                }
                {
                    
                result.isImageAccessible = decoder0.readBoolean(24, 0);
                }
                {
                    
                org.chromium.mojo.bindings.Decoder decoder1 = decoder0.readPointer(32, false);
                result.sourceUrl = org.chromium.url.mojom.Url.decode(decoder1);
                }
                {
                    
                org.chromium.mojo.bindings.Decoder decoder1 = decoder0.readPointer(40, false);
                result.filenameExtension = org.chromium.mojo_base.mojom.FilePath.decode(decoder1);
                }
                {
                    
                result.contentDisposition = decoder0.readString(48, true);
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
        
        encoder0.encode(this.data, 8, false);
        
        encoder0.encode(this.isImageAccessible, 24, 0);
        
        encoder0.encode(this.sourceUrl, 32, false);
        
        encoder0.encode(this.filenameExtension, 40, false);
        
        encoder0.encode(this.contentDisposition, 48, true);
    }
}