// SslPrivateKey.java is auto generated by mojom_bindings_generator.py, do not edit


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


public interface SslPrivateKey extends org.chromium.mojo.bindings.Interface {



    public interface Proxy extends SslPrivateKey, org.chromium.mojo.bindings.Interface.Proxy {
    }

    Manager<SslPrivateKey, SslPrivateKey.Proxy> MANAGER = SslPrivateKey_Internal.MANAGER;

    void sign(
short algorithm, byte[] input, 
Sign_Response callback);

    interface Sign_Response extends org.chromium.mojo.bindings.Callbacks.Callback2<Integer, byte[]> { }


}
