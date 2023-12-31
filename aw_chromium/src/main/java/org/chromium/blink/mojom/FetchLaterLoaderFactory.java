// FetchLaterLoaderFactory.java is auto generated by mojom_bindings_generator.py, do not edit


// Copyright 2014 The Chromium Authors
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.

// This file is autogenerated by:
//     mojo/public/tools/bindings/mojom_bindings_generator.py
// For:
//     third_party/blink/public/mojom/loader/fetch_later.mojom
//

package org.chromium.blink.mojom;

import androidx.annotation.IntDef;


public interface FetchLaterLoaderFactory extends org.chromium.mojo.bindings.Interface {



    public interface Proxy extends FetchLaterLoaderFactory, org.chromium.mojo.bindings.Interface.Proxy {
    }

    Manager<FetchLaterLoaderFactory, FetchLaterLoaderFactory.Proxy> MANAGER = FetchLaterLoaderFactory_Internal.MANAGER;

    void createLoader(
org.chromium.mojo.bindings.AssociatedInterfaceRequestNotSupported loader, int requestId, int options, org.chromium.network.mojom.UrlRequest request, org.chromium.network.mojom.MutableNetworkTrafficAnnotationTag trafficAnnotation);


    void clone(
org.chromium.mojo.bindings.AssociatedInterfaceRequestNotSupported factory);


}
