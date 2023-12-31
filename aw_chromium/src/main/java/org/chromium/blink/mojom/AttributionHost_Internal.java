// AttributionHost_Internal.java is auto generated by mojom_bindings_generator.py, do not edit


// Copyright 2014 The Chromium Authors
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.

// This file is autogenerated by:
//     mojo/public/tools/bindings/mojom_bindings_generator.py
// For:
//     third_party/blink/public/mojom/conversions/conversions.mojom
//

package org.chromium.blink.mojom;

import androidx.annotation.IntDef;


class AttributionHost_Internal {

    public static final org.chromium.mojo.bindings.Interface.Manager<AttributionHost, AttributionHost.Proxy> MANAGER =
            new org.chromium.mojo.bindings.Interface.Manager<AttributionHost, AttributionHost.Proxy>() {

        @Override
        public String getName() {
            return "blink.mojom.AttributionHost";
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
        public Stub buildStub(org.chromium.mojo.system.Core core, AttributionHost impl) {
            return new Stub(core, impl);
        }

        @Override
        public AttributionHost[] buildArray(int size) {
          return new AttributionHost[size];
        }
    };


    private static final int REGISTER_DATA_HOST_ORDINAL = 0;

    private static final int REGISTER_NAVIGATION_DATA_HOST_ORDINAL = 1;


    static final class Proxy extends org.chromium.mojo.bindings.Interface.AbstractProxy implements AttributionHost.Proxy {

        Proxy(org.chromium.mojo.system.Core core,
              org.chromium.mojo.bindings.MessageReceiverWithResponder messageReceiver) {
            super(core, messageReceiver);
        }


        @Override
        public void registerDataHost(
org.chromium.mojo.bindings.InterfaceRequest<AttributionDataHost> dataHost, int registrationEligibility) {

            AttributionHostRegisterDataHostParams _message = new AttributionHostRegisterDataHostParams();

            _message.dataHost = dataHost;

            _message.registrationEligibility = registrationEligibility;


            getProxyHandler().getMessageReceiver().accept(
                    _message.serializeWithHeader(
                            getProxyHandler().getCore(),
                            new org.chromium.mojo.bindings.MessageHeader(REGISTER_DATA_HOST_ORDINAL)));

        }


        @Override
        public void registerNavigationDataHost(
org.chromium.mojo.bindings.InterfaceRequest<AttributionDataHost> dataHost, AttributionSrcToken attributionSrcToken) {

            AttributionHostRegisterNavigationDataHostParams _message = new AttributionHostRegisterNavigationDataHostParams();

            _message.dataHost = dataHost;

            _message.attributionSrcToken = attributionSrcToken;


            getProxyHandler().getMessageReceiver().accept(
                    _message.serializeWithHeader(
                            getProxyHandler().getCore(),
                            new org.chromium.mojo.bindings.MessageHeader(REGISTER_NAVIGATION_DATA_HOST_ORDINAL)));

        }


    }

    static final class Stub extends org.chromium.mojo.bindings.Interface.Stub<AttributionHost> {

        Stub(org.chromium.mojo.system.Core core, AttributionHost impl) {
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
                                AttributionHost_Internal.MANAGER, messageWithHeader);





                    case REGISTER_DATA_HOST_ORDINAL: {

                        AttributionHostRegisterDataHostParams data =
                                AttributionHostRegisterDataHostParams.deserialize(messageWithHeader.getPayload());

                        getImpl().registerDataHost(data.dataHost, data.registrationEligibility);
                        return true;
                    }





                    case REGISTER_NAVIGATION_DATA_HOST_ORDINAL: {

                        AttributionHostRegisterNavigationDataHostParams data =
                                AttributionHostRegisterNavigationDataHostParams.deserialize(messageWithHeader.getPayload());

                        getImpl().registerNavigationDataHost(data.dataHost, data.attributionSrcToken);
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
                                getCore(), AttributionHost_Internal.MANAGER, messageWithHeader, receiver);






                    default:
                        return false;
                }
            } catch (org.chromium.mojo.bindings.DeserializationException e) {
                System.err.println(e.toString());
                return false;
            }
        }
    }


    
    static final class AttributionHostRegisterDataHostParams extends org.chromium.mojo.bindings.Struct {

        private static final int STRUCT_SIZE = 16;
        private static final org.chromium.mojo.bindings.DataHeader[] VERSION_ARRAY = new org.chromium.mojo.bindings.DataHeader[] {new org.chromium.mojo.bindings.DataHeader(16, 0)};
        private static final org.chromium.mojo.bindings.DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public org.chromium.mojo.bindings.InterfaceRequest<AttributionDataHost> dataHost;
        public int registrationEligibility;

        private AttributionHostRegisterDataHostParams(int version) {
            super(STRUCT_SIZE, version);
        }

        public AttributionHostRegisterDataHostParams() {
            this(0);
        }

        public static AttributionHostRegisterDataHostParams deserialize(org.chromium.mojo.bindings.Message message) {
            return decode(new org.chromium.mojo.bindings.Decoder(message));
        }

        /**
         * Similar to the method above, but deserializes from a |ByteBuffer| instance.
         *
         * @throws org.chromium.mojo.bindings.DeserializationException on deserialization failure.
         */
        public static AttributionHostRegisterDataHostParams deserialize(java.nio.ByteBuffer data) {
            return deserialize(new org.chromium.mojo.bindings.Message(
                    data, new java.util.ArrayList<org.chromium.mojo.system.Handle>()));
        }

        @SuppressWarnings("unchecked")
        public static AttributionHostRegisterDataHostParams decode(org.chromium.mojo.bindings.Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            AttributionHostRegisterDataHostParams result;
            try {
                org.chromium.mojo.bindings.DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                final int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new AttributionHostRegisterDataHostParams(elementsOrVersion);
                    {
                        
                    result.dataHost = decoder0.readInterfaceRequest(8, false);
                    }
                    {
                        
                    result.registrationEligibility = decoder0.readInt(12);
                        org.chromium.attribution_reporting.mojom.RegistrationEligibility.validate(result.registrationEligibility);
                        result.registrationEligibility = org.chromium.attribution_reporting.mojom.RegistrationEligibility.toKnownValue(result.registrationEligibility);
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
            
            encoder0.encode(this.dataHost, 8, false);
            
            encoder0.encode(this.registrationEligibility, 12);
        }
    }



    
    static final class AttributionHostRegisterNavigationDataHostParams extends org.chromium.mojo.bindings.Struct {

        private static final int STRUCT_SIZE = 24;
        private static final org.chromium.mojo.bindings.DataHeader[] VERSION_ARRAY = new org.chromium.mojo.bindings.DataHeader[] {new org.chromium.mojo.bindings.DataHeader(24, 0)};
        private static final org.chromium.mojo.bindings.DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public org.chromium.mojo.bindings.InterfaceRequest<AttributionDataHost> dataHost;
        public AttributionSrcToken attributionSrcToken;

        private AttributionHostRegisterNavigationDataHostParams(int version) {
            super(STRUCT_SIZE, version);
        }

        public AttributionHostRegisterNavigationDataHostParams() {
            this(0);
        }

        public static AttributionHostRegisterNavigationDataHostParams deserialize(org.chromium.mojo.bindings.Message message) {
            return decode(new org.chromium.mojo.bindings.Decoder(message));
        }

        /**
         * Similar to the method above, but deserializes from a |ByteBuffer| instance.
         *
         * @throws org.chromium.mojo.bindings.DeserializationException on deserialization failure.
         */
        public static AttributionHostRegisterNavigationDataHostParams deserialize(java.nio.ByteBuffer data) {
            return deserialize(new org.chromium.mojo.bindings.Message(
                    data, new java.util.ArrayList<org.chromium.mojo.system.Handle>()));
        }

        @SuppressWarnings("unchecked")
        public static AttributionHostRegisterNavigationDataHostParams decode(org.chromium.mojo.bindings.Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            AttributionHostRegisterNavigationDataHostParams result;
            try {
                org.chromium.mojo.bindings.DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                final int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new AttributionHostRegisterNavigationDataHostParams(elementsOrVersion);
                    {
                        
                    result.dataHost = decoder0.readInterfaceRequest(8, false);
                    }
                    {
                        
                    org.chromium.mojo.bindings.Decoder decoder1 = decoder0.readPointer(16, false);
                    result.attributionSrcToken = AttributionSrcToken.decode(decoder1);
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
            
            encoder0.encode(this.dataHost, 8, false);
            
            encoder0.encode(this.attributionSrcToken, 16, false);
        }
    }



}
