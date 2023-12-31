// SpeechSynthesis_Internal.java is auto generated by mojom_bindings_generator.py, do not edit


// Copyright 2014 The Chromium Authors
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.

// This file is autogenerated by:
//     mojo/public/tools/bindings/mojom_bindings_generator.py
// For:
//     third_party/blink/public/mojom/speech/speech_synthesis.mojom
//

package org.chromium.blink.mojom;

import androidx.annotation.IntDef;


class SpeechSynthesis_Internal {

    public static final org.chromium.mojo.bindings.Interface.Manager<SpeechSynthesis, SpeechSynthesis.Proxy> MANAGER =
            new org.chromium.mojo.bindings.Interface.Manager<SpeechSynthesis, SpeechSynthesis.Proxy>() {

        @Override
        public String getName() {
            return "blink.mojom.SpeechSynthesis";
        }

        @Override
        public int getVersion() {
          return 0;
        }

        @Override
        public Proxy buildProxy(org.chromium.mojo.system.Core core,
                                org.chromium.mojo.bindings.MessageReceiverWithResponder messageReceiver) {
            return new Proxy(core, messageReceiver);
        }

        @Override
        public Stub buildStub(org.chromium.mojo.system.Core core, SpeechSynthesis impl) {
            return new Stub(core, impl);
        }

        @Override
        public SpeechSynthesis[] buildArray(int size) {
          return new SpeechSynthesis[size];
        }
    };


    private static final int ADD_VOICE_LIST_OBSERVER_ORDINAL = 0;

    private static final int SPEAK_ORDINAL = 1;

    private static final int PAUSE_ORDINAL = 2;

    private static final int RESUME_ORDINAL = 3;

    private static final int CANCEL_ORDINAL = 4;


    static final class Proxy extends org.chromium.mojo.bindings.Interface.AbstractProxy implements SpeechSynthesis.Proxy {

        Proxy(org.chromium.mojo.system.Core core,
              org.chromium.mojo.bindings.MessageReceiverWithResponder messageReceiver) {
            super(core, messageReceiver);
        }


        @Override
        public void addVoiceListObserver(
SpeechSynthesisVoiceListObserver observer) {

            SpeechSynthesisAddVoiceListObserverParams _message = new SpeechSynthesisAddVoiceListObserverParams();

            _message.observer = observer;


            getProxyHandler().getMessageReceiver().accept(
                    _message.serializeWithHeader(
                            getProxyHandler().getCore(),
                            new org.chromium.mojo.bindings.MessageHeader(ADD_VOICE_LIST_OBSERVER_ORDINAL)));

        }


        @Override
        public void speak(
SpeechSynthesisUtterance utterance, SpeechSynthesisClient client) {

            SpeechSynthesisSpeakParams _message = new SpeechSynthesisSpeakParams();

            _message.utterance = utterance;

            _message.client = client;


            getProxyHandler().getMessageReceiver().accept(
                    _message.serializeWithHeader(
                            getProxyHandler().getCore(),
                            new org.chromium.mojo.bindings.MessageHeader(SPEAK_ORDINAL)));

        }


        @Override
        public void pause(
) {

            SpeechSynthesisPauseParams _message = new SpeechSynthesisPauseParams();


            getProxyHandler().getMessageReceiver().accept(
                    _message.serializeWithHeader(
                            getProxyHandler().getCore(),
                            new org.chromium.mojo.bindings.MessageHeader(PAUSE_ORDINAL)));

        }


        @Override
        public void resume(
) {

            SpeechSynthesisResumeParams _message = new SpeechSynthesisResumeParams();


            getProxyHandler().getMessageReceiver().accept(
                    _message.serializeWithHeader(
                            getProxyHandler().getCore(),
                            new org.chromium.mojo.bindings.MessageHeader(RESUME_ORDINAL)));

        }


        @Override
        public void cancel(
) {

            SpeechSynthesisCancelParams _message = new SpeechSynthesisCancelParams();


            getProxyHandler().getMessageReceiver().accept(
                    _message.serializeWithHeader(
                            getProxyHandler().getCore(),
                            new org.chromium.mojo.bindings.MessageHeader(CANCEL_ORDINAL)));

        }


    }

    static final class Stub extends org.chromium.mojo.bindings.Interface.Stub<SpeechSynthesis> {

        Stub(org.chromium.mojo.system.Core core, SpeechSynthesis impl) {
            super(core, impl);
        }

