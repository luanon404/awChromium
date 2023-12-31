// AcceptChFrameObserver_Internal.java is auto generated by mojom_bindings_generator.py, do not edit


// Copyright 2014 The Chromium Authors
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.

// This file is autogenerated by:
//     mojo/public/tools/bindings/mojom_bindings_generator.py
// For:
//     services/network/public/mojom/accept_ch_frame_observer.mojom
//

package org.chromium.network.mojom;

import androidx.annotation.IntDef;


class AcceptChFrameObserver_Internal {

    public static final org.chromium.mojo.bindings.Interface.Manager<AcceptChFrameObserver, AcceptChFrameObserver.Proxy> MANAGER =
            new org.chromium.mojo.bindings.Interface.Manager<AcceptChFrameObserver, AcceptChFrameObserver.Proxy>() {

        @Override
        public String getName() {
            return "network.mojom.AcceptCHFrameObserver";
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
        public Stub buildStub(org.chromium.mojo.system.Core core, AcceptChFrameObserver impl) {
            return new Stub(core, impl);
        }

        @Override
        public AcceptChFrameObserver[] buildArray(int size) {
          return new AcceptChFrameObserver[size];
        }
    };


    private static final int ON_ACCEPT_CH_FRAME_RECEIVED_ORDINAL = 0;

    private static final int CLONE_ORDINAL = 1;


    static final class Proxy extends org.chromium.mojo.bindings.Interface.AbstractProxy implements AcceptChFrameObserver.Proxy {

        Proxy(org.chromium.mojo.system.Core core,
              org.chromium.mojo.bindings.MessageReceiverWithResponder messageReceiver) {
            super(core, messageReceiver);
        }


        @Override
        public void onAcceptChFrameReceived(
org.chromium.url.internal.mojom.Origin origin, int[] acceptChFrame, 
OnAcceptChFrameReceived_Response callback) {

            AcceptChFrameObserverOnAcceptChFrameReceivedParams _message = new AcceptChFrameObserverOnAcceptChFrameReceivedParams();

            _message.origin = origin;

            _message.acceptChFrame = acceptChFrame;


            getProxyHandler().getMessageReceiver().acceptWithResponder(
                    _message.serializeWithHeader(
                            getProxyHandler().getCore(),
                            new org.chromium.mojo.bindings.MessageHeader(
                                    ON_ACCEPT_CH_FRAME_RECEIVED_ORDINAL,
                                    org.chromium.mojo.bindings.MessageHeader.MESSAGE_EXPECTS_RESPONSE_FLAG,
                                    0)),
                    new AcceptChFrameObserverOnAcceptChFrameReceivedResponseParamsForwardToCallback(callback));

        }


        @Override
        public void clone(
org.chromium.mojo.bindings.InterfaceRequest<AcceptChFrameObserver> listener) {

            AcceptChFrameObserverCloneParams _message = new AcceptChFrameObserverCloneParams();

            _message.listener = listener;


            getProxyHandler().getMessageReceiver().accept(
                    _message.serializeWithHeader(
                            getProxyHandler().getCore(),
                            new org.chromium.mojo.bindings.MessageHeader(CLONE_ORDINAL)));

        }


    }

    static final class Stub extends org.chromium.mojo.bindings.Interface.Stub<AcceptChFrameObserver> {

        Stub(org.chromium.mojo.system.Core core, AcceptChFrameObserver impl) {
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
                                AcceptChFrameObserver_Internal.MANAGER, messageWithHeader);







                    case CLONE_ORDINAL: {

                        AcceptChFrameObserverCloneParams data =
                                AcceptChFrameObserverCloneParams.deserialize(messageWithHeader.getPayload());

                        getImpl().clone(data.listener);
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
                                getCore(), AcceptChFrameObserver_Internal.MANAGER, messageWithHeader, receiver);







                    case ON_ACCEPT_CH_FRAME_RECEIVED_ORDINAL: {

                        AcceptChFrameObserverOnAcceptChFrameReceivedParams data =
                                AcceptChFrameObserverOnAcceptChFrameReceivedParams.deserialize(messageWithHeader.getPayload());

                        getImpl().onAcceptChFrameReceived(data.origin, data.acceptChFrame, new AcceptChFrameObserverOnAcceptChFrameReceivedResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
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


    
    static final class AcceptChFrameObserverOnAcceptChFrameReceivedParams extends org.chromium.mojo.bindings.Struct {

        private static final int STRUCT_SIZE = 24;
        private static final org.chromium.mojo.bindings.DataHeader[] VERSION_ARRAY = new org.chromium.mojo.bindings.DataHeader[] {new org.chromium.mojo.bindings.DataHeader(24, 0)};
        private static final org.chromium.mojo.bindings.DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public org.chromium.url.internal.mojom.Origin origin;
        public int[] acceptChFrame;

        private AcceptChFrameObserverOnAcceptChFrameReceivedParams(int version) {
            super(STRUCT_SIZE, version);
        }

        public AcceptChFrameObserverOnAcceptChFrameReceivedParams() {
            this(0);
        }

        public static AcceptChFrameObserverOnAcceptChFrameReceivedParams deserialize(org.chromium.mojo.bindings.Message message) {
            return decode(new org.chromium.mojo.bindings.Decoder(message));
        }

        /**
         * Similar to the method above, but deserializes from a |ByteBuffer| instance.
         *
         * @throws org.chromium.mojo.bindings.DeserializationException on deserialization failure.
         */
        public static AcceptChFrameObserverOnAcceptChFrameReceivedParams deserialize(java.nio.ByteBuffer data) {
            return deserialize(new org.chromium.mojo.bindings.Message(
                    data, new java.util.ArrayList<org.chromium.mojo.system.Handle>()));
        }

        @SuppressWarnings("unchecked")
        public static AcceptChFrameObserverOnAcceptChFrameReceivedParams decode(org.chromium.mojo.bindings.Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            AcceptChFrameObserverOnAcceptChFrameReceivedParams result;
            try {
                org.chromium.mojo.bindings.DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                final int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new AcceptChFrameObserverOnAcceptChFrameReceivedParams(elementsOrVersion);
                    {
                        
                    org.chromium.mojo.bindings.Decoder decoder1 = decoder0.readPointer(8, false);
                    result.origin = org.chromium.url.internal.mojom.Origin.decode(decoder1);
                    }
                    {
                        
                    result.acceptChFrame = decoder0.readInts(16, org.chromium.mojo.bindings.BindingsHelper.NOTHING_NULLABLE, org.chromium.mojo.bindings.BindingsHelper.UNSPECIFIED_ARRAY_LENGTH);
                    {
                        for (int i1 = 0; i1 < result.acceptChFrame.length; ++i1) {
                            WebClientHintsType.validate(result.acceptChFrame[i1]);
                        }
                    }
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
            
            encoder0.encode(this.origin, 8, false);
            
            encoder0.encode(this.acceptChFrame, 16, org.chromium.mojo.bindings.BindingsHelper.NOTHING_NULLABLE, org.chromium.mojo.bindings.BindingsHelper.UNSPECIFIED_ARRAY_LENGTH);
        }
    }



    
    static final class AcceptChFrameObserverOnAcceptChFrameReceivedResponseParams extends org.chromium.mojo.bindings.Struct {

        private static final int STRUCT_SIZE = 16;
        private static final org.chromium.mojo.bindings.DataHeader[] VERSION_ARRAY = new org.chromium.mojo.bindings.DataHeader[] {new org.chromium.mojo.bindings.DataHeader(16, 0)};
        private static final org.chromium.mojo.bindings.DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public int status;

        private AcceptChFrameObserverOnAcceptChFrameReceivedResponseParams(int version) {
            super(STRUCT_SIZE, version);
        }

        public AcceptChFrameObserverOnAcceptChFrameReceivedResponseParams() {
            this(0);
        }

        public static AcceptChFrameObserverOnAcceptChFrameReceivedResponseParams deserialize(org.chromium.mojo.bindings.Message message) {
            return decode(new org.chromium.mojo.bindings.Decoder(message));
        }

        /**
         * Similar to the method above, but deserializes from a |ByteBuffer| instance.
         *
         * @throws org.chromium.mojo.bindings.DeserializationException on deserialization failure.
         */
        public static AcceptChFrameObserverOnAcceptChFrameReceivedResponseParams deserialize(java.nio.ByteBuffer data) {
            return deserialize(new org.chromium.mojo.bindings.Message(
                    data, new java.util.ArrayList<org.chromium.mojo.system.Handle>()));
        }

        @SuppressWarnings("unchecked")
        public static AcceptChFrameObserverOnAcceptChFrameReceivedResponseParams decode(org.chromium.mojo.bindings.Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            AcceptChFrameObserverOnAcceptChFrameReceivedResponseParams result;
            try {
                org.chromium.mojo.bindings.DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                final int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new AcceptChFrameObserverOnAcceptChFrameReceivedResponseParams(elementsOrVersion);
                    {
                        
                    result.status = decoder0.readInt(8);
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

    static class AcceptChFrameObserverOnAcceptChFrameReceivedResponseParamsForwardToCallback extends org.chromium.mojo.bindings.SideEffectFreeCloseable
            implements org.chromium.mojo.bindings.MessageReceiver {
        private final AcceptChFrameObserver.OnAcceptChFrameReceived_Response mCallback;

        AcceptChFrameObserverOnAcceptChFrameReceivedResponseParamsForwardToCallback(AcceptChFrameObserver.OnAcceptChFrameReceived_Response callback) {
            this.mCallback = callback;
        }

        @Override
        public boolean accept(org.chromium.mojo.bindings.Message message) {
            try {
                org.chromium.mojo.bindings.ServiceMessage messageWithHeader =
                        message.asServiceMessage();
                org.chromium.mojo.bindings.MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(ON_ACCEPT_CH_FRAME_RECEIVED_ORDINAL,
                                           org.chromium.mojo.bindings.MessageHeader.MESSAGE_IS_RESPONSE_FLAG)) {
                    return false;
                }

                AcceptChFrameObserverOnAcceptChFrameReceivedResponseParams response = AcceptChFrameObserverOnAcceptChFrameReceivedResponseParams.deserialize(messageWithHeader.getPayload());

                mCallback.call(response.status);
                return true;
            } catch (org.chromium.mojo.bindings.DeserializationException e) {
                return false;
            }
        }
    }

    static class AcceptChFrameObserverOnAcceptChFrameReceivedResponseParamsProxyToResponder implements AcceptChFrameObserver.OnAcceptChFrameReceived_Response {

        private final org.chromium.mojo.system.Core mCore;
        private final org.chromium.mojo.bindings.MessageReceiver mMessageReceiver;
        private final long mRequestId;

        AcceptChFrameObserverOnAcceptChFrameReceivedResponseParamsProxyToResponder(
                org.chromium.mojo.system.Core core,
                org.chromium.mojo.bindings.MessageReceiver messageReceiver,
                long requestId) {
            mCore = core;
            mMessageReceiver = messageReceiver;
            mRequestId = requestId;
        }

        @Override
        public void call(Integer status) {
            AcceptChFrameObserverOnAcceptChFrameReceivedResponseParams _response = new AcceptChFrameObserverOnAcceptChFrameReceivedResponseParams();

            _response.status = status;

            org.chromium.mojo.bindings.ServiceMessage _message =
                    _response.serializeWithHeader(
                            mCore,
                            new org.chromium.mojo.bindings.MessageHeader(
                                    ON_ACCEPT_CH_FRAME_RECEIVED_ORDINAL,
                                    org.chromium.mojo.bindings.MessageHeader.MESSAGE_IS_RESPONSE_FLAG,
                                    mRequestId));
            mMessageReceiver.accept(_message);
        }
    }



    
    static final class AcceptChFrameObserverCloneParams extends org.chromium.mojo.bindings.Struct {

        private static final int STRUCT_SIZE = 16;
        private static final org.chromium.mojo.bindings.DataHeader[] VERSION_ARRAY = new org.chromium.mojo.bindings.DataHeader[] {new org.chromium.mojo.bindings.DataHeader(16, 0)};
        private static final org.chromium.mojo.bindings.DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public org.chromium.mojo.bindings.InterfaceRequest<AcceptChFrameObserver> listener;

        private AcceptChFrameObserverCloneParams(int version) {
            super(STRUCT_SIZE, version);
        }

        public AcceptChFrameObserverCloneParams() {
            this(0);
        }

        public static AcceptChFrameObserverCloneParams deserialize(org.chromium.mojo.bindings.Message message) {
            return decode(new org.chromium.mojo.bindings.Decoder(message));
        }

        /**
         * Similar to the method above, but deserializes from a |ByteBuffer| instance.
         *
         * @throws org.chromium.mojo.bindings.DeserializationException on deserialization failure.
         */
        public static AcceptChFrameObserverCloneParams deserialize(java.nio.ByteBuffer data) {
            return deserialize(new org.chromium.mojo.bindings.Message(
                    data, new java.util.ArrayList<org.chromium.mojo.system.Handle>()));
        }

        @SuppressWarnings("unchecked")
        public static AcceptChFrameObserverCloneParams decode(org.chromium.mojo.bindings.Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            AcceptChFrameObserverCloneParams result;
            try {
                org.chromium.mojo.bindings.DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                final int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new AcceptChFrameObserverCloneParams(elementsOrVersion);
                    {
                        
                    result.listener = decoder0.readInterfaceRequest(8, false);
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
            
            encoder0.encode(this.listener, 8, false);
        }
    }



}
