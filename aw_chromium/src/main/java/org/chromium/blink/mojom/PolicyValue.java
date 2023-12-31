// PolicyValue.java is auto generated by mojom_bindings_generator.py, do not edit


// Copyright 2014 The Chromium Authors
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.

// This file is autogenerated by:
//     mojo/public/tools/bindings/mojom_bindings_generator.py
// For:
//     third_party/blink/public/mojom/permissions_policy/policy_value.mojom
//

package org.chromium.blink.mojom;

import androidx.annotation.IntDef;


public final class PolicyValue extends org.chromium.mojo.bindings.Union {

    public static final class Tag {
        public static final int NullValue = 0;
        public static final int BoolValue = 1;
        public static final int DecDoubleValue = 2;
        public static final int EnumValue = 3;
    };
    private boolean mNullValue;
    private boolean mBoolValue;
    private double mDecDoubleValue;
    private int mEnumValue;

    public void setNullValue(boolean nullValue) {
        this.mTag = Tag.NullValue;
        this.mNullValue = nullValue;
    }

    public boolean getNullValue() {
        assert this.mTag == Tag.NullValue;
        return this.mNullValue;
    }

    public void setBoolValue(boolean boolValue) {
        this.mTag = Tag.BoolValue;
        this.mBoolValue = boolValue;
    }

    public boolean getBoolValue() {
        assert this.mTag == Tag.BoolValue;
        return this.mBoolValue;
    }

    public void setDecDoubleValue(double decDoubleValue) {
        this.mTag = Tag.DecDoubleValue;
        this.mDecDoubleValue = decDoubleValue;
    }

    public double getDecDoubleValue() {
        assert this.mTag == Tag.DecDoubleValue;
        return this.mDecDoubleValue;
    }

    public void setEnumValue(int enumValue) {
        this.mTag = Tag.EnumValue;
        this.mEnumValue = enumValue;
    }

    public int getEnumValue() {
        assert this.mTag == Tag.EnumValue;
        return this.mEnumValue;
    }


    @Override
    protected final void encode(org.chromium.mojo.bindings.Encoder encoder0, int offset) {
        encoder0.encode(org.chromium.mojo.bindings.BindingsHelper.UNION_SIZE, offset);
        encoder0.encode(this.mTag, offset + 4);
        switch (mTag) {
            case Tag.NullValue: {
                
                encoder0.encode(this.mNullValue, offset + 8, 0);
                break;
            }
            case Tag.BoolValue: {
                
                encoder0.encode(this.mBoolValue, offset + 8, 0);
                break;
            }
            case Tag.DecDoubleValue: {
                
                encoder0.encode(this.mDecDoubleValue, offset + 8);
                break;
            }
            case Tag.EnumValue: {
                
                encoder0.encode(this.mEnumValue, offset + 8);
                break;
            }
            default: {
                break;
            }
        }
    }

    public static PolicyValue deserialize(org.chromium.mojo.bindings.Message message) {
        return decode(new org.chromium.mojo.bindings.Decoder(message).decoderForSerializedUnion(), 0);
    }

    public static final PolicyValue decode(org.chromium.mojo.bindings.Decoder decoder0, int offset) {
        org.chromium.mojo.bindings.DataHeader dataHeader = decoder0.readDataHeaderForUnion(offset);
        if (dataHeader.size == 0) {
            return null;
        }
        PolicyValue result = new PolicyValue();
        switch (dataHeader.elementsOrVersion) {
            case Tag.NullValue: {
                
                result.mNullValue = decoder0.readBoolean(offset + org.chromium.mojo.bindings.DataHeader.HEADER_SIZE, 0);
                result.mTag = Tag.NullValue;
                break;
            }
            case Tag.BoolValue: {
                
                result.mBoolValue = decoder0.readBoolean(offset + org.chromium.mojo.bindings.DataHeader.HEADER_SIZE, 0);
                result.mTag = Tag.BoolValue;
                break;
            }
            case Tag.DecDoubleValue: {
                
                result.mDecDoubleValue = decoder0.readDouble(offset + org.chromium.mojo.bindings.DataHeader.HEADER_SIZE);
                result.mTag = Tag.DecDoubleValue;
                break;
            }
            case Tag.EnumValue: {
                
                result.mEnumValue = decoder0.readInt(offset + org.chromium.mojo.bindings.DataHeader.HEADER_SIZE);
                result.mTag = Tag.EnumValue;
                break;
            }
            default: {
                break;
            }
        }
        return result;
    }
}