// InspectorIssueDetails.java is auto generated by mojom_bindings_generator.py, do not edit


// Copyright 2014 The Chromium Authors
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.

// This file is autogenerated by:
//     mojo/public/tools/bindings/mojom_bindings_generator.py
// For:
//     third_party/blink/public/mojom/devtools/inspector_issue.mojom
//

package org.chromium.blink.mojom;

import androidx.annotation.IntDef;


public final class InspectorIssueDetails extends org.chromium.mojo.bindings.Struct {

    private static final int STRUCT_SIZE = 128;
    private static final org.chromium.mojo.bindings.DataHeader[] VERSION_ARRAY = new org.chromium.mojo.bindings.DataHeader[] {new org.chromium.mojo.bindings.DataHeader(128, 0)};
    private static final org.chromium.mojo.bindings.DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
    public CookieIssueDetails cookieIssueDetails;
    public MixedContentIssueDetails mixedContentIssueDetails;
    public BlockedByResponseIssueDetails blockedByResponseIssueDetails;
    public ContentSecurityPolicyIssueDetails cspIssueDetails;
    public SharedArrayBufferIssueDetails sabIssueDetails;
    public HeavyAdIssueDetails heavyAdIssueDetails;
    public AttributionReportingIssueDetails attributionReportingIssueDetails;
    public LowTextContrastIssue lowTextContrastDetails;
    public FederatedAuthRequestIssueDetails federatedAuthRequestDetails;
    public BounceTrackingIssueDetails bounceTrackingIssueDetails;
    public CookieDeprecationMetadataIssueDetails cookieDeprecationMetadataIssueDetails;
    public GenericIssueDetails genericIssueDetails;
    public DeprecationIssueDetails deprecationIssueDetails;
    public FederatedAuthUserInfoRequestIssueDetails federatedAuthUserInfoRequestDetails;
    public org.chromium.mojo_base.mojom.UnguessableToken issueId;

    private InspectorIssueDetails(int version) {
        super(STRUCT_SIZE, version);
    }

    public InspectorIssueDetails() {
        this(0);
    }

    public static InspectorIssueDetails deserialize(org.chromium.mojo.bindings.Message message) {
        return decode(new org.chromium.mojo.bindings.Decoder(message));
    }

    /**
     * Similar to the method above, but deserializes from a |ByteBuffer| instance.
     *
     * @throws org.chromium.mojo.bindings.DeserializationException on deserialization failure.
     */
    public static InspectorIssueDetails deserialize(java.nio.ByteBuffer data) {
        return deserialize(new org.chromium.mojo.bindings.Message(
                data, new java.util.ArrayList<org.chromium.mojo.system.Handle>()));
    }

    @SuppressWarnings("unchecked")
    public static InspectorIssueDetails decode(org.chromium.mojo.bindings.Decoder decoder0) {
        if (decoder0 == null) {
            return null;
        }
        decoder0.increaseStackDepth();
        InspectorIssueDetails result;
        try {
            org.chromium.mojo.bindings.DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
            final int elementsOrVersion = mainDataHeader.elementsOrVersion;
            result = new InspectorIssueDetails(elementsOrVersion);
                {
                    
                org.chromium.mojo.bindings.Decoder decoder1 = decoder0.readPointer(8, true);
                result.cookieIssueDetails = CookieIssueDetails.decode(decoder1);
                }
                {
                    
                org.chromium.mojo.bindings.Decoder decoder1 = decoder0.readPointer(16, true);
                result.mixedContentIssueDetails = MixedContentIssueDetails.decode(decoder1);
                }
                {
                    
                org.chromium.mojo.bindings.Decoder decoder1 = decoder0.readPointer(24, true);
                result.blockedByResponseIssueDetails = BlockedByResponseIssueDetails.decode(decoder1);
                }
                {
                    
                org.chromium.mojo.bindings.Decoder decoder1 = decoder0.readPointer(32, true);
                result.cspIssueDetails = ContentSecurityPolicyIssueDetails.decode(decoder1);
                }
                {
                    
                org.chromium.mojo.bindings.Decoder decoder1 = decoder0.readPointer(40, true);
                result.sabIssueDetails = SharedArrayBufferIssueDetails.decode(decoder1);
                }
                {
                    
                org.chromium.mojo.bindings.Decoder decoder1 = decoder0.readPointer(48, true);
                result.heavyAdIssueDetails = HeavyAdIssueDetails.decode(decoder1);
                }
                {
                    
                org.chromium.mojo.bindings.Decoder decoder1 = decoder0.readPointer(56, true);
                result.attributionReportingIssueDetails = AttributionReportingIssueDetails.decode(decoder1);
                }
                {
                    
                org.chromium.mojo.bindings.Decoder decoder1 = decoder0.readPointer(64, true);
                result.lowTextContrastDetails = LowTextContrastIssue.decode(decoder1);
                }
                {
                    
                org.chromium.mojo.bindings.Decoder decoder1 = decoder0.readPointer(72, true);
                result.federatedAuthRequestDetails = FederatedAuthRequestIssueDetails.decode(decoder1);
                }
                {
                    
                org.chromium.mojo.bindings.Decoder decoder1 = decoder0.readPointer(80, true);
                result.bounceTrackingIssueDetails = BounceTrackingIssueDetails.decode(decoder1);
                }
                {
                    
                org.chromium.mojo.bindings.Decoder decoder1 = decoder0.readPointer(88, true);
                result.cookieDeprecationMetadataIssueDetails = CookieDeprecationMetadataIssueDetails.decode(decoder1);
                }
                {
                    
                org.chromium.mojo.bindings.Decoder decoder1 = decoder0.readPointer(96, true);
                result.genericIssueDetails = GenericIssueDetails.decode(decoder1);
                }
                {
                    
                org.chromium.mojo.bindings.Decoder decoder1 = decoder0.readPointer(104, true);
                result.deprecationIssueDetails = DeprecationIssueDetails.decode(decoder1);
                }
                {
                    
                org.chromium.mojo.bindings.Decoder decoder1 = decoder0.readPointer(112, true);
                result.federatedAuthUserInfoRequestDetails = FederatedAuthUserInfoRequestIssueDetails.decode(decoder1);
                }
                {
                    
                org.chromium.mojo.bindings.Decoder decoder1 = decoder0.readPointer(120, true);
                result.issueId = org.chromium.mojo_base.mojom.UnguessableToken.decode(decoder1);
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
        
        encoder0.encode(this.cookieIssueDetails, 8, true);
        
        encoder0.encode(this.mixedContentIssueDetails, 16, true);
        
        encoder0.encode(this.blockedByResponseIssueDetails, 24, true);
        
        encoder0.encode(this.cspIssueDetails, 32, true);
        
        encoder0.encode(this.sabIssueDetails, 40, true);
        
        encoder0.encode(this.heavyAdIssueDetails, 48, true);
        
        encoder0.encode(this.attributionReportingIssueDetails, 56, true);
        
        encoder0.encode(this.lowTextContrastDetails, 64, true);
        
        encoder0.encode(this.federatedAuthRequestDetails, 72, true);
        
        encoder0.encode(this.bounceTrackingIssueDetails, 80, true);
        
        encoder0.encode(this.cookieDeprecationMetadataIssueDetails, 88, true);
        
        encoder0.encode(this.genericIssueDetails, 96, true);
        
        encoder0.encode(this.deprecationIssueDetails, 104, true);
        
        encoder0.encode(this.federatedAuthUserInfoRequestDetails, 112, true);
        
        encoder0.encode(this.issueId, 120, true);
    }
}