// BeginNavigationParams.java is auto generated by mojom_bindings_generator.py, do not edit


// Copyright 2014 The Chromium Authors
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.

// This file is autogenerated by:
//     mojo/public/tools/bindings/mojom_bindings_generator.py
// For:
//     third_party/blink/public/mojom/navigation/navigation_params.mojom
//

package org.chromium.blink.mojom;

import androidx.annotation.IntDef;


public final class BeginNavigationParams extends org.chromium.mojo.bindings.Struct {

    private static final int STRUCT_SIZE = 112;
    private static final org.chromium.mojo.bindings.DataHeader[] VERSION_ARRAY = new org.chromium.mojo.bindings.DataHeader[] {new org.chromium.mojo.bindings.DataHeader(112, 0)};
    private static final org.chromium.mojo.bindings.DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
    public LocalFrameToken initiatorFrameToken;
    public String headers;
    public int loadFlags;
    public boolean skipServiceWorker;
    public int requestContextType;
    public int mixedContentContextType;
    public boolean isFormSubmission;
    public boolean wasInitiatedByLinkClick;
    public int forceHistoryPush;
    public org.chromium.url.mojom.Url searchableFormUrl;
    public String searchableFormEncoding;
    public org.chromium.url.mojom.Url clientSideRedirectUrl;
    public org.chromium.mojo_base.mojom.DictionaryValue devtoolsInitiator;
    public org.chromium.network.mojom.TrustTokenParams trustTokenParams;
    public Impression impression;
    public org.chromium.mojo_base.mojom.TimeTicks beforeUnloadStart;
    public org.chromium.mojo_base.mojom.TimeTicks beforeUnloadEnd;
    public int initiatorActivationAndAdStatus;
    public boolean isContainerInitiated;
    public boolean isFullscreenRequested;
    public boolean hasStorageAccess;

    private BeginNavigationParams(int version) {
        super(STRUCT_SIZE, version);
        this.loadFlags = (int) 0;
        this.skipServiceWorker = (boolean) false;
        this.requestContextType = (int) RequestContextType.UNSPECIFIED;
        this.mixedContentContextType = (int) MixedContentContextType.NOT_MIXED_CONTENT;
        this.isFormSubmission = (boolean) false;
        this.wasInitiatedByLinkClick = (boolean) false;
        this.forceHistoryPush = (int) ForceHistoryPush.NO;
        this.isContainerInitiated = (boolean) false;
        this.isFullscreenRequested = (boolean) false;
        this.hasStorageAccess = (boolean) false;
    }

    public BeginNavigationParams() {
        this(0);
    }

    public static BeginNavigationParams deserialize(org.chromium.mojo.bindings.Message message) {
        return decode(new org.chromium.mojo.bindings.Decoder(message));
    }

    /**
     * Similar to the method above, but deserializes from a |ByteBuffer| instance.
     *
     * @throws org.chromium.mojo.bindings.DeserializationException on deserialization failure.
     */
    public static BeginNavigationParams deserialize(java.nio.ByteBuffer data) {
        return deserialize(new org.chromium.mojo.bindings.Message(
                data, new java.util.ArrayList<org.chromium.mojo.system.Handle>()));
    }

    @SuppressWarnings("unchecked")
    public static BeginNavigationParams decode(org.chromium.mojo.bindings.Decoder decoder0) {
        if (decoder0 == null) {
            return null;
        }
        decoder0.increaseStackDepth();
        BeginNavigationParams result;
        try {
            org.chromium.mojo.bindings.DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
            final int elementsOrVersion = mainDataHeader.elementsOrVersion;
            result = new BeginNavigationParams(elementsOrVersion);
                {
                    
                org.chromium.mojo.bindings.Decoder decoder1 = decoder0.readPointer(8, true);
                result.initiatorFrameToken = LocalFrameToken.decode(decoder1);
                }
                {
                    
                result.headers = decoder0.readString(16, false);
                }
                {
                    
                result.loadFlags = decoder0.readInt(24);
                }
                {
                    
                result.skipServiceWorker = decoder0.readBoolean(28, 0);
                }
                {
                    
                result.isFormSubmission = decoder0.readBoolean(28, 1);
                }
                {
                    
                result.wasInitiatedByLinkClick = decoder0.readBoolean(28, 2);
                }
                {
                    
                result.isContainerInitiated = decoder0.readBoolean(28, 3);
                }
                {
                    
                result.isFullscreenRequested = decoder0.readBoolean(28, 4);
                }
                {
                    
                result.hasStorageAccess = decoder0.readBoolean(28, 5);
                }
                {
                    
                result.requestContextType = decoder0.readInt(32);
                    RequestContextType.validate(result.requestContextType);
                    result.requestContextType = RequestContextType.toKnownValue(result.requestContextType);
                }
                {
                    
                result.mixedContentContextType = decoder0.readInt(36);
                    MixedContentContextType.validate(result.mixedContentContextType);
                    result.mixedContentContextType = MixedContentContextType.toKnownValue(result.mixedContentContextType);
                }
                {
                    
                result.forceHistoryPush = decoder0.readInt(40);
                    ForceHistoryPush.validate(result.forceHistoryPush);
                    result.forceHistoryPush = ForceHistoryPush.toKnownValue(result.forceHistoryPush);
                }
                {
                    
                result.initiatorActivationAndAdStatus = decoder0.readInt(44);
                    NavigationInitiatorActivationAndAdStatus.validate(result.initiatorActivationAndAdStatus);
                    result.initiatorActivationAndAdStatus = NavigationInitiatorActivationAndAdStatus.toKnownValue(result.initiatorActivationAndAdStatus);
                }
                {
                    
                org.chromium.mojo.bindings.Decoder decoder1 = decoder0.readPointer(48, false);
                result.searchableFormUrl = org.chromium.url.mojom.Url.decode(decoder1);
                }
                {
                    
                result.searchableFormEncoding = decoder0.readString(56, false);
                }
                {
                    
                org.chromium.mojo.bindings.Decoder decoder1 = decoder0.readPointer(64, false);
                result.clientSideRedirectUrl = org.chromium.url.mojom.Url.decode(decoder1);
                }
                {
                    
                org.chromium.mojo.bindings.Decoder decoder1 = decoder0.readPointer(72, true);
                result.devtoolsInitiator = org.chromium.mojo_base.mojom.DictionaryValue.decode(decoder1);
                }
                {
                    
                org.chromium.mojo.bindings.Decoder decoder1 = decoder0.readPointer(80, true);
                result.trustTokenParams = org.chromium.network.mojom.TrustTokenParams.decode(decoder1);
                }
                {
                    
                org.chromium.mojo.bindings.Decoder decoder1 = decoder0.readPointer(88, true);
                result.impression = Impression.decode(decoder1);
                }
                {
                    
                org.chromium.mojo.bindings.Decoder decoder1 = decoder0.readPointer(96, false);
                result.beforeUnloadStart = org.chromium.mojo_base.mojom.TimeTicks.decode(decoder1);
                }
                {
                    
                org.chromium.mojo.bindings.Decoder decoder1 = decoder0.readPointer(104, false);
                result.beforeUnloadEnd = org.chromium.mojo_base.mojom.TimeTicks.decode(decoder1);
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
        
        encoder0.encode(this.initiatorFrameToken, 8, true);
        
        encoder0.encode(this.headers, 16, false);
        
        encoder0.encode(this.loadFlags, 24);
        
        encoder0.encode(this.skipServiceWorker, 28, 0);
        
        encoder0.encode(this.isFormSubmission, 28, 1);
        
        encoder0.encode(this.wasInitiatedByLinkClick, 28, 2);
        
        encoder0.encode(this.isContainerInitiated, 28, 3);
        
        encoder0.encode(this.isFullscreenRequested, 28, 4);
        
        encoder0.encode(this.hasStorageAccess, 28, 5);
        
        encoder0.encode(this.requestContextType, 32);
        
        encoder0.encode(this.mixedContentContextType, 36);
        
        encoder0.encode(this.forceHistoryPush, 40);
        
        encoder0.encode(this.initiatorActivationAndAdStatus, 44);
        
        encoder0.encode(this.searchableFormUrl, 48, false);
        
        encoder0.encode(this.searchableFormEncoding, 56, false);
        
        encoder0.encode(this.clientSideRedirectUrl, 64, false);
        
        encoder0.encode(this.devtoolsInitiator, 72, true);
        
        encoder0.encode(this.trustTokenParams, 80, true);
        
        encoder0.encode(this.impression, 88, true);
        
        encoder0.encode(this.beforeUnloadStart, 96, false);
        
        encoder0.encode(this.beforeUnloadEnd, 104, false);
    }
}