// AudioProcessingSettings.java is auto generated by mojom_bindings_generator.py, do not edit


// Copyright 2014 The Chromium Authors
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.

// This file is autogenerated by:
//     mojo/public/tools/bindings/mojom_bindings_generator.py
// For:
//     media/mojo/mojom/audio_processing.mojom
//

package org.chromium.media.mojom;

import androidx.annotation.IntDef;


public final class AudioProcessingSettings extends org.chromium.mojo.bindings.Struct {

    private static final int STRUCT_SIZE = 16;
    private static final org.chromium.mojo.bindings.DataHeader[] VERSION_ARRAY = new org.chromium.mojo.bindings.DataHeader[] {new org.chromium.mojo.bindings.DataHeader(16, 0)};
    private static final org.chromium.mojo.bindings.DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
    public boolean echoCancellation;
    public boolean noiseSuppression;
    public boolean transientNoiseSuppression;
    public boolean automaticGainControl;
    public boolean highPassFilter;
    public boolean multiChannelCaptureProcessing;
    public boolean stereoMirroring;
    public boolean forceApmCreation;

    private AudioProcessingSettings(int version) {
        super(STRUCT_SIZE, version);
    }

    public AudioProcessingSettings() {
        this(0);
    }

    public static AudioProcessingSettings deserialize(org.chromium.mojo.bindings.Message message) {
        return decode(new org.chromium.mojo.bindings.Decoder(message));
    }

    /**
     * Similar to the method above, but deserializes from a |ByteBuffer| instance.
     *
     * @throws org.chromium.mojo.bindings.DeserializationException on deserialization failure.
     */
    public static AudioProcessingSettings deserialize(java.nio.ByteBuffer data) {
        return deserialize(new org.chromium.mojo.bindings.Message(
                data, new java.util.ArrayList<org.chromium.mojo.system.Handle>()));
    }

    @SuppressWarnings("unchecked")
    public static AudioProcessingSettings decode(org.chromium.mojo.bindings.Decoder decoder0) {
        if (decoder0 == null) {
            return null;
        }
        decoder0.increaseStackDepth();
        AudioProcessingSettings result;
        try {
            org.chromium.mojo.bindings.DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
            final int elementsOrVersion = mainDataHeader.elementsOrVersion;
            result = new AudioProcessingSettings(elementsOrVersion);
                {
                    
                result.echoCancellation = decoder0.readBoolean(8, 0);
                }
                {
                    
                result.noiseSuppression = decoder0.readBoolean(8, 1);
                }
                {
                    
                result.transientNoiseSuppression = decoder0.readBoolean(8, 2);
                }
                {
                    
                result.automaticGainControl = decoder0.readBoolean(8, 3);
                }
                {
                    
                result.highPassFilter = decoder0.readBoolean(8, 4);
                }
                {
                    
                result.multiChannelCaptureProcessing = decoder0.readBoolean(8, 5);
                }
                {
                    
                result.stereoMirroring = decoder0.readBoolean(8, 6);
                }
                {
                    
                result.forceApmCreation = decoder0.readBoolean(8, 7);
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
        
        encoder0.encode(this.echoCancellation, 8, 0);
        
        encoder0.encode(this.noiseSuppression, 8, 1);
        
        encoder0.encode(this.transientNoiseSuppression, 8, 2);
        
        encoder0.encode(this.automaticGainControl, 8, 3);
        
        encoder0.encode(this.highPassFilter, 8, 4);
        
        encoder0.encode(this.multiChannelCaptureProcessing, 8, 5);
        
        encoder0.encode(this.stereoMirroring, 8, 6);
        
        encoder0.encode(this.forceApmCreation, 8, 7);
    }
}