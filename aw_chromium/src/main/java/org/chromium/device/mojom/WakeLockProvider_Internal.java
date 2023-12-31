// WakeLockProvider_Internal.java is auto generated by mojom_bindings_generator.py, do not edit


// Copyright 2014 The Chromium Authors
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.

// This file is autogenerated by:
//     mojo/public/tools/bindings/mojom_bindings_generator.py
// For:
//     services/device/public/mojom/wake_lock_provider.mojom
//

package org.chromium.device.mojom;

import androidx.annotation.IntDef;


class WakeLockProvider_Internal {

    public static final org.chromium.mojo.bindings.Interface.Manager<WakeLockProvider, WakeLockProvider.Proxy> MANAGER =
            new org.chromium.mojo.bindings.Interface.Manager<WakeLockProvider, WakeLockProvider.Proxy>() {

        @Override
        public String getName() {
            return "device.mojom.WakeLockProvider";
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
        public Stub buildStub(org.chromium.mojo.system.Core core, WakeLockProvider impl) {
            return new Stub(core, impl);
        }

        @Override
        public WakeLockProvider[] buildArray(int size) {
          return new WakeLockProvider[size];
        }
    };


    private static final int GET_WAKE_LOCK_CONTEXT_FOR_ID_ORDINAL = 0;

    private static final int GET_WAKE_LOCK_WITHOUT_CONTEXT_ORDINAL = 1;

    private static final int NOTIFY_ON_WAKE_LOCK_DEACTIVATION_ORDINAL = 2;

    private static final int GET_ACTIVE_WAKE_LOCKS_FOR_TESTS_ORDINAL = 3;


    static final class Proxy extends org.chromium.mojo.bindings.Interface.AbstractProxy implements WakeLockProvider.Proxy {

        Proxy(org.chromium.mojo.system.Core core,
              org.chromium.mojo.bindings.MessageReceiverWithResponder messageReceiver) {
            super(core, messageReceiver);
        }


        @Override
        public void getWakeLockContextForId(
int contextId, org.chromium.mojo.bindings.InterfaceRequest<WakeLockContext> context) {

            WakeLockProviderGetWakeLockContextForIdParams _message = new WakeLockProviderGetWakeLockContextForIdParams();

            _message.contextId = contextId;

            _message.context = context;


            getProxyHandler().getMessageReceiver().accept(
                    _message.serializeWithHeader(
                            getProxyHandler().getCore(),
                            new org.chromium.mojo.bindings.MessageHeader(GET_WAKE_LOCK_CONTEXT_FOR_ID_ORDINAL)));

        }


        @Override
        public void getWakeLockWithoutContext(
int type, int reason, String description, org.chromium.mojo.bindings.InterfaceRequest<WakeLock> wakeLock) {

            WakeLockProviderGetWakeLockWithoutContextParams _message = new WakeLockProviderGetWakeLockWithoutContextParams();

            _message.type = type;

            _message.reason = reason;

            _message.description = description;

            _message.wakeLock = wakeLock;


            getProxyHandler().getMessageReceiver().accept(
                    _message.serializeWithHeader(
                            getProxyHandler().getCore(),
                            new org.chromium.mojo.bindings.MessageHeader(GET_WAKE_LOCK_WITHOUT_CONTEXT_ORDINAL)));

        }


        @Override
        public void notifyOnWakeLockDeactivation(
int type, WakeLockObserver observer) {

            WakeLockProviderNotifyOnWakeLockDeactivationParams _message = new WakeLockProviderNotifyOnWakeLockDeactivationParams();

            _message.type = type;

            _message.observer = observer;


            getProxyHandler().getMessageReceiver().accept(
                    _message.serializeWithHeader(
                            getProxyHandler().getCore(),
                            new org.chromium.mojo.bindings.MessageHeader(NOTIFY_ON_WAKE_LOCK_DEACTIVATION_ORDINAL)));

        }


        @Override
        public void getActiveWakeLocksForTests(
int type, 
GetActiveWakeLocksForTests_Response callback) {

            WakeLockProviderGetActiveWakeLocksForTestsParams _message = new WakeLockProviderGetActiveWakeLocksForTestsParams();

            _message.type = type;


            getProxyHandler().getMessageReceiver().acceptWithResponder(
                    _message.serializeWithHeader(
                            getProxyHandler().getCore(),
                            new org.chromium.mojo.bindings.MessageHeader(
                                    GET_ACTIVE_WAKE_LOCKS_FOR_TESTS_ORDINAL,
                                    org.chromium.mojo.bindings.MessageHeader.MESSAGE_EXPECTS_RESPONSE_FLAG,
                                    0)),
                    new WakeLockProviderGetActiveWakeLocksForTestsResponseParamsForwardToCallback(callback));

        }


    }

    static final class Stub extends org.chromium.mojo.bindings.Interface.Stub<WakeLockProvider> {

        Stub(org.chromium.mojo.system.Core core, WakeLockProvider impl) {
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
                                WakeLockProvider_Internal.MANAGER, messageWithHeader);





                    case GET_WAKE_LOCK_CONTEXT_FOR_ID_ORDINAL: {

                        WakeLockProviderGetWakeLockContextForIdParams data =
                                WakeLockProviderGetWakeLockContextForIdParams.deserialize(messageWithHeader.getPayload());

                        getImpl().getWakeLockContextForId(data.contextId, data.context);
                        return true;
                    }





                    case GET_WAKE_LOCK_WITHOUT_CONTEXT_ORDINAL: {

                        WakeLockProviderGetWakeLockWithoutContextParams data =
                                WakeLockProviderGetWakeLockWithoutContextParams.deserialize(messageWithHeader.getPayload());

                        getImpl().getWakeLockWithoutContext(data.type, data.reason, data.description, data.wakeLock);
                        return true;
                    }





                    case NOTIFY_ON_WAKE_LOCK_DEACTIVATION_ORDINAL: {

                        WakeLockProviderNotifyOnWakeLockDeactivationParams data =
                                WakeLockProviderNotifyOnWakeLockDeactivationParams.deserialize(messageWithHeader.getPayload());

                        getImpl().notifyOnWakeLockDeactivation(data.type, data.observer);
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
                                getCore(), WakeLockProvider_Internal.MANAGER, messageWithHeader, receiver);













                    case GET_ACTIVE_WAKE_LOCKS_FOR_TESTS_ORDINAL: {

                        WakeLockProviderGetActiveWakeLocksForTestsParams data =
                                WakeLockProviderGetActiveWakeLocksForTestsParams.deserialize(messageWithHeader.getPayload());

                        getImpl().getActiveWakeLocksForTests(data.type, new WakeLockProviderGetActiveWakeLocksForTestsResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
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


    
    static final class WakeLockProviderGetWakeLockContextForIdParams extends org.chromium.mojo.bindings.Struct {

        private static final int STRUCT_SIZE = 16;
        private static final org.chromium.mojo.bindings.DataHeader[] VERSION_ARRAY = new org.chromium.mojo.bindings.DataHeader[] {new org.chromium.mojo.bindings.DataHeader(16, 0)};
        private static final org.chromium.mojo.bindings.DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public int contextId;
        public org.chromium.mojo.bindings.InterfaceRequest<WakeLockContext> context;

        private WakeLockProviderGetWakeLockContextForIdParams(int version) {
            super(STRUCT_SIZE, version);
        }

        public WakeLockProviderGetWakeLockContextForIdParams() {
            this(0);
        }

        public static WakeLockProviderGetWakeLockContextForIdParams deserialize(org.chromium.mojo.bindings.Message message) {
            return decode(new org.chromium.mojo.bindings.Decoder(message));
        }

        /**
         * Similar to the method above, but deserializes from a |ByteBuffer| instance.
         *
         * @throws org.chromium.mojo.bindings.DeserializationException on deserialization failure.
         */
        public static WakeLockProviderGetWakeLockContextForIdParams deserialize(java.nio.ByteBuffer data) {
            return deserialize(new org.chromium.mojo.bindings.Message(
                    data, new java.util.ArrayList<org.chromium.mojo.system.Handle>()));
        }

        @SuppressWarnings("unchecked")
        public static WakeLockProviderGetWakeLockContextForIdParams decode(org.chromium.mojo.bindings.Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            WakeLockProviderGetWakeLockContextForIdParams result;
            try {
                org.chromium.mojo.bindings.DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                final int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new WakeLockProviderGetWakeLockContextForIdParams(elementsOrVersion);
                    {
                        
                    result.contextId = decoder0.readInt(8);
                    }
                    {
                        
                    result.context = decoder0.readInterfaceRequest(12, false);
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
            
            encoder0.encode(this.contextId, 8);
            
            encoder0.encode(this.context, 12, false);
        }
    }



    
    static final class WakeLockProviderGetWakeLockWithoutContextParams extends org.chromium.mojo.bindings.Struct {

        private static final int STRUCT_SIZE = 32;
        private static final org.chromium.mojo.bindings.DataHeader[] VERSION_ARRAY = new org.chromium.mojo.bindings.DataHeader[] {new org.chromium.mojo.bindings.DataHeader(32, 0)};
        private static final org.chromium.mojo.bindings.DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public int type;
        public int reason;
        public String description;
        public org.chromium.mojo.bindings.InterfaceRequest<WakeLock> wakeLock;

        private WakeLockProviderGetWakeLockWithoutContextParams(int version) {
            super(STRUCT_SIZE, version);
        }

        public WakeLockProviderGetWakeLockWithoutContextParams() {
            this(0);
        }

        public static WakeLockProviderGetWakeLockWithoutContextParams deserialize(org.chromium.mojo.bindings.Message message) {
            return decode(new org.chromium.mojo.bindings.Decoder(message));
        }

        /**
         * Similar to the method above, but deserializes from a |ByteBuffer| instance.
         *
         * @throws org.chromium.mojo.bindings.DeserializationException on deserialization failure.
         */
        public static WakeLockProviderGetWakeLockWithoutContextParams deserialize(java.nio.ByteBuffer data) {
            return deserialize(new org.chromium.mojo.bindings.Message(
                    data, new java.util.ArrayList<org.chromium.mojo.system.Handle>()));
        }

        @SuppressWarnings("unchecked")
        public static WakeLockProviderGetWakeLockWithoutContextParams decode(org.chromium.mojo.bindings.Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            WakeLockProviderGetWakeLockWithoutContextParams result;
            try {
                org.chromium.mojo.bindings.DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                final int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new WakeLockProviderGetWakeLockWithoutContextParams(elementsOrVersion);
                    {
                        
                    result.type = decoder0.readInt(8);
                        WakeLockType.validate(result.type);
                        result.type = WakeLockType.toKnownValue(result.type);
                    }
                    {
                        
                    result.reason = decoder0.readInt(12);
                        WakeLockReason.validate(result.reason);
                        result.reason = WakeLockReason.toKnownValue(result.reason);
                    }
                    {
                        
                    result.description = decoder0.readString(16, false);
                    }
                    {
                        
                    result.wakeLock = decoder0.readInterfaceRequest(24, false);
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
            
            encoder0.encode(this.type, 8);
            
            encoder0.encode(this.reason, 12);
            
            encoder0.encode(this.description, 16, false);
            
            encoder0.encode(this.wakeLock, 24, false);
        }
    }



    
    static final class WakeLockProviderNotifyOnWakeLockDeactivationParams extends org.chromium.mojo.bindings.Struct {

        private static final int STRUCT_SIZE = 24;
        private static final org.chromium.mojo.bindings.DataHeader[] VERSION_ARRAY = new org.chromium.mojo.bindings.DataHeader[] {new org.chromium.mojo.bindings.DataHeader(24, 0)};
        private static final org.chromium.mojo.bindings.DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public int type;
        public WakeLockObserver observer;

        private WakeLockProviderNotifyOnWakeLockDeactivationParams(int version) {
            super(STRUCT_SIZE, version);
        }

        public WakeLockProviderNotifyOnWakeLockDeactivationParams() {
            this(0);
        }

        public static WakeLockProviderNotifyOnWakeLockDeactivationParams deserialize(org.chromium.mojo.bindings.Message message) {
            return decode(new org.chromium.mojo.bindings.Decoder(message));
        }

        /**
         * Similar to the method above, but deserializes from a |ByteBuffer| instance.
         *
         * @throws org.chromium.mojo.bindings.DeserializationException on deserialization failure.
         */
        public static WakeLockProviderNotifyOnWakeLockDeactivationParams deserialize(java.nio.ByteBuffer data) {
            return deserialize(new org.chromium.mojo.bindings.Message(
                    data, new java.util.ArrayList<org.chromium.mojo.system.Handle>()));
        }

        @SuppressWarnings("unchecked")
        public static WakeLockProviderNotifyOnWakeLockDeactivationParams decode(org.chromium.mojo.bindings.Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            WakeLockProviderNotifyOnWakeLockDeactivationParams result;
            try {
                org.chromium.mojo.bindings.DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                final int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new WakeLockProviderNotifyOnWakeLockDeactivationParams(elementsOrVersion);
                    {
                        
                    result.type = decoder0.readInt(8);
                        WakeLockType.validate(result.type);
                        result.type = WakeLockType.toKnownValue(result.type);
                    }
                    {
                        
                    result.observer = decoder0.readServiceInterface(12, false, WakeLockObserver.MANAGER);
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
            
            encoder0.encode(this.type, 8);
            
            encoder0.encode(this.observer, 12, false, WakeLockObserver.MANAGER);
        }
    }



    
    static final class WakeLockProviderGetActiveWakeLocksForTestsParams extends org.chromium.mojo.bindings.Struct {

        private static final int STRUCT_SIZE = 16;
        private static final org.chromium.mojo.bindings.DataHeader[] VERSION_ARRAY = new org.chromium.mojo.bindings.DataHeader[] {new org.chromium.mojo.bindings.DataHeader(16, 0)};
        private static final org.chromium.mojo.bindings.DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public int type;

        private WakeLockProviderGetActiveWakeLocksForTestsParams(int version) {
            super(STRUCT_SIZE, version);
        }

        public WakeLockProviderGetActiveWakeLocksForTestsParams() {
            this(0);
        }

        public static WakeLockProviderGetActiveWakeLocksForTestsParams deserialize(org.chromium.mojo.bindings.Message message) {
            return decode(new org.chromium.mojo.bindings.Decoder(message));
        }

        /**
         * Similar to the method above, but deserializes from a |ByteBuffer| instance.
         *
         * @throws org.chromium.mojo.bindings.DeserializationException on deserialization failure.
         */
        public static WakeLockProviderGetActiveWakeLocksForTestsParams deserialize(java.nio.ByteBuffer data) {
            return deserialize(new org.chromium.mojo.bindings.Message(
                    data, new java.util.ArrayList<org.chromium.mojo.system.Handle>()));
        }

        @SuppressWarnings("unchecked")
        public static WakeLockProviderGetActiveWakeLocksForTestsParams decode(org.chromium.mojo.bindings.Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            WakeLockProviderGetActiveWakeLocksForTestsParams result;
            try {
                org.chromium.mojo.bindings.DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                final int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new WakeLockProviderGetActiveWakeLocksForTestsParams(elementsOrVersion);
                    {
                        
                    result.type = decoder0.readInt(8);
                        WakeLockType.validate(result.type);
                        result.type = WakeLockType.toKnownValue(result.type);
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
            
            encoder0.encode(this.type, 8);
        }
    }



    
    static final class WakeLockProviderGetActiveWakeLocksForTestsResponseParams extends org.chromium.mojo.bindings.Struct {

        private static final int STRUCT_SIZE = 16;
        private static final org.chromium.mojo.bindings.DataHeader[] VERSION_ARRAY = new org.chromium.mojo.bindings.DataHeader[] {new org.chromium.mojo.bindings.DataHeader(16, 0)};
        private static final org.chromium.mojo.bindings.DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public int count;

        private WakeLockProviderGetActiveWakeLocksForTestsResponseParams(int version) {
            super(STRUCT_SIZE, version);
        }

        public WakeLockProviderGetActiveWakeLocksForTestsResponseParams() {
            this(0);
        }

        public static WakeLockProviderGetActiveWakeLocksForTestsResponseParams deserialize(org.chromium.mojo.bindings.Message message) {
            return decode(new org.chromium.mojo.bindings.Decoder(message));
        }

        /**
         * Similar to the method above, but deserializes from a |ByteBuffer| instance.
         *
         * @throws org.chromium.mojo.bindings.DeserializationException on deserialization failure.
         */
        public static WakeLockProviderGetActiveWakeLocksForTestsResponseParams deserialize(java.nio.ByteBuffer data) {
            return deserialize(new org.chromium.mojo.bindings.Message(
                    data, new java.util.ArrayList<org.chromium.mojo.system.Handle>()));
        }

        @SuppressWarnings("unchecked")
        public static WakeLockProviderGetActiveWakeLocksForTestsResponseParams decode(org.chromium.mojo.bindings.Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            WakeLockProviderGetActiveWakeLocksForTestsResponseParams result;
            try {
                org.chromium.mojo.bindings.DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                final int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new WakeLockProviderGetActiveWakeLocksForTestsResponseParams(elementsOrVersion);
                    {
                        
                    result.count = decoder0.readInt(8);
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
            
            encoder0.encode(this.count, 8);
        }
    }

    static class WakeLockProviderGetActiveWakeLocksForTestsResponseParamsForwardToCallback extends org.chromium.mojo.bindings.SideEffectFreeCloseable
            implements org.chromium.mojo.bindings.MessageReceiver {
        private final WakeLockProvider.GetActiveWakeLocksForTests_Response mCallback;

        WakeLockProviderGetActiveWakeLocksForTestsResponseParamsForwardToCallback(WakeLockProvider.GetActiveWakeLocksForTests_Response callback) {
            this.mCallback = callback;
        }

        @Override
        public boolean accept(org.chromium.mojo.bindings.Message message) {
            try {
                org.chromium.mojo.bindings.ServiceMessage messageWithHeader =
                        message.asServiceMessage();
                org.chromium.mojo.bindings.MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(GET_ACTIVE_WAKE_LOCKS_FOR_TESTS_ORDINAL,
                                           org.chromium.mojo.bindings.MessageHeader.MESSAGE_IS_RESPONSE_FLAG)) {
                    return false;
                }

                WakeLockProviderGetActiveWakeLocksForTestsResponseParams response = WakeLockProviderGetActiveWakeLocksForTestsResponseParams.deserialize(messageWithHeader.getPayload());

                mCallback.call(response.count);
                return true;
            } catch (org.chromium.mojo.bindings.DeserializationException e) {
                return false;
            }
        }
    }

    static class WakeLockProviderGetActiveWakeLocksForTestsResponseParamsProxyToResponder implements WakeLockProvider.GetActiveWakeLocksForTests_Response {

        private final org.chromium.mojo.system.Core mCore;
        private final org.chromium.mojo.bindings.MessageReceiver mMessageReceiver;
        private final long mRequestId;

        WakeLockProviderGetActiveWakeLocksForTestsResponseParamsProxyToResponder(
                org.chromium.mojo.system.Core core,
                org.chromium.mojo.bindings.MessageReceiver messageReceiver,
                long requestId) {
            mCore = core;
            mMessageReceiver = messageReceiver;
            mRequestId = requestId;
        }

        @Override
        public void call(Integer count) {
            WakeLockProviderGetActiveWakeLocksForTestsResponseParams _response = new WakeLockProviderGetActiveWakeLocksForTestsResponseParams();

            _response.count = count;

            org.chromium.mojo.bindings.ServiceMessage _message =
                    _response.serializeWithHeader(
                            mCore,
                            new org.chromium.mojo.bindings.MessageHeader(
                                    GET_ACTIVE_WAKE_LOCKS_FOR_TESTS_ORDINAL,
                                    org.chromium.mojo.bindings.MessageHeader.MESSAGE_IS_RESPONSE_FLAG,
                                    mRequestId));
            mMessageReceiver.accept(_message);
        }
    }



}
