// CdmDocumentService_Internal.java is auto generated by mojom_bindings_generator.py, do not edit


// Copyright 2014 The Chromium Authors
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.

// This file is autogenerated by:
//     mojo/public/tools/bindings/mojom_bindings_generator.py
// For:
//     media/mojo/mojom/cdm_document_service.mojom
//

package org.chromium.media.mojom;

import androidx.annotation.IntDef;


class CdmDocumentService_Internal {

    public static final org.chromium.mojo.bindings.Interface.Manager<CdmDocumentService, CdmDocumentService.Proxy> MANAGER =
            new org.chromium.mojo.bindings.Interface.Manager<CdmDocumentService, CdmDocumentService.Proxy>() {

        @Override
        public String getName() {
            return "media.mojom.CdmDocumentService";
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
        public Stub buildStub(org.chromium.mojo.system.Core core, CdmDocumentService impl) {
            return new Stub(core, impl);
        }

        @Override
        public CdmDocumentService[] buildArray(int size) {
          return new CdmDocumentService[size];
        }
    };


    private static final int CHALLENGE_PLATFORM_ORDINAL = 0;

    private static final int GET_STORAGE_ID_ORDINAL = 1;


    static final class Proxy extends org.chromium.mojo.bindings.Interface.AbstractProxy implements CdmDocumentService.Proxy {

        Proxy(org.chromium.mojo.system.Core core,
              org.chromium.mojo.bindings.MessageReceiverWithResponder messageReceiver) {
            super(core, messageReceiver);
        }


        @Override
        public void challengePlatform(
String serviceId, String challenge, 
ChallengePlatform_Response callback) {

            CdmDocumentServiceChallengePlatformParams _message = new CdmDocumentServiceChallengePlatformParams();

            _message.serviceId = serviceId;

            _message.challenge = challenge;


            getProxyHandler().getMessageReceiver().acceptWithResponder(
                    _message.serializeWithHeader(
                            getProxyHandler().getCore(),
                            new org.chromium.mojo.bindings.MessageHeader(
                                    CHALLENGE_PLATFORM_ORDINAL,
                                    org.chromium.mojo.bindings.MessageHeader.MESSAGE_EXPECTS_RESPONSE_FLAG,
                                    0)),
                    new CdmDocumentServiceChallengePlatformResponseParamsForwardToCallback(callback));

        }


        @Override
        public void getStorageId(
int version, 
GetStorageId_Response callback) {

            CdmDocumentServiceGetStorageIdParams _message = new CdmDocumentServiceGetStorageIdParams();

            _message.version = version;


            getProxyHandler().getMessageReceiver().acceptWithResponder(
                    _message.serializeWithHeader(
                            getProxyHandler().getCore(),
                            new org.chromium.mojo.bindings.MessageHeader(
                                    GET_STORAGE_ID_ORDINAL,
                                    org.chromium.mojo.bindings.MessageHeader.MESSAGE_EXPECTS_RESPONSE_FLAG,
                                    0)),
                    new CdmDocumentServiceGetStorageIdResponseParamsForwardToCallback(callback));

        }


    }

    static final class Stub extends org.chromium.mojo.bindings.Interface.Stub<CdmDocumentService> {

        Stub(org.chromium.mojo.system.Core core, CdmDocumentService impl) {
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
                                CdmDocumentService_Internal.MANAGER, messageWithHeader);






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
                                getCore(), CdmDocumentService_Internal.MANAGER, messageWithHeader, receiver);







                    case CHALLENGE_PLATFORM_ORDINAL: {

                        CdmDocumentServiceChallengePlatformParams data =
                                CdmDocumentServiceChallengePlatformParams.deserialize(messageWithHeader.getPayload());

                        getImpl().challengePlatform(data.serviceId, data.challenge, new CdmDocumentServiceChallengePlatformResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
                        return true;
                    }







                    case GET_STORAGE_ID_ORDINAL: {

                        CdmDocumentServiceGetStorageIdParams data =
                                CdmDocumentServiceGetStorageIdParams.deserialize(messageWithHeader.getPayload());

                        getImpl().getStorageId(data.version, new CdmDocumentServiceGetStorageIdResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
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


    
    static final class CdmDocumentServiceChallengePlatformParams extends org.chromium.mojo.bindings.Struct {

        private static final int STRUCT_SIZE = 24;
        private static final org.chromium.mojo.bindings.DataHeader[] VERSION_ARRAY = new org.chromium.mojo.bindings.DataHeader[] {new org.chromium.mojo.bindings.DataHeader(24, 0)};
        private static final org.chromium.mojo.bindings.DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public String serviceId;
        public String challenge;

        private CdmDocumentServiceChallengePlatformParams(int version) {
            super(STRUCT_SIZE, version);
        }

        public CdmDocumentServiceChallengePlatformParams() {
            this(0);
        }

        public static CdmDocumentServiceChallengePlatformParams deserialize(org.chromium.mojo.bindings.Message message) {
            return decode(new org.chromium.mojo.bindings.Decoder(message));
        }

        /**
         * Similar to the method above, but deserializes from a |ByteBuffer| instance.
         *
         * @throws org.chromium.mojo.bindings.DeserializationException on deserialization failure.
         */
        public static CdmDocumentServiceChallengePlatformParams deserialize(java.nio.ByteBuffer data) {
            return deserialize(new org.chromium.mojo.bindings.Message(
                    data, new java.util.ArrayList<org.chromium.mojo.system.Handle>()));
        }

        @SuppressWarnings("unchecked")
        public static CdmDocumentServiceChallengePlatformParams decode(org.chromium.mojo.bindings.Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            CdmDocumentServiceChallengePlatformParams result;
            try {
                org.chromium.mojo.bindings.DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                final int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new CdmDocumentServiceChallengePlatformParams(elementsOrVersion);
                    {
                        
                    result.serviceId = decoder0.readString(8, false);
                    }
                    {
                        
                    result.challenge = decoder0.readString(16, false);
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
            
            encoder0.encode(this.serviceId, 8, false);
            
            encoder0.encode(this.challenge, 16, false);
        }
    }



    
    static final class CdmDocumentServiceChallengePlatformResponseParams extends org.chromium.mojo.bindings.Struct {

        private static final int STRUCT_SIZE = 40;
        private static final org.chromium.mojo.bindings.DataHeader[] VERSION_ARRAY = new org.chromium.mojo.bindings.DataHeader[] {new org.chromium.mojo.bindings.DataHeader(40, 0)};
        private static final org.chromium.mojo.bindings.DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public boolean success;
        public String signedData;
        public String signedDataSignature;
        public String platformKeyCertificate;

        private CdmDocumentServiceChallengePlatformResponseParams(int version) {
            super(STRUCT_SIZE, version);
        }

        public CdmDocumentServiceChallengePlatformResponseParams() {
            this(0);
        }

        public static CdmDocumentServiceChallengePlatformResponseParams deserialize(org.chromium.mojo.bindings.Message message) {
            return decode(new org.chromium.mojo.bindings.Decoder(message));
        }

        /**
         * Similar to the method above, but deserializes from a |ByteBuffer| instance.
         *
         * @throws org.chromium.mojo.bindings.DeserializationException on deserialization failure.
         */
        public static CdmDocumentServiceChallengePlatformResponseParams deserialize(java.nio.ByteBuffer data) {
            return deserialize(new org.chromium.mojo.bindings.Message(
                    data, new java.util.ArrayList<org.chromium.mojo.system.Handle>()));
        }

        @SuppressWarnings("unchecked")
        public static CdmDocumentServiceChallengePlatformResponseParams decode(org.chromium.mojo.bindings.Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            CdmDocumentServiceChallengePlatformResponseParams result;
            try {
                org.chromium.mojo.bindings.DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                final int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new CdmDocumentServiceChallengePlatformResponseParams(elementsOrVersion);
                    {
                        
                    result.success = decoder0.readBoolean(8, 0);
                    }
                    {
                        
                    result.signedData = decoder0.readString(16, false);
                    }
                    {
                        
                    result.signedDataSignature = decoder0.readString(24, false);
                    }
                    {
                        
                    result.platformKeyCertificate = decoder0.readString(32, false);
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
            
            encoder0.encode(this.success, 8, 0);
            
            encoder0.encode(this.signedData, 16, false);
            
            encoder0.encode(this.signedDataSignature, 24, false);
            
            encoder0.encode(this.platformKeyCertificate, 32, false);
        }
    }

    static class CdmDocumentServiceChallengePlatformResponseParamsForwardToCallback extends org.chromium.mojo.bindings.SideEffectFreeCloseable
            implements org.chromium.mojo.bindings.MessageReceiver {
        private final CdmDocumentService.ChallengePlatform_Response mCallback;

        CdmDocumentServiceChallengePlatformResponseParamsForwardToCallback(CdmDocumentService.ChallengePlatform_Response callback) {
            this.mCallback = callback;
        }

        @Override
        public boolean accept(org.chromium.mojo.bindings.Message message) {
            try {
                org.chromium.mojo.bindings.ServiceMessage messageWithHeader =
                        message.asServiceMessage();
                org.chromium.mojo.bindings.MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(CHALLENGE_PLATFORM_ORDINAL,
                                           org.chromium.mojo.bindings.MessageHeader.MESSAGE_IS_RESPONSE_FLAG)) {
                    return false;
                }

                CdmDocumentServiceChallengePlatformResponseParams response = CdmDocumentServiceChallengePlatformResponseParams.deserialize(messageWithHeader.getPayload());

                mCallback.call(response.success, response.signedData, response.signedDataSignature, response.platformKeyCertificate);
                return true;
            } catch (org.chromium.mojo.bindings.DeserializationException e) {
                return false;
            }
        }
    }

    static class CdmDocumentServiceChallengePlatformResponseParamsProxyToResponder implements CdmDocumentService.ChallengePlatform_Response {

        private final org.chromium.mojo.system.Core mCore;
        private final org.chromium.mojo.bindings.MessageReceiver mMessageReceiver;
        private final long mRequestId;

        CdmDocumentServiceChallengePlatformResponseParamsProxyToResponder(
                org.chromium.mojo.system.Core core,
                org.chromium.mojo.bindings.MessageReceiver messageReceiver,
                long requestId) {
            mCore = core;
            mMessageReceiver = messageReceiver;
            mRequestId = requestId;
        }

        @Override
        public void call(Boolean success, String signedData, String signedDataSignature, String platformKeyCertificate) {
            CdmDocumentServiceChallengePlatformResponseParams _response = new CdmDocumentServiceChallengePlatformResponseParams();

            _response.success = success;

            _response.signedData = signedData;

            _response.signedDataSignature = signedDataSignature;

            _response.platformKeyCertificate = platformKeyCertificate;

            org.chromium.mojo.bindings.ServiceMessage _message =
                    _response.serializeWithHeader(
                            mCore,
                            new org.chromium.mojo.bindings.MessageHeader(
                                    CHALLENGE_PLATFORM_ORDINAL,
                                    org.chromium.mojo.bindings.MessageHeader.MESSAGE_IS_RESPONSE_FLAG,
                                    mRequestId));
            mMessageReceiver.accept(_message);
        }
    }



    
    static final class CdmDocumentServiceGetStorageIdParams extends org.chromium.mojo.bindings.Struct {

        private static final int STRUCT_SIZE = 16;
        private static final org.chromium.mojo.bindings.DataHeader[] VERSION_ARRAY = new org.chromium.mojo.bindings.DataHeader[] {new org.chromium.mojo.bindings.DataHeader(16, 0)};
        private static final org.chromium.mojo.bindings.DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public int version;

        private CdmDocumentServiceGetStorageIdParams(int version) {
            super(STRUCT_SIZE, version);
        }

        public CdmDocumentServiceGetStorageIdParams() {
            this(0);
        }

        public static CdmDocumentServiceGetStorageIdParams deserialize(org.chromium.mojo.bindings.Message message) {
            return decode(new org.chromium.mojo.bindings.Decoder(message));
        }

        /**
         * Similar to the method above, but deserializes from a |ByteBuffer| instance.
         *
         * @throws org.chromium.mojo.bindings.DeserializationException on deserialization failure.
         */
        public static CdmDocumentServiceGetStorageIdParams deserialize(java.nio.ByteBuffer data) {
            return deserialize(new org.chromium.mojo.bindings.Message(
                    data, new java.util.ArrayList<org.chromium.mojo.system.Handle>()));
        }

        @SuppressWarnings("unchecked")
        public static CdmDocumentServiceGetStorageIdParams decode(org.chromium.mojo.bindings.Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            CdmDocumentServiceGetStorageIdParams result;
            try {
                org.chromium.mojo.bindings.DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                final int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new CdmDocumentServiceGetStorageIdParams(elementsOrVersion);
                    {
                        
                    result.version = decoder0.readInt(8);
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
            
            encoder0.encode(this.version, 8);
        }
    }



    
    static final class CdmDocumentServiceGetStorageIdResponseParams extends org.chromium.mojo.bindings.Struct {

        private static final int STRUCT_SIZE = 24;
        private static final org.chromium.mojo.bindings.DataHeader[] VERSION_ARRAY = new org.chromium.mojo.bindings.DataHeader[] {new org.chromium.mojo.bindings.DataHeader(24, 0)};
        private static final org.chromium.mojo.bindings.DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public int version;
        public byte[] storageId;

        private CdmDocumentServiceGetStorageIdResponseParams(int version) {
            super(STRUCT_SIZE, version);
        }

        public CdmDocumentServiceGetStorageIdResponseParams() {
            this(0);
        }

        public static CdmDocumentServiceGetStorageIdResponseParams deserialize(org.chromium.mojo.bindings.Message message) {
            return decode(new org.chromium.mojo.bindings.Decoder(message));
        }

        /**
         * Similar to the method above, but deserializes from a |ByteBuffer| instance.
         *
         * @throws org.chromium.mojo.bindings.DeserializationException on deserialization failure.
         */
        public static CdmDocumentServiceGetStorageIdResponseParams deserialize(java.nio.ByteBuffer data) {
            return deserialize(new org.chromium.mojo.bindings.Message(
                    data, new java.util.ArrayList<org.chromium.mojo.system.Handle>()));
        }

        @SuppressWarnings("unchecked")
        public static CdmDocumentServiceGetStorageIdResponseParams decode(org.chromium.mojo.bindings.Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            CdmDocumentServiceGetStorageIdResponseParams result;
            try {
                org.chromium.mojo.bindings.DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                final int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new CdmDocumentServiceGetStorageIdResponseParams(elementsOrVersion);
                    {
                        
                    result.version = decoder0.readInt(8);
                    }
                    {
                        
                    result.storageId = decoder0.readBytes(16, org.chromium.mojo.bindings.BindingsHelper.NOTHING_NULLABLE, org.chromium.mojo.bindings.BindingsHelper.UNSPECIFIED_ARRAY_LENGTH);
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
            
            encoder0.encode(this.version, 8);
            
            encoder0.encode(this.storageId, 16, org.chromium.mojo.bindings.BindingsHelper.NOTHING_NULLABLE, org.chromium.mojo.bindings.BindingsHelper.UNSPECIFIED_ARRAY_LENGTH);
        }
    }

    static class CdmDocumentServiceGetStorageIdResponseParamsForwardToCallback extends org.chromium.mojo.bindings.SideEffectFreeCloseable
            implements org.chromium.mojo.bindings.MessageReceiver {
        private final CdmDocumentService.GetStorageId_Response mCallback;

        CdmDocumentServiceGetStorageIdResponseParamsForwardToCallback(CdmDocumentService.GetStorageId_Response callback) {
            this.mCallback = callback;
        }

        @Override
        public boolean accept(org.chromium.mojo.bindings.Message message) {
            try {
                org.chromium.mojo.bindings.ServiceMessage messageWithHeader =
                        message.asServiceMessage();
                org.chromium.mojo.bindings.MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(GET_STORAGE_ID_ORDINAL,
                                           org.chromium.mojo.bindings.MessageHeader.MESSAGE_IS_RESPONSE_FLAG)) {
                    return false;
                }

                CdmDocumentServiceGetStorageIdResponseParams response = CdmDocumentServiceGetStorageIdResponseParams.deserialize(messageWithHeader.getPayload());

                mCallback.call(response.version, response.storageId);
                return true;
            } catch (org.chromium.mojo.bindings.DeserializationException e) {
                return false;
            }
        }
    }

    static class CdmDocumentServiceGetStorageIdResponseParamsProxyToResponder implements CdmDocumentService.GetStorageId_Response {

        private final org.chromium.mojo.system.Core mCore;
        private final org.chromium.mojo.bindings.MessageReceiver mMessageReceiver;
        private final long mRequestId;

        CdmDocumentServiceGetStorageIdResponseParamsProxyToResponder(
                org.chromium.mojo.system.Core core,
                org.chromium.mojo.bindings.MessageReceiver messageReceiver,
                long requestId) {
            mCore = core;
            mMessageReceiver = messageReceiver;
            mRequestId = requestId;
        }

        @Override
        public void call(Integer version, byte[] storageId) {
            CdmDocumentServiceGetStorageIdResponseParams _response = new CdmDocumentServiceGetStorageIdResponseParams();

            _response.version = version;

            _response.storageId = storageId;

            org.chromium.mojo.bindings.ServiceMessage _message =
                    _response.serializeWithHeader(
                            mCore,
                            new org.chromium.mojo.bindings.MessageHeader(
                                    GET_STORAGE_ID_ORDINAL,
                                    org.chromium.mojo.bindings.MessageHeader.MESSAGE_IS_RESPONSE_FLAG,
                                    mRequestId));
            mMessageReceiver.accept(_message);
        }
    }



}
