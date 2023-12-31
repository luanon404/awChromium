// SerialPortManagerClient.java is auto generated by mojom_bindings_generator.py, do not edit


// Copyright 2014 The Chromium Authors
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.

// This file is autogenerated by:
//     mojo/public/tools/bindings/mojom_bindings_generator.py
// For:
//     services/device/public/mojom/serial.mojom
//

package org.chromium.device.mojom;

import androidx.annotation.IntDef;


public interface SerialPortManagerClient extends org.chromium.mojo.bindings.Interface {



    public interface Proxy extends SerialPortManagerClient, org.chromium.mojo.bindings.Interface.Proxy {
    }

    Manager<SerialPortManagerClient, SerialPortManagerClient.Proxy> MANAGER = SerialPortManagerClient_Internal.MANAGER;

    void onPortAdded(
SerialPortInfo portInfo);


    void onPortRemoved(
SerialPortInfo portInfo);


}
