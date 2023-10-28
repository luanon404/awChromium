// Copyright 2019 The Chromium Authors
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.

package org.chromium.android_webview.common;

/**
 * Constants for the names of WebView Features.
 */
public final class AwFeatures {


    // This following string constants were inserted by
    //     java_cpp_features.py
    // From
    //     ../../android_webview/common/aw_features.cc
    // Into
    //     ../../android_webview/java/src/org/chromium/android_webview/common/AwFeatures.java.tmpl

    // Enable brotli compression support in WebView.
    public static final String WEBVIEW_BROTLI_SUPPORT = "WebViewBrotliSupport";

    // Check layer_tree_frame_sink_id when return resources to compositor.
    public static final String WEBVIEW_CHECK_RETURN_RESOURCES = "WebViewCheckReturnResources";

    // Whether to destroy the WebView rendering functor when after a WebView window
    // becomes invisible.
    public static final String WEBVIEW_CLEAR_FUNCTOR_IN_BACKGROUND = "WebViewClearFunctorInBackground";

    // Use the SafeBrowsingApiHandlerBridge which uses the connectionless GMS APIs.
    // This Feature is checked and used in downstream internal code.
    public static final String WEBVIEW_CONNECTIONLESS_SAFE_BROWSING = "WebViewConnectionlessSafeBrowsing";

    // Kill switch for adding CHECKs to loading pak files.
    public static final String WEBVIEW_CHECK_PAK_FILE_DESCRIPTORS = "WebViewCheckPakFileDescriptors";

    // Cache origins which have camera/mic permissions approved to allow subsequent
    // calls to enumerate devices to return device labels.
    public static final String WEBVIEW_ENUMERATE_DEVICES_CACHE = "WebViewEnumerateDevicesCache";


    public static final String WEBVIEW_EXIT_REASON_METRIC = "WebViewExitReasonMetric";

    // Enable WebView to automatically darken the page in FORCE_DARK_AUTO mode if
    // the app's theme is dark.
    public static final String WEBVIEW_FORCE_DARK_MODE_MATCH_THEME = "WebViewForceDarkModeMatchTheme";


    public static final String WEBVIEW_HIT_TEST_IN_BLINK_ON_TOUCH_START = "WebViewHitTestInBlinkOnTouchStart";

    // Enable display cutout support for Android P and above.
    public static final String WEBVIEW_DISPLAY_CUTOUT = "WebViewDisplayCutout";

    // Fake empty component to measure component updater performance impact on
    // WebView clients.
    public static final String WEBVIEW_EMPTY_COMPONENT_LOADER_POLICY = "WebViewEmptyComponentLoaderPolicy";

    // When enabled, passive mixed content (Audio/Video/Image subresources loaded
    // over HTTP on HTTPS sites) will be autoupgraded to HTTPS, and the load will be
    // blocked if the resource fails to load over HTTPS. This only affects apps that
    // set the mixed content mode to MIXED_CONTENT_COMPATIBILITY_MODE, autoupgrades
    // are always disabled for MIXED_CONTENT_NEVER_ALLOW and
    // MIXED_CONTENT_ALWAYS_ALLOW modes.
    public static final String WEBVIEW_MIXED_CONTENT_AUTOUPGRADES = "WebViewMixedContentAutoupgrades";

    // Only allow extra headers added via loadUrl() to be sent to the original
    // origin; strip them from the request if a cross-origin redirect occurs.
    public static final String WEBVIEW_EXTRA_HEADERS_SAME_ORIGIN_ONLY = "WebViewExtraHeadersSameOriginOnly";

    // Enable the new Java/JS Bridge code path with mojo implementation.
    public static final String WEBVIEW_JAVA_JS_BRIDGE_MOJO = "WebViewJavaJsBridgeMojo";

    // Enable reporting filtered metrics from webview clients used to be
    // out-sampled.
    public static final String WEBVIEW_METRICS_FILTERING = "WebViewMetricsFiltering";

