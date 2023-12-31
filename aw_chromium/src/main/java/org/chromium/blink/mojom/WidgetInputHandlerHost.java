// WidgetInputHandlerHost.java is auto generated by mojom_bindings_generator.py, do not edit


// Copyright 2014 The Chromium Authors
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.

// This file is autogenerated by:
//     mojo/public/tools/bindings/mojom_bindings_generator.py
// For:
//     third_party/blink/public/mojom/input/input_handler.mojom
//

package org.chromium.blink.mojom;

import androidx.annotation.IntDef;


public interface WidgetInputHandlerHost extends org.chromium.mojo.bindings.Interface {



    public interface Proxy extends WidgetInputHandlerHost, org.chromium.mojo.bindings.Interface.Proxy {
    }

    Manager<WidgetInputHandlerHost, WidgetInputHandlerHost.Proxy> MANAGER = WidgetInputHandlerHost_Internal.MANAGER;

    void setTouchActionFromMain(
int touchAction);


    void setPanAction(
int panAction);


    void didOverscroll(
DidOverscrollParams params);


    void didStartScrollingViewport(
);


    void imeCancelComposition(
);


    void imeCompositionRangeChanged(
org.chromium.gfx.mojom.Range range, org.chromium.gfx.mojom.Rect[] characterBounds, org.chromium.gfx.mojom.Rect[] lineBounds);


    void setMouseCapture(
boolean capture);


    void requestMouseLock(
boolean fromUserGesture, boolean unadjustedMovement, 
RequestMouseLock_Response callback);

    interface RequestMouseLock_Response extends org.chromium.mojo.bindings.Callbacks.Callback2<Integer, PointerLockContext> { }


}
