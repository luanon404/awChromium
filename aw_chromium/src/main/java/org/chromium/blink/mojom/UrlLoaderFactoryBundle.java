// UrlLoaderFactoryBundle.java is auto generated by mojom_bindings_generator.py, do not edit


// Copyright 2014 The Chromium Authors
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.

// This file is autogenerated by:
//     mojo/public/tools/bindings/mojom_bindings_generator.py
// For:
//     third_party/blink/public/mojom/loader/url_loader_factory_bundle.mojom
//

package org.chromium.blink.mojom;


public final class UrlLoaderFactoryBundle extends org.chromium.mojo.bindings.Struct {

    private static final int STRUCT_SIZE = 40;
    private static final org.chromium.mojo.bindings.DataHeader[] VERSION_ARRAY = new org.chromium.mojo.bindings.DataHeader[] {new org.chromium.mojo.bindings.DataHeader(40, 0)};
    private static final org.chromium.mojo.bindings.DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
    public org.chromium.network.mojom.UrlLoaderFactory defaultFactory;
    public java.util.Map<String, org.chromium.network.mojom.UrlLoaderFactory> schemeSpecificFactories;
    public java.util.Map<org.chromium.url.internal.mojom.Origin, org.chromium.network.mojom.UrlLoaderFactory> isolatedWorldFactories;
    public boolean bypassRedirectChecks;

    private UrlLoaderFactoryBundle(int version) {
        super(STRUCT_SIZE, version);
        this.bypassRedirectChecks = (boolean) false;
    }

    public UrlLoaderFactoryBundle() {
        this(0);
    }

    public static UrlLoaderFactoryBundle deserialize(org.chromium.mojo.bindings.Message message) {
        return decode(new org.chromium.mojo.bindings.Decoder(message));
    }

    /**
     * Similar to the method above, but deserializes from a |ByteBuffer| instance.
     *
     * @throws org.chromium.mojo.bindings.DeserializationException on deserialization failure.
     */
    public static UrlLoaderFactoryBundle deserialize(java.nio.ByteBuffer data) {
        return deserialize(new org.chromium.mojo.bindings.Message(
                data, new java.util.ArrayList<org.chromium.mojo.system.Handle>()));
    }

    @SuppressWarnings("unchecked")
    public static UrlLoaderFactoryBundle decode(org.chromium.mojo.bindings.Decoder decoder0) {
        if (decoder0 == null) {
            return null;
        }
        decoder0.increaseStackDepth();
        UrlLoaderFactoryBundle result;
        try {
            org.chromium.mojo.bindings.DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
            final int elementsOrVersion = mainDataHeader.elementsOrVersion;
            result = new UrlLoaderFactoryBundle(elementsOrVersion);
                {
                    
                result.defaultFactory = decoder0.readServiceInterface(8, true, org.chromium.network.mojom.UrlLoaderFactory.MANAGER);
                }
                {
                    
                org.chromium.mojo.bindings.Decoder decoder1 = decoder0.readPointer(16, false);
                {
                    decoder1.readDataHeaderForMap();
                    String[] keys0;
                    org.chromium.network.mojom.UrlLoaderFactory[] values0;
                    {
                        
                        org.chromium.mojo.bindings.Decoder decoder2 = decoder1.readPointer(org.chromium.mojo.bindings.DataHeader.HEADER_SIZE, false);
                        {
                            org.chromium.mojo.bindings.DataHeader si2 = decoder2.readDataHeaderForPointerArray(org.chromium.mojo.bindings.BindingsHelper.UNSPECIFIED_ARRAY_LENGTH);
                            keys0 = new String[si2.elementsOrVersion];
                            for (int i2 = 0; i2 < si2.elementsOrVersion; ++i2) {
                                
                                keys0[i2] = decoder2.readString(org.chromium.mojo.bindings.DataHeader.HEADER_SIZE + org.chromium.mojo.bindings.BindingsHelper.POINTER_SIZE * i2, false);
                            }
                        }
                    }
                    {
                        
                        values0 = decoder1.readServiceInterfaces(org.chromium.mojo.bindings.DataHeader.HEADER_SIZE + org.chromium.mojo.bindings.BindingsHelper.POINTER_SIZE, org.chromium.mojo.bindings.BindingsHelper.NOTHING_NULLABLE, keys0.length, org.chromium.network.mojom.UrlLoaderFactory.MANAGER);
                    }
                    result.schemeSpecificFactories = new java.util.HashMap<String, org.chromium.network.mojom.UrlLoaderFactory>();
                    for (int index0 = 0; index0 < keys0.length; ++index0) {
                        result.schemeSpecificFactories.put(keys0[index0],  values0[index0]);
                    }
                }
                }
                {
                    
                org.chromium.mojo.bindings.Decoder decoder1 = decoder0.readPointer(24, false);
                {
                    decoder1.readDataHeaderForMap();
                    org.chromium.url.internal.mojom.Origin[] keys0;
                    org.chromium.network.mojom.UrlLoaderFactory[] values0;
                    {
                        
                        org.chromium.mojo.bindings.Decoder decoder2 = decoder1.readPointer(org.chromium.mojo.bindings.DataHeader.HEADER_SIZE, false);
                        {
                            org.chromium.mojo.bindings.DataHeader si2 = decoder2.readDataHeaderForPointerArray(org.chromium.mojo.bindings.BindingsHelper.UNSPECIFIED_ARRAY_LENGTH);
                            keys0 = new org.chromium.url.internal.mojom.Origin[si2.elementsOrVersion];
                            for (int i2 = 0; i2 < si2.elementsOrVersion; ++i2) {
                                
                                org.chromium.mojo.bindings.Decoder decoder3 = decoder2.readPointer(org.chromium.mojo.bindings.DataHeader.HEADER_SIZE + org.chromium.mojo.bindings.BindingsHelper.POINTER_SIZE * i2, false);
                                keys0[i2] = org.chromium.url.internal.mojom.Origin.decode(decoder3);
                            }
                        }
                    }
                    {
                        
                        values0 = decoder1.readServiceInterfaces(org.chromium.mojo.bindings.DataHeader.HEADER_SIZE + org.chromium.mojo.bindings.BindingsHelper.POINTER_SIZE, org.chromium.mojo.bindings.BindingsHelper.NOTHING_NULLABLE, keys0.length, org.chromium.network.mojom.UrlLoaderFactory.MANAGER);
                    }
                    result.isolatedWorldFactories = new java.util.HashMap<org.chromium.url.internal.mojom.Origin, org.chromium.network.mojom.UrlLoaderFactory>();
                    for (int index0 = 0; index0 < keys0.length; ++index0) {
                        result.isolatedWorldFactories.put(keys0[index0],  values0[index0]);
                    }
                }
                }
                {
                    
                result.bypassRedirectChecks = decoder0.readBoolean(32, 0);
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
        
        encoder0.encode(this.defaultFactory, 8, true, org.chromium.network.mojom.UrlLoaderFactory.MANAGER);
        
        if (this.schemeSpecificFactories == null) {
            encoder0.encodeNullPointer(16, false);
        } else {
            org.chromium.mojo.bindings.Encoder encoder1 = encoder0.encoderForMap(16);
            int size0 = this.schemeSpecificFactories.size();
            String[] keys0 = new String[size0];
            org.chromium.network.mojom.UrlLoaderFactory[] values0 = new org.chromium.network.mojom.UrlLoaderFactory[size0];
            int index0 = 0;
            for (java.util.Map.Entry<String, org.chromium.network.mojom.UrlLoaderFactory> entry0 : this.schemeSpecificFactories.entrySet()) {
                keys0[index0] = entry0.getKey();
                values0[index0] = entry0.getValue();
                ++index0;
            }
            
            {
                org.chromium.mojo.bindings.Encoder encoder2 = encoder1.encodePointerArray(keys0.length, org.chromium.mojo.bindings.DataHeader.HEADER_SIZE, org.chromium.mojo.bindings.BindingsHelper.UNSPECIFIED_ARRAY_LENGTH);
                for (int i1 = 0; i1 < keys0.length; ++i1) {
                    
                    encoder2.encode(keys0[i1], org.chromium.mojo.bindings.DataHeader.HEADER_SIZE + org.chromium.mojo.bindings.BindingsHelper.POINTER_SIZE * i1, false);
                }
            }
            
            encoder1.encode(values0, org.chromium.mojo.bindings.DataHeader.HEADER_SIZE + org.chromium.mojo.bindings.BindingsHelper.POINTER_SIZE, org.chromium.mojo.bindings.BindingsHelper.NOTHING_NULLABLE, org.chromium.mojo.bindings.BindingsHelper.UNSPECIFIED_ARRAY_LENGTH, org.chromium.network.mojom.UrlLoaderFactory.MANAGER);
        }
        
        if (this.isolatedWorldFactories == null) {
            encoder0.encodeNullPointer(24, false);
        } else {
            org.chromium.mojo.bindings.Encoder encoder1 = encoder0.encoderForMap(24);
            int size0 = this.isolatedWorldFactories.size();
            org.chromium.url.internal.mojom.Origin[] keys0 = new org.chromium.url.internal.mojom.Origin[size0];
            org.chromium.network.mojom.UrlLoaderFactory[] values0 = new org.chromium.network.mojom.UrlLoaderFactory[size0];
            int index0 = 0;
            for (java.util.Map.Entry<org.chromium.url.internal.mojom.Origin, org.chromium.network.mojom.UrlLoaderFactory> entry0 : this.isolatedWorldFactories.entrySet()) {
                keys0[index0] = entry0.getKey();
                values0[index0] = entry0.getValue();
                ++index0;
            }
            
            {
                org.chromium.mojo.bindings.Encoder encoder2 = encoder1.encodePointerArray(keys0.length, org.chromium.mojo.bindings.DataHeader.HEADER_SIZE, org.chromium.mojo.bindings.BindingsHelper.UNSPECIFIED_ARRAY_LENGTH);
                for (int i1 = 0; i1 < keys0.length; ++i1) {
                    
                    encoder2.encode(keys0[i1], org.chromium.mojo.bindings.DataHeader.HEADER_SIZE + org.chromium.mojo.bindings.BindingsHelper.POINTER_SIZE * i1, false);
                }
            }
            
            encoder1.encode(values0, org.chromium.mojo.bindings.DataHeader.HEADER_SIZE + org.chromium.mojo.bindings.BindingsHelper.POINTER_SIZE, org.chromium.mojo.bindings.BindingsHelper.NOTHING_NULLABLE, org.chromium.mojo.bindings.BindingsHelper.UNSPECIFIED_ARRAY_LENGTH, org.chromium.network.mojom.UrlLoaderFactory.MANAGER);
        }
        
        encoder0.encode(this.bypassRedirectChecks, 32, 0);
    }
}