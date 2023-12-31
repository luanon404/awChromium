// Gpu_Internal.java is auto generated by mojom_bindings_generator.py, do not edit


// Copyright 2014 The Chromium Authors
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.

// This file is autogenerated by:
//     mojo/public/tools/bindings/mojom_bindings_generator.py
// For:
//     services/viz/public/mojom/gpu.mojom
//

package org.chromium.viz.mojom;

import androidx.annotation.IntDef;


class Gpu_Internal {

    public static final org.chromium.mojo.bindings.Interface.Manager<Gpu, Gpu.Proxy> MANAGER =
            new org.chromium.mojo.bindings.Interface.Manager<Gpu, Gpu.Proxy>() {

        @Override
        public String getName() {
            return "viz.mojom.Gpu";
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
        public Stub buildStub(org.chromium.mojo.system.Core core, Gpu impl) {
            return new Stub(core, impl);
        }

        @Override
        public Gpu[] buildArray(int size) {
          return new Gpu[size];
        }
    };


    private static final int CREATE_GPU_MEMORY_BUFFER_FACTORY_ORDINAL = 0;

    private static final int CREATE_CLIENT_GPU_MEMORY_BUFFER_FACTORY_ORDINAL = 1;

    private static final int ESTABLISH_GPU_CHANNEL_ORDINAL = 2;

    private static final int CREATE_VIDEO_ENCODE_ACCELERATOR_PROVIDER_ORDINAL = 3;


    static final class Proxy extends org.chromium.mojo.bindings.Interface.AbstractProxy implements Gpu.Proxy {

        Proxy(org.chromium.mojo.system.Core core,
              org.chromium.mojo.bindings.MessageReceiverWithResponder messageReceiver) {
            super(core, messageReceiver);
        }


        @Override
        public void createGpuMemoryBufferFactory(
org.chromium.mojo.bindings.InterfaceRequest<GpuMemoryBufferFactory> receiver) {

            GpuCreateGpuMemoryBufferFactoryParams _message = new GpuCreateGpuMemoryBufferFactoryParams();

            _message.receiver = receiver;


            getProxyHandler().getMessageReceiver().accept(
                    _message.serializeWithHeader(
                            getProxyHandler().getCore(),
                            new org.chromium.mojo.bindings.MessageHeader(CREATE_GPU_MEMORY_BUFFER_FACTORY_ORDINAL)));

        }


        @Override
        public void createClientGpuMemoryBufferFactory(
org.chromium.mojo.bindings.InterfaceRequest<org.chromium.gpu.mojom.ClientGmbInterface> receiver) {

            GpuCreateClientGpuMemoryBufferFactoryParams _message = new GpuCreateClientGpuMemoryBufferFactoryParams();

            _message.receiver = receiver;


            getProxyHandler().getMessageReceiver().accept(
                    _message.serializeWithHeader(
                            getProxyHandler().getCore(),
                            new org.chromium.mojo.bindings.MessageHeader(CREATE_CLIENT_GPU_MEMORY_BUFFER_FACTORY_ORDINAL)));

        }


        @Override
        public void establishGpuChannel(

EstablishGpuChannel_Response callback) {

            GpuEstablishGpuChannelParams _message = new GpuEstablishGpuChannelParams();


            getProxyHandler().getMessageReceiver().acceptWithResponder(
                    _message.serializeWithHeader(
                            getProxyHandler().getCore(),
                            new org.chromium.mojo.bindings.MessageHeader(
                                    ESTABLISH_GPU_CHANNEL_ORDINAL,
                                    org.chromium.mojo.bindings.MessageHeader.MESSAGE_EXPECTS_RESPONSE_FLAG,
                                    0)),
                    new GpuEstablishGpuChannelResponseParamsForwardToCallback(callback));

        }


        @Override
        public void createVideoEncodeAcceleratorProvider(
org.chromium.mojo.bindings.InterfaceRequest<org.chromium.media.mojom.VideoEncodeAcceleratorProvider> veaProvider) {

            GpuCreateVideoEncodeAcceleratorProviderParams _message = new GpuCreateVideoEncodeAcceleratorProviderParams();

            _message.veaProvider = veaProvider;


            getProxyHandler().getMessageReceiver().accept(
                    _message.serializeWithHeader(
                            getProxyHandler().getCore(),
                            new org.chromium.mojo.bindings.MessageHeader(CREATE_VIDEO_ENCODE_ACCELERATOR_PROVIDER_ORDINAL)));

        }


    }

    static final class Stub extends org.chromium.mojo.bindings.Interface.Stub<Gpu> {

        Stub(org.chromium.mojo.system.Core core, Gpu impl) {
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
                                Gpu_Internal.MANAGER, messageWithHeader);





                    case CREATE_GPU_MEMORY_BUFFER_FACTORY_ORDINAL: {

                        GpuCreateGpuMemoryBufferFactoryParams data =
                                GpuCreateGpuMemoryBufferFactoryParams.deserialize(messageWithHeader.getPayload());

                        getImpl().createGpuMemoryBufferFactory(data.receiver);
                        return true;
                    }





                    case CREATE_CLIENT_GPU_MEMORY_BUFFER_FACTORY_ORDINAL: {

                        GpuCreateClientGpuMemoryBufferFactoryParams data =
                                GpuCreateClientGpuMemoryBufferFactoryParams.deserialize(messageWithHeader.getPayload());

                        getImpl().createClientGpuMemoryBufferFactory(data.receiver);
                        return true;
                    }







                    case CREATE_VIDEO_ENCODE_ACCELERATOR_PROVIDER_ORDINAL: {

                        GpuCreateVideoEncodeAcceleratorProviderParams data =
                                GpuCreateVideoEncodeAcceleratorProviderParams.deserialize(messageWithHeader.getPayload());

                        getImpl().createVideoEncodeAcceleratorProvider(data.veaProvider);
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
                                getCore(), Gpu_Internal.MANAGER, messageWithHeader, receiver);











                    case ESTABLISH_GPU_CHANNEL_ORDINAL: {

                        GpuEstablishGpuChannelParams.deserialize(messageWithHeader.getPayload());

                        getImpl().establishGpuChannel(new GpuEstablishGpuChannelResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
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


    
    static final class GpuCreateGpuMemoryBufferFactoryParams extends org.chromium.mojo.bindings.Struct {

        private static final int STRUCT_SIZE = 16;
        private static final org.chromium.mojo.bindings.DataHeader[] VERSION_ARRAY = new org.chromium.mojo.bindings.DataHeader[] {new org.chromium.mojo.bindings.DataHeader(16, 0)};
        private static final org.chromium.mojo.bindings.DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public org.chromium.mojo.bindings.InterfaceRequest<GpuMemoryBufferFactory> receiver;

        private GpuCreateGpuMemoryBufferFactoryParams(int version) {
            super(STRUCT_SIZE, version);
        }

        public GpuCreateGpuMemoryBufferFactoryParams() {
            this(0);
        }

        public static GpuCreateGpuMemoryBufferFactoryParams deserialize(org.chromium.mojo.bindings.Message message) {
            return decode(new org.chromium.mojo.bindings.Decoder(message));
        }

        /**
         * Similar to the method above, but deserializes from a |ByteBuffer| instance.
         *
         * @throws org.chromium.mojo.bindings.DeserializationException on deserialization failure.
         */
        public static GpuCreateGpuMemoryBufferFactoryParams deserialize(java.nio.ByteBuffer data) {
            return deserialize(new org.chromium.mojo.bindings.Message(
                    data, new java.util.ArrayList<org.chromium.mojo.system.Handle>()));
        }

        @SuppressWarnings("unchecked")
        public static GpuCreateGpuMemoryBufferFactoryParams decode(org.chromium.mojo.bindings.Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            GpuCreateGpuMemoryBufferFactoryParams result;
            try {
                org.chromium.mojo.bindings.DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                final int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new GpuCreateGpuMemoryBufferFactoryParams(elementsOrVersion);
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



    
    static final class GpuCreateClientGpuMemoryBufferFactoryParams extends org.chromium.mojo.bindings.Struct {

        private static final int STRUCT_SIZE = 16;
        private static final org.chromium.mojo.bindings.DataHeader[] VERSION_ARRAY = new org.chromium.mojo.bindings.DataHeader[] {new org.chromium.mojo.bindings.DataHeader(16, 0)};
        private static final org.chromium.mojo.bindings.DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public org.chromium.mojo.bindings.InterfaceRequest<org.chromium.gpu.mojom.ClientGmbInterface> receiver;

        private GpuCreateClientGpuMemoryBufferFactoryParams(int version) {
            super(STRUCT_SIZE, version);
        }

        public GpuCreateClientGpuMemoryBufferFactoryParams() {
            this(0);
        }

        public static GpuCreateClientGpuMemoryBufferFactoryParams deserialize(org.chromium.mojo.bindings.Message message) {
            return decode(new org.chromium.mojo.bindings.Decoder(message));
        }

        /**
         * Similar to the method above, but deserializes from a |ByteBuffer| instance.
         *
         * @throws org.chromium.mojo.bindings.DeserializationException on deserialization failure.
         */
        public static GpuCreateClientGpuMemoryBufferFactoryParams deserialize(java.nio.ByteBuffer data) {
            return deserialize(new org.chromium.mojo.bindings.Message(
                    data, new java.util.ArrayList<org.chromium.mojo.system.Handle>()));
        }

        @SuppressWarnings("unchecked")
        public static GpuCreateClientGpuMemoryBufferFactoryParams decode(org.chromium.mojo.bindings.Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            GpuCreateClientGpuMemoryBufferFactoryParams result;
            try {
                org.chromium.mojo.bindings.DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                final int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new GpuCreateClientGpuMemoryBufferFactoryParams(elementsOrVersion);
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



    
    static final class GpuEstablishGpuChannelParams extends org.chromium.mojo.bindings.Struct {

        private static final int STRUCT_SIZE = 8;
        private static final org.chromium.mojo.bindings.DataHeader[] VERSION_ARRAY = new org.chromium.mojo.bindings.DataHeader[] {new org.chromium.mojo.bindings.DataHeader(8, 0)};
        private static final org.chromium.mojo.bindings.DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        private GpuEstablishGpuChannelParams(int version) {
            super(STRUCT_SIZE, version);
        }

        public GpuEstablishGpuChannelParams() {
            this(0);
        }

        public static GpuEstablishGpuChannelParams deserialize(org.chromium.mojo.bindings.Message message) {
            return decode(new org.chromium.mojo.bindings.Decoder(message));
        }

        /**
         * Similar to the method above, but deserializes from a |ByteBuffer| instance.
         *
         * @throws org.chromium.mojo.bindings.DeserializationException on deserialization failure.
         */
        public static GpuEstablishGpuChannelParams deserialize(java.nio.ByteBuffer data) {
            return deserialize(new org.chromium.mojo.bindings.Message(
                    data, new java.util.ArrayList<org.chromium.mojo.system.Handle>()));
        }

        @SuppressWarnings("unchecked")
        public static GpuEstablishGpuChannelParams decode(org.chromium.mojo.bindings.Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            GpuEstablishGpuChannelParams result;
            try {
                org.chromium.mojo.bindings.DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                final int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new GpuEstablishGpuChannelParams(elementsOrVersion);

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



    
    static final class GpuEstablishGpuChannelResponseParams extends org.chromium.mojo.bindings.Struct {

        private static final int STRUCT_SIZE = 40;
        private static final org.chromium.mojo.bindings.DataHeader[] VERSION_ARRAY = new org.chromium.mojo.bindings.DataHeader[] {new org.chromium.mojo.bindings.DataHeader(40, 0)};
        private static final org.chromium.mojo.bindings.DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public int clientId;
        public org.chromium.mojo.system.MessagePipeHandle channelHandle;
        public org.chromium.gpu.mojom.GpuInfo gpuInfo;
        public org.chromium.gpu.mojom.GpuFeatureInfo gpuFeatureInfo;
        public org.chromium.gpu.mojom.SharedImageCapabilities sharedImageCapabilities;

        private GpuEstablishGpuChannelResponseParams(int version) {
            super(STRUCT_SIZE, version);
            this.channelHandle = org.chromium.mojo.system.InvalidHandle.INSTANCE;
        }

        public GpuEstablishGpuChannelResponseParams() {
            this(0);
        }

        public static GpuEstablishGpuChannelResponseParams deserialize(org.chromium.mojo.bindings.Message message) {
            return decode(new org.chromium.mojo.bindings.Decoder(message));
        }

        /**
         * Similar to the method above, but deserializes from a |ByteBuffer| instance.
         *
         * @throws org.chromium.mojo.bindings.DeserializationException on deserialization failure.
         */
        public static GpuEstablishGpuChannelResponseParams deserialize(java.nio.ByteBuffer data) {
            return deserialize(new org.chromium.mojo.bindings.Message(
                    data, new java.util.ArrayList<org.chromium.mojo.system.Handle>()));
        }

        @SuppressWarnings("unchecked")
        public static GpuEstablishGpuChannelResponseParams decode(org.chromium.mojo.bindings.Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            GpuEstablishGpuChannelResponseParams result;
            try {
                org.chromium.mojo.bindings.DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                final int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new GpuEstablishGpuChannelResponseParams(elementsOrVersion);
                    {
                        
                    result.clientId = decoder0.readInt(8);
                    }
                    {
                        
                    result.channelHandle = decoder0.readMessagePipeHandle(12, true);
                    }
                    {
                        
                    org.chromium.mojo.bindings.Decoder decoder1 = decoder0.readPointer(16, false);
                    result.gpuInfo = org.chromium.gpu.mojom.GpuInfo.decode(decoder1);
                    }
                    {
                        
                    org.chromium.mojo.bindings.Decoder decoder1 = decoder0.readPointer(24, false);
                    result.gpuFeatureInfo = org.chromium.gpu.mojom.GpuFeatureInfo.decode(decoder1);
                    }
                    {
                        
                    org.chromium.mojo.bindings.Decoder decoder1 = decoder0.readPointer(32, false);
                    result.sharedImageCapabilities = org.chromium.gpu.mojom.SharedImageCapabilities.decode(decoder1);
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
            
            encoder0.encode(this.clientId, 8);
            
            encoder0.encode(this.channelHandle, 12, true);
            
            encoder0.encode(this.gpuInfo, 16, false);
            
            encoder0.encode(this.gpuFeatureInfo, 24, false);
            
            encoder0.encode(this.sharedImageCapabilities, 32, false);
        }
    }

    static class GpuEstablishGpuChannelResponseParamsForwardToCallback extends org.chromium.mojo.bindings.SideEffectFreeCloseable
            implements org.chromium.mojo.bindings.MessageReceiver {
        private final Gpu.EstablishGpuChannel_Response mCallback;

        GpuEstablishGpuChannelResponseParamsForwardToCallback(Gpu.EstablishGpuChannel_Response callback) {
            this.mCallback = callback;
        }

        @Override
        public boolean accept(org.chromium.mojo.bindings.Message message) {
            try {
                org.chromium.mojo.bindings.ServiceMessage messageWithHeader =
                        message.asServiceMessage();
                org.chromium.mojo.bindings.MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(ESTABLISH_GPU_CHANNEL_ORDINAL,
                                           org.chromium.mojo.bindings.MessageHeader.MESSAGE_IS_RESPONSE_FLAG)) {
                    return false;
                }

                GpuEstablishGpuChannelResponseParams response = GpuEstablishGpuChannelResponseParams.deserialize(messageWithHeader.getPayload());

                mCallback.call(response.clientId, response.channelHandle, response.gpuInfo, response.gpuFeatureInfo, response.sharedImageCapabilities);
                return true;
            } catch (org.chromium.mojo.bindings.DeserializationException e) {
                return false;
            }
        }
    }

    static class GpuEstablishGpuChannelResponseParamsProxyToResponder implements Gpu.EstablishGpuChannel_Response {

        private final org.chromium.mojo.system.Core mCore;
        private final org.chromium.mojo.bindings.MessageReceiver mMessageReceiver;
        private final long mRequestId;

        GpuEstablishGpuChannelResponseParamsProxyToResponder(
                org.chromium.mojo.system.Core core,
                org.chromium.mojo.bindings.MessageReceiver messageReceiver,
                long requestId) {
            mCore = core;
            mMessageReceiver = messageReceiver;
            mRequestId = requestId;
        }

        @Override
        public void call(Integer clientId, org.chromium.mojo.system.MessagePipeHandle channelHandle, org.chromium.gpu.mojom.GpuInfo gpuInfo, org.chromium.gpu.mojom.GpuFeatureInfo gpuFeatureInfo, org.chromium.gpu.mojom.SharedImageCapabilities sharedImageCapabilities) {
            GpuEstablishGpuChannelResponseParams _response = new GpuEstablishGpuChannelResponseParams();

            _response.clientId = clientId;

            _response.channelHandle = channelHandle;

            _response.gpuInfo = gpuInfo;

            _response.gpuFeatureInfo = gpuFeatureInfo;

            _response.sharedImageCapabilities = sharedImageCapabilities;

            org.chromium.mojo.bindings.ServiceMessage _message =
                    _response.serializeWithHeader(
                            mCore,
                            new org.chromium.mojo.bindings.MessageHeader(
                                    ESTABLISH_GPU_CHANNEL_ORDINAL,
                                    org.chromium.mojo.bindings.MessageHeader.MESSAGE_IS_RESPONSE_FLAG,
                                    mRequestId));
            mMessageReceiver.accept(_message);
        }
    }



    
    static final class GpuCreateVideoEncodeAcceleratorProviderParams extends org.chromium.mojo.bindings.Struct {

        private static final int STRUCT_SIZE = 16;
        private static final org.chromium.mojo.bindings.DataHeader[] VERSION_ARRAY = new org.chromium.mojo.bindings.DataHeader[] {new org.chromium.mojo.bindings.DataHeader(16, 0)};
        private static final org.chromium.mojo.bindings.DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public org.chromium.mojo.bindings.InterfaceRequest<org.chromium.media.mojom.VideoEncodeAcceleratorProvider> veaProvider;

        private GpuCreateVideoEncodeAcceleratorProviderParams(int version) {
            super(STRUCT_SIZE, version);
        }

        public GpuCreateVideoEncodeAcceleratorProviderParams() {
            this(0);
        }

        public static GpuCreateVideoEncodeAcceleratorProviderParams deserialize(org.chromium.mojo.bindings.Message message) {
            return decode(new org.chromium.mojo.bindings.Decoder(message));
        }

        /**
         * Similar to the method above, but deserializes from a |ByteBuffer| instance.
         *
         * @throws org.chromium.mojo.bindings.DeserializationException on deserialization failure.
         */
        public static GpuCreateVideoEncodeAcceleratorProviderParams deserialize(java.nio.ByteBuffer data) {
            return deserialize(new org.chromium.mojo.bindings.Message(
                    data, new java.util.ArrayList<org.chromium.mojo.system.Handle>()));
        }

        @SuppressWarnings("unchecked")
        public static GpuCreateVideoEncodeAcceleratorProviderParams decode(org.chromium.mojo.bindings.Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            GpuCreateVideoEncodeAcceleratorProviderParams result;
            try {
                org.chromium.mojo.bindings.DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                final int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new GpuCreateVideoEncodeAcceleratorProviderParams(elementsOrVersion);
                    {
                        
                    result.veaProvider = decoder0.readInterfaceRequest(8, false);
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
            
            encoder0.encode(this.veaProvider, 8, false);
        }
    }



}
