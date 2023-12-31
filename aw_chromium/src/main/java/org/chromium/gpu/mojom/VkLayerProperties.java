// VkLayerProperties.java is auto generated by mojom_bindings_generator.py, do not edit


// Copyright 2014 The Chromium Authors
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.

// This file is autogenerated by:
//     mojo/public/tools/bindings/mojom_bindings_generator.py
// For:
//     gpu/ipc/common/vulkan_types.mojom
//

package org.chromium.gpu.mojom;

import androidx.annotation.IntDef;


public final class VkLayerProperties extends org.chromium.mojo.bindings.Struct {

    private static final int STRUCT_SIZE = 32;
    private static final org.chromium.mojo.bindings.DataHeader[] VERSION_ARRAY = new org.chromium.mojo.bindings.DataHeader[] {new org.chromium.mojo.bindings.DataHeader(32, 0)};
    private static final org.chromium.mojo.bindings.DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
    public String layerName;
    public int specVersion;
    public int implementationVersion;
    public String description;

    private VkLayerProperties(int version) {
        super(STRUCT_SIZE, version);
    }

    public VkLayerProperties() {
        this(0);
    }

    public static VkLayerProperties deserialize(org.chromium.mojo.bindings.Message message) {
        return decode(new org.chromium.mojo.bindings.Decoder(message));
    }

    /**
     * Similar to the method above, but deserializes from a |ByteBuffer| instance.
     *
     * @throws org.chromium.mojo.bindings.DeserializationException on deserialization failure.
     */
    public static VkLayerProperties deserialize(java.nio.ByteBuffer data) {
        return deserialize(new org.chromium.mojo.bindings.Message(
                data, new java.util.ArrayList<org.chromium.mojo.system.Handle>()));
    }

    @SuppressWarnings("unchecked")
    public static VkLayerProperties decode(org.chromium.mojo.bindings.Decoder decoder0) {
        if (decoder0 == null) {
            return null;
        }
        decoder0.increaseStackDepth();
        VkLayerProperties result;
        try {
            org.chromium.mojo.bindings.DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
            final int elementsOrVersion = mainDataHeader.elementsOrVersion;
            result = new VkLayerProperties(elementsOrVersion);
                {
                    
                result.layerName = decoder0.readString(8, false);
                }
                {
                    
                result.specVersion = decoder0.readInt(16);
                }
                {
                    
                result.implementationVersion = decoder0.readInt(20);
                }
                {
                    
                result.description = decoder0.readString(24, false);
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
        
        encoder0.encode(this.layerName, 8, false);
        
        encoder0.encode(this.specVersion, 16);
        
        encoder0.encode(this.implementationVersion, 20);
        
        encoder0.encode(this.description, 24, false);
    }
}