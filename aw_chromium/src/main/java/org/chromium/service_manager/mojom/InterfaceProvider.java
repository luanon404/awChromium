// InterfaceProvider.java is auto generated by mojom_bindings_generator.py, do not edit


// Copyright 2014 The Chromium Authors
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.

// This file is autogenerated by:
//     mojo/public/tools/bindings/mojom_bindings_generator.py
// For:
//     services/service_manager/public/mojom/interface_provider.mojom
//

package org.chromium.service_manager.mojom;

import androidx.annotation.IntDef;


public interface InterfaceProvider extends org.chromium.mojo.bindings.Interface {



    public interface Proxy extends InterfaceProvider, org.chromium.mojo.bindings.Interface.Proxy {
    }

    Manager<InterfaceProvider, InterfaceProvider.Proxy> MANAGER = InterfaceProvider_Internal.MANAGER;

    void getInterface(
String interfaceName, org.chromium.mojo.system.MessagePipeHandle pipe);


}
