// PictureInPictureService.java is auto generated by mojom_bindings_generator.py, do not edit


// Copyright 2014 The Chromium Authors
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.

// This file is autogenerated by:
//     mojo/public/tools/bindings/mojom_bindings_generator.py
// For:
//     third_party/blink/public/mojom/picture_in_picture/picture_in_picture.mojom
//

package org.chromium.blink.mojom;

import androidx.annotation.IntDef;


public interface PictureInPictureService extends org.chromium.mojo.bindings.Interface {



    public interface Proxy extends PictureInPictureService, org.chromium.mojo.bindings.Interface.Proxy {
    }

    Manager<PictureInPictureService, PictureInPictureService.Proxy> MANAGER = PictureInPictureService_Internal.MANAGER;

    void startSession(
int playerId, org.chromium.mojo.bindings.AssociatedInterfaceNotSupported playerRemote, org.chromium.viz.mojom.SurfaceId surfaceId, org.chromium.gfx.mojom.Size naturalSize, boolean showPlayPauseButton, PictureInPictureSessionObserver observer, org.chromium.gfx.mojom.Rect sourceBounds, 
StartSession_Response callback);

    interface StartSession_Response extends org.chromium.mojo.bindings.Callbacks.Callback2<PictureInPictureSession, org.chromium.gfx.mojom.Size> { }


}
