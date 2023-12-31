// Renderer.java is auto generated by mojom_bindings_generator.py, do not edit


// Copyright 2014 The Chromium Authors
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.

// This file is autogenerated by:
//     mojo/public/tools/bindings/mojom_bindings_generator.py
// For:
//     media/mojo/mojom/renderer.mojom
//

package org.chromium.media.mojom;

import androidx.annotation.IntDef;


public interface Renderer extends org.chromium.mojo.bindings.Interface {



    public interface Proxy extends Renderer, org.chromium.mojo.bindings.Interface.Proxy {
    }

    Manager<Renderer, Renderer.Proxy> MANAGER = Renderer_Internal.MANAGER;

    void initialize(
org.chromium.mojo.bindings.AssociatedInterfaceNotSupported client, DemuxerStream[] streams, MediaUrlParams mediaUrlParams, 
Initialize_Response callback);

    interface Initialize_Response extends org.chromium.mojo.bindings.Callbacks.Callback1<Boolean> { }


    void flush(

Flush_Response callback);

    interface Flush_Response extends org.chromium.mojo.bindings.Callbacks.Callback0 { }


    void startPlayingFrom(
org.chromium.mojo_base.mojom.TimeDelta time);


    void setPlaybackRate(
double playbackRate);


    void setVolume(
float volume);


    void setCdm(
org.chromium.mojo_base.mojom.UnguessableToken cdmId, 
SetCdm_Response callback);

    interface SetCdm_Response extends org.chromium.mojo.bindings.Callbacks.Callback1<Boolean> { }


}
