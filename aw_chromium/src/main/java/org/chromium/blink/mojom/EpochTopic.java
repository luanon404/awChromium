// EpochTopic.java is auto generated by mojom_bindings_generator.py, do not edit


// Copyright 2014 The Chromium Authors
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.

// This file is autogenerated by:
//     mojo/public/tools/bindings/mojom_bindings_generator.py
// For:
//     third_party/blink/public/mojom/browsing_topics/browsing_topics.mojom
//

package org.chromium.blink.mojom;

import androidx.annotation.IntDef;


public final class EpochTopic extends org.chromium.mojo.bindings.Struct {

    private static final int STRUCT_SIZE = 48;
    private static final org.chromium.mojo.bindings.DataHeader[] VERSION_ARRAY = new org.chromium.mojo.bindings.DataHeader[] {new org.chromium.mojo.bindings.DataHeader(48, 0)};
    private static final org.chromium.mojo.bindings.DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
    public int topic;
    public String version;
    public String configVersion;
    public String modelVersion;
    public String taxonomyVersion;

    private EpochTopic(int version) {
        super(STRUCT_SIZE, version);
    }

    public EpochTopic() {
        this(0);
    }

    public static EpochTopic deserialize(org.chromium.mojo.bindings.Message message) {
        return decode(new org.chromium.mojo.bindings.Decoder(message));
    }

    /**
     * Similar to the method above, but deserializes from a |ByteBuffer| instance.
     *
     * @throws org.chromium.mojo.bindings.DeserializationException on deserialization failure.
     */
    public static EpochTopic deserialize(java.nio.ByteBuffer data) {
        return deserialize(new org.chromium.mojo.bindings.Message(
                data, new java.util.ArrayList<org.chromium.mojo.system.Handle>()));
    }

    @SuppressWarnings("unchecked")
    public static EpochTopic decode(org.chromium.mojo.bindings.Decoder decoder0) {
        if (decoder0 == null) {
            return null;
        }
        decoder0.increaseStackDepth();
        EpochTopic result;
        try {
            org.chromium.mojo.bindings.DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
            final int elementsOrVersion = mainDataHeader.elementsOrVersion;
            result = new EpochTopic(elementsOrVersion);
                {
                    
                result.topic = decoder0.readInt(8);
                }
                {
                    
                result.version = decoder0.readString(16, false);
                }
                {
                    
                result.configVersion = decoder0.readString(24, false);
                }
                {
                    
                result.modelVersion = decoder0.readString(32, false);
                }
                {
                    
                result.taxonomyVersion = decoder0.readString(40, false);
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
        
        encoder0.encode(this.topic, 8);
        
        encoder0.encode(this.version, 16, false);
        
        encoder0.encode(this.configVersion, 24, false);
        
        encoder0.encode(this.modelVersion, 32, false);
        
        encoder0.encode(this.taxonomyVersion, 40, false);
    }
}