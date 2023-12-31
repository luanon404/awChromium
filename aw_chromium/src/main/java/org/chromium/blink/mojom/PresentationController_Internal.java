// PresentationController_Internal.java is auto generated by mojom_bindings_generator.py, do not edit


// Copyright 2014 The Chromium Authors
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.

// This file is autogenerated by:
//     mojo/public/tools/bindings/mojom_bindings_generator.py
// For:
//     third_party/blink/public/mojom/presentation/presentation.mojom
//

package org.chromium.blink.mojom;

import androidx.annotation.IntDef;


class PresentationController_Internal {

    public static final org.chromium.mojo.bindings.Interface.Manager<PresentationController, PresentationController.Proxy> MANAGER =
            new org.chromium.mojo.bindings.Interface.Manager<PresentationController, PresentationController.Proxy>() {

        @Override
        public String getName() {
            return "blink.mojom.PresentationController";
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
        public Stub buildStub(org.chromium.mojo.system.Core core, PresentationController impl) {
            return new Stub(core, impl);
        }

        @Override
        public PresentationController[] buildArray(int size) {
          return new PresentationController[size];
        }
    };


    private static final int ON_SCREEN_AVAILABILITY_UPDATED_ORDINAL = 0;

    private static final int ON_DEFAULT_PRESENTATION_STARTED_ORDINAL = 1;

    private static final int ON_CONNECTION_STATE_CHANGED_ORDINAL = 2;

    private static final int ON_CONNECTION_CLOSED_ORDINAL = 3;


    static final class Proxy extends org.chromium.mojo.bindings.Interface.AbstractProxy implements PresentationController.Proxy {

        Proxy(org.chromium.mojo.system.Core core,
              org.chromium.mojo.bindings.MessageReceiverWithResponder messageReceiver) {
            super(core, messageReceiver);
        }


        @Override
        public void onScreenAvailabilityUpdated(
org.chromium.url.mojom.Url url, int availability) {

            PresentationControllerOnScreenAvailabilityUpdatedParams _message = new PresentationControllerOnScreenAvailabilityUpdatedParams();

            _message.url = url;

            _message.availability = availability;


            getProxyHandler().getMessageReceiver().accept(
                    _message.serializeWithHeader(
                            getProxyHandler().getCore(),
                            new org.chromium.mojo.bindings.MessageHeader(ON_SCREEN_AVAILABILITY_UPDATED_ORDINAL)));

        }


        @Override
        public void onDefaultPresentationStarted(
PresentationConnectionResult result) {

            PresentationControllerOnDefaultPresentationStartedParams _message = new PresentationControllerOnDefaultPresentationStartedParams();

            _message.result = result;


            getProxyHandler().getMessageReceiver().accept(
                    _message.serializeWithHeader(
                            getProxyHandler().getCore(),
                            new org.chromium.mojo.bindings.MessageHeader(ON_DEFAULT_PRESENTATION_STARTED_ORDINAL)));

        }


        @Override
        public void onConnectionStateChanged(
PresentationInfo presentationInfo, int newState) {

            PresentationControllerOnConnectionStateChangedParams _message = new PresentationControllerOnConnectionStateChangedParams();

            _message.presentationInfo = presentationInfo;

            _message.newState = newState;


            getProxyHandler().getMessageReceiver().accept(
                    _message.serializeWithHeader(
                            getProxyHandler().getCore(),
                            new org.chromium.mojo.bindings.MessageHeader(ON_CONNECTION_STATE_CHANGED_ORDINAL)));

        }


        @Override
        public void onConnectionClosed(
PresentationInfo presentationInfo, int reason, String message) {

            PresentationControllerOnConnectionClosedParams _message = new PresentationControllerOnConnectionClosedParams();

            _message.presentationInfo = presentationInfo;

            _message.reason = reason;

            _message.message = message;


            getProxyHandler().getMessageReceiver().accept(
                    _message.serializeWithHeader(
                            getProxyHandler().getCore(),
                            new org.chromium.mojo.bindings.MessageHeader(ON_CONNECTION_CLOSED_ORDINAL)));

        }


    }

    static final class Stub extends org.chromium.mojo.bindings.Interface.Stub<PresentationController> {

        Stub(org.chromium.mojo.system.Core core, PresentationController impl) {
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
                                PresentationController_Internal.MANAGER, messageWithHeader);





                    case ON_SCREEN_AVAILABILITY_UPDATED_ORDINAL: {

                        PresentationControllerOnScreenAvailabilityUpdatedParams data =
                                PresentationControllerOnScreenAvailabilityUpdatedParams.deserialize(messageWithHeader.getPayload());

                        getImpl().onScreenAvailabilityUpdated(data.url, data.availability);
                        return true;
                    }





                    case ON_DEFAULT_PRESENTATION_STARTED_ORDINAL: {

                        PresentationControllerOnDefaultPresentationStartedParams data =
                                PresentationControllerOnDefaultPresentationStartedParams.deserialize(messageWithHeader.getPayload());

                        getImpl().onDefaultPresentationStarted(data.result);
                        return true;
                    }





                    case ON_CONNECTION_STATE_CHANGED_ORDINAL: {

                        PresentationControllerOnConnectionStateChangedParams data =
                                PresentationControllerOnConnectionStateChangedParams.deserialize(messageWithHeader.getPayload());

                        getImpl().onConnectionStateChanged(data.presentationInfo, data.newState);
                        return true;
                    }





                    case ON_CONNECTION_CLOSED_ORDINAL: {

                        PresentationControllerOnConnectionClosedParams data =
                                PresentationControllerOnConnectionClosedParams.deserialize(messageWithHeader.getPayload());

                        getImpl().onConnectionClosed(data.presentationInfo, data.reason, data.message);
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
                                getCore(), PresentationController_Internal.MANAGER, messageWithHeader, receiver);










                    default:
                        return false;
                }
            } catch (org.chromium.mojo.bindings.DeserializationException e) {
                System.err.println(e.toString());
                return false;
            }
        }
    }


    
    static final class PresentationControllerOnScreenAvailabilityUpdatedParams extends org.chromium.mojo.bindings.Struct {

        private static final int STRUCT_SIZE = 24;
        private static final org.chromium.mojo.bindings.DataHeader[] VERSION_ARRAY = new org.chromium.mojo.bindings.DataHeader[] {new org.chromium.mojo.bindings.DataHeader(24, 0)};
        private static final org.chromium.mojo.bindings.DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public org.chromium.url.mojom.Url url;
        public int availability;

        private PresentationControllerOnScreenAvailabilityUpdatedParams(int version) {
            super(STRUCT_SIZE, version);
        }

        public PresentationControllerOnScreenAvailabilityUpdatedParams() {
            this(0);
        }

        public static PresentationControllerOnScreenAvailabilityUpdatedParams deserialize(org.chromium.mojo.bindings.Message message) {
            return decode(new org.chromium.mojo.bindings.Decoder(message));
        }

        /**
         * Similar to the method above, but deserializes from a |ByteBuffer| instance.
         *
         * @throws org.chromium.mojo.bindings.DeserializationException on deserialization failure.
         */
        public static PresentationControllerOnScreenAvailabilityUpdatedParams deserialize(java.nio.ByteBuffer data) {
            return deserialize(new org.chromium.mojo.bindings.Message(
                    data, new java.util.ArrayList<org.chromium.mojo.system.Handle>()));
        }

        @SuppressWarnings("unchecked")
        public static PresentationControllerOnScreenAvailabilityUpdatedParams decode(org.chromium.mojo.bindings.Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            PresentationControllerOnScreenAvailabilityUpdatedParams result;
            try {
                org.chromium.mojo.bindings.DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                final int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new PresentationControllerOnScreenAvailabilityUpdatedParams(elementsOrVersion);
                    {
                        
                    org.chromium.mojo.bindings.Decoder decoder1 = decoder0.readPointer(8, false);
                    result.url = org.chromium.url.mojom.Url.decode(decoder1);
                    }
                    {
                        
                    result.availability = decoder0.readInt(16);
                        ScreenAvailability.validate(result.availability);
                        result.availability = ScreenAvailability.toKnownValue(result.availability);
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
            
            encoder0.encode(this.url, 8, false);
            
            encoder0.encode(this.availability, 16);
        }
    }



    
    static final class PresentationControllerOnDefaultPresentationStartedParams extends org.chromium.mojo.bindings.Struct {

        private static final int STRUCT_SIZE = 16;
        private static final org.chromium.mojo.bindings.DataHeader[] VERSION_ARRAY = new org.chromium.mojo.bindings.DataHeader[] {new org.chromium.mojo.bindings.DataHeader(16, 0)};
        private static final org.chromium.mojo.bindings.DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public PresentationConnectionResult result;

        private PresentationControllerOnDefaultPresentationStartedParams(int version) {
            super(STRUCT_SIZE, version);
        }

        public PresentationControllerOnDefaultPresentationStartedParams() {
            this(0);
        }

        public static PresentationControllerOnDefaultPresentationStartedParams deserialize(org.chromium.mojo.bindings.Message message) {
            return decode(new org.chromium.mojo.bindings.Decoder(message));
        }

        /**
         * Similar to the method above, but deserializes from a |ByteBuffer| instance.
         *
         * @throws org.chromium.mojo.bindings.DeserializationException on deserialization failure.
         */
        public static PresentationControllerOnDefaultPresentationStartedParams deserialize(java.nio.ByteBuffer data) {
            return deserialize(new org.chromium.mojo.bindings.Message(
                    data, new java.util.ArrayList<org.chromium.mojo.system.Handle>()));
        }

        @SuppressWarnings("unchecked")
        public static PresentationControllerOnDefaultPresentationStartedParams decode(org.chromium.mojo.bindings.Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            PresentationControllerOnDefaultPresentationStartedParams result;
            try {
                org.chromium.mojo.bindings.DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                final int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new PresentationControllerOnDefaultPresentationStartedParams(elementsOrVersion);
                    {
                        
                    org.chromium.mojo.bindings.Decoder decoder1 = decoder0.readPointer(8, false);
                    result.result = PresentationConnectionResult.decode(decoder1);
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
            
            encoder0.encode(this.result, 8, false);
        }
    }



    
    static final class PresentationControllerOnConnectionStateChangedParams extends org.chromium.mojo.bindings.Struct {

        private static final int STRUCT_SIZE = 24;
        private static final org.chromium.mojo.bindings.DataHeader[] VERSION_ARRAY = new org.chromium.mojo.bindings.DataHeader[] {new org.chromium.mojo.bindings.DataHeader(24, 0)};
        private static final org.chromium.mojo.bindings.DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public PresentationInfo presentationInfo;
        public int newState;

        private PresentationControllerOnConnectionStateChangedParams(int version) {
            super(STRUCT_SIZE, version);
        }

        public PresentationControllerOnConnectionStateChangedParams() {
            this(0);
        }

        public static PresentationControllerOnConnectionStateChangedParams deserialize(org.chromium.mojo.bindings.Message message) {
            return decode(new org.chromium.mojo.bindings.Decoder(message));
        }

        /**
         * Similar to the method above, but deserializes from a |ByteBuffer| instance.
         *
         * @throws org.chromium.mojo.bindings.DeserializationException on deserialization failure.
         */
        public static PresentationControllerOnConnectionStateChangedParams deserialize(java.nio.ByteBuffer data) {
            return deserialize(new org.chromium.mojo.bindings.Message(
                    data, new java.util.ArrayList<org.chromium.mojo.system.Handle>()));
        }

        @SuppressWarnings("unchecked")
        public static PresentationControllerOnConnectionStateChangedParams decode(org.chromium.mojo.bindings.Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            PresentationControllerOnConnectionStateChangedParams result;
            try {
                org.chromium.mojo.bindings.DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                final int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new PresentationControllerOnConnectionStateChangedParams(elementsOrVersion);
                    {
                        
                    org.chromium.mojo.bindings.Decoder decoder1 = decoder0.readPointer(8, false);
                    result.presentationInfo = PresentationInfo.decode(decoder1);
                    }
                    {
                        
                    result.newState = decoder0.readInt(16);
                        PresentationConnectionState.validate(result.newState);
                        result.newState = PresentationConnectionState.toKnownValue(result.newState);
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
            
            encoder0.encode(this.presentationInfo, 8, false);
            
            encoder0.encode(this.newState, 16);
        }
    }



    
    static final class PresentationControllerOnConnectionClosedParams extends org.chromium.mojo.bindings.Struct {

        private static final int STRUCT_SIZE = 32;
        private static final org.chromium.mojo.bindings.DataHeader[] VERSION_ARRAY = new org.chromium.mojo.bindings.DataHeader[] {new org.chromium.mojo.bindings.DataHeader(32, 0)};
        private static final org.chromium.mojo.bindings.DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public PresentationInfo presentationInfo;
        public int reason;
        public String message;

        private PresentationControllerOnConnectionClosedParams(int version) {
            super(STRUCT_SIZE, version);
        }

        public PresentationControllerOnConnectionClosedParams() {
            this(0);
        }

        public static PresentationControllerOnConnectionClosedParams deserialize(org.chromium.mojo.bindings.Message message) {
            return decode(new org.chromium.mojo.bindings.Decoder(message));
        }

        /**
         * Similar to the method above, but deserializes from a |ByteBuffer| instance.
         *
         * @throws org.chromium.mojo.bindings.DeserializationException on deserialization failure.
         */
        public static PresentationControllerOnConnectionClosedParams deserialize(java.nio.ByteBuffer data) {
            return deserialize(new org.chromium.mojo.bindings.Message(
                    data, new java.util.ArrayList<org.chromium.mojo.system.Handle>()));
        }

        @SuppressWarnings("unchecked")
        public static PresentationControllerOnConnectionClosedParams decode(org.chromium.mojo.bindings.Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            PresentationControllerOnConnectionClosedParams result;
            try {
                org.chromium.mojo.bindings.DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                final int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new PresentationControllerOnConnectionClosedParams(elementsOrVersion);
                    {
                        
                    org.chromium.mojo.bindings.Decoder decoder1 = decoder0.readPointer(8, false);
                    result.presentationInfo = PresentationInfo.decode(decoder1);
                    }
                    {
                        
                    result.reason = decoder0.readInt(16);
                        PresentationConnectionCloseReason.validate(result.reason);
                        result.reason = PresentationConnectionCloseReason.toKnownValue(result.reason);
                    }
                    {
                        
                    result.message = decoder0.readString(24, false);
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
            
            encoder0.encode(this.presentationInfo, 8, false);
            
            encoder0.encode(this.reason, 16);
            
            encoder0.encode(this.message, 24, false);
        }
    }



}
