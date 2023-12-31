// ProxyResolver.java is auto generated by mojom_bindings_generator.py, do not edit


// Copyright 2014 The Chromium Authors
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.

// This file is autogenerated by:
//     mojo/public/tools/bindings/mojom_bindings_generator.py
// For:
//     services/proxy_resolver/public/mojom/proxy_resolver.mojom
//

package org.chromium.proxy_resolver.mojom;

import androidx.annotation.IntDef;


public interface ProxyResolver extends org.chromium.mojo.bindings.Interface {



    public interface Proxy extends ProxyResolver, org.chromium.mojo.bindings.Interface.Proxy {
    }

    Manager<ProxyResolver, ProxyResolver.Proxy> MANAGER = ProxyResolver_Internal.MANAGER;

    void getProxyForUrl(
org.chromium.url.mojom.Url url, org.chromium.network.mojom.NetworkAnonymizationKey networkAnonymizationKey, ProxyResolverRequestClient client);


}
