// UrlLoaderNetworkServiceObserver.java is auto generated by mojom_bindings_generator.py, do not edit


// Copyright 2014 The Chromium Authors
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.

// This file is autogenerated by:
//     mojo/public/tools/bindings/mojom_bindings_generator.py
// For:
//     services/network/public/mojom/url_loader_network_service_observer.mojom
//

package org.chromium.network.mojom;

import androidx.annotation.IntDef;


public interface UrlLoaderNetworkServiceObserver extends org.chromium.mojo.bindings.Interface {



    public interface Proxy extends UrlLoaderNetworkServiceObserver, org.chromium.mojo.bindings.Interface.Proxy {
    }

    Manager<UrlLoaderNetworkServiceObserver, UrlLoaderNetworkServiceObserver.Proxy> MANAGER = UrlLoaderNetworkServiceObserver_Internal.MANAGER;

    void onSslCertificateError(
org.chromium.url.mojom.Url url, int netError, SslInfo sslInfo, boolean fatal, 
OnSslCertificateError_Response callback);

    interface OnSslCertificateError_Response extends org.chromium.mojo.bindings.Callbacks.Callback1<Integer> { }


    void onCertificateRequested(
org.chromium.mojo_base.mojom.UnguessableToken windowId, SslCertRequestInfo certInfo, ClientCertificateResponder certResponder);


    void onAuthRequired(
org.chromium.mojo_base.mojom.UnguessableToken windowId, int requestId, org.chromium.url.mojom.Url url, boolean firstAuthAttempt, AuthChallengeInfo authInfo, HttpResponseHeaders headHeaders, AuthChallengeResponder authChallengeResponder);


    void onPrivateNetworkAccessPermissionRequired(
org.chromium.url.mojom.Url url, IpAddress ipAddress, String privateNetworkDeviceId, String privateNetworkDeviceName, 
OnPrivateNetworkAccessPermissionRequired_Response callback);

    interface OnPrivateNetworkAccessPermissionRequired_Response extends org.chromium.mojo.bindings.Callbacks.Callback1<Boolean> { }


    void onClearSiteData(
org.chromium.url.mojom.Url url, String headerValue, int loadFlags, CookiePartitionKey cookiePartitionKey, boolean partitionedStateAllowedOnly, 
OnClearSiteData_Response callback);

    interface OnClearSiteData_Response extends org.chromium.mojo.bindings.Callbacks.Callback0 { }


    void onLoadingStateUpdate(
LoadInfo info, 
OnLoadingStateUpdate_Response callback);

    interface OnLoadingStateUpdate_Response extends org.chromium.mojo.bindings.Callbacks.Callback0 { }


    void onDataUseUpdate(
int networkTrafficAnnotationIdHash, long recvBytes, long sentBytes);


    void onSharedStorageHeaderReceived(
org.chromium.url.internal.mojom.Origin requestOrigin, SharedStorageOperation[] operations, 
OnSharedStorageHeaderReceived_Response callback);

    interface OnSharedStorageHeaderReceived_Response extends org.chromium.mojo.bindings.Callbacks.Callback0 { }


    void clone(
org.chromium.mojo.bindings.InterfaceRequest<UrlLoaderNetworkServiceObserver> listener);


}
