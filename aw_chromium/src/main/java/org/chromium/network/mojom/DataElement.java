// DataElement.java is auto generated by mojom_bindings_generator.py, do not edit


// Copyright 2014 The Chromium Authors
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.

// This file is autogenerated by:
//     mojo/public/tools/bindings/mojom_bindings_generator.py
// For:
//     services/network/public/mojom/url_request.mojom
//

package org.chromium.network.mojom;

import androidx.annotation.IntDef;


public final class DataElement extends org.chromium.mojo.bindings.Union {

    public static final class Tag {
        public static final int Bytes = 0;
        public static final int File = 1;
        public static final int DataPipe = 2;
        public static final int ChunkedDataPipe = 3;
    };
    private DataElementBytes mBytes;
    private DataElementFile mFile;
    private DataElementDataPipe mDataPipe;
    private DataElementChunkedDataPipe mChunkedDataPipe;

    public void setBytes(DataElementBytes bytes) {
        this.mTag = Tag.Bytes;
        this.mBytes = bytes;
    }

    public DataElementBytes getBytes() {
        assert this.mTag == Tag.Bytes;
        return this.mBytes;
    }

    public void setFile(DataElementFile file) {
        this.mTag = Tag.File;
        this.mFile = file;
    }

    public DataElementFile getFile() {
        assert this.mTag == Tag.File;
        return this.mFile;
    }

    public void setDataPipe(DataElementDataPipe dataPipe) {
        this.mTag = Tag.DataPipe;
        this.mDataPipe = dataPipe;
    }

    public DataElementDataPipe getDataPipe() {
        assert this.mTag == Tag.DataPipe;
        return this.mDataPipe;
    }

    public void setChunkedDataPipe(DataElementChunkedDataPipe chunkedDataPipe) {
        this.mTag = Tag.ChunkedDataPipe;
        this.mChunkedDataPipe = chunkedDataPipe;
    }

    public DataElementChunkedDataPipe getChunkedDataPipe() {
        assert this.mTag == Tag.ChunkedDataPipe;
        return this.mChunkedDataPipe;
    }


    @Override
    protected final void encode(org.chromium.mojo.bindings.Encoder encoder0, int offset) {
        encoder0.encode(org.chromium.mojo.bindings.BindingsHelper.UNION_SIZE, offset);
        encoder0.encode(this.mTag, offset + 4);
        switch (mTag) {
            case Tag.Bytes: {
                
                encoder0.encode(this.mBytes, offset + 8, false);
                break;
            }
            case Tag.File: {
                
                encoder0.encode(this.mFile, offset + 8, false);
                break;
            }
            case Tag.DataPipe: {
                
                encoder0.encode(this.mDataPipe, offset + 8, false);
                break;
            }
            case Tag.ChunkedDataPipe: {
                
                encoder0.encode(this.mChunkedDataPipe, offset + 8, false);
                break;
            }
            default: {
                break;
            }
        }
    }

    public static DataElement deserialize(org.chromium.mojo.bindings.Message message) {
        return decode(new org.chromium.mojo.bindings.Decoder(message).decoderForSerializedUnion(), 0);
    }

    public static final DataElement decode(org.chromium.mojo.bindings.Decoder decoder0, int offset) {
        org.chromium.mojo.bindings.DataHeader dataHeader = decoder0.readDataHeaderForUnion(offset);
        if (dataHeader.size == 0) {
            return null;
        }
        DataElement result = new DataElement();
        switch (dataHeader.elementsOrVersion) {
            case Tag.Bytes: {
                
                org.chromium.mojo.bindings.Decoder decoder1 = decoder0.readPointer(offset + org.chromium.mojo.bindings.DataHeader.HEADER_SIZE, false);
                result.mBytes = DataElementBytes.decode(decoder1);
                result.mTag = Tag.Bytes;
                break;
            }
            case Tag.File: {
                
                org.chromium.mojo.bindings.Decoder decoder1 = decoder0.readPointer(offset + org.chromium.mojo.bindings.DataHeader.HEADER_SIZE, false);
                result.mFile = DataElementFile.decode(decoder1);
                result.mTag = Tag.File;
                break;
            }
            case Tag.DataPipe: {
                
                org.chromium.mojo.bindings.Decoder decoder1 = decoder0.readPointer(offset + org.chromium.mojo.bindings.DataHeader.HEADER_SIZE, false);
                result.mDataPipe = DataElementDataPipe.decode(decoder1);
                result.mTag = Tag.DataPipe;
                break;
            }
            case Tag.ChunkedDataPipe: {
                
                org.chromium.mojo.bindings.Decoder decoder1 = decoder0.readPointer(offset + org.chromium.mojo.bindings.DataHeader.HEADER_SIZE, false);
                result.mChunkedDataPipe = DataElementChunkedDataPipe.decode(decoder1);
                result.mTag = Tag.ChunkedDataPipe;
                break;
            }
            default: {
                break;
            }
        }
        return result;
    }
}