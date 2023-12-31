// StartSpeechRecognitionRequestParams.java is auto generated by mojom_bindings_generator.py, do not edit


// Copyright 2014 The Chromium Authors
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.

// This file is autogenerated by:
//     mojo/public/tools/bindings/mojom_bindings_generator.py
// For:
//     third_party/blink/public/mojom/speech/speech_recognizer.mojom
//

package org.chromium.blink.mojom;

import androidx.annotation.IntDef;


public final class StartSpeechRecognitionRequestParams extends org.chromium.mojo.bindings.Struct {

    private static final int STRUCT_SIZE = 48;
    private static final org.chromium.mojo.bindings.DataHeader[] VERSION_ARRAY = new org.chromium.mojo.bindings.DataHeader[] {new org.chromium.mojo.bindings.DataHeader(48, 0)};
    private static final org.chromium.mojo.bindings.DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
    public org.chromium.mojo.bindings.InterfaceRequest<SpeechRecognitionSession> sessionReceiver;
    public SpeechRecognitionSessionClient client;
    public String language;
    public SpeechRecognitionGrammar[] grammars;
    public int maxHypotheses;
    public boolean continuous;
    public boolean interimResults;

    private StartSpeechRecognitionRequestParams(int version) {
        super(STRUCT_SIZE, version);
    }

    public StartSpeechRecognitionRequestParams() {
        this(0);
    }

    public static StartSpeechRecognitionRequestParams deserialize(org.chromium.mojo.bindings.Message message) {
        return decode(new org.chromium.mojo.bindings.Decoder(message));
    }

    /**
     * Similar to the method above, but deserializes from a |ByteBuffer| instance.
     *
     * @throws org.chromium.mojo.bindings.DeserializationException on deserialization failure.
     */
    public static StartSpeechRecognitionRequestParams deserialize(java.nio.ByteBuffer data) {
        return deserialize(new org.chromium.mojo.bindings.Message(
                data, new java.util.ArrayList<org.chromium.mojo.system.Handle>()));
    }

    @SuppressWarnings("unchecked")
    public static StartSpeechRecognitionRequestParams decode(org.chromium.mojo.bindings.Decoder decoder0) {
        if (decoder0 == null) {
            return null;
        }
        decoder0.increaseStackDepth();
        StartSpeechRecognitionRequestParams result;
        try {
            org.chromium.mojo.bindings.DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
            final int elementsOrVersion = mainDataHeader.elementsOrVersion;
            result = new StartSpeechRecognitionRequestParams(elementsOrVersion);
                {
                    
                result.sessionReceiver = decoder0.readInterfaceRequest(8, false);
                }
                {
                    
                result.client = decoder0.readServiceInterface(12, false, SpeechRecognitionSessionClient.MANAGER);
                }
                {
                    
                result.maxHypotheses = decoder0.readInt(20);
                }
                {
                    
                result.language = decoder0.readString(24, false);
                }
                {
                    
                org.chromium.mojo.bindings.Decoder decoder1 = decoder0.readPointer(32, false);
                {
                    org.chromium.mojo.bindings.DataHeader si1 = decoder1.readDataHeaderForPointerArray(org.chromium.mojo.bindings.BindingsHelper.UNSPECIFIED_ARRAY_LENGTH);
                    result.grammars = new SpeechRecognitionGrammar[si1.elementsOrVersion];
                    for (int i1 = 0; i1 < si1.elementsOrVersion; ++i1) {
                        
                        org.chromium.mojo.bindings.Decoder decoder2 = decoder1.readPointer(org.chromium.mojo.bindings.DataHeader.HEADER_SIZE + org.chromium.mojo.bindings.BindingsHelper.POINTER_SIZE * i1, false);
                        result.grammars[i1] = SpeechRecognitionGrammar.decode(decoder2);
                    }
                }
                }
                {
                    
                result.continuous = decoder0.readBoolean(40, 0);
                }
                {
                    
                result.interimResults = decoder0.readBoolean(40, 1);
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
        
        encoder0.encode(this.sessionReceiver, 8, false);
        
        encoder0.encode(this.client, 12, false, SpeechRecognitionSessionClient.MANAGER);
        
        encoder0.encode(this.maxHypotheses, 20);
        
        encoder0.encode(this.language, 24, false);
        
        if (this.grammars == null) {
            encoder0.encodeNullPointer(32, false);
        } else {
            org.chromium.mojo.bindings.Encoder encoder1 = encoder0.encodePointerArray(this.grammars.length, 32, org.chromium.mojo.bindings.BindingsHelper.UNSPECIFIED_ARRAY_LENGTH);
            for (int i0 = 0; i0 < this.grammars.length; ++i0) {
                
                encoder1.encode(this.grammars[i0], org.chromium.mojo.bindings.DataHeader.HEADER_SIZE + org.chromium.mojo.bindings.BindingsHelper.POINTER_SIZE * i0, false);
            }
        }
        
        encoder0.encode(this.continuous, 40, 0);
        
        encoder0.encode(this.interimResults, 40, 1);
    }
}