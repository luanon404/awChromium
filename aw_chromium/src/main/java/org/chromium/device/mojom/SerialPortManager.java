// SerialPortManager.java is auto generated by mojom_bindings_generator.py, do not edit


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


public interface SerialPortManager extends org.chromium.mojo.bindings.Interface {



    public interface Proxy extends SerialPortManager, org.chromium.mojo.bindings.Interface.Proxy {
    }

    Manager<SerialPortManager, SerialPortManager.Proxy> MANAGER = SerialPortManager_Internal.MANAGER;

    void setClient(
SerialPortManagerClient client);


    void getDevices(

GetDevices_Response callback);

    interface GetDevices_Response extends org.chromium.mojo.bindings.Callbacks.Callback1<SerialPortInfo[]> { }


    void openPort(
org.chromium.mojo_base.mojom.UnguessableToken token, boolean useAlternatePath, SerialConnectionOptions options, SerialPortClient client, SerialPortConnectionWatcher watcher, 
OpenPort_Response callback);

    interface OpenPort_Response extends org.chromium.mojo.bindings.Callbacks.Callback1<SerialPort> { }


}
