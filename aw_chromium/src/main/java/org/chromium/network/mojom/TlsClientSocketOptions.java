// TlsClientSocketOptions.java is auto generated by mojom_bindings_generator.py, do not edit


// Copyright 2014 The Chromium Authors
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.

// This file is autogenerated by:
//     mojo/public/tools/bindings/mojom_bindings_generator.py
// For:
//     services/network/public/mojom/tls_socket.mojom
//

package org.chromium.network.mojom;

import androidx.annotation.IntDef;


public final class TlsClientSocketOptions extends org.chromium.mojo.bindings.Struct {

    private static final int STRUCT_SIZE = 24;
    private static final org.chromium.mojo.bindings.DataHeader[] VERSION_ARRAY = new org.chromium.mojo.bindings.DataHeader[] {new org.chromium.mojo.bindings.DataHeader(24, 0)};
    private static final org.chromium.mojo.bindings.DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
    public int versionMin;
    public int versionMax;
    public boolean sendSslInfo;
    public boolean unsafelySkipCertVerification;

    private TlsClientSocketOptions(int version) {
        super(STRUCT_SIZE, version);
        this.versionMin = (int) SslVersion.TLS12;
        this.versionMax = (int) SslVersion.TLS13;
        this.sendSslInfo = (boolean) false;
        this.unsafelySkipCertVerification = (boolean) false;
    }

    public TlsClientSocketOptions() {
        this(0);
    }

    public static TlsClientSocketOptions deserialize(org.chromium.mojo.bindings.Message message) {
        return decode(new org.chromium.mojo.bindings.Decoder(message));
    }

    /**
     * Similar to the method above, but deserializes from a |ByteBuffer| instance.
     *
     * @throws org.chromium.mojo.bindings.DeserializationException on deserialization failure.
     */
    public static TlsClientSocketOptions deserialize(java.nio.ByteBuffer data) {
        return deserialize(new org.chromium.mojo.bindings.Message(
                data, new java.util.ArrayList<org.chromium.mojo.system.Handle>()));
    }

    @SuppressWarnings("unchecked")
    public static TlsClientSocketOptions decode(org.chromium.mojo.bindings.Decoder decoder0) {
        if (decoder0 == null) {
            return null;
        }
        decoder0.increaseStackDepth();
        TlsClientSocketOptions result;
        try {
            org.chromium.mojo.bindings.DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
            final int elementsOrVersion = mainDataHeader.elementsOrVersion;
            result = new TlsClientSocketOptions(elementsOrVersion);
                {
                    
                result.versionMin = decoder0.readInt(8);
                    SslVersion.validate(result.versionMin);
                    result.versionMin = SslVersion.toKnownValue(result.versionMin);
                }
                {
                    
                result.versionMax = decoder0.readInt(12);
                    SslVersion.validate(result.versionMax);
                    result.versionMax = SslVersion.toKnownValue(result.versionMax);
                }
                {
                    
                result.sendSslInfo = decoder0.readBoolean(16, 0);
                }
                {
                    
                result.unsafelySkipCertVerification = decoder0.readBoolean(16, 1);
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
        
        encoder0.encode(this.versionMin, 8);
        
        encoder0.encode(this.versionMax, 12);
        
        encoder0.encode(this.sendSslInfo, 16, 0);
        
        encoder0.encode(this.unsafelySkipCertVerification, 16, 1);
    }
}