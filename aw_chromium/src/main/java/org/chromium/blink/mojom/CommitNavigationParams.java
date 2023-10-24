// CommitNavigationParams.java is auto generated by mojom_bindings_generator.py, do not edit


// Copyright 2014 The Chromium Authors
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.

// This file is autogenerated by:
//     mojo/public/tools/bindings/mojom_bindings_generator.py
// For:
//     third_party/blink/public/mojom/navigation/navigation_params.mojom
//

package org.chromium.blink.mojom;


public final class CommitNavigationParams extends org.chromium.mojo.bindings.Struct {

    private static final int STRUCT_SIZE = 304;
    private static final org.chromium.mojo.bindings.DataHeader[] VERSION_ARRAY = new org.chromium.mojo.bindings.DataHeader[] {new org.chromium.mojo.bindings.DataHeader(304, 0)};
    private static final org.chromium.mojo.bindings.DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
    public org.chromium.url.internal.mojom.Origin originToCommit;
    public StorageKey storageKey;
    public StorageKey sessionStorageKey;
    public boolean isOverridingUserAgent;
    public org.chromium.url.mojom.Url[] redirects;
    public org.chromium.network.mojom.UrlResponseHead[] redirectResponse;
    public org.chromium.network.mojom.UrlRequestRedirectInfo[] redirectInfos;
    public String postContentType;
    public org.chromium.url.mojom.Url originalUrl;
    public String originalMethod;
    public boolean canLoadLocalResources;
    public String pageState;
    public int navEntryId;
    public java.util.Map<String, Boolean> subframeUniqueNames;
    public boolean intendedAsNewEntry;
    public int pendingHistoryListOffset;
    public int currentHistoryListOffset;
    public int currentHistoryListLength;
    public boolean wasDiscarded;
    public boolean isViewSource;
    public boolean shouldClearHistoryList;
    public NavigationTiming navigationTiming;
    public int wasActivated;
    public org.chromium.mojo_base.mojom.UnguessableToken navigationToken;
    public PrefetchedSignedExchangeInfo[] prefetchedSignedExchanges;
    public String dataUrlAsString;
    public boolean isBrowserInitiated;
    public long documentUkmSourceId;
    public FramePolicy framePolicy;
    public String[] forceEnabledOriginTrials;
    public boolean originAgentCluster;
    public boolean originAgentClusterLeftAsDefault;
    public int[] enabledClientHints;
    public boolean isCrossSiteCrossBrowsingContextGroup;
    public OldPageInfo oldPageInfo;
    public int httpResponseCode;
    public NavigationApiHistoryEntryArrays navigationApiHistoryEntryArrays;
    public org.chromium.url.mojom.Url[] earlyHintsPreloadedResources;
    public org.chromium.mojo_base.mojom.TimeTicks commitSent;
    public String srcdocValue;
    public boolean isLoadDataWithBaseUrl;
    public boolean ancestorOrSelfHasCspee;
    public String reducedAcceptLanguage;
    public int navigationDeliveryType;
    public ViewTransitionState viewTransitionState;
    public TaskAttributionId softNavigationHeuristicsTaskId;
    public java.util.Map<Integer, Boolean> modifiedRuntimeFeatures;
    public FencedFrameProperties fencedFrameProperties;
    public BackForwardCacheNotRestoredReasons notRestoredReasons;
    public boolean loadWithStorageAccess;
    public BrowsingContextGroupInfo browsingContextGroupInfo;
    public LcpCriticalPathPredictorNavigationTimeHint lcppHint;
    public RendererContentSettings contentSettings;

    private CommitNavigationParams(int version) {
        super(STRUCT_SIZE, version);
        this.isOverridingUserAgent = (boolean) false;
        this.canLoadLocalResources = (boolean) false;
        this.navEntryId = (int) 0;
        this.intendedAsNewEntry = (boolean) false;
        this.pendingHistoryListOffset = (int) -1;
        this.currentHistoryListOffset = (int) -1;
        this.currentHistoryListLength = (int) 0;
        this.wasDiscarded = (boolean) false;
        this.isViewSource = (boolean) false;
        this.shouldClearHistoryList = (boolean) false;
        this.wasActivated = (int) WasActivatedOption.UNKNOWN;
        this.isBrowserInitiated = (boolean) false;
        this.originAgentCluster = (boolean) false;
        this.originAgentClusterLeftAsDefault = (boolean) true;
        this.isCrossSiteCrossBrowsingContextGroup = (boolean) false;
        this.httpResponseCode = (int) -1;
        this.isLoadDataWithBaseUrl = (boolean) false;
        this.ancestorOrSelfHasCspee = (boolean) false;
        this.navigationDeliveryType = (int) org.chromium.network.mojom.NavigationDeliveryType.DEFAULT;
        this.loadWithStorageAccess = (boolean) false;
    }

    public CommitNavigationParams() {
        this(0);
    }

    public static CommitNavigationParams deserialize(org.chromium.mojo.bindings.Message message) {
        return decode(new org.chromium.mojo.bindings.Decoder(message));
    }

    /**
     * Similar to the method above, but deserializes from a |ByteBuffer| instance.
     *
     * @throws org.chromium.mojo.bindings.DeserializationException on deserialization failure.
     */
    public static CommitNavigationParams deserialize(java.nio.ByteBuffer data) {
        return deserialize(new org.chromium.mojo.bindings.Message(
                data, new java.util.ArrayList<org.chromium.mojo.system.Handle>()));
    }

    @SuppressWarnings("unchecked")
    public static CommitNavigationParams decode(org.chromium.mojo.bindings.Decoder decoder0) {
        if (decoder0 == null) {
            return null;
        }
        decoder0.increaseStackDepth();
        CommitNavigationParams result;
        try {
            org.chromium.mojo.bindings.DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
            final int elementsOrVersion = mainDataHeader.elementsOrVersion;
            result = new CommitNavigationParams(elementsOrVersion);
                {
                    
                org.chromium.mojo.bindings.Decoder decoder1 = decoder0.readPointer(8, true);
                result.originToCommit = org.chromium.url.internal.mojom.Origin.decode(decoder1);
                }
                {
                    
                org.chromium.mojo.bindings.Decoder decoder1 = decoder0.readPointer(16, false);
                result.storageKey = StorageKey.decode(decoder1);
                }
                {
                    
                org.chromium.mojo.bindings.Decoder decoder1 = decoder0.readPointer(24, false);
                result.sessionStorageKey = StorageKey.decode(decoder1);
                }
                {
                    
                result.isOverridingUserAgent = decoder0.readBoolean(32, 0);
                }
                {
                    
                result.canLoadLocalResources = decoder0.readBoolean(32, 1);
                }
                {
                    
                result.intendedAsNewEntry = decoder0.readBoolean(32, 2);
                }
                {
                    
                result.wasDiscarded = decoder0.readBoolean(32, 3);
                }
                {
                    
                result.isViewSource = decoder0.readBoolean(32, 4);
                }
                {
                    
                result.shouldClearHistoryList = decoder0.readBoolean(32, 5);
                }
                {
                    
                result.isBrowserInitiated = decoder0.readBoolean(32, 6);
                }
                {
                    
                result.originAgentCluster = decoder0.readBoolean(32, 7);
                }
                {
                    
                result.originAgentClusterLeftAsDefault = decoder0.readBoolean(33, 0);
                }
                {
                    
                result.isCrossSiteCrossBrowsingContextGroup = decoder0.readBoolean(33, 1);
                }
                {
                    
                result.isLoadDataWithBaseUrl = decoder0.readBoolean(33, 2);
                }
                {
                    
                result.ancestorOrSelfHasCspee = decoder0.readBoolean(33, 3);
                }
                {
                    
                result.loadWithStorageAccess = decoder0.readBoolean(33, 4);
                }
                {
                    
                result.navEntryId = decoder0.readInt(36);
                }
                {
                    
                org.chromium.mojo.bindings.Decoder decoder1 = decoder0.readPointer(40, false);
                {
                    org.chromium.mojo.bindings.DataHeader si1 = decoder1.readDataHeaderForPointerArray(org.chromium.mojo.bindings.BindingsHelper.UNSPECIFIED_ARRAY_LENGTH);
                    result.redirects = new org.chromium.url.mojom.Url[si1.elementsOrVersion];
                    for (int i1 = 0; i1 < si1.elementsOrVersion; ++i1) {
                        
                        org.chromium.mojo.bindings.Decoder decoder2 = decoder1.readPointer(org.chromium.mojo.bindings.DataHeader.HEADER_SIZE + org.chromium.mojo.bindings.BindingsHelper.POINTER_SIZE * i1, false);
                        result.redirects[i1] = org.chromium.url.mojom.Url.decode(decoder2);
                    }
                }
                }
                {
                    
                org.chromium.mojo.bindings.Decoder decoder1 = decoder0.readPointer(48, false);
                {
                    org.chromium.mojo.bindings.DataHeader si1 = decoder1.readDataHeaderForPointerArray(org.chromium.mojo.bindings.BindingsHelper.UNSPECIFIED_ARRAY_LENGTH);
                    result.redirectResponse = new org.chromium.network.mojom.UrlResponseHead[si1.elementsOrVersion];
                    for (int i1 = 0; i1 < si1.elementsOrVersion; ++i1) {
                        
                        org.chromium.mojo.bindings.Decoder decoder2 = decoder1.readPointer(org.chromium.mojo.bindings.DataHeader.HEADER_SIZE + org.chromium.mojo.bindings.BindingsHelper.POINTER_SIZE * i1, false);
                        result.redirectResponse[i1] = org.chromium.network.mojom.UrlResponseHead.decode(decoder2);
                    }
                }
                }
                {
                    
                org.chromium.mojo.bindings.Decoder decoder1 = decoder0.readPointer(56, false);
                {
                    org.chromium.mojo.bindings.DataHeader si1 = decoder1.readDataHeaderForPointerArray(org.chromium.mojo.bindings.BindingsHelper.UNSPECIFIED_ARRAY_LENGTH);
                    result.redirectInfos = new org.chromium.network.mojom.UrlRequestRedirectInfo[si1.elementsOrVersion];
                    for (int i1 = 0; i1 < si1.elementsOrVersion; ++i1) {
                        
                        org.chromium.mojo.bindings.Decoder decoder2 = decoder1.readPointer(org.chromium.mojo.bindings.DataHeader.HEADER_SIZE + org.chromium.mojo.bindings.BindingsHelper.POINTER_SIZE * i1, false);
                        result.redirectInfos[i1] = org.chromium.network.mojom.UrlRequestRedirectInfo.decode(decoder2);
                    }
                }
                }
                {
                    
                result.postContentType = decoder0.readString(64, false);
                }
                {
                    
                org.chromium.mojo.bindings.Decoder decoder1 = decoder0.readPointer(72, false);
                result.originalUrl = org.chromium.url.mojom.Url.decode(decoder1);
                }
                {
                    
                result.originalMethod = decoder0.readString(80, false);
                }
                {
                    
                result.pageState = decoder0.readString(88, false);
                }
                {
                    
                org.chromium.mojo.bindings.Decoder decoder1 = decoder0.readPointer(96, false);
                {
                    decoder1.readDataHeaderForMap();
                    String[] keys0;
                    boolean[] values0;
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
                        
                        values0 = decoder1.readBooleans(org.chromium.mojo.bindings.DataHeader.HEADER_SIZE + org.chromium.mojo.bindings.BindingsHelper.POINTER_SIZE, org.chromium.mojo.bindings.BindingsHelper.NOTHING_NULLABLE, keys0.length);
                    }
                    result.subframeUniqueNames = new java.util.HashMap<String, Boolean>();
                    for (int index0 = 0; index0 < keys0.length; ++index0) {
                        result.subframeUniqueNames.put(keys0[index0],  values0[index0]);
                    }
                }
                }
                {
                    
                result.pendingHistoryListOffset = decoder0.readInt(104);
                }
                {
                    
                result.currentHistoryListOffset = decoder0.readInt(108);
                }
                {
                    
                result.currentHistoryListLength = decoder0.readInt(112);
                }
                {
                    
                result.wasActivated = decoder0.readInt(116);
                    WasActivatedOption.validate(result.wasActivated);
                    result.wasActivated = WasActivatedOption.toKnownValue(result.wasActivated);
                }
                {
                    
                org.chromium.mojo.bindings.Decoder decoder1 = decoder0.readPointer(120, false);
                result.navigationTiming = NavigationTiming.decode(decoder1);
                }
                {
                    
                org.chromium.mojo.bindings.Decoder decoder1 = decoder0.readPointer(128, false);
                result.navigationToken = org.chromium.mojo_base.mojom.UnguessableToken.decode(decoder1);
                }
                {
                    
                org.chromium.mojo.bindings.Decoder decoder1 = decoder0.readPointer(136, false);
                {
                    org.chromium.mojo.bindings.DataHeader si1 = decoder1.readDataHeaderForPointerArray(org.chromium.mojo.bindings.BindingsHelper.UNSPECIFIED_ARRAY_LENGTH);
                    result.prefetchedSignedExchanges = new PrefetchedSignedExchangeInfo[si1.elementsOrVersion];
                    for (int i1 = 0; i1 < si1.elementsOrVersion; ++i1) {
                        
                        org.chromium.mojo.bindings.Decoder decoder2 = decoder1.readPointer(org.chromium.mojo.bindings.DataHeader.HEADER_SIZE + org.chromium.mojo.bindings.BindingsHelper.POINTER_SIZE * i1, false);
                        result.prefetchedSignedExchanges[i1] = PrefetchedSignedExchangeInfo.decode(decoder2);
                    }
                }
                }
                {
                    
                result.dataUrlAsString = decoder0.readString(144, false);
                }
                {
                    
                result.documentUkmSourceId = decoder0.readLong(152);
                }
                {
                    
                org.chromium.mojo.bindings.Decoder decoder1 = decoder0.readPointer(160, false);
                result.framePolicy = FramePolicy.decode(decoder1);
                }
                {
                    
                org.chromium.mojo.bindings.Decoder decoder1 = decoder0.readPointer(168, false);
                {
                    org.chromium.mojo.bindings.DataHeader si1 = decoder1.readDataHeaderForPointerArray(org.chromium.mojo.bindings.BindingsHelper.UNSPECIFIED_ARRAY_LENGTH);
                    result.forceEnabledOriginTrials = new String[si1.elementsOrVersion];
                    for (int i1 = 0; i1 < si1.elementsOrVersion; ++i1) {
                        
                        result.forceEnabledOriginTrials[i1] = decoder1.readString(org.chromium.mojo.bindings.DataHeader.HEADER_SIZE + org.chromium.mojo.bindings.BindingsHelper.POINTER_SIZE * i1, false);
                    }
                }
                }
                {
                    
                result.enabledClientHints = decoder0.readInts(176, org.chromium.mojo.bindings.BindingsHelper.NOTHING_NULLABLE, org.chromium.mojo.bindings.BindingsHelper.UNSPECIFIED_ARRAY_LENGTH);
                {
                    for (int i1 = 0; i1 < result.enabledClientHints.length; ++i1) {
                        org.chromium.network.mojom.WebClientHintsType.validate(result.enabledClientHints[i1]);
                    }
                }
                }
                {
                    
                org.chromium.mojo.bindings.Decoder decoder1 = decoder0.readPointer(184, true);
                result.oldPageInfo = OldPageInfo.decode(decoder1);
                }
                {
                    
                result.httpResponseCode = decoder0.readInt(192);
                }
                {
                    
                result.navigationDeliveryType = decoder0.readInt(196);
                    org.chromium.network.mojom.NavigationDeliveryType.validate(result.navigationDeliveryType);
                    result.navigationDeliveryType = org.chromium.network.mojom.NavigationDeliveryType.toKnownValue(result.navigationDeliveryType);
                }
                {
                    
                org.chromium.mojo.bindings.Decoder decoder1 = decoder0.readPointer(200, false);
                result.navigationApiHistoryEntryArrays = NavigationApiHistoryEntryArrays.decode(decoder1);
                }
                {
                    
                org.chromium.mojo.bindings.Decoder decoder1 = decoder0.readPointer(208, false);
                {
                    org.chromium.mojo.bindings.DataHeader si1 = decoder1.readDataHeaderForPointerArray(org.chromium.mojo.bindings.BindingsHelper.UNSPECIFIED_ARRAY_LENGTH);
                    result.earlyHintsPreloadedResources = new org.chromium.url.mojom.Url[si1.elementsOrVersion];
                    for (int i1 = 0; i1 < si1.elementsOrVersion; ++i1) {
                        
                        org.chromium.mojo.bindings.Decoder decoder2 = decoder1.readPointer(org.chromium.mojo.bindings.DataHeader.HEADER_SIZE + org.chromium.mojo.bindings.BindingsHelper.POINTER_SIZE * i1, false);
                        result.earlyHintsPreloadedResources[i1] = org.chromium.url.mojom.Url.decode(decoder2);
                    }
                }
                }
                {
                    
                org.chromium.mojo.bindings.Decoder decoder1 = decoder0.readPointer(216, false);
                result.commitSent = org.chromium.mojo_base.mojom.TimeTicks.decode(decoder1);
                }
                {
                    
                result.srcdocValue = decoder0.readString(224, false);
                }
                {
                    
                result.reducedAcceptLanguage = decoder0.readString(232, false);
                }
                {
                    
                org.chromium.mojo.bindings.Decoder decoder1 = decoder0.readPointer(240, true);
                result.viewTransitionState = ViewTransitionState.decode(decoder1);
                }
                {
                    
                org.chromium.mojo.bindings.Decoder decoder1 = decoder0.readPointer(248, true);
                result.softNavigationHeuristicsTaskId = TaskAttributionId.decode(decoder1);
                }
                {
                    
                org.chromium.mojo.bindings.Decoder decoder1 = decoder0.readPointer(256, false);
                {
                    decoder1.readDataHeaderForMap();
                    int[] keys0;
                    boolean[] values0;
                    {
                        
                        keys0 = decoder1.readInts(org.chromium.mojo.bindings.DataHeader.HEADER_SIZE, org.chromium.mojo.bindings.BindingsHelper.NOTHING_NULLABLE, org.chromium.mojo.bindings.BindingsHelper.UNSPECIFIED_ARRAY_LENGTH);
                        {
                            for (int i2 = 0; i2 < keys0.length; ++i2) {
                                RuntimeFeature.validate(keys0[i2]);
                            }
                        }
                    }
                    {
                        
                        values0 = decoder1.readBooleans(org.chromium.mojo.bindings.DataHeader.HEADER_SIZE + org.chromium.mojo.bindings.BindingsHelper.POINTER_SIZE, org.chromium.mojo.bindings.BindingsHelper.NOTHING_NULLABLE, keys0.length);
                    }
                    result.modifiedRuntimeFeatures = new java.util.HashMap<Integer, Boolean>();
                    for (int index0 = 0; index0 < keys0.length; ++index0) {
                        result.modifiedRuntimeFeatures.put(keys0[index0],  values0[index0]);
                    }
                }
                }
                {
                    
                org.chromium.mojo.bindings.Decoder decoder1 = decoder0.readPointer(264, true);
                result.fencedFrameProperties = FencedFrameProperties.decode(decoder1);
                }
                {
                    
                org.chromium.mojo.bindings.Decoder decoder1 = decoder0.readPointer(272, true);
                result.notRestoredReasons = BackForwardCacheNotRestoredReasons.decode(decoder1);
                }
                {
                    
                org.chromium.mojo.bindings.Decoder decoder1 = decoder0.readPointer(280, true);
                result.browsingContextGroupInfo = BrowsingContextGroupInfo.decode(decoder1);
                }
                {
                    
                org.chromium.mojo.bindings.Decoder decoder1 = decoder0.readPointer(288, true);
                result.lcppHint = LcpCriticalPathPredictorNavigationTimeHint.decode(decoder1);
                }
                {
                    
                org.chromium.mojo.bindings.Decoder decoder1 = decoder0.readPointer(296, false);
                result.contentSettings = RendererContentSettings.decode(decoder1);
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
        
        encoder0.encode(this.originToCommit, 8, true);
        
        encoder0.encode(this.storageKey, 16, false);
        
        encoder0.encode(this.sessionStorageKey, 24, false);
        
        encoder0.encode(this.isOverridingUserAgent, 32, 0);
        
        encoder0.encode(this.canLoadLocalResources, 32, 1);
        
        encoder0.encode(this.intendedAsNewEntry, 32, 2);
        
        encoder0.encode(this.wasDiscarded, 32, 3);
        
        encoder0.encode(this.isViewSource, 32, 4);
        
        encoder0.encode(this.shouldClearHistoryList, 32, 5);
        
        encoder0.encode(this.isBrowserInitiated, 32, 6);
        
        encoder0.encode(this.originAgentCluster, 32, 7);
        
        encoder0.encode(this.originAgentClusterLeftAsDefault, 33, 0);
        
        encoder0.encode(this.isCrossSiteCrossBrowsingContextGroup, 33, 1);
        
        encoder0.encode(this.isLoadDataWithBaseUrl, 33, 2);
        
        encoder0.encode(this.ancestorOrSelfHasCspee, 33, 3);
        
        encoder0.encode(this.loadWithStorageAccess, 33, 4);
        
        encoder0.encode(this.navEntryId, 36);
        
        if (this.redirects == null) {
            encoder0.encodeNullPointer(40, false);
        } else {
            org.chromium.mojo.bindings.Encoder encoder1 = encoder0.encodePointerArray(this.redirects.length, 40, org.chromium.mojo.bindings.BindingsHelper.UNSPECIFIED_ARRAY_LENGTH);
            for (int i0 = 0; i0 < this.redirects.length; ++i0) {
                
                encoder1.encode(this.redirects[i0], org.chromium.mojo.bindings.DataHeader.HEADER_SIZE + org.chromium.mojo.bindings.BindingsHelper.POINTER_SIZE * i0, false);
            }
        }
        
        if (this.redirectResponse == null) {
            encoder0.encodeNullPointer(48, false);
        } else {
            org.chromium.mojo.bindings.Encoder encoder1 = encoder0.encodePointerArray(this.redirectResponse.length, 48, org.chromium.mojo.bindings.BindingsHelper.UNSPECIFIED_ARRAY_LENGTH);
            for (int i0 = 0; i0 < this.redirectResponse.length; ++i0) {
                
                encoder1.encode(this.redirectResponse[i0], org.chromium.mojo.bindings.DataHeader.HEADER_SIZE + org.chromium.mojo.bindings.BindingsHelper.POINTER_SIZE * i0, false);
            }
        }
        
        if (this.redirectInfos == null) {
            encoder0.encodeNullPointer(56, false);
        } else {
            org.chromium.mojo.bindings.Encoder encoder1 = encoder0.encodePointerArray(this.redirectInfos.length, 56, org.chromium.mojo.bindings.BindingsHelper.UNSPECIFIED_ARRAY_LENGTH);
            for (int i0 = 0; i0 < this.redirectInfos.length; ++i0) {
                
                encoder1.encode(this.redirectInfos[i0], org.chromium.mojo.bindings.DataHeader.HEADER_SIZE + org.chromium.mojo.bindings.BindingsHelper.POINTER_SIZE * i0, false);
            }
        }
        
        encoder0.encode(this.postContentType, 64, false);
        
        encoder0.encode(this.originalUrl, 72, false);
        
        encoder0.encode(this.originalMethod, 80, false);
        
        encoder0.encode(this.pageState, 88, false);
        
        if (this.subframeUniqueNames == null) {
            encoder0.encodeNullPointer(96, false);
        } else {
            org.chromium.mojo.bindings.Encoder encoder1 = encoder0.encoderForMap(96);
            int size0 = this.subframeUniqueNames.size();
            String[] keys0 = new String[size0];
            boolean[] values0 = new boolean[size0];
            int index0 = 0;
            for (java.util.Map.Entry<String, Boolean> entry0 : this.subframeUniqueNames.entrySet()) {
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
            
            encoder1.encode(values0, org.chromium.mojo.bindings.DataHeader.HEADER_SIZE + org.chromium.mojo.bindings.BindingsHelper.POINTER_SIZE, org.chromium.mojo.bindings.BindingsHelper.NOTHING_NULLABLE, org.chromium.mojo.bindings.BindingsHelper.UNSPECIFIED_ARRAY_LENGTH);
        }
        
        encoder0.encode(this.pendingHistoryListOffset, 104);
        
        encoder0.encode(this.currentHistoryListOffset, 108);
        
        encoder0.encode(this.currentHistoryListLength, 112);
        
        encoder0.encode(this.wasActivated, 116);
        
        encoder0.encode(this.navigationTiming, 120, false);
        
        encoder0.encode(this.navigationToken, 128, false);
        
        if (this.prefetchedSignedExchanges == null) {
            encoder0.encodeNullPointer(136, false);
        } else {
            org.chromium.mojo.bindings.Encoder encoder1 = encoder0.encodePointerArray(this.prefetchedSignedExchanges.length, 136, org.chromium.mojo.bindings.BindingsHelper.UNSPECIFIED_ARRAY_LENGTH);
            for (int i0 = 0; i0 < this.prefetchedSignedExchanges.length; ++i0) {
                
                encoder1.encode(this.prefetchedSignedExchanges[i0], org.chromium.mojo.bindings.DataHeader.HEADER_SIZE + org.chromium.mojo.bindings.BindingsHelper.POINTER_SIZE * i0, false);
            }
        }
        
        encoder0.encode(this.dataUrlAsString, 144, false);
        
        encoder0.encode(this.documentUkmSourceId, 152);
        
        encoder0.encode(this.framePolicy, 160, false);
        
        if (this.forceEnabledOriginTrials == null) {
            encoder0.encodeNullPointer(168, false);
        } else {
            org.chromium.mojo.bindings.Encoder encoder1 = encoder0.encodePointerArray(this.forceEnabledOriginTrials.length, 168, org.chromium.mojo.bindings.BindingsHelper.UNSPECIFIED_ARRAY_LENGTH);
            for (int i0 = 0; i0 < this.forceEnabledOriginTrials.length; ++i0) {
                
                encoder1.encode(this.forceEnabledOriginTrials[i0], org.chromium.mojo.bindings.DataHeader.HEADER_SIZE + org.chromium.mojo.bindings.BindingsHelper.POINTER_SIZE * i0, false);
            }
        }
        
        encoder0.encode(this.enabledClientHints, 176, org.chromium.mojo.bindings.BindingsHelper.NOTHING_NULLABLE, org.chromium.mojo.bindings.BindingsHelper.UNSPECIFIED_ARRAY_LENGTH);
        
        encoder0.encode(this.oldPageInfo, 184, true);
        
        encoder0.encode(this.httpResponseCode, 192);
        
        encoder0.encode(this.navigationDeliveryType, 196);
        
        encoder0.encode(this.navigationApiHistoryEntryArrays, 200, false);
        
        if (this.earlyHintsPreloadedResources == null) {
            encoder0.encodeNullPointer(208, false);
        } else {
            org.chromium.mojo.bindings.Encoder encoder1 = encoder0.encodePointerArray(this.earlyHintsPreloadedResources.length, 208, org.chromium.mojo.bindings.BindingsHelper.UNSPECIFIED_ARRAY_LENGTH);
            for (int i0 = 0; i0 < this.earlyHintsPreloadedResources.length; ++i0) {
                
                encoder1.encode(this.earlyHintsPreloadedResources[i0], org.chromium.mojo.bindings.DataHeader.HEADER_SIZE + org.chromium.mojo.bindings.BindingsHelper.POINTER_SIZE * i0, false);
            }
        }
        
        encoder0.encode(this.commitSent, 216, false);
        
        encoder0.encode(this.srcdocValue, 224, false);
        
        encoder0.encode(this.reducedAcceptLanguage, 232, false);
        
        encoder0.encode(this.viewTransitionState, 240, true);
        
        encoder0.encode(this.softNavigationHeuristicsTaskId, 248, true);
        
        if (this.modifiedRuntimeFeatures == null) {
            encoder0.encodeNullPointer(256, false);
        } else {
            org.chromium.mojo.bindings.Encoder encoder1 = encoder0.encoderForMap(256);
            int size0 = this.modifiedRuntimeFeatures.size();
            int[] keys0 = new int[size0];
            boolean[] values0 = new boolean[size0];
            int index0 = 0;
            for (java.util.Map.Entry<Integer, Boolean> entry0 : this.modifiedRuntimeFeatures.entrySet()) {
                keys0[index0] = entry0.getKey();
                values0[index0] = entry0.getValue();
                ++index0;
            }
            
            encoder1.encode(keys0, org.chromium.mojo.bindings.DataHeader.HEADER_SIZE, org.chromium.mojo.bindings.BindingsHelper.NOTHING_NULLABLE, org.chromium.mojo.bindings.BindingsHelper.UNSPECIFIED_ARRAY_LENGTH);
            
            encoder1.encode(values0, org.chromium.mojo.bindings.DataHeader.HEADER_SIZE + org.chromium.mojo.bindings.BindingsHelper.POINTER_SIZE, org.chromium.mojo.bindings.BindingsHelper.NOTHING_NULLABLE, org.chromium.mojo.bindings.BindingsHelper.UNSPECIFIED_ARRAY_LENGTH);
        }
        
        encoder0.encode(this.fencedFrameProperties, 264, true);
        
        encoder0.encode(this.notRestoredReasons, 272, true);
        
        encoder0.encode(this.browsingContextGroupInfo, 280, true);
        
        encoder0.encode(this.lcppHint, 288, true);
        
        encoder0.encode(this.contentSettings, 296, false);
    }
}