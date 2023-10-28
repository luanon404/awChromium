// Copyright 2022 The Chromium Authors
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.

package org.chromium.net;

/**
 * Constants for the names of Net Features.
 */
public final class NetFeatures {


    // This following string constants were inserted by
    //     java_cpp_features.py
    // From
    //     ../../net/base/features.cc
    // Into
    //     ../../net/base/android/java_templates/NetFeatures.java.tmpl


    public static final String ALPS_FOR_HTTP2 = "AlpsForHttp2";


    public static final String AVOID_H2_REPRIORITIZATION = "AvoidH2Reprioritization";


    public static final String CAP_REFERRER_TO_ORIGIN_ON_CROSS_ORIGIN = "CapReferrerToOriginOnCrossOrigin";


    public static final String DNS_TRANSACTION_DYNAMIC_TIMEOUTS = "DnsTransactionDynamicTimeouts";


    public static final String USE_DNS_HTTPS_SVCB = "UseDnsHttpsSvcb";


    public static final String USE_DNS_HTTPS_SVCB_ALPN = "UseDnsHttpsSvcbAlpn";


    public static final String USE_ALTERNATIVE_PORT_FOR_GLOBALLY_REACHABLE_CHECK = "UseAlternativePortForGloballyReachableCheck";


    public static final String ENABLE_I_PV6_REACHABILITY_OVERRIDE = "EnableIPv6ReachabilityOverride";


    public static final String SHA1_SERVER_SIGNATURE = "SHA1ServerSignature";


    public static final String ENABLE_TLS13_EARLY_DATA = "EnableTLS13EarlyData";


    public static final String ENCRYPTED_CLIENT_HELLO = "EncryptedClientHello";


    public static final String ENCRYPTED_CLIENT_HELLO_QUIC = "EncryptedClientHelloQuic";

    // TODO(crbug.com/795089): Enable this feature.
    public static final String RSA_KEY_USAGE_FOR_LOCAL_ANCHORS = "RSAKeyUsageForLocalAnchors";


    public static final String NETWORK_QUALITY_ESTIMATOR = "NetworkQualityEstimator";


    public static final String SPLIT_CACHE_BY_INCLUDE_CREDENTIALS = "SplitCacheByIncludeCredentials";


    public static final String SPLIT_CACHE_BY_NETWORK_ISOLATION_KEY = "SplitCacheByNetworkIsolationKey";


    public static final String SPLIT_CODE_CACHE_BY_NETWORK_ISOLATION_KEY = "SplitCodeCacheByNetworkIsolationKey";


    public static final String SPLIT_HOST_CACHE_BY_NETWORK_ISOLATION_KEY = "SplitHostCacheByNetworkIsolationKey";


    public static final String PARTITION_CONNECTIONS_BY_NETWORK_ISOLATION_KEY = "PartitionConnectionsByNetworkIsolationKey";


    public static final String PARTITION_HTTP_SERVER_PROPERTIES_BY_NETWORK_ISOLATION_KEY = "PartitionHttpServerPropertiesByNetworkIsolationKey";


    public static final String PARTITION_SSL_SESSIONS_BY_NETWORK_ISOLATION_KEY = "PartitionSSLSessionsByNetworkIsolationKey";


    public static final String PARTITION_NEL_AND_REPORTING_BY_NETWORK_ISOLATION_KEY = "PartitionNelAndReportingByNetworkIsolationKey";


    public static final String ENABLE_CROSS_SITE_FLAG_NETWORK_ISOLATION_KEY = "EnableCrossSiteFlagNetworkIsolationKey";


    public static final String ENABLE_FRAME_SITE_SHARED_OPAQUE_NETWORK_ISOLATION_KEY = "EnableFrameSiteSharedOpaqueNetworkIsolationKey";


    public static final String HTTP_CACHE_KEYING_EXPERIMENT_CONTROL_GROUP = "HttpCacheKeyingExperimentControlGroup";


    public static final String TLS13_KEY_UPDATE = "TLS13KeyUpdate";


    public static final String PERMUTE_TLS_EXTENSIONS = "PermuteTLSExtensions";


    public static final String POST_QUANTUM_KYBER = "PostQuantumKyber";


    public static final String NET_UNUSED_IDLE_SOCKET_TIMEOUT = "NetUnusedIdleSocketTimeout";


    public static final String SHORT_LAX_ALLOW_UNSAFE_THRESHOLD = "ShortLaxAllowUnsafeThreshold";


    public static final String SAME_SITE_DEFAULT_CHECKS_METHOD_RIGOROUSLY = "SameSiteDefaultChecksMethodRigorously";


    public static final String CHROME_ROOT_STORE_USED = "ChromeRootStoreUsed";


    public static final String TRUST_STORE_TRUSTED_LEAF_SUPPORT = "TrustStoreTrustedLeafSupport";


    public static final String TURN_OFF_STREAMING_MEDIA_CACHING_ON_BATTERY = "TurnOffStreamingMediaCachingOnBattery";


    public static final String TURN_OFF_STREAMING_MEDIA_CACHING_ALWAYS = "TurnOffStreamingMediaCachingAlways";


    public static final String SCHEMEFUL_SAME_SITE = "SchemefulSameSite";


    public static final String LIMIT_OPEN_UDP_SOCKETS = "LimitOpenUDPSockets";


    public static final String TIMEOUT_TCP_CONNECT_ATTEMPT = "TimeoutTcpConnectAttempt";


    public static final String DOCUMENT_REPORTING = "DocumentReporting";


    public static final String UDP_SOCKET_POSIX_ALWAYS_UPDATE_BYTES_RECEIVED = "UdpSocketPosixAlwaysUpdateBytesReceived";


