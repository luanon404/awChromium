// ServiceWorkerRouterCondition.java is auto generated by mojom_bindings_generator.py, do not edit


// Copyright 2014 The Chromium Authors
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.

// This file is autogenerated by:
//     mojo/public/tools/bindings/mojom_bindings_generator.py
// For:
//     third_party/blink/public/mojom/service_worker/service_worker_router_rule.mojom
//

package org.chromium.blink.mojom;

import androidx.annotation.IntDef;


public final class ServiceWorkerRouterCondition extends org.chromium.mojo.bindings.Union {

    public static final class Tag {
        public static final int UrlPattern = 0;
        public static final int Request = 1;
        public static final int RunningStatus = 2;
        public static final int OrCondition = 3;
    };
    private SafeUrlPattern mUrlPattern;
    private ServiceWorkerRouterRequestCondition mRequest;
    private ServiceWorkerRouterRunningStatusCondition mRunningStatus;
    private ServiceWorkerRouterOrCondition mOrCondition;

    public void setUrlPattern(SafeUrlPattern urlPattern) {
        this.mTag = Tag.UrlPattern;
        this.mUrlPattern = urlPattern;
    }

    public SafeUrlPattern getUrlPattern() {
        assert this.mTag == Tag.UrlPattern;
        return this.mUrlPattern;
    }

    public void setRequest(ServiceWorkerRouterRequestCondition request) {
        this.mTag = Tag.Request;
        this.mRequest = request;
    }

    public ServiceWorkerRouterRequestCondition getRequest() {
        assert this.mTag == Tag.Request;
        return this.mRequest;
    }

    public void setRunningStatus(ServiceWorkerRouterRunningStatusCondition runningStatus) {
        this.mTag = Tag.RunningStatus;
        this.mRunningStatus = runningStatus;
    }

    public ServiceWorkerRouterRunningStatusCondition getRunningStatus() {
        assert this.mTag == Tag.RunningStatus;
        return this.mRunningStatus;
    }

    public void setOrCondition(ServiceWorkerRouterOrCondition orCondition) {
        this.mTag = Tag.OrCondition;
        this.mOrCondition = orCondition;
    }

    public ServiceWorkerRouterOrCondition getOrCondition() {
        assert this.mTag == Tag.OrCondition;
        return this.mOrCondition;
    }


    @Override
    protected final void encode(org.chromium.mojo.bindings.Encoder encoder0, int offset) {
        encoder0.encode(org.chromium.mojo.bindings.BindingsHelper.UNION_SIZE, offset);
        encoder0.encode(this.mTag, offset + 4);
        switch (mTag) {
            case Tag.UrlPattern: {
                
                encoder0.encode(this.mUrlPattern, offset + 8, false);
                break;
            }
            case Tag.Request: {
                
                encoder0.encode(this.mRequest, offset + 8, false);
                break;
            }
            case Tag.RunningStatus: {
                
                encoder0.encode(this.mRunningStatus, offset + 8, false);
                break;
            }
            case Tag.OrCondition: {
                
                encoder0.encode(this.mOrCondition, offset + 8, false);
                break;
            }
            default: {
                break;
            }
        }
    }

    public static ServiceWorkerRouterCondition deserialize(org.chromium.mojo.bindings.Message message) {
        return decode(new org.chromium.mojo.bindings.Decoder(message).decoderForSerializedUnion(), 0);
    }

    public static final ServiceWorkerRouterCondition decode(org.chromium.mojo.bindings.Decoder decoder0, int offset) {
        org.chromium.mojo.bindings.DataHeader dataHeader = decoder0.readDataHeaderForUnion(offset);
        if (dataHeader.size == 0) {
            return null;
        }
        ServiceWorkerRouterCondition result = new ServiceWorkerRouterCondition();
        switch (dataHeader.elementsOrVersion) {
            case Tag.UrlPattern: {
                
                org.chromium.mojo.bindings.Decoder decoder1 = decoder0.readPointer(offset + org.chromium.mojo.bindings.DataHeader.HEADER_SIZE, false);
                result.mUrlPattern = SafeUrlPattern.decode(decoder1);
                result.mTag = Tag.UrlPattern;
                break;
            }
            case Tag.Request: {
                
                org.chromium.mojo.bindings.Decoder decoder1 = decoder0.readPointer(offset + org.chromium.mojo.bindings.DataHeader.HEADER_SIZE, false);
                result.mRequest = ServiceWorkerRouterRequestCondition.decode(decoder1);
                result.mTag = Tag.Request;
                break;
            }
            case Tag.RunningStatus: {
                
                org.chromium.mojo.bindings.Decoder decoder1 = decoder0.readPointer(offset + org.chromium.mojo.bindings.DataHeader.HEADER_SIZE, false);
                result.mRunningStatus = ServiceWorkerRouterRunningStatusCondition.decode(decoder1);
                result.mTag = Tag.RunningStatus;
                break;
            }
            case Tag.OrCondition: {
                
                org.chromium.mojo.bindings.Decoder decoder1 = decoder0.readPointer(offset + org.chromium.mojo.bindings.DataHeader.HEADER_SIZE, false);
                result.mOrCondition = ServiceWorkerRouterOrCondition.decode(decoder1);
                result.mTag = Tag.OrCondition;
                break;
            }
            default: {
                break;
            }
        }
        return result;
    }
}