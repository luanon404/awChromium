// CompositorFrameMetadata.java is auto generated by mojom_bindings_generator.py, do not edit


// Copyright 2014 The Chromium Authors
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.

// This file is autogenerated by:
//     mojo/public/tools/bindings/mojom_bindings_generator.py
// For:
//     services/viz/public/mojom/compositing/compositor_frame_metadata.mojom
//

package org.chromium.viz.mojom;

import androidx.annotation.IntDef;


public final class CompositorFrameMetadata extends org.chromium.mojo.bindings.Struct {

    private static final int STRUCT_SIZE = 136;
    private static final org.chromium.mojo.bindings.DataHeader[] VERSION_ARRAY = new org.chromium.mojo.bindings.DataHeader[] {new org.chromium.mojo.bindings.DataHeader(136, 0)};
    private static final org.chromium.mojo.bindings.DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
    public float deviceScaleFactor;
    public org.chromium.gfx.mojom.PointF rootScrollOffset;
    public float pageScaleFactor;
    public org.chromium.gfx.mojom.SizeF scrollableViewportSize;
    public int contentColorUsage;
    public boolean mayContainVideo;
    public boolean mayThrottleIfUndrawnFrames;
    public boolean isResourcelessSoftwareDrawWithScrollOrAnimation;
    public boolean isHandlingInteraction;
    public org.chromium.skia.mojom.SkColor4f rootBackgroundColor;
    public org.chromium.ui.mojom.LatencyInfo[] latencyInfo;
    public SurfaceRange[] referencedSurfaces;
    public FrameDeadline deadline;
    public SurfaceId[] activationDependencies;
    public BeginFrameAck beginFrameAck;
    public int frameToken;
    public boolean sendFrameTokenToEmbedder;
    public boolean topControlsVisibleHeightSet;
    public float topControlsVisibleHeight;
    public float minPageScaleFactor;
    public org.chromium.mojo_base.mojom.TimeDelta preferredFrameInterval;
    public int displayTransformHint;
    public org.chromium.gfx.mojom.DelegatedInkMetadata delegatedInkMetadata;
    public CompositorFrameTransitionDirective[] transitionDirectives;
    public RegionCaptureBounds captureBounds;
    public boolean hasSharedElementResources;

    private CompositorFrameMetadata(int version) {
        super(STRUCT_SIZE, version);
    }

    public CompositorFrameMetadata() {
        this(0);
    }

    public static CompositorFrameMetadata deserialize(org.chromium.mojo.bindings.Message message) {
        return decode(new org.chromium.mojo.bindings.Decoder(message));
    }

    /**
     * Similar to the method above, but deserializes from a |ByteBuffer| instance.
     *
     * @throws org.chromium.mojo.bindings.DeserializationException on deserialization failure.
     */
    public static CompositorFrameMetadata deserialize(java.nio.ByteBuffer data) {
        return deserialize(new org.chromium.mojo.bindings.Message(
                data, new java.util.ArrayList<org.chromium.mojo.system.Handle>()));
    }

    @SuppressWarnings("unchecked")
    public static CompositorFrameMetadata decode(org.chromium.mojo.bindings.Decoder decoder0) {
        if (decoder0 == null) {
            return null;
        }
        decoder0.increaseStackDepth();
        CompositorFrameMetadata result;
        try {
            org.chromium.mojo.bindings.DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
            final int elementsOrVersion = mainDataHeader.elementsOrVersion;
            result = new CompositorFrameMetadata(elementsOrVersion);
                {
                    
                result.deviceScaleFactor = decoder0.readFloat(8);
                }
                {
                    
                result.pageScaleFactor = decoder0.readFloat(12);
                }
                {
                    
                org.chromium.mojo.bindings.Decoder decoder1 = decoder0.readPointer(16, false);
                result.rootScrollOffset = org.chromium.gfx.mojom.PointF.decode(decoder1);
                }
                {
                    
                org.chromium.mojo.bindings.Decoder decoder1 = decoder0.readPointer(24, false);
                result.scrollableViewportSize = org.chromium.gfx.mojom.SizeF.decode(decoder1);
                }
                {
                    
                result.contentColorUsage = decoder0.readInt(32);
                    org.chromium.gfx.mojom.ContentColorUsage.validate(result.contentColorUsage);
                    result.contentColorUsage = org.chromium.gfx.mojom.ContentColorUsage.toKnownValue(result.contentColorUsage);
                }
                {
                    
                result.mayContainVideo = decoder0.readBoolean(36, 0);
                }
                {
                    
                result.mayThrottleIfUndrawnFrames = decoder0.readBoolean(36, 1);
                }
                {
                    
                result.isResourcelessSoftwareDrawWithScrollOrAnimation = decoder0.readBoolean(36, 2);
                }
                {
                    
                result.isHandlingInteraction = decoder0.readBoolean(36, 3);
                }
                {
                    
                result.sendFrameTokenToEmbedder = decoder0.readBoolean(36, 4);
                }
                {
                    
                result.topControlsVisibleHeightSet = decoder0.readBoolean(36, 5);
                }
                {
                    
                result.hasSharedElementResources = decoder0.readBoolean(36, 6);
                }
                {
                    
                org.chromium.mojo.bindings.Decoder decoder1 = decoder0.readPointer(40, false);
                result.rootBackgroundColor = org.chromium.skia.mojom.SkColor4f.decode(decoder1);
                }
                {
                    
                org.chromium.mojo.bindings.Decoder decoder1 = decoder0.readPointer(48, false);
                {
                    org.chromium.mojo.bindings.DataHeader si1 = decoder1.readDataHeaderForPointerArray(org.chromium.mojo.bindings.BindingsHelper.UNSPECIFIED_ARRAY_LENGTH);
                    result.latencyInfo = new org.chromium.ui.mojom.LatencyInfo[si1.elementsOrVersion];
                    for (int i1 = 0; i1 < si1.elementsOrVersion; ++i1) {
                        
                        org.chromium.mojo.bindings.Decoder decoder2 = decoder1.readPointer(org.chromium.mojo.bindings.DataHeader.HEADER_SIZE + org.chromium.mojo.bindings.BindingsHelper.POINTER_SIZE * i1, false);
                        result.latencyInfo[i1] = org.chromium.ui.mojom.LatencyInfo.decode(decoder2);
                    }
                }
                }
                {
                    
                org.chromium.mojo.bindings.Decoder decoder1 = decoder0.readPointer(56, false);
                {
                    org.chromium.mojo.bindings.DataHeader si1 = decoder1.readDataHeaderForPointerArray(org.chromium.mojo.bindings.BindingsHelper.UNSPECIFIED_ARRAY_LENGTH);
                    result.referencedSurfaces = new SurfaceRange[si1.elementsOrVersion];
                    for (int i1 = 0; i1 < si1.elementsOrVersion; ++i1) {
                        
                        org.chromium.mojo.bindings.Decoder decoder2 = decoder1.readPointer(org.chromium.mojo.bindings.DataHeader.HEADER_SIZE + org.chromium.mojo.bindings.BindingsHelper.POINTER_SIZE * i1, false);
                        result.referencedSurfaces[i1] = SurfaceRange.decode(decoder2);
                    }
                }
                }
                {
                    
                org.chromium.mojo.bindings.Decoder decoder1 = decoder0.readPointer(64, false);
                result.deadline = FrameDeadline.decode(decoder1);
                }
                {
                    
                org.chromium.mojo.bindings.Decoder decoder1 = decoder0.readPointer(72, false);
                {
                    org.chromium.mojo.bindings.DataHeader si1 = decoder1.readDataHeaderForPointerArray(org.chromium.mojo.bindings.BindingsHelper.UNSPECIFIED_ARRAY_LENGTH);
                    result.activationDependencies = new SurfaceId[si1.elementsOrVersion];
                    for (int i1 = 0; i1 < si1.elementsOrVersion; ++i1) {
                        
                        org.chromium.mojo.bindings.Decoder decoder2 = decoder1.readPointer(org.chromium.mojo.bindings.DataHeader.HEADER_SIZE + org.chromium.mojo.bindings.BindingsHelper.POINTER_SIZE * i1, false);
                        result.activationDependencies[i1] = SurfaceId.decode(decoder2);
                    }
                }
                }
                {
                    
                org.chromium.mojo.bindings.Decoder decoder1 = decoder0.readPointer(80, false);
                result.beginFrameAck = BeginFrameAck.decode(decoder1);
                }
                {
                    
                result.frameToken = decoder0.readInt(88);
                }
                {
                    
                result.topControlsVisibleHeight = decoder0.readFloat(92);
                }
                {
                    
                result.minPageScaleFactor = decoder0.readFloat(96);
                }
                {
                    
                result.displayTransformHint = decoder0.readInt(100);
                    org.chromium.gfx.mojom.OverlayTransform.validate(result.displayTransformHint);
                    result.displayTransformHint = org.chromium.gfx.mojom.OverlayTransform.toKnownValue(result.displayTransformHint);
                }
                {
                    
                org.chromium.mojo.bindings.Decoder decoder1 = decoder0.readPointer(104, true);
                result.preferredFrameInterval = org.chromium.mojo_base.mojom.TimeDelta.decode(decoder1);
                }
                {
                    
                org.chromium.mojo.bindings.Decoder decoder1 = decoder0.readPointer(112, true);
                result.delegatedInkMetadata = org.chromium.gfx.mojom.DelegatedInkMetadata.decode(decoder1);
                }
                {
                    
                org.chromium.mojo.bindings.Decoder decoder1 = decoder0.readPointer(120, false);
                {
                    org.chromium.mojo.bindings.DataHeader si1 = decoder1.readDataHeaderForPointerArray(org.chromium.mojo.bindings.BindingsHelper.UNSPECIFIED_ARRAY_LENGTH);
                    result.transitionDirectives = new CompositorFrameTransitionDirective[si1.elementsOrVersion];
                    for (int i1 = 0; i1 < si1.elementsOrVersion; ++i1) {
                        
                        org.chromium.mojo.bindings.Decoder decoder2 = decoder1.readPointer(org.chromium.mojo.bindings.DataHeader.HEADER_SIZE + org.chromium.mojo.bindings.BindingsHelper.POINTER_SIZE * i1, false);
                        result.transitionDirectives[i1] = CompositorFrameTransitionDirective.decode(decoder2);
                    }
                }
                }
                {
                    
                org.chromium.mojo.bindings.Decoder decoder1 = decoder0.readPointer(128, false);
                result.captureBounds = RegionCaptureBounds.decode(decoder1);
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
        
        encoder0.encode(this.deviceScaleFactor, 8);
        
        encoder0.encode(this.pageScaleFactor, 12);
        
        encoder0.encode(this.rootScrollOffset, 16, false);
        
        encoder0.encode(this.scrollableViewportSize, 24, false);
        
        encoder0.encode(this.contentColorUsage, 32);
        
        encoder0.encode(this.mayContainVideo, 36, 0);
        
        encoder0.encode(this.mayThrottleIfUndrawnFrames, 36, 1);
        
        encoder0.encode(this.isResourcelessSoftwareDrawWithScrollOrAnimation, 36, 2);
        
        encoder0.encode(this.isHandlingInteraction, 36, 3);
        
        encoder0.encode(this.sendFrameTokenToEmbedder, 36, 4);
        
        encoder0.encode(this.topControlsVisibleHeightSet, 36, 5);
        
        encoder0.encode(this.hasSharedElementResources, 36, 6);
        
        encoder0.encode(this.rootBackgroundColor, 40, false);
        
        if (this.latencyInfo == null) {
            encoder0.encodeNullPointer(48, false);
        } else {
            org.chromium.mojo.bindings.Encoder encoder1 = encoder0.encodePointerArray(this.latencyInfo.length, 48, org.chromium.mojo.bindings.BindingsHelper.UNSPECIFIED_ARRAY_LENGTH);
            for (int i0 = 0; i0 < this.latencyInfo.length; ++i0) {
                
                encoder1.encode(this.latencyInfo[i0], org.chromium.mojo.bindings.DataHeader.HEADER_SIZE + org.chromium.mojo.bindings.BindingsHelper.POINTER_SIZE * i0, false);
            }
        }
        
        if (this.referencedSurfaces == null) {
            encoder0.encodeNullPointer(56, false);
        } else {
            org.chromium.mojo.bindings.Encoder encoder1 = encoder0.encodePointerArray(this.referencedSurfaces.length, 56, org.chromium.mojo.bindings.BindingsHelper.UNSPECIFIED_ARRAY_LENGTH);
            for (int i0 = 0; i0 < this.referencedSurfaces.length; ++i0) {
                
                encoder1.encode(this.referencedSurfaces[i0], org.chromium.mojo.bindings.DataHeader.HEADER_SIZE + org.chromium.mojo.bindings.BindingsHelper.POINTER_SIZE * i0, false);
            }
        }
        
        encoder0.encode(this.deadline, 64, false);
        
        if (this.activationDependencies == null) {
            encoder0.encodeNullPointer(72, false);
        } else {
            org.chromium.mojo.bindings.Encoder encoder1 = encoder0.encodePointerArray(this.activationDependencies.length, 72, org.chromium.mojo.bindings.BindingsHelper.UNSPECIFIED_ARRAY_LENGTH);
            for (int i0 = 0; i0 < this.activationDependencies.length; ++i0) {
                
                encoder1.encode(this.activationDependencies[i0], org.chromium.mojo.bindings.DataHeader.HEADER_SIZE + org.chromium.mojo.bindings.BindingsHelper.POINTER_SIZE * i0, false);
            }
        }
        
        encoder0.encode(this.beginFrameAck, 80, false);
        
        encoder0.encode(this.frameToken, 88);
        
        encoder0.encode(this.topControlsVisibleHeight, 92);
        
        encoder0.encode(this.minPageScaleFactor, 96);
        
        encoder0.encode(this.displayTransformHint, 100);
        
        encoder0.encode(this.preferredFrameInterval, 104, true);
        
        encoder0.encode(this.delegatedInkMetadata, 112, true);
        
        if (this.transitionDirectives == null) {
            encoder0.encodeNullPointer(120, false);
        } else {
            org.chromium.mojo.bindings.Encoder encoder1 = encoder0.encodePointerArray(this.transitionDirectives.length, 120, org.chromium.mojo.bindings.BindingsHelper.UNSPECIFIED_ARRAY_LENGTH);
            for (int i0 = 0; i0 < this.transitionDirectives.length; ++i0) {
                
                encoder1.encode(this.transitionDirectives[i0], org.chromium.mojo.bindings.DataHeader.HEADER_SIZE + org.chromium.mojo.bindings.BindingsHelper.POINTER_SIZE * i0, false);
            }
        }
        
        encoder0.encode(this.captureBounds, 128, false);
    }
}