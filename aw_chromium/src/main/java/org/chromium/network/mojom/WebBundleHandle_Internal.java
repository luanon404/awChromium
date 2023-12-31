// WebBundleHandle_Internal.java is auto generated by mojom_bindings_generator.py, do not edit


// Copyright 2014 The Chromium Authors
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.

// This file is autogenerated by:
//     mojo/public/tools/bindings/mojom_bindings_generator.py
// For:
//     services/network/public/mojom/web_bundle_handle.mojom
//

package org.chromium.network.mojom;

import androidx.annotation.IntDef;


class WebBundleHandle_Internal {

    public static final org.chromium.mojo.bindings.Interface.Manager<WebBundleHandle, WebBundleHandle.Proxy> MANAGER =
            new org.chromium.mojo.bindings.Interface.Manager<WebBundleHandle, WebBundleHandle.Proxy>() {

        @Override
        public String getName() {
            return "network.mojom.WebBundleHandle";
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
        public Stub buildStub(org.chromium.mojo.system.Core core, WebBundleHandle impl) {
            return new Stub(core, impl);
        }

        @Override
        public WebBundleHandle[] buildArray(int size) {
          return new WebBundleHandle[size];
        }
    };


    private static final int CLONE_ORDINAL = 0;

    private static final int ON_WEB_BUNDLE_ERROR_ORDINAL = 1;

    private static final int ON_WEB_BUNDLE_LOAD_FINISHED_ORDINAL = 2;


    static final class Proxy extends org.chromium.mojo.bindings.Interface.AbstractProxy implements WebBundleHandle.Proxy {

        Proxy(org.chromium.mojo.system.Core core,
              org.chromium.mojo.bindings.MessageReceiverWithResponder messageReceiver) {
            super(core, messageReceiver);
        }


        @Override
        public void clone(
org.chromium.mojo.bindings.InterfaceRequest<WebBundleHandle> receiver) {

            WebBundleHandleCloneParams _message = new WebBundleHandleCloneParams();

            _message.receiver = receiver;


            getProxyHandler().getMessageReceiver().accept(
                    _message.serializeWithHeader(
                            getProxyHandler().getCore(),
                            new org.chromium.mojo.bindings.MessageHeader(CLONE_ORDINAL)));

        }


        @Override
        public void onWebBundleError(
int type, String message) {

            WebBundleHandleOnWebBundleErrorParams _message = new WebBundleHandleOnWebBundleErrorParams();

            _message.type = type;

            _message.message = message;


            getProxyHandler().getMessageReceiver().accept(
                    _message.serializeWithHeader(
                            getProxyHandler().getCore(),
                            new org.chromium.mojo.bindings.MessageHeader(ON_WEB_BUNDLE_ERROR_ORDINAL)));

        }


        @Override
        public void onWebBundleLoadFinished(
boolean success) {

            WebBundleHandleOnWebBundleLoadFinishedParams _message = new WebBundleHandleOnWebBundleLoadFinishedParams();

            _message.success = success;


            getProxyHandler().getMessageReceiver().accept(
                    _message.serializeWithHeader(
                            getProxyHandler().getCore(),
                            new org.chromium.mojo.bindings.MessageHeader(ON_WEB_BUNDLE_LOAD_FINISHED_ORDINAL)));

        }


    }

    static final class Stub extends org.chromium.mojo.bindings.Interface.Stub<WebBundleHandle> {

        Stub(org.chromium.mojo.system.Core core, WebBundleHandle impl) {
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
                                WebBundleHandle_Internal.MANAGER, messageWithHeader);





                    case CLONE_ORDINAL: {

                        WebBundleHandleCloneParams data =
                                WebBundleHandleCloneParams.deserialize(messageWithHeader.getPayload());

                        getImpl().clone(data.receiver);
                        return true;
                    }





                    case ON_WEB_BUNDLE_ERROR_ORDINAL: {

                        WebBundleHandleOnWebBundleErrorParams data =
                                WebBundleHandleOnWebBundleErrorParams.deserialize(messageWithHeader.getPayload());

                        getImpl().onWebBundleError(data.type, data.message);
                        return true;
                    }





                    case ON_WEB_BUNDLE_LOAD_FINISHED_ORDINAL: {

                        WebBundleHandleOnWebBundleLoadFinishedParams data =
                                WebBundleHandleOnWebBundleLoadFinishedParams.deserialize(messageWithHeader.getPayload());

                        getImpl().onWebBundleLoadFinished(data.success);
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
                                getCore(), WebBundleHandle_Internal.MANAGER, messageWithHeader, receiver);








                    default:
                        return false;
                }
            } catch (org.chromium.mojo.bindings.DeserializationException e) {
                System.err.println(e.toString());
                return false;
            }
        }
    }


    
    static final class WebBundleHandleCloneParams extends org.chromium.mojo.bindings.Struct {

        private static final int STRUCT_SIZE = 16;
        private static final org.chromium.mojo.bindings.DataHeader[] VERSION_ARRAY = new org.chromium.mojo.bindings.DataHeader[] {new org.chromium.mojo.bindings.DataHeader(16, 0)};
        private static final org.chromium.mojo.bindings.DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public org.chromium.mojo.bindings.InterfaceRequest<WebBundleHandle> receiver;

        private WebBundleHandleCloneParams(int version) {
            super(STRUCT_SIZE, version);
        }

        public WebBundleHandleCloneParams() {
            this(0);
        }

        public static WebBundleHandleCloneParams deserialize(org.chromium.mojo.bindings.Message message) {
            return decode(new org.chromium.mojo.bindings.Decoder(message));
        }

        /**
         * Similar to the method above, but deserializes from a |ByteBuffer| instance.
         *
         * @throws org.chromium.mojo.bindings.DeserializationException on deserialization failure.
         */
        public static WebBundleHandleCloneParams deserialize(java.nio.ByteBuffer data) {
            return deserialize(new org.chromium.mojo.bindings.Message(
                    data, new java.util.ArrayList<org.chromium.mojo.system.Handle>()));
        }

        @SuppressWarnings("unchecked")
        public static WebBundleHandleCloneParams decode(org.chromium.mojo.bindings.Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            WebBundleHandleCloneParams result;
            try {
                org.chromium.mojo.bindings.DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                final int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new WebBundleHandleCloneParams(elementsOrVersion);
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



    
    static final class WebBundleHandleOnWebBundleErrorParams extends org.chromium.mojo.bindings.Struct {

        private static final int STRUCT_SIZE = 24;
        private static final org.chromium.mojo.bindings.DataHeader[] VERSION_ARRAY = new org.chromium.mojo.bindings.DataHeader[] {new org.chromium.mojo.bindings.DataHeader(24, 0)};
        private static final org.chromium.mojo.bindings.DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public int type;
        public String message;

        private WebBundleHandleOnWebBundleErrorParams(int version) {
            super(STRUCT_SIZE, version);
        }

        public WebBundleHandleOnWebBundleErrorParams() {
            this(0);
        }

        public static WebBundleHandleOnWebBundleErrorParams deserialize(org.chromium.mojo.bindings.Message message) {
            return decode(new org.chromium.mojo.bindings.Decoder(message));
        }

        /**
         * Similar to the method above, but deserializes from a |ByteBuffer| instance.
         *
         * @throws org.chromium.mojo.bindings.DeserializationException on deserialization failure.
         */
        public static WebBundleHandleOnWebBundleErrorParams deserialize(java.nio.ByteBuffer data) {
            return deserialize(new org.chromium.mojo.bindings.Message(
                    data, new java.util.ArrayList<org.chromium.mojo.system.Handle>()));
        }

        @SuppressWarnings("unchecked")
        public static WebBundleHandleOnWebBundleErrorParams decode(org.chromium.mojo.bindings.Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            WebBundleHandleOnWebBundleErrorParams result;
            try {
                org.chromium.mojo.bindings.DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                final int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new WebBundleHandleOnWebBundleErrorParams(elementsOrVersion);
                    {
                        
                    result.type = decoder0.readInt(8);
                        WebBundleErrorType.validate(result.type);
                        result.type = WebBundleErrorType.toKnownValue(result.type);
                    }
                    {
                        
                    result.message = decoder0.readString(16, false);
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
            
            encoder0.encode(this.message, 16, false);
        }
    }



    
    static final class WebBundleHandleOnWebBundleLoadFinishedParams extends org.chromium.mojo.bindings.Struct {

        private static final int STRUCT_SIZE = 16;
        private static final org.chromium.mojo.bindings.DataHeader[] VERSION_ARRAY = new org.chromium.mojo.bindings.DataHeader[] {new org.chromium.mojo.bindings.DataHeader(16, 0)};
        private static final org.chromium.mojo.bindings.DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public boolean success;

        private WebBundleHandleOnWebBundleLoadFinishedParams(int version) {
            super(STRUCT_SIZE, version);
        }

        public WebBundleHandleOnWebBundleLoadFinishedParams() {
            this(0);
        }

        public static WebBundleHandleOnWebBundleLoadFinishedParams deserialize(org.chromium.mojo.bindings.Message message) {
            return decode(new org.chromium.mojo.bindings.Decoder(message));
        }

        /**
         * Similar to the method above, but deserializes from a |ByteBuffer| instance.
         *
         * @throws org.chromium.mojo.bindings.DeserializationException on deserialization failure.
         */
        public static WebBundleHandleOnWebBundleLoadFinishedParams deserialize(java.nio.ByteBuffer data) {
            return deserialize(new org.chromium.mojo.bindings.Message(
                    data, new java.util.ArrayList<org.chromium.mojo.system.Handle>()));
        }

        @SuppressWarnings("unchecked")
        public static WebBundleHandleOnWebBundleLoadFinishedParams decode(org.chromium.mojo.bindings.Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            WebBundleHandleOnWebBundleLoadFinishedParams result;
            try {
                org.chromium.mojo.bindings.DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                final int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new WebBundleHandleOnWebBundleLoadFinishedParams(elementsOrVersion);
                    {
                        
                    result.success = decoder0.readBoolean(8, 0);
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
            
            encoder0.encode(this.success, 8, 0);
        }
    }



}
