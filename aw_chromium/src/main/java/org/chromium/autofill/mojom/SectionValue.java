// SectionValue.java is auto generated by mojom_bindings_generator.py, do not edit


// Copyright 2014 The Chromium Authors
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.

// This file is autogenerated by:
//     mojo/public/tools/bindings/mojom_bindings_generator.py
// For:
//     components/autofill/core/common/mojom/autofill_types.mojom
//

package org.chromium.autofill.mojom;

import androidx.annotation.IntDef;


public final class SectionValue extends org.chromium.mojo.bindings.Union {

    public static final class Tag {
        public static final int DefaultSection = 0;
        public static final int Autocomplete = 1;
        public static final int FieldIdentifier = 2;
    };
    private boolean mDefaultSection;
    private SectionAutocomplete mAutocomplete;
    private SectionFieldIdentifier mFieldIdentifier;

    public void setDefaultSection(boolean defaultSection) {
        this.mTag = Tag.DefaultSection;
        this.mDefaultSection = defaultSection;
    }

    public boolean getDefaultSection() {
        assert this.mTag == Tag.DefaultSection;
        return this.mDefaultSection;
    }

    public void setAutocomplete(SectionAutocomplete autocomplete) {
        this.mTag = Tag.Autocomplete;
        this.mAutocomplete = autocomplete;
    }

    public SectionAutocomplete getAutocomplete() {
        assert this.mTag == Tag.Autocomplete;
        return this.mAutocomplete;
    }

    public void setFieldIdentifier(SectionFieldIdentifier fieldIdentifier) {
        this.mTag = Tag.FieldIdentifier;
        this.mFieldIdentifier = fieldIdentifier;
    }

    public SectionFieldIdentifier getFieldIdentifier() {
        assert this.mTag == Tag.FieldIdentifier;
        return this.mFieldIdentifier;
    }


    @Override
    protected final void encode(org.chromium.mojo.bindings.Encoder encoder0, int offset) {
        encoder0.encode(org.chromium.mojo.bindings.BindingsHelper.UNION_SIZE, offset);
        encoder0.encode(this.mTag, offset + 4);
        switch (mTag) {
            case Tag.DefaultSection: {
                
                encoder0.encode(this.mDefaultSection, offset + 8, 0);
                break;
            }
            case Tag.Autocomplete: {
                
                encoder0.encode(this.mAutocomplete, offset + 8, false);
                break;
            }
            case Tag.FieldIdentifier: {
                
                encoder0.encode(this.mFieldIdentifier, offset + 8, false);
                break;
            }
            default: {
                break;
            }
        }
    }

    public static SectionValue deserialize(org.chromium.mojo.bindings.Message message) {
        return decode(new org.chromium.mojo.bindings.Decoder(message).decoderForSerializedUnion(), 0);
    }

    public static final SectionValue decode(org.chromium.mojo.bindings.Decoder decoder0, int offset) {
        org.chromium.mojo.bindings.DataHeader dataHeader = decoder0.readDataHeaderForUnion(offset);
        if (dataHeader.size == 0) {
            return null;
        }
        SectionValue result = new SectionValue();
        switch (dataHeader.elementsOrVersion) {
            case Tag.DefaultSection: {
                
                result.mDefaultSection = decoder0.readBoolean(offset + org.chromium.mojo.bindings.DataHeader.HEADER_SIZE, 0);
                result.mTag = Tag.DefaultSection;
                break;
            }
            case Tag.Autocomplete: {
                
                org.chromium.mojo.bindings.Decoder decoder1 = decoder0.readPointer(offset + org.chromium.mojo.bindings.DataHeader.HEADER_SIZE, false);
                result.mAutocomplete = SectionAutocomplete.decode(decoder1);
                result.mTag = Tag.Autocomplete;
                break;
            }
            case Tag.FieldIdentifier: {
                
                org.chromium.mojo.bindings.Decoder decoder1 = decoder0.readPointer(offset + org.chromium.mojo.bindings.DataHeader.HEADER_SIZE, false);
                result.mFieldIdentifier = SectionFieldIdentifier.decode(decoder1);
                result.mTag = Tag.FieldIdentifier;
                break;
            }
            default: {
                break;
            }
        }
        return result;
    }
}