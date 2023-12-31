// FencedFrameProperties.java is auto generated by mojom_bindings_generator.py, do not edit


// Copyright 2014 The Chromium Authors
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.

// This file is autogenerated by:
//     mojo/public/tools/bindings/mojom_bindings_generator.py
// For:
//     third_party/blink/public/mojom/fenced_frame/fenced_frame_config.mojom
//

package org.chromium.blink.mojom;

import androidx.annotation.IntDef;


public final class FencedFrameProperties extends org.chromium.mojo.bindings.Struct {

    private static final int STRUCT_SIZE = 136;
    private static final org.chromium.mojo.bindings.DataHeader[] VERSION_ARRAY = new org.chromium.mojo.bindings.DataHeader[] {new org.chromium.mojo.bindings.DataHeader(136, 0)};
    private static final org.chromium.mojo.bindings.DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
    public PotentiallyOpaqueUrl mappedUrl;
    public PotentiallyOpaqueSize containerSize;
    public PotentiallyOpaqueSize contentSize;
    public PotentiallyOpaqueBool deprecatedShouldFreezeInitialSize;
    public PotentiallyOpaqueAdAuctionData adAuctionData;
    public PotentiallyOpaqueUrnConfigVector nestedUrnConfigPairs;
    public PotentiallyOpaqueSharedStorageBudgetMetadata sharedStorageBudgetMetadata;
    public boolean hasFencedFrameReporting;
    public int mode;
    public int[] effectiveEnabledPermissions;

    private FencedFrameProperties(int version) {
        super(STRUCT_SIZE, version);
    }

    public FencedFrameProperties() {
        this(0);
    }

    public static FencedFrameProperties deserialize(org.chromium.mojo.bindings.Message message) {
        return decode(new org.chromium.mojo.bindings.Decoder(message));
    }

    /**
     * Similar to the method above, but deserializes from a |ByteBuffer| instance.
     *
     * @throws org.chromium.mojo.bindings.DeserializationException on deserialization failure.
     */
    public static FencedFrameProperties deserialize(java.nio.ByteBuffer data) {
        return deserialize(new org.chromium.mojo.bindings.Message(
                data, new java.util.ArrayList<org.chromium.mojo.system.Handle>()));
    }

    @SuppressWarnings("unchecked")
    public static FencedFrameProperties decode(org.chromium.mojo.bindings.Decoder decoder0) {
        if (decoder0 == null) {
            return null;
        }
        decoder0.increaseStackDepth();
        FencedFrameProperties result;
        try {
            org.chromium.mojo.bindings.DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
            final int elementsOrVersion = mainDataHeader.elementsOrVersion;
            result = new FencedFrameProperties(elementsOrVersion);
                {
                    
                result.mappedUrl = PotentiallyOpaqueUrl.decode(decoder0, 8);
                }
                {
                    
                result.containerSize = PotentiallyOpaqueSize.decode(decoder0, 24);
                }
                {
                    
                result.contentSize = PotentiallyOpaqueSize.decode(decoder0, 40);
                }
                {
                    
                result.deprecatedShouldFreezeInitialSize = PotentiallyOpaqueBool.decode(decoder0, 56);
                }
                {
                    
                result.adAuctionData = PotentiallyOpaqueAdAuctionData.decode(decoder0, 72);
                }
                {
                    
                result.nestedUrnConfigPairs = PotentiallyOpaqueUrnConfigVector.decode(decoder0, 88);
                }
                {
                    
                result.sharedStorageBudgetMetadata = PotentiallyOpaqueSharedStorageBudgetMetadata.decode(decoder0, 104);
                }
                {
                    
                result.hasFencedFrameReporting = decoder0.readBoolean(120, 0);
                }
                {
                    
                result.mode = decoder0.readInt(124);
                    DeprecatedFencedFrameMode.validate(result.mode);
                    result.mode = DeprecatedFencedFrameMode.toKnownValue(result.mode);
                }
                {
                    
                result.effectiveEnabledPermissions = decoder0.readInts(128, org.chromium.mojo.bindings.BindingsHelper.NOTHING_NULLABLE, org.chromium.mojo.bindings.BindingsHelper.UNSPECIFIED_ARRAY_LENGTH);
                {
                    for (int i1 = 0; i1 < result.effectiveEnabledPermissions.length; ++i1) {
                        PermissionsPolicyFeature.validate(result.effectiveEnabledPermissions[i1]);
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
        
        encoder0.encode(this.mappedUrl, 8, true);
        
        encoder0.encode(this.containerSize, 24, true);
        
        encoder0.encode(this.contentSize, 40, true);
        
        encoder0.encode(this.deprecatedShouldFreezeInitialSize, 56, true);
        
        encoder0.encode(this.adAuctionData, 72, true);
        
        encoder0.encode(this.nestedUrnConfigPairs, 88, true);
        
        encoder0.encode(this.sharedStorageBudgetMetadata, 104, true);
        
        encoder0.encode(this.hasFencedFrameReporting, 120, 0);
        
        encoder0.encode(this.mode, 124);
        
        encoder0.encode(this.effectiveEnabledPermissions, 128, org.chromium.mojo.bindings.BindingsHelper.NOTHING_NULLABLE, org.chromium.mojo.bindings.BindingsHelper.UNSPECIFIED_ARRAY_LENGTH);
    }
}