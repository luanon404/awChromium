// VideoFrameInfo.java is auto generated by mojom_bindings_generator.py, do not edit


// Copyright 2014 The Chromium Authors
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.

// This file is autogenerated by:
//     mojo/public/tools/bindings/mojom_bindings_generator.py
// For:
//     media/capture/mojom/video_capture_buffer.mojom
//

package org.chromium.media.mojom;

import androidx.annotation.IntDef;


public final class VideoFrameInfo extends org.chromium.mojo.bindings.Struct {

    private static final int STRUCT_SIZE = 64;
    private static final org.chromium.mojo.bindings.DataHeader[] VERSION_ARRAY = new org.chromium.mojo.bindings.DataHeader[] {new org.chromium.mojo.bindings.DataHeader(64, 0)};
    private static final org.chromium.mojo.bindings.DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
    public org.chromium.mojo_base.mojom.TimeDelta timestamp;
    public VideoFrameMetadata metadata;
    public int pixelFormat;
    public org.chromium.gfx.mojom.Size codedSize;
    public org.chromium.gfx.mojom.Rect visibleRect;
    public boolean isPremapped;
    public org.chromium.gfx.mojom.ColorSpace colorSpace;
    public PlaneStrides strides;

    private VideoFrameInfo(int version) {
        super(STRUCT_SIZE, version);
    }

    public VideoFrameInfo() {
        this(0);
    }

    public static VideoFrameInfo deserialize(org.chromium.mojo.bindings.Message message) {
        return decode(new org.chromium.mojo.bindings.Decoder(message));
    }

    /**
     * Similar to the method above, but deserializes from a |ByteBuffer| instance.
     *
     * @throws org.chromium.mojo.bindings.DeserializationException on deserialization failure.
     */
    public static VideoFrameInfo deserialize(java.nio.ByteBuffer data) {
        return deserialize(new org.chromium.mojo.bindings.Message(
                data, new java.util.ArrayList<org.chromium.mojo.system.Handle>()));
    }

    @SuppressWarnings("unchecked")
    public static VideoFrameInfo decode(org.chromium.mojo.bindings.Decoder decoder0) {
        if (decoder0 == null) {
            return null;
        }
        decoder0.increaseStackDepth();
        VideoFrameInfo result;
        try {
            org.chromium.mojo.bindings.DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
            final int elementsOrVersion = mainDataHeader.elementsOrVersion;
            result = new VideoFrameInfo(elementsOrVersion);
                {
                    
                org.chromium.mojo.bindings.Decoder decoder1 = decoder0.readPointer(8, false);
                result.timestamp = org.chromium.mojo_base.mojom.TimeDelta.decode(decoder1);
                }
                {
                    
                org.chromium.mojo.bindings.Decoder decoder1 = decoder0.readPointer(16, false);
                result.metadata = VideoFrameMetadata.decode(decoder1);
                }
                {
                    
                result.pixelFormat = decoder0.readInt(24);
                    VideoCapturePixelFormat.validate(result.pixelFormat);
                    result.pixelFormat = VideoCapturePixelFormat.toKnownValue(result.pixelFormat);
                }
                {
                    
                result.isPremapped = decoder0.readBoolean(28, 0);
                }
                {
                    
                org.chromium.mojo.bindings.Decoder decoder1 = decoder0.readPointer(32, false);
                result.codedSize = org.chromium.gfx.mojom.Size.decode(decoder1);
                }
                {
                    
                org.chromium.mojo.bindings.Decoder decoder1 = decoder0.readPointer(40, false);
                result.visibleRect = org.chromium.gfx.mojom.Rect.decode(decoder1);
                }
                {
                    
                org.chromium.mojo.bindings.Decoder decoder1 = decoder0.readPointer(48, false);
                result.colorSpace = org.chromium.gfx.mojom.ColorSpace.decode(decoder1);
                }
                {
                    
                org.chromium.mojo.bindings.Decoder decoder1 = decoder0.readPointer(56, true);
                result.strides = PlaneStrides.decode(decoder1);
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
        
        encoder0.encode(this.timestamp, 8, false);
        
        encoder0.encode(this.metadata, 16, false);
        
        encoder0.encode(this.pixelFormat, 24);
        
        encoder0.encode(this.isPremapped, 28, 0);
        
        encoder0.encode(this.codedSize, 32, false);
        
        encoder0.encode(this.visibleRect, 40, false);
        
        encoder0.encode(this.colorSpace, 48, false);
        
        encoder0.encode(this.strides, 56, true);
    }
}