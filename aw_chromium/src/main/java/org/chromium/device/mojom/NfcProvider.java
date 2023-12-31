// NfcProvider.java is auto generated by mojom_bindings_generator.py, do not edit


// Copyright 2014 The Chromium Authors
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.

// This file is autogenerated by:
//     mojo/public/tools/bindings/mojom_bindings_generator.py
// For:
//     services/device/public/mojom/nfc_provider.mojom
//

package org.chromium.device.mojom;

import androidx.annotation.IntDef;


public interface NfcProvider extends org.chromium.mojo.bindings.Interface {



    public interface Proxy extends NfcProvider, org.chromium.mojo.bindings.Interface.Proxy {
    }

    Manager<NfcProvider, NfcProvider.Proxy> MANAGER = NfcProvider_Internal.MANAGER;

    void getNfcForHost(
int hostId, org.chromium.mojo.bindings.InterfaceRequest<Nfc> receiver);


    void suspendNfcOperations(
);


    void resumeNfcOperations(
);


}
