// RestrictedUdpSocket_Internal.java is auto generated by mojom_bindings_generator.py, do not edit


// Copyright 2014 The Chromium Authors
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.

// This file is autogenerated by:
//     mojo/public/tools/bindings/mojom_bindings_generator.py
// For:
//     services/network/public/mojom/restricted_udp_socket.mojom
//

package org.chromium.network.mojom;

class RestrictedUdpSocket_Internal {

    public static final org.chromium.mojo.bindings.Interface.Manager<RestrictedUdpSocket, RestrictedUdpSocket.Proxy> MANAGER = new org.chromium.mojo.bindings.Interface.Manager<RestrictedUdpSocket, RestrictedUdpSocket.Proxy>() {

        @Override
        public String getName() {
            return "network.mojom.RestrictedUDPSocket";
        }

        @Override
        public int getVersion() {
            return 0;
        }

        @Override
        public Proxy buildProxy(org.chromium.mojo.system.Core core, org.chromium.mojo.bindings.MessageReceiverWithResponder messageReceiver) {
            return new Proxy(core, messageReceiver);
        }

        @Override
        public Stub buildStub(org.chromium.mojo.system.Core core, RestrictedUdpSocket impl) {
            return new Stub(core, impl);
        }

        @Override
        public RestrictedUdpSocket[] buildArray(int size) {
            return new RestrictedUdpSocket[size];
        }
    };


    private static final int RECEIVE_MORE_ORDINAL = 0;

    private static final int SEND_ORDINAL = 1;

    private static final int SEND_TO_ORDINAL = 2;


    static final class Proxy extends org.chromium.mojo.bindings.Interface.AbstractProxy implements RestrictedUdpSocket.Proxy {

        Proxy(org.chromium.mojo.system.Core core, org.chromium.mojo.bindings.MessageReceiverWithResponder messageReceiver) {
            super(core, messageReceiver);
        }


        @Override
        public void receiveMore(int numAdditionalDatagrams) {

            RestrictedUdpSocketReceiveMoreParams _message = new RestrictedUdpSocketReceiveMoreParams();

            _message.numAdditionalDatagrams = numAdditionalDatagrams;


            getProxyHandler().getMessageReceiver().accept(_message.serializeWithHeader(getProxyHandler().getCore(), new org.chromium.mojo.bindings.MessageHeader(RECEIVE_MORE_ORDINAL)));

        }


        @Override
        public void send(org.chromium.mojo_base.mojom.ReadOnlyBuffer data, Send_Response callback) {

            RestrictedUdpSocketSendParams _message = new RestrictedUdpSocketSendParams();

            _message.data = data;


            getProxyHandler().getMessageReceiver().acceptWithResponder(_message.serializeWithHeader(getProxyHandler().getCore(), new org.chromium.mojo.bindings.MessageHeader(SEND_ORDINAL, org.chromium.mojo.bindings.MessageHeader.MESSAGE_EXPECTS_RESPONSE_FLAG, 0)), new RestrictedUdpSocketSendResponseParamsForwardToCallback(callback));

        }


        @Override
        public void sendTo(org.chromium.mojo_base.mojom.ReadOnlyBuffer data, HostPortPair destAddr, int dnsQueryType, SendTo_Response callback) {

            RestrictedUdpSocketSendToParams _message = new RestrictedUdpSocketSendToParams();

            _message.data = data;

            _message.destAddr = destAddr;

            _message.dnsQueryType = dnsQueryType;


            getProxyHandler().getMessageReceiver().acceptWithResponder(_message.serializeWithHeader(getProxyHandler().getCore(), new org.chromium.mojo.bindings.MessageHeader(SEND_TO_ORDINAL, org.chromium.mojo.bindings.MessageHeader.MESSAGE_EXPECTS_RESPONSE_FLAG, 0)), new RestrictedUdpSocketSendToResponseParamsForwardToCallback(callback));

        }


    }

    static final class Stub extends org.chromium.mojo.bindings.Interface.Stub<RestrictedUdpSocket> {

        Stub(org.chromium.mojo.system.Core core, RestrictedUdpSocket impl) {
            super(core, impl);
        }

