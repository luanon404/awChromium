// Copyright 2021 The Chromium Authors
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.

package org.chromium.content_public.common;

/**
 * Constants for the names of Content Features.
 */
public final class ContentFeatures {


    // This following string constants were inserted by
    //     java_cpp_features.py
    // From
    //     ../../content/public/common/content_features.cc
    // Into
    //     ../../content/public/common/android/java_templates/ContentFeatures.java.tmpl

    // Use chromim's implementation of selection magnifier built using surface
    // control APIs, instead of using the system-provided magnifier.
    public static final String ANDROID_SURFACE_CONTROL_MAGNIFIER = "AndroidSurfaceControlMagnifier";

    // Enables FLEDGE and Attribution Reporting API integration.
    public static final String ATTRIBUTION_FENCED_FRAME_REPORTING_BEACON = "AttributionFencedFrameReportingBeacon";

    // Launches the audio service on the browser startup.
    public static final String AUDIO_SERVICE_LAUNCH_ON_STARTUP = "AudioServiceLaunchOnStartup";

    // Runs the audio service in a separate process.
    public static final String AUDIO_SERVICE_OUT_OF_PROCESS = "AudioServiceOutOfProcess";

    // Enables the audio-service sandbox. This feature has an effect only when the
    // kAudioServiceOutOfProcess feature is enabled.
    public static final String AUDIO_SERVICE_SANDBOX = "AudioServiceSandbox";

    // Kill switch for Background Fetch.
    public static final String BACKGROUND_FETCH = "BackgroundFetch";

    // Enable using the BackForwardCache.
    public static final String BACK_FORWARD_CACHE = "BackForwardCache";

    // Enable showing a page preview during back/forward navigations.
    public static final String BACK_FORWARD_TRANSITIONS = "BackForwardTransitions";

    // Allows pages that created a MediaSession service to stay eligible for the
    // back/forward cache.
    public static final String BACK_FORWARD_CACHE_MEDIA_SESSION_SERVICE = "BackForwardCacheMediaSessionService";

    // Set a time limit for the page to enter the cache. Disabling this prevents
    // flakes during testing.
    public static final String BACK_FORWARD_CACHE_ENTRY_TIMEOUT = "BackForwardCacheEntryTimeout";

    // BackForwardCacheMemoryControls is enabled only on Android to disable
    // BackForwardCache for lower memory devices due to memory limiations.
    public static final String BACK_FORWARD_CACHE_MEMORY_CONTROLS = "BackForwardCacheMemoryControls";

    // See also:
    //  - https://wicg.github.io/private-network-access/#integration-fetch
    //  - kBlockInsecurePrivateNetworkRequestsFromPrivate
    //  - kBlockInsecurePrivateNetworkRequestsFromUnknown
    public static final String BLOCK_INSECURE_PRIVATE_NETWORK_REQUESTS = "BlockInsecurePrivateNetworkRequests";

    // See also:
    //  - https://wicg.github.io/private-network-access/#integration-fetch
    //  - kBlockInsecurePrivateNetworkRequests
    public static final String BLOCK_INSECURE_PRIVATE_NETWORK_REQUESTS_FROM_PRIVATE = "BlockInsecurePrivateNetworkRequestsFromPrivate";

    // Enables use of the PrivateNetworkAccessNonSecureContextsAllowed deprecation
    // trial. This is a necessary yet insufficient condition: documents that wish to
    // make use of the trial must additionally serve a valid origin trial token.
    public static final String BLOCK_INSECURE_PRIVATE_NETWORK_REQUESTS_DEPRECATION_TRIAL = "BlockInsecurePrivateNetworkRequestsDeprecationTrial";

    // Broker file operations on disk cache in the Network Service.
    // This is no-op if the network service is hosted in the browser process.
    public static final String BROKER_FILE_OPERATIONS_ON_DISK_CACHE_IN_NETWORK_SERVICE = "BrokerFileOperationsOnDiskCacheInNetworkService";

    // When enabled, mouse user activation will be verified by the browser side.
    public static final String BROWSER_VERIFIED_USER_ACTIVATION_MOUSE = "BrowserVerifiedUserActivationMouse";

    // Allows pages with cache-control:no-store to enter the back/forward cache.
    // Feature params can specify whether pages with cache-control:no-store can be
    // restored if cookies change / if HTTPOnly cookies change.
    // TODO(crbug.com/1228611): Enable this feature.
    public static final String CACHE_CONTROL_NO_STORE_ENTER_BACK_FORWARD_CACHE = "CacheControlNoStoreEnterBackForwardCache";

    // This serves as an overall kill switch to kill CdmStorageDatabase. If
    // disabled, which it is by default, no operations will be routed through the
    // CdmStorage* path, even in the migration code that lives in MediaLicense* code
    // path.
    public static final String CDM_STORAGE_DATABASE = "CdmStorageDatabase";

    // This guards between using the MediaLicense* code path and the CdmStorage*
    // code path for storing Cdm data. This will be enabled by default as we do not
    // want the CdmStorageDatabase to be used solely, and instead when we conduct
    // our experiments, we will enable kCdmStorageDatabase to flow the migration.
    // Later when the migration is finished, we will remove this flag so that
    // kCdmStorageDatabase serves as the only flag. Refer to
    // go/cdm-storage-migration-details for more details.
    public static final String CDM_STORAGE_DATABASE_MIGRATION = "CdmStorageDatabaseMigration";

    // Clear the window.name property for the top-level cross-site navigations that
    // swap BrowsingContextGroups(BrowsingInstances).
    public static final String CLEAR_CROSS_SITE_CROSS_BROWSING_CONTEXT_GROUP_WINDOW_NAME = "ClearCrossSiteCrossBrowsingContextGroupWindowName";


    public static final String COMPOSITE_BG_COLOR_ANIMATION = "CompositeBGColorAnimation";

    // Gate access to cookie deprecation API which allows developers to opt in
    // server side testing without cookies.
    // (See https://developer.chrome.com/en/docs/privacy-sandbox/chrome-testing)
    public static final String COOKIE_DEPRECATION_FACILITATED_TESTING = "CookieDeprecationFacilitatedTesting";

    // Enables Blink cooperative scheduling.
    public static final String COOPERATIVE_SCHEDULING = "CooperativeScheduling";

    // Enables crash reporting via Reporting API.
    // https://www.w3.org/TR/reporting/#crash-report
    public static final String CRASH_REPORTING = "CrashReporting";

    // Enable the device posture API.
    // Tracking bug for enabling device posture API: https://crbug.com/1066842.
    public static final String DEVICE_POSTURE = "DevicePosture";

    // Controls whether the Digital Goods API is enabled.
    // https://github.com/WICG/digital-goods/
    public static final String DIGITAL_GOODS_API = "DigitalGoodsApi";

    // Enables the DIPS (Detect Incidental Party State) feature.
    // On by default to allow for collecting metrics. All potentially dangerous
    // behavior (database persistence, DIPS deletion) will be gated by params.
    public static final String DIPS = "DIPS";

    // Enables disconnecting the `ExtensionMessagePort` when the page using the port
    // enters BFCache.
    public static final String DISCONNECT_EXTENSION_MESSAGE_PORT_WHEN_PAGE_ENTERS_BF_CACHE = "DisconnectExtensionMessagePortWhenPageEntersBFCache";

    // Enable document policy for configuring and restricting feature behavior.
    public static final String DOCUMENT_POLICY = "DocumentPolicy";

    // Enable drawing under System Bars within DisplayCutout.
    public static final String DRAW_CUTOUT_EDGE_TO_EDGE = "DrawCutoutEdgeToEdge";

    // Enable early swapping of RenderFrameHosts during some back/forward
    // navigations. This is an experimental feature intended to support new kinds of
    // navigation transitions. See https://crbug.com/1480129.
    public static final String EARLY_DOCUMENT_SWAP_FOR_BACK_FORWARD_TRANSITIONS = "EarlyDocumentSwapForBackForwardTransitions";

    // Enable establishing the GPU channel early in renderer startup.
    public static final String EARLY_ESTABLISH_GPU_CHANNEL = "EarlyEstablishGpuChannel";

    // Enables canvas 2d methods BeginLayer and EndLayer.
    public static final String ENABLE_CANVAS2D_LAYERS = "EnableCanvas2DLayers";

    // Enables the Machine Learning Model Loader Web Platform API. Explainer:
    // https://github.com/webmachinelearning/model-loader/blob/main/explainer.md
    public static final String ENABLE_MACHINE_LEARNING_MODEL_LOADER_WEB_PLATFORM_API = "EnableMachineLearningModelLoaderWebPlatformApi";

    // Enables service workers on chrome-untrusted:// urls.
    public static final String ENABLE_SERVICE_WORKERS_FOR_CHROME_UNTRUSTED = "EnableServiceWorkersForChromeUntrusted";

    // Enables service workers on chrome:// urls.
    public static final String ENABLE_SERVICE_WORKERS_FOR_CHROME_SCHEME = "EnableServiceWorkersForChromeScheme";

    // Enables JavaScript API to intermediate federated identity requests.
    // Note that actual exposure of the FedCM API to web content is controlled
    // by the flag in RuntimeEnabledFeatures on the blink side. See also
    // the use of kSetOnlyIfOverridden in content/child/runtime_features.cc.
    // We enable it here by default to support use in origin trials.
    public static final String FED_CM = "FedCm";

    // Enables usage of the FedCM IdentityCredentialAutoSelectedFlag feature.
    // ChromeStatus entry: https://chromestatus.com/feature/5384360374566912
    public static final String FED_CM_IDENTITY_CREDENTIAL_AUTO_SELECTED_FLAG = "FedCmIdentityCredentialAutoSelectedFlag";

    // Enables usage of the FedCM Authz API.
    public static final String FED_CM_AUTHZ = "FedCmAuthz";

    // Enables usage of the FedCM Error API.
    public static final String FED_CM_ERROR = "FedCmError";

    // Enables usage of the FedCM HostedDomain feature. ChromeStatus entry:
    // https://chromestatus.com/feature/5202286040580096
    public static final String FED_CM_HOSTED_DOMAIN = "FedCmHostedDomain";

    // Enables usage of the FedCM IdP Registration API.
    public static final String FED_CM_ID_P_REGISTRATION = "FedCmIdPregistration";

    // Enables usage of the FedCM logoutRPs method.
    public static final String FED_CM_LOGOUT_RPS = "FedCmLogoutRps";

    // Enables usage of the FedCM API with metrics endpoint at the same time.
    public static final String FED_CM_METRICS_ENDPOINT = "FedCmMetricsEndpoint";

    // Enables usage of the FedCM API with multiple identity providers at the same
    // time.
    public static final String FED_CM_MULTIPLE_IDENTITY_PROVIDERS = "FedCmMultipleIdentityProviders";

    // Enables usage of the FedCM API with the Selective Disclosure API at the same
    // time.
    public static final String FED_CM_SELECTIVE_DISCLOSURE = "FedCmSelectiveDisclosure";

    // Enables the IDP signin status API for use with FedCM, including avoiding
    // network requests when not signed in and mismatch handling.
    public static final String FED_CM_IDP_SIGNIN_STATUS_ENABLED = "FedCmIdpSigninStatusEnabled";

    // Enables bypassing the well-known file enforcement.
    public static final String FED_CM_WITHOUT_WELL_KNOWN_ENFORCEMENT = "FedCmWithoutWellKnownEnforcement";

    // Enables browser-side focus verification when crossing fenced boundaries.
    public static final String FENCED_FRAMES_ENFORCE_FOCUS = "FencedFramesEnforceFocus";

    // Enables the MDocs API in the IdentityCredential.
    public static final String WEB_IDENTITY_M_DOCS = "WebIdentityMDocs";

    // Enables usage of First Party Sets to determine cookie availability.
    public static final String FIRST_PARTY_SETS = "FirstPartySets";

    // Enables scrollers inside Blink to store scroll offsets in fractional
    // floating-point numbers rather than truncating to integers.
    public static final String FRACTIONAL_SCROLL_OFFSETS = "FractionalScrollOffsets";

    // Puts network quality estimate related Web APIs in the holdback mode. When the
    // holdback is enabled the related Web APIs return network quality estimate
    // set by the experiment (regardless of the actual quality).
    public static final String NETWORK_QUALITY_ESTIMATOR_WEB_HOLDBACK = "NetworkQualityEstimatorWebHoldback";

    // Determines if an extra brand version pair containing possibly escaped double
    // quotes and escaped backslashed should be added to the Sec-CH-UA header
    // (activated by kUserAgentClientHint)
    public static final String GREASE_UACH = "GreaseUACH";

    // This is intended as a kill switch for the Idle Detection feature. To enable
    // this feature, the experimental web platform features flag should be set,
    // or the site should obtain an Origin Trial token.
    public static final String IDLE_DETECTION = "IdleDetection";

    // Kill switch for the GetInstalledRelatedApps API.
    public static final String INSTALLED_APP = "InstalledApp";

    // Allow Windows specific implementation for the GetInstalledRelatedApps API.
    public static final String INSTALLED_APP_PROVIDER = "InstalledAppProvider";

    // Enable support for isolated web apps. This will guard features like serving
    // isolated web apps via the isolated-app:// scheme, and other advanced isolated
    // app functionality. See https://github.com/reillyeon/isolated-web-apps for a
    // general overview.
    // This also enables support for IWA Controlled Frame, providing the Controlled
    // Frame tag to IWA apps. See
    // https://github.com/chasephillips/controlled-frame/blob/main/EXPLAINER.md for
    // more info. Please don't use this feature flag directly to guard the IWA code.
    // Use IsolatedWebAppsPolicy::AreIsolatedWebAppsEnabled() in the browser process
    // or check kEnableIsolatedWebAppsInRenderer command line flag in the renderer
    // process.
    public static final String ISOLATED_WEB_APPS = "IsolatedWebApps";

    // Enables process isolation of fenced content (content inside fenced frames)
    // from non-fenced content. See
    // https://github.com/WICG/fenced-frame/blob/master/explainer/process_isolation.md
    // for rationale and more details.
    public static final String ISOLATE_FENCED_FRAMES = "IsolateFencedFrames";

    // Alternative to switches::kIsolateOrigins, for turning on origin isolation.
    // List of origins to isolate has to be specified via
    // kIsolateOriginsFieldTrialParamName.
    public static final String ISOLATE_ORIGINS = "IsolateOrigins";

    // Enables experimental JavaScript shared memory features.
    public static final String JAVA_SCRIPT_EXPERIMENTAL_SHARED_MEMORY = "JavaScriptExperimentalSharedMemory";

    // Enable lazy initialization of the media controls.
    public static final String LAZY_INITIALIZE_MEDIA_CONTROLS = "LazyInitializeMediaControls";

    // Using top-level document URL when create an enterprise report for legacy
    // technologies usage
    public static final String LEGACY_TECH_REPORT_TOP_LEVEL_URL = "LegacyTechReportTopLevelUrl";

    // Configures whether Blink on Windows 8.0 and below should use out of process
    // API font fallback calls to retrieve a fallback font family name as opposed to
    // using a hard-coded font lookup table.
    public static final String LEGACY_WINDOWS_D_WRITE_FONT_FALLBACK = "LegacyWindowsDWriteFontFallback";


    public static final String LOG_JS_CONSOLE_MESSAGES = "LogJsConsoleMessages";

    // Uses ThreadType::kCompositing for the main thread
    public static final String MAIN_THREAD_COMPOSITING_PRIORITY = "MainThreadCompositingPriority";

    // The MBI mode controls whether or not communication over the
    // AgentSchedulingGroup is ordered with respect to the render-process-global
    // legacy IPC channel, as well as the granularity of AgentSchedulingGroup
    // creation. This will break ordering guarantees between different agent
    // scheduling groups (ordering withing a group is still preserved).
    // DO NOT USE! The feature is not yet fully implemented. See crbug.com/1111231.
    public static final String MBI_MODE = "MBIMode";

    // Enables/disables the video capture service.
    public static final String MOJO_VIDEO_CAPTURE = "MojoVideoCapture";

    // When NavigationNetworkResponseQueue is enabled, the browser will schedule
    // some tasks related to navigation network responses in a kHigh priority
    // queue.
    public static final String NAVIGATION_NETWORK_RESPONSE_QUEUE = "NavigationNetworkResponseQueue";

    // When enabled, RenderFrameHostManager::CommitPending will also update the
    // visibility of all child views, not just that of the main frame.
    public static final String NAVIGATION_UPDATES_CHILD_VIEWS_VISIBILITY = "NavigationUpdatesChildViewsVisibility";

    // If the network service is enabled, runs it in process.
    public static final String NETWORK_SERVICE_IN_PROCESS = "NetworkServiceInProcess2";

    // Kill switch for Web Notification content images.
    public static final String NOTIFICATION_CONTENT_IMAGE = "NotificationContentImage";

    // Enables the notification trigger API.
    public static final String NOTIFICATION_TRIGGERS = "NotificationTriggers";

    // Feature which holdbacks NoStatePrefetch on all surfaces.
    public static final String NO_STATE_PREFETCH_HOLDBACK = "NoStatePrefetchHoldback";

    // The name is "OriginIsolationHeader" because that was the old name when the
    // feature was under development.
    public static final String ORIGIN_ISOLATION_HEADER = "OriginIsolationHeader";

    // History navigation in response to horizontal overscroll (aka gesture-nav).
    public static final String OVERSCROLL_HISTORY_NAVIGATION = "OverscrollHistoryNavigation";

    // Setting to control overscroll history navigation.
    public static final String OVERSCROLL_HISTORY_NAVIGATION_SETTING = "OverscrollHistoryNavigationSetting";

    // Whether web apps can run periodic tasks upon network connectivity.
    public static final String PERIODIC_BACKGROUND_SYNC = "PeriodicBackgroundSync";

    // Kill-switch to introduce a compatibility breaking restriction.
    public static final String PEPPER_CROSS_ORIGIN_REDIRECT_RESTRICTION = "PepperCrossOriginRedirectRestriction";

    // Enables Persistent Origin Trials. It causes tokens for an origin to be stored
    // and persisted for the next navigation. This way, an origin trial can affect
    // things before receiving the response, for instance it can affect the next
    // navigation's network request.
    public static final String PERSISTENT_ORIGIN_TRIALS = "PersistentOriginTrials";

    // If enabled, then an updated prefetch request limit policy will be used that
    // separates eager and non-eager prefetches, and allows for evictions.
    public static final String PREFETCH_NEW_LIMITS = "PrefetchNewLimits";

    // Enables exposure of ads APIs in the renderer: Attribution Reporting,
    // FLEDGE, Topics, along with a number of other features actively in development
    // within these APIs.
    public static final String PRIVACY_SANDBOX_ADS_AP_IS_OVERRIDE = "PrivacySandboxAdsAPIsOverride";


    public static final String PRIVATE_NETWORK_ACCESS_FOR_WORKERS = "PrivateNetworkAccessForWorkers";

    // If both this and `kPrivateNetworkAccessForWorkers` are enabled, then PNA
    // preflight requests for workers are not required to succeed. If one fails, a
    // warning is simply displayed in DevTools.
    public static final String PRIVATE_NETWORK_ACCESS_FOR_WORKERS_WARNING_ONLY = "PrivateNetworkAccessForWorkersWarningOnly";

    // The exact checks run are the same as for document subresources, and depend on
    // the state of other Private Network Access feature flags:
    //  - `kBlockInsecurePrivateNetworkRequests`
    //  - `kPrivateNetworkAccessSendPreflights`
    //  - `kPrivateNetworkAccessRespectPreflightResults`
    public static final String PRIVATE_NETWORK_ACCESS_FOR_IFRAMES = "PrivateNetworkAccessForIframes";

    // Requires that CORS preflight requests succeed before sending private network
    // requests. This flag implies `kPrivateNetworkAccessSendPreflights`.
    // See: https://wicg.github.io/private-network-access/#cors-preflight
    public static final String PRIVATE_NETWORK_ACCESS_RESPECT_PREFLIGHT_RESULTS = "PrivateNetworkAccessRespectPreflightResults";

    // Enables sending CORS preflight requests ahead of private network requests.
    // See: https://wicg.github.io/private-network-access/#cors-preflight
    public static final String PRIVATE_NETWORK_ACCESS_SEND_PREFLIGHTS = "PrivateNetworkAccessSendPreflights";

    // Enables origin-keyed processes by default, unless origins opt out using
    // Origin-Agent-Cluster: ?0. This feature only takes effect if the Blink feature
    // OriginAgentClusterDefaultEnable is enabled, since origin-keyed processes
    // require origin-agent-clusters.
    public static final String ORIGIN_KEYED_PROCESSES_BY_DEFAULT = "OriginKeyedProcessesByDefault";

    // Fires the `pushsubscriptionchange` event defined here:
    // https://w3c.github.io/push-api/#the-pushsubscriptionchange-event
    // for subscription refreshes, revoked permissions or subscription losses
    public static final String PUSH_SUBSCRIPTION_CHANGE_EVENT = "PushSubscriptionChangeEvent";

    // When enabled, queues navigations instead of cancelling the previous
    // navigation if the previous navigation is already waiting for commit.
    // See https://crbug.com/838348 and https://crbug.com/1220337.
    public static final String QUEUE_NAVIGATIONS_WHILE_WAITING_FOR_COMMIT = "QueueNavigationsWhileWaitingForCommit";

    // When enabled, sends SubresourceResponseStarted IPC only when the user has
    // allowed any HTTPS-related warning exceptions. From field data, (see
    // `SSL.Experimental.SubresourceResponse`), ~100% of subresource notifications
    // are not required, since allowing certificate exceptions by users is a rare
    // event. Hence, if user has never allowed any certificate or HTTP exceptions,
    // notifications are not sent to the browser. Once we start sending these
    // messages, we keep sending them until all exceptions are revoked and browser
    // restart occurs.
    public static final String REDUCE_SUBRESOURCE_RESPONSE_STARTED_IPC = "ReduceSubresourceResponseStartedIPC";

    // Enable using the RenderDocument.
    public static final String RENDER_DOCUMENT = "RenderDocument";

    // Enables retrying to obtain list of available cameras after restarting the
    // video capture service if a previous attempt failed, which could be caused
    // by a service crash.
    public static final String RETRY_GET_VIDEO_CAPTURE_DEVICE_INFOS = "RetryGetVideoCaptureDeviceInfos";

    // Reuses RenderProcessHost up to a certain threshold. This mode ignores the
    // soft process limit and behaves just like a process-per-site policy for all
    // sites, with an additional restriction that a process may only be reused while
    // the number of main frames in that process stays below a threshold.
    public static final String PROCESS_PER_SITE_UP_TO_MAIN_FRAME_THRESHOLD = "ProcessPerSiteUpToMainFrameThreshold";

    // Enables bypassing the service worker fetch handler. Unlike
    // `kServiceWorkerSkipIgnorableFetchHandler`, this feature starts the service
    // worker for subsequent requests.
    public static final String SERVICE_WORKER_BYPASS_FETCH_HANDLER = "ServiceWorkerBypassFetchHandler";

    // Enables skipping the service worker fetch handler if the fetch handler is
    // identified as ignorable.
    public static final String SERVICE_WORKER_SKIP_IGNORABLE_FETCH_HANDLER = "ServiceWorkerSkipIgnorableFetchHandler";

    // Enables ServiceWorker static routing API.
    // https://github.com/yoshisatoyanagisawa/service-worker-static-routing-api
    public static final String SERVICE_WORKER_STATIC_ROUTER = "ServiceWorkerStaticRouter";

    // Run video capture service in the Browser process as opposed to a dedicated
    // utility process
    public static final String RUN_VIDEO_CAPTURE_SERVICE_IN_BROWSER_PROCESS = "RunVideoCaptureServiceInBrowserProcess";

    // Browser-side feature flag for Secure Payment Confirmation (SPC) that also
    // controls the render side feature state. SPC is not currently available on
    // Linux or ChromeOS, as it requires platform authenticator support.
    public static final String SECURE_PAYMENT_CONFIRMATION = "SecurePaymentConfirmationBrowser";

    // Used to control whether to remove the restriction that PaymentCredential in
    // WebAuthn and secure payment confirmation method in PaymentRequest API must
    // use a user verifying platform authenticator. When enabled, this allows using
    // such devices as UbiKey on Linux, which can make development easier.
    public static final String SECURE_PAYMENT_CONFIRMATION_DEBUG = "SecurePaymentConfirmationDebug";

    // Service worker based payment apps as defined by w3c here:
    // https://w3c.github.io/webpayments-payment-apps-api/
    // TODO(rouslan): Remove this.
    public static final String SERVICE_WORKER_PAYMENT_APPS = "ServiceWorkerPaymentApps";

    // http://tc39.github.io/ecmascript_sharedmem/shmem.html
    // This feature is also enabled independently of this flag for cross-origin
    // isolated renderers.
    public static final String SHARED_ARRAY_BUFFER = "SharedArrayBuffer";

    // If enabled, SharedArrayBuffer is present and can be transferred on desktop
    // platforms. This flag is used only as a "kill switch" as we migrate towards
    // requiring 'crossOriginIsolated'.
    public static final String SHARED_ARRAY_BUFFER_ON_DESKTOP = "SharedArrayBufferOnDesktop";

    // Kill switch for creating first-party StorageKeys in
    // RenderFrameHostImpl::CalculateStorageKey for frames with extension URLs.
    public static final String SHOULD_ALLOW_FIRST_PARTY_STORAGE_KEY_OVERRIDE_FROM_EMBEDDER = "ShouldAllowFirstPartyStorageKeyOverrideFromEmbedder";

    // Origin-Signed HTTP Exchanges (for WebPackage Loading)
    // https://www.chromestatus.com/feature/5745285984681984
    public static final String SIGNED_HTTP_EXCHANGE = "SignedHTTPExchange";

    // If enabled, GetUserMedia API will only work when the concerned tab is in
    // focus
    public static final String USER_MEDIA_CAPTURE_ON_FOCUS = "UserMediaCaptureOnFocus";

    // This is intended as a kill switch for the WebOTP Service feature. To enable
    // this feature, the experimental web platform features flag should be set.
    public static final String WEB_OTP = "WebOTP";

    // Enable the web lockscreen API implementation
    // (https://github.com/WICG/lock-screen) in Chrome.
    public static final String WEB_LOCK_SCREEN_API = "WebLockScreenApi";

    // When enabled, puts subframe data: URLs in a separate SiteInstance in the same
    // SiteInstanceGroup as the initiator.
    public static final String SITE_INSTANCE_GROUPS_FOR_DATA_URLS = "SiteInstanceGroupsForDataUrls";

    // Controls whether to isolate sites of documents that specify an eligible
    // Cross-Origin-Opener-Policy header.  Note that this is only intended to be
    // used on Android, which does not use strict site isolation. See
    // https://crbug.com/1018656.
    public static final String SITE_ISOLATION_FOR_CROSS_ORIGIN_OPENER_POLICY = "SiteIsolationForCrossOriginOpenerPolicy";

    // When enabled, OOPIFs will not try to reuse compatible processes from
    // unrelated tabs.
    public static final String DISABLE_PROCESS_REUSE = "DisableProcessReuse";

    // Controls whether SpareRenderProcessHostManager tries to always have a warm
    // spare renderer process around for the most recently requested BrowserContext.
    // This feature is only consulted in site-per-process mode.
    public static final String SPARE_RENDERER_FOR_SITE_PER_PROCESS = "SpareRendererForSitePerProcess";

    // Controls whether site isolation should use origins instead of scheme and
    // eTLD+1.
    public static final String STRICT_ORIGIN_ISOLATION = "StrictOriginIsolation";

    // Disallows window.{alert, prompt, confirm} if triggered inside a subframe that
    // is not same origin with the main frame.
    public static final String SUPPRESS_DIFFERENT_ORIGIN_SUBFRAME_JS_DIALOGS = "SuppressDifferentOriginSubframeJSDialogs";

    // To disable the updated fullscreen handling of the companion Viz
    // SurfaceSyncThrottling flag. Disabling this will restore the base
    // SurfaceSyncThrottling path.
    public static final String SURFACE_SYNC_FULLSCREEN_KILLSWITCH = "SurfaceSyncFullscreenKillswitch";

    // Dispatch touch events to "SyntheticGestureController" for events from
    // Devtool Protocol Input.dispatchTouchEvent to simulate touch events close to
    // real OS events.
    public static final String SYNTHETIC_POINTER_ACTIONS = "SyntheticPointerActions";

    // This feature allows touch dragging and a context menu to occur
    // simultaneously, with the assumption that the menu is non-modal.  Without this
    // feature, a long-press touch gesture can start either a drag or a context-menu
    // in Blink, not both (more precisely, a context menu is shown only if a drag
    // cannot be started).
    public static final String TOUCH_DRAG_AND_CONTEXT_MENU = "TouchDragAndContextMenu";

    // This feature is for a reverse Origin Trial, enabling SharedArrayBuffer for
    // sites as they migrate towards requiring cross-origin isolation for these
    // features.
    // TODO(bbudge): Remove when the deprecation is complete.
    // https://developer.chrome.com/origintrials/#/view_trial/303992974847508481
    // https://crbug.com/1144104
    public static final String UNRESTRICTED_SHARED_ARRAY_BUFFER = "UnrestrictedSharedArrayBuffer";

    // Allows user activation propagation to all frames having the same origin as
    // the activation notifier frame.  This is an intermediate measure before we
    // have an iframe attribute to declaratively allow user activation propagation
    // to subframes.
    public static final String USER_ACTIVATION_SAME_ORIGIN_VISIBILITY = "UserActivationSameOriginVisibility";

    // Enables comparing browser and renderer's DidCommitProvisionalLoadParams in
    // RenderFrameHostImpl::VerifyThatBrowserAndRendererCalculatedDidCommitParamsMatch.
    public static final String VERIFY_DID_COMMIT_PARAMS = "VerifyDidCommitParams";

    // Enable the viewport segments API.
    // Tracking bug for enabling viewport segments API: https://crbug.com/1039050.
    public static final String VIEWPORT_SEGMENTS = "ViewportSegments";

    // Enables future V8 VM features
    public static final String V8_VM_FUTURE = "V8VmFuture";

    // Enable WebAssembly baseline compilation (Liftoff).
    public static final String WEB_ASSEMBLY_BASELINE = "WebAssemblyBaseline";


    public static final String ENABLE_EXPERIMENTAL_WEB_ASSEMBLY_JSPI = "WebAssemblyExperimentalJSPI";

    // Enable support for the WebAssembly Garbage Collection proposal:
    // https://github.com/WebAssembly/gc.
    public static final String WEB_ASSEMBLY_GARBAGE_COLLECTION = "WebAssemblyGarbageCollection";

    // Enable WebAssembly lazy compilation (JIT on first call).
    public static final String WEB_ASSEMBLY_LAZY_COMPILATION = "WebAssemblyLazyCompilation";

    // Enable the use of WebAssembly Relaxed SIMD operations
    public static final String WEB_ASSEMBLY_RELAXED_SIMD = "WebAssemblyRelaxedSimd";

    // Enable support for the WebAssembly Stringref proposal:
    // https://github.com/WebAssembly/stringref.
    public static final String WEB_ASSEMBLY_STRINGREF = "WebAssemblyStringref";

    // Enable WebAssembly tiering (Liftoff -> TurboFan).
    public static final String WEB_ASSEMBLY_TIERING = "WebAssemblyTiering";

    // Enable WebAssembly trap handler.
    public static final String WEB_ASSEMBLY_TRAP_HANDLER = "WebAssemblyTrapHandler";

    // Controls whether the Web Bluetooth API is enabled:
    // https://webbluetoothcg.github.io/web-bluetooth/
    public static final String WEB_BLUETOOTH = "WebBluetooth";

    // Controls whether Web Bluetooth should use the new permissions backend. The
    // new permissions backend uses ObjectPermissionContextBase, which is used by
    // other device APIs, such as WebUSB. When enabled,
    // WebBluetoothWatchAdvertisements and WebBluetoothGetDevices blink features are
    // also enabled.
    public static final String WEB_BLUETOOTH_NEW_PERMISSIONS_BACKEND = "WebBluetoothNewPermissionsBackend";

    // Enable the browser process components of the Web MIDI API. This flag does not
    // control whether the API is exposed in Blink.
    public static final String WEB_MIDI = "WebMidi";

    // Controls which backend is used to retrieve OTP on Android. When disabled
    // we use User Consent API.
    public static final String WEB_OTP_BACKEND_AUTO = "WebOtpBackendAuto";

    // The JavaScript API for payments on the web.
    public static final String WEB_PAYMENTS = "WebPayments";

    // Enables code caching for scripts used on WebUI pages.
    public static final String WEB_UI_CODE_CACHE = "WebUICodeCache";

    // Controls whether the WebUSB API is enabled:
    // https://wicg.github.io/webusb
    public static final String WEB_USB = "WebUSB";

    // Controls whether the WebXR Device API is enabled.
    public static final String WEB_XR = "WebXR";

    // Allows the use of page zoom in place of accessibility text autosizing, and
    // updated UI to replace existing Chrome Accessibility Settings.
    public static final String ACCESSIBILITY_PAGE_ZOOM = "AccessibilityPageZoom";

    // Disables use of performance improvements for experimental testing/dev.
    public static final String ACCESSIBILITY_PERFORMANCE_TESTING = "AccessibilityPerformanceTesting";

    // Allows the use of "Smart Zoom", an alternative form of page zoom, and
    // enables the associated UI.
    public static final String SMART_ZOOM = "SmartZoom";

    // Automatically disables accessibility on Android when no assistive
    // technologies are present
    public static final String AUTO_DISABLE_ACCESSIBILITY_V2 = "AutoDisableAccessibilityV2";

    // Reduce the priority of GPU process when in background so it is more likely
    // to be killed first if the OS needs more memory.
    public static final String REDUCE_GPU_PRIORITY_ON_BACKGROUND = "ReduceGpuPriorityOnBackground";

    // When enabled, shows a dropdown menu for mouse and trackpad secondary
    // clicks (i.e. right click) with respect to text selection.
    public static final String MOUSE_AND_TRACKPAD_DROPDOWN_MENU = "MouseAndTrackpadDropdownMenu";

    // Request Desktop Site secondary settings for Android; including display
    // setting and peripheral setting.
    public static final String REQUEST_DESKTOP_SITE_ADDITIONS = "RequestDesktopSiteAdditions";

    // Request Desktop Site based on window width for Android.
    public static final String REQUEST_DESKTOP_SITE_WINDOW_SETTING = "RequestDesktopSiteWindowSetting";

    // Request Desktop Site zoom for Android. Apply a pre-defined page zoom level
    // when desktop user agent is used.
    public static final String REQUEST_DESKTOP_SITE_ZOOM = "RequestDesktopSiteZoom";

    // Send background signal to GPU stack for synchronous compositor.
    public static final String SYNCHRONOUS_COMPOSITOR_BACKGROUND_SIGNAL = "SynchronousCompositorBackgroundSignal";

    // Text autosizing uses heuristics to inflate text sizes on devices with
    // small screens. This feature is for disabling these heuristics.
    public static final String FORCE_OFF_TEXT_AUTOSIZING = "ForceOffTextAutosizing";

    // Screen Capture API support for Android
    public static final String USER_MEDIA_SCREEN_CAPTURING = "UserMediaScreenCapturing";

    // Kill switch for the WebNFC feature. This feature can be enabled for all sites
    // using the kEnableExperimentalWebPlatformFeatures flag.
    // https://w3c.github.io/web-nfc/
    public static final String WEB_NFC = "WebNFC";

    // Enables backgrounding hidden renderers on Mac.
    public static final String MAC_ALLOW_BACKGROUNDING_RENDER_PROCESSES = "MacAllowBackgroundingRenderProcesses";


    public static final String MAC_SYSCALL_SANDBOX = "MacSyscallSandbox";

    // Controls whether the PipeWire support for screen capturing is enabled on the
    // Wayland display server.
    public static final String WEB_RTC_PIPE_WIRE_CAPTURER = "WebRTCPipeWireCapturer";

    // A secondary switch used in combination with kMojoVideoCapture.
    // This is intended as a kill switch to allow disabling the service on
    // particular groups of devices even if they forcibly enable kMojoVideoCapture
    // via a command-line argument.
    public static final String MOJO_VIDEO_CAPTURE_SECONDARY = "MojoVideoCaptureSecondary";

    // Do not instantiate this class.
    private ContentFeatures() {}
}
