// RenderFrameMetadataObserver.java is auto generated by mojom_bindings_generator.py, do not edit


// Copyright 2014 The Chromium Authors
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.

// This file is autogenerated by:
//     mojo/public/tools/bindings/mojom_bindings_generator.py
// For:
//     cc/mojom/render_frame_metadata.mojom
//

package org.chromium.cc.mojom;

import androidx.annotation.IntDef;


public interface RenderFrameMetadataObserver extends org.chromium.mojo.bindings.Interface {



    public interface Proxy extends RenderFrameMetadataObserver, org.chromium.mojo.bindings.Interface.Proxy {
    }

    Manager<RenderFrameMetadataObserver, RenderFrameMetadataObserver.Proxy> MANAGER = RenderFrameMetadataObserver_Internal.MANAGER;

    void updateRootScrollOffsetUpdateFrequency(
int frequency);


    void reportAllFrameSubmissionsForTesting(
boolean enabled);


}
