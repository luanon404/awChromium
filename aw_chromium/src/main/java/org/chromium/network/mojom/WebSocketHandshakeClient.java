// WebSocketHandshakeClient.java is auto generated by mojom_bindings_generator.py, do not edit


// Copyright 2014 The Chromium Authors
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.

// This file is autogenerated by:
//     mojo/public/tools/bindings/mojom_bindings_generator.py
// For:
//     services/network/public/mojom/websocket.mojom
//

package org.chromium.network.mojom;

import androidx.annotation.IntDef;


public interface WebSocketHandshakeClient extends org.chromium.mojo.bindings.Interface {



    public interface Proxy extends WebSocketHandshakeClient, org.chromium.mojo.bindings.Interface.Proxy {
    }

    Manager<WebSocketHandshakeClient, WebSocketHandshakeClient.Proxy> MANAGER = WebSocketHandshakeClient_Internal.MANAGER;

    void onOpeningHandshakeStarted(
WebSocketHandshakeRequest request);


    void onFailure(
String message, int netError, int responseCode);


    void onConnectionEstablished(
WebSocket socket, org.chromium.mojo.bindings.InterfaceRequest<WebSocketClient> clientReceiver, WebSocketHandshakeResponse response, org.chromium.mojo.system.DataPipe.ConsumerHandle readable, org.chromium.mojo.system.DataPipe.ProducerHandle writable);


}
