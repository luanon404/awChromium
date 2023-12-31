// ServiceWorkerRegistrationObjectInfo.java is auto generated by mojom_bindings_generator.py, do not edit


// Copyright 2014 The Chromium Authors
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.

// This file is autogenerated by:
//     mojo/public/tools/bindings/mojom_bindings_generator.py
// For:
//     third_party/blink/public/mojom/service_worker/service_worker_registration.mojom
//

package org.chromium.blink.mojom;

import androidx.annotation.IntDef;


public final class ServiceWorkerRegistrationObjectInfo extends org.chromium.mojo.bindings.Struct {

    private static final int STRUCT_SIZE = 64;
    private static final org.chromium.mojo.bindings.DataHeader[] VERSION_ARRAY = new org.chromium.mojo.bindings.DataHeader[] {new org.chromium.mojo.bindings.DataHeader(64, 0)};
    private static final org.chromium.mojo.bindings.DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
    public long registrationId;
    public org.chromium.url.mojom.Url scope;
    public int updateViaCache;
    public org.chromium.mojo.bindings.AssociatedInterfaceNotSupported hostRemote;
    public org.chromium.mojo.bindings.AssociatedInterfaceRequestNotSupported receiver;
    public ServiceWorkerObjectInfo installing;
    public ServiceWorkerObjectInfo waiting;
    public ServiceWorkerObjectInfo active;

    private ServiceWorkerRegistrationObjectInfo(int version) {
        super(STRUCT_SIZE, version);
        this.registrationId = (long) ServiceWorkerDatabaseConstants.INVALID_SERVICE_WORKER_REGISTRATION_ID;
    }

    public ServiceWorkerRegistrationObjectInfo() {
        this(0);
    }

    public static ServiceWorkerRegistrationObjectInfo deserialize(org.chromium.mojo.bindings.Message message) {
        return decode(new org.chromium.mojo.bindings.Decoder(message));
    }

    /**
     * Similar to the method above, but deserializes from a |ByteBuffer| instance.
     *
     * @throws org.chromium.mojo.bindings.DeserializationException on deserialization failure.
     */
    public static ServiceWorkerRegistrationObjectInfo deserialize(java.nio.ByteBuffer data) {
        return deserialize(new org.chromium.mojo.bindings.Message(
                data, new java.util.ArrayList<org.chromium.mojo.system.Handle>()));
    }

    @SuppressWarnings("unchecked")
    public static ServiceWorkerRegistrationObjectInfo decode(org.chromium.mojo.bindings.Decoder decoder0) {
        if (decoder0 == null) {
            return null;
        }
        decoder0.increaseStackDepth();
        ServiceWorkerRegistrationObjectInfo result;
        try {
            org.chromium.mojo.bindings.DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
            final int elementsOrVersion = mainDataHeader.elementsOrVersion;
            result = new ServiceWorkerRegistrationObjectInfo(elementsOrVersion);
                {
                    
                result.registrationId = decoder0.readLong(8);
                }
                {
                    
                org.chromium.mojo.bindings.Decoder decoder1 = decoder0.readPointer(16, false);
                result.scope = org.chromium.url.mojom.Url.decode(decoder1);
                }
                {
                    
                result.updateViaCache = decoder0.readInt(24);
                    ServiceWorkerUpdateViaCache.validate(result.updateViaCache);
                    result.updateViaCache = ServiceWorkerUpdateViaCache.toKnownValue(result.updateViaCache);
                }
                {
                    
                result.hostRemote = decoder0.readAssociatedServiceInterfaceNotSupported(28, false);
                }
                {
                    
                result.receiver = decoder0.readAssociatedInterfaceRequestNotSupported(36, false);
                }
                {
                    
                org.chromium.mojo.bindings.Decoder decoder1 = decoder0.readPointer(40, true);
                result.installing = ServiceWorkerObjectInfo.decode(decoder1);
                }
                {
                    
                org.chromium.mojo.bindings.Decoder decoder1 = decoder0.readPointer(48, true);
                result.waiting = ServiceWorkerObjectInfo.decode(decoder1);
                }
                {
                    
                org.chromium.mojo.bindings.Decoder decoder1 = decoder0.readPointer(56, true);
                result.active = ServiceWorkerObjectInfo.decode(decoder1);
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
        
        encoder0.encode(this.registrationId, 8);
        
        encoder0.encode(this.scope, 16, false);
        
        encoder0.encode(this.updateViaCache, 24);
        
        encoder0.encode(this.hostRemote, 28, false);
        
        encoder0.encode(this.receiver, 36, false);
        
        encoder0.encode(this.installing, 40, true);
        
        encoder0.encode(this.waiting, 48, true);
        
        encoder0.encode(this.active, 56, true);
    }
}