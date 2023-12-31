// SecondaryPlaybackProperties.java is auto generated by mojom_bindings_generator.py, do not edit


// Copyright 2014 The Chromium Authors
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.

// This file is autogenerated by:
//     mojo/public/tools/bindings/mojom_bindings_generator.py
// For:
//     media/mojo/mojom/watch_time_recorder.mojom
//

package org.chromium.media.mojom;

import androidx.annotation.IntDef;


public final class SecondaryPlaybackProperties extends org.chromium.mojo.bindings.Struct {

    private static final int STRUCT_SIZE = 48;
    private static final org.chromium.mojo.bindings.DataHeader[] VERSION_ARRAY = new org.chromium.mojo.bindings.DataHeader[] {new org.chromium.mojo.bindings.DataHeader(48, 0)};
    private static final org.chromium.mojo.bindings.DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
    public int audioCodec;
    public int videoCodec;
    public int audioCodecProfile;
    public int videoCodecProfile;
    public int audioDecoder;
    public int videoDecoder;
    public int audioEncryptionScheme;
    public int videoEncryptionScheme;
    public org.chromium.gfx.mojom.Size naturalSize;

    private SecondaryPlaybackProperties(int version) {
        super(STRUCT_SIZE, version);
    }

    public SecondaryPlaybackProperties() {
        this(0);
    }

    public static SecondaryPlaybackProperties deserialize(org.chromium.mojo.bindings.Message message) {
        return decode(new org.chromium.mojo.bindings.Decoder(message));
    }

    /**
     * Similar to the method above, but deserializes from a |ByteBuffer| instance.
     *
     * @throws org.chromium.mojo.bindings.DeserializationException on deserialization failure.
     */
    public static SecondaryPlaybackProperties deserialize(java.nio.ByteBuffer data) {
        return deserialize(new org.chromium.mojo.bindings.Message(
                data, new java.util.ArrayList<org.chromium.mojo.system.Handle>()));
    }

    @SuppressWarnings("unchecked")
    public static SecondaryPlaybackProperties decode(org.chromium.mojo.bindings.Decoder decoder0) {
        if (decoder0 == null) {
            return null;
        }
        decoder0.increaseStackDepth();
        SecondaryPlaybackProperties result;
        try {
            org.chromium.mojo.bindings.DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
            final int elementsOrVersion = mainDataHeader.elementsOrVersion;
            result = new SecondaryPlaybackProperties(elementsOrVersion);
                {
                    
                result.audioCodec = decoder0.readInt(8);
                    AudioCodec.validate(result.audioCodec);
                    result.audioCodec = AudioCodec.toKnownValue(result.audioCodec);
                }
                {
                    
                result.videoCodec = decoder0.readInt(12);
                    VideoCodec.validate(result.videoCodec);
                    result.videoCodec = VideoCodec.toKnownValue(result.videoCodec);
                }
                {
                    
                result.audioCodecProfile = decoder0.readInt(16);
                    AudioCodecProfile.validate(result.audioCodecProfile);
                    result.audioCodecProfile = AudioCodecProfile.toKnownValue(result.audioCodecProfile);
                }
                {
                    
                result.videoCodecProfile = decoder0.readInt(20);
                    VideoCodecProfile.validate(result.videoCodecProfile);
                    result.videoCodecProfile = VideoCodecProfile.toKnownValue(result.videoCodecProfile);
                }
                {
                    
                result.audioDecoder = decoder0.readInt(24);
                    AudioDecoderType.validate(result.audioDecoder);
                    result.audioDecoder = AudioDecoderType.toKnownValue(result.audioDecoder);
                }
                {
                    
                result.videoDecoder = decoder0.readInt(28);
                    VideoDecoderType.validate(result.videoDecoder);
                    result.videoDecoder = VideoDecoderType.toKnownValue(result.videoDecoder);
                }
                {
                    
                result.audioEncryptionScheme = decoder0.readInt(32);
                    EncryptionScheme.validate(result.audioEncryptionScheme);
                    result.audioEncryptionScheme = EncryptionScheme.toKnownValue(result.audioEncryptionScheme);
                }
                {
                    
                result.videoEncryptionScheme = decoder0.readInt(36);
                    EncryptionScheme.validate(result.videoEncryptionScheme);
                    result.videoEncryptionScheme = EncryptionScheme.toKnownValue(result.videoEncryptionScheme);
                }
                {
                    
                org.chromium.mojo.bindings.Decoder decoder1 = decoder0.readPointer(40, false);
                result.naturalSize = org.chromium.gfx.mojom.Size.decode(decoder1);
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
        
        encoder0.encode(this.audioCodec, 8);
        
        encoder0.encode(this.videoCodec, 12);
        
        encoder0.encode(this.audioCodecProfile, 16);
        
        encoder0.encode(this.videoCodecProfile, 20);
        
        encoder0.encode(this.audioDecoder, 24);
        
        encoder0.encode(this.videoDecoder, 28);
        
        encoder0.encode(this.audioEncryptionScheme, 32);
        
        encoder0.encode(this.videoEncryptionScheme, 36);
        
        encoder0.encode(this.naturalSize, 40, false);
    }
}