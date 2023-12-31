// DevToolsObserver.java is auto generated by mojom_bindings_generator.py, do not edit


// Copyright 2014 The Chromium Authors
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.

// This file is autogenerated by:
//     mojo/public/tools/bindings/mojom_bindings_generator.py
// For:
//     services/network/public/mojom/devtools_observer.mojom
//

package org.chromium.network.mojom;

import androidx.annotation.IntDef;


public interface DevToolsObserver extends org.chromium.mojo.bindings.Interface {



    public interface Proxy extends DevToolsObserver, org.chromium.mojo.bindings.Interface.Proxy {
    }

    Manager<DevToolsObserver, DevToolsObserver.Proxy> MANAGER = DevToolsObserver_Internal.MANAGER;

    void onRawRequest(
String devtoolRequestId, CookieWithAccessResult[] cookiesWithAccessResult, HttpRawHeaderPair[] headers, org.chromium.mojo_base.mojom.TimeTicks timestamp, ClientSecurityState clientSecurityState, OtherPartitionInfo otherPartitionInfo);


    void onRawResponse(
String devtoolRequestId, CookieAndLineWithAccessResult[] cookiesWithAccessResult, HttpRawHeaderPair[] headers, String rawResponseHeaders, int resourceAddressSpace, int httpStatusCode, CookiePartitionKey cookiePartitionKey);


    void onPrivateNetworkRequest(
String devtoolRequestId, org.chromium.url.mojom.Url url, boolean isWarning, int resourceAddressSpace, ClientSecurityState clientSecurityState);


    void onCorsPreflightRequest(
org.chromium.mojo_base.mojom.UnguessableToken devtoolRequestId, HttpRequestHeaders requestHeaders, UrlRequestDevToolsInfo requestInfo, org.chromium.url.mojom.Url initiatorUrl, String initiatorDevtoolRequestId);


    void onCorsPreflightResponse(
org.chromium.mojo_base.mojom.UnguessableToken devtoolRequestId, org.chromium.url.mojom.Url url, UrlResponseHeadDevToolsInfo head);


    void onCorsPreflightRequestCompleted(
org.chromium.mojo_base.mojom.UnguessableToken devtoolRequestId, UrlLoaderCompletionStatus status);


    void onTrustTokenOperationDone(
String devtoolRequestId, TrustTokenOperationResult result);


    void onCorsError(
String devtoolRequestId, org.chromium.url.internal.mojom.Origin initiatorOrigin, ClientSecurityState clientSecurityState, org.chromium.url.mojom.Url url, CorsErrorStatus status, boolean isWarning);


    void onCorbError(
String devtoolsRequestId, org.chromium.url.mojom.Url url);


    void onSubresourceWebBundleMetadata(
String devtoolRequestId, org.chromium.url.mojom.Url[] urls);


    void onSubresourceWebBundleMetadataError(
String devtoolRequestId, String errorMessage);


    void onSubresourceWebBundleInnerResponse(
String innerRequestDevtoolsId, org.chromium.url.mojom.Url url, String bundleRequestDevtoolsId);


    void onSubresourceWebBundleInnerResponseError(
String innerRequestDevtoolsId, org.chromium.url.mojom.Url url, String errorMessage, String bundleRequestDevtoolsId);


    void clone(
org.chromium.mojo.bindings.InterfaceRequest<DevToolsObserver> listener);


}
