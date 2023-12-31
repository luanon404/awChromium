// VideoFrameData.java is auto generated by mojom_bindings_generator.py, do not edit


// Copyright 2014 The Chromium Authors
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.

// This file is autogenerated by:
//     mojo/public/tools/bindings/mojom_bindings_generator.py
// For:
//     media/mojo/mojom/media_types.mojom
//

package org.chromium.media.mojom;

import androidx.annotation.IntDef;


public final class VideoFrameData extends org.chromium.mojo.bindings.Union {

    public static final class Tag {
        public static final int EosData = 0;
        public static final int SharedMemoryData = 1;
        public static final int GpuMemoryBufferData = 2;
        public static final int MailboxData = 3;
    };
    private EosVideoFrameData mEosData;
    private SharedMemoryVideoFrameData mSharedMemoryData;
    private GpuMemoryBufferVideoFrameData mGpuMemoryBufferData;
    private MailboxVideoFrameData mMailboxData;

    public void setEosData(EosVideoFrameData eosData) {
        this.mTag = Tag.EosData;
        this.mEosData = eosData;
    }

    public EosVideoFrameData getEosData() {
        assert this.mTag == Tag.EosData;
        return this.mEosData;
    }

    public void setSharedMemoryData(SharedMemoryVideoFrameData sharedMemoryData) {
        this.mTag = Tag.SharedMemoryData;
        this.mSharedMemoryData = sharedMemoryData;
    }

    public SharedMemoryVideoFrameData getSharedMemoryData() {
        assert this.mTag == Tag.SharedMemoryData;
        return this.mSharedMemoryData;
    }

    public void setGpuMemoryBufferData(GpuMemoryBufferVideoFrameData gpuMemoryBufferData) {
        this.mTag = Tag.GpuMemoryBufferData;
        this.mGpuMemoryBufferData = gpuMemoryBufferData;
    }

    public GpuMemoryBufferVideoFrameData getGpuMemoryBufferData() {
        assert this.mTag == Tag.GpuMemoryBufferData;
        return this.mGpuMemoryBufferData;
    }

    public void setMailboxData(MailboxVideoFrameData mailboxData) {
        this.mTag = Tag.MailboxData;
        this.mMailboxData = mailboxData;
    }

    public MailboxVideoFrameData getMailboxData() {
        assert this.mTag == Tag.MailboxData;
        return this.mMailboxData;
    }


    @Override
    protected final void encode(org.chromium.mojo.bindings.Encoder encoder0, int offset) {
        encoder0.encode(org.chromium.mojo.bindings.BindingsHelper.UNION_SIZE, offset);
        encoder0.encode(this.mTag, offset + 4);
        switch (mTag) {
            case Tag.EosData: {
                
                encoder0.encode(this.mEosData, offset + 8, false);
                break;
            }
            case Tag.SharedMemoryData: {
                
                encoder0.encode(this.mSharedMemoryData, offset + 8, false);
                break;
            }
            case Tag.GpuMemoryBufferData: {
                
                encoder0.encode(this.mGpuMemoryBufferData, offset + 8, false);
                break;
            }
            case Tag.MailboxData: {
                
                encoder0.encode(this.mMailboxData, offset + 8, false);
                break;
            }
            default: {
                break;
            }
        }
    }

    public static VideoFrameData deserialize(org.chromium.mojo.bindings.Message message) {
        return decode(new org.chromium.mojo.bindings.Decoder(message).decoderForSerializedUnion(), 0);
    }

    public static final VideoFrameData decode(org.chromium.mojo.bindings.Decoder decoder0, int offset) {
        org.chromium.mojo.bindings.DataHeader dataHeader = decoder0.readDataHeaderForUnion(offset);
        if (dataHeader.size == 0) {
            return null;
        }
        VideoFrameData result = new VideoFrameData();
        switch (dataHeader.elementsOrVersion) {
            case Tag.EosData: {
                
                org.chromium.mojo.bindings.Decoder decoder1 = decoder0.readPointer(offset + org.chromium.mojo.bindings.DataHeader.HEADER_SIZE, false);
                result.mEosData = EosVideoFrameData.decode(decoder1);
                result.mTag = Tag.EosData;
                break;
            }
            case Tag.SharedMemoryData: {
                
                org.chromium.mojo.bindings.Decoder decoder1 = decoder0.readPointer(offset + org.chromium.mojo.bindings.DataHeader.HEADER_SIZE, false);
                result.mSharedMemoryData = SharedMemoryVideoFrameData.decode(decoder1);
                result.mTag = Tag.SharedMemoryData;
                break;
            }
            case Tag.GpuMemoryBufferData: {
                
                org.chromium.mojo.bindings.Decoder decoder1 = decoder0.readPointer(offset + org.chromium.mojo.bindings.DataHeader.HEADER_SIZE, false);
                result.mGpuMemoryBufferData = GpuMemoryBufferVideoFrameData.decode(decoder1);
                result.mTag = Tag.GpuMemoryBufferData;
                break;
            }
            case Tag.MailboxData: {
                
                org.chromium.mojo.bindings.Decoder decoder1 = decoder0.readPointer(offset + org.chromium.mojo.bindings.DataHeader.HEADER_SIZE, false);
                result.mMailboxData = MailboxVideoFrameData.decode(decoder1);
                result.mTag = Tag.MailboxData;
                break;
            }
            default: {
                break;
            }
        }
        return result;
    }
}