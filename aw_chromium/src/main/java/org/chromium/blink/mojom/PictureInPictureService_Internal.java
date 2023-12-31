// PictureInPictureService_Internal.java is auto generated by mojom_bindings_generator.py, do not edit


// Copyright 2014 The Chromium Authors
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.

// This file is autogenerated by:
//     mojo/public/tools/bindings/mojom_bindings_generator.py
// For:
//     third_party/blink/public/mojom/picture_in_picture/picture_in_picture.mojom
//

package org.chromium.blink.mojom;

import androidx.annotation.IntDef;


class PictureInPictureService_Internal {

    public static final org.chromium.mojo.bindings.Interface.Manager<PictureInPictureService, PictureInPictureService.Proxy> MANAGER =
            new org.chromium.mojo.bindings.Interface.Manager<PictureInPictureService, PictureInPictureService.Proxy>() {

        @Override
        public String getName() {
            return "blink.mojom.PictureInPictureService";
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
        public Stub buildStub(org.chromium.mojo.system.Core core, PictureInPictureService impl) {
            return new Stub(core, impl);
        }

        @Override
        public PictureInPictureService[] buildArray(int size) {
          return new PictureInPictureService[size];
        }
    };


    private static final int START_SESSION_ORDINAL = 0;


    static final class Proxy extends org.chromium.mojo.bindings.Interface.AbstractProxy implements PictureInPictureService.Proxy {

        Proxy(org.chromium.mojo.system.Core core,
              org.chromium.mojo.bindings.MessageReceiverWithResponder messageReceiver) {
            super(core, messageReceiver);
        }


        @Override
        public void startSession(
int playerId, org.chromium.mojo.bindings.AssociatedInterfaceNotSupported playerRemote, org.chromium.viz.mojom.SurfaceId surfaceId, org.chromium.gfx.mojom.Size naturalSize, boolean showPlayPauseButton, PictureInPictureSessionObserver observer, org.chromium.gfx.mojom.Rect sourceBounds, 
StartSession_Response callback) {

            PictureInPictureServiceStartSessionParams _message = new PictureInPictureServiceStartSessionParams();

            _message.playerId = playerId;

            _message.playerRemote = playerRemote;

            _message.surfaceId = surfaceId;

            _message.naturalSize = naturalSize;

            _message.showPlayPauseButton = showPlayPauseButton;

            _message.observer = observer;

            _message.sourceBounds = sourceBounds;


            getProxyHandler().getMessageReceiver().acceptWithResponder(
                    _message.serializeWithHeader(
                            getProxyHandler().getCore(),
                            new org.chromium.mojo.bindings.MessageHeader(
                                    START_SESSION_ORDINAL,
                                    org.chromium.mojo.bindings.MessageHeader.MESSAGE_EXPECTS_RESPONSE_FLAG,
                                    0)),
                    new PictureInPictureServiceStartSessionResponseParamsForwardToCallback(callback));

        }


    }

    static final class Stub extends org.chromium.mojo.bindings.Interface.Stub<PictureInPictureService> {

        Stub(org.chromium.mojo.system.Core core, PictureInPictureService impl) {
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
                                PictureInPictureService_Internal.MANAGER, messageWithHeader);




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
                                getCore(), PictureInPictureService_Internal.MANAGER, messageWithHeader, receiver);







                    case START_SESSION_ORDINAL: {

                        PictureInPictureServiceStartSessionParams data =
                                PictureInPictureServiceStartSessionParams.deserialize(messageWithHeader.getPayload());

                        getImpl().startSession(data.playerId, data.playerRemote, data.surfaceId, data.naturalSize, data.showPlayPauseButton, data.observer, data.sourceBounds, new PictureInPictureServiceStartSessionResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
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


    
    static final class PictureInPictureServiceStartSessionParams extends org.chromium.mojo.bindings.Struct {

        private static final int STRUCT_SIZE = 56;
        private static final org.chromium.mojo.bindings.DataHeader[] VERSION_ARRAY = new org.chromium.mojo.bindings.DataHeader[] {new org.chromium.mojo.bindings.DataHeader(56, 0)};
        private static final org.chromium.mojo.bindings.DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public int playerId;
        public org.chromium.mojo.bindings.AssociatedInterfaceNotSupported playerRemote;
        public org.chromium.viz.mojom.SurfaceId surfaceId;
        public org.chromium.gfx.mojom.Size naturalSize;
        public boolean showPlayPauseButton;
        public PictureInPictureSessionObserver observer;
        public org.chromium.gfx.mojom.Rect sourceBounds;

        private PictureInPictureServiceStartSessionParams(int version) {
            super(STRUCT_SIZE, version);
        }

        public PictureInPictureServiceStartSessionParams() {
            this(0);
        }

        public static PictureInPictureServiceStartSessionParams deserialize(org.chromium.mojo.bindings.Message message) {
            return decode(new org.chromium.mojo.bindings.Decoder(message));
        }

        /**
         * Similar to the method above, but deserializes from a |ByteBuffer| instance.
         *
         * @throws org.chromium.mojo.bindings.DeserializationException on deserialization failure.
         */
        public static PictureInPictureServiceStartSessionParams deserialize(java.nio.ByteBuffer data) {
            return deserialize(new org.chromium.mojo.bindings.Message(
                    data, new java.util.ArrayList<org.chromium.mojo.system.Handle>()));
        }

        @SuppressWarnings("unchecked")
        public static PictureInPictureServiceStartSessionParams decode(org.chromium.mojo.bindings.Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            PictureInPictureServiceStartSessionParams result;
            try {
                org.chromium.mojo.bindings.DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                final int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new PictureInPictureServiceStartSessionParams(elementsOrVersion);
                    {
                        
                    result.playerId = decoder0.readInt(8);
                    }
                    {
                        
                    result.playerRemote = decoder0.readAssociatedServiceInterfaceNotSupported(12, false);
                    }
                    {
                        
                    result.showPlayPauseButton = decoder0.readBoolean(20, 0);
                    }
                    {
                        
                    org.chromium.mojo.bindings.Decoder decoder1 = decoder0.readPointer(24, false);
                    result.surfaceId = org.chromium.viz.mojom.SurfaceId.decode(decoder1);
                    }
                    {
                        
                    org.chromium.mojo.bindings.Decoder decoder1 = decoder0.readPointer(32, false);
                    result.naturalSize = org.chromium.gfx.mojom.Size.decode(decoder1);
                    }
                    {
                        
                    result.observer = decoder0.readServiceInterface(40, false, PictureInPictureSessionObserver.MANAGER);
                    }
                    {
                        
                    org.chromium.mojo.bindings.Decoder decoder1 = decoder0.readPointer(48, false);
                    result.sourceBounds = org.chromium.gfx.mojom.Rect.decode(decoder1);
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
            
            encoder0.encode(this.playerId, 8);
            
            encoder0.encode(this.playerRemote, 12, false);
            
            encoder0.encode(this.showPlayPauseButton, 20, 0);
            
            encoder0.encode(this.surfaceId, 24, false);
            
            encoder0.encode(this.naturalSize, 32, false);
            
            encoder0.encode(this.observer, 40, false, PictureInPictureSessionObserver.MANAGER);
            
            encoder0.encode(this.sourceBounds, 48, false);
        }
    }



    
    static final class PictureInPictureServiceStartSessionResponseParams extends org.chromium.mojo.bindings.Struct {

        private static final int STRUCT_SIZE = 24;
        private static final org.chromium.mojo.bindings.DataHeader[] VERSION_ARRAY = new org.chromium.mojo.bindings.DataHeader[] {new org.chromium.mojo.bindings.DataHeader(24, 0)};
        private static final org.chromium.mojo.bindings.DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public PictureInPictureSession session;
        public org.chromium.gfx.mojom.Size size;

        private PictureInPictureServiceStartSessionResponseParams(int version) {
            super(STRUCT_SIZE, version);
        }

        public PictureInPictureServiceStartSessionResponseParams() {
            this(0);
        }

        public static PictureInPictureServiceStartSessionResponseParams deserialize(org.chromium.mojo.bindings.Message message) {
            return decode(new org.chromium.mojo.bindings.Decoder(message));
        }

        /**
         * Similar to the method above, but deserializes from a |ByteBuffer| instance.
         *
         * @throws org.chromium.mojo.bindings.DeserializationException on deserialization failure.
         */
        public static PictureInPictureServiceStartSessionResponseParams deserialize(java.nio.ByteBuffer data) {
            return deserialize(new org.chromium.mojo.bindings.Message(
                    data, new java.util.ArrayList<org.chromium.mojo.system.Handle>()));
        }

        @SuppressWarnings("unchecked")
        public static PictureInPictureServiceStartSessionResponseParams decode(org.chromium.mojo.bindings.Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            PictureInPictureServiceStartSessionResponseParams result;
            try {
                org.chromium.mojo.bindings.DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                final int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new PictureInPictureServiceStartSessionResponseParams(elementsOrVersion);
                    {
                        
                    result.session = decoder0.readServiceInterface(8, true, PictureInPictureSession.MANAGER);
                    }
                    {
                        
                    org.chromium.mojo.bindings.Decoder decoder1 = decoder0.readPointer(16, false);
                    result.size = org.chromium.gfx.mojom.Size.decode(decoder1);
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
            
            encoder0.encode(this.session, 8, true, PictureInPictureSession.MANAGER);
            
            encoder0.encode(this.size, 16, false);
        }
    }

    static class PictureInPictureServiceStartSessionResponseParamsForwardToCallback extends org.chromium.mojo.bindings.SideEffectFreeCloseable
            implements org.chromium.mojo.bindings.MessageReceiver {
        private final PictureInPictureService.StartSession_Response mCallback;

        PictureInPictureServiceStartSessionResponseParamsForwardToCallback(PictureInPictureService.StartSession_Response callback) {
            this.mCallback = callback;
        }

        @Override
        public boolean accept(org.chromium.mojo.bindings.Message message) {
            try {
                org.chromium.mojo.bindings.ServiceMessage messageWithHeader =
                        message.asServiceMessage();
                org.chromium.mojo.bindings.MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(START_SESSION_ORDINAL,
                                           org.chromium.mojo.bindings.MessageHeader.MESSAGE_IS_RESPONSE_FLAG)) {
                    return false;
                }

                PictureInPictureServiceStartSessionResponseParams response = PictureInPictureServiceStartSessionResponseParams.deserialize(messageWithHeader.getPayload());

                mCallback.call(response.session, response.size);
                return true;
            } catch (org.chromium.mojo.bindings.DeserializationException e) {
                return false;
            }
        }
    }

    static class PictureInPictureServiceStartSessionResponseParamsProxyToResponder implements PictureInPictureService.StartSession_Response {

        private final org.chromium.mojo.system.Core mCore;
        private final org.chromium.mojo.bindings.MessageReceiver mMessageReceiver;
        private final long mRequestId;

        PictureInPictureServiceStartSessionResponseParamsProxyToResponder(
                org.chromium.mojo.system.Core core,
                org.chromium.mojo.bindings.MessageReceiver messageReceiver,
                long requestId) {
            mCore = core;
            mMessageReceiver = messageReceiver;
            mRequestId = requestId;
        }

        @Override
        public void call(PictureInPictureSession session, org.chromium.gfx.mojom.Size size) {
            PictureInPictureServiceStartSessionResponseParams _response = new PictureInPictureServiceStartSessionResponseParams();

            _response.session = session;

            _response.size = size;

            org.chromium.mojo.bindings.ServiceMessage _message =
                    _response.serializeWithHeader(
                            mCore,
                            new org.chromium.mojo.bindings.MessageHeader(
                                    START_SESSION_ORDINAL,
                                    org.chromium.mojo.bindings.MessageHeader.MESSAGE_IS_RESPONSE_FLAG,
                                    mRequestId));
            mMessageReceiver.accept(_message);
        }
    }



}
