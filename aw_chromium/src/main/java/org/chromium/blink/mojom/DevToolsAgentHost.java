// DevToolsAgentHost.java is auto generated by mojom_bindings_generator.py, do not edit


// Copyright 2014 The Chromium Authors
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.

// This file is autogenerated by:
//     mojo/public/tools/bindings/mojom_bindings_generator.py
// For:
//     third_party/blink/public/mojom/devtools/devtools_agent.mojom
//

package org.chromium.blink.mojom;

import androidx.annotation.IntDef;


public interface DevToolsAgentHost extends org.chromium.mojo.bindings.Interface {



    public interface Proxy extends DevToolsAgentHost, org.chromium.mojo.bindings.Interface.Proxy {
    }

    Manager<DevToolsAgentHost, DevToolsAgentHost.Proxy> MANAGER = DevToolsAgentHost_Internal.MANAGER;

    void childTargetCreated(
DevToolsAgent workerDevtoolsAgent, org.chromium.mojo.bindings.InterfaceRequest<DevToolsAgentHost> workerDevtoolsAgentHost, org.chromium.url.mojom.Url url, String name, org.chromium.mojo_base.mojom.UnguessableToken devtoolsWorkerToken, boolean waitingForDebugger, int contextType);


    void mainThreadDebuggerPaused(
);


    void mainThreadDebuggerResumed(
);


}
