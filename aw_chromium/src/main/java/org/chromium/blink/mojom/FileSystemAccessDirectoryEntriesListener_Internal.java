// FileSystemAccessDirectoryEntriesListener_Internal.java is auto generated by mojom_bindings_generator.py, do not edit


// Copyright 2014 The Chromium Authors
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.

// This file is autogenerated by:
//     mojo/public/tools/bindings/mojom_bindings_generator.py
// For:
//     third_party/blink/public/mojom/file_system_access/file_system_access_directory_handle.mojom
//

package org.chromium.blink.mojom;

import androidx.annotation.IntDef;


class FileSystemAccessDirectoryEntriesListener_Internal {

    public static final org.chromium.mojo.bindings.Interface.Manager<FileSystemAccessDirectoryEntriesListener, FileSystemAccessDirectoryEntriesListener.Proxy> MANAGER =
            new org.chromium.mojo.bindings.Interface.Manager<FileSystemAccessDirectoryEntriesListener, FileSystemAccessDirectoryEntriesListener.Proxy>() {

        @Override
        public String getName() {
            return "blink.mojom.FileSystemAccessDirectoryEntriesListener";
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
        public Stub buildStub(org.chromium.mojo.system.Core core, FileSystemAccessDirectoryEntriesListener impl) {
            return new Stub(core, impl);
        }

        @Override
        public FileSystemAccessDirectoryEntriesListener[] buildArray(int size) {
          return new FileSystemAccessDirectoryEntriesListener[size];
        }
    };


    private static final int DID_READ_DIRECTORY_ORDINAL = 0;


    static final class Proxy extends org.chromium.mojo.bindings.Interface.AbstractProxy implements FileSystemAccessDirectoryEntriesListener.Proxy {

        Proxy(org.chromium.mojo.system.Core core,
              org.chromium.mojo.bindings.MessageReceiverWithResponder messageReceiver) {
            super(core, messageReceiver);
        }


        @Override
        public void didReadDirectory(
FileSystemAccessError result, FileSystemAccessEntry[] entries, boolean hasMoreEntries) {

            FileSystemAccessDirectoryEntriesListenerDidReadDirectoryParams _message = new FileSystemAccessDirectoryEntriesListenerDidReadDirectoryParams();

            _message.result = result;

            _message.entries = entries;

            _message.hasMoreEntries = hasMoreEntries;


            getProxyHandler().getMessageReceiver().accept(
                    _message.serializeWithHeader(
                            getProxyHandler().getCore(),
                            new org.chromium.mojo.bindings.MessageHeader(DID_READ_DIRECTORY_ORDINAL)));

        }


    }

    static final class Stub extends org.chromium.mojo.bindings.Interface.Stub<FileSystemAccessDirectoryEntriesListener> {

        Stub(org.chromium.mojo.system.Core core, FileSystemAccessDirectoryEntriesListener impl) {
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
                                FileSystemAccessDirectoryEntriesListener_Internal.MANAGER, messageWithHeader);





                    case DID_READ_DIRECTORY_ORDINAL: {

                        FileSystemAccessDirectoryEntriesListenerDidReadDirectoryParams data =
                                FileSystemAccessDirectoryEntriesListenerDidReadDirectoryParams.deserialize(messageWithHeader.getPayload());

                        getImpl().didReadDirectory(data.result, data.entries, data.hasMoreEntries);
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
                                getCore(), FileSystemAccessDirectoryEntriesListener_Internal.MANAGER, messageWithHeader, receiver);




                    default:
                        return false;
                }
            } catch (org.chromium.mojo.bindings.DeserializationException e) {
                System.err.println(e.toString());
                return false;
            }
        }
    }


    
    static final class FileSystemAccessDirectoryEntriesListenerDidReadDirectoryParams extends org.chromium.mojo.bindings.Struct {

        private static final int STRUCT_SIZE = 32;
        private static final org.chromium.mojo.bindings.DataHeader[] VERSION_ARRAY = new org.chromium.mojo.bindings.DataHeader[] {new org.chromium.mojo.bindings.DataHeader(32, 0)};
        private static final org.chromium.mojo.bindings.DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public FileSystemAccessError result;
        public FileSystemAccessEntry[] entries;
        public boolean hasMoreEntries;

        private FileSystemAccessDirectoryEntriesListenerDidReadDirectoryParams(int version) {
            super(STRUCT_SIZE, version);
        }

        public FileSystemAccessDirectoryEntriesListenerDidReadDirectoryParams() {
            this(0);
        }

        public static FileSystemAccessDirectoryEntriesListenerDidReadDirectoryParams deserialize(org.chromium.mojo.bindings.Message message) {
            return decode(new org.chromium.mojo.bindings.Decoder(message));
        }

        /**
         * Similar to the method above, but deserializes from a |ByteBuffer| instance.
         *
         * @throws org.chromium.mojo.bindings.DeserializationException on deserialization failure.
         */
        public static FileSystemAccessDirectoryEntriesListenerDidReadDirectoryParams deserialize(java.nio.ByteBuffer data) {
            return deserialize(new org.chromium.mojo.bindings.Message(
                    data, new java.util.ArrayList<org.chromium.mojo.system.Handle>()));
        }

        @SuppressWarnings("unchecked")
        public static FileSystemAccessDirectoryEntriesListenerDidReadDirectoryParams decode(org.chromium.mojo.bindings.Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            FileSystemAccessDirectoryEntriesListenerDidReadDirectoryParams result;
            try {
                org.chromium.mojo.bindings.DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                final int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new FileSystemAccessDirectoryEntriesListenerDidReadDirectoryParams(elementsOrVersion);
                    {
                        
                    org.chromium.mojo.bindings.Decoder decoder1 = decoder0.readPointer(8, false);
                    result.result = FileSystemAccessError.decode(decoder1);
                    }
                    {
                        
                    org.chromium.mojo.bindings.Decoder decoder1 = decoder0.readPointer(16, false);
                    {
                        org.chromium.mojo.bindings.DataHeader si1 = decoder1.readDataHeaderForPointerArray(org.chromium.mojo.bindings.BindingsHelper.UNSPECIFIED_ARRAY_LENGTH);
                        result.entries = new FileSystemAccessEntry[si1.elementsOrVersion];
                        for (int i1 = 0; i1 < si1.elementsOrVersion; ++i1) {
                            
                            org.chromium.mojo.bindings.Decoder decoder2 = decoder1.readPointer(org.chromium.mojo.bindings.DataHeader.HEADER_SIZE + org.chromium.mojo.bindings.BindingsHelper.POINTER_SIZE * i1, false);
                            result.entries[i1] = FileSystemAccessEntry.decode(decoder2);
                        }
                    }
                    }
                    {
                        
                    result.hasMoreEntries = decoder0.readBoolean(24, 0);
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
            
            encoder0.encode(this.result, 8, false);
            
            if (this.entries == null) {
                encoder0.encodeNullPointer(16, false);
            } else {
                org.chromium.mojo.bindings.Encoder encoder1 = encoder0.encodePointerArray(this.entries.length, 16, org.chromium.mojo.bindings.BindingsHelper.UNSPECIFIED_ARRAY_LENGTH);
                for (int i0 = 0; i0 < this.entries.length; ++i0) {
                    
                    encoder1.encode(this.entries[i0], org.chromium.mojo.bindings.DataHeader.HEADER_SIZE + org.chromium.mojo.bindings.BindingsHelper.POINTER_SIZE * i0, false);
                }
            }
            
            encoder0.encode(this.hasMoreEntries, 24, 0);
        }
    }



}
