// SharedArrayBufferIssueDetails.java is auto generated by mojom_bindings_generator.py, do not edit


// Copyright 2014 The Chromium Authors
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.

// This file is autogenerated by:
//     mojo/public/tools/bindings/mojom_bindings_generator.py
// For:
//     third_party/blink/public/mojom/devtools/inspector_issue.mojom
//

package org.chromium.blink.mojom;

import androidx.annotation.IntDef;


public final class SharedArrayBufferIssueDetails extends org.chromium.mojo.bindings.Struct {

    private static final int STRUCT_SIZE = 24;
    private static final org.chromium.mojo.bindings.DataHeader[] VERSION_ARRAY = new org.chromium.mojo.bindings.DataHeader[] {new org.chromium.mojo.bindings.DataHeader(24, 0)};
    private static final org.chromium.mojo.bindings.DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
    public AffectedLocation affectedLocation;
    public boolean isWarning;
    public int type;

    private SharedArrayBufferIssueDetails(int version) {
        super(STRUCT_SIZE, version);
    }

    public SharedArrayBufferIssueDetails() {
        this(0);
    }

    public static SharedArrayBufferIssueDetails deserialize(org.chromium.mojo.bindings.Message message) {
        return decode(new org.chromium.mojo.bindings.Decoder(message));
    }

    /**
     * Similar to the method above, but deserializes from a |ByteBuffer| instance.
     *
     * @throws org.chromium.mojo.bindings.DeserializationException on deserialization failure.
     */
    public static SharedArrayBufferIssueDetails deserialize(java.nio.ByteBuffer data) {
        return deserialize(new org.chromium.mojo.bindings.Message(
                data, new java.util.ArrayList<org.chromium.mojo.system.Handle>()));
    }

    @SuppressWarnings("unchecked")
    public static SharedArrayBufferIssueDetails decode(org.chromium.mojo.bindings.Decoder decoder0) {
        if (decoder0 == null) {
            return null;
        }
        decoder0.increaseStackDepth();
        SharedArrayBufferIssueDetails result;
        try {
            org.chromium.mojo.bindings.DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
            final int elementsOrVersion = mainDataHeader.elementsOrVersion;
            result = new SharedArrayBufferIssueDetails(elementsOrVersion);
                {
                    
                org.chromium.mojo.bindings.Decoder decoder1 = decoder0.readPointer(8, true);
                result.affectedLocation = AffectedLocation.decode(decoder1);
                }
                {
                    
                result.isWarning = decoder0.readBoolean(16, 0);
                }
                {
                    
                result.type = decoder0.readInt(20);
                    SharedArrayBufferIssueType.validate(result.type);
                    result.type = SharedArrayBufferIssueType.toKnownValue(result.type);
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
        
        encoder0.encode(this.affectedLocation, 8, true);
        
        encoder0.encode(this.isWarning, 16, 0);
        
        encoder0.encode(this.type, 20);
    }
}