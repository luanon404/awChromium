// SharedWorkerHost.java is auto generated by mojom_bindings_generator.py, do not edit


// Copyright 2014 The Chromium Authors
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.

// This file is autogenerated by:
//     mojo/public/tools/bindings/mojom_bindings_generator.py
// For:
//     third_party/blink/public/mojom/worker/shared_worker_host.mojom
//

package org.chromium.blink.mojom;

import androidx.annotation.IntDef;


public interface SharedWorkerHost extends org.chromium.mojo.bindings.Interface {



    public interface Proxy extends SharedWorkerHost, org.chromium.mojo.bindings.Interface.Proxy {
    }

    Manager<SharedWorkerHost, SharedWorkerHost.Proxy> MANAGER = SharedWorkerHost_Internal.MANAGER;

    void onConnected(
int connectionId);


    void onContextClosed(
);


    void onReadyForInspection(
DevToolsAgent agent, org.chromium.mojo.bindings.InterfaceRequest<DevToolsAgentHost> agentHost);


    void onScriptLoadFailed(
String errorMessage);


    void onFeatureUsed(
int feature);


}