        @Override
        public boolean accept(org.chromium.mojo.bindings.Message message) {
            try {
                org.chromium.mojo.bindings.ServiceMessage messageWithHeader =
                        message.asServiceMessage();
                org.chromium.mojo.bindings.MessageHeader header = messageWithHeader.getHeader();
                int flags = org.chromium.mojo.bindings.MessageHeader.NO_FLAG;
                if (header.hasFlag(org.chromium.mojo.bindings.MessageHeader.MESSAGE_IS_SYNC_FLAG)) {
                    flags = flags | org.chromium.mojo.bindings.MessageHeader.MESSAGE_IS_SYNC_FLAG;
                }
                if (!header.validateHeader(flags)) {
                    return false;
                }
                switch(header.getType()) {

                    case org.chromium.mojo.bindings.interfacecontrol.InterfaceControlMessagesConstants.RUN_OR_CLOSE_PIPE_MESSAGE_ID:
                        return org.chromium.mojo.bindings.InterfaceControlMessagesHelper.handleRunOrClosePipe(
                                SpeechSynthesis_Internal.MANAGER, messageWithHeader);





                    case ADD_VOICE_LIST_OBSERVER_ORDINAL: {

                        SpeechSynthesisAddVoiceListObserverParams data =
                                SpeechSynthesisAddVoiceListObserverParams.deserialize(messageWithHeader.getPayload());

                        getImpl().addVoiceListObserver(data.observer);
                        return true;
                    }





                    case SPEAK_ORDINAL: {

                        SpeechSynthesisSpeakParams data =
                                SpeechSynthesisSpeakParams.deserialize(messageWithHeader.getPayload());

                        getImpl().speak(data.utterance, data.client);
                        return true;
                    }





                    case PAUSE_ORDINAL: {

                        SpeechSynthesisPauseParams.deserialize(messageWithHeader.getPayload());

                        getImpl().pause();
                        return true;
                    }





                    case RESUME_ORDINAL: {

                        SpeechSynthesisResumeParams.deserialize(messageWithHeader.getPayload());

                        getImpl().resume();
                        return true;
                    }





                    case CANCEL_ORDINAL: {

                        SpeechSynthesisCancelParams.deserialize(messageWithHeader.getPayload());

                        getImpl().cancel();
                        return true;
                    }


                    default:
                        return false;
                }
            } catch (org.chromium.mojo.bindings.DeserializationException e) {
                System.err.println(e.toString());
                return false;
            }
        }

        @Override
        public boolean acceptWithResponder(org.chromium.mojo.bindings.Message message, org.chromium.mojo.bindings.MessageReceiver receiver) {
            try {
                org.chromium.mojo.bindings.ServiceMessage messageWithHeader =
                        message.asServiceMessage();
                org.chromium.mojo.bindings.MessageHeader header = messageWithHeader.getHeader();
                int flags = org.chromium.mojo.bindings.MessageHeader.MESSAGE_EXPECTS_RESPONSE_FLAG;
                if (header.hasFlag(org.chromium.mojo.bindings.MessageHeader.MESSAGE_IS_SYNC_FLAG)) {
                    flags = flags | org.chromium.mojo.bindings.MessageHeader.MESSAGE_IS_SYNC_FLAG;
                }
                if (!header.validateHeader(flags)) {
                    return false;
                }
                switch(header.getType()) {

                    case org.chromium.mojo.bindings.interfacecontrol.InterfaceControlMessagesConstants.RUN_MESSAGE_ID:
                        return org.chromium.mojo.bindings.InterfaceControlMessagesHelper.handleRun(
                                getCore(), SpeechSynthesis_Internal.MANAGER, messageWithHeader, receiver);












                    default:
                        return false;
                }
            } catch (org.chromium.mojo.bindings.DeserializationException e) {
                System.err.println(e.toString());
                return false;
            }
        }
    }


    
    static final class SpeechSynthesisAddVoiceListObserverParams extends org.chromium.mojo.bindings.Struct {

        private static final int STRUCT_SIZE = 16;
        private static final org.chromium.mojo.bindings.DataHeader[] VERSION_ARRAY = new org.chromium.mojo.bindings.DataHeader[] {new org.chromium.mojo.bindings.DataHeader(16, 0)};
        private static final org.chromium.mojo.bindings.DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public SpeechSynthesisVoiceListObserver observer;