    // Field trial feature for controlling support of Origin Trials on WebView.
    public static final String WEBVIEW_ORIGIN_TRIALS = "WebViewOriginTrials";

    // Whether to record size of the embedding app's data directory to the UMA
    // histogram Android.WebView.AppDataDirectorySize.
    public static final String WEBVIEW_RECORD_APP_DATA_DIRECTORY_SIZE = "WebViewRecordAppDataDirectorySize";

    // Flag to restrict main frame Web Content to verified web content. Verification
    // happens via Digital Asset Links.
    public static final String WEBVIEW_RESTRICT_SENSITIVE_CONTENT = "WebViewRestrictSensitiveContent";

    // Enable detection of loading mature sites (according to Google SafeSearch)
    // on WebViews running on supervised user accounts.
    public static final String WEBVIEW_SUPERVISED_USER_SITE_DETECTION = "WebViewSupervisedUserSiteDetection";

    // Enable blocking the loading of mature sites (according to Google SafeSearch)
    // on WebViews running on supervised user accounts.
    public static final String WEBVIEW_SUPERVISED_USER_SITE_BLOCK = "WebViewSupervisedUserSiteBlock";

    // Disallows window.{alert, prompt, confirm} if triggered inside a subframe that
    // is not same origin with the main frame.
    public static final String WEBVIEW_SUPPRESS_DIFFERENT_ORIGIN_SUBFRAME_JS_DIALOGS = "WebViewSuppressDifferentOriginSubframeJSDialogs";

    // A Feature used for WebView variations tests. Not used in production.
    public static final String WEBVIEW_TEST_FEATURE = "WebViewTestFeature";

    // Use WebView's nonembedded MetricsUploadService to upload UMA metrics instead
    // of sending it directly to GMS-core.
    public static final String WEBVIEW_USE_METRICS_UPLOAD_SERVICE = "WebViewUseMetricsUploadService";

    // Use WebView's nonembedded MetricsUploadService to upload UMA metrics instead
    // of sending it directly to GMS-core when running within the SDK Runtime.
    public static final String WEBVIEW_USE_METRICS_UPLOAD_SERVICE_ONLY_SDK_RUNTIME = "WebViewUseMetricsUploadServiceOnlySdkRuntime";

    // Propagate Android's network notification signals to networking stack
    public static final String WEBVIEW_PROPAGATE_NETWORK_SIGNALS = "webViewPropagateNetworkSignals";

    // Provide the unreduced product version from the AwContentBrowserClient API,
    // regardless of the user agent reduction policy.
    public static final String WEBVIEW_UNREDUCED_PRODUCT_VERSION = "WebViewUnreducedPrductVersion";

    // Enable raster in wide color gamut for apps that use webview in a wide color
    // gamut activity.
    public static final String WEBVIEW_WIDE_COLOR_GAMUT_SUPPORT = "WebViewWideColorGamutSupport";

    // Control the default behaviour for the XRequestedWith header
    public static final String WEBVIEW_X_REQUESTED_WITH_HEADER_CONTROL = "WebViewXRequestedWithHeaderControl";

    // Control whether WebView will attempt to read the XRW header allow-list from
    // the manifest.
    public static final String WEBVIEW_X_REQUESTED_WITH_HEADER_MANIFEST_ALLOW_LIST = "WebViewXRequestedWithHeaderManifestAllowList";

    // This enables image drage out for Webview.
    public static final String WEBVIEW_IMAGE_DRAG = "WebViewImageDrag";

    // This enables uploading UMA data with a higher frequency.
    // This Feature is checked and used in downstream internal code.
    public static final String WEBVIEW_UMA_UPLOAD_QUALITY_OF_SERVICE_SET_TO_DEFAULT = "WebViewUmaUploadQualityOfServiceSetToDefault";

    // This enables zoom keyboard shortcuts for zoom-in, zoom-out and zoom reset.
    public static final String WEBVIEW_ZOOM_KEYBOARD_SHORTCUTS = "WebViewZoomKeyboardShortcuts";

    // Do not instantiate this class.
    private AwFeatures() {}
}