    public static final String COOKIE_SAME_SITE_CONSIDERS_REDIRECT_CHAIN = "CookieSameSiteConsidersRedirectChain";


    public static final String WAIT_FOR_FIRST_PARTY_SETS_INIT = "WaitForFirstPartySetsInit";


    public static final String PARTITIONED_COOKIES = "PartitionedCookies";


    public static final String BLOCK_TRUNCATED_COOKIES = "BlockTruncatedCookies";


    public static final String STATIC_KEY_PINNING_ENFORCEMENT = "StaticKeyPinningEnforcement";


    public static final String COOKIE_DOMAIN_REJECT_NON_ASCII = "CookieDomainRejectNonASCII";

    // Enables partitioning of third party storage (IndexedDB, CacheStorage, etc.)
    // by the top level site to reduce fingerprinting.
    public static final String THIRD_PARTY_STORAGE_PARTITIONING = "ThirdPartyStoragePartitioning";

    // Whether to use the new code paths needed to support partitioning Blob URLs.
    // This exists as a kill-switch in case an issue is identified with the Blob
    // URL implementation that causes breakage.
    public static final String SUPPORT_PARTITIONED_BLOB_URL = "SupportPartitionedBlobUrl";


    public static final String TPCD_SUPPORT_SETTINGS = "TpcdSupportSettings";


    public static final String TPCD_METADATA_GRANTS = "TpcdMetadataGrants";


    public static final String ALPS_PARSING = "AlpsParsing";


    public static final String ALPS_CLIENT_HINT_PARSING = "AlpsClientHintParsing";


    public static final String SHOULD_KILL_SESSION_ON_ACCEPT_CH_MALFORMED = "ShouldKillSessionOnAcceptChMalformed";


    public static final String CASE_INSENSITIVE_COOKIE_PREFIX = "CaseInsensitiveCookiePrefix";


    public static final String ENABLE_WEBSOCKETS_OVER_HTTP3 = "EnableWebsocketsOverHttp3";


    public static final String USE_NAT64_FOR_I_PV4_LITERAL = "UseNAT64ForIPv4Literal";


    public static final String BLOCK_NEW_FORBIDDEN_HEADERS = "BlockNewForbiddenHeaders";


    public static final String PLATFORM_KEY_PROBE_SHA256 = "PlatformKeyProbeSHA256";

    // Disabled because of https://crbug.com/1489696.
    public static final String ENABLE_GET_NETWORK_CONNECTIVITY_HINT_API = "EnableGetNetworkConnectivityHintAPI";

    // Prefetch to follow normal semantics instead of 5-minute rule
    // https://crbug.com/1345207
    public static final String PREFETCH_FOLLOWS_NORMAL_CACHE_SEMANTICS = "PrefetchFollowsNormalCacheSemantics";


    public static final String KERBEROS_IN_BROWSER_REDIRECT = "KerberosInBrowserRedirect";

    // A flag to use asynchronous session creation for new QUIC sessions.
    public static final String ASYNC_QUIC_SESSION = "AsyncQuicSession";

    // A flag to make multiport context creation asynchronous.
    public static final String ASYNC_MULTI_PORT_PATH = "AsyncMultiPortPath";

    // IP protection experiment configuration settings
    public static final String ENABLE_IP_PROTECTION_PROXY = "EnableIpPrivacyProxy";


    public static final String MIGRATE_SESSIONS_ON_NETWORK_CHANGE_V2 = "MigrateSessionsOnNetworkChangeV2";


    public static final String DISABLE_BLACKHOLE_ON_NO_NEW_NETWORK = "DisableBlackHoleOnNoNewNetwork";


    public static final String ADDRESS_TRACKER_LINUX_IS_PROXIED = "AddressTrackerLinuxIsProxied";

    // Enables binding of cookies to the port that originally set them by default.
    public static final String ENABLE_PORT_BOUND_COOKIES = "EnablePortBoundCookies";


    public static final String ENABLE_SCHEME_BOUND_COOKIES = "EnableSchemeBoundCookies";

    // Enable third-party cookie blocking from the command line.
    public static final String FORCE_THIRD_PARTY_COOKIE_BLOCKING = "ForceThirdPartyCookieBlockingEnabled";


    public static final String ENABLE_EARLY_HINTS_ON_HTTP11 = "EnableEarlyHintsOnHttp11";


    public static final String ENABLE_WEB_TRANSPORT_DRAFT07 = "EnableWebTransportDraft07";


    public static final String ZSTD_CONTENT_ENCODING = "ZstdContentEncoding";


    public static final String DIGEST_AUTH_ENABLE_SECURE_ALGORITHMS = "DigestAuthEnableSecureAlgorithms";

    // When enabled, partitioned storage will be allowed even if third-party cookies
    // are disabled by default. Partitioned storage will not be allowed if
    // third-party cookies are disabled due to a specific rule.
    public static final String THIRD_PARTY_PARTITIONED_STORAGE_ALLOWED_BY_DEFAULT = "ThirdPartyPartitionedStorageAllowedByDefault";


    public static final String PRIORITY_HEADER = "PriorityHeader";


    public static final String SPDY_HEADERS_TO_HTTP_RESPONSE_USE_BUILDER = "SpdyHeadersToHttpResponseUseBuilder";


    public static final String SPDY_HEADERS_TO_HTTP_RESPONSE_VERIFY_CORRECTNESS = "SpdyHeadersToHttpResponseVerifyCorrectness";


    public static final String RECEIVE_ECN = "ReceiveEcn";

    // Do not instantiate this class.
    private NetFeatures() {}
}
