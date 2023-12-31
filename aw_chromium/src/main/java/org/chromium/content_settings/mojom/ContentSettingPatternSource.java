// ContentSettingPatternSource.java is auto generated by mojom_bindings_generator.py, do not edit


// Copyright 2014 The Chromium Authors
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.

// This file is autogenerated by:
//     mojo/public/tools/bindings/mojom_bindings_generator.py
// For:
//     components/content_settings/core/common/content_settings.mojom
//

package org.chromium.content_settings.mojom;

import androidx.annotation.IntDef;


public final class ContentSettingPatternSource extends org.chromium.mojo.bindings.Struct {

    private static final int STRUCT_SIZE = 64;
    private static final org.chromium.mojo.bindings.DataHeader[] VERSION_ARRAY = new org.chromium.mojo.bindings.DataHeader[] {new org.chromium.mojo.bindings.DataHeader(64, 0)};
    private static final org.chromium.mojo.bindings.DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
    public ContentSettingsPattern primaryPattern;
    public ContentSettingsPattern secondaryPattern;
    public org.chromium.mojo_base.mojom.Value settingValue;
    public RuleMetaData metadata;
    public String source;
    public boolean incognito;

    private ContentSettingPatternSource(int version) {
        super(STRUCT_SIZE, version);
    }

    public ContentSettingPatternSource() {
        this(0);
    }

    public static ContentSettingPatternSource deserialize(org.chromium.mojo.bindings.Message message) {
        return decode(new org.chromium.mojo.bindings.Decoder(message));
    }

    /**
     * Similar to the method above, but deserializes from a |ByteBuffer| instance.
     *
     * @throws org.chromium.mojo.bindings.DeserializationException on deserialization failure.
     */
    public static ContentSettingPatternSource deserialize(java.nio.ByteBuffer data) {
        return deserialize(new org.chromium.mojo.bindings.Message(
                data, new java.util.ArrayList<org.chromium.mojo.system.Handle>()));
    }

    @SuppressWarnings("unchecked")
    public static ContentSettingPatternSource decode(org.chromium.mojo.bindings.Decoder decoder0) {
        if (decoder0 == null) {
            return null;
        }
        decoder0.increaseStackDepth();
        ContentSettingPatternSource result;
        try {
            org.chromium.mojo.bindings.DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
            final int elementsOrVersion = mainDataHeader.elementsOrVersion;
            result = new ContentSettingPatternSource(elementsOrVersion);
                {
                    
                org.chromium.mojo.bindings.Decoder decoder1 = decoder0.readPointer(8, false);
                result.primaryPattern = ContentSettingsPattern.decode(decoder1);
                }
                {
                    
                org.chromium.mojo.bindings.Decoder decoder1 = decoder0.readPointer(16, false);
                result.secondaryPattern = ContentSettingsPattern.decode(decoder1);
                }
                {
                    
                result.settingValue = org.chromium.mojo_base.mojom.Value.decode(decoder0, 24);
                }
                {
                    
                org.chromium.mojo.bindings.Decoder decoder1 = decoder0.readPointer(40, false);
                result.metadata = RuleMetaData.decode(decoder1);
                }
                {
                    
                result.source = decoder0.readString(48, false);
                }
                {
                    
                result.incognito = decoder0.readBoolean(56, 0);
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
        
        encoder0.encode(this.primaryPattern, 8, false);
        
        encoder0.encode(this.secondaryPattern, 16, false);
        
        encoder0.encode(this.settingValue, 24, false);
        
        encoder0.encode(this.metadata, 40, false);
        
        encoder0.encode(this.source, 48, false);
        
        encoder0.encode(this.incognito, 56, 0);
    }
}