// FrameSinkBundleClient.java is auto generated by mojom_bindings_generator.py, do not edit


// Copyright 2014 The Chromium Authors
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.

// This file is autogenerated by:
//     mojo/public/tools/bindings/mojom_bindings_generator.py
// For:
//     services/viz/public/mojom/compositing/frame_sink_bundle.mojom
//

package org.chromium.viz.mojom;

import androidx.annotation.IntDef;


public interface FrameSinkBundleClient extends org.chromium.mojo.bindings.Interface {



    public interface Proxy extends FrameSinkBundleClient, org.chromium.mojo.bindings.Interface.Proxy {
    }

    Manager<FrameSinkBundleClient, FrameSinkBundleClient.Proxy> MANAGER = FrameSinkBundleClient_Internal.MANAGER;

    void flushNotifications(
BundledReturnedResources[] acks, BeginFrameInfo[] beginFrames, BundledReturnedResources[] reclaimedResources);


    void onBeginFramePausedChanged(
int sinkId, boolean paused);


    void onCompositorFrameTransitionDirectiveProcessed(
int sinkId, int sequenceId);


}
