// AudioDecoder.java is auto generated by mojom_bindings_generator.py, do not edit


// Copyright 2014 The Chromium Authors
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.

// This file is autogenerated by:
//     mojo/public/tools/bindings/mojom_bindings_generator.py
// For:
//     media/mojo/mojom/audio_decoder.mojom
//

package org.chromium.media.mojom;

import androidx.annotation.IntDef;


public interface AudioDecoder extends org.chromium.mojo.bindings.Interface {



    public interface Proxy extends AudioDecoder, org.chromium.mojo.bindings.Interface.Proxy {
    }

    Manager<AudioDecoder, AudioDecoder.Proxy> MANAGER = AudioDecoder_Internal.MANAGER;

    void construct(
org.chromium.mojo.bindings.AssociatedInterfaceNotSupported client, MediaLog mediaLog);


    void initialize(
AudioDecoderConfig config, org.chromium.mojo_base.mojom.UnguessableToken cdmId, 
Initialize_Response callback);

    interface Initialize_Response extends org.chromium.mojo.bindings.Callbacks.Callback3<DecoderStatus, Boolean, Integer> { }


    void setDataSource(
org.chromium.mojo.system.DataPipe.ConsumerHandle receivePipe);


    void decode(
DecoderBuffer buffer, 
Decode_Response callback);

    interface Decode_Response extends org.chromium.mojo.bindings.Callbacks.Callback1<DecoderStatus> { }


    void reset(

Reset_Response callback);

    interface Reset_Response extends org.chromium.mojo.bindings.Callbacks.Callback0 { }


}
