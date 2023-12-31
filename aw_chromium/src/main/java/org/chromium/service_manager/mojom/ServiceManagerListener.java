// ServiceManagerListener.java is auto generated by mojom_bindings_generator.py, do not edit


// Copyright 2014 The Chromium Authors
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.

// This file is autogenerated by:
//     mojo/public/tools/bindings/mojom_bindings_generator.py
// For:
//     services/service_manager/public/mojom/service_manager.mojom
//

package org.chromium.service_manager.mojom;

import androidx.annotation.IntDef;


public interface ServiceManagerListener extends org.chromium.mojo.bindings.Interface {



    public interface Proxy extends ServiceManagerListener, org.chromium.mojo.bindings.Interface.Proxy {
    }

    Manager<ServiceManagerListener, ServiceManagerListener.Proxy> MANAGER = ServiceManagerListener_Internal.MANAGER;

    void onInit(
RunningServiceInfo[] runningServices);


    void onServiceCreated(
RunningServiceInfo service);


    void onServiceStarted(
Identity identity, int pidDeprecated);


    void onServicePidReceived(
Identity identity, int pid);


    void onServiceFailedToStart(
Identity identity);


    void onServiceStopped(
Identity identity);


}