        @Override
        public boolean accept(org.chromium.mojo.bindings.Message message) {
            try {
                org.chromium.mojo.bindings.ServiceMessage messageWithHeader = message.asServiceMessage();
                org.chromium.mojo.bindings.MessageHeader header = messageWithHeader.getHeader();
                int flags = org.chromium.mojo.bindings.MessageHeader.NO_FLAG;
                if (header.hasFlag(org.chromium.mojo.bindings.MessageHeader.MESSAGE_IS_SYNC_FLAG)) {
                    flags = flags | org.chromium.mojo.bindings.MessageHeader.MESSAGE_IS_SYNC_FLAG;
                }
                if (!header.validateHeader(flags)) {
                    return false;
                }
                switch (header.getType()) {

                    case org.chromium.mojo.bindings.interfacecontrol.InterfaceControlMessagesConstants.RUN_OR_CLOSE_PIPE_MESSAGE_ID:
                        return org.chromium.mojo.bindings.InterfaceControlMessagesHelper.handleRunOrClosePipe(RestrictedUdpSocket_Internal.MANAGER, messageWithHeader);


                    case RECEIVE_MORE_ORDINAL: {

                        RestrictedUdpSocketReceiveMoreParams data = RestrictedUdpSocketReceiveMoreParams.deserialize(messageWithHeader.getPayload());

                        getImpl().receiveMore(data.numAdditionalDatagrams);
                        return true;
                    }


                    default:
                        return false;
                }
            } catch (org.chromium.mojo.bindings.DeserializationException e) {
                System.err.println(e);
                return false;
            }
        }

