// FrameSinkBundleClient_Internal.java is auto generated by mojom_bindings_generator.py, do not edit


// Copyright 2014 The Chromium Authors
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.

// This file is autogenerated by:
//     mojo/public/tools/bindings/mojom_bindings_generator.py
// For:
//     services/viz/public/mojom/compositing/frame_sink_bundle.mojom
//

package org.chromium.viz.mojom;

import androidx.annotation.IntDef;


class FrameSinkBundleClient_Internal {

    public static final org.chromium.mojo.bindings.Interface.Manager<FrameSinkBundleClient, FrameSinkBundleClient.Proxy> MANAGER =
            new org.chromium.mojo.bindings.Interface.Manager<FrameSinkBundleClient, FrameSinkBundleClient.Proxy>() {

        @Override
        public String getName() {
            return "viz.mojom.FrameSinkBundleClient";
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
        public Stub buildStub(org.chromium.mojo.system.Core core, FrameSinkBundleClient impl) {
            return new Stub(core, impl);
        }

        @Override
        public FrameSinkBundleClient[] buildArray(int size) {
          return new FrameSinkBundleClient[size];
        }
    };


    private static final int FLUSH_NOTIFICATIONS_ORDINAL = 0;

    private static final int ON_BEGIN_FRAME_PAUSED_CHANGED_ORDINAL = 1;

    private static final int ON_COMPOSITOR_FRAME_TRANSITION_DIRECTIVE_PROCESSED_ORDINAL = 2;


    static final class Proxy extends org.chromium.mojo.bindings.Interface.AbstractProxy implements FrameSinkBundleClient.Proxy {

        Proxy(org.chromium.mojo.system.Core core,
              org.chromium.mojo.bindings.MessageReceiverWithResponder messageReceiver) {
            super(core, messageReceiver);
        }


        @Override
        public void flushNotifications(
BundledReturnedResources[] acks, BeginFrameInfo[] beginFrames, BundledReturnedResources[] reclaimedResources) {

            FrameSinkBundleClientFlushNotificationsParams _message = new FrameSinkBundleClientFlushNotificationsParams();

            _message.acks = acks;

            _message.beginFrames = beginFrames;

            _message.reclaimedResources = reclaimedResources;


            getProxyHandler().getMessageReceiver().accept(
                    _message.serializeWithHeader(
                            getProxyHandler().getCore(),
                            new org.chromium.mojo.bindings.MessageHeader(FLUSH_NOTIFICATIONS_ORDINAL)));

        }


        @Override
        public void onBeginFramePausedChanged(
int sinkId, boolean paused) {

            FrameSinkBundleClientOnBeginFramePausedChangedParams _message = new FrameSinkBundleClientOnBeginFramePausedChangedParams();

            _message.sinkId = sinkId;

            _message.paused = paused;


            getProxyHandler().getMessageReceiver().accept(
                    _message.serializeWithHeader(
                            getProxyHandler().getCore(),
                            new org.chromium.mojo.bindings.MessageHeader(ON_BEGIN_FRAME_PAUSED_CHANGED_ORDINAL)));

        }


        @Override
        public void onCompositorFrameTransitionDirectiveProcessed(
int sinkId, int sequenceId) {

            FrameSinkBundleClientOnCompositorFrameTransitionDirectiveProcessedParams _message = new FrameSinkBundleClientOnCompositorFrameTransitionDirectiveProcessedParams();

            _message.sinkId = sinkId;

            _message.sequenceId = sequenceId;


            getProxyHandler().getMessageReceiver().accept(
                    _message.serializeWithHeader(
                            getProxyHandler().getCore(),
                            new org.chromium.mojo.bindings.MessageHeader(ON_COMPOSITOR_FRAME_TRANSITION_DIRECTIVE_PROCESSED_ORDINAL)));

        }


    }

    static final class Stub extends org.chromium.mojo.bindings.Interface.Stub<FrameSinkBundleClient> {

        Stub(org.chromium.mojo.system.Core core, FrameSinkBundleClient impl) {
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
                                FrameSinkBundleClient_Internal.MANAGER, messageWithHeader);





                    case FLUSH_NOTIFICATIONS_ORDINAL: {

                        FrameSinkBundleClientFlushNotificationsParams data =
                                FrameSinkBundleClientFlushNotificationsParams.deserialize(messageWithHeader.getPayload());

                        getImpl().flushNotifications(data.acks, data.beginFrames, data.reclaimedResources);
                        return true;
                    }





                    case ON_BEGIN_FRAME_PAUSED_CHANGED_ORDINAL: {

                        FrameSinkBundleClientOnBeginFramePausedChangedParams data =
                                FrameSinkBundleClientOnBeginFramePausedChangedParams.deserialize(messageWithHeader.getPayload());

                        getImpl().onBeginFramePausedChanged(data.sinkId, data.paused);
                        return true;
                    }





                    case ON_COMPOSITOR_FRAME_TRANSITION_DIRECTIVE_PROCESSED_ORDINAL: {

                        FrameSinkBundleClientOnCompositorFrameTransitionDirectiveProcessedParams data =
                                FrameSinkBundleClientOnCompositorFrameTransitionDirectiveProcessedParams.deserialize(messageWithHeader.getPayload());

                        getImpl().onCompositorFrameTransitionDirectiveProcessed(data.sinkId, data.sequenceId);
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
                                getCore(), FrameSinkBundleClient_Internal.MANAGER, messageWithHeader, receiver);








                    default:
                        return false;
                }
            } catch (org.chromium.mojo.bindings.DeserializationException e) {
                System.err.println(e.toString());
                return false;
            }
        }
    }


    
    static final class FrameSinkBundleClientFlushNotificationsParams extends org.chromium.mojo.bindings.Struct {

        private static final int STRUCT_SIZE = 32;
        private static final org.chromium.mojo.bindings.DataHeader[] VERSION_ARRAY = new org.chromium.mojo.bindings.DataHeader[] {new org.chromium.mojo.bindings.DataHeader(32, 0)};
        private static final org.chromium.mojo.bindings.DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public BundledReturnedResources[] acks;
        public BeginFrameInfo[] beginFrames;
        public BundledReturnedResources[] reclaimedResources;

        private FrameSinkBundleClientFlushNotificationsParams(int version) {
            super(STRUCT_SIZE, version);
        }

        public FrameSinkBundleClientFlushNotificationsParams() {
            this(0);
        }

        public static FrameSinkBundleClientFlushNotificationsParams deserialize(org.chromium.mojo.bindings.Message message) {
            return decode(new org.chromium.mojo.bindings.Decoder(message));
        }

        /**
         * Similar to the method above, but deserializes from a |ByteBuffer| instance.
         *
         * @throws org.chromium.mojo.bindings.DeserializationException on deserialization failure.
         */
        public static FrameSinkBundleClientFlushNotificationsParams deserialize(java.nio.ByteBuffer data) {
            return deserialize(new org.chromium.mojo.bindings.Message(
                    data, new java.util.ArrayList<org.chromium.mojo.system.Handle>()));
        }

        @SuppressWarnings("unchecked")
        public static FrameSinkBundleClientFlushNotificationsParams decode(org.chromium.mojo.bindings.Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            FrameSinkBundleClientFlushNotificationsParams result;
            try {
                org.chromium.mojo.bindings.DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                final int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new FrameSinkBundleClientFlushNotificationsParams(elementsOrVersion);
                    {
                        
                    org.chromium.mojo.bindings.Decoder decoder1 = decoder0.readPointer(8, false);
                    {
                        org.chromium.mojo.bindings.DataHeader si1 = decoder1.readDataHeaderForPointerArray(org.chromium.mojo.bindings.BindingsHelper.UNSPECIFIED_ARRAY_LENGTH);
                        result.acks = new BundledReturnedResources[si1.elementsOrVersion];
                        for (int i1 = 0; i1 < si1.elementsOrVersion; ++i1) {
                            
                            org.chromium.mojo.bindings.Decoder decoder2 = decoder1.readPointer(org.chromium.mojo.bindings.DataHeader.HEADER_SIZE + org.chromium.mojo.bindings.BindingsHelper.POINTER_SIZE * i1, false);
                            result.acks[i1] = BundledReturnedResources.decode(decoder2);
                        }
                    }
                    }
                    {
                        
                    org.chromium.mojo.bindings.Decoder decoder1 = decoder0.readPointer(16, false);
                    {
                        org.chromium.mojo.bindings.DataHeader si1 = decoder1.readDataHeaderForPointerArray(org.chromium.mojo.bindings.BindingsHelper.UNSPECIFIED_ARRAY_LENGTH);
                        result.beginFrames = new BeginFrameInfo[si1.elementsOrVersion];
                        for (int i1 = 0; i1 < si1.elementsOrVersion; ++i1) {
                            
                            org.chromium.mojo.bindings.Decoder decoder2 = decoder1.readPointer(org.chromium.mojo.bindings.DataHeader.HEADER_SIZE + org.chromium.mojo.bindings.BindingsHelper.POINTER_SIZE * i1, false);
                            result.beginFrames[i1] = BeginFrameInfo.decode(decoder2);
                        }
                    }
                    }
                    {
                        
                    org.chromium.mojo.bindings.Decoder decoder1 = decoder0.readPointer(24, false);
                    {
                        org.chromium.mojo.bindings.DataHeader si1 = decoder1.readDataHeaderForPointerArray(org.chromium.mojo.bindings.BindingsHelper.UNSPECIFIED_ARRAY_LENGTH);
                        result.reclaimedResources = new BundledReturnedResources[si1.elementsOrVersion];
                        for (int i1 = 0; i1 < si1.elementsOrVersion; ++i1) {
                            
                            org.chromium.mojo.bindings.Decoder decoder2 = decoder1.readPointer(org.chromium.mojo.bindings.DataHeader.HEADER_SIZE + org.chromium.mojo.bindings.BindingsHelper.POINTER_SIZE * i1, false);
                            result.reclaimedResources[i1] = BundledReturnedResources.decode(decoder2);
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
            
            if (this.acks == null) {
                encoder0.encodeNullPointer(8, false);
            } else {
                org.chromium.mojo.bindings.Encoder encoder1 = encoder0.encodePointerArray(this.acks.length, 8, org.chromium.mojo.bindings.BindingsHelper.UNSPECIFIED_ARRAY_LENGTH);
                for (int i0 = 0; i0 < this.acks.length; ++i0) {
                    
                    encoder1.encode(this.acks[i0], org.chromium.mojo.bindings.DataHeader.HEADER_SIZE + org.chromium.mojo.bindings.BindingsHelper.POINTER_SIZE * i0, false);
                }
            }
            
            if (this.beginFrames == null) {
                encoder0.encodeNullPointer(16, false);
            } else {
                org.chromium.mojo.bindings.Encoder encoder1 = encoder0.encodePointerArray(this.beginFrames.length, 16, org.chromium.mojo.bindings.BindingsHelper.UNSPECIFIED_ARRAY_LENGTH);
                for (int i0 = 0; i0 < this.beginFrames.length; ++i0) {
                    
                    encoder1.encode(this.beginFrames[i0], org.chromium.mojo.bindings.DataHeader.HEADER_SIZE + org.chromium.mojo.bindings.BindingsHelper.POINTER_SIZE * i0, false);
                }
            }
            
            if (this.reclaimedResources == null) {
                encoder0.encodeNullPointer(24, false);
            } else {
                org.chromium.mojo.bindings.Encoder encoder1 = encoder0.encodePointerArray(this.reclaimedResources.length, 24, org.chromium.mojo.bindings.BindingsHelper.UNSPECIFIED_ARRAY_LENGTH);
                for (int i0 = 0; i0 < this.reclaimedResources.length; ++i0) {
                    
                    encoder1.encode(this.reclaimedResources[i0], org.chromium.mojo.bindings.DataHeader.HEADER_SIZE + org.chromium.mojo.bindings.BindingsHelper.POINTER_SIZE * i0, false);
                }
            }
        }
    }



    
    static final class FrameSinkBundleClientOnBeginFramePausedChangedParams extends org.chromium.mojo.bindings.Struct {

        private static final int STRUCT_SIZE = 16;
        private static final org.chromium.mojo.bindings.DataHeader[] VERSION_ARRAY = new org.chromium.mojo.bindings.DataHeader[] {new org.chromium.mojo.bindings.DataHeader(16, 0)};
        private static final org.chromium.mojo.bindings.DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public int sinkId;
        public boolean paused;

        private FrameSinkBundleClientOnBeginFramePausedChangedParams(int version) {
            super(STRUCT_SIZE, version);
        }

        public FrameSinkBundleClientOnBeginFramePausedChangedParams() {
            this(0);
        }

        public static FrameSinkBundleClientOnBeginFramePausedChangedParams deserialize(org.chromium.mojo.bindings.Message message) {
            return decode(new org.chromium.mojo.bindings.Decoder(message));
        }

        /**
         * Similar to the method above, but deserializes from a |ByteBuffer| instance.
         *
         * @throws org.chromium.mojo.bindings.DeserializationException on deserialization failure.
         */
        public static FrameSinkBundleClientOnBeginFramePausedChangedParams deserialize(java.nio.ByteBuffer data) {
            return deserialize(new org.chromium.mojo.bindings.Message(
                    data, new java.util.ArrayList<org.chromium.mojo.system.Handle>()));
        }

        @SuppressWarnings("unchecked")
        public static FrameSinkBundleClientOnBeginFramePausedChangedParams decode(org.chromium.mojo.bindings.Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            FrameSinkBundleClientOnBeginFramePausedChangedParams result;
            try {
                org.chromium.mojo.bindings.DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                final int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new FrameSinkBundleClientOnBeginFramePausedChangedParams(elementsOrVersion);
                    {
                        
                    result.sinkId = decoder0.readInt(8);
                    }
                    {
                        
                    result.paused = decoder0.readBoolean(12, 0);
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
            
            encoder0.encode(this.sinkId, 8);
            
            encoder0.encode(this.paused, 12, 0);
        }
    }



    
    static final class FrameSinkBundleClientOnCompositorFrameTransitionDirectiveProcessedParams extends org.chromium.mojo.bindings.Struct {

        private static final int STRUCT_SIZE = 16;
        private static final org.chromium.mojo.bindings.DataHeader[] VERSION_ARRAY = new org.chromium.mojo.bindings.DataHeader[] {new org.chromium.mojo.bindings.DataHeader(16, 0)};
        private static final org.chromium.mojo.bindings.DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public int sinkId;
        public int sequenceId;

        private FrameSinkBundleClientOnCompositorFrameTransitionDirectiveProcessedParams(int version) {
            super(STRUCT_SIZE, version);
        }

        public FrameSinkBundleClientOnCompositorFrameTransitionDirectiveProcessedParams() {
            this(0);
        }

        public static FrameSinkBundleClientOnCompositorFrameTransitionDirectiveProcessedParams deserialize(org.chromium.mojo.bindings.Message message) {
            return decode(new org.chromium.mojo.bindings.Decoder(message));
        }

        /**
         * Similar to the method above, but deserializes from a |ByteBuffer| instance.
         *
         * @throws org.chromium.mojo.bindings.DeserializationException on deserialization failure.
         */
        public static FrameSinkBundleClientOnCompositorFrameTransitionDirectiveProcessedParams deserialize(java.nio.ByteBuffer data) {
            return deserialize(new org.chromium.mojo.bindings.Message(
                    data, new java.util.ArrayList<org.chromium.mojo.system.Handle>()));
        }

        @SuppressWarnings("unchecked")
        public static FrameSinkBundleClientOnCompositorFrameTransitionDirectiveProcessedParams decode(org.chromium.mojo.bindings.Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            FrameSinkBundleClientOnCompositorFrameTransitionDirectiveProcessedParams result;
            try {
                org.chromium.mojo.bindings.DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                final int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new FrameSinkBundleClientOnCompositorFrameTransitionDirectiveProcessedParams(elementsOrVersion);
                    {
                        
                    result.sinkId = decoder0.readInt(8);
                    }
                    {
                        
                    result.sequenceId = decoder0.readInt(12);
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
            
            encoder0.encode(this.sinkId, 8);
            
            encoder0.encode(this.sequenceId, 12);
        }
    }



}
