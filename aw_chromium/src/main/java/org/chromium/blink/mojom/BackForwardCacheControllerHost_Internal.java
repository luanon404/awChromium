// BackForwardCacheControllerHost_Internal.java is auto generated by mojom_bindings_generator.py, do not edit


// Copyright 2014 The Chromium Authors
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.

// This file is autogenerated by:
//     mojo/public/tools/bindings/mojom_bindings_generator.py
// For:
//     third_party/blink/public/mojom/frame/back_forward_cache_controller.mojom
//

package org.chromium.blink.mojom;

import androidx.annotation.IntDef;


class BackForwardCacheControllerHost_Internal {

    public static final org.chromium.mojo.bindings.Interface.Manager<BackForwardCacheControllerHost, BackForwardCacheControllerHost.Proxy> MANAGER =
            new org.chromium.mojo.bindings.Interface.Manager<BackForwardCacheControllerHost, BackForwardCacheControllerHost.Proxy>() {

        @Override
        public String getName() {
            return "blink.mojom.BackForwardCacheControllerHost";
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
        public Stub buildStub(org.chromium.mojo.system.Core core, BackForwardCacheControllerHost impl) {
            return new Stub(core, impl);
        }

        @Override
        public BackForwardCacheControllerHost[] buildArray(int size) {
          return new BackForwardCacheControllerHost[size];
        }
    };


    private static final int EVICT_FROM_BACK_FORWARD_CACHE_ORDINAL = 0;

    private static final int DID_CHANGE_BACK_FORWARD_CACHE_DISABLING_FEATURES_ORDINAL = 1;


    static final class Proxy extends org.chromium.mojo.bindings.Interface.AbstractProxy implements BackForwardCacheControllerHost.Proxy {

        Proxy(org.chromium.mojo.system.Core core,
              org.chromium.mojo.bindings.MessageReceiverWithResponder messageReceiver) {
            super(core, messageReceiver);
        }


        @Override
        public void evictFromBackForwardCache(
int reason) {

            BackForwardCacheControllerHostEvictFromBackForwardCacheParams _message = new BackForwardCacheControllerHostEvictFromBackForwardCacheParams();

            _message.reason = reason;


            getProxyHandler().getMessageReceiver().accept(
                    _message.serializeWithHeader(
                            getProxyHandler().getCore(),
                            new org.chromium.mojo.bindings.MessageHeader(EVICT_FROM_BACK_FORWARD_CACHE_ORDINAL)));

        }


        @Override
        public void didChangeBackForwardCacheDisablingFeatures(
BlockingDetails[] details) {

            BackForwardCacheControllerHostDidChangeBackForwardCacheDisablingFeaturesParams _message = new BackForwardCacheControllerHostDidChangeBackForwardCacheDisablingFeaturesParams();

            _message.details = details;


            getProxyHandler().getMessageReceiver().accept(
                    _message.serializeWithHeader(
                            getProxyHandler().getCore(),
                            new org.chromium.mojo.bindings.MessageHeader(DID_CHANGE_BACK_FORWARD_CACHE_DISABLING_FEATURES_ORDINAL)));

        }


    }

    static final class Stub extends org.chromium.mojo.bindings.Interface.Stub<BackForwardCacheControllerHost> {

        Stub(org.chromium.mojo.system.Core core, BackForwardCacheControllerHost impl) {
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
                                BackForwardCacheControllerHost_Internal.MANAGER, messageWithHeader);





                    case EVICT_FROM_BACK_FORWARD_CACHE_ORDINAL: {

                        BackForwardCacheControllerHostEvictFromBackForwardCacheParams data =
                                BackForwardCacheControllerHostEvictFromBackForwardCacheParams.deserialize(messageWithHeader.getPayload());

                        getImpl().evictFromBackForwardCache(data.reason);
                        return true;
                    }





                    case DID_CHANGE_BACK_FORWARD_CACHE_DISABLING_FEATURES_ORDINAL: {

                        BackForwardCacheControllerHostDidChangeBackForwardCacheDisablingFeaturesParams data =
                                BackForwardCacheControllerHostDidChangeBackForwardCacheDisablingFeaturesParams.deserialize(messageWithHeader.getPayload());

                        getImpl().didChangeBackForwardCacheDisablingFeatures(data.details);
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
                                getCore(), BackForwardCacheControllerHost_Internal.MANAGER, messageWithHeader, receiver);






                    default:
                        return false;
                }
            } catch (org.chromium.mojo.bindings.DeserializationException e) {
                System.err.println(e.toString());
                return false;
            }
        }
    }


    
    static final class BackForwardCacheControllerHostEvictFromBackForwardCacheParams extends org.chromium.mojo.bindings.Struct {

        private static final int STRUCT_SIZE = 16;
        private static final org.chromium.mojo.bindings.DataHeader[] VERSION_ARRAY = new org.chromium.mojo.bindings.DataHeader[] {new org.chromium.mojo.bindings.DataHeader(16, 0)};
        private static final org.chromium.mojo.bindings.DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public int reason;

        private BackForwardCacheControllerHostEvictFromBackForwardCacheParams(int version) {
            super(STRUCT_SIZE, version);
        }

        public BackForwardCacheControllerHostEvictFromBackForwardCacheParams() {
            this(0);
        }

        public static BackForwardCacheControllerHostEvictFromBackForwardCacheParams deserialize(org.chromium.mojo.bindings.Message message) {
            return decode(new org.chromium.mojo.bindings.Decoder(message));
        }

        /**
         * Similar to the method above, but deserializes from a |ByteBuffer| instance.
         *
         * @throws org.chromium.mojo.bindings.DeserializationException on deserialization failure.
         */
        public static BackForwardCacheControllerHostEvictFromBackForwardCacheParams deserialize(java.nio.ByteBuffer data) {
            return deserialize(new org.chromium.mojo.bindings.Message(
                    data, new java.util.ArrayList<org.chromium.mojo.system.Handle>()));
        }

        @SuppressWarnings("unchecked")
        public static BackForwardCacheControllerHostEvictFromBackForwardCacheParams decode(org.chromium.mojo.bindings.Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            BackForwardCacheControllerHostEvictFromBackForwardCacheParams result;
            try {
                org.chromium.mojo.bindings.DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                final int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new BackForwardCacheControllerHostEvictFromBackForwardCacheParams(elementsOrVersion);
                    {
                        
                    result.reason = decoder0.readInt(8);
                        RendererEvictionReason.validate(result.reason);
                        result.reason = RendererEvictionReason.toKnownValue(result.reason);
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
            
            encoder0.encode(this.reason, 8);
        }
    }



    
    static final class BackForwardCacheControllerHostDidChangeBackForwardCacheDisablingFeaturesParams extends org.chromium.mojo.bindings.Struct {

        private static final int STRUCT_SIZE = 16;
        private static final org.chromium.mojo.bindings.DataHeader[] VERSION_ARRAY = new org.chromium.mojo.bindings.DataHeader[] {new org.chromium.mojo.bindings.DataHeader(16, 0)};
        private static final org.chromium.mojo.bindings.DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public BlockingDetails[] details;

        private BackForwardCacheControllerHostDidChangeBackForwardCacheDisablingFeaturesParams(int version) {
            super(STRUCT_SIZE, version);
        }

        public BackForwardCacheControllerHostDidChangeBackForwardCacheDisablingFeaturesParams() {
            this(0);
        }

        public static BackForwardCacheControllerHostDidChangeBackForwardCacheDisablingFeaturesParams deserialize(org.chromium.mojo.bindings.Message message) {
            return decode(new org.chromium.mojo.bindings.Decoder(message));
        }

        /**
         * Similar to the method above, but deserializes from a |ByteBuffer| instance.
         *
         * @throws org.chromium.mojo.bindings.DeserializationException on deserialization failure.
         */
        public static BackForwardCacheControllerHostDidChangeBackForwardCacheDisablingFeaturesParams deserialize(java.nio.ByteBuffer data) {
            return deserialize(new org.chromium.mojo.bindings.Message(
                    data, new java.util.ArrayList<org.chromium.mojo.system.Handle>()));
        }

        @SuppressWarnings("unchecked")
        public static BackForwardCacheControllerHostDidChangeBackForwardCacheDisablingFeaturesParams decode(org.chromium.mojo.bindings.Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            BackForwardCacheControllerHostDidChangeBackForwardCacheDisablingFeaturesParams result;
            try {
                org.chromium.mojo.bindings.DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                final int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new BackForwardCacheControllerHostDidChangeBackForwardCacheDisablingFeaturesParams(elementsOrVersion);
                    {
                        
                    org.chromium.mojo.bindings.Decoder decoder1 = decoder0.readPointer(8, false);
                    {
                        org.chromium.mojo.bindings.DataHeader si1 = decoder1.readDataHeaderForPointerArray(org.chromium.mojo.bindings.BindingsHelper.UNSPECIFIED_ARRAY_LENGTH);
                        result.details = new BlockingDetails[si1.elementsOrVersion];
                        for (int i1 = 0; i1 < si1.elementsOrVersion; ++i1) {
                            
                            org.chromium.mojo.bindings.Decoder decoder2 = decoder1.readPointer(org.chromium.mojo.bindings.DataHeader.HEADER_SIZE + org.chromium.mojo.bindings.BindingsHelper.POINTER_SIZE * i1, false);
                            result.details[i1] = BlockingDetails.decode(decoder2);
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
            
            if (this.details == null) {
                encoder0.encodeNullPointer(8, false);
            } else {
                org.chromium.mojo.bindings.Encoder encoder1 = encoder0.encodePointerArray(this.details.length, 8, org.chromium.mojo.bindings.BindingsHelper.UNSPECIFIED_ARRAY_LENGTH);
                for (int i0 = 0; i0 < this.details.length; ++i0) {
                    
                    encoder1.encode(this.details[i0], org.chromium.mojo.bindings.DataHeader.HEADER_SIZE + org.chromium.mojo.bindings.BindingsHelper.POINTER_SIZE * i0, false);
                }
            }
        }
    }



}
