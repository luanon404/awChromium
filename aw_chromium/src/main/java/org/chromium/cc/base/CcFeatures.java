// Copyright 2022 The Chromium Authors
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.

package org.chromium.cc.base;

/**
 * Contains all of the command line switches that are specific to the cc/ layer.
 */
public final class CcFeatures {


    // This following string constants were inserted by
    //     java_cpp_features.py
    // From
    //     ../../cc/base/features.cc
    // Into
    //     ../../cc/base/android/java/src/org/chromium/cc/base/CcFeatures.java.tmpl

    // Uses the Resume method instead of the Catch-up method for animated images.
    // - Catch-up behavior tries to keep animated images in pace with wall-clock
    //   time. This might require decoding several animation frames if the
    //   animation has fallen behind.
    // - Resume behavior presents what would have been the next presented frame.
    //   This means it might only decode one frame, resuming where it left off.
    //   However, if the animation updates faster than the display's refresh rate,
    //   it is possible to decode more than a single frame.
    public static final String ANIMATED_IMAGE_RESUME = "AnimatedImageResume";

    // Whether the compositor should attempt to sync with the scroll handlers before
    // submitting a frame.
    public static final String SYNCHRONIZED_SCROLLING = "SynchronizedScrolling";


    public static final String REMOVE_MOBILE_VIEWPORT_DOUBLE_TAP = "RemoveMobileViewportDoubleTap";


    public static final String SCROLL_SNAP_COVERING_AVOID_NESTED_SNAP_AREAS = "ScrollSnapCoveringAvoidNestedSnapAreas";


    public static final String SCROLL_SNAP_COVERING_USE_NATIVE_FLING = "ScrollSnapCoveringUseNativeFling";


    public static final String SCROLL_SNAP_PREFER_CLOSER_COVERING = "ScrollSnapPreferCloserCovering";


    public static final String HUD_DISPLAY_FOR_PERFORMANCE_METRICS = "HudDisplayForPerformanceMetrics";


    public static final String RENDER_SURFACE_COMMON_ANCESTOR_CLIP = "RenderSurfaceCommonAncestorClip";


    public static final String DURATION_ESTIMATES_IN_COMPOSITOR_TIMING_HISTORY = "DurationEstimatesInCompositorTimingHistory";


    public static final String NON_BLOCKING_COMMIT = "NonBlockingCommit";


    public static final String NO_PRESERVE_LAST_MUTATION = "NoPreserveLastMutation";


    public static final String SLIDING_WINDOW_FOR_DROPPED_FRAME_COUNTER = "SlidingWindowForDroppedFrameCounter";


    public static final String NORMAL_PRIORITY_IMAGE_DECODING = "NormalPriorityImageDecoding";

    // Note that kUseDMSAAForTiles only controls vulkan launch on android. We will
    // be using a separate flag to control the launch on GL.
    public static final String USE_DMSAA_FOR_TILES = "UseDMSAAForTiles";

    // This flag controls the DMSAA for tile raster on Android GL backend whereas
    // above flag UseDMSAAForTiles controls the launch on Vulkan backend.
    public static final String USE_DMSAA_FOR_TILES_ANDROID_GL = "UseDMSAAForTilesAndroidGL";


    public static final String UPDATE_BROWSER_CONTROLS_WITHOUT_PROXY = "UpdateBrowserControlsWithoutProxy";


    public static final String UI_ENABLE_SHARED_IMAGE_CACHE_FOR_GPU = "UIEnableSharedImageCacheForGpu";


    public static final String RECLAIM_RESOURCES_FLUSH_IN_BACKGROUND = "ReclaimResourcesFlushInBackground";


    public static final String RECLAIM_RESOURCES_DELAYED_FLUSH_IN_BACKGROUND = "ReclaimResourcesDelayedFlushInBackground";


    public static final String MORE_AGGRESSIVE_SOLID_COLOR_DETECTION = "MoreAggressiveSolidColorDetection";


    public static final String REDUCED_FRAME_RATE_ESTIMATION = "kReducedFrameRateEstimation";


    public static final String DETECT_HI_DPI_FOR_MSAA = "DetectHiDpiForMsaa";


    public static final String RECLAIM_PREPAINT_TILES_WHEN_IDLE = "ReclaimPrepaintTilesWhenIdle";

    // This saves memory on all platforms, but while on Android savings are
    // significant (~10MiB or more of foreground memory), on desktop they were
    // small, so only enable on Android.
    public static final String SMALLER_INTEREST_AREA = "SmallerInterestArea";


    public static final String IMAGE_CACHE_NO_CACHE = "ImageCacheNoCache";


    public static final String RECLAIM_OLD_PREPAINT_TILES = "ReclaimOldPrepaintTiles";


    public static final String USE_MAP_RECT_FOR_PIXEL_MOVEMENT = "UseMapRectForPixelMovement";

    // Prevent instantiation.
    private CcFeatures() {}
}
