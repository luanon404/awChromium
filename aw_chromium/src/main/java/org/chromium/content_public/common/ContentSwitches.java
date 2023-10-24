// Copyright 2013 The Chromium Authors
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.

package org.chromium.content_public.common;

/**
 * Contains all of the command line switches that are specific to the content/
 * portion of Chromium on Android.
 */
public final class ContentSwitches {
    // Tell Java to use the official command line, loaded from the
    // official-command-line.xml files.  WARNING this is not done
    // immediately on startup, so early running Java code will not see
    // these flags.
    public static final String ADD_OFFICIAL_COMMAND_LINE = "add-official-command-line";

    // Enables test intent handling.
    public static final String ENABLE_TEST_INTENTS = "enable-test-intents";

    // Dump frames-per-second to the log
    public static final String LOG_FPS = "log-fps";

    // Whether Chromium should use a mobile user agent.
    public static final String USE_MOBILE_UA = "use-mobile-user-agent";

    // Change the url of the JavaScript that gets injected when accessibility mode is enabled.
    public static final String ACCESSIBILITY_JAVASCRIPT_URL = "accessibility-js-url";

    // How much of the browser controls need to be shown before they will auto show.
    public static final String TOP_CONTROLS_SHOW_THRESHOLD = "top-controls-show-threshold";

    // How much of the browser controls need to be hidden before they will auto hide.
    public static final String TOP_CONTROLS_HIDE_THRESHOLD = "top-controls-hide-threshold";

    // Native switch - chrome_switches::kDisablePopupBlocking
    public static final String DISABLE_POPUP_BLOCKING = "disable-popup-blocking";

    // Native switch kRendererProcessLimit
    public static final String RENDER_PROCESS_LIMIT = "renderer-process-limit";

    // Native switch kProcessType
    public static final String SWITCH_PROCESS_TYPE = "type";

    // Native switch kRendererProcess
    public static final String SWITCH_RENDERER_PROCESS = "renderer";

    // Native switch kUtilityProcess
    public static final String SWITCH_UTILITY_PROCESS = "utility";

    // Native switch kGPUProcess
    public static final String SWITCH_GPU_PROCESS = "gpu-process";

    // Use fake device for Media Stream to replace actual camera and microphone.
    public static final String USE_FAKE_DEVICE_FOR_MEDIA_STREAM = "use-fake-device-for-media-stream";

    // Native switch kHostResolverRules
    public static final String HOST_RESOLVER_RULES = "host-resolver-rules";

    // Native switch kServiceSandboxType
    public static final String SWITCH_SERVICE_SANDBOX_TYPE = "service-sandbox-type";

    // "None" sandbox, meaning the process shouldn't be sandboxed.
    public static final String NONE_SANDBOX_TYPE = "none";


    // This following string constants were inserted by
    //     java_cpp_strings.py
    // From
    //     ../../content/public/common/content_switches.cc
    // Into
    //     ../../content/common/android/java_templates/ContentSwitches.java.tmpl

    // By default, file:// URIs cannot read other file:// URIs. This is an
    // override for developers who need the old behavior for testing.
    public static final String ALLOW_FILE_ACCESS_FROM_FILES = "allow-file-access-from-files";

    // Enables TLS/SSL errors on localhost to be ignored (no interstitial,
    // no blocking of requests).
    public static final String ALLOW_INSECURE_LOCALHOST = "allow-insecure-localhost";

    // Allows loopback interface to be added in network list for peer connection.
    public static final String ALLOW_LOOPBACK_IN_PEER_CONNECTION = "allow-loopback-in-peer-connection";

    // Allows plugins to be loaded in the command line for testing.
    public static final String ALLOW_COMMAND_LINE_PLUGINS = "allow-command-line-plugins";

    // Causes the Attribution Report API to run without delays or noise.
    public static final String ATTRIBUTION_REPORTING_DEBUG_MODE = "attribution-reporting-debug-mode";

    // Bypasses the dialog prompting the user for permission to capture
    // cameras and microphones. Useful in automatic tests of video-conferencing
    // Web applications.
    // This is nearly identical to kUseFakeUIForMediaStream, with the exception
    // being that this flag does NOT affect screen-capture.
    public static final String AUTO_ACCEPT_CAMERA_AND_MICROPHONE_CAPTURE = "auto-accept-camera-and-microphone-capture";

    // Causes the browser process to crash on startup.
    public static final String BROWSER_CRASH_TEST = "crash-test";

    // Causes the browser process to display a dialog on launch.
    public static final String BROWSER_STARTUP_DIALOG = "browser-startup-dialog";

    // Path to the exe to run for the renderer and plugin subprocesses.
    public static final String BROWSER_SUBPROCESS_PATH = "browser-subprocess-path";

    // Tells whether the code is running browser tests (this changes the startup URL
    // used by the content shell and also disables features that can make tests
    // flaky [like monitoring of memory pressure]).
    public static final String BROWSER_TEST = "browser-test";

    // After a zygote forks a new process, change the stack canary. This switch is
    // useful so not all forked processes use the same canary (a secret value),
    // which can be vulnerable to information leaks and brute force attacks. See
    // https://crbug.com/1206626.
    // This requires that all functions on the stack at the time
    // content::RunZygote() is called be compiled without stack canaries.
    // Valid values are "enable" or "disable".
    public static final String CHANGE_STACK_GUARD_ON_FORK = "change-stack-guard-on-fork";


    public static final String CHANGE_STACK_GUARD_ON_FORK_ENABLED = "enable";


    public static final String CHANGE_STACK_GUARD_ON_FORK_DISABLED = "disable";

    // Disable antialiasing on 2d canvas.
    public static final String DISABLE2D_CANVAS_ANTIALIASING = "disable-canvas-aa";

    // Disables Canvas2D rendering into a scanout buffer for overlay support.
    public static final String DISABLE2D_CANVAS_IMAGE_CHROMIUM = "disable-2d-canvas-image-chromium";

    // Disables client-visible 3D APIs, in particular WebGL and Pepper 3D.
    // This is controlled by policy and is kept separate from the other
    // enable/disable switches to avoid accidentally regressing the policy
    // support for controlling access to these APIs.
    public static final String DISABLE3DAP_IS = "disable-3d-apis";

    // Disable gpu-accelerated 2d canvas.
    public static final String DISABLE_ACCELERATED2D_CANVAS = "disable-accelerated-2d-canvas";

    // Enable in-progress canvas 2d API methods BeginLayer and EndLayer.
    public static final String ENABLE_CANVAS2D_LAYERS = "canvas-2d-layers";

    // Disables hardware acceleration of video decode, where available.
    public static final String DISABLE_ACCELERATED_VIDEO_DECODE = "disable-accelerated-video-decode";

    // Disables hardware acceleration of video encode, where available.
    public static final String DISABLE_ACCELERATED_VIDEO_ENCODE = "disable-accelerated-video-encode";

    // Disable limits on the number of backing stores. Can prevent blinking for
    // users with many windows/tabs and lots of memory.
    public static final String DISABLE_BACKING_STORE_LIMIT = "disable-backing-store-limit";

    // Disable backgrounding renders for occluded windows. Done for tests to avoid
    // nondeterministic behavior.
    public static final String DISABLE_BACKGROUNDING_OCCLUDED_WINDOWS_FOR_TESTING = "disable-backgrounding-occluded-windows";

    // Disable task throttling of timer tasks from background pages.
    public static final String DISABLE_BACKGROUND_TIMER_THROTTLING = "disable-background-timer-throttling";

    // Disables the BackForwardCache feature.
    public static final String DISABLE_BACK_FORWARD_CACHE = "disable-back-forward-cache";

    // Disable one or more Blink runtime-enabled features.
    // Use names from runtime_enabled_features.json5, separated by commas.
    // Applied after kEnableBlinkFeatures, and after other flags that change these
    // features.
    public static final String DISABLE_BLINK_FEATURES = "disable-blink-features";

    // Disables HTML5 DB support.
    public static final String DISABLE_DATABASES = "disable-databases";

    // Disable the per-domain blocking for 3D APIs after GPU reset.
    // This switch is intended only for tests.
    public static final String DISABLE_DOMAIN_BLOCKING_FOR3DAP_IS = "disable-domain-blocking-for-3d-apis";

    // Disables the in-process stack traces.
    public static final String DISABLE_IN_PROCESS_STACK_TRACES = "disable-in-process-stack-traces";

    // Disable all versions of WebGL.
    public static final String DISABLE_WEB_GL = "disable-webgl";

    // Disable WebGL2.
    public static final String DISABLE_WEB_GL2 = "disable-webgl2";

    // Disable FileSystem API.
    public static final String DISABLE_FILE_SYSTEM = "disable-file-system";

    // Disable user gesture requirement for presentation.
    public static final String DISABLE_GESTURE_REQUIREMENT_FOR_PRESENTATION = "disable-gesture-requirement-for-presentation";

    // Disables GPU hardware acceleration.  If software renderer is not in place,
    // then the GPU process won't launch.
    public static final String DISABLE_GPU = "disable-gpu";

    // Prevent the compositor from using its GPU implementation.
    public static final String DISABLE_GPU_COMPOSITING = "disable-gpu-compositing";

    // Disable proactive early init of GPU process.
    public static final String DISABLE_GPU_EARLY_INIT = "disable-gpu-early-init";

    // Do not force that all compositor resources be backed by GPU memory buffers.
    public static final String DISABLE_GPU_MEMORY_BUFFER_COMPOSITOR_RESOURCES = "disable-gpu-memory-buffer-compositor-resources";

    // Disable GpuMemoryBuffer backed VideoFrames.
    public static final String DISABLE_GPU_MEMORY_BUFFER_VIDEO_FRAMES = "disable-gpu-memory-buffer-video-frames";

    // For tests, to disable the limit on the number of times the GPU process may be
    // restarted.
    public static final String DISABLE_GPU_PROCESS_CRASH_LIMIT = "disable-gpu-process-crash-limit";

    // For tests, to disable falling back to software compositing if the GPU Process
    // has crashed, and reached the GPU Process crash limit.
    public static final String DISABLE_SOFTWARE_COMPOSITING_FALLBACK = "disable-software-compositing-fallback";

    // Disable the thread that crashes the GPU process if it stops responding to
    // messages.
    public static final String DISABLE_GPU_WATCHDOG = "disable-gpu-watchdog";

    // Disables the IPC flooding protection.
    // It is activated by default. Some javascript functions can be used to flood
    // the browser process with IPC. This protection limits the rate at which they
    // can be used.
    public static final String DISABLE_IPC_FLOODING_PROTECTION = "disable-ipc-flooding-protection";

    // Suppresses hang monitor dialogs in renderer processes.  This may allow slow
    // unload handlers on a page to prevent the tab from closing, but the Task
    // Manager can be used to terminate the offending process in this case.
    public static final String DISABLE_HANG_MONITOR = "disable-hang-monitor";

    // Disable the RenderThread's HistogramCustomizer.
    public static final String DISABLE_HISTOGRAM_CUSTOMIZER = "disable-histogram-customizer";

    // Don't kill a child process when it sends a bad IPC message.  Apart
    // from testing, it is a bad idea from a security perspective to enable
    // this switch.
    public static final String DISABLE_KILL_AFTER_BAD_IPC = "disable-kill-after-bad-ipc";

    // Disables LCD text.
    public static final String DISABLE_LCD_TEXT = "disable-lcd-text";

    // Disable LocalStorage.
    public static final String DISABLE_LOCAL_STORAGE = "disable-local-storage";

    // Force logging to be disabled.  Logging is enabled by default in debug
    // builds.
    public static final String DISABLE_LOGGING = "disable-logging";

    // Disables using CODECAPI_AVLowLatencyMode when creating DXVA decoders.
    public static final String DISABLE_LOW_LATENCY_DXVA = "disable-low-latency-dxva";

    // Disables Mojo broker capabilities in the browser during Mojo initialization.
    public static final String DISABLE_MOJO_BROKER = "disable-mojo-broker";

    // Disables clearing the rendering output of a renderer when it didn't commit
    // new output for a while after a top-frame navigation.
    public static final String DISABLE_NEW_CONTENT_RENDERING_TIMEOUT = "disable-new-content-rendering-timeout";

    // Disables the Web Notification and the Push APIs.
    public static final String DISABLE_NOTIFICATIONS = "disable-notifications";

    // Disable Pepper3D.
    public static final String DISABLE_PEPPER3D = "disable-pepper-3d";

    // Disables the Permissions API.
    public static final String DISABLE_PERMISSIONS_API = "disable-permissions-api";

    // Disables compositor-accelerated touch-screen pinch gestures.
    public static final String DISABLE_PINCH = "disable-pinch";

    // Disables the Presentation API.
    public static final String DISABLE_PRESENTATION_API = "disable-presentation-api";

    // Disables throttling of history.pushState/replaceState calls.
    public static final String DISABLE_PUSH_STATE_THROTTLE = "disable-pushstate-throttle";

    // Taints all <canvas> elements, regardless of origin.
    public static final String DISABLE_READING_FROM_CANVAS = "disable-reading-from-canvas";

    // Disables remote web font support. SVG font should always work whether this
    // option is specified or not.
    public static final String DISABLE_REMOTE_FONTS = "disable-remote-fonts";

    // Disables the RemotePlayback API.
    public static final String DISABLE_REMOTE_PLAYBACK_API = "disable-remote-playback-api";

    // Turns off the accessibility in the renderer.
    public static final String DISABLE_RENDERER_ACCESSIBILITY = "disable-renderer-accessibility";

    // Prevent renderer process backgrounding when set.
    public static final String DISABLE_RENDERER_BACKGROUNDING = "disable-renderer-backgrounding";

    // Whether the ResourceScheduler is disabled.  Note this is only useful for C++
    // Headless embedders who need to implement their own resource scheduling.
    public static final String DISABLE_RESOURCE_SCHEDULER = "disable-resource-scheduler";

    // Disable shared workers.
    public static final String DISABLE_SHARED_WORKERS = "disable-shared-workers";

    // Do not use runtime-detected high-end CPU optimizations in Skia.  This is
    // useful for forcing a baseline code path for e.g. web tests.
    public static final String DISABLE_SKIA_RUNTIME_OPTS = "disable-skia-runtime-opts";

    // Disable smooth scrolling for testing.
    public static final String DISABLE_SMOOTH_SCROLLING = "disable-smooth-scrolling";

    // Disables the use of a 3D software rasterizer.
    public static final String DISABLE_SOFTWARE_RASTERIZER = "disable-software-rasterizer";

    // Disables the Web Speech API (both speech recognition and synthesis).
    public static final String DISABLE_SPEECH_API = "disable-speech-api";

    // Disables the speech synthesis part of Web Speech API.
    public static final String DISABLE_SPEECH_SYNTHESIS_API = "disable-speech-synthesis-api";

    // Disable multithreaded GPU compositing of web content.
    public static final String DISABLE_THREADED_COMPOSITING = "disable-threaded-compositing";

    // Disable V8 idle tasks.
    public static final String DISABLE_V8_IDLE_TASKS = "disable-v8-idle-tasks";

    // Disables WebGL rendering into a scanout buffer for overlay support.
    public static final String DISABLE_WEB_GL_IMAGE_CHROMIUM = "disable-webgl-image-chromium";

    // Don't enforce the same-origin policy; meant for website testing only.
    // This switch has no effect unless --user-data-dir (as defined by the content
    // embedder) is also present.
    public static final String DISABLE_WEB_SECURITY = "disable-web-security";

    // Disable the video decoder from drawing directly to a texture.
    public static final String DISABLE_ZERO_COPY_DXGI_VIDEO = "disable-zero-copy-dxgi-video";

    // Specifies if the |DOMAutomationController| needs to be bound in the
    // renderer. This binding happens on per-frame basis and hence can potentially
    // be a performance bottleneck. One should only enable it when automating dom
    // based tests.
    public static final String DOM_AUTOMATION_CONTROLLER = "dom-automation";

    // Disable antialiasing on 2d canvas clips
    public static final String DISABLE2D_CANVAS_CLIP_ANTIALIASING = "disable-2d-canvas-clip-aa";

    // Disable YUV image decoding for those formats and cases where it's supported.
    // Has no effect unless GPU rasterization is enabled.
    public static final String DISABLE_YUV_IMAGE_DECODING = "disable-yuv-image-decoding";

    // Enables LCD text.
    public static final String ENABLE_LCD_TEXT = "enable-lcd-text";

    // Enable one or more Blink runtime-enabled features.
    // Use names from runtime_enabled_features.json5, separated by commas.
    // Applied before kDisableBlinkFeatures, and after other flags that change these
    // features.
    public static final String ENABLE_BLINK_FEATURES = "enable-blink-features";

    // Enable native caret browsing, in which a moveable cursor is placed on a web
    // page, allowing a user to select and navigate through non-editable text using
    // just a keyboard. See https://crbug.com/977390 for links to i2i.
    public static final String ENABLE_CARET_BROWSING = "enable-caret-browsing";

    // At present this turns on:
    //   net::features::kSameSiteDefaultChecksMethodRigorously
    //   net::features::kSchemefulSameSite
    //   net::features::kCookieSameSiteConsidersRedirectChain
    //   net::features::kPartitionedCookies
    public static final String ENABLE_EXPERIMENTAL_COOKIE_FEATURES = "enable-experimental-cookie-features";

    // Enables experimental WebAssembly features.
    public static final String ENABLE_EXPERIMENTAL_WEB_ASSEMBLY_FEATURES = "enable-experimental-webassembly-features";

    // Enables Web Platform features that are in development.
    public static final String ENABLE_EXPERIMENTAL_WEB_PLATFORM_FEATURES = "enable-experimental-web-platform-features";

    // Forces the V8/blink bindings to call all API entry points that use the
    // [NoAllocDirectCall] extended IDL attribute as if V8 were using the fast call
    // code path.  Using this flag will not make API calls use the true fast path,
    // it will probably even make things a bit slower.  Its purpose is to guarantee
    // test coverage for the blink side of V8 Fast API calls, independently of
    // whether or not V8 actually activates the fast path, which depends on
    // heuristics.  This flag is effective only when DCHECKs are enabled.
    public static final String ENABLE_FAKE_NO_ALLOC_DIRECT_CALL_FOR_TESTING = "enable-fake-no-alloc-direct-call-for-testing";

    // Enables blink runtime enabled features with status:"test" or
    // status:"experimental", which are enabled when running web tests.
    public static final String ENABLE_BLINK_TEST_FEATURES = "enable-blink-test-features";

    // Disables all RuntimeEnabledFeatures that can be enabled via OriginTrials.
    public static final String DISABLE_ORIGIN_TRIAL_CONTROLLED_BLINK_FEATURES = "disable-origin-trial-controlled-blink-features";

    // Enable GpuMemoryBuffer backed VideoFrames.
    public static final String ENABLE_GPU_MEMORY_BUFFER_VIDEO_FRAMES = "enable-gpu-memory-buffer-video-frames";

    // Enables Isolated Web Apps (IWAs) in a renderer process. There are two ways
    // to enable the IWAs: by feature flag and by enterprise policy. If IWAs are
    // enabled by any of the mentioned above ways then this flag is passed to
    // the renderer process. This flag should not be used from command line.
    // To enable IWAs from command line one should use kIsolatedWebApps feature
    // flag.
    public static final String ENABLE_ISOLATED_WEB_APPS_IN_RENDERER = "enable-isolated-web-apps-in-renderer";

    // Force logging to be enabled.  Logging is disabled by default in release
    // builds.
    public static final String ENABLE_LOGGING = "enable-logging";

    // Enables the type, downlinkMax attributes of the NetInfo API. Also, enables
    // triggering of change attribute of the NetInfo API when there is a change in
    // the connection type.
    public static final String ENABLE_NETWORK_INFORMATION_DOWNLINK_MAX = "enable-network-information-downlink-max";

    // Disables the video decoder from drawing to an NV12 textures instead of ARGB.
    public static final String DISABLE_NV12_DXGI_VIDEO = "disable-nv12-dxgi-video";

    // Enables testing features of the Plugin Placeholder. For internal use only.
    public static final String ENABLE_PLUGIN_PLACEHOLDER_TESTING = "enable-plugin-placeholder-testing";

    // Make the values returned to window.performance.memory more granular and more
    // up to date in shared worker. Without this flag, the memory information is
    // still available, but it is bucketized and updated less frequently. This flag
    // also applys to workers.
    public static final String ENABLE_PRECISE_MEMORY_INFO = "enable-precise-memory-info";

    // Enables Privacy Sandbox APIs: Attribution Reporting, Fledge, Topics, Fenced
    // Frames, Shared Storage, Private Aggregation, and their associated features.
    public static final String ENABLE_PRIVACY_SANDBOX_ADS_APIS = "enable-privacy-sandbox-ads-apis";

    // Set options to cache V8 data. (none, code, or default)
    public static final String V8_CACHE_OPTIONS = "v8-cache-options";

    // If true the ServiceProcessLauncher is used to launch services. This allows
    // for service binaries to be loaded rather than using the utility process. This
    // is only useful for tests.
    public static final String ENABLE_SERVICE_BINARY_LAUNCHER = "enable-service-binary-launcher";

    // Enables the Skia benchmarking extension.
    public static final String ENABLE_SKIA_BENCHMARKING = "enable-skia-benchmarking";

    // On platforms that support it, enables smooth scroll animation.
    public static final String ENABLE_SMOOTH_SCROLLING = "enable-smooth-scrolling";

    // Enable spatial navigation
    public static final String ENABLE_SPATIAL_NAVIGATION = "enable-spatial-navigation";

    // Blocks all insecure requests from secure contexts, and prevents the user
    // from overriding that decision.
    public static final String ENABLE_STRICT_MIXED_CONTENT_CHECKING = "enable-strict-mixed-content-checking";

    // Blocks insecure usage of a number of powerful features (device orientation,
    // for example) that we haven't yet deprecated for the web at large.
    public static final String ENABLE_STRICT_POWERFUL_FEATURE_RESTRICTIONS = "enable-strict-powerful-feature-restrictions";

    // When specified along with a value in the range (0,1] will --enable-tracing
    // for (roughly) that percentage of tests being run. This is done in a stable
    // manner such that the same tests are chosen each run, and under the assumption
    // that tests hash equally across the range of possible values.
    // The flag will enable all tracing categories for those tests, and none for the
    // rest. This flag could be used with other tracing switches like
    // --enable-tracing-format, but any other switches that will enable tracing will
    // turn tracing on for all tests.
    public static final String ENABLE_TRACING_FRACTION = "enable-tracing-fraction";

    // Enable screen capturing support for MediaStream API.
    public static final String ENABLE_USER_MEDIA_SCREEN_CAPTURING = "enable-usermedia-screen-capturing";

    // Enables the use of the @viewport CSS rule, which allows
    // pages to control aspects of their own layout. This also turns on touch-screen
    // pinch gestures.
    public static final String ENABLE_VIEWPORT = "enable-viewport";

    // Enable the Vtune profiler support.
    public static final String ENABLE_VTUNE = "enable-vtune-support";

    // Enable the WebAuthn Mojo Testing API. This is a way to interact with the
    // virtual authenticator environment through a mojo interface and is supported
    // only to run web-platform-tests on content shell.
    // Removal of this deprecated API is blocked on crbug.com/937369.
    public static final String ENABLE_WEB_AUTH_DEPRECATED_MOJO_TESTING_API = "enable-web-auth-deprecated-mojo-testing-api";

    // Enables WebGL developer extensions which are not generally exposed
    // to the web platform.
    public static final String ENABLE_WEB_GL_DEVELOPER_EXTENSIONS = "enable-webgl-developer-extensions";

    // Enables WebGL extensions not yet approved by the community.
    public static final String ENABLE_WEB_GL_DRAFT_EXTENSIONS = "enable-webgl-draft-extensions";

    // Enables WebGL rendering into a scanout buffer for overlay support.
    public static final String ENABLE_WEB_GL_IMAGE_CHROMIUM = "enable-webgl-image-chromium";

    // Define an alias root directory which is replaced with the replacement string
    // in file URLs. The format is "/alias=/replacement", which would turn
    // file:///alias/some/path.html into file:///replacement/some/path.html.
    public static final String FILE_URL_PATH_ALIAS = "file-url-path-alias";

    // This forces pages to be loaded as presentation receivers.  Useful for testing
    // behavior specific to presentation receivers.
    // Spec: https://www.w3.org/TR/presentation-api/#interface-presentationreceiver
    public static final String FORCE_PRESENTATION_RECEIVER_FOR_TESTING = "force-presentation-receiver-for-testing";

    // Force renderer accessibility to be on instead of enabling it on demand when
    // a screen reader is detected. The disable-renderer-accessibility switch
    // overrides this if present.
    // This switch has an optional parameter that forces an AXMode bundle. The three
    // available bundle settings are: 'basic', 'form-controls', and 'complete'. If
    // the bundle argument is invalid, then the forced AXMode will default to
    // 'complete'. If the bundle argument is missing, then the initial AXMode will
    // default to complete but allow changes to the AXMode during execution.
    public static final String FORCE_RENDERER_ACCESSIBILITY = "force-renderer-accessibility";

    // Extra command line options for launching the GPU process (normally used
    // for debugging). Use like renderer-cmd-prefix.
    public static final String GPU_LAUNCHER = "gpu-launcher";

    // Makes this process a GPU sub-process.
    public static final String GPU_PROCESS = "gpu-process";

    // Starts the GPU sandbox before creating a GL context.
    public static final String GPU_SANDBOX_START_EARLY = "gpu-sandbox-start-early";

    // Causes the GPU process to display a dialog on launch.
    public static final String GPU_STARTUP_DIALOG = "gpu-startup-dialog";

    // Prevents creating scrollbars for web content. Useful for taking consistent
    // screenshots.
    public static final String HIDE_SCROLLBARS = "hide-scrollbars";

    // Run the GPU process as a thread in the browser process.
    public static final String IN_PROCESS_GPU = "in-process-gpu";

    // Overrides the timeout, in seconds, that a child process waits for a
    // connection from the browser before killing itself.
    public static final String IPC_CONNECTION_TIMEOUT = "ipc-connection-timeout";

    // Require dedicated processes for a set of origins, specified as a
    // comma-separated list. For example:
    //   --isolate-origins=https://www.foo.com,https://www.bar.com
    public static final String ISOLATE_ORIGINS = "isolate-origins";

    // https://crbug.com/1140371
    public static final String ISOLATION_BY_DEFAULT = "isolation-by-default";

    // Disable latest shipping ECMAScript 6 features.
    public static final String DISABLE_JAVA_SCRIPT_HARMONY_SHIPPING = "disable-javascript-harmony-shipping";

    // Enables experimental Harmony (ECMAScript 6) features.
    public static final String JAVA_SCRIPT_HARMONY = "javascript-harmony";

    // Flag to launch tests in the browser process.
    public static final String LAUNCH_AS_BROWSER = "as-browser";

    // Logs GPU control list decisions when enforcing blocklist rules.
    public static final String LOG_GPU_CONTROL_LIST_DECISIONS = "log-gpu-control-list-decisions";

    // Sets the minimum log level. Valid values are from 0 to 3:
    // INFO = 0, WARNING = 1, LOG_ERROR = 2, LOG_FATAL = 3.
    public static final String LOGGING_LEVEL = "log-level";

    // Overrides the default file name to use for general-purpose logging (does not
    // affect which events are logged).
    public static final String LOG_FILE = "log-file";

    // Log an error whenever the unload timeout for a render frame is exceeded.
    public static final String LOG_MISSING_UNLOAD_ACK = "log-missing-unload-ack";

    // Allows user to override maximum number of active WebGL contexts per
    // renderer process.
    public static final String MAX_ACTIVE_WEB_GL_CONTEXTS = "max-active-webgl-contexts";

    // Sets the maximium decoded image size limitation.
    public static final String MAX_DECODED_IMAGE_SIZE_MB = "max-decoded-image-size-mb";

    // Sets the maximum number of WebMediaPlayers allowed per frame.
    public static final String MAX_WEB_MEDIA_PLAYER_COUNT = "max-web-media-player-count";

    // Indicates the utility process should run with a message loop type of UI.
    public static final String MESSAGE_LOOP_TYPE_UI = "message-loop-type-ui";

    // Set the default result for MockCertVerifier. This only works in test code.
    public static final String MOCK_CERT_VERIFIER_DEFAULT_RESULT_FOR_TESTING = "mock-cert-verifier-default-result-for-testing";

    // Initializes Mojo Core from a shared library at the specified path, rather
    // than using the version of Mojo Core embedded within the Content executable.
    public static final String MOJO_CORE_LIBRARY_PATH = "mojo-core-library-path";

    // Use a Mojo-based LocalStorage implementation.
    public static final String MOJO_LOCAL_STORAGE = "mojo-local-storage";

    // Disables the unsandboxed zygote.
    // Note: this flag should not be used on most platforms. It is introduced
    // because some platforms (e.g. Cast) have very limited memory and binaries
    // won't be updated when the browser process is running.
    public static final String NO_UNSANDBOXED_ZYGOTE = "no-unsandboxed-zygote";

    // Disables the use of a zygote process for forking child processes. Instead,
    // child processes will be forked and exec'd directly. Note that --no-sandbox
    // should also be used together with this flag because the sandbox needs the
    // zygote to work.
    public static final String NO_ZYGOTE = "no-zygote";

    // Overrides the language detection result determined based on the page
    // contents.
    public static final String OVERRIDE_LANGUAGE_DETECTION = "override-language-detection";

    // Renderer process that runs the non-PPAPI PDF plugin.
    public static final String PDF_RENDERER = "pdf-renderer";

    // Runs PPAPI (Pepper) plugins in-process.
    public static final String PPAPI_IN_PROCESS = "ppapi-in-process";

    // Specifies a command that should be used to launch the ppapi plugin process.
    // Useful for running the plugin process through purify or quantify.  Ex:
    //   --ppapi-plugin-launcher="path\to\purify /Run=yes"
    public static final String PPAPI_PLUGIN_LAUNCHER = "ppapi-plugin-launcher";

    // Argument to the process type that indicates a PPAPI plugin process type.
    public static final String PPAPI_PLUGIN_PROCESS = "ppapi";

    // Causes the PPAPI sub process to display a dialog on launch. Be sure to use
    // --no-sandbox as well or the sandbox won't allow the dialog to display.
    public static final String PPAPI_STARTUP_DIALOG = "ppapi-startup-dialog";

    // Causes the Private Aggregation API to run without reporting delays.
    public static final String PRIVATE_AGGREGATION_DEVELOPER_MODE = "private-aggregation-developer-mode";

    // IMPORTANT: This isn't to be confused with --site-per-process (which is about
    // isolation, not consolidation). You probably want the other one.
    public static final String PROCESS_PER_SITE = "process-per-site";

    // Runs each set of script-connected tabs (i.e., a BrowsingInstance) in its own
    // renderer process.  We default to using a renderer process for each
    // site instance (i.e., group of pages from the same registered domain with
    // script connections to each other).
    // TODO(creis): This flag is currently a no-op.  We should refactor it to avoid
    // "unnecessary" process swaps for cross-site navigations but still swap when
    // needed for security (e.g., isolated origins).
    public static final String PROCESS_PER_TAB = "process-per-tab";

    // The value of this switch determines whether the process is started as a
    // renderer or plugin host.  If it's empty, it's the browser.
    public static final String PROCESS_TYPE = "type";

    // Causes Protected Audiences Bidding and Auction API to supply the provided
    // debugging key to the trusted auction server. This tells the server that it
    // okay to log information about this user's auction to help with debugging.
    public static final String PROTECTED_AUDIENCES_CONSENTED_DEBUG_TOKEN = "protected-audiences-consented-debug-token";

    // Uses a specified proxy server, overrides system settings. This switch only
    // affects HTTP and HTTPS requests. ARC-apps use only HTTP proxy server with the
    // highest priority.
    // TODO(yzshen): Move this switch back to chrome/common/chrome_switches.{h,cc},
    // once the network service is able to access the corresponding setting via the
    // pref service.
    public static final String PROXY_SERVER = "proxy-server";

    // Enables or disables pull-to-refresh gesture in response to vertical
    // overscroll.
    // Set the value to '0' to disable the feature, set to '1' to enable it for both
    // touchpad and touchscreen, and set to '2' to enable it only for touchscreen.
    // Defaults to disabled.
    public static final String PULL_TO_REFRESH = "pull-to-refresh";

    // Specifies the minimum amount of time, in seconds, that must pass before
    // consecutive quota change events can be fired. Set the value to '0' to disable
    // the debounce mechanimsm.
    public static final String QUOTA_CHANGE_EVENT_INTERVAL = "quota-change-event-interval";

    // Reduce the accept-language http header, and only send one language in the
    // request header: https://github.com/Tanych/accept-language.
    public static final String REDUCE_ACCEPT_LANGUAGE = "reduce-accept-language";

    // Reduce the minor version number in the User-Agent string. This flag
    // implements phase 4 of User-Agent reduction:
    // https://blog.chromium.org/2021/09/user-agent-reduction-origin-trial-and-dates.html.
    public static final String REDUCE_USER_AGENT_MINOR_VERSION = "reduce-user-agent-minor-version";

    // Reduce the platform and oscpu in the desktop User-Agent string. This flag
    // implements phase 5 of User-Agent reduction:
    // https://blog.chromium.org/2021/09/user-agent-reduction-origin-trial-and-dates.html.
    public static final String REDUCE_USER_AGENT_PLATFORM_OS_CPU = "reduce-user-agent-platform-oscpu";

    // Register Pepper plugins (see pepper_plugin_list.cc for its format).
    public static final String REGISTER_PEPPER_PLUGINS = "register-pepper-plugins";

    // Enables remote debug over stdio pipes [in=3, out=4] or over the remote pipes
    // specified in the 'remote-debugging-io-pipes' switch.
    // Optionally, specifies the format for the protocol messages, can be either
    // "JSON" (the default) or "CBOR".
    public static final String REMOTE_DEBUGGING_PIPE = "remote-debugging-pipe";

    // Enables remote debug over HTTP on the specified port.
    public static final String REMOTE_DEBUGGING_PORT = "remote-debugging-port";

    // Enables web socket connections from the specified origins only. '*' allows
    // any origin.
    public static final String REMOTE_ALLOW_ORIGINS = "remote-allow-origins";


    public static final String RENDERER_CLIENT_ID = "renderer-client-id";

    // The contents of this flag are prepended to the renderer command line.
    // Useful values might be "valgrind" or "xterm -e gdb --args".
    public static final String RENDERER_CMD_PREFIX = "renderer-cmd-prefix";

    // Causes the process to run as renderer instead of as browser.
    public static final String RENDERER_PROCESS = "renderer";

    // Time the browser launched the renderer process (in TimeTicks).
    public static final String RENDERER_PROCESS_LAUNCH_TIME_TICKS = "launch-time-ticks";

    // Overrides the default/calculated limit to the number of renderer processes.
    // Very high values for this setting can lead to high memory/resource usage
    // or instability.
    public static final String RENDERER_PROCESS_LIMIT = "renderer-process-limit";

    // Causes the renderer process to display a dialog on launch. Passing this flag
    // also adds sandbox::policy::kNoSandbox on Windows non-official builds, since
    // that's needed to show a dialog.
    public static final String RENDERER_STARTUP_DIALOG = "renderer-startup-dialog";

    // Manual tests only run when --run-manual is specified. This allows writing
    // tests that don't run automatically but are still in the same test binary.
    // This is useful so that a team that wants to run a few tests doesn't have to
    // add a new binary that must be compiled on all builds.
    public static final String RUN_MANUAL_TESTS_FLAG = "run-manual";

    // Causes the process to run as a sandbox IPC subprocess.
    public static final String SANDBOX_IPC_PROCESS = "sandbox-ipc";


    public static final String SHARED_ARRAY_BUFFER_UNRESTRICTED_ACCESS_ALLOWED = "shared-array-buffer-unrestricted-access-allowed";

    // where <file_id> is an ID string from the manifest of the service being
    // launched and <descriptor_id> is the numeric identifier of the descriptor for
    // the child process can use to retrieve the file descriptor from the
    // global descriptor table.
    public static final String SHARED_FILES = "shared-files";

    // Runs the renderer and plugins in the same process as the browser
    public static final String SINGLE_PROCESS = "single-process";

    // IMPORTANT: this isn't to be confused with --process-per-site (which is about
    // process consolidation, not isolation). You probably want this one.
    public static final String SITE_PER_PROCESS = "site-per-process";

    // Note that for historic reasons the name of the switch misleadingly mentions
    // "trials", but the switch also disables the default site isolation that ships
    // on desktop since M67.  The name of the switch is preserved for
    // backcompatibility of chrome://flags.
    public static final String DISABLE_SITE_ISOLATION = "disable-site-isolation-trials";

    // Specifies if the browser should start in fullscreen mode, like if the user
    // had pressed F11 right after startup.
    public static final String START_FULLSCREEN = "start-fullscreen";

    // Specifies if the |StatsCollectionController| needs to be bound in the
    // renderer. This binding happens on per-frame basis and hence can potentially
    // be a performance bottleneck. One should only enable it when running a test
    // that needs to access the provided statistics.
    public static final String STATS_COLLECTION_CONTROLLER = "enable-stats-collection-bindings";

    // Specifies the max number of bytes that should be used by the skia font cache.
    // If the cache needs to allocate more, skia will purge previous entries.
    public static final String SKIA_FONT_CACHE_LIMIT_MB = "skia-font-cache-limit-mb";

    // Specifies the max number of bytes that should be used by the skia resource
    // cache. The previous entries are purged from the cache when the memory useage
    // exceeds this limit.
    public static final String SKIA_RESOURCE_CACHE_LIMIT_MB = "skia-resource-cache-limit-mb";

    // Type of the current test harness ("browser" or "ui" or "gpu").
    public static final String TEST_TYPE = "test-type";

    // The time zone to use for testing. Passed to renderers and plugins on startup.
    public static final String TIME_ZONE_FOR_TESTING = "time-zone-for-testing";

    // Enable support for touch event feature detection.
    public static final String TOUCH_EVENT_FEATURE_DETECTION = "touch-events";

    // The values the kTouchEventFeatureDetection switch may have, as in
    // --touch-events=disabled.
    //   auto: enabled at startup when an attached touchscreen is present.
    public static final String TOUCH_EVENT_FEATURE_DETECTION_AUTO = "auto";

    //   enabled: touch events always enabled.
    public static final String TOUCH_EVENT_FEATURE_DETECTION_ENABLED = "enabled";

    //   disabled: touch events are disabled.
    public static final String TOUCH_EVENT_FEATURE_DETECTION_DISABLED = "disabled";

    // Accepts a number representing the time-ticks value at the Unix epoch.
    // Since different processes can produce a different value for this due to
    // system clock changes, this allows synchronizing them to a single value.
    public static final String TIME_TICKS_AT_UNIX_EPOCH = "time-ticks-at-unix-epoch";

    // Replaces the existing codecs supported in peer connection with a single fake
    // codec entry that create a fake video encoder and decoder.
    public static final String USE_FAKE_CODEC_FOR_PEER_CONNECTION = "use-fake-codec-for-peer-connection";

    // Bypass the FedCM account selection dialog. If a value is provided for
    // this switch, that account ID is selected, otherwise the first account
    // is chosen.
    public static final String USE_FAKE_UI_FOR_FED_CM = "use-fake-ui-for-fedcm";

    // Bypass the media stream infobar by selecting the default device for media
    // streams (e.g. WebRTC). Works with --use-fake-device-for-media-stream.
    public static final String USE_FAKE_UI_FOR_MEDIA_STREAM = "use-fake-ui-for-media-stream";

    // Texture target for CHROMIUM_image backed video frame textures.
    public static final String VIDEO_IMAGE_TEXTURE_TARGET = "video-image-texture-target";

    // Set when Chromium should use a mobile user agent.
    public static final String USE_MOBILE_USER_AGENT = "use-mobile-user-agent";

    // Use the MockCertVerifier. This only works in test code.
    public static final String USE_MOCK_CERT_VERIFIER_FOR_TESTING = "use-mock-cert-verifier-for-testing";

    // The contents of this flag are prepended to the utility process command line.
    // Useful values might be "valgrind" or "xterm -e gdb --args".
    public static final String UTILITY_CMD_PREFIX = "utility-cmd-prefix";

    // Causes the process to run as a utility subprocess.
    public static final String UTILITY_PROCESS = "utility";

    // Causes the utility process to display a dialog on launch.
    public static final String UTILITY_STARTUP_DIALOG = "utility-startup-dialog";

    // This switch indicates the type of a utility process. It does not affect the
    // services offered by the process, but is added to the command line for
    // debugging and profiling purposes.
    public static final String UTILITY_SUB_TYPE = "utility-sub-type";

    // In debug builds, asserts that the stream of input events is valid.
    public static final String VALIDATE_INPUT_EVENT_STREAM = "validate-input-event-stream";

    // Causes tests to attempt to verify pixel output.
    public static final String VERIFY_PIXELS = "browser-ui-tests-verify-pixels";

    // Will add kWaitForDebugger to every child processes. If a value is passed, it
    // will be used as a filter to determine if the child process should have the
    // kWaitForDebugger flag passed on or not.
    public static final String WAIT_FOR_DEBUGGER_CHILDREN = "wait-for-debugger-children";

    // On every navigation a message with the renderer's URL will be logged and the
    // renderer will wait for a debugger to be attached or SIGUSR1 to be sent to
    // continue execution.
    public static final String WAIT_FOR_DEBUGGER_ON_NAVIGATION = "wait-for-debugger-on-navigation";

    // Flag used by WebUI test runners to wait for debugger to be attached.
    public static final String WAIT_FOR_DEBUGGER_WEB_UI = "wait-for-debugger-webui";

    // Allows trusted remote desktop clients to make WebAuthn requests on behalf of
    // other origins. This switch only controls availability of the
    // `remoteDesktopClientOverride` extension but doesn't by itself enable any
    // origin to use it.
    public static final String WEB_AUTH_REMOTE_DESKTOP_SUPPORT = "webauthn-remote-desktop-support";

    // Set the antialiasing method used for webgl. (none, explicit, implicit)
    public static final String WEBGL_ANTIALIASING_MODE = "webgl-antialiasing-mode";

    // Set a default sample count for webgl if msaa is enabled.
    public static final String WEBGL_MSAA_SAMPLE_COUNT = "webgl-msaa-sample-count";

    // The prefix used when starting the zygote process. (i.e. 'gdb --args')
    public static final String ZYGOTE_CMD_PREFIX = "zygote-cmd-prefix";

    // Causes the process to run as a zygote.
    public static final String ZYGOTE_PROCESS = "zygote";

    // Enables specified backend for the Web OTP API.
    public static final String WEB_OTP_BACKEND = "web-otp-backend";

    // Enables Sms Verification backend for Web OTP API which requires app hash in
    // SMS body.
    public static final String WEB_OTP_BACKEND_SMS_VERIFICATION = "web-otp-backend-sms-verification";

    // Enables User Consent backend for Web OTP API.
    public static final String WEB_OTP_BACKEND_USER_CONSENT = "web-otp-backend-user-consent";

    // Enables auto backend selection for Web OTP API.
    public static final String WEB_OTP_BACKEND_AUTO = "web-otp-backend-auto";

    // Disables encryption of RTP Media for WebRTC. When Chrome embeds Content, it
    // ignores this switch on its stable and beta channels.
    public static final String DISABLE_WEB_RTC_ENCRYPTION = "disable-webrtc-encryption";

    // Disables HW decode acceleration for WebRTC.
    public static final String DISABLE_WEB_RTC_HW_DECODING = "disable-webrtc-hw-decoding";

    // Disables HW encode acceleration for WebRTC.
    public static final String DISABLE_WEB_RTC_HW_ENCODING = "disable-webrtc-hw-encoding";

    // Enables negotiation of encrypted header extensions from RFC 6904 for SRTP
    // in WebRTC.
    // See https://tools.ietf.org/html/rfc6904 for further information.
    // TODO(https://crbug.com/954201): Remove this.
    public static final String ENABLE_WEB_RTC_SRTP_ENCRYPTED_HEADERS = "enable-webrtc-srtp-encrypted-headers";

    // Enforce IP Permission check. TODO(guoweis): Remove this once the feature is
    // not under finch and becomes the default.
    public static final String ENFORCE_WEB_RTC_IP_PERMISSION_CHECK = "enforce-webrtc-ip-permission-check";

    // Override WebRTC IP handling policy to mimic the behavior when WebRTC IP
    // handling policy is specified in Preferences.
    public static final String FORCE_WEB_RTC_IP_HANDLING_POLICY = "force-webrtc-ip-handling-policy";

    // Override the maximum framerate as can be specified in calls to getUserMedia.
    // This flag expects a value.  Example: --max-gum-fps=17.5
    public static final String WEB_RTC_MAX_CAPTURE_FRAMERATE = "max-gum-fps";

    // Enable capture and local storage of WebRTC event logs without visiting
    // chrome://webrtc-internals. This is useful for automated testing. It accepts
    // the path to which the local logs would be stored. Disabling is not possible
    // without restarting the browser and relaunching without this flag.
    public static final String WEB_RTC_LOCAL_EVENT_LOGGING = "webrtc-event-logging";

    // This switch disables the ScrollToTextFragment feature.
    public static final String DISABLE_SCROLL_TO_TEXT_FRAGMENT = "disable-scroll-to-text-fragment";

    // Forcibly enable and select the specified runtime for webxr.
    // Note that this provides an alternative means of enabling a runtime, and will
    // also functionally disable all other runtimes.
    public static final String WEB_XR_FORCE_RUNTIME = "force-webxr-runtime";

    // Tell WebXr to assume that it does not support any runtimes.
    public static final String WEB_XR_RUNTIME_NONE = "no-vr-runtime";


    public static final String WEB_XR_RUNTIME_ORIENTATION_SENSORS = "orientation-sensors";

    // The following are the runtimes that WebXr supports.
    public static final String WEB_XR_RUNTIME_CARDBOARD = "cardboard";


    public static final String WEB_XR_RUNTIME_GVR = "gvr";


    public static final String WEB_XR_RUNTIME_OPEN_XR = "openxr";

    // Disable Media Session API
    public static final String DISABLE_MEDIA_SESSION_API = "disable-media-session-api";

    // Disable the locking feature of the screen orientation API.
    public static final String DISABLE_SCREEN_ORIENTATION_LOCK = "disable-screen-orientation-lock";

    // Just like kDisableSiteIsolation, but doesn't show the "stability and security
    // will suffer" butter bar warning.
    public static final String DISABLE_SITE_ISOLATION_FOR_POLICY = "disable-site-isolation-for-policy";

    // Disable timeouts that may cause the browser to die when running slowly. This
    // is useful if running with profiling (such as debug malloc).
    public static final String DISABLE_TIMEOUTS_FOR_PROFILING = "disable-timeouts-for-profiling";

    // Enable inverting of selection handles so that they are not clipped by the
    // viewport boundaries.
    public static final String ENABLE_ADAPTIVE_SELECTION_HANDLE_ORIENTATION = "enable-adaptive-selection-handle-orientation";

    // Enable drag manipulation of longpress-triggered text selections.
    public static final String ENABLE_LONGPRESS_DRAG_SELECTION = "enable-longpress-drag-selection";

    // Prevent the offline indicator from showing.
    public static final String FORCE_ONLINE_CONNECTION_STATE_FOR_INDICATOR = "force-online-connection-state-for-indicator";

    // Enables remote debug over HTTP on the specified socket name.
    public static final String REMOTE_DEBUGGING_SOCKET_NAME = "remote-debugging-socket-name";

    // Block ChildProcessMain thread of the renderer's ChildProcessService until a
    // Java debugger is attached.
    public static final String RENDERER_WAIT_FOR_JAVA_DEBUGGER = "renderer-wait-for-java-debugger";

    // Disables debug crash dumps for OOPR.
    public static final String DISABLE_OOPR_DEBUG_CRASH_DUMP = "disable-oopr-debug-crash-dump";

    // Enable the aggressive flushing of DOM Storage to minimize data loss.
    public static final String ENABLE_AGGRESSIVE_DOM_STORAGE_FLUSHING = "enable-aggressive-domstorage-flushing";

    // Enable indication that browser is controlled by automation.
    public static final String ENABLE_AUTOMATION = "enable-automation";

    // Allows sending text-to-speech requests to speech-dispatcher, a common
    // Linux speech service. Because it's buggy, the user must explicitly
    // enable it so that visiting a random webpage can't cause instability.
    public static final String ENABLE_SPEECH_DISPATCHER = "enable-speech-dispatcher";

    // For lacros, we do not use environment variable to pass values. Instead we
    // use a command line flag to pass the path to the device.
    public static final String LLVM_PROFILE_FILE = "llvm-profile-file";

    // /prefetch:# arguments to use when launching various process types. It has
    // been observed that when file reads are consistent for 3 process launches with
    // the same /prefetch:# argument, the Windows prefetcher starts issuing reads in
    // batch at process launch. Because reads depend on the process type, the
    // prefetcher wouldn't be able to observe consistent reads if no /prefetch:#
    // arguments were used. Note that the browser process has no /prefetch:#
    // argument; as such all other processes must have one in order to avoid
    // polluting its profile. Note: # must always be in [1, 8]; otherwise it is
    // ignored by the Windows prefetcher.
    public static final String PREFETCH_ARGUMENT_RENDERER = "/prefetch:1";


    public static final String PREFETCH_ARGUMENT_GPU = "/prefetch:2";


    public static final String PREFETCH_ARGUMENT_PPAPI = "/prefetch:3";


    public static final String PREFETCH_ARGUMENT_PPAPI_BROKER = "/prefetch:4";

    // /prefetch:# argument shared by all process types that don't have their own.
    // It is likely that the prefetcher won't work for these process types as it
    // won't be able to observe consistent file reads across launches. However,
    // having a valid prefetch argument for these process types is required to
    // prevent them from interfering with the prefetch profile of the browser
    // process.
    public static final String PREFETCH_ARGUMENT_OTHER = "/prefetch:8";

    // Device scale factor passed to certain processes like renderers, etc.
    public static final String DEVICE_SCALE_FACTOR = "device-scale-factor";

    // Disable the Legacy Window which corresponds to the size of the WebContents.
    public static final String DISABLE_LEGACY_INTERMEDIATE_WINDOW = "disable-legacy-window";

    // DirectWrite FontCache is shared by browser to renderers using shared memory.
    // This switch allows us to pass the shared memory handle to the renderer.
    public static final String FONT_CACHE_SHARED_HANDLE = "font-cache-shared-handle";

    // The boolean value (0/1) of FontRenderParams::antialiasing to be passed to
    // Ppapi processes.
    public static final String PPAPI_ANTIALIASED_TEXT_ENABLED = "ppapi-antialiased-text-enabled";

    // The enum value of FontRenderParams::subpixel_rendering to be passed to Ppapi
    // processes.
    public static final String PPAPI_SUBPIXEL_RENDERING_SETTING = "ppapi-subpixel-rendering-setting";

    // Raise the timer interrupt frequency in all Chrome processes, for experimental
    // purposes. This feature is needed because as of Windows 10 2004 the scheduling
    // effects of changing the timer interrupt frequency are not global, and this
    // lets us prove/disprove whether this matters. See https://crbug.com/1128917
    public static final String RAISE_TIMER_FREQUENCY = "raise-timer-frequency";

    // Causes the second GPU process used for gpu info collection to display a
    // dialog on launch.
    public static final String GPU2_STARTUP_DIALOG = "gpu2-startup-dialog";

    // Use high priority for the audio process.
    public static final String AUDIO_PROCESS_HIGH_PRIORITY = "audio-process-high-priority";

    // Specifies pipe names for the incoming and outbound messages on the Windows
    // platform. This is a comma separated list of two pipe handles serialized as
    // unsigned integers, e.g. "--remote-debugging-io-pipes=3,4".
    public static final String REMOTE_DEBUGGING_IO_PIPES = "remote-debugging-io-pipes";

    // Dumps IPC messages sent from renderer processes to the browser process to
    // the given directory. Used primarily to gather samples for IPC fuzzing.
    public static final String IPC_DUMP_DIRECTORY = "ipc-dump-directory";

    // Specifies the testcase used by the IPC fuzzer.
    public static final String IPC_FUZZER_TESTCASE = "ipc-fuzzer-testcase";

    // Prevent instantiation.
    private ContentSwitches() {
    }
}
