// HttpCacheBackendFileOperationsFactory_Internal.java is auto generated by mojom_bindings_generator.py, do not edit


// Copyright 2014 The Chromium Authors
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.

// This file is autogenerated by:
//     mojo/public/tools/bindings/mojom_bindings_generator.py
// For:
//     services/network/public/mojom/http_cache_backend_file_operations.mojom
//

package org.chromium.network.mojom;

class HttpCacheBackendFileOperationsFactory_Internal {

    public static final org.chromium.mojo.bindings.Interface.Manager<HttpCacheBackendFileOperationsFactory, HttpCacheBackendFileOperationsFactory.Proxy> MANAGER = new org.chromium.mojo.bindings.Interface.Manager<HttpCacheBackendFileOperationsFactory, HttpCacheBackendFileOperationsFactory.Proxy>() {

        @Override
        public String getName() {
            return "network.mojom.HttpCacheBackendFileOperationsFactory";
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
        public Stub buildStub(org.chromium.mojo.system.Core core, HttpCacheBackendFileOperationsFactory impl) {
            return new Stub(core, impl);
        }

        @Override
        public HttpCacheBackendFileOperationsFactory[] buildArray(int size) {
            return new HttpCacheBackendFileOperationsFactory[size];
        }
    };


    private static final int CREATE_ORDINAL = 0;


    static final class Proxy extends org.chromium.mojo.bindings.Interface.AbstractProxy implements HttpCacheBackendFileOperationsFactory.Proxy {

        Proxy(org.chromium.mojo.system.Core core, org.chromium.mojo.bindings.MessageReceiverWithResponder messageReceiver) {
            super(core, messageReceiver);
        }


        @Override
        public void create(org.chromium.mojo.bindings.InterfaceRequest<HttpCacheBackendFileOperations> receiver) {

            HttpCacheBackendFileOperationsFactoryCreateParams _message = new HttpCacheBackendFileOperationsFactoryCreateParams();

            _message.receiver = receiver;


            getProxyHandler().getMessageReceiver().accept(_message.serializeWithHeader(getProxyHandler().getCore(), new org.chromium.mojo.bindings.MessageHeader(CREATE_ORDINAL)));

        }


    }

    static final class Stub extends org.chromium.mojo.bindings.Interface.Stub<HttpCacheBackendFileOperationsFactory> {

        Stub(org.chromium.mojo.system.Core core, HttpCacheBackendFileOperationsFactory impl) {
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
                        return org.chromium.mojo.bindings.InterfaceControlMessagesHelper.handleRunOrClosePipe(HttpCacheBackendFileOperationsFactory_Internal.MANAGER, messageWithHeader);


                    case CREATE_ORDINAL: {

                        HttpCacheBackendFileOperationsFactoryCreateParams data = HttpCacheBackendFileOperationsFactoryCreateParams.deserialize(messageWithHeader.getPayload());

                        getImpl().create(data.receiver);
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
                        return org.chromium.mojo.bindings.InterfaceControlMessagesHelper.handleRun(getCore(), HttpCacheBackendFileOperationsFactory_Internal.MANAGER, messageWithHeader, receiver);


                    default:
                        return false;
                }
            } catch (org.chromium.mojo.bindings.DeserializationException e) {
                System.err.println(e);
                return false;
            }
        }
    }


    static final class HttpCacheBackendFileOperationsFactoryCreateParams extends org.chromium.mojo.bindings.Struct {

        private static final int STRUCT_SIZE = 16;
        private static final org.chromium.mojo.bindings.DataHeader[] VERSION_ARRAY = new org.chromium.mojo.bindings.DataHeader[]{new org.chromium.mojo.bindings.DataHeader(16, 0)};
        private static final org.chromium.mojo.bindings.DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public org.chromium.mojo.bindings.InterfaceRequest<HttpCacheBackendFileOperations> receiver;

        private HttpCacheBackendFileOperationsFactoryCreateParams(int version) {
            super(STRUCT_SIZE, version);
        }

        public HttpCacheBackendFileOperationsFactoryCreateParams() {
            this(0);
        }

        public static HttpCacheBackendFileOperationsFactoryCreateParams deserialize(org.chromium.mojo.bindings.Message message) {
            return decode(new org.chromium.mojo.bindings.Decoder(message));
        }

        /**
         * Similar to the method above, but deserializes from a |ByteBuffer| instance.
         *
         * @throws org.chromium.mojo.bindings.DeserializationException on deserialization failure.
         */
        public static HttpCacheBackendFileOperationsFactoryCreateParams deserialize(java.nio.ByteBuffer data) {
            return deserialize(new org.chromium.mojo.bindings.Message(data, new java.util.ArrayList<org.chromium.mojo.system.Handle>()));
        }

        @SuppressWarnings("unchecked")
        public static HttpCacheBackendFileOperationsFactoryCreateParams decode(org.chromium.mojo.bindings.Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            HttpCacheBackendFileOperationsFactoryCreateParams result;
            try {
                org.chromium.mojo.bindings.DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                final int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new HttpCacheBackendFileOperationsFactoryCreateParams(elementsOrVersion);
                {

                    result.receiver = decoder0.readInterfaceRequest(8, false);
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

            encoder0.encode(this.receiver, 8, false);
        }
    }


}