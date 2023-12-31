// DigitalGoodsFactory_Internal.java is auto generated by mojom_bindings_generator.py, do not edit


// Copyright 2014 The Chromium Authors
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.

// This file is autogenerated by:
//     mojo/public/tools/bindings/mojom_bindings_generator.py
// For:
//     third_party/blink/public/mojom/digital_goods/digital_goods.mojom
//

package org.chromium.payments.mojom;

import androidx.annotation.IntDef;


class DigitalGoodsFactory_Internal {

    public static final org.chromium.mojo.bindings.Interface.Manager<DigitalGoodsFactory, DigitalGoodsFactory.Proxy> MANAGER =
            new org.chromium.mojo.bindings.Interface.Manager<DigitalGoodsFactory, DigitalGoodsFactory.Proxy>() {

        @Override
        public String getName() {
            return "payments.mojom.DigitalGoodsFactory";
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
        public Stub buildStub(org.chromium.mojo.system.Core core, DigitalGoodsFactory impl) {
            return new Stub(core, impl);
        }

        @Override
        public DigitalGoodsFactory[] buildArray(int size) {
          return new DigitalGoodsFactory[size];
        }
    };


    private static final int CREATE_DIGITAL_GOODS_ORDINAL = 0;


    static final class Proxy extends org.chromium.mojo.bindings.Interface.AbstractProxy implements DigitalGoodsFactory.Proxy {

        Proxy(org.chromium.mojo.system.Core core,
              org.chromium.mojo.bindings.MessageReceiverWithResponder messageReceiver) {
            super(core, messageReceiver);
        }


        @Override
        public void createDigitalGoods(
String paymentMethod, 
CreateDigitalGoods_Response callback) {

            DigitalGoodsFactoryCreateDigitalGoodsParams _message = new DigitalGoodsFactoryCreateDigitalGoodsParams();

            _message.paymentMethod = paymentMethod;


            getProxyHandler().getMessageReceiver().acceptWithResponder(
                    _message.serializeWithHeader(
                            getProxyHandler().getCore(),
                            new org.chromium.mojo.bindings.MessageHeader(
                                    CREATE_DIGITAL_GOODS_ORDINAL,
                                    org.chromium.mojo.bindings.MessageHeader.MESSAGE_EXPECTS_RESPONSE_FLAG,
                                    0)),
                    new DigitalGoodsFactoryCreateDigitalGoodsResponseParamsForwardToCallback(callback));

        }


    }

    static final class Stub extends org.chromium.mojo.bindings.Interface.Stub<DigitalGoodsFactory> {

        Stub(org.chromium.mojo.system.Core core, DigitalGoodsFactory impl) {
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
                                DigitalGoodsFactory_Internal.MANAGER, messageWithHeader);




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
                                getCore(), DigitalGoodsFactory_Internal.MANAGER, messageWithHeader, receiver);







                    case CREATE_DIGITAL_GOODS_ORDINAL: {

                        DigitalGoodsFactoryCreateDigitalGoodsParams data =
                                DigitalGoodsFactoryCreateDigitalGoodsParams.deserialize(messageWithHeader.getPayload());

                        getImpl().createDigitalGoods(data.paymentMethod, new DigitalGoodsFactoryCreateDigitalGoodsResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
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


    
    static final class DigitalGoodsFactoryCreateDigitalGoodsParams extends org.chromium.mojo.bindings.Struct {

        private static final int STRUCT_SIZE = 16;
        private static final org.chromium.mojo.bindings.DataHeader[] VERSION_ARRAY = new org.chromium.mojo.bindings.DataHeader[] {new org.chromium.mojo.bindings.DataHeader(16, 0)};
        private static final org.chromium.mojo.bindings.DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public String paymentMethod;

        private DigitalGoodsFactoryCreateDigitalGoodsParams(int version) {
            super(STRUCT_SIZE, version);
        }

        public DigitalGoodsFactoryCreateDigitalGoodsParams() {
            this(0);
        }

        public static DigitalGoodsFactoryCreateDigitalGoodsParams deserialize(org.chromium.mojo.bindings.Message message) {
            return decode(new org.chromium.mojo.bindings.Decoder(message));
        }

        /**
         * Similar to the method above, but deserializes from a |ByteBuffer| instance.
         *
         * @throws org.chromium.mojo.bindings.DeserializationException on deserialization failure.
         */
        public static DigitalGoodsFactoryCreateDigitalGoodsParams deserialize(java.nio.ByteBuffer data) {
            return deserialize(new org.chromium.mojo.bindings.Message(
                    data, new java.util.ArrayList<org.chromium.mojo.system.Handle>()));
        }

        @SuppressWarnings("unchecked")
        public static DigitalGoodsFactoryCreateDigitalGoodsParams decode(org.chromium.mojo.bindings.Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            DigitalGoodsFactoryCreateDigitalGoodsParams result;
            try {
                org.chromium.mojo.bindings.DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                final int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new DigitalGoodsFactoryCreateDigitalGoodsParams(elementsOrVersion);
                    {
                        
                    result.paymentMethod = decoder0.readString(8, false);
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
            
            encoder0.encode(this.paymentMethod, 8, false);
        }
    }



    
    static final class DigitalGoodsFactoryCreateDigitalGoodsResponseParams extends org.chromium.mojo.bindings.Struct {

        private static final int STRUCT_SIZE = 24;
        private static final org.chromium.mojo.bindings.DataHeader[] VERSION_ARRAY = new org.chromium.mojo.bindings.DataHeader[] {new org.chromium.mojo.bindings.DataHeader(24, 0)};
        private static final org.chromium.mojo.bindings.DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public int code;
        public DigitalGoods digitalGoods;

        private DigitalGoodsFactoryCreateDigitalGoodsResponseParams(int version) {
            super(STRUCT_SIZE, version);
        }

        public DigitalGoodsFactoryCreateDigitalGoodsResponseParams() {
            this(0);
        }

        public static DigitalGoodsFactoryCreateDigitalGoodsResponseParams deserialize(org.chromium.mojo.bindings.Message message) {
            return decode(new org.chromium.mojo.bindings.Decoder(message));
        }

        /**
         * Similar to the method above, but deserializes from a |ByteBuffer| instance.
         *
         * @throws org.chromium.mojo.bindings.DeserializationException on deserialization failure.
         */
        public static DigitalGoodsFactoryCreateDigitalGoodsResponseParams deserialize(java.nio.ByteBuffer data) {
            return deserialize(new org.chromium.mojo.bindings.Message(
                    data, new java.util.ArrayList<org.chromium.mojo.system.Handle>()));
        }

        @SuppressWarnings("unchecked")
        public static DigitalGoodsFactoryCreateDigitalGoodsResponseParams decode(org.chromium.mojo.bindings.Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            DigitalGoodsFactoryCreateDigitalGoodsResponseParams result;
            try {
                org.chromium.mojo.bindings.DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                final int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new DigitalGoodsFactoryCreateDigitalGoodsResponseParams(elementsOrVersion);
                    {
                        
                    result.code = decoder0.readInt(8);
                        CreateDigitalGoodsResponseCode.validate(result.code);
                        result.code = CreateDigitalGoodsResponseCode.toKnownValue(result.code);
                    }
                    {
                        
                    result.digitalGoods = decoder0.readServiceInterface(12, true, DigitalGoods.MANAGER);
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
            
            encoder0.encode(this.code, 8);
            
            encoder0.encode(this.digitalGoods, 12, true, DigitalGoods.MANAGER);
        }
    }

    static class DigitalGoodsFactoryCreateDigitalGoodsResponseParamsForwardToCallback extends org.chromium.mojo.bindings.SideEffectFreeCloseable
            implements org.chromium.mojo.bindings.MessageReceiver {
        private final DigitalGoodsFactory.CreateDigitalGoods_Response mCallback;

        DigitalGoodsFactoryCreateDigitalGoodsResponseParamsForwardToCallback(DigitalGoodsFactory.CreateDigitalGoods_Response callback) {
            this.mCallback = callback;
        }

        @Override
        public boolean accept(org.chromium.mojo.bindings.Message message) {
            try {
                org.chromium.mojo.bindings.ServiceMessage messageWithHeader =
                        message.asServiceMessage();
                org.chromium.mojo.bindings.MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(CREATE_DIGITAL_GOODS_ORDINAL,
                                           org.chromium.mojo.bindings.MessageHeader.MESSAGE_IS_RESPONSE_FLAG)) {
                    return false;
                }

                DigitalGoodsFactoryCreateDigitalGoodsResponseParams response = DigitalGoodsFactoryCreateDigitalGoodsResponseParams.deserialize(messageWithHeader.getPayload());

                mCallback.call(response.code, response.digitalGoods);
                return true;
            } catch (org.chromium.mojo.bindings.DeserializationException e) {
                return false;
            }
        }
    }

    static class DigitalGoodsFactoryCreateDigitalGoodsResponseParamsProxyToResponder implements DigitalGoodsFactory.CreateDigitalGoods_Response {

        private final org.chromium.mojo.system.Core mCore;
        private final org.chromium.mojo.bindings.MessageReceiver mMessageReceiver;
        private final long mRequestId;

        DigitalGoodsFactoryCreateDigitalGoodsResponseParamsProxyToResponder(
                org.chromium.mojo.system.Core core,
                org.chromium.mojo.bindings.MessageReceiver messageReceiver,
                long requestId) {
            mCore = core;
            mMessageReceiver = messageReceiver;
            mRequestId = requestId;
        }

        @Override
        public void call(Integer code, DigitalGoods digitalGoods) {
            DigitalGoodsFactoryCreateDigitalGoodsResponseParams _response = new DigitalGoodsFactoryCreateDigitalGoodsResponseParams();

            _response.code = code;

            _response.digitalGoods = digitalGoods;

            org.chromium.mojo.bindings.ServiceMessage _message =
                    _response.serializeWithHeader(
                            mCore,
                            new org.chromium.mojo.bindings.MessageHeader(
                                    CREATE_DIGITAL_GOODS_ORDINAL,
                                    org.chromium.mojo.bindings.MessageHeader.MESSAGE_IS_RESPONSE_FLAG,
                                    mRequestId));
            mMessageReceiver.accept(_message);
        }
    }



}
