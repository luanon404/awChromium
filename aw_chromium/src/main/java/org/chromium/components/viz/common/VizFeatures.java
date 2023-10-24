// Copyright 2020 The Chromium Authors
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.

package org.chromium.components.viz.common;

/**
 * Constants for the names of Viz Features.
 */
public final class VizFeatures {


    // This following string constants were inserted by
    //     java_cpp_features.py
    // From
    //     ../../components/viz/common/features.cc
    // Into
    //     ../../components/viz/common/java/src/org/chromium/components/viz/common/VizFeatures.java.tmpl


    public static final String USE_MULTIPLE_OVERLAYS = "UseMultipleOverlays";


    public static final String DELEGATED_COMPOSITING = "DelegatedCompositing";


    public static final String VIDEO_DETECTOR_IGNORE_NON_VIDEOS = "VideoDetectorIgnoreNonVideos";

    // When wide color gamut content from the web is encountered, promote our
    // display to wide color gamut if supported.
    public static final String DYNAMIC_COLOR_GAMUT = "DynamicColorGamut";

    // Submit CompositorFrame from SynchronousLayerTreeFrameSink directly to viz in
    // WebView.
    public static final String VIZ_FRAME_SUBMISSION_FOR_WEBVIEW = "VizFrameSubmissionForWebView";

    // Whether we should use the real buffers corresponding to overlay candidates in
    // order to do a pageflip test rather than allocating test buffers.
    public static final String USE_REAL_BUFFERS_FOR_PAGE_FLIP_TEST = "UseRealBuffersForPageFlipTest";

    // Enables SkiaOutputDeviceBufferQueue instead of Vulkan swapchain on Fuchsia.
    public static final String USE_SKIA_OUTPUT_DEVICE_BUFFER_QUEUE = "UseSkiaOutputDeviceBufferQueue";

    // Whether we should log extra debug information to webrtc native log.
    public static final String WEB_RTC_LOG_CAPTURE_PIPELINE = "WebRtcLogCapturePipeline";

    // Enables swap chains to call SetPresentDuration to request DWM/OS to reduce
    // vsync.
    public static final String USE_SET_PRESENT_DURATION = "UseSetPresentDuration";

    // Enables platform supported delegated ink trails instead of Skia backed
    // delegated ink trails.
    public static final String USE_PLATFORM_DELEGATED_INK = "UsePlatformDelegatedInk";

    // Used to debug Android WebView Vulkan composite. Composite to an intermediate
    // buffer and draw the intermediate buffer to the secondary command buffer.
    public static final String WEBVIEW_VULKAN_INTERMEDIATE_BUFFER = "WebViewVulkanIntermediateBuffer";

    // Hardcoded as disabled for WebView to have a different default for
    // UseSurfaceLayerForVideo from chrome.
    public static final String USE_SURFACE_LAYER_FOR_VIDEO_DEFAULT = "UseSurfaceLayerForVideoDefault";


    public static final String WEBVIEW_NEW_INVALIDATE_HEURISTIC = "WebViewNewInvalidateHeuristic";


    public static final String DRAW_PREDICTED_INK_POINT = "DrawPredictedInkPoint";

    // Used by Viz to parameterize adjustments to scheduler deadlines.
    public static final String DYNAMIC_SCHEDULER_FOR_DRAW = "DynamicSchedulerForDraw";

    // User to parameterize adjustments to clients' deadlines.
    public static final String DYNAMIC_SCHEDULER_FOR_CLIENTS = "DynamicSchedulerForClients";

    // Increase the max CALayer number allowed for CoreAnimation.
    // * If this feature is disabled, then the default limit is 128 quads,
    //   unless there are 5 or more video elements present, in which case
    //   the limit is 300.
    // * If this feature is enabled, then these limits are 512, and can be
    // overridden by the "default" and "many-videos"
    //   feature parameters.
    public static final String CA_LAYER_NEW_LIMIT = "CALayerNewLimit";


    public static final String CAN_SKIP_RENDER_PASS_OVERLAY = "CanSkipRenderPassOverlay";


    public static final String CV_DISPLAY_LINK_BEGIN_FRAME_SOURCE = "CVDisplayLinkBeginFrameSource";

    // Allow SkiaRenderer to skip drawing render passes that contain a single
    // RenderPassDrawQuad.
    public static final String ALLOW_BYPASS_RENDER_PASS_QUADS = "AllowBypassRenderPassQuads";


    public static final String ALLOW_UNDAMAGED_NONROOT_RENDER_PASS_TO_SKIP = "AllowUndamagedNonrootRenderPassToSkip";

    // Allow SurfaceAggregator to merge render passes when they contain quads that
    // require overlay (e.g. protected video). See usage in |EmitSurfaceContent|.
    public static final String ALLOW_FORCE_MERGE_RENDER_PASS_WITH_REQUIRE_OVERLAY_QUADS = "AllowForceMergeRenderPassWithRequireOverlayQuads";

