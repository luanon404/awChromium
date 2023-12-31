// AudioContextManager_Internal.java is auto generated by mojom_bindings_generator.py, do not edit


// Copyright 2014 The Chromium Authors
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.

// This file is autogenerated by:
//     mojo/public/tools/bindings/mojom_bindings_generator.py
// For:
//     third_party/blink/public/mojom/webaudio/audio_context_manager.mojom
//

package org.chromium.blink.mojom;

import androidx.annotation.IntDef;


class AudioContextManager_Internal {

    public static final org.chromium.mojo.bindings.Interface.Manager<AudioContextManager, AudioContextManager.Proxy> MANAGER =
            new org.chromium.mojo.bindings.Interface.Manager<AudioContextManager, AudioContextManager.Proxy>() {

        @Override
        public String getName() {
            return "blink.mojom.AudioContextManager";
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
        public Stub buildStub(org.chromium.mojo.system.Core core, AudioContextManager impl) {
            return new Stub(core, impl);
        }

        @Override
        public AudioContextManager[] buildArray(int size) {
          return new AudioContextManager[size];
        }
    };


    private static final int AUDIO_CONTEXT_AUDIBLE_PLAYBACK_STARTED_ORDINAL = 0;

    private static final int AUDIO_CONTEXT_AUDIBLE_PLAYBACK_STOPPED_ORDINAL = 1;


    static final class Proxy extends org.chromium.mojo.bindings.Interface.AbstractProxy implements AudioContextManager.Proxy {

        Proxy(org.chromium.mojo.system.Core core,
              org.chromium.mojo.bindings.MessageReceiverWithResponder messageReceiver) {
            super(core, messageReceiver);
        }


        @Override
        public void audioContextAudiblePlaybackStarted(
int id) {

            AudioContextManagerAudioContextAudiblePlaybackStartedParams _message = new AudioContextManagerAudioContextAudiblePlaybackStartedParams();

            _message.id = id;


            getProxyHandler().getMessageReceiver().accept(
                    _message.serializeWithHeader(
                            getProxyHandler().getCore(),
                            new org.chromium.mojo.bindings.MessageHeader(AUDIO_CONTEXT_AUDIBLE_PLAYBACK_STARTED_ORDINAL)));

        }


        @Override
        public void audioContextAudiblePlaybackStopped(
int id) {

            AudioContextManagerAudioContextAudiblePlaybackStoppedParams _message = new AudioContextManagerAudioContextAudiblePlaybackStoppedParams();

            _message.id = id;


            getProxyHandler().getMessageReceiver().accept(
                    _message.serializeWithHeader(
                            getProxyHandler().getCore(),
                            new org.chromium.mojo.bindings.MessageHeader(AUDIO_CONTEXT_AUDIBLE_PLAYBACK_STOPPED_ORDINAL)));

        }


    }

    static final class Stub extends org.chromium.mojo.bindings.Interface.Stub<AudioContextManager> {

        Stub(org.chromium.mojo.system.Core core, AudioContextManager impl) {
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
                                AudioContextManager_Internal.MANAGER, messageWithHeader);





                    case AUDIO_CONTEXT_AUDIBLE_PLAYBACK_STARTED_ORDINAL: {

                        AudioContextManagerAudioContextAudiblePlaybackStartedParams data =
                                AudioContextManagerAudioContextAudiblePlaybackStartedParams.deserialize(messageWithHeader.getPayload());

                        getImpl().audioContextAudiblePlaybackStarted(data.id);
                        return true;
                    }





                    case AUDIO_CONTEXT_AUDIBLE_PLAYBACK_STOPPED_ORDINAL: {

                        AudioContextManagerAudioContextAudiblePlaybackStoppedParams data =
                                AudioContextManagerAudioContextAudiblePlaybackStoppedParams.deserialize(messageWithHeader.getPayload());

                        getImpl().audioContextAudiblePlaybackStopped(data.id);
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
                                getCore(), AudioContextManager_Internal.MANAGER, messageWithHeader, receiver);






                    default:
                        return false;
                }
            } catch (org.chromium.mojo.bindings.DeserializationException e) {
                System.err.println(e.toString());
                return false;
            }
        }
    }


    
    static final class AudioContextManagerAudioContextAudiblePlaybackStartedParams extends org.chromium.mojo.bindings.Struct {

        private static final int STRUCT_SIZE = 16;
        private static final org.chromium.mojo.bindings.DataHeader[] VERSION_ARRAY = new org.chromium.mojo.bindings.DataHeader[] {new org.chromium.mojo.bindings.DataHeader(16, 0)};
        private static final org.chromium.mojo.bindings.DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public int id;

        private AudioContextManagerAudioContextAudiblePlaybackStartedParams(int version) {
            super(STRUCT_SIZE, version);
        }

        public AudioContextManagerAudioContextAudiblePlaybackStartedParams() {
            this(0);
        }

        public static AudioContextManagerAudioContextAudiblePlaybackStartedParams deserialize(org.chromium.mojo.bindings.Message message) {
            return decode(new org.chromium.mojo.bindings.Decoder(message));
        }

        /**
         * Similar to the method above, but deserializes from a |ByteBuffer| instance.
         *
         * @throws org.chromium.mojo.bindings.DeserializationException on deserialization failure.
         */
        public static AudioContextManagerAudioContextAudiblePlaybackStartedParams deserialize(java.nio.ByteBuffer data) {
            return deserialize(new org.chromium.mojo.bindings.Message(
                    data, new java.util.ArrayList<org.chromium.mojo.system.Handle>()));
        }

        @SuppressWarnings("unchecked")
        public static AudioContextManagerAudioContextAudiblePlaybackStartedParams decode(org.chromium.mojo.bindings.Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            AudioContextManagerAudioContextAudiblePlaybackStartedParams result;
            try {
                org.chromium.mojo.bindings.DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                final int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new AudioContextManagerAudioContextAudiblePlaybackStartedParams(elementsOrVersion);
                    {
                        
                    result.id = decoder0.readInt(8);
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
            
            encoder0.encode(this.id, 8);
        }
    }



    
    static final class AudioContextManagerAudioContextAudiblePlaybackStoppedParams extends org.chromium.mojo.bindings.Struct {

        private static final int STRUCT_SIZE = 16;
        private static final org.chromium.mojo.bindings.DataHeader[] VERSION_ARRAY = new org.chromium.mojo.bindings.DataHeader[] {new org.chromium.mojo.bindings.DataHeader(16, 0)};
        private static final org.chromium.mojo.bindings.DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public int id;

        private AudioContextManagerAudioContextAudiblePlaybackStoppedParams(int version) {
            super(STRUCT_SIZE, version);
        }

        public AudioContextManagerAudioContextAudiblePlaybackStoppedParams() {
            this(0);
        }

        public static AudioContextManagerAudioContextAudiblePlaybackStoppedParams deserialize(org.chromium.mojo.bindings.Message message) {
            return decode(new org.chromium.mojo.bindings.Decoder(message));
        }

        /**
         * Similar to the method above, but deserializes from a |ByteBuffer| instance.
         *
         * @throws org.chromium.mojo.bindings.DeserializationException on deserialization failure.
         */
        public static AudioContextManagerAudioContextAudiblePlaybackStoppedParams deserialize(java.nio.ByteBuffer data) {
            return deserialize(new org.chromium.mojo.bindings.Message(
                    data, new java.util.ArrayList<org.chromium.mojo.system.Handle>()));
        }

        @SuppressWarnings("unchecked")
        public static AudioContextManagerAudioContextAudiblePlaybackStoppedParams decode(org.chromium.mojo.bindings.Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            AudioContextManagerAudioContextAudiblePlaybackStoppedParams result;
            try {
                org.chromium.mojo.bindings.DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                final int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new AudioContextManagerAudioContextAudiblePlaybackStoppedParams(elementsOrVersion);
                    {
                        
                    result.id = decoder0.readInt(8);
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
            
            encoder0.encode(this.id, 8);
        }
    }



}