        @Override
        public boolean acceptWithResponder(org.chromium.mojo.bindings.Message message, org.chromium.mojo.bindings.MessageReceiver receiver) {
            try {
                org.chromium.mojo.bindings.ServiceMessage messageWithHeader = message.asServiceMessage();
                org.chromium.mojo.bindings.MessageHeader header = messageWithHeader.getHeader();
                int flags = org.chromium.mojo.bindings.MessageHeader.MESSAGE_EXPECTS_RESPONSE_FLAG;
                if (header.hasFlag(org.chromium.mojo.bindings.MessageHeader.MESSAGE_IS_SYNC_FLAG)) {
                    flags = flags | org.chromium.mojo.bindings.MessageHeader.MESSAGE_IS_SYNC_FLAG;
                }
                if (!header.validateHeader(flags)) {
                    return false;
                }
                switch (header.getType()) {

                    case org.chromium.mojo.bindings.interfacecontrol.InterfaceControlMessagesConstants.RUN_MESSAGE_ID:
                        return org.chromium.mojo.bindings.InterfaceControlMessagesHelper.handleRun(getCore(), RestrictedUdpSocket_Internal.MANAGER, messageWithHeader, receiver);


                    case SEND_ORDINAL: {

                        RestrictedUdpSocketSendParams data = RestrictedUdpSocketSendParams.deserialize(messageWithHeader.getPayload());

                        getImpl().send(data.data, new RestrictedUdpSocketSendResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
                        return true;
                    }


                    case SEND_TO_ORDINAL: {

                        RestrictedUdpSocketSendToParams data = RestrictedUdpSocketSendToParams.deserialize(messageWithHeader.getPayload());

                        getImpl().sendTo(data.data, data.destAddr, data.dnsQueryType, new RestrictedUdpSocketSendToResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
                        return true;
                    }


                    default:
                        return false;
                }
            } catch (org.chromium.mojo.bindings.DeserializationException e) {
                System.err.println(e);
                return false;
            }
        }
    }


    static final class RestrictedUdpSocketReceiveMoreParams extends org.chromium.mojo.bindings.Struct {

        private static final int STRUCT_SIZE = 16;
        private static final org.chromium.mojo.bindings.DataHeader[] VERSION_ARRAY = new org.chromium.mojo.bindings.DataHeader[]{new org.chromium.mojo.bindings.DataHeader(16, 0)};
        private static final org.chromium.mojo.bindings.DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public int numAdditionalDatagrams;

        private RestrictedUdpSocketReceiveMoreParams(int version) {
            super(STRUCT_SIZE, version);
        }

        public RestrictedUdpSocketReceiveMoreParams() {
            this(0);
        }

        public static RestrictedUdpSocketReceiveMoreParams deserialize(org.chromium.mojo.bindings.Message message) {
            return decode(new org.chromium.mojo.bindings.Decoder(message));
        }

        /**
         * Similar to the method above, but deserializes from a |ByteBuffer| instance.
         *
         * @throws org.chromium.mojo.bindings.DeserializationException on deserialization failure.
         */
        public static RestrictedUdpSocketReceiveMoreParams deserialize(java.nio.ByteBuffer data) {
            return deserialize(new org.chromium.mojo.bindings.Message(data, new java.util.ArrayList<org.chromium.mojo.system.Handle>()));
        }

        @SuppressWarnings("unchecked")
        public static RestrictedUdpSocketReceiveMoreParams decode(org.chromium.mojo.bindings.Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            RestrictedUdpSocketReceiveMoreParams result;
            try {
                org.chromium.mojo.bindings.DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                final int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new RestrictedUdpSocketReceiveMoreParams(elementsOrVersion);
                {

                    result.numAdditionalDatagrams = decoder0.readInt(8);
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

            encoder0.encode(this.numAdditionalDatagrams, 8);
        }
    }


    static final class RestrictedUdpSocketSendParams extends org.chromium.mojo.bindings.Struct {

        private static final int STRUCT_SIZE = 16;
        private static final org.chromium.mojo.bindings.DataHeader[] VERSION_ARRAY = new org.chromium.mojo.bindings.DataHeader[]{new org.chromium.mojo.bindings.DataHeader(16, 0)};
        private static final org.chromium.mojo.bindings.DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public org.chromium.mojo_base.mojom.ReadOnlyBuffer data;

        private RestrictedUdpSocketSendParams(int version) {
            super(STRUCT_SIZE, version);
        }

        public RestrictedUdpSocketSendParams() {
            this(0);
        }

        public static RestrictedUdpSocketSendParams deserialize(org.chromium.mojo.bindings.Message message) {
            return decode(new org.chromium.mojo.bindings.Decoder(message));
        }

        /**
         * Similar to the method above, but deserializes from a |ByteBuffer| instance.
         *
         * @throws org.chromium.mojo.bindings.DeserializationException on deserialization failure.
         */
        public static RestrictedUdpSocketSendParams deserialize(java.nio.ByteBuffer data) {
            return deserialize(new org.chromium.mojo.bindings.Message(data, new java.util.ArrayList<org.chromium.mojo.system.Handle>()));
        }

        @SuppressWarnings("unchecked")
        public static RestrictedUdpSocketSendParams decode(org.chromium.mojo.bindings.Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            RestrictedUdpSocketSendParams result;
            try {
                org.chromium.mojo.bindings.DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                final int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new RestrictedUdpSocketSendParams(elementsOrVersion);
                {

                    org.chromium.mojo.bindings.Decoder decoder1 = decoder0.readPointer(8, false);
                    result.data = org.chromium.mojo_base.mojom.ReadOnlyBuffer.decode(decoder1);
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
        }
    }


    static final class RestrictedUdpSocketSendResponseParams extends org.chromium.mojo.bindings.Struct {

        private static final int STRUCT_SIZE = 16;
        private static final org.chromium.mojo.bindings.DataHeader[] VERSION_ARRAY = new org.chromium.mojo.bindings.DataHeader[]{new org.chromium.mojo.bindings.DataHeader(16, 0)};
        private static final org.chromium.mojo.bindings.DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public int result;

        private RestrictedUdpSocketSendResponseParams(int version) {
            super(STRUCT_SIZE, version);
        }

        public RestrictedUdpSocketSendResponseParams() {
            this(0);
        }

        public static RestrictedUdpSocketSendResponseParams deserialize(org.chromium.mojo.bindings.Message message) {
            return decode(new org.chromium.mojo.bindings.Decoder(message));
        }

        /**
         * Similar to the method above, but deserializes from a |ByteBuffer| instance.
         *
         * @throws org.chromium.mojo.bindings.DeserializationException on deserialization failure.
         */
        public static RestrictedUdpSocketSendResponseParams deserialize(java.nio.ByteBuffer data) {
            return deserialize(new org.chromium.mojo.bindings.Message(data, new java.util.ArrayList<org.chromium.mojo.system.Handle>()));
        }

        @SuppressWarnings("unchecked")
        public static RestrictedUdpSocketSendResponseParams decode(org.chromium.mojo.bindings.Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            RestrictedUdpSocketSendResponseParams result;
            try {
                org.chromium.mojo.bindings.DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                final int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new RestrictedUdpSocketSendResponseParams(elementsOrVersion);
                {

                    result.result = decoder0.readInt(8);
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

            encoder0.encode(this.result, 8);
        }
    }

    static class RestrictedUdpSocketSendResponseParamsForwardToCallback extends org.chromium.mojo.bindings.SideEffectFreeCloseable implements org.chromium.mojo.bindings.MessageReceiver {
        private final RestrictedUdpSocket.Send_Response mCallback;

        RestrictedUdpSocketSendResponseParamsForwardToCallback(RestrictedUdpSocket.Send_Response callback) {
            this.mCallback = callback;
        }

        @Override
        public boolean accept(org.chromium.mojo.bindings.Message message) {
            try {
                org.chromium.mojo.bindings.ServiceMessage messageWithHeader = message.asServiceMessage();
                org.chromium.mojo.bindings.MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(SEND_ORDINAL, org.chromium.mojo.bindings.MessageHeader.MESSAGE_IS_RESPONSE_FLAG)) {
                    return false;
                }

                RestrictedUdpSocketSendResponseParams response = RestrictedUdpSocketSendResponseParams.deserialize(messageWithHeader.getPayload());

                mCallback.call(response.result);
                return true;
            } catch (org.chromium.mojo.bindings.DeserializationException e) {
                return false;
            }
        }
    }

    static class RestrictedUdpSocketSendResponseParamsProxyToResponder implements RestrictedUdpSocket.Send_Response {

        private final org.chromium.mojo.system.Core mCore;
        private final org.chromium.mojo.bindings.MessageReceiver mMessageReceiver;
        private final long mRequestId;

        RestrictedUdpSocketSendResponseParamsProxyToResponder(org.chromium.mojo.system.Core core, org.chromium.mojo.bindings.MessageReceiver messageReceiver, long requestId) {
            mCore = core;
            mMessageReceiver = messageReceiver;
            mRequestId = requestId;
        }

        @Override
        public void call(Integer result) {
            RestrictedUdpSocketSendResponseParams _response = new RestrictedUdpSocketSendResponseParams();

            _response.result = result;

            org.chromium.mojo.bindings.ServiceMessage _message = _response.serializeWithHeader(mCore, new org.chromium.mojo.bindings.MessageHeader(SEND_ORDINAL, org.chromium.mojo.bindings.MessageHeader.MESSAGE_IS_RESPONSE_FLAG, mRequestId));
            mMessageReceiver.accept(_message);
        }
    }


    static final class RestrictedUdpSocketSendToParams extends org.chromium.mojo.bindings.Struct {

        private static final int STRUCT_SIZE = 32;
        private static final org.chromium.mojo.bindings.DataHeader[] VERSION_ARRAY = new org.chromium.mojo.bindings.DataHeader[]{new org.chromium.mojo.bindings.DataHeader(32, 0)};
        private static final org.chromium.mojo.bindings.DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public org.chromium.mojo_base.mojom.ReadOnlyBuffer data;
        public HostPortPair destAddr;
        public int dnsQueryType;

        private RestrictedUdpSocketSendToParams(int version) {
            super(STRUCT_SIZE, version);
        }

        public RestrictedUdpSocketSendToParams() {
            this(0);
        }

        public static RestrictedUdpSocketSendToParams deserialize(org.chromium.mojo.bindings.Message message) {
            return decode(new org.chromium.mojo.bindings.Decoder(message));
        }

        /**
         * Similar to the method above, but deserializes from a |ByteBuffer| instance.
         *
         * @throws org.chromium.mojo.bindings.DeserializationException on deserialization failure.
         */
        public static RestrictedUdpSocketSendToParams deserialize(java.nio.ByteBuffer data) {
            return deserialize(new org.chromium.mojo.bindings.Message(data, new java.util.ArrayList<org.chromium.mojo.system.Handle>()));
        }

        @SuppressWarnings("unchecked")
        public static RestrictedUdpSocketSendToParams decode(org.chromium.mojo.bindings.Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            RestrictedUdpSocketSendToParams result;
            try {
                org.chromium.mojo.bindings.DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                final int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new RestrictedUdpSocketSendToParams(elementsOrVersion);
                {

                    org.chromium.mojo.bindings.Decoder decoder1 = decoder0.readPointer(8, false);
                    result.data = org.chromium.mojo_base.mojom.ReadOnlyBuffer.decode(decoder1);
                }
                {

                    org.chromium.mojo.bindings.Decoder decoder1 = decoder0.readPointer(16, false);
                    result.destAddr = HostPortPair.decode(decoder1);
                }
                {

                    result.dnsQueryType = decoder0.readInt(24);
                    DnsQueryType.validate(result.dnsQueryType);
                    result.dnsQueryType = DnsQueryType.toKnownValue(result.dnsQueryType);
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

            encoder0.encode(this.destAddr, 16, false);

            encoder0.encode(this.dnsQueryType, 24);
        }
    }


    static final class RestrictedUdpSocketSendToResponseParams extends org.chromium.mojo.bindings.Struct {

        private static final int STRUCT_SIZE = 16;
        private static final org.chromium.mojo.bindings.DataHeader[] VERSION_ARRAY = new org.chromium.mojo.bindings.DataHeader[]{new org.chromium.mojo.bindings.DataHeader(16, 0)};
        private static final org.chromium.mojo.bindings.DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public int result;

        private RestrictedUdpSocketSendToResponseParams(int version) {
            super(STRUCT_SIZE, version);
        }

        public RestrictedUdpSocketSendToResponseParams() {
            this(0);
        }

        public static RestrictedUdpSocketSendToResponseParams deserialize(org.chromium.mojo.bindings.Message message) {
            return decode(new org.chromium.mojo.bindings.Decoder(message));
        }

        /**
         * Similar to the method above, but deserializes from a |ByteBuffer| instance.
         *
         * @throws org.chromium.mojo.bindings.DeserializationException on deserialization failure.
         */
        public static RestrictedUdpSocketSendToResponseParams deserialize(java.nio.ByteBuffer data) {
            return deserialize(new org.chromium.mojo.bindings.Message(data, new java.util.ArrayList<org.chromium.mojo.system.Handle>()));
        }

        @SuppressWarnings("unchecked")
        public static RestrictedUdpSocketSendToResponseParams decode(org.chromium.mojo.bindings.Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            RestrictedUdpSocketSendToResponseParams result;
            try {
                org.chromium.mojo.bindings.DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                final int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new RestrictedUdpSocketSendToResponseParams(elementsOrVersion);
                {

                    result.result = decoder0.readInt(8);
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

            encoder0.encode(this.result, 8);
        }
    }

    static class RestrictedUdpSocketSendToResponseParamsForwardToCallback extends org.chromium.mojo.bindings.SideEffectFreeCloseable implements org.chromium.mojo.bindings.MessageReceiver {
        private final RestrictedUdpSocket.SendTo_Response mCallback;

        RestrictedUdpSocketSendToResponseParamsForwardToCallback(RestrictedUdpSocket.SendTo_Response callback) {
            this.mCallback = callback;
        }

        @Override
        public boolean accept(org.chromium.mojo.bindings.Message message) {
            try {
                org.chromium.mojo.bindings.ServiceMessage messageWithHeader = message.asServiceMessage();
                org.chromium.mojo.bindings.MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(SEND_TO_ORDINAL, org.chromium.mojo.bindings.MessageHeader.MESSAGE_IS_RESPONSE_FLAG)) {
                    return false;
                }

                RestrictedUdpSocketSendToResponseParams response = RestrictedUdpSocketSendToResponseParams.deserialize(messageWithHeader.getPayload());

                mCallback.call(response.result);
                return true;
            } catch (org.chromium.mojo.bindings.DeserializationException e) {
                return false;
            }
        }
    }

    static class RestrictedUdpSocketSendToResponseParamsProxyToResponder implements RestrictedUdpSocket.SendTo_Response {

        private final org.chromium.mojo.system.Core mCore;
        private final org.chromium.mojo.bindings.MessageReceiver mMessageReceiver;
        private final long mRequestId;

        RestrictedUdpSocketSendToResponseParamsProxyToResponder(org.chromium.mojo.system.Core core, org.chromium.mojo.bindings.MessageReceiver messageReceiver, long requestId) {
            mCore = core;
            mMessageReceiver = messageReceiver;
            mRequestId = requestId;
        }

        @Override
        public void call(Integer result) {
            RestrictedUdpSocketSendToResponseParams _response = new RestrictedUdpSocketSendToResponseParams();

            _response.result = result;

            org.chromium.mojo.bindings.ServiceMessage _message = _response.serializeWithHeader(mCore, new org.chromium.mojo.bindings.MessageHeader(SEND_TO_ORDINAL, org.chromium.mojo.bindings.MessageHeader.MESSAGE_IS_RESPONSE_FLAG, mRequestId));
            mMessageReceiver.accept(_message);
        }
    }


}