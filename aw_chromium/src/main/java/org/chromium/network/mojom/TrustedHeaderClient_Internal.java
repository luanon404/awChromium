// TrustedHeaderClient_Internal.java is auto generated by mojom_bindings_generator.py, do not edit


// Copyright 2014 The Chromium Authors
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.

// This file is autogenerated by:
//     mojo/public/tools/bindings/mojom_bindings_generator.py
// For:
//     services/network/public/mojom/network_context.mojom
//

package org.chromium.network.mojom;

import androidx.annotation.IntDef;


class TrustedHeaderClient_Internal {

    public static final org.chromium.mojo.bindings.Interface.Manager<TrustedHeaderClient, TrustedHeaderClient.Proxy> MANAGER =
            new org.chromium.mojo.bindings.Interface.Manager<TrustedHeaderClient, TrustedHeaderClient.Proxy>() {

        @Override
        public String getName() {
            return "network.mojom.TrustedHeaderClient";
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
        public Stub buildStub(org.chromium.mojo.system.Core core, TrustedHeaderClient impl) {
            return new Stub(core, impl);
        }

        @Override
        public TrustedHeaderClient[] buildArray(int size) {
          return new TrustedHeaderClient[size];
        }
    };


    private static final int ON_BEFORE_SEND_HEADERS_ORDINAL = 0;

    private static final int ON_HEADERS_RECEIVED_ORDINAL = 1;


    static final class Proxy extends org.chromium.mojo.bindings.Interface.AbstractProxy implements TrustedHeaderClient.Proxy {

        Proxy(org.chromium.mojo.system.Core core,
              org.chromium.mojo.bindings.MessageReceiverWithResponder messageReceiver) {
            super(core, messageReceiver);
        }


        @Override
        public void onBeforeSendHeaders(
HttpRequestHeaders headers, 
OnBeforeSendHeaders_Response callback) {

            TrustedHeaderClientOnBeforeSendHeadersParams _message = new TrustedHeaderClientOnBeforeSendHeadersParams();

            _message.headers = headers;


            getProxyHandler().getMessageReceiver().acceptWithResponder(
                    _message.serializeWithHeader(
                            getProxyHandler().getCore(),
                            new org.chromium.mojo.bindings.MessageHeader(
                                    ON_BEFORE_SEND_HEADERS_ORDINAL,
                                    org.chromium.mojo.bindings.MessageHeader.MESSAGE_EXPECTS_RESPONSE_FLAG,
                                    0)),
                    new TrustedHeaderClientOnBeforeSendHeadersResponseParamsForwardToCallback(callback));

        }


        @Override
        public void onHeadersReceived(
String headers, IpEndPoint remoteEndpoint, 
OnHeadersReceived_Response callback) {

            TrustedHeaderClientOnHeadersReceivedParams _message = new TrustedHeaderClientOnHeadersReceivedParams();

            _message.headers = headers;

            _message.remoteEndpoint = remoteEndpoint;


            getProxyHandler().getMessageReceiver().acceptWithResponder(
                    _message.serializeWithHeader(
                            getProxyHandler().getCore(),
                            new org.chromium.mojo.bindings.MessageHeader(
                                    ON_HEADERS_RECEIVED_ORDINAL,
                                    org.chromium.mojo.bindings.MessageHeader.MESSAGE_EXPECTS_RESPONSE_FLAG,
                                    0)),
                    new TrustedHeaderClientOnHeadersReceivedResponseParamsForwardToCallback(callback));

        }


    }

    static final class Stub extends org.chromium.mojo.bindings.Interface.Stub<TrustedHeaderClient> {

        Stub(org.chromium.mojo.system.Core core, TrustedHeaderClient impl) {
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
                                TrustedHeaderClient_Internal.MANAGER, messageWithHeader);






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
                                getCore(), TrustedHeaderClient_Internal.MANAGER, messageWithHeader, receiver);







                    case ON_BEFORE_SEND_HEADERS_ORDINAL: {

                        TrustedHeaderClientOnBeforeSendHeadersParams data =
                                TrustedHeaderClientOnBeforeSendHeadersParams.deserialize(messageWithHeader.getPayload());

                        getImpl().onBeforeSendHeaders(data.headers, new TrustedHeaderClientOnBeforeSendHeadersResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
                        return true;
                    }







                    case ON_HEADERS_RECEIVED_ORDINAL: {

                        TrustedHeaderClientOnHeadersReceivedParams data =
                                TrustedHeaderClientOnHeadersReceivedParams.deserialize(messageWithHeader.getPayload());

                        getImpl().onHeadersReceived(data.headers, data.remoteEndpoint, new TrustedHeaderClientOnHeadersReceivedResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
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
    }


    
    static final class TrustedHeaderClientOnBeforeSendHeadersParams extends org.chromium.mojo.bindings.Struct {

        private static final int STRUCT_SIZE = 16;
        private static final org.chromium.mojo.bindings.DataHeader[] VERSION_ARRAY = new org.chromium.mojo.bindings.DataHeader[] {new org.chromium.mojo.bindings.DataHeader(16, 0)};
        private static final org.chromium.mojo.bindings.DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public HttpRequestHeaders headers;

        private TrustedHeaderClientOnBeforeSendHeadersParams(int version) {
            super(STRUCT_SIZE, version);
        }

        public TrustedHeaderClientOnBeforeSendHeadersParams() {
            this(0);
        }

        public static TrustedHeaderClientOnBeforeSendHeadersParams deserialize(org.chromium.mojo.bindings.Message message) {
            return decode(new org.chromium.mojo.bindings.Decoder(message));
        }

        /**
         * Similar to the method above, but deserializes from a |ByteBuffer| instance.
         *
         * @throws org.chromium.mojo.bindings.DeserializationException on deserialization failure.
         */
        public static TrustedHeaderClientOnBeforeSendHeadersParams deserialize(java.nio.ByteBuffer data) {
            return deserialize(new org.chromium.mojo.bindings.Message(
                    data, new java.util.ArrayList<org.chromium.mojo.system.Handle>()));
        }

        @SuppressWarnings("unchecked")
        public static TrustedHeaderClientOnBeforeSendHeadersParams decode(org.chromium.mojo.bindings.Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            TrustedHeaderClientOnBeforeSendHeadersParams result;
            try {
                org.chromium.mojo.bindings.DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                final int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new TrustedHeaderClientOnBeforeSendHeadersParams(elementsOrVersion);
                    {
                        
                    org.chromium.mojo.bindings.Decoder decoder1 = decoder0.readPointer(8, false);
                    result.headers = HttpRequestHeaders.decode(decoder1);
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
            
            encoder0.encode(this.headers, 8, false);
        }
    }



    
    static final class TrustedHeaderClientOnBeforeSendHeadersResponseParams extends org.chromium.mojo.bindings.Struct {

        private static final int STRUCT_SIZE = 24;
        private static final org.chromium.mojo.bindings.DataHeader[] VERSION_ARRAY = new org.chromium.mojo.bindings.DataHeader[] {new org.chromium.mojo.bindings.DataHeader(24, 0)};
        private static final org.chromium.mojo.bindings.DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public int result;
        public HttpRequestHeaders headers;

        private TrustedHeaderClientOnBeforeSendHeadersResponseParams(int version) {
            super(STRUCT_SIZE, version);
        }

        public TrustedHeaderClientOnBeforeSendHeadersResponseParams() {
            this(0);
        }

        public static TrustedHeaderClientOnBeforeSendHeadersResponseParams deserialize(org.chromium.mojo.bindings.Message message) {
            return decode(new org.chromium.mojo.bindings.Decoder(message));
        }

        /**
         * Similar to the method above, but deserializes from a |ByteBuffer| instance.
         *
         * @throws org.chromium.mojo.bindings.DeserializationException on deserialization failure.
         */
        public static TrustedHeaderClientOnBeforeSendHeadersResponseParams deserialize(java.nio.ByteBuffer data) {
            return deserialize(new org.chromium.mojo.bindings.Message(
                    data, new java.util.ArrayList<org.chromium.mojo.system.Handle>()));
        }

        @SuppressWarnings("unchecked")
        public static TrustedHeaderClientOnBeforeSendHeadersResponseParams decode(org.chromium.mojo.bindings.Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            TrustedHeaderClientOnBeforeSendHeadersResponseParams result;
            try {
                org.chromium.mojo.bindings.DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                final int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new TrustedHeaderClientOnBeforeSendHeadersResponseParams(elementsOrVersion);
                    {
                        
                    result.result = decoder0.readInt(8);
                    }
                    {
                        
                    org.chromium.mojo.bindings.Decoder decoder1 = decoder0.readPointer(16, true);
                    result.headers = HttpRequestHeaders.decode(decoder1);
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
            
            encoder0.encode(this.headers, 16, true);
        }
    }

    static class TrustedHeaderClientOnBeforeSendHeadersResponseParamsForwardToCallback extends org.chromium.mojo.bindings.SideEffectFreeCloseable
            implements org.chromium.mojo.bindings.MessageReceiver {
        private final TrustedHeaderClient.OnBeforeSendHeaders_Response mCallback;

        TrustedHeaderClientOnBeforeSendHeadersResponseParamsForwardToCallback(TrustedHeaderClient.OnBeforeSendHeaders_Response callback) {
            this.mCallback = callback;
        }

        @Override
        public boolean accept(org.chromium.mojo.bindings.Message message) {
            try {
                org.chromium.mojo.bindings.ServiceMessage messageWithHeader =
                        message.asServiceMessage();
                org.chromium.mojo.bindings.MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(ON_BEFORE_SEND_HEADERS_ORDINAL,
                                           org.chromium.mojo.bindings.MessageHeader.MESSAGE_IS_RESPONSE_FLAG)) {
                    return false;
                }

                TrustedHeaderClientOnBeforeSendHeadersResponseParams response = TrustedHeaderClientOnBeforeSendHeadersResponseParams.deserialize(messageWithHeader.getPayload());

                mCallback.call(response.result, response.headers);
                return true;
            } catch (org.chromium.mojo.bindings.DeserializationException e) {
                return false;
            }
        }
    }

    static class TrustedHeaderClientOnBeforeSendHeadersResponseParamsProxyToResponder implements TrustedHeaderClient.OnBeforeSendHeaders_Response {

        private final org.chromium.mojo.system.Core mCore;
        private final org.chromium.mojo.bindings.MessageReceiver mMessageReceiver;
        private final long mRequestId;

        TrustedHeaderClientOnBeforeSendHeadersResponseParamsProxyToResponder(
                org.chromium.mojo.system.Core core,
                org.chromium.mojo.bindings.MessageReceiver messageReceiver,
                long requestId) {
            mCore = core;
            mMessageReceiver = messageReceiver;
            mRequestId = requestId;
        }

        @Override
        public void call(Integer result, HttpRequestHeaders headers) {
            TrustedHeaderClientOnBeforeSendHeadersResponseParams _response = new TrustedHeaderClientOnBeforeSendHeadersResponseParams();

            _response.result = result;

            _response.headers = headers;

            org.chromium.mojo.bindings.ServiceMessage _message =
                    _response.serializeWithHeader(
                            mCore,
                            new org.chromium.mojo.bindings.MessageHeader(
                                    ON_BEFORE_SEND_HEADERS_ORDINAL,
                                    org.chromium.mojo.bindings.MessageHeader.MESSAGE_IS_RESPONSE_FLAG,
                                    mRequestId));
            mMessageReceiver.accept(_message);
        }
    }



    
    static final class TrustedHeaderClientOnHeadersReceivedParams extends org.chromium.mojo.bindings.Struct {

        private static final int STRUCT_SIZE = 24;
        private static final org.chromium.mojo.bindings.DataHeader[] VERSION_ARRAY = new org.chromium.mojo.bindings.DataHeader[] {new org.chromium.mojo.bindings.DataHeader(24, 0)};
        private static final org.chromium.mojo.bindings.DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public String headers;
        public IpEndPoint remoteEndpoint;

        private TrustedHeaderClientOnHeadersReceivedParams(int version) {
            super(STRUCT_SIZE, version);
        }

        public TrustedHeaderClientOnHeadersReceivedParams() {
            this(0);
        }

        public static TrustedHeaderClientOnHeadersReceivedParams deserialize(org.chromium.mojo.bindings.Message message) {
            return decode(new org.chromium.mojo.bindings.Decoder(message));
        }

        /**
         * Similar to the method above, but deserializes from a |ByteBuffer| instance.
         *
         * @throws org.chromium.mojo.bindings.DeserializationException on deserialization failure.
         */
        public static TrustedHeaderClientOnHeadersReceivedParams deserialize(java.nio.ByteBuffer data) {
            return deserialize(new org.chromium.mojo.bindings.Message(
                    data, new java.util.ArrayList<org.chromium.mojo.system.Handle>()));
        }

        @SuppressWarnings("unchecked")
        public static TrustedHeaderClientOnHeadersReceivedParams decode(org.chromium.mojo.bindings.Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            TrustedHeaderClientOnHeadersReceivedParams result;
            try {
                org.chromium.mojo.bindings.DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                final int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new TrustedHeaderClientOnHeadersReceivedParams(elementsOrVersion);
                    {
                        
                    result.headers = decoder0.readString(8, false);
                    }
                    {
                        
                    org.chromium.mojo.bindings.Decoder decoder1 = decoder0.readPointer(16, false);
                    result.remoteEndpoint = IpEndPoint.decode(decoder1);
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
            
            encoder0.encode(this.headers, 8, false);
            
            encoder0.encode(this.remoteEndpoint, 16, false);
        }
    }



    
    static final class TrustedHeaderClientOnHeadersReceivedResponseParams extends org.chromium.mojo.bindings.Struct {

        private static final int STRUCT_SIZE = 32;
        private static final org.chromium.mojo.bindings.DataHeader[] VERSION_ARRAY = new org.chromium.mojo.bindings.DataHeader[] {new org.chromium.mojo.bindings.DataHeader(32, 0)};
        private static final org.chromium.mojo.bindings.DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public int result;
        public String headers;
        public org.chromium.url.mojom.Url preserveFragmentOnRedirectUrl;

        private TrustedHeaderClientOnHeadersReceivedResponseParams(int version) {
            super(STRUCT_SIZE, version);
        }

        public TrustedHeaderClientOnHeadersReceivedResponseParams() {
            this(0);
        }

        public static TrustedHeaderClientOnHeadersReceivedResponseParams deserialize(org.chromium.mojo.bindings.Message message) {
            return decode(new org.chromium.mojo.bindings.Decoder(message));
        }

        /**
         * Similar to the method above, but deserializes from a |ByteBuffer| instance.
         *
         * @throws org.chromium.mojo.bindings.DeserializationException on deserialization failure.
         */
        public static TrustedHeaderClientOnHeadersReceivedResponseParams deserialize(java.nio.ByteBuffer data) {
            return deserialize(new org.chromium.mojo.bindings.Message(
                    data, new java.util.ArrayList<org.chromium.mojo.system.Handle>()));
        }

        @SuppressWarnings("unchecked")
        public static TrustedHeaderClientOnHeadersReceivedResponseParams decode(org.chromium.mojo.bindings.Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            TrustedHeaderClientOnHeadersReceivedResponseParams result;
            try {
                org.chromium.mojo.bindings.DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                final int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new TrustedHeaderClientOnHeadersReceivedResponseParams(elementsOrVersion);
                    {
                        
                    result.result = decoder0.readInt(8);
                    }
                    {
                        
                    result.headers = decoder0.readString(16, true);
                    }
                    {
                        
                    org.chromium.mojo.bindings.Decoder decoder1 = decoder0.readPointer(24, true);
                    result.preserveFragmentOnRedirectUrl = org.chromium.url.mojom.Url.decode(decoder1);
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
            
            encoder0.encode(this.headers, 16, true);
            
            encoder0.encode(this.preserveFragmentOnRedirectUrl, 24, true);
        }
    }

    static class TrustedHeaderClientOnHeadersReceivedResponseParamsForwardToCallback extends org.chromium.mojo.bindings.SideEffectFreeCloseable
            implements org.chromium.mojo.bindings.MessageReceiver {
        private final TrustedHeaderClient.OnHeadersReceived_Response mCallback;

        TrustedHeaderClientOnHeadersReceivedResponseParamsForwardToCallback(TrustedHeaderClient.OnHeadersReceived_Response callback) {
            this.mCallback = callback;
        }

        @Override
        public boolean accept(org.chromium.mojo.bindings.Message message) {
            try {
                org.chromium.mojo.bindings.ServiceMessage messageWithHeader =
                        message.asServiceMessage();
                org.chromium.mojo.bindings.MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(ON_HEADERS_RECEIVED_ORDINAL,
                                           org.chromium.mojo.bindings.MessageHeader.MESSAGE_IS_RESPONSE_FLAG)) {
                    return false;
                }

                TrustedHeaderClientOnHeadersReceivedResponseParams response = TrustedHeaderClientOnHeadersReceivedResponseParams.deserialize(messageWithHeader.getPayload());

                mCallback.call(response.result, response.headers, response.preserveFragmentOnRedirectUrl);
                return true;
            } catch (org.chromium.mojo.bindings.DeserializationException e) {
                return false;
            }
        }
    }

    static class TrustedHeaderClientOnHeadersReceivedResponseParamsProxyToResponder implements TrustedHeaderClient.OnHeadersReceived_Response {

        private final org.chromium.mojo.system.Core mCore;
        private final org.chromium.mojo.bindings.MessageReceiver mMessageReceiver;
        private final long mRequestId;

        TrustedHeaderClientOnHeadersReceivedResponseParamsProxyToResponder(
                org.chromium.mojo.system.Core core,
                org.chromium.mojo.bindings.MessageReceiver messageReceiver,
                long requestId) {
            mCore = core;
            mMessageReceiver = messageReceiver;
            mRequestId = requestId;
        }

        @Override
        public void call(Integer result, String headers, org.chromium.url.mojom.Url preserveFragmentOnRedirectUrl) {
            TrustedHeaderClientOnHeadersReceivedResponseParams _response = new TrustedHeaderClientOnHeadersReceivedResponseParams();

            _response.result = result;

            _response.headers = headers;

            _response.preserveFragmentOnRedirectUrl = preserveFragmentOnRedirectUrl;

            org.chromium.mojo.bindings.ServiceMessage _message =
                    _response.serializeWithHeader(
                            mCore,
                            new org.chromium.mojo.bindings.MessageHeader(
                                    ON_HEADERS_RECEIVED_ORDINAL,
                                    org.chromium.mojo.bindings.MessageHeader.MESSAGE_IS_RESPONSE_FLAG,
                                    mRequestId));
            mMessageReceiver.accept(_message);
        }
    }



}
