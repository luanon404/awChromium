// ObliviousHttpRequest.java is auto generated by mojom_bindings_generator.py, do not edit


// Copyright 2014 The Chromium Authors
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.

// This file is autogenerated by:
//     mojo/public/tools/bindings/mojom_bindings_generator.py
// For:
//     services/network/public/mojom/oblivious_http_request.mojom
//

package org.chromium.network.mojom;

public final class ObliviousHttpRequest extends org.chromium.mojo.bindings.Struct {

    private static final int STRUCT_SIZE = 80;
    private static final org.chromium.mojo.bindings.DataHeader[] VERSION_ARRAY = new org.chromium.mojo.bindings.DataHeader[]{new org.chromium.mojo.bindings.DataHeader(80, 0)};
    private static final org.chromium.mojo.bindings.DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
    public org.chromium.url.mojom.Url relayUrl;
    public MutableNetworkTrafficAnnotationTag trafficAnnotation;
    public org.chromium.mojo_base.mojom.TimeDelta timeoutDuration;
    public String keyConfig;
    public org.chromium.url.mojom.Url resourceUrl;
    public String method;
    public ObliviousHttpRequestBody requestBody;
    public TrustTokenParams trustTokenParams;
    public ObliviousHttpPaddingParameters paddingParams;

    private ObliviousHttpRequest(int version) {
        super(STRUCT_SIZE, version);
    }

    public ObliviousHttpRequest() {
        this(0);
    }

    public static ObliviousHttpRequest deserialize(org.chromium.mojo.bindings.Message message) {
        return decode(new org.chromium.mojo.bindings.Decoder(message));
    }

    /**
     * Similar to the method above, but deserializes from a |ByteBuffer| instance.
     *
     * @throws org.chromium.mojo.bindings.DeserializationException on deserialization failure.
     */
    public static ObliviousHttpRequest deserialize(java.nio.ByteBuffer data) {
        return deserialize(new org.chromium.mojo.bindings.Message(data, new java.util.ArrayList<org.chromium.mojo.system.Handle>()));
    }

    @SuppressWarnings("unchecked")
    public static ObliviousHttpRequest decode(org.chromium.mojo.bindings.Decoder decoder0) {
        if (decoder0 == null) {
            return null;
        }
        decoder0.increaseStackDepth();
        ObliviousHttpRequest result;
        try {
            org.chromium.mojo.bindings.DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
            final int elementsOrVersion = mainDataHeader.elementsOrVersion;
            result = new ObliviousHttpRequest(elementsOrVersion);
            {

                org.chromium.mojo.bindings.Decoder decoder1 = decoder0.readPointer(8, false);
                result.relayUrl = org.chromium.url.mojom.Url.decode(decoder1);
            }
            {

                org.chromium.mojo.bindings.Decoder decoder1 = decoder0.readPointer(16, false);
                result.trafficAnnotation = MutableNetworkTrafficAnnotationTag.decode(decoder1);
            }
            {

                org.chromium.mojo.bindings.Decoder decoder1 = decoder0.readPointer(24, true);
                result.timeoutDuration = org.chromium.mojo_base.mojom.TimeDelta.decode(decoder1);
            }
            {

                result.keyConfig = decoder0.readString(32, false);
            }
            {

                org.chromium.mojo.bindings.Decoder decoder1 = decoder0.readPointer(40, false);
                result.resourceUrl = org.chromium.url.mojom.Url.decode(decoder1);
            }
            {

                result.method = decoder0.readString(48, false);
            }
            {

                org.chromium.mojo.bindings.Decoder decoder1 = decoder0.readPointer(56, true);
                result.requestBody = ObliviousHttpRequestBody.decode(decoder1);
            }
            {

                org.chromium.mojo.bindings.Decoder decoder1 = decoder0.readPointer(64, true);
                result.trustTokenParams = TrustTokenParams.decode(decoder1);
            }
            {

                org.chromium.mojo.bindings.Decoder decoder1 = decoder0.readPointer(72, true);
                result.paddingParams = ObliviousHttpPaddingParameters.decode(decoder1);
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

        encoder0.encode(this.relayUrl, 8, false);

        encoder0.encode(this.trafficAnnotation, 16, false);

        encoder0.encode(this.timeoutDuration, 24, true);

        encoder0.encode(this.keyConfig, 32, false);

        encoder0.encode(this.resourceUrl, 40, false);

        encoder0.encode(this.method, 48, false);

        encoder0.encode(this.requestBody, 56, true);

        encoder0.encode(this.trustTokenParams, 64, true);

        encoder0.encode(this.paddingParams, 72, true);
    }
}