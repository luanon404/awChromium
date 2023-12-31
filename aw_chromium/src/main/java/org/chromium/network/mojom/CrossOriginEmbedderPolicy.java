// CrossOriginEmbedderPolicy.java is auto generated by mojom_bindings_generator.py, do not edit


// Copyright 2014 The Chromium Authors
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.

// This file is autogenerated by:
//     mojo/public/tools/bindings/mojom_bindings_generator.py
// For:
//     services/network/public/mojom/cross_origin_embedder_policy.mojom
//

package org.chromium.network.mojom;

import androidx.annotation.IntDef;


public final class CrossOriginEmbedderPolicy extends org.chromium.mojo.bindings.Struct {

    private static final int STRUCT_SIZE = 32;
    private static final org.chromium.mojo.bindings.DataHeader[] VERSION_ARRAY = new org.chromium.mojo.bindings.DataHeader[] {new org.chromium.mojo.bindings.DataHeader(32, 0)};
    private static final org.chromium.mojo.bindings.DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
    public int value;
    public String reportingEndpoint;
    public int reportOnlyValue;
    public String reportOnlyReportingEndpoint;

    private CrossOriginEmbedderPolicy(int version) {
        super(STRUCT_SIZE, version);
        this.value = (int) CrossOriginEmbedderPolicyValue.NONE;
        this.reportOnlyValue = (int) CrossOriginEmbedderPolicyValue.NONE;
    }

    public CrossOriginEmbedderPolicy() {
        this(0);
    }

    public static CrossOriginEmbedderPolicy deserialize(org.chromium.mojo.bindings.Message message) {
        return decode(new org.chromium.mojo.bindings.Decoder(message));
    }

    /**
     * Similar to the method above, but deserializes from a |ByteBuffer| instance.
     *
     * @throws org.chromium.mojo.bindings.DeserializationException on deserialization failure.
     */
    public static CrossOriginEmbedderPolicy deserialize(java.nio.ByteBuffer data) {
        return deserialize(new org.chromium.mojo.bindings.Message(
                data, new java.util.ArrayList<org.chromium.mojo.system.Handle>()));
    }

    @SuppressWarnings("unchecked")
    public static CrossOriginEmbedderPolicy decode(org.chromium.mojo.bindings.Decoder decoder0) {
        if (decoder0 == null) {
            return null;
        }
        decoder0.increaseStackDepth();
        CrossOriginEmbedderPolicy result;
        try {
            org.chromium.mojo.bindings.DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
            final int elementsOrVersion = mainDataHeader.elementsOrVersion;
            result = new CrossOriginEmbedderPolicy(elementsOrVersion);
                {
                    
                result.value = decoder0.readInt(8);
                    CrossOriginEmbedderPolicyValue.validate(result.value);
                    result.value = CrossOriginEmbedderPolicyValue.toKnownValue(result.value);
                }
                {
                    
                result.reportOnlyValue = decoder0.readInt(12);
                    CrossOriginEmbedderPolicyValue.validate(result.reportOnlyValue);
                    result.reportOnlyValue = CrossOriginEmbedderPolicyValue.toKnownValue(result.reportOnlyValue);
                }
                {
                    
                result.reportingEndpoint = decoder0.readString(16, true);
                }
                {
                    
                result.reportOnlyReportingEndpoint = decoder0.readString(24, true);
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
        
        encoder0.encode(this.value, 8);
        
        encoder0.encode(this.reportOnlyValue, 12);
        
        encoder0.encode(this.reportingEndpoint, 16, true);
        
        encoder0.encode(this.reportOnlyReportingEndpoint, 24, true);
    }
}