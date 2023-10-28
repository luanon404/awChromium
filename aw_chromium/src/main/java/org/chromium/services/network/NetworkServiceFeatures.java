// Copyright 2021 The Chromium Authors
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.

package org.chromium.services.network;

/**
 * Contains features that are specific to Network Service.
 */
public final class NetworkServiceFeatures {


    // This following string constants were inserted by
    //     java_cpp_features.py
    // From
    //     ../../services/network/public/cpp/features.cc
    // Into
    //     ../../services/network/public/java/src/org/chromium/services/network/public/NetworkServiceFeatures.java.tmpl


    public static final String NETWORK_ERROR_LOGGING = "NetworkErrorLogging";


    public static final String REPORTING = "Reporting";

    // Based on the field trial parameters, this feature will override the value of
    // the maximum number of delayable requests allowed in flight. The number of
    // delayable requests allowed in flight will be based on the network's
    // effective connection type ranges and the
    // corresponding number of delayable requests in flight specified in the
    // experiment configuration. Based on field trial parameters, this experiment
    // may also throttle delayable requests based on the number of non-delayable
    // requests in-flight times a weighting factor.
    public static final String THROTTLE_DELAYABLE = "ThrottleDelayable";

    // When kPriorityRequestsDelayableOnSlowConnections is enabled, HTTP
    // requests fetched from a SPDY/QUIC/H2 proxies can be delayed by the
    // ResourceScheduler just as HTTP/1.1 resources are. However, requests from such
    // servers are not subject to kMaxNumDelayableRequestsPerHostPerClient limit.
    public static final String DELAY_REQUESTS_ON_MULTIPLEXED_CONNECTIONS = "DelayRequestsOnMultiplexedConnections";

    // When kPauseBrowserInitiatedHeavyTrafficForP2P is enabled, then a subset of
    // the browser initiated traffic may be paused if there is at least one active
    // P2P connection and the network is estimated to be congested. This feature is
    // intended to throttle only the browser initiated traffic that is expected to
    // be heavy (has large request/response sizes) when real time content might be
    // streaming over an active P2P connection.
    public static final String PAUSE_BROWSER_INITIATED_HEAVY_TRAFFIC_FOR_P2P = "PauseBrowserInitiatedHeavyTrafficForP2P";

    // When kProactivelyThrottleLowPriorityRequests is enabled,
    // resource scheduler proactively throttles low priority requests to avoid
    // network contention with high priority requests that may arrive soon.
    public static final String PROACTIVELY_THROTTLE_LOW_PRIORITY_REQUESTS = "ProactivelyThrottleLowPriorityRequests";

    // Enables Cross-Origin Opener Policy (COOP).
    // https://gist.github.com/annevk/6f2dd8c79c77123f39797f6bdac43f3e
    // https://html.spec.whatwg.org/C/#cross-origin-opener-policy
    // Currently this feature is enabled for all platforms except WebView.
    public static final String CROSS_ORIGIN_OPENER_POLICY = "CrossOriginOpenerPolicy";

    // Shift's COOP's default from `unsafe-none` to `same-origin-allow-popups`.
    // https://github.com/mikewest/coop-by-default/
    public static final String CROSS_ORIGIN_OPENER_POLICY_BY_DEFAULT = "CrossOriginOpenerPolicyByDefault";

    // Introduce a new COOP value: restrict-properties. It restricts window
    // properties that can be accessed by other pages. This also grants
    // crossOriginIsolated if coupled with an appropriate COEP header.
    // This used solely for testing the process model and should not be enabled in
    // any production code. See https://crbug.com/1221127.
    public static final String COOP_RESTRICT_PROPERTIES = "CoopRestrictProperties";

    // Enables the origin trial for COOP: restrict-properties. We need a new feature
    // because token validation is not possible in the network process. This also
    // allows us to keep using CoopRestrictProperties to enable COOP: RP for WPTs.
    public static final String COOP_RESTRICT_PROPERTIES_ORIGIN_TRIAL = "CoopRestrictPropertiesOriginTrial";

    // Enables or defaults splittup up server (not proxy) entries in the
    // HttpAuthCache.
    public static final String SPLIT_AUTH_CACHE_BY_NETWORK_ISOLATION_KEY = "SplitAuthCacheByNetworkIsolationKey";

    // Enable usage of hardcoded DoH upgrade mapping for use in automatic mode.
    public static final String DNS_OVER_HTTPS_UPGRADE = "DnsOverHttpsUpgrade";

    // When enabled, the requests in a third party context to domains included in
    // the Masked Domain List Component will use the Privacy Proxy to shield the
    // client's IP.
    public static final String MASKED_DOMAIN_LIST = "MaskedDomainList";

    // If this feature is enabled, the mDNS responder service responds to queries
    // for TXT records associated with
    // "Generated-Names._mdns_name_generator._udp.local" with a list of generated
    // mDNS names (random UUIDs) in the TXT record data.
    public static final String MDNS_RESPONDER_GENERATED_NAME_LISTING = "MdnsResponderGeneratedNameListing";

    // Enables ORB blocked responses being treated as errors (according to the spec)
    // rather than the current, CORB-style handling of injecting an empty response.
    // This exempts fetches initiated by scripts. (Technically, fetches with an
    // empty destination.)
    // This is ORB v0.2.
    // Implementing ORB in Chromium is tracked in https://crbug.com/1178928
    public static final String OPAQUE_RESPONSE_BLOCKING_V02 = "OpaqueResponseBlockingV02";

    // Treat ORB blocked responses to script-initiated fetches as errors too.
    // Complements ORB v0.2, which exempts script-initiated fetches.
    // Implementing ORB in Chromium is tracked in https://crbug.com/1178928
    public static final String OPAQUE_RESPONSE_BLOCKING_ERRORS_FOR_ALL_FETCHES = "OpaqueResponseBlockingErrorsForAllFetches";

    // Enables preprocessing the Attribution API's trigger registration ping
    // requests, potentially adding verification headers, and handling their
    // responses. (See
    // https://github.com/WICG/attribution-reporting-api/blob/main/report_verification.md)
    public static final String ATTRIBUTION_REPORTING_REPORT_VERIFICATION = "AttributionReportingReportVerification";

    // Gate access to Attribution Reporting cross app and web APIs that allow
    // registering with a native attribution API.
    public static final String ATTRIBUTION_REPORTING_CROSS_APP_WEB = "AttributionReportingCrossAppWeb";

    // Enables preprocessing requests with the Private State Tokens API Fetch flags
    // set, and handling their responses, according to the protocol.
    // (See https://github.com/WICG/trust-token-api.)
    public static final String PRIVATE_STATE_TOKENS = "PrivateStateTokens";

    // Secondary flag used by the FLEDGE ads experiment in the interim before
    // PSTs are fully rolled out to stable.
    public static final String FLEDGE_PST = "TrustTokens";


    public static final String WEB_SOCKET_REASSEMBLE_SHORT_MESSAGES = "WebSocketReassembleShortMessages";

    // Enable support for ACCEPT_CH H2/3 frame as part of Client Hint Reliability.
    // See:
    // https://tools.ietf.org/html/draft-davidben-http-client-hint-reliability-02#section-4.3
    public static final String ACCEPT_CH_FRAME = "AcceptCHFrame";

    // Enable
    public static final String GET_COOKIES_STRING_UMA = "GetCookiesStringUma";


    public static final String DEFAULT_DATA_PIPE_ALLOCATION_SIZE_FEATURE = "DefaultDataPipeAllocationSizeFeature";


    public static final String LARGER_DATA_PIPE_ALLOCATION_SIZE_FEATURE = "LargerDataPipeAllocationSizeFeature";


    public static final String NET_ADAPTER_MAX_BUF_SIZE_FEATURE = "NetAdapterMaxBufSizeFeature";


    public static final String MAX_NUM_CONSUMED_BYTES_IN_TASK_FEATURE = "MaxNumConsumedBytesInTaskFeature";

    // https://fetch.spec.whatwg.org/#cors-non-wildcard-request-header-name
    public static final String CORS_NON_WILDCARD_REQUEST_HEADERS_SUPPORT = "CorsNonWildcardRequestHeadersSupport";


    public static final String NETWORK_SERVICE_MEMORY_CACHE = "NetworkServiceMemoryCache";

    // Do not send TLS client certificates in CORS preflight. Omit all client certs
    // and continue the handshake without sending one if requested.
    public static final String OMIT_CORS_CLIENT_CERT = "OmitCorsClientCert";

    // Allow pervasive payloads to use a single-keyed cache.
    public static final String CACHE_TRANSPARENCY = "CacheTransparency";

    // Load Pervasive Payloads List for Cache Transparency.
    public static final String PERVASIVE_PAYLOADS_LIST = "PervasivePayloadsList";

    // Enables support for the `Variants` response header and reduce
    // accept-language. https://github.com/Tanych/accept-language
    public static final String REDUCE_ACCEPT_LANGUAGE = "ReduceAcceptLanguage";

    // Gate access to ReduceAcceptLanguage origin trial major code. Currently, All
    // ReduceAcceptLanguage feature codes are guarded by the feature flag
    // kReduceAcceptLanguage. This feature flag is useful on control major code
    // which required to do origin trial. It allows Chrome developers to mitigate
    // issues when exposed codes cause impacts.
    public static final String REDUCE_ACCEPT_LANGUAGE_ORIGIN_TRIAL = "ReduceAcceptLanguageOriginTrial";

    // Reduce PNA preflight response waiting time to 200ms.
    // See: https://wicg.github.io/private-network-access/#cors-preflight
    public static final String PRIVATE_NETWORK_ACCESS_PREFLIGHT_SHORT_TIMEOUT = "PrivateNetworkAccessPreflightShortTimeout";

    // Allow potentially trustworthy same origin local network requests without
    // preflights.
    public static final String LOCAL_NETWORK_ACCESS_ALLOW_POTENTIALLY_TRUSTWORTHY_SAME_ORIGIN = "LocalNetworkAccessAllowPotentiallyTrustworthySameOrigin";

    // When kPrivateNetworkAccessPermissionPrompt is enabled, public secure websites
    // are allowed to access private insecure subresources with user's permission.
    public static final String PRIVATE_NETWORK_ACCESS_PERMISSION_PROMPT = "PrivateNetworkAccessPermissionPrompt";


    public static final String ACCESS_CONTROL_ALLOW_METHODS_IN_CORS_PREFLIGHT_SPEC_CONFORMANT = "AccessControlAllowMethodsInCORSPreflightSpecConformant";


    public static final String PREFETCH_NO_VARY_SEARCH = "PrefetchNoVarySearch";

    // Enables the backend of the compression dictionary transport feature.
    // When this feature is enabled, the following will happen:
    //   * The network service loads the metadata database.
    //   * If there is a matching dictionary for a sending request, it adds the
    //     `sec-available-dictionary` header.
    //   * And if the `content-encoding` header of the response is `sbr`, it
    //     decompresses the response body using the dictionary.
    public static final String COMPRESSION_DICTIONARY_TRANSPORT_BACKEND = "CompressionDictionaryTransportBackend";

    // When both this feature and the kCompressionDictionaryTransportBackend feature
    // are enabled, the following will happen:
    //   * A <link rel=dictionary> HTML tag and a `Link: rel=dictionary` HTTP header
    //     will trigger dictionary download.
    //   * HTMLLinkElement.relList.supports('dictionary') will return true.
    //   * The network service may register a HTTP response as a dictionary if the
    //     response header contains a `use-as-dictionary` header.
    // This feature can be enabled by an Origin Trial token in Blink. To propagate
    // the enabled state to the network service, Blink sets the
    // `shared_dictionary_writer_enabled` flag in resource requests.
    public static final String COMPRESSION_DICTIONARY_TRANSPORT = "CompressionDictionaryTransport";


    public static final String VISIBILITY_AWARE_RESOURCE_SCHEDULER = "VisibilityAwareResourceScheduler";


    public static final String SHARED_ZSTD = "SharedZstd";

    // This feature will permits de-duplicating cookie access details that are sent
    // to observers via OnCookiesAccessed.
    public static final String COOKIE_ACCESS_DETAILS_NOTIFICATION_DE_DUPING = "CookieAccessDetailsNotificationDeDuping";

    // Do not instantiate this class.
    private NetworkServiceFeatures() {}
}
