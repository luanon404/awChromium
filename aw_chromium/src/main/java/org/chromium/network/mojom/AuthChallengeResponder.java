// AuthChallengeResponder.java is auto generated by mojom_bindings_generator.py, do not edit


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


public interface AuthChallengeResponder extends org.chromium.mojo.bindings.Interface {



    public interface Proxy extends AuthChallengeResponder, org.chromium.mojo.bindings.Interface.Proxy {
    }

    Manager<AuthChallengeResponder, AuthChallengeResponder.Proxy> MANAGER = AuthChallengeResponder_Internal.MANAGER;

    void onAuthCredentials(
AuthCredentials credentials);


}
