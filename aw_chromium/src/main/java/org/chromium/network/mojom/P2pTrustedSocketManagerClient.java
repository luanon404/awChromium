// P2pTrustedSocketManagerClient.java is auto generated by mojom_bindings_generator.py, do not edit


// Copyright 2014 The Chromium Authors
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.

// This file is autogenerated by:
//     mojo/public/tools/bindings/mojom_bindings_generator.py
// For:
//     services/network/public/mojom/p2p_trusted.mojom
//

package org.chromium.network.mojom;

import androidx.annotation.IntDef;


public interface P2pTrustedSocketManagerClient extends org.chromium.mojo.bindings.Interface {



    public interface Proxy extends P2pTrustedSocketManagerClient, org.chromium.mojo.bindings.Interface.Proxy {
    }

    Manager<P2pTrustedSocketManagerClient, P2pTrustedSocketManagerClient.Proxy> MANAGER = P2pTrustedSocketManagerClient_Internal.MANAGER;

    void invalidSocketPortRangeRequested(
);


    void dumpPacket(
byte[] packetHeader, long packetLength, boolean incoming);


}