        private SpeechSynthesisAddVoiceListObserverParams(int version) {
            super(STRUCT_SIZE, version);
        }

        public SpeechSynthesisAddVoiceListObserverParams() {
            this(0);
        }

        public static SpeechSynthesisAddVoiceListObserverParams deserialize(org.chromium.mojo.bindings.Message message) {
            return decode(new org.chromium.mojo.bindings.Decoder(message));
        }

        /**
         * Similar to the method above, but deserializes from a |ByteBuffer| instance.
         *
         * @throws org.chromium.mojo.bindings.DeserializationException on deserialization failure.
         */
        public static SpeechSynthesisAddVoiceListObserverParams deserialize(java.nio.ByteBuffer data) {
            return deserialize(new org.chromium.mojo.bindings.Message(
                    data, new java.util.ArrayList<org.chromium.mojo.system.Handle>()));
        }

        @SuppressWarnings("unchecked")
        public static SpeechSynthesisAddVoiceListObserverParams decode(org.chromium.mojo.bindings.Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            SpeechSynthesisAddVoiceListObserverParams result;
            try {
                org.chromium.mojo.bindings.DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                final int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new SpeechSynthesisAddVoiceListObserverParams(elementsOrVersion);
                    {
                        
                    result.observer = decoder0.readServiceInterface(8, false, SpeechSynthesisVoiceListObserver.MANAGER);
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
            
            encoder0.encode(this.observer, 8, false, SpeechSynthesisVoiceListObserver.MANAGER);
        }
    }



    
    static final class SpeechSynthesisSpeakParams extends org.chromium.mojo.bindings.Struct {

        private static final int STRUCT_SIZE = 24;
        private static final org.chromium.mojo.bindings.DataHeader[] VERSION_ARRAY = new org.chromium.mojo.bindings.DataHeader[] {new org.chromium.mojo.bindings.DataHeader(24, 0)};
        private static final org.chromium.mojo.bindings.DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public SpeechSynthesisUtterance utterance;
        public SpeechSynthesisClient client;

        private SpeechSynthesisSpeakParams(int version) {
            super(STRUCT_SIZE, version);
        }

        public SpeechSynthesisSpeakParams() {
            this(0);
        }

        public static SpeechSynthesisSpeakParams deserialize(org.chromium.mojo.bindings.Message message) {
            return decode(new org.chromium.mojo.bindings.Decoder(message));
        }

        /**
         * Similar to the method above, but deserializes from a |ByteBuffer| instance.
         *
         * @throws org.chromium.mojo.bindings.DeserializationException on deserialization failure.
         */
        public static SpeechSynthesisSpeakParams deserialize(java.nio.ByteBuffer data) {
            return deserialize(new org.chromium.mojo.bindings.Message(
                    data, new java.util.ArrayList<org.chromium.mojo.system.Handle>()));
        }

        @SuppressWarnings("unchecked")
        public static SpeechSynthesisSpeakParams decode(org.chromium.mojo.bindings.Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            SpeechSynthesisSpeakParams result;
            try {
                org.chromium.mojo.bindings.DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                final int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new SpeechSynthesisSpeakParams(elementsOrVersion);
                    {
                        
                    org.chromium.mojo.bindings.Decoder decoder1 = decoder0.readPointer(8, false);
                    result.utterance = SpeechSynthesisUtterance.decode(decoder1);
                    }
                    {
                        
                    result.client = decoder0.readServiceInterface(16, false, SpeechSynthesisClient.MANAGER);
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
            
            encoder0.encode(this.utterance, 8, false);
            
            encoder0.encode(this.client, 16, false, SpeechSynthesisClient.MANAGER);
        }
    }



    
    static final class SpeechSynthesisPauseParams extends org.chromium.mojo.bindings.Struct {

        private static final int STRUCT_SIZE = 8;
        private static final org.chromium.mojo.bindings.DataHeader[] VERSION_ARRAY = new org.chromium.mojo.bindings.DataHeader[] {new org.chromium.mojo.bindings.DataHeader(8, 0)};
        private static final org.chromium.mojo.bindings.DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        private SpeechSynthesisPauseParams(int version) {
            super(STRUCT_SIZE, version);
        }

        public SpeechSynthesisPauseParams() {
            this(0);
        }

        public static SpeechSynthesisPauseParams deserialize(org.chromium.mojo.bindings.Message message) {
            return decode(new org.chromium.mojo.bindings.Decoder(message));
        }

        /**
         * Similar to the method above, but deserializes from a |ByteBuffer| instance.
         *
         * @throws org.chromium.mojo.bindings.DeserializationException on deserialization failure.
         */
        public static SpeechSynthesisPauseParams deserialize(java.nio.ByteBuffer data) {
            return deserialize(new org.chromium.mojo.bindings.Message(
                    data, new java.util.ArrayList<org.chromium.mojo.system.Handle>()));
        }

        @SuppressWarnings("unchecked")
        public static SpeechSynthesisPauseParams decode(org.chromium.mojo.bindings.Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            SpeechSynthesisPauseParams result;
            try {
                org.chromium.mojo.bindings.DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                final int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new SpeechSynthesisPauseParams(elementsOrVersion);

            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        @SuppressWarnings("unchecked")
        @Override
        protected final void encode(org.chromium.mojo.bindings.Encoder encoder) {
            encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
        }
    }



    
    static final class SpeechSynthesisResumeParams extends org.chromium.mojo.bindings.Struct {

        private static final int STRUCT_SIZE = 8;
        private static final org.chromium.mojo.bindings.DataHeader[] VERSION_ARRAY = new org.chromium.mojo.bindings.DataHeader[] {new org.chromium.mojo.bindings.DataHeader(8, 0)};
        private static final org.chromium.mojo.bindings.DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        private SpeechSynthesisResumeParams(int version) {
            super(STRUCT_SIZE, version);
        }

        public SpeechSynthesisResumeParams() {
            this(0);
        }

        public static SpeechSynthesisResumeParams deserialize(org.chromium.mojo.bindings.Message message) {
            return decode(new org.chromium.mojo.bindings.Decoder(message));
        }

        /**
         * Similar to the method above, but deserializes from a |ByteBuffer| instance.
         *
         * @throws org.chromium.mojo.bindings.DeserializationException on deserialization failure.
         */
        public static SpeechSynthesisResumeParams deserialize(java.nio.ByteBuffer data) {
            return deserialize(new org.chromium.mojo.bindings.Message(
                    data, new java.util.ArrayList<org.chromium.mojo.system.Handle>()));
        }

        @SuppressWarnings("unchecked")
        public static SpeechSynthesisResumeParams decode(org.chromium.mojo.bindings.Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            SpeechSynthesisResumeParams result;
            try {
                org.chromium.mojo.bindings.DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                final int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new SpeechSynthesisResumeParams(elementsOrVersion);

            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        @SuppressWarnings("unchecked")
        @Override
        protected final void encode(org.chromium.mojo.bindings.Encoder encoder) {
            encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
        }
    }



    
    static final class SpeechSynthesisCancelParams extends org.chromium.mojo.bindings.Struct {

        private static final int STRUCT_SIZE = 8;
        private static final org.chromium.mojo.bindings.DataHeader[] VERSION_ARRAY = new org.chromium.mojo.bindings.DataHeader[] {new org.chromium.mojo.bindings.DataHeader(8, 0)};
        private static final org.chromium.mojo.bindings.DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        private SpeechSynthesisCancelParams(int version) {
            super(STRUCT_SIZE, version);
        }

        public SpeechSynthesisCancelParams() {
            this(0);
        }

        public static SpeechSynthesisCancelParams deserialize(org.chromium.mojo.bindings.Message message) {
            return decode(new org.chromium.mojo.bindings.Decoder(message));
        }

        /**
         * Similar to the method above, but deserializes from a |ByteBuffer| instance.
         *
         * @throws org.chromium.mojo.bindings.DeserializationException on deserialization failure.
         */
        public static SpeechSynthesisCancelParams deserialize(java.nio.ByteBuffer data) {
            return deserialize(new org.chromium.mojo.bindings.Message(
                    data, new java.util.ArrayList<org.chromium.mojo.system.Handle>()));
        }

        @SuppressWarnings("unchecked")
        public static SpeechSynthesisCancelParams decode(org.chromium.mojo.bindings.Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            SpeechSynthesisCancelParams result;
            try {
                org.chromium.mojo.bindings.DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                final int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new SpeechSynthesisCancelParams(elementsOrVersion);

            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        @SuppressWarnings("unchecked")
        @Override
        protected final void encode(org.chromium.mojo.bindings.Encoder encoder) {
            encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
        }
    }



}
