// WebSocketHandshakeClient_Internal.java is auto generated by mojom_bindings_generator.py, do not edit


// Copyright 2014 The Chromium Authors
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.

// This file is autogenerated by:
//     mojo/public/tools/bindings/mojom_bindings_generator.py
// For:
//     services/network/public/mojom/websocket.mojom
//

package org.chromium.network.mojom;

import androidx.annotation.IntDef;


class WebSocketHandshakeClient_Internal {

    public static final org.chromium.mojo.bindings.Interface.Manager<WebSocketHandshakeClient, WebSocketHandshakeClient.Proxy> MANAGER =
            new org.chromium.mojo.bindings.Interface.Manager<WebSocketHandshakeClient, WebSocketHandshakeClient.Proxy>() {

        @Override
        public String getName() {
            return "network.mojom.WebSocketHandshakeClient";
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
        public Stub buildStub(org.chromium.mojo.system.Core core, WebSocketHandshakeClient impl) {
            return new Stub(core, impl);
        }

        @Override
        public WebSocketHandshakeClient[] buildArray(int size) {
          return new WebSocketHandshakeClient[size];
        }
    };


    private static final int ON_OPENING_HANDSHAKE_STARTED_ORDINAL = 0;

    private static final int ON_FAILURE_ORDINAL = 1;

    private static final int ON_CONNECTION_ESTABLISHED_ORDINAL = 2;


    static final class Proxy extends org.chromium.mojo.bindings.Interface.AbstractProxy implements WebSocketHandshakeClient.Proxy {

        Proxy(org.chromium.mojo.system.Core core,
              org.chromium.mojo.bindings.MessageReceiverWithResponder messageReceiver) {
            super(core, messageReceiver);
        }


        @Override
        public void onOpeningHandshakeStarted(
WebSocketHandshakeRequest request) {

            WebSocketHandshakeClientOnOpeningHandshakeStartedParams _message = new WebSocketHandshakeClientOnOpeningHandshakeStartedParams();

            _message.request = request;


            getProxyHandler().getMessageReceiver().accept(
                    _message.serializeWithHeader(
                            getProxyHandler().getCore(),
                            new org.chromium.mojo.bindings.MessageHeader(ON_OPENING_HANDSHAKE_STARTED_ORDINAL)));

        }


        @Override
        public void onFailure(
String message, int netError, int responseCode) {

            WebSocketHandshakeClientOnFailureParams _message = new WebSocketHandshakeClientOnFailureParams();

            _message.message = message;

            _message.netError = netError;

            _message.responseCode = responseCode;


            getProxyHandler().getMessageReceiver().accept(
                    _message.serializeWithHeader(
                            getProxyHandler().getCore(),
                            new org.chromium.mojo.bindings.MessageHeader(ON_FAILURE_ORDINAL)));

        }


        @Override
        public void onConnectionEstablished(
WebSocket socket, org.chromium.mojo.bindings.InterfaceRequest<WebSocketClient> clientReceiver, WebSocketHandshakeResponse response, org.chromium.mojo.system.DataPipe.ConsumerHandle readable, org.chromium.mojo.system.DataPipe.ProducerHandle writable) {

            WebSocketHandshakeClientOnConnectionEstablishedParams _message = new WebSocketHandshakeClientOnConnectionEstablishedParams();

            _message.socket = socket;

            _message.clientReceiver = clientReceiver;

            _message.response = response;

            _message.readable = readable;

            _message.writable = writable;


            getProxyHandler().getMessageReceiver().accept(
                    _message.serializeWithHeader(
                            getProxyHandler().getCore(),
                            new org.chromium.mojo.bindings.MessageHeader(ON_CONNECTION_ESTABLISHED_ORDINAL)));

        }


    }

    static final class Stub extends org.chromium.mojo.bindings.Interface.Stub<WebSocketHandshakeClient> {

        Stub(org.chromium.mojo.system.Core core, WebSocketHandshakeClient impl) {
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
                                WebSocketHandshakeClient_Internal.MANAGER, messageWithHeader);





                    case ON_OPENING_HANDSHAKE_STARTED_ORDINAL: {

                        WebSocketHandshakeClientOnOpeningHandshakeStartedParams data =
                                WebSocketHandshakeClientOnOpeningHandshakeStartedParams.deserialize(messageWithHeader.getPayload());

                        getImpl().onOpeningHandshakeStarted(data.request);
                        return true;
                    }





                    case ON_FAILURE_ORDINAL: {

                        WebSocketHandshakeClientOnFailureParams data =
                                WebSocketHandshakeClientOnFailureParams.deserialize(messageWithHeader.getPayload());

                        getImpl().onFailure(data.message, data.netError, data.responseCode);
                        return true;
                    }





                    case ON_CONNECTION_ESTABLISHED_ORDINAL: {

                        WebSocketHandshakeClientOnConnectionEstablishedParams data =
                                WebSocketHandshakeClientOnConnectionEstablishedParams.deserialize(messageWithHeader.getPayload());

                        getImpl().onConnectionEstablished(data.socket, data.clientReceiver, data.response, data.readable, data.writable);
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
                                getCore(), WebSocketHandshakeClient_Internal.MANAGER, messageWithHeader, receiver);








                    default:
                        return false;
                }
            } catch (org.chromium.mojo.bindings.DeserializationException e) {
                System.err.println(e.toString());
                return false;
            }
        }
    }


    
    static final class WebSocketHandshakeClientOnOpeningHandshakeStartedParams extends org.chromium.mojo.bindings.Struct {

        private static final int STRUCT_SIZE = 16;
        private static final org.chromium.mojo.bindings.DataHeader[] VERSION_ARRAY = new org.chromium.mojo.bindings.DataHeader[] {new org.chromium.mojo.bindings.DataHeader(16, 0)};
        private static final org.chromium.mojo.bindings.DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public WebSocketHandshakeRequest request;

        private WebSocketHandshakeClientOnOpeningHandshakeStartedParams(int version) {
            super(STRUCT_SIZE, version);
        }

        public WebSocketHandshakeClientOnOpeningHandshakeStartedParams() {
            this(0);
        }

        public static WebSocketHandshakeClientOnOpeningHandshakeStartedParams deserialize(org.chromium.mojo.bindings.Message message) {
            return decode(new org.chromium.mojo.bindings.Decoder(message));
        }

        /**
         * Similar to the method above, but deserializes from a |ByteBuffer| instance.
         *
         * @throws org.chromium.mojo.bindings.DeserializationException on deserialization failure.
         */
        public static WebSocketHandshakeClientOnOpeningHandshakeStartedParams deserialize(java.nio.ByteBuffer data) {
            return deserialize(new org.chromium.mojo.bindings.Message(
                    data, new java.util.ArrayList<org.chromium.mojo.system.Handle>()));
        }

        @SuppressWarnings("unchecked")
        public static WebSocketHandshakeClientOnOpeningHandshakeStartedParams decode(org.chromium.mojo.bindings.Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            WebSocketHandshakeClientOnOpeningHandshakeStartedParams result;
            try {
                org.chromium.mojo.bindings.DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                final int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new WebSocketHandshakeClientOnOpeningHandshakeStartedParams(elementsOrVersion);
                    {
                        
                    org.chromium.mojo.bindings.Decoder decoder1 = decoder0.readPointer(8, false);
                    result.request = WebSocketHandshakeRequest.decode(decoder1);
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
            
            encoder0.encode(this.request, 8, false);
        }
    }



    
    static final class WebSocketHandshakeClientOnFailureParams extends org.chromium.mojo.bindings.Struct {

        private static final int STRUCT_SIZE = 24;
        private static final org.chromium.mojo.bindings.DataHeader[] VERSION_ARRAY = new org.chromium.mojo.bindings.DataHeader[] {new org.chromium.mojo.bindings.DataHeader(24, 0)};
        private static final org.chromium.mojo.bindings.DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public String message;
        public int netError;
        public int responseCode;

        private WebSocketHandshakeClientOnFailureParams(int version) {
            super(STRUCT_SIZE, version);
        }

        public WebSocketHandshakeClientOnFailureParams() {
            this(0);
        }

        public static WebSocketHandshakeClientOnFailureParams deserialize(org.chromium.mojo.bindings.Message message) {
            return decode(new org.chromium.mojo.bindings.Decoder(message));
        }

        /**
         * Similar to the method above, but deserializes from a |ByteBuffer| instance.
         *
         * @throws org.chromium.mojo.bindings.DeserializationException on deserialization failure.
         */
        public static WebSocketHandshakeClientOnFailureParams deserialize(java.nio.ByteBuffer data) {
            return deserialize(new org.chromium.mojo.bindings.Message(
                    data, new java.util.ArrayList<org.chromium.mojo.system.Handle>()));
        }

        @SuppressWarnings("unchecked")
        public static WebSocketHandshakeClientOnFailureParams decode(org.chromium.mojo.bindings.Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            WebSocketHandshakeClientOnFailureParams result;
            try {
                org.chromium.mojo.bindings.DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                final int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new WebSocketHandshakeClientOnFailureParams(elementsOrVersion);
                    {
                        
                    result.message = decoder0.readString(8, false);
                    }
                    {
                        
                    result.netError = decoder0.readInt(16);
                    }
                    {
                        
                    result.responseCode = decoder0.readInt(20);
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
            
            encoder0.encode(this.message, 8, false);
            
            encoder0.encode(this.netError, 16);
            
            encoder0.encode(this.responseCode, 20);
        }
    }



    
    static final class WebSocketHandshakeClientOnConnectionEstablishedParams extends org.chromium.mojo.bindings.Struct {

        private static final int STRUCT_SIZE = 40;
        private static final org.chromium.mojo.bindings.DataHeader[] VERSION_ARRAY = new org.chromium.mojo.bindings.DataHeader[] {new org.chromium.mojo.bindings.DataHeader(40, 0)};
        private static final org.chromium.mojo.bindings.DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public WebSocket socket;
        public org.chromium.mojo.bindings.InterfaceRequest<WebSocketClient> clientReceiver;
        public WebSocketHandshakeResponse response;
        public org.chromium.mojo.system.DataPipe.ConsumerHandle readable;
        public org.chromium.mojo.system.DataPipe.ProducerHandle writable;

        private WebSocketHandshakeClientOnConnectionEstablishedParams(int version) {
            super(STRUCT_SIZE, version);
            this.readable = org.chromium.mojo.system.InvalidHandle.INSTANCE;
            this.writable = org.chromium.mojo.system.InvalidHandle.INSTANCE;
        }

        public WebSocketHandshakeClientOnConnectionEstablishedParams() {
            this(0);
        }

        public static WebSocketHandshakeClientOnConnectionEstablishedParams deserialize(org.chromium.mojo.bindings.Message message) {
            return decode(new org.chromium.mojo.bindings.Decoder(message));
        }

        /**
         * Similar to the method above, but deserializes from a |ByteBuffer| instance.
         *
         * @throws org.chromium.mojo.bindings.DeserializationException on deserialization failure.
         */
        public static WebSocketHandshakeClientOnConnectionEstablishedParams deserialize(java.nio.ByteBuffer data) {
            return deserialize(new org.chromium.mojo.bindings.Message(
                    data, new java.util.ArrayList<org.chromium.mojo.system.Handle>()));
        }

        @SuppressWarnings("unchecked")
        public static WebSocketHandshakeClientOnConnectionEstablishedParams decode(org.chromium.mojo.bindings.Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            WebSocketHandshakeClientOnConnectionEstablishedParams result;
            try {
                org.chromium.mojo.bindings.DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                final int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new WebSocketHandshakeClientOnConnectionEstablishedParams(elementsOrVersion);
                    {
                        
                    result.socket = decoder0.readServiceInterface(8, false, WebSocket.MANAGER);
                    }
                    {
                        
                    result.clientReceiver = decoder0.readInterfaceRequest(16, false);
                    }
                    {
                        
                    result.readable = decoder0.readConsumerHandle(20, false);
                    }
                    {
                        
                    org.chromium.mojo.bindings.Decoder decoder1 = decoder0.readPointer(24, false);
                    result.response = WebSocketHandshakeResponse.decode(decoder1);
                    }
                    {
                        
                    result.writable = decoder0.readProducerHandle(32, false);
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
            
            encoder0.encode(this.socket, 8, false, WebSocket.MANAGER);
            
            encoder0.encode(this.clientReceiver, 16, false);
            
            encoder0.encode(this.readable, 20, false);
            
            encoder0.encode(this.response, 24, false);
            
            encoder0.encode(this.writable, 32, false);
        }
    }



}
