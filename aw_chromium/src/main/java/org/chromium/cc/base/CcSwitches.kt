// Copyright 2020 The Chromium Authors. All rights reserved.
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.
package org.chromium.cc.base

/**
 * Contains all of the command line switches that are specific to the cc/ layer.
 */
object CcSwitches {
    // This following string constants were inserted by
    //     java_cpp_strings.py
    // From
    //     ../../cc/base/switches.cc
    // Into
    //     ../../cc/base/android/java/src/org/chromium/cc/base/CcSwitches.java.tmpl
    const val DISABLE_THREADED_ANIMATION = "disable-threaded-animation"

    // Disables layer-edge anti-aliasing in the compositor.
    const val DISABLE_COMPOSITED_ANTIALIASING = "disable-composited-antialiasing"

    // Disables sending the next BeginMainFrame before the previous commit
    // activates. Overrides the kEnableMainFrameBeforeActivation flag.
    const val DISABLE_MAIN_FRAME_BEFORE_ACTIVATION = "disable-main-frame-before-activation"

    // Enables sending the next BeginMainFrame before the previous commit activates.
    const val ENABLE_MAIN_FRAME_BEFORE_ACTIVATION = "enable-main-frame-before-activation"

    // Disabled defering all image decodes to the image decode service, ignoring
    // DecodingMode preferences specified on PaintImage.
    const val DISABLE_CHECKER_IMAGING = "disable-checker-imaging"

    // Percentage of the browser controls need to be hidden before they will auto
    // hide.
    const val BROWSER_CONTROLS_HIDE_THRESHOLD = "top-controls-hide-threshold"

    // Percentage of the browser controls need to be shown before they will auto
    // show.
    const val BROWSER_CONTROLS_SHOW_THRESHOLD = "top-controls-show-threshold"

    // Re-rasters everything multiple times to simulate a much slower machine.
    // Give a scale factor to cause raster to take that many times longer to
    // complete, such as --slow-down-raster-scale-factor=25.
    const val SLOW_DOWN_RASTER_SCALE_FACTOR = "slow-down-raster-scale-factor"

    // Checks damage early and aborts the frame if no damage, so that clients like
    // Android WebView don't invalidate unnecessarily.
    const val CHECK_DAMAGE_EARLY = "check-damage-early"

    // Enables the GPU benchmarking extension
    const val ENABLE_GPU_BENCHMARKING = "enable-gpu-benchmarking"

    // Disables LayerTreeHost::OnMemoryPressure
    const val DISABLE_LAYER_TREE_HOST_MEMORY_PRESSURE = "disable-layer-tree-host-memory-pressure"

    // Renders a border around compositor layers to help debug and study
    // layer compositing.
    const val SHOW_COMPOSITED_LAYER_BORDERS = "show-composited-layer-borders"
    const val UI_SHOW_COMPOSITED_LAYER_BORDERS = "ui-show-composited-layer-borders"

    // Parameters for kUIShowCompositedLayerBorders.
    const val COMPOSITED_RENDER_PASS_BORDERS = "renderpass"
    const val COMPOSITED_SURFACE_BORDERS = "surface"
    const val COMPOSITED_LAYER_BORDERS = "layer"

    // Checks and logs double background blur as an error if any.
    const val LOG_ON_UI_DOUBLE_BACKGROUND_BLUR = "log-on-ui-double-background-blur"

    // Draws a heads-up-display showing Frames Per Second as well as GPU memory
    // usage. If you also use --enable-logging=stderr --vmodule="head*=1" then FPS
    // will also be output to the console log.
    const val SHOW_FPS_COUNTER = "show-fps-counter"
    const val UI_SHOW_FPS_COUNTER = "ui-show-fps-counter"

    // Renders a border that represents the bounding box for the layer's animation.
    const val SHOW_LAYER_ANIMATION_BOUNDS = "show-layer-animation-bounds"
    const val UI_SHOW_LAYER_ANIMATION_BOUNDS = "ui-show-layer-animation-bounds"

    // Show rects in the HUD around layers whose properties have changed.
    const val SHOW_PROPERTY_CHANGED_RECTS = "show-property-changed-rects"
    const val UI_SHOW_PROPERTY_CHANGED_RECTS = "ui-show-property-changed-rects"

    // Show rects in the HUD around damage as it is recorded into each render
    // surface.
    const val SHOW_SURFACE_DAMAGE_RECTS = "show-surface-damage-rects"
    const val UI_SHOW_SURFACE_DAMAGE_RECTS = "ui-show-surface-damage-rects"

    // Show rects in the HUD around the screen-space transformed bounds of every
    // layer.
    const val SHOW_SCREEN_SPACE_RECTS = "show-screenspace-rects"
    const val UI_SHOW_SCREEN_SPACE_RECTS = "ui-show-screenspace-rects"

    // Highlights layers that can't use lcd text. Layers containing no text won't
    // be highlighted. See DebugColors::NonLCDTextHighlightColor() for the colors.
    const val HIGHLIGHT_NON_LCD_TEXT_LAYERS = "highlight-non-lcd-text-layers"

    // Switches the ui compositor to use layer lists instead of layer trees.
    const val UI_ENABLE_LAYER_LISTS = "ui-enable-layer-lists"

    // Allows scaling clipped images in GpuImageDecodeCache. Note that this may
    // cause color-bleeding.
    // TODO(crbug.com/1157548): Remove this workaround flag once the underlying
    // cache problems are solved.
    const val ENABLE_CLIPPED_IMAGE_SCALING = "enable-scaling-clipped-images"

    // Prevents the layer tree unit tests from timing out.
    const val CC_LAYER_TREE_TEST_NO_TIMEOUT = "cc-layer-tree-test-no-timeout"

    // Increases timeout for memory checkers.
    const val CC_LAYER_TREE_TEST_LONG_TIMEOUT = "cc-layer-tree-test-long-timeout"

    // Controls the duration of the scroll animation curve.
    const val CC_SCROLL_ANIMATION_DURATION_FOR_TESTING = "cc-scroll-animation-duration-in-seconds"
}