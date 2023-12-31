// AudioFocusRequestState.java is auto generated by mojom_bindings_generator.py, do not edit


// Copyright 2014 The Chromium Authors
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.

// This file is autogenerated by:
//     mojo/public/tools/bindings/mojom_bindings_generator.py
// For:
//     services/media_session/public/mojom/audio_focus.mojom
//

package org.chromium.media_session.mojom;

import androidx.annotation.IntDef;


public final class AudioFocusRequestState extends org.chromium.mojo.bindings.Struct {

    private static final int STRUCT_SIZE = 48;
    private static final org.chromium.mojo.bindings.DataHeader[] VERSION_ARRAY = new org.chromium.mojo.bindings.DataHeader[] {new org.chromium.mojo.bindings.DataHeader(24, 0),new org.chromium.mojo.bindings.DataHeader(32, 2),new org.chromium.mojo.bindings.DataHeader(40, 3),new org.chromium.mojo.bindings.DataHeader(48, 9)};
    private static final org.chromium.mojo.bindings.DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[3];
    public MediaSessionInfo sessionInfo;
    public int audioFocusType;
    public String sourceName;
    public org.chromium.mojo_base.mojom.UnguessableToken requestId;
    public org.chromium.mojo_base.mojom.UnguessableToken sourceId;

    private AudioFocusRequestState(int version) {
        super(STRUCT_SIZE, version);
    }

    public AudioFocusRequestState() {
        this(9);
    }

    public static AudioFocusRequestState deserialize(org.chromium.mojo.bindings.Message message) {
        return decode(new org.chromium.mojo.bindings.Decoder(message));
    }

    /**
     * Similar to the method above, but deserializes from a |ByteBuffer| instance.
     *
     * @throws org.chromium.mojo.bindings.DeserializationException on deserialization failure.
     */
    public static AudioFocusRequestState deserialize(java.nio.ByteBuffer data) {
        return deserialize(new org.chromium.mojo.bindings.Message(
                data, new java.util.ArrayList<org.chromium.mojo.system.Handle>()));
    }

    @SuppressWarnings("unchecked")
    public static AudioFocusRequestState decode(org.chromium.mojo.bindings.Decoder decoder0) {
        if (decoder0 == null) {
            return null;
        }
        decoder0.increaseStackDepth();
        AudioFocusRequestState result;
        try {
            org.chromium.mojo.bindings.DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
            final int elementsOrVersion = mainDataHeader.elementsOrVersion;
            result = new AudioFocusRequestState(elementsOrVersion);
                {
                    
                org.chromium.mojo.bindings.Decoder decoder1 = decoder0.readPointer(8, false);
                result.sessionInfo = MediaSessionInfo.decode(decoder1);
                }
                {
                    
                result.audioFocusType = decoder0.readInt(16);
                    AudioFocusType.validate(result.audioFocusType);
                    result.audioFocusType = AudioFocusType.toKnownValue(result.audioFocusType);
                }
            if (elementsOrVersion >= 2) {
                {
                    
                result.sourceName = decoder0.readString(24, true);
                }
            }
            if (elementsOrVersion >= 3) {
                {
                    
                org.chromium.mojo.bindings.Decoder decoder1 = decoder0.readPointer(32, true);
                result.requestId = org.chromium.mojo_base.mojom.UnguessableToken.decode(decoder1);
                }
            }
            if (elementsOrVersion >= 9) {
                {
                    
                org.chromium.mojo.bindings.Decoder decoder1 = decoder0.readPointer(40, true);
                result.sourceId = org.chromium.mojo_base.mojom.UnguessableToken.decode(decoder1);
                }
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
        
        encoder0.encode(this.sessionInfo, 8, false);
        
        encoder0.encode(this.audioFocusType, 16);
        
        encoder0.encode(this.sourceName, 24, true);
        
        encoder0.encode(this.requestId, 32, true);
        
        encoder0.encode(this.sourceId, 40, true);
    }
}