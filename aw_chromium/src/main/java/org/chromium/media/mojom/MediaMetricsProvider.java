// MediaMetricsProvider.java is auto generated by mojom_bindings_generator.py, do not edit


// Copyright 2014 The Chromium Authors
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.

// This file is autogenerated by:
//     mojo/public/tools/bindings/mojom_bindings_generator.py
// For:
//     media/mojo/mojom/media_metrics_provider.mojom
//

package org.chromium.media.mojom;

import androidx.annotation.IntDef;


public interface MediaMetricsProvider extends org.chromium.mojo.bindings.Interface {



    public interface Proxy extends MediaMetricsProvider, org.chromium.mojo.bindings.Interface.Proxy {
    }

    Manager<MediaMetricsProvider, MediaMetricsProvider.Proxy> MANAGER = MediaMetricsProvider_Internal.MANAGER;

    void initialize(
boolean isMse, int urlScheme, int streamType);


    void onError(
PipelineStatus status);


    void onFallback(
PipelineStatus status);


    void setHasPlayed(
);


    void setHaveEnough(
);


    void setIsEme(
);


    void setTimeToMetadata(
org.chromium.mojo_base.mojom.TimeDelta elapsed);


    void setTimeToFirstFrame(
org.chromium.mojo_base.mojom.TimeDelta elapsed);


    void setTimeToPlayReady(
org.chromium.mojo_base.mojom.TimeDelta elapsed);


    void setRendererType(
int rendererType);


    void setKeySystem(
String keySystem);


    void setIsHardwareSecure(
);


    void setContainerName(
int containerName);


    void acquireWatchTimeRecorder(
PlaybackProperties properties, org.chromium.mojo.bindings.InterfaceRequest<WatchTimeRecorder> recorder);


    void acquireVideoDecodeStatsRecorder(
org.chromium.mojo.bindings.InterfaceRequest<VideoDecodeStatsRecorder> recorder);


    void acquireLearningTaskController(
String taskName, org.chromium.mojo.bindings.InterfaceRequest<org.chromium.media.learning.mojom.LearningTaskController> controller);


    void acquirePlaybackEventsRecorder(
org.chromium.mojo.bindings.InterfaceRequest<PlaybackEventsRecorder> receiver);


    void setHasAudio(
int codec);


    void setHasVideo(
int codec);


    void setVideoPipelineInfo(
VideoPipelineInfo info);


    void setAudioPipelineInfo(
AudioPipelineInfo info);


}
