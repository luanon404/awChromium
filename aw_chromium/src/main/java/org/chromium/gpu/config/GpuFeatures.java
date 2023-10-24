// Copyright 2020 The Chromium Authors
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.

package org.chromium.gpu.config;

/**
 * Constants for the names of GPU Features.
 */
public final class GpuFeatures {


    // This following string constants were inserted by
    //     java_cpp_features.py
    // From
    //     ../../gpu/config/gpu_finch_features.cc
    // Into
    //     ../../gpu/config/android/java/src/org/chromium/gpu/config/GpuFeatures.java.tmpl

    // Used to limit GL version to 2.0 for skia raster and compositing.
    public static final String USE_GLES2_FOR_OOP_R = "UseGles2ForOopR";

    // Use android SurfaceControl API for managing display compositor's buffer queue
    // and using overlays on Android. Also used by webview to disable surface
    // SurfaceControl.
    public static final String ANDROID_SURFACE_CONTROL = "AndroidSurfaceControl";

    // Hardware Overlays for WebView.
    public static final String WEBVIEW_SURFACE_CONTROL = "WebViewSurfaceControl";

    // Use thread-safe media path on WebView.
    public static final String WEBVIEW_THREAD_SAFE_MEDIA = "WebViewThreadSafeMedia";

    // This is used as default state because it's different for webview and chrome.
    // WebView hardcodes this as enabled in AwMainDelegate.
    public static final String WEBVIEW_THREAD_SAFE_MEDIA_DEFAULT = "WebViewThreadSafeMediaDefault";

    // Use AImageReader for MediaCodec and MediaPlyer on android.
    public static final String A_IMAGE_READER = "AImageReader";

    // If webview-draw-functor-uses-vulkan is set, use vulkan for composite and
    // raster.
    public static final String WEBVIEW_VULKAN = "WebViewVulkan";

    // Used to limit AImageReader max queue size to 1 since many devices especially
    // android Tv devices do not support more than 1 images.
    public static final String LIMIT_A_IMAGE_READER_MAX_SIZE_TO_ONE = "LimitAImageReaderMaxSizeToOne";

    // Increase number of buffers and pipeline depth for high frame rate devices.
    public static final String INCREASE_BUFFER_COUNT_FOR_HIGH_FRAME_RATE = "IncreaseBufferCountForHighFrameRate";

    // Use shorter timeout when performDeferredCleanup, and enable
    // performDeferredCleanup for Android WebView.
    public static final String AGGRESSIVE_SKIA_GPU_RESOURCE_PURGE = "AggressiveSkiaGpuResourcePurge";

    // Enable GPU Rasterization by default. This can still be overridden by
    // --enable-gpu-rasterization or --disable-gpu-rasterization.
    // DefaultEnableGpuRasterization has launched on Mac, Windows, ChromeOS,
    // Android and Linux.
    public static final String DEFAULT_ENABLE_GPU_RASTERIZATION = "DefaultEnableGpuRasterization";

    // Enables the use of out of process rasterization for canvas.
    public static final String CANVAS_OOP_RASTERIZATION = "CanvasOopRasterization";

    // Detect front buffering condition and set buffer usage as such.
    // This is a killswitch to be removed once launched.
    public static final String OZONE_FRONT_BUFFER_USAGE = "OzoneFrontBufferUsage";

    // Enables the use of MSAA in skia on Ice Lake and later intel architectures.
    public static final String ENABLE_MSAA_ON_NEW_INTEL_GP_US = "EnableMSAAOnNewIntelGPUs";

    // Enables the use of ANGLE validation for non-WebGL contexts.
    public static final String DEFAULT_ENABLE_ANGLE_VALIDATION = "DefaultEnableANGLEValidation";

    // Disables MSAA in Graphite if MSAA is reported as being slow for the device.
    public static final String DISABLE_SLOW_MSAA_IN_GRAPHITE = "DisableSlowMSAAInGraphite";

    // Enables canvas to free its resources by default when it's running in
    // the background.
    public static final String CANVAS_CONTEXT_LOST_IN_BACKGROUND = "CanvasContextLostInBackground";

    // Use a high priority for GPU process on Windows.
    public static final String GPU_PROCESS_HIGH_PRIORITY_WIN = "GpuProcessHighPriorityWin";

    // Disable overlay promotion for clear video quads when their MPO quad would
    // move.
    public static final String DISABLE_VIDEO_OVERLAY_IF_MOVING = "DisableVideoOverlayIfMoving";


    public static final String NO_UNDAMAGED_OVERLAY_PROMOTION = "NoUndamagedOverlayPromotion";

    // Use a DCompPresenter as the root surface, instead of a
    // DirectCompositionSurfaceWin. DCompPresenter is surface-less and the actual
    // allocation of the root surface will be owned by DirectRenderer.
    public static final String D_COMP_PRESENTER = "DCompPresenter";

    // If enabled, the TASK_CATEGORY_POLICY value of the GPU process will be
    // adjusted to match the one from the browser process every time it changes.
    public static final String ADJUST_GPU_PROCESS_PRIORITY = "AdjustGpuProcessPriority";

    // Causes us to use the SharedImageManager, removing support for the old
    // mailbox system. Any consumers of the GPU process using the old mailbox
    // system will experience undefined results.
    public static final String SHARED_IMAGE_MANAGER = "SharedImageManager";

    // Controls the decode acceleration of JPEG images (as opposed to camera
    // captures) in Chrome OS using the VA-API.
    // TODO(andrescj): remove or enable by default in Chrome OS once
    // https://crbug.com/868400 is resolved.
    public static final String VAAPI_JPEG_IMAGE_DECODE_ACCELERATION = "VaapiJpegImageDecodeAcceleration";

    // Controls the decode acceleration of WebP images in Chrome OS using the
    // VA-API.
    // TODO(gildekel): remove or enable by default in Chrome OS once
    // https://crbug.com/877694 is resolved.
    public static final String VAAPI_WEB_P_IMAGE_DECODE_ACCELERATION = "VaapiWebPImageDecodeAcceleration";

    // Enable Vulkan graphics backend for compositing and rasterization. Defaults to
    // native implementation if --use-vulkan flag is not used. Otherwise
    // --use-vulkan will be followed.
    // Note Android WebView uses kWebViewVulkan instead of this.
    public static final String VULKAN = "Vulkan";


    public static final String ENABLE_DR_DC = "EnableDrDc";


    public static final String FORCE_GPU_MAIN_THREAD_TO_NORMAL_PRIORITY_DR_DC = "ForceGpuMainThreadToNormalPriorityDrDc";


    public static final String WEB_GPU_SERVICE = "WebGPUService";


    public static final String WEB_GPU_BLOB_CACHE = "WebGPUBlobCache";


    public static final String WEB_GPU_USE_DXC = "WebGPUUseDXC2";


    public static final String WEB_GPU_USE_TINT_IR = "WebGPUUseTintIR";

    // Enable Skia Graphite. This will use the Dawn backend by default, but can be
    // overridden with command line flags for testing on non-official developer
    // builds. See --skia-graphite-backend flag in gpu_switches.h.
    // Note: This can also be overridden by
    // --enable-skia-graphite & --disable-skia-graphite.
    public static final String SKIA_GRAPHITE = "SkiaGraphite";


    public static final String SKIA_GRAPHITE_DAWN_USE_D3D12 = "SkiaGraphiteDawnUseD3D12";

    // Enable GrShaderCache to use with Vulkan backend.
    public static final String ENABLE_GR_SHADER_CACHE_FOR_VULKAN = "EnableGrShaderCacheForVulkan";

    // Enable report only mode on the GPU watchdog instead of pausing the watchdog
    // thread during GPU startup.
    public static final String ENABLE_WATCHDOG_REPORT_ONLY_MODE_ON_GPU_INIT = "EnableWatchdogReportOnlyModeOnGpuInit";

    // Enable persistent storage of VkPipelineCache data.
    public static final String ENABLE_VK_PIPELINE_CACHE = "EnableVkPipelineCache";

    // Enabling this will make the GPU decode path use a mock implementation of
    // discardable memory.
    public static final String NO_DISCARDABLE_MEMORY_FOR_GPU_DECODE_PATH = "NoDiscardableMemoryForGpuDecodePath";

    // Use a 100-command limit before forcing context switch per command buffer
    // instead of 20.
    public static final String INCREASED_CMD_BUFFER_PARSE_SLICE = "IncreasedCmdBufferParseSlice";

    // Kill switch for forcing restart GPU with context loss.
    // See https://crbug.com/1172229 for detail.
    public static final String FORCE_RESTART_GPU_KILL_SWITCH = "ForceRestartGpuKillSwitch";

    // Using the new SchedulerDfs GPU scheduler.
    public static final String USE_GPU_SCHEDULER_DFS = "UseGpuSchedulerDfs";

    // Use the ClientGmb interface to create GpuMemoryBuffers. This is supposed to
    // reduce number of IPCs happening while creating GpuMemoryBuffers by allowing
    // Renderers to do IPC directly to GPU process.
    public static final String USE_CLIENT_GMB_INTERFACE = "UseClientGmbInterface";

    // When the application is in background, whether to perform immediate GPU
    // cleanup when executing deferred requests.
    public static final String GPU_CLEANUP_IN_BACKGROUND = "GpuCleanupInBackground";

    // When enabled, the validating command decoder always returns true
    // from IsGL_REDSupportedOnFBOs in feature_info.cc on Android.
    public static final String CMD_DECODER_SKIP_GL_RED_MESA_WORKAROUND_ON_ANDROID = "CmdDecoderSkipGLRedMesaWorkaroundOnAndroid";

    // Prevent instantiation.
    private GpuFeatures() {
    }
}
