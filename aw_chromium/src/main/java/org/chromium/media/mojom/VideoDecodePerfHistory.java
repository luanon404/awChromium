// VideoDecodePerfHistory.java is auto generated by mojom_bindings_generator.py, do not edit


// Copyright 2014 The Chromium Authors
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.

// This file is autogenerated by:
//     mojo/public/tools/bindings/mojom_bindings_generator.py
// For:
//     media/mojo/mojom/video_decode_perf_history.mojom
//

package org.chromium.media.mojom;

import androidx.annotation.IntDef;


public interface VideoDecodePerfHistory extends org.chromium.mojo.bindings.Interface {



    public interface Proxy extends VideoDecodePerfHistory, org.chromium.mojo.bindings.Interface.Proxy {
    }

    Manager<VideoDecodePerfHistory, VideoDecodePerfHistory.Proxy> MANAGER = VideoDecodePerfHistory_Internal.MANAGER;

    void getPerfInfo(
PredictionFeatures features, 
GetPerfInfo_Response callback);

    interface GetPerfInfo_Response extends org.chromium.mojo.bindings.Callbacks.Callback2<Boolean, Boolean> { }


}
