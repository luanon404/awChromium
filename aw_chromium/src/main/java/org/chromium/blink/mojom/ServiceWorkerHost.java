// ServiceWorkerHost.java is auto generated by mojom_bindings_generator.py, do not edit


// Copyright 2014 The Chromium Authors
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.

// This file is autogenerated by:
//     mojo/public/tools/bindings/mojom_bindings_generator.py
// For:
//     third_party/blink/public/mojom/service_worker/service_worker.mojom
//

package org.chromium.blink.mojom;

import androidx.annotation.IntDef;


public interface ServiceWorkerHost extends org.chromium.mojo.bindings.Interface {



    public interface Proxy extends ServiceWorkerHost, org.chromium.mojo.bindings.Interface.Proxy {
    }

    Manager<ServiceWorkerHost, ServiceWorkerHost.Proxy> MANAGER = ServiceWorkerHost_Internal.MANAGER;

    void setCachedMetadata(
org.chromium.url.mojom.Url url, org.chromium.mojo_base.mojom.ReadOnlyBuffer data);


    void clearCachedMetadata(
org.chromium.url.mojom.Url url);


    void getClients(
ServiceWorkerClientQueryOptions options, 
GetClients_Response callback);

    interface GetClients_Response extends org.chromium.mojo.bindings.Callbacks.Callback1<ServiceWorkerClientInfo[]> { }


    void getClient(
String clientUuid, 
GetClient_Response callback);

    interface GetClient_Response extends org.chromium.mojo.bindings.Callbacks.Callback1<ServiceWorkerClientInfo> { }


    void openNewTab(
org.chromium.url.mojom.Url url, 
OpenNewTab_Response callback);

    interface OpenNewTab_Response extends org.chromium.mojo.bindings.Callbacks.Callback3<Boolean, ServiceWorkerClientInfo, String> { }


    void openPaymentHandlerWindow(
org.chromium.url.mojom.Url url, 
OpenPaymentHandlerWindow_Response callback);

    interface OpenPaymentHandlerWindow_Response extends org.chromium.mojo.bindings.Callbacks.Callback3<Boolean, ServiceWorkerClientInfo, String> { }


    void postMessageToClient(
String clientUuid, TransferableMessage message);


    void focusClient(
String clientUuid, 
FocusClient_Response callback);

    interface FocusClient_Response extends org.chromium.mojo.bindings.Callbacks.Callback1<ServiceWorkerClientInfo> { }


    void navigateClient(
String clientUuid, org.chromium.url.mojom.Url url, 
NavigateClient_Response callback);

    interface NavigateClient_Response extends org.chromium.mojo.bindings.Callbacks.Callback3<Boolean, ServiceWorkerClientInfo, String> { }


    void skipWaiting(

SkipWaiting_Response callback);

    interface SkipWaiting_Response extends org.chromium.mojo.bindings.Callbacks.Callback1<Boolean> { }


    void claimClients(

ClaimClients_Response callback);

    interface ClaimClients_Response extends org.chromium.mojo.bindings.Callbacks.Callback2<Integer, String> { }


    void registerRouter(
ServiceWorkerRouterRules rules, 
RegisterRouter_Response callback);

    interface RegisterRouter_Response extends org.chromium.mojo.bindings.Callbacks.Callback0 { }


}