    // Whether to:
    // - Perform periodic inactive frame culling.
    // - Cull *all* frames in case of critical memory pressure, rather than keeping
    //   one.
    public static final String AGGRESSIVE_FRAME_CULLING = "AggressiveFrameCulling";

    // If enabled, do not rely on surface garbage collection to happen
    // periodically, but trigger it eagerly, to avoid missing calls.
    public static final String EAGER_SURFACE_GARBAGE_COLLECTION = "EagerSurfaceGarbageCollection";

    // Only applies when a caller has requested a custom BeginFrame rate via the
    // Throttle() API in frame_sink_manager.mojom. If enabled, parameters related
    // to the BeginFrame rate are overridden in viz to reflect the throttled rate
    // before being circulated in the system. The most notable are the interval and
    // deadline in BeginFrameArgs. If disabled, these parameters reflect the default
    // vsync rate (the behavior at the time this feature was created.)
    public static final String OVERRIDE_THROTTLED_FRAME_RATE_PARAMS = "OverrideThrottledFrameRateParams";

    // Used to gate calling SetPurgeable on OutputPresenter::Image from
    // SkiaOutputDeviceBufferQueue.
    public static final String BUFFER_QUEUE_IMAGE_SET_PURGEABLE = "BufferQueueImageSetPurgeable";

    // On platforms using SkiaOutputDeviceBufferQueue, when this is true
    // SkiaRenderer will allocate and maintain a buffer queue of images for the root
    // render pass, instead of SkiaOutputDeviceBufferQueue itself.
    public static final String RENDERER_ALLOCATES_IMAGES = "RendererAllocatesImages";

    // Furthermore, by default on Android, when a client is being evicted, it only
    // evicts itself. This differs from Destkop platforms which evict the entire
    // FrameTree along with the topmost viz::Surface. When this feature is enabled,
    // Android will begin also evicting the entire FrameTree.
    public static final String EVICT_SUBTREE = "EvictSubtree";

    // If enabled, CompositorFrameSinkClient::OnBeginFrame is also treated as the
    // DidReceiveCompositorFrameAck. Both in providing the Ack for the previous
    // frame, and in returning resources. While enabled we attempt to not send
    // separate Ack and ReclaimResources signals. However if while sending an
    // OnBeginFrame there is a pending Ack, then if the Ack arrives before the next
    // OnBeginFrame we will send the Ack immediately, rather than batching it.
    public static final String ON_BEGIN_FRAME_ACKS = "OnBeginFrameAcks";

    // if enabled, Any CompositorFrameSink of type video that defines a preferred
    // framerate that is below the display framerate will throttle OnBeginFrame
    // callbacks to match the preferred framerate.
    public static final String ON_BEGIN_FRAME_THROTTLE_VIDEO = "OnBeginFrameThrottleVideo";


    public static final String SHARED_BITMAP_TO_SHARED_IMAGE = "SharedBitmapToSharedImage";

    // Used to enable the HintSession::Mode::BOOST mode. BOOST mode try to force
    // the ADPF(Android Dynamic Performance Framework) to give Chrome more CPU
    // resources during a scroll.
    public static final String ENABLE_ADPF_SCROLL_BOOST = "EnableADPFScrollBoost";

    // If enabled, Chrome uses ADPF(Android Dynamic Performance Framework) to
    // request more CPU resources in the middle of a frame production if the frame
    // is taking longer than expected.
    public static final String ENABLE_ADPF_MID_FRAME_BOOST = "EnableADPFMidFrameBoost";

    // Allows delegating transforms over Wayland when it is also supported by Ash.
    public static final String DELEGATE_TRANSFORMS = "DelegateTransforms";

    // If enabled, Chrome includes the Renderer Main thread(s) into the
    // ADPF(Android Dynamic Performance Framework) hint session.
    public static final String ENABLE_ADPF_RENDERER_MAIN = "EnableADPFRendererMain";

    // If enabled, Chrome verifies that Renderer threads do not belong to the
    // Browser process asynchronously via a mojo call to the Browser before
    // including them into the ADPF(Android Dynamic Performance Framework) hint
    // session.
    public static final String ENABLE_ADPF_ASYNC_THREADS_VERIFICATION = "EnableADPFAsyncThreadsVerification";

    // If enabled, surface activation and draw do not block on dependencies.
    public static final String DRAW_IMMEDIATELY_WHEN_INTERACTIVE = "DrawImmediatelyWhenInteractive";

    // Invalidate the `viz::LocalSurfaceId` on the browser side when the page is
    // navigated away. This flag serves as the kill-switch for the uncaught edge
    // cases in production.
    public static final String INVALIDATE_LOCAL_SURFACE_ID_PRE_COMMIT = "InvalidateLocalSurfaceIdPreCommit";

    // On mac, when the RenderWidgetHostViewMac is hidden, also hide the
    // DelegatedFrameHost. Among other things, it unlocks the compositor frames,
    // which can saves hundreds of MiB of memory with bfcache entries.
    public static final String HIDE_DELEGATED_FRAME_HOST_MAC = "HideDelegatedFrameHostMac";

    // Prevent instantiation.
    private VizFeatures() {
    }
}
