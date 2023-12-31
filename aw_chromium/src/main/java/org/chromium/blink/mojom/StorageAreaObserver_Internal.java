// StorageAreaObserver_Internal.java is auto generated by mojom_bindings_generator.py, do not edit


// Copyright 2014 The Chromium Authors
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.

// This file is autogenerated by:
//     mojo/public/tools/bindings/mojom_bindings_generator.py
// For:
//     third_party/blink/public/mojom/dom_storage/storage_area.mojom
//

package org.chromium.blink.mojom;

import androidx.annotation.IntDef;


class StorageAreaObserver_Internal {

    public static final org.chromium.mojo.bindings.Interface.Manager<StorageAreaObserver, StorageAreaObserver.Proxy> MANAGER =
            new org.chromium.mojo.bindings.Interface.Manager<StorageAreaObserver, StorageAreaObserver.Proxy>() {

        @Override
        public String getName() {
            return "blink.mojom.StorageAreaObserver";
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
        public Stub buildStub(org.chromium.mojo.system.Core core, StorageAreaObserver impl) {
            return new Stub(core, impl);
        }

        @Override
        public StorageAreaObserver[] buildArray(int size) {
          return new StorageAreaObserver[size];
        }
    };


    private static final int KEY_CHANGED_ORDINAL = 0;

    private static final int KEY_CHANGE_FAILED_ORDINAL = 1;

    private static final int KEY_DELETED_ORDINAL = 2;

    private static final int ALL_DELETED_ORDINAL = 3;

    private static final int SHOULD_SEND_OLD_VALUE_ON_MUTATIONS_ORDINAL = 4;


    static final class Proxy extends org.chromium.mojo.bindings.Interface.AbstractProxy implements StorageAreaObserver.Proxy {

        Proxy(org.chromium.mojo.system.Core core,
              org.chromium.mojo.bindings.MessageReceiverWithResponder messageReceiver) {
            super(core, messageReceiver);
        }


        @Override
        public void keyChanged(
byte[] key, byte[] newValue, byte[] oldValue, String source) {

            StorageAreaObserverKeyChangedParams _message = new StorageAreaObserverKeyChangedParams();

            _message.key = key;

            _message.newValue = newValue;

            _message.oldValue = oldValue;

            _message.source = source;


            getProxyHandler().getMessageReceiver().accept(
                    _message.serializeWithHeader(
                            getProxyHandler().getCore(),
                            new org.chromium.mojo.bindings.MessageHeader(KEY_CHANGED_ORDINAL)));

        }


        @Override
        public void keyChangeFailed(
byte[] key, String source) {

            StorageAreaObserverKeyChangeFailedParams _message = new StorageAreaObserverKeyChangeFailedParams();

            _message.key = key;

            _message.source = source;


            getProxyHandler().getMessageReceiver().accept(
                    _message.serializeWithHeader(
                            getProxyHandler().getCore(),
                            new org.chromium.mojo.bindings.MessageHeader(KEY_CHANGE_FAILED_ORDINAL)));

        }


        @Override
        public void keyDeleted(
byte[] key, byte[] oldValue, String source) {

            StorageAreaObserverKeyDeletedParams _message = new StorageAreaObserverKeyDeletedParams();

            _message.key = key;

            _message.oldValue = oldValue;

            _message.source = source;


            getProxyHandler().getMessageReceiver().accept(
                    _message.serializeWithHeader(
                            getProxyHandler().getCore(),
                            new org.chromium.mojo.bindings.MessageHeader(KEY_DELETED_ORDINAL)));

        }


        @Override
        public void allDeleted(
boolean wasNonempty, String source) {

            StorageAreaObserverAllDeletedParams _message = new StorageAreaObserverAllDeletedParams();

            _message.wasNonempty = wasNonempty;

            _message.source = source;


            getProxyHandler().getMessageReceiver().accept(
                    _message.serializeWithHeader(
                            getProxyHandler().getCore(),
                            new org.chromium.mojo.bindings.MessageHeader(ALL_DELETED_ORDINAL)));

        }


        @Override
        public void shouldSendOldValueOnMutations(
boolean value) {

            StorageAreaObserverShouldSendOldValueOnMutationsParams _message = new StorageAreaObserverShouldSendOldValueOnMutationsParams();

            _message.value = value;


            getProxyHandler().getMessageReceiver().accept(
                    _message.serializeWithHeader(
                            getProxyHandler().getCore(),
                            new org.chromium.mojo.bindings.MessageHeader(SHOULD_SEND_OLD_VALUE_ON_MUTATIONS_ORDINAL)));

        }


    }

    static final class Stub extends org.chromium.mojo.bindings.Interface.Stub<StorageAreaObserver> {

        Stub(org.chromium.mojo.system.Core core, StorageAreaObserver impl) {
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
                                StorageAreaObserver_Internal.MANAGER, messageWithHeader);





                    case KEY_CHANGED_ORDINAL: {

                        StorageAreaObserverKeyChangedParams data =
                                StorageAreaObserverKeyChangedParams.deserialize(messageWithHeader.getPayload());

                        getImpl().keyChanged(data.key, data.newValue, data.oldValue, data.source);
                        return true;
                    }





                    case KEY_CHANGE_FAILED_ORDINAL: {

                        StorageAreaObserverKeyChangeFailedParams data =
                                StorageAreaObserverKeyChangeFailedParams.deserialize(messageWithHeader.getPayload());

                        getImpl().keyChangeFailed(data.key, data.source);
                        return true;
                    }





                    case KEY_DELETED_ORDINAL: {

                        StorageAreaObserverKeyDeletedParams data =
                                StorageAreaObserverKeyDeletedParams.deserialize(messageWithHeader.getPayload());

                        getImpl().keyDeleted(data.key, data.oldValue, data.source);
                        return true;
                    }





                    case ALL_DELETED_ORDINAL: {

                        StorageAreaObserverAllDeletedParams data =
                                StorageAreaObserverAllDeletedParams.deserialize(messageWithHeader.getPayload());

                        getImpl().allDeleted(data.wasNonempty, data.source);
                        return true;
                    }





                    case SHOULD_SEND_OLD_VALUE_ON_MUTATIONS_ORDINAL: {

                        StorageAreaObserverShouldSendOldValueOnMutationsParams data =
                                StorageAreaObserverShouldSendOldValueOnMutationsParams.deserialize(messageWithHeader.getPayload());

                        getImpl().shouldSendOldValueOnMutations(data.value);
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
                                getCore(), StorageAreaObserver_Internal.MANAGER, messageWithHeader, receiver);












                    default:
                        return false;
                }
            } catch (org.chromium.mojo.bindings.DeserializationException e) {
                System.err.println(e.toString());
                return false;
            }
        }
    }


    
    static final class StorageAreaObserverKeyChangedParams extends org.chromium.mojo.bindings.Struct {

        private static final int STRUCT_SIZE = 40;
        private static final org.chromium.mojo.bindings.DataHeader[] VERSION_ARRAY = new org.chromium.mojo.bindings.DataHeader[] {new org.chromium.mojo.bindings.DataHeader(40, 0)};
        private static final org.chromium.mojo.bindings.DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public byte[] key;
        public byte[] newValue;
        public byte[] oldValue;
        public String source;

        private StorageAreaObserverKeyChangedParams(int version) {
            super(STRUCT_SIZE, version);
        }

        public StorageAreaObserverKeyChangedParams() {
            this(0);
        }

        public static StorageAreaObserverKeyChangedParams deserialize(org.chromium.mojo.bindings.Message message) {
            return decode(new org.chromium.mojo.bindings.Decoder(message));
        }

        /**
         * Similar to the method above, but deserializes from a |ByteBuffer| instance.
         *
         * @throws org.chromium.mojo.bindings.DeserializationException on deserialization failure.
         */
        public static StorageAreaObserverKeyChangedParams deserialize(java.nio.ByteBuffer data) {
            return deserialize(new org.chromium.mojo.bindings.Message(
                    data, new java.util.ArrayList<org.chromium.mojo.system.Handle>()));
        }

        @SuppressWarnings("unchecked")
        public static StorageAreaObserverKeyChangedParams decode(org.chromium.mojo.bindings.Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            StorageAreaObserverKeyChangedParams result;
            try {
                org.chromium.mojo.bindings.DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                final int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new StorageAreaObserverKeyChangedParams(elementsOrVersion);
                    {
                        
                    result.key = decoder0.readBytes(8, org.chromium.mojo.bindings.BindingsHelper.NOTHING_NULLABLE, org.chromium.mojo.bindings.BindingsHelper.UNSPECIFIED_ARRAY_LENGTH);
                    }
                    {
                        
                    result.newValue = decoder0.readBytes(16, org.chromium.mojo.bindings.BindingsHelper.NOTHING_NULLABLE, org.chromium.mojo.bindings.BindingsHelper.UNSPECIFIED_ARRAY_LENGTH);
                    }
                    {
                        
                    result.oldValue = decoder0.readBytes(24, org.chromium.mojo.bindings.BindingsHelper.ARRAY_NULLABLE, org.chromium.mojo.bindings.BindingsHelper.UNSPECIFIED_ARRAY_LENGTH);
                    }
                    {
                        
                    result.source = decoder0.readString(32, false);
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
            
            encoder0.encode(this.key, 8, org.chromium.mojo.bindings.BindingsHelper.NOTHING_NULLABLE, org.chromium.mojo.bindings.BindingsHelper.UNSPECIFIED_ARRAY_LENGTH);
            
            encoder0.encode(this.newValue, 16, org.chromium.mojo.bindings.BindingsHelper.NOTHING_NULLABLE, org.chromium.mojo.bindings.BindingsHelper.UNSPECIFIED_ARRAY_LENGTH);
            
            encoder0.encode(this.oldValue, 24, org.chromium.mojo.bindings.BindingsHelper.ARRAY_NULLABLE, org.chromium.mojo.bindings.BindingsHelper.UNSPECIFIED_ARRAY_LENGTH);
            
            encoder0.encode(this.source, 32, false);
        }
    }



    
    static final class StorageAreaObserverKeyChangeFailedParams extends org.chromium.mojo.bindings.Struct {

        private static final int STRUCT_SIZE = 24;
        private static final org.chromium.mojo.bindings.DataHeader[] VERSION_ARRAY = new org.chromium.mojo.bindings.DataHeader[] {new org.chromium.mojo.bindings.DataHeader(24, 0)};
        private static final org.chromium.mojo.bindings.DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public byte[] key;
        public String source;

        private StorageAreaObserverKeyChangeFailedParams(int version) {
            super(STRUCT_SIZE, version);
        }

        public StorageAreaObserverKeyChangeFailedParams() {
            this(0);
        }

        public static StorageAreaObserverKeyChangeFailedParams deserialize(org.chromium.mojo.bindings.Message message) {
            return decode(new org.chromium.mojo.bindings.Decoder(message));
        }

        /**
         * Similar to the method above, but deserializes from a |ByteBuffer| instance.
         *
         * @throws org.chromium.mojo.bindings.DeserializationException on deserialization failure.
         */
        public static StorageAreaObserverKeyChangeFailedParams deserialize(java.nio.ByteBuffer data) {
            return deserialize(new org.chromium.mojo.bindings.Message(
                    data, new java.util.ArrayList<org.chromium.mojo.system.Handle>()));
        }

        @SuppressWarnings("unchecked")
        public static StorageAreaObserverKeyChangeFailedParams decode(org.chromium.mojo.bindings.Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            StorageAreaObserverKeyChangeFailedParams result;
            try {
                org.chromium.mojo.bindings.DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                final int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new StorageAreaObserverKeyChangeFailedParams(elementsOrVersion);
                    {
                        
                    result.key = decoder0.readBytes(8, org.chromium.mojo.bindings.BindingsHelper.NOTHING_NULLABLE, org.chromium.mojo.bindings.BindingsHelper.UNSPECIFIED_ARRAY_LENGTH);
                    }
                    {
                        
                    result.source = decoder0.readString(16, false);
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
            
            encoder0.encode(this.key, 8, org.chromium.mojo.bindings.BindingsHelper.NOTHING_NULLABLE, org.chromium.mojo.bindings.BindingsHelper.UNSPECIFIED_ARRAY_LENGTH);
            
            encoder0.encode(this.source, 16, false);
        }
    }



    
    static final class StorageAreaObserverKeyDeletedParams extends org.chromium.mojo.bindings.Struct {

        private static final int STRUCT_SIZE = 32;
        private static final org.chromium.mojo.bindings.DataHeader[] VERSION_ARRAY = new org.chromium.mojo.bindings.DataHeader[] {new org.chromium.mojo.bindings.DataHeader(32, 0)};
        private static final org.chromium.mojo.bindings.DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public byte[] key;
        public byte[] oldValue;
        public String source;

        private StorageAreaObserverKeyDeletedParams(int version) {
            super(STRUCT_SIZE, version);
        }

        public StorageAreaObserverKeyDeletedParams() {
            this(0);
        }

        public static StorageAreaObserverKeyDeletedParams deserialize(org.chromium.mojo.bindings.Message message) {
            return decode(new org.chromium.mojo.bindings.Decoder(message));
        }

        /**
         * Similar to the method above, but deserializes from a |ByteBuffer| instance.
         *
         * @throws org.chromium.mojo.bindings.DeserializationException on deserialization failure.
         */
        public static StorageAreaObserverKeyDeletedParams deserialize(java.nio.ByteBuffer data) {
            return deserialize(new org.chromium.mojo.bindings.Message(
                    data, new java.util.ArrayList<org.chromium.mojo.system.Handle>()));
        }

        @SuppressWarnings("unchecked")
        public static StorageAreaObserverKeyDeletedParams decode(org.chromium.mojo.bindings.Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            StorageAreaObserverKeyDeletedParams result;
            try {
                org.chromium.mojo.bindings.DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                final int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new StorageAreaObserverKeyDeletedParams(elementsOrVersion);
                    {
                        
                    result.key = decoder0.readBytes(8, org.chromium.mojo.bindings.BindingsHelper.NOTHING_NULLABLE, org.chromium.mojo.bindings.BindingsHelper.UNSPECIFIED_ARRAY_LENGTH);
                    }
                    {
                        
                    result.oldValue = decoder0.readBytes(16, org.chromium.mojo.bindings.BindingsHelper.ARRAY_NULLABLE, org.chromium.mojo.bindings.BindingsHelper.UNSPECIFIED_ARRAY_LENGTH);
                    }
                    {
                        
                    result.source = decoder0.readString(24, false);
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
            
            encoder0.encode(this.key, 8, org.chromium.mojo.bindings.BindingsHelper.NOTHING_NULLABLE, org.chromium.mojo.bindings.BindingsHelper.UNSPECIFIED_ARRAY_LENGTH);
            
            encoder0.encode(this.oldValue, 16, org.chromium.mojo.bindings.BindingsHelper.ARRAY_NULLABLE, org.chromium.mojo.bindings.BindingsHelper.UNSPECIFIED_ARRAY_LENGTH);
            
            encoder0.encode(this.source, 24, false);
        }
    }



    
    static final class StorageAreaObserverAllDeletedParams extends org.chromium.mojo.bindings.Struct {

        private static final int STRUCT_SIZE = 24;
        private static final org.chromium.mojo.bindings.DataHeader[] VERSION_ARRAY = new org.chromium.mojo.bindings.DataHeader[] {new org.chromium.mojo.bindings.DataHeader(24, 0)};
        private static final org.chromium.mojo.bindings.DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public boolean wasNonempty;
        public String source;

        private StorageAreaObserverAllDeletedParams(int version) {
            super(STRUCT_SIZE, version);
        }

        public StorageAreaObserverAllDeletedParams() {
            this(0);
        }

        public static StorageAreaObserverAllDeletedParams deserialize(org.chromium.mojo.bindings.Message message) {
            return decode(new org.chromium.mojo.bindings.Decoder(message));
        }

        /**
         * Similar to the method above, but deserializes from a |ByteBuffer| instance.
         *
         * @throws org.chromium.mojo.bindings.DeserializationException on deserialization failure.
         */
        public static StorageAreaObserverAllDeletedParams deserialize(java.nio.ByteBuffer data) {
            return deserialize(new org.chromium.mojo.bindings.Message(
                    data, new java.util.ArrayList<org.chromium.mojo.system.Handle>()));
        }

        @SuppressWarnings("unchecked")
        public static StorageAreaObserverAllDeletedParams decode(org.chromium.mojo.bindings.Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            StorageAreaObserverAllDeletedParams result;
            try {
                org.chromium.mojo.bindings.DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                final int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new StorageAreaObserverAllDeletedParams(elementsOrVersion);
                    {
                        
                    result.wasNonempty = decoder0.readBoolean(8, 0);
                    }
                    {
                        
                    result.source = decoder0.readString(16, false);
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
            
            encoder0.encode(this.wasNonempty, 8, 0);
            
            encoder0.encode(this.source, 16, false);
        }
    }



    
    static final class StorageAreaObserverShouldSendOldValueOnMutationsParams extends org.chromium.mojo.bindings.Struct {

        private static final int STRUCT_SIZE = 16;
        private static final org.chromium.mojo.bindings.DataHeader[] VERSION_ARRAY = new org.chromium.mojo.bindings.DataHeader[] {new org.chromium.mojo.bindings.DataHeader(16, 0)};
        private static final org.chromium.mojo.bindings.DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public boolean value;

        private StorageAreaObserverShouldSendOldValueOnMutationsParams(int version) {
            super(STRUCT_SIZE, version);
        }

        public StorageAreaObserverShouldSendOldValueOnMutationsParams() {
            this(0);
        }

        public static StorageAreaObserverShouldSendOldValueOnMutationsParams deserialize(org.chromium.mojo.bindings.Message message) {
            return decode(new org.chromium.mojo.bindings.Decoder(message));
        }

        /**
         * Similar to the method above, but deserializes from a |ByteBuffer| instance.
         *
         * @throws org.chromium.mojo.bindings.DeserializationException on deserialization failure.
         */
        public static StorageAreaObserverShouldSendOldValueOnMutationsParams deserialize(java.nio.ByteBuffer data) {
            return deserialize(new org.chromium.mojo.bindings.Message(
                    data, new java.util.ArrayList<org.chromium.mojo.system.Handle>()));
        }

        @SuppressWarnings("unchecked")
        public static StorageAreaObserverShouldSendOldValueOnMutationsParams decode(org.chromium.mojo.bindings.Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            StorageAreaObserverShouldSendOldValueOnMutationsParams result;
            try {
                org.chromium.mojo.bindings.DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                final int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new StorageAreaObserverShouldSendOldValueOnMutationsParams(elementsOrVersion);
                    {
                        
                    result.value = decoder0.readBoolean(8, 0);
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
            
            encoder0.encode(this.value, 8, 0);
        }
    }



}
