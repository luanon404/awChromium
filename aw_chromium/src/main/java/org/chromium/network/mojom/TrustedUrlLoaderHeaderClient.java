// TrustedUrlLoaderHeaderClient.java is auto generated by mojom_bindings_generator.py, do not edit


// Copyright 2014 The Chromium Authors
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.

// This file is autogenerated by:
//     mojo/public/tools/bindings/mojom_bindings_generator.py
// For:
//     services/network/public/mojom/network_context.mojom
//

package org.chromium.network.mojom;

import androidx.annotation.IntDef;


public interface TrustedUrlLoaderHeaderClient extends org.chromium.mojo.bindings.Interface {



    public interface Proxy extends TrustedUrlLoaderHeaderClient, org.chromium.mojo.bindings.Interface.Proxy {
    }

    Manager<TrustedUrlLoaderHeaderClient, TrustedUrlLoaderHeaderClient.Proxy> MANAGER = TrustedUrlLoaderHeaderClient_Internal.MANAGER;

    void onLoaderCreated(
int requestId, org.chromium.mojo.bindings.InterfaceRequest<TrustedHeaderClient> headerClient);


    void onLoaderForCorsPreflightCreated(
UrlRequest request, org.chromium.mojo.bindings.InterfaceRequest<TrustedHeaderClient> headerClient);


}
