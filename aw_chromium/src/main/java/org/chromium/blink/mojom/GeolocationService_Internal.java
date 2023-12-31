// GeolocationService_Internal.java is auto generated by mojom_bindings_generator.py, do not edit


// Copyright 2014 The Chromium Authors
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.

// This file is autogenerated by:
//     mojo/public/tools/bindings/mojom_bindings_generator.py
// For:
//     third_party/blink/public/mojom/geolocation/geolocation_service.mojom
//

package org.chromium.blink.mojom;

import androidx.annotation.IntDef;


class GeolocationService_Internal {

    public static final org.chromium.mojo.bindings.Interface.Manager<GeolocationService, GeolocationService.Proxy> MANAGER =
            new org.chromium.mojo.bindings.Interface.Manager<GeolocationService, GeolocationService.Proxy>() {

        @Override
        public String getName() {
            return "blink.mojom.GeolocationService";
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
        public Stub buildStub(org.chromium.mojo.system.Core core, GeolocationService impl) {
            return new Stub(core, impl);
        }

        @Override
        public GeolocationService[] buildArray(int size) {
          return new GeolocationService[size];
        }
    };


    private static final int CREATE_GEOLOCATION_ORDINAL = 0;


    static final class Proxy extends org.chromium.mojo.bindings.Interface.AbstractProxy implements GeolocationService.Proxy {

        Proxy(org.chromium.mojo.system.Core core,
              org.chromium.mojo.bindings.MessageReceiverWithResponder messageReceiver) {
            super(core, messageReceiver);
        }


        @Override
        public void createGeolocation(
org.chromium.mojo.bindings.InterfaceRequest<org.chromium.device.mojom.Geolocation> receiver, boolean userGesture, 
CreateGeolocation_Response callback) {

            GeolocationServiceCreateGeolocationParams _message = new GeolocationServiceCreateGeolocationParams();

            _message.receiver = receiver;

            _message.userGesture = userGesture;


            getProxyHandler().getMessageReceiver().acceptWithResponder(
                    _message.serializeWithHeader(
                            getProxyHandler().getCore(),
                            new org.chromium.mojo.bindings.MessageHeader(
                                    CREATE_GEOLOCATION_ORDINAL,
                                    org.chromium.mojo.bindings.MessageHeader.MESSAGE_EXPECTS_RESPONSE_FLAG,
                                    0)),
                    new GeolocationServiceCreateGeolocationResponseParamsForwardToCallback(callback));

        }


    }

    static final class Stub extends org.chromium.mojo.bindings.Interface.Stub<GeolocationService> {

        Stub(org.chromium.mojo.system.Core core, GeolocationService impl) {
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
                                GeolocationService_Internal.MANAGER, messageWithHeader);




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
                                getCore(), GeolocationService_Internal.MANAGER, messageWithHeader, receiver);







                    case CREATE_GEOLOCATION_ORDINAL: {

                        GeolocationServiceCreateGeolocationParams data =
                                GeolocationServiceCreateGeolocationParams.deserialize(messageWithHeader.getPayload());

                        getImpl().createGeolocation(data.receiver, data.userGesture, new GeolocationServiceCreateGeolocationResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
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


    
    static final class GeolocationServiceCreateGeolocationParams extends org.chromium.mojo.bindings.Struct {

        private static final int STRUCT_SIZE = 16;
        private static final org.chromium.mojo.bindings.DataHeader[] VERSION_ARRAY = new org.chromium.mojo.bindings.DataHeader[] {new org.chromium.mojo.bindings.DataHeader(16, 0)};
        private static final org.chromium.mojo.bindings.DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public org.chromium.mojo.bindings.InterfaceRequest<org.chromium.device.mojom.Geolocation> receiver;
        public boolean userGesture;

        private GeolocationServiceCreateGeolocationParams(int version) {
            super(STRUCT_SIZE, version);
        }

        public GeolocationServiceCreateGeolocationParams() {
            this(0);
        }

        public static GeolocationServiceCreateGeolocationParams deserialize(org.chromium.mojo.bindings.Message message) {
            return decode(new org.chromium.mojo.bindings.Decoder(message));
        }

        /**
         * Similar to the method above, but deserializes from a |ByteBuffer| instance.
         *
         * @throws org.chromium.mojo.bindings.DeserializationException on deserialization failure.
         */
        public static GeolocationServiceCreateGeolocationParams deserialize(java.nio.ByteBuffer data) {
            return deserialize(new org.chromium.mojo.bindings.Message(
                    data, new java.util.ArrayList<org.chromium.mojo.system.Handle>()));
        }

        @SuppressWarnings("unchecked")
        public static GeolocationServiceCreateGeolocationParams decode(org.chromium.mojo.bindings.Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            GeolocationServiceCreateGeolocationParams result;
            try {
                org.chromium.mojo.bindings.DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                final int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new GeolocationServiceCreateGeolocationParams(elementsOrVersion);
                    {
                        
                    result.receiver = decoder0.readInterfaceRequest(8, false);
                    }
                    {
                        
                    result.userGesture = decoder0.readBoolean(12, 0);
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
            
            encoder0.encode(this.userGesture, 12, 0);
        }
    }



    
    static final class GeolocationServiceCreateGeolocationResponseParams extends org.chromium.mojo.bindings.Struct {

        private static final int STRUCT_SIZE = 16;
        private static final org.chromium.mojo.bindings.DataHeader[] VERSION_ARRAY = new org.chromium.mojo.bindings.DataHeader[] {new org.chromium.mojo.bindings.DataHeader(16, 0)};
        private static final org.chromium.mojo.bindings.DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public int status;

        private GeolocationServiceCreateGeolocationResponseParams(int version) {
            super(STRUCT_SIZE, version);
        }

        public GeolocationServiceCreateGeolocationResponseParams() {
            this(0);
        }

        public static GeolocationServiceCreateGeolocationResponseParams deserialize(org.chromium.mojo.bindings.Message message) {
            return decode(new org.chromium.mojo.bindings.Decoder(message));
        }

        /**
         * Similar to the method above, but deserializes from a |ByteBuffer| instance.
         *
         * @throws org.chromium.mojo.bindings.DeserializationException on deserialization failure.
         */
        public static GeolocationServiceCreateGeolocationResponseParams deserialize(java.nio.ByteBuffer data) {
            return deserialize(new org.chromium.mojo.bindings.Message(
                    data, new java.util.ArrayList<org.chromium.mojo.system.Handle>()));
        }

        @SuppressWarnings("unchecked")
        public static GeolocationServiceCreateGeolocationResponseParams decode(org.chromium.mojo.bindings.Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            GeolocationServiceCreateGeolocationResponseParams result;
            try {
                org.chromium.mojo.bindings.DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                final int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new GeolocationServiceCreateGeolocationResponseParams(elementsOrVersion);
                    {
                        
                    result.status = decoder0.readInt(8);
                        PermissionStatus.validate(result.status);
                        result.status = PermissionStatus.toKnownValue(result.status);
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
            
            encoder0.encode(this.status, 8);
        }
    }

    static class GeolocationServiceCreateGeolocationResponseParamsForwardToCallback extends org.chromium.mojo.bindings.SideEffectFreeCloseable
            implements org.chromium.mojo.bindings.MessageReceiver {
        private final GeolocationService.CreateGeolocation_Response mCallback;

        GeolocationServiceCreateGeolocationResponseParamsForwardToCallback(GeolocationService.CreateGeolocation_Response callback) {
            this.mCallback = callback;
        }

        @Override
        public boolean accept(org.chromium.mojo.bindings.Message message) {
            try {
                org.chromium.mojo.bindings.ServiceMessage messageWithHeader =
                        message.asServiceMessage();
                org.chromium.mojo.bindings.MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(CREATE_GEOLOCATION_ORDINAL,
                                           org.chromium.mojo.bindings.MessageHeader.MESSAGE_IS_RESPONSE_FLAG)) {
                    return false;
                }

                GeolocationServiceCreateGeolocationResponseParams response = GeolocationServiceCreateGeolocationResponseParams.deserialize(messageWithHeader.getPayload());

                mCallback.call(response.status);
                return true;
            } catch (org.chromium.mojo.bindings.DeserializationException e) {
                return false;
            }
        }
    }

    static class GeolocationServiceCreateGeolocationResponseParamsProxyToResponder implements GeolocationService.CreateGeolocation_Response {

        private final org.chromium.mojo.system.Core mCore;
        private final org.chromium.mojo.bindings.MessageReceiver mMessageReceiver;
        private final long mRequestId;

        GeolocationServiceCreateGeolocationResponseParamsProxyToResponder(
                org.chromium.mojo.system.Core core,
                org.chromium.mojo.bindings.MessageReceiver messageReceiver,
                long requestId) {
            mCore = core;
            mMessageReceiver = messageReceiver;
            mRequestId = requestId;
        }

        @Override
        public void call(Integer status) {
            GeolocationServiceCreateGeolocationResponseParams _response = new GeolocationServiceCreateGeolocationResponseParams();

            _response.status = status;

            org.chromium.mojo.bindings.ServiceMessage _message =
                    _response.serializeWithHeader(
                            mCore,
                            new org.chromium.mojo.bindings.MessageHeader(
                                    CREATE_GEOLOCATION_ORDINAL,
                                    org.chromium.mojo.bindings.MessageHeader.MESSAGE_IS_RESPONSE_FLAG,
                                    mRequestId));
            mMessageReceiver.accept(_message);
        }
    }



}
