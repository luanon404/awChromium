// EmbeddedWorkerInstanceHost.java is auto generated by mojom_bindings_generator.py, do not edit


// Copyright 2014 The Chromium Authors
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.

// This file is autogenerated by:
//     mojo/public/tools/bindings/mojom_bindings_generator.py
// For:
//     third_party/blink/public/mojom/service_worker/embedded_worker.mojom
//

package org.chromium.blink.mojom;

import androidx.annotation.IntDef;


public interface EmbeddedWorkerInstanceHost extends org.chromium.mojo.bindings.Interface {



    public interface Proxy extends EmbeddedWorkerInstanceHost, org.chromium.mojo.bindings.Interface.Proxy {
    }

    Manager<EmbeddedWorkerInstanceHost, EmbeddedWorkerInstanceHost.Proxy> MANAGER = EmbeddedWorkerInstanceHost_Internal.MANAGER;

    void requestTermination(

RequestTermination_Response callback);

    interface RequestTermination_Response extends org.chromium.mojo.bindings.Callbacks.Callback1<Boolean> { }


    void countFeature(
int feature);


    void onReadyForInspection(
DevToolsAgent agent, org.chromium.mojo.bindings.InterfaceRequest<DevToolsAgentHost> agentHost);


    void onScriptLoaded(
);


    void onScriptEvaluationStart(
);


    void onStarted(
int status, int fetchHandlerType, boolean hasHidEventHandlers, boolean hasUsbEventHandlers, int threadId, EmbeddedWorkerStartTiming startTiming);


    void onReportException(
org.chromium.mojo_base.mojom.String16 errorMessage, int lineNumber, int columnNumber, org.chromium.url.mojom.Url sourceUrl);


    void onReportConsoleMessage(
int source, int messageLevel, org.chromium.mojo_base.mojom.String16 message, int lineNumber, org.chromium.url.mojom.Url sourceUrl);


    void onStopped(
);


}
