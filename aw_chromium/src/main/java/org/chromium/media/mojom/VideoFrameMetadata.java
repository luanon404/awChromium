// VideoFrameMetadata.java is auto generated by mojom_bindings_generator.py, do not edit


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


public final class VideoFrameMetadata extends org.chromium.mojo.bindings.Struct {

    private static final int STRUCT_SIZE = 192;
    private static final org.chromium.mojo.bindings.DataHeader[] VERSION_ARRAY = new org.chromium.mojo.bindings.DataHeader[] {new org.chromium.mojo.bindings.DataHeader(192, 0)};
    private static final org.chromium.mojo.bindings.DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
    public boolean allowOverlay;
    public org.chromium.mojo_base.mojom.TimeTicks captureBeginTime;
    public org.chromium.mojo_base.mojom.TimeTicks captureEndTime;
    public boolean hasCaptureCounter;
    public int captureCounter;
    public org.chromium.gfx.mojom.Rect captureUpdateRect;
    public org.chromium.gfx.mojom.Size sourceSize;
    public org.chromium.gfx.mojom.Rect regionCaptureRect;
    public int cropVersion;
    public boolean copyRequired;
    public boolean endOfStream;
    public org.chromium.mojo_base.mojom.TimeDelta frameDuration;
    public boolean hasFrameRate;
    public double frameRate;
    public boolean interactiveContent;
    public org.chromium.mojo_base.mojom.TimeTicks referenceTime;
    public boolean readLockFencesEnabled;
    public VideoTransformation transformation;
    public boolean textureOwner;
    public boolean wantsPromotionHint;
    public boolean protectedVideo;
    public boolean hwProtected;
    public boolean isWebgpuCompatible;
    public org.chromium.mojo_base.mojom.UnguessableToken overlayPlaneId;
    public boolean powerEfficient;
    public boolean textureOriginIsTopLeft;
    public boolean hasDeviceScaleFactor;
    public double deviceScaleFactor;
    public boolean hasPageScaleFactor;
    public double pageScaleFactor;
    public boolean hasRootScrollOffsetX;
    public double rootScrollOffsetX;
    public boolean hasRootScrollOffsetY;
    public double rootScrollOffsetY;
    public boolean hasTopControlsVisibleHeight;
    public double topControlsVisibleHeight;
    public org.chromium.mojo_base.mojom.TimeTicks decodeBeginTime;
    public org.chromium.mojo_base.mojom.TimeTicks decodeEndTime;
    public org.chromium.mojo_base.mojom.TimeDelta processingTime;
    public boolean hasRtpTimestamp;
    public double rtpTimestamp;
    public org.chromium.mojo_base.mojom.TimeTicks receiveTime;
    public org.chromium.mojo_base.mojom.TimeDelta wallclockFrameDuration;

    private VideoFrameMetadata(int version) {
        super(STRUCT_SIZE, version);
    }

    public VideoFrameMetadata() {
        this(0);
    }

    public static VideoFrameMetadata deserialize(org.chromium.mojo.bindings.Message message) {
        return decode(new org.chromium.mojo.bindings.Decoder(message));
    }

    /**
     * Similar to the method above, but deserializes from a |ByteBuffer| instance.
     *
     * @throws org.chromium.mojo.bindings.DeserializationException on deserialization failure.
     */
    public static VideoFrameMetadata deserialize(java.nio.ByteBuffer data) {
        return deserialize(new org.chromium.mojo.bindings.Message(
                data, new java.util.ArrayList<org.chromium.mojo.system.Handle>()));
    }

