// ClientCertificateResponder_Internal.java is auto generated by mojom_bindings_generator.py, do not edit


// Copyright 2014 The Chromium Authors
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.

// This file is autogenerated by:
//     mojo/public/tools/bindings/mojom_bindings_generator.py
// For:
//     services/network/public/mojom/url_loader_network_service_observer.mojom
//

package org.chromium.network.mojom;

import androidx.annotation.IntDef;


class ClientCertificateResponder_Internal {

    public static final org.chromium.mojo.bindings.Interface.Manager<ClientCertificateResponder, ClientCertificateResponder.Proxy> MANAGER =
            new org.chromium.mojo.bindings.Interface.Manager<ClientCertificateResponder, ClientCertificateResponder.Proxy>() {

        @Override
        public String getName() {
            return "network.mojom.ClientCertificateResponder";
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
        public Stub buildStub(org.chromium.mojo.system.Core core, ClientCertificateResponder impl) {
            return new Stub(core, impl);
        }

        @Override
        public ClientCertificateResponder[] buildArray(int size) {
          return new ClientCertificateResponder[size];
        }
    };


    private static final int CONTINUE_WITH_CERTIFICATE_ORDINAL = 0;

    private static final int CONTINUE_WITHOUT_CERTIFICATE_ORDINAL = 1;

    private static final int CANCEL_REQUEST_ORDINAL = 2;


    static final class Proxy extends org.chromium.mojo.bindings.Interface.AbstractProxy implements ClientCertificateResponder.Proxy {

        Proxy(org.chromium.mojo.system.Core core,
              org.chromium.mojo.bindings.MessageReceiverWithResponder messageReceiver) {
            super(core, messageReceiver);
        }


        @Override
        public void continueWithCertificate(
X509Certificate x509Certificate, String providerName, short[] algorithmPreferences, SslPrivateKey sslPrivateKey) {

            ClientCertificateResponderContinueWithCertificateParams _message = new ClientCertificateResponderContinueWithCertificateParams();

            _message.x509Certificate = x509Certificate;

            _message.providerName = providerName;

            _message.algorithmPreferences = algorithmPreferences;

            _message.sslPrivateKey = sslPrivateKey;


            getProxyHandler().getMessageReceiver().accept(
                    _message.serializeWithHeader(
                            getProxyHandler().getCore(),
                            new org.chromium.mojo.bindings.MessageHeader(CONTINUE_WITH_CERTIFICATE_ORDINAL)));

        }


        @Override
        public void continueWithoutCertificate(
) {

            ClientCertificateResponderContinueWithoutCertificateParams _message = new ClientCertificateResponderContinueWithoutCertificateParams();


            getProxyHandler().getMessageReceiver().accept(
                    _message.serializeWithHeader(
                            getProxyHandler().getCore(),
                            new org.chromium.mojo.bindings.MessageHeader(CONTINUE_WITHOUT_CERTIFICATE_ORDINAL)));

        }


        @Override
        public void cancelRequest(
) {

            ClientCertificateResponderCancelRequestParams _message = new ClientCertificateResponderCancelRequestParams();


            getProxyHandler().getMessageReceiver().accept(
                    _message.serializeWithHeader(
                            getProxyHandler().getCore(),
                            new org.chromium.mojo.bindings.MessageHeader(CANCEL_REQUEST_ORDINAL)));

        }


    }

    static final class Stub extends org.chromium.mojo.bindings.Interface.Stub<ClientCertificateResponder> {

        Stub(org.chromium.mojo.system.Core core, ClientCertificateResponder impl) {
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
                                ClientCertificateResponder_Internal.MANAGER, messageWithHeader);





                    case CONTINUE_WITH_CERTIFICATE_ORDINAL: {

                        ClientCertificateResponderContinueWithCertificateParams data =
                                ClientCertificateResponderContinueWithCertificateParams.deserialize(messageWithHeader.getPayload());

                        getImpl().continueWithCertificate(data.x509Certificate, data.providerName, data.algorithmPreferences, data.sslPrivateKey);
                        return true;
                    }





                    case CONTINUE_WITHOUT_CERTIFICATE_ORDINAL: {

                        ClientCertificateResponderContinueWithoutCertificateParams.deserialize(messageWithHeader.getPayload());

                        getImpl().continueWithoutCertificate();
                        return true;
                    }





                    case CANCEL_REQUEST_ORDINAL: {

                        ClientCertificateResponderCancelRequestParams.deserialize(messageWithHeader.getPayload());

                        getImpl().cancelRequest();
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
                                getCore(), ClientCertificateResponder_Internal.MANAGER, messageWithHeader, receiver);








                    default:
                        return false;
                }
            } catch (org.chromium.mojo.bindings.DeserializationException e) {
                System.err.println(e.toString());
                return false;
            }
        }
    }


    
    static final class ClientCertificateResponderContinueWithCertificateParams extends org.chromium.mojo.bindings.Struct {

        private static final int STRUCT_SIZE = 40;
        private static final org.chromium.mojo.bindings.DataHeader[] VERSION_ARRAY = new org.chromium.mojo.bindings.DataHeader[] {new org.chromium.mojo.bindings.DataHeader(40, 0)};
        private static final org.chromium.mojo.bindings.DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public X509Certificate x509Certificate;
        public String providerName;
        public short[] algorithmPreferences;
        public SslPrivateKey sslPrivateKey;

        private ClientCertificateResponderContinueWithCertificateParams(int version) {
            super(STRUCT_SIZE, version);
        }

        public ClientCertificateResponderContinueWithCertificateParams() {
            this(0);
        }

        public static ClientCertificateResponderContinueWithCertificateParams deserialize(org.chromium.mojo.bindings.Message message) {
            return decode(new org.chromium.mojo.bindings.Decoder(message));
        }

        /**
         * Similar to the method above, but deserializes from a |ByteBuffer| instance.
         *
         * @throws org.chromium.mojo.bindings.DeserializationException on deserialization failure.
         */
        public static ClientCertificateResponderContinueWithCertificateParams deserialize(java.nio.ByteBuffer data) {
            return deserialize(new org.chromium.mojo.bindings.Message(
                    data, new java.util.ArrayList<org.chromium.mojo.system.Handle>()));
        }

        @SuppressWarnings("unchecked")
        public static ClientCertificateResponderContinueWithCertificateParams decode(org.chromium.mojo.bindings.Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            ClientCertificateResponderContinueWithCertificateParams result;
            try {
                org.chromium.mojo.bindings.DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                final int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new ClientCertificateResponderContinueWithCertificateParams(elementsOrVersion);
                    {
                        
                    org.chromium.mojo.bindings.Decoder decoder1 = decoder0.readPointer(8, false);
                    result.x509Certificate = X509Certificate.decode(decoder1);
                    }
                    {
                        
                    result.providerName = decoder0.readString(16, false);
                    }
                    {
                        
                    result.algorithmPreferences = decoder0.readShorts(24, org.chromium.mojo.bindings.BindingsHelper.NOTHING_NULLABLE, org.chromium.mojo.bindings.BindingsHelper.UNSPECIFIED_ARRAY_LENGTH);
                    }
                    {
                        
                    result.sslPrivateKey = decoder0.readServiceInterface(32, false, SslPrivateKey.MANAGER);
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
            
            encoder0.encode(this.x509Certificate, 8, false);
            
            encoder0.encode(this.providerName, 16, false);
            
            encoder0.encode(this.algorithmPreferences, 24, org.chromium.mojo.bindings.BindingsHelper.NOTHING_NULLABLE, org.chromium.mojo.bindings.BindingsHelper.UNSPECIFIED_ARRAY_LENGTH);
            
            encoder0.encode(this.sslPrivateKey, 32, false, SslPrivateKey.MANAGER);
        }
    }



    
    static final class ClientCertificateResponderContinueWithoutCertificateParams extends org.chromium.mojo.bindings.Struct {

        private static final int STRUCT_SIZE = 8;
        private static final org.chromium.mojo.bindings.DataHeader[] VERSION_ARRAY = new org.chromium.mojo.bindings.DataHeader[] {new org.chromium.mojo.bindings.DataHeader(8, 0)};
        private static final org.chromium.mojo.bindings.DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        private ClientCertificateResponderContinueWithoutCertificateParams(int version) {
            super(STRUCT_SIZE, version);
        }

        public ClientCertificateResponderContinueWithoutCertificateParams() {
            this(0);
        }

        public static ClientCertificateResponderContinueWithoutCertificateParams deserialize(org.chromium.mojo.bindings.Message message) {
            return decode(new org.chromium.mojo.bindings.Decoder(message));
        }

        /**
         * Similar to the method above, but deserializes from a |ByteBuffer| instance.
         *
         * @throws org.chromium.mojo.bindings.DeserializationException on deserialization failure.
         */
        public static ClientCertificateResponderContinueWithoutCertificateParams deserialize(java.nio.ByteBuffer data) {
            return deserialize(new org.chromium.mojo.bindings.Message(
                    data, new java.util.ArrayList<org.chromium.mojo.system.Handle>()));
        }

        @SuppressWarnings("unchecked")
        public static ClientCertificateResponderContinueWithoutCertificateParams decode(org.chromium.mojo.bindings.Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            ClientCertificateResponderContinueWithoutCertificateParams result;
            try {
                org.chromium.mojo.bindings.DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                final int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new ClientCertificateResponderContinueWithoutCertificateParams(elementsOrVersion);

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



    
    static final class ClientCertificateResponderCancelRequestParams extends org.chromium.mojo.bindings.Struct {

        private static final int STRUCT_SIZE = 8;
        private static final org.chromium.mojo.bindings.DataHeader[] VERSION_ARRAY = new org.chromium.mojo.bindings.DataHeader[] {new org.chromium.mojo.bindings.DataHeader(8, 0)};
        private static final org.chromium.mojo.bindings.DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        private ClientCertificateResponderCancelRequestParams(int version) {
            super(STRUCT_SIZE, version);
        }

        public ClientCertificateResponderCancelRequestParams() {
            this(0);
        }

        public static ClientCertificateResponderCancelRequestParams deserialize(org.chromium.mojo.bindings.Message message) {
            return decode(new org.chromium.mojo.bindings.Decoder(message));
        }

        /**
         * Similar to the method above, but deserializes from a |ByteBuffer| instance.
         *
         * @throws org.chromium.mojo.bindings.DeserializationException on deserialization failure.
         */
        public static ClientCertificateResponderCancelRequestParams deserialize(java.nio.ByteBuffer data) {
            return deserialize(new org.chromium.mojo.bindings.Message(
                    data, new java.util.ArrayList<org.chromium.mojo.system.Handle>()));
        }

        @SuppressWarnings("unchecked")
        public static ClientCertificateResponderCancelRequestParams decode(org.chromium.mojo.bindings.Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            ClientCertificateResponderCancelRequestParams result;
            try {
                org.chromium.mojo.bindings.DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                final int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new ClientCertificateResponderCancelRequestParams(elementsOrVersion);

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