    @SuppressWarnings("unchecked")
    public static VideoFrameMetadata decode(org.chromium.mojo.bindings.Decoder decoder0) {
        if (decoder0 == null) {
            return null;
        }
        decoder0.increaseStackDepth();
        VideoFrameMetadata result;
        try {
            org.chromium.mojo.bindings.DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
            final int elementsOrVersion = mainDataHeader.elementsOrVersion;
            result = new VideoFrameMetadata(elementsOrVersion);
                {
                    
                result.allowOverlay = decoder0.readBoolean(8, 0);
                }
                {
                    
                result.hasCaptureCounter = decoder0.readBoolean(8, 1);
                }
                {
                    
                result.copyRequired = decoder0.readBoolean(8, 2);
                }
                {
                    
                result.endOfStream = decoder0.readBoolean(8, 3);
                }
                {
                    
                result.hasFrameRate = decoder0.readBoolean(8, 4);
                }
                {
                    
                result.interactiveContent = decoder0.readBoolean(8, 5);
                }
                {
                    
                result.readLockFencesEnabled = decoder0.readBoolean(8, 6);
                }
                {
                    
                result.textureOwner = decoder0.readBoolean(8, 7);
                }
                {
                    
                result.wantsPromotionHint = decoder0.readBoolean(9, 0);
                }
                {
                    
                result.protectedVideo = decoder0.readBoolean(9, 1);
                }
                {
                    
                result.hwProtected = decoder0.readBoolean(9, 2);
                }
                {
                    
                result.isWebgpuCompatible = decoder0.readBoolean(9, 3);
                }
                {
                    
                result.powerEfficient = decoder0.readBoolean(9, 4);
                }
                {
                    
                result.textureOriginIsTopLeft = decoder0.readBoolean(9, 5);
                }
                {
                    
                result.hasDeviceScaleFactor = decoder0.readBoolean(9, 6);
                }
                {
                    
                result.hasPageScaleFactor = decoder0.readBoolean(9, 7);
                }
                {
                    
                result.hasRootScrollOffsetX = decoder0.readBoolean(10, 0);
                }
                {
                    
                result.hasRootScrollOffsetY = decoder0.readBoolean(10, 1);
                }
                {
                    
                result.hasTopControlsVisibleHeight = decoder0.readBoolean(10, 2);
                }
                {
                    
                result.hasRtpTimestamp = decoder0.readBoolean(10, 3);
                }
                {
                    
                result.captureCounter = decoder0.readInt(12);
                }
                {
                    
                org.chromium.mojo.bindings.Decoder decoder1 = decoder0.readPointer(16, true);
                result.captureBeginTime = org.chromium.mojo_base.mojom.TimeTicks.decode(decoder1);
                }
                {
                    
                org.chromium.mojo.bindings.Decoder decoder1 = decoder0.readPointer(24, true);
                result.captureEndTime = org.chromium.mojo_base.mojom.TimeTicks.decode(decoder1);
                }
                {
                    
                org.chromium.mojo.bindings.Decoder decoder1 = decoder0.readPointer(32, true);
                result.captureUpdateRect = org.chromium.gfx.mojom.Rect.decode(decoder1);
                }
                {
                    
                org.chromium.mojo.bindings.Decoder decoder1 = decoder0.readPointer(40, true);
                result.sourceSize = org.chromium.gfx.mojom.Size.decode(decoder1);
                }
                {
                    
                org.chromium.mojo.bindings.Decoder decoder1 = decoder0.readPointer(48, true);
                result.regionCaptureRect = org.chromium.gfx.mojom.Rect.decode(decoder1);
                }
                {
                    
                result.cropVersion = decoder0.readInt(56);
                }
                {
                    
                org.chromium.mojo.bindings.Decoder decoder1 = decoder0.readPointer(64, true);
                result.frameDuration = org.chromium.mojo_base.mojom.TimeDelta.decode(decoder1);
                }
                {
                    
                result.frameRate = decoder0.readDouble(72);
                }
                {
                    
                org.chromium.mojo.bindings.Decoder decoder1 = decoder0.readPointer(80, true);
                result.referenceTime = org.chromium.mojo_base.mojom.TimeTicks.decode(decoder1);
                }
                {
                    
                org.chromium.mojo.bindings.Decoder decoder1 = decoder0.readPointer(88, true);
                result.transformation = VideoTransformation.decode(decoder1);
                }
                {
                    
                org.chromium.mojo.bindings.Decoder decoder1 = decoder0.readPointer(96, true);
                result.overlayPlaneId = org.chromium.mojo_base.mojom.UnguessableToken.decode(decoder1);
                }
                {
                    
                result.deviceScaleFactor = decoder0.readDouble(104);
                }
                {
                    
                result.pageScaleFactor = decoder0.readDouble(112);
                }
                {
                    
                result.rootScrollOffsetX = decoder0.readDouble(120);
                }
                {
                    
                result.rootScrollOffsetY = decoder0.readDouble(128);
                }
                {
                    
                result.topControlsVisibleHeight = decoder0.readDouble(136);
                }
                {
                    
                org.chromium.mojo.bindings.Decoder decoder1 = decoder0.readPointer(144, true);
                result.decodeBeginTime = org.chromium.mojo_base.mojom.TimeTicks.decode(decoder1);
                }
                {
                    
                org.chromium.mojo.bindings.Decoder decoder1 = decoder0.readPointer(152, true);
                result.decodeEndTime = org.chromium.mojo_base.mojom.TimeTicks.decode(decoder1);
                }
                {
                    
                org.chromium.mojo.bindings.Decoder decoder1 = decoder0.readPointer(160, true);
                result.processingTime = org.chromium.mojo_base.mojom.TimeDelta.decode(decoder1);
                }
                {
                    
                result.rtpTimestamp = decoder0.readDouble(168);
                }
                {
                    
                org.chromium.mojo.bindings.Decoder decoder1 = decoder0.readPointer(176, true);
                result.receiveTime = org.chromium.mojo_base.mojom.TimeTicks.decode(decoder1);
                }
                {
                    
                org.chromium.mojo.bindings.Decoder decoder1 = decoder0.readPointer(184, true);
                result.wallclockFrameDuration = org.chromium.mojo_base.mojom.TimeDelta.decode(decoder1);
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
        
        encoder0.encode(this.allowOverlay, 8, 0);
        
        encoder0.encode(this.hasCaptureCounter, 8, 1);
        
        encoder0.encode(this.copyRequired, 8, 2);
        
        encoder0.encode(this.endOfStream, 8, 3);
        
        encoder0.encode(this.hasFrameRate, 8, 4);
        
        encoder0.encode(this.interactiveContent, 8, 5);
        
        encoder0.encode(this.readLockFencesEnabled, 8, 6);
        
        encoder0.encode(this.textureOwner, 8, 7);
        
        encoder0.encode(this.wantsPromotionHint, 9, 0);
        
        encoder0.encode(this.protectedVideo, 9, 1);
        
        encoder0.encode(this.hwProtected, 9, 2);
        
        encoder0.encode(this.isWebgpuCompatible, 9, 3);
        
        encoder0.encode(this.powerEfficient, 9, 4);
        
        encoder0.encode(this.textureOriginIsTopLeft, 9, 5);
        
        encoder0.encode(this.hasDeviceScaleFactor, 9, 6);
        
        encoder0.encode(this.hasPageScaleFactor, 9, 7);
        
        encoder0.encode(this.hasRootScrollOffsetX, 10, 0);
        
        encoder0.encode(this.hasRootScrollOffsetY, 10, 1);
        
        encoder0.encode(this.hasTopControlsVisibleHeight, 10, 2);
        
        encoder0.encode(this.hasRtpTimestamp, 10, 3);
        
        encoder0.encode(this.captureCounter, 12);
        
        encoder0.encode(this.captureBeginTime, 16, true);
        
        encoder0.encode(this.captureEndTime, 24, true);
        
        encoder0.encode(this.captureUpdateRect, 32, true);
        
        encoder0.encode(this.sourceSize, 40, true);
        
        encoder0.encode(this.regionCaptureRect, 48, true);
        
        encoder0.encode(this.cropVersion, 56);
        
        encoder0.encode(this.frameDuration, 64, true);
        
        encoder0.encode(this.frameRate, 72);
        
        encoder0.encode(this.referenceTime, 80, true);
        
        encoder0.encode(this.transformation, 88, true);
        
        encoder0.encode(this.overlayPlaneId, 96, true);
        
        encoder0.encode(this.deviceScaleFactor, 104);
        
        encoder0.encode(this.pageScaleFactor, 112);
        
        encoder0.encode(this.rootScrollOffsetX, 120);
        
        encoder0.encode(this.rootScrollOffsetY, 128);
        
        encoder0.encode(this.topControlsVisibleHeight, 136);
        
        encoder0.encode(this.decodeBeginTime, 144, true);
        
        encoder0.encode(this.decodeEndTime, 152, true);
        
        encoder0.encode(this.processingTime, 160, true);
        
        encoder0.encode(this.rtpTimestamp, 168);
        
        encoder0.encode(this.receiveTime, 176, true);
        
        encoder0.encode(this.wallclockFrameDuration, 184, true);
    }
}