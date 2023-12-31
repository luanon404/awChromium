// NetworkContext.java is auto generated by mojom_bindings_generator.py, do not edit


// Copyright 2014 The Chromium Authors
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.

// This file is autogenerated by:
//     mojo/public/tools/bindings/mojom_bindings_generator.py
// For:
//     services/network/public/mojom/network_context.mojom
//

package org.chromium.network.mojom;

import androidx.annotation.IntDef;


public interface NetworkContext extends org.chromium.mojo.bindings.Interface {



    public static final class DomainReliabilityClearMode {
        private static final boolean IS_EXTENSIBLE = false;
        @IntDef({

            DomainReliabilityClearMode.CLEAR_CONTEXTS,
            DomainReliabilityClearMode.CLEAR_BEACONS})
        public @interface EnumType {}

        public static final int CLEAR_CONTEXTS = 0;
        public static final int CLEAR_BEACONS = 1;
        public static final int MIN_VALUE = 0;
        public static final int MAX_VALUE = 1;

        public static boolean isKnownValue(int value) {
            return value >= 0 && value <= 1;
        }

        public static void validate(int value) {
            if (IS_EXTENSIBLE || isKnownValue(value)) return;
            throw new org.chromium.mojo.bindings.DeserializationException("Invalid enum value.");
        }

        public static int toKnownValue(int value) {
          return value;
        }

        private DomainReliabilityClearMode() {}
    }


    public interface Proxy extends NetworkContext, org.chromium.mojo.bindings.Interface.Proxy {
    }

    Manager<NetworkContext, NetworkContext.Proxy> MANAGER = NetworkContext_Internal.MANAGER;

    void setClient(
NetworkContextClient client);


    void createUrlLoaderFactory(
org.chromium.mojo.bindings.InterfaceRequest<UrlLoaderFactory> urlLoaderFactory, UrlLoaderFactoryParams params);


    void resetUrlLoaderFactories(
);


    void getViaObliviousHttp(
ObliviousHttpRequest request, ObliviousHttpClient client);


    void getCookieManager(
org.chromium.mojo.bindings.InterfaceRequest<CookieManager> cookieManager);


    void getRestrictedCookieManager(
org.chromium.mojo.bindings.InterfaceRequest<RestrictedCookieManager> restrictedCookieManager, int role, org.chromium.url.internal.mojom.Origin origin, IsolationInfo isolationInfo, CookieSettingOverrides cookieSettingOverrides, CookieAccessObserver cookieObserver);


    void getTrustTokenQueryAnswerer(
org.chromium.mojo.bindings.InterfaceRequest<TrustTokenQueryAnswerer> trustTokenQueryAnswerer, org.chromium.url.internal.mojom.Origin topFrameOrigin);


    void clearTrustTokenData(
ClearDataFilter filter, 
ClearTrustTokenData_Response callback);

    interface ClearTrustTokenData_Response extends org.chromium.mojo.bindings.Callbacks.Callback0 { }


    void clearTrustTokenSessionOnlyData(

ClearTrustTokenSessionOnlyData_Response callback);

    interface ClearTrustTokenSessionOnlyData_Response extends org.chromium.mojo.bindings.Callbacks.Callback1<Boolean> { }


    void getStoredTrustTokenCounts(

GetStoredTrustTokenCounts_Response callback);

    interface GetStoredTrustTokenCounts_Response extends org.chromium.mojo.bindings.Callbacks.Callback1<StoredTrustTokensForIssuer[]> { }


    void deleteStoredTrustTokens(
org.chromium.url.internal.mojom.Origin issuer, 
DeleteStoredTrustTokens_Response callback);

    interface DeleteStoredTrustTokens_Response extends org.chromium.mojo.bindings.Callbacks.Callback1<Integer> { }


    void setBlockTrustTokens(
boolean block);


    void clearNetworkingHistoryBetween(
org.chromium.mojo_base.mojom.Time startTime, org.chromium.mojo_base.mojom.Time endTime, 
ClearNetworkingHistoryBetween_Response callback);

    interface ClearNetworkingHistoryBetween_Response extends org.chromium.mojo.bindings.Callbacks.Callback0 { }


    void clearHttpCache(
org.chromium.mojo_base.mojom.Time startTime, org.chromium.mojo_base.mojom.Time endTime, ClearDataFilter filter, 
ClearHttpCache_Response callback);

    interface ClearHttpCache_Response extends org.chromium.mojo.bindings.Callbacks.Callback0 { }


    void computeHttpCacheSize(
org.chromium.mojo_base.mojom.Time startTime, org.chromium.mojo_base.mojom.Time endTime, 
ComputeHttpCacheSize_Response callback);

    interface ComputeHttpCacheSize_Response extends org.chromium.mojo.bindings.Callbacks.Callback2<Boolean, Long> { }


    void notifyExternalCacheHit(
org.chromium.url.mojom.Url url, String httpMethod, NetworkIsolationKey key, boolean isSubframeDocumentResource, boolean includeCredentials);


    void clearHostCache(
ClearDataFilter filter, 
ClearHostCache_Response callback);

    interface ClearHostCache_Response extends org.chromium.mojo.bindings.Callbacks.Callback0 { }


    void clearHttpAuthCache(
org.chromium.mojo_base.mojom.Time startTime, org.chromium.mojo_base.mojom.Time endTime, ClearDataFilter filter, 
ClearHttpAuthCache_Response callback);

    interface ClearHttpAuthCache_Response extends org.chromium.mojo.bindings.Callbacks.Callback0 { }


    void clearCorsPreflightCache(
ClearDataFilter filter, 
ClearCorsPreflightCache_Response callback);

    interface ClearCorsPreflightCache_Response extends org.chromium.mojo.bindings.Callbacks.Callback0 { }


    void clearReportingCacheReports(
ClearDataFilter filter, 
ClearReportingCacheReports_Response callback);

    interface ClearReportingCacheReports_Response extends org.chromium.mojo.bindings.Callbacks.Callback0 { }


    void clearReportingCacheClients(
ClearDataFilter filter, 
ClearReportingCacheClients_Response callback);

    interface ClearReportingCacheClients_Response extends org.chromium.mojo.bindings.Callbacks.Callback0 { }


    void clearNetworkErrorLogging(
ClearDataFilter filter, 
ClearNetworkErrorLogging_Response callback);

    interface ClearNetworkErrorLogging_Response extends org.chromium.mojo.bindings.Callbacks.Callback0 { }


    void clearDomainReliability(
ClearDataFilter filter, int mode, 
ClearDomainReliability_Response callback);

    interface ClearDomainReliability_Response extends org.chromium.mojo.bindings.Callbacks.Callback0 { }


    void clearSharedDictionaryCache(
org.chromium.mojo_base.mojom.Time startTime, org.chromium.mojo_base.mojom.Time endTime, ClearDataFilter filter, 
ClearSharedDictionaryCache_Response callback);

    interface ClearSharedDictionaryCache_Response extends org.chromium.mojo.bindings.Callbacks.Callback0 { }


    void clearSharedDictionaryCacheForIsolationKey(
SharedDictionaryIsolationKey isolationKey, 
ClearSharedDictionaryCacheForIsolationKey_Response callback);

    interface ClearSharedDictionaryCacheForIsolationKey_Response extends org.chromium.mojo.bindings.Callbacks.Callback0 { }


    void setDocumentReportingEndpoints(
org.chromium.mojo_base.mojom.UnguessableToken reportingSource, org.chromium.url.internal.mojom.Origin origin, IsolationInfo isolationInfo, java.util.Map<String, String> endpoints);


    void sendReportsAndRemoveSource(
org.chromium.mojo_base.mojom.UnguessableToken reportingSource);


    void queueReport(
String type, String group, org.chromium.url.mojom.Url url, org.chromium.mojo_base.mojom.UnguessableToken reportingSource, NetworkAnonymizationKey networkAnonymizationKey, String userAgent, org.chromium.mojo_base.mojom.DictionaryValue body);


    void queueSignedExchangeReport(
SignedExchangeReport report, NetworkAnonymizationKey networkAnonymizationKey);


    void closeAllConnections(

CloseAllConnections_Response callback);

    interface CloseAllConnections_Response extends org.chromium.mojo.bindings.Callbacks.Callback0 { }


    void closeIdleConnections(

CloseIdleConnections_Response callback);

    interface CloseIdleConnections_Response extends org.chromium.mojo.bindings.Callbacks.Callback0 { }


    void setNetworkConditions(
org.chromium.mojo_base.mojom.UnguessableToken throttlingProfileId, NetworkConditions conditions);


    void setAcceptLanguage(
String newAcceptLanguage);


    void setEnableReferrers(
boolean enableReferrers);


    void setCtPolicy(
CtPolicy ctPolicy);


    void createUdpSocket(
org.chromium.mojo.bindings.InterfaceRequest<UdpSocket> receiver, UdpSocketListener listener);


    void createRestrictedUdpSocket(
IpEndPoint addr, int mode, MutableNetworkTrafficAnnotationTag trafficAnnotation, RestrictedUdpSocketParams params, org.chromium.mojo.bindings.InterfaceRequest<RestrictedUdpSocket> receiver, UdpSocketListener listener, 
CreateRestrictedUdpSocket_Response callback);

    interface CreateRestrictedUdpSocket_Response extends org.chromium.mojo.bindings.Callbacks.Callback2<Integer, IpEndPoint> { }


    void createTcpServerSocket(
IpEndPoint localAddr, TcpServerSocketOptions options, MutableNetworkTrafficAnnotationTag trafficAnnotation, org.chromium.mojo.bindings.InterfaceRequest<TcpServerSocket> socket, 
CreateTcpServerSocket_Response callback);

    interface CreateTcpServerSocket_Response extends org.chromium.mojo.bindings.Callbacks.Callback2<Integer, IpEndPoint> { }


    void createTcpConnectedSocket(
IpEndPoint localAddr, AddressList remoteAddrList, TcpConnectedSocketOptions tcpConnectedSocketOptions, MutableNetworkTrafficAnnotationTag trafficAnnotation, org.chromium.mojo.bindings.InterfaceRequest<TcpConnectedSocket> socket, SocketObserver observer, 
CreateTcpConnectedSocket_Response callback);

    interface CreateTcpConnectedSocket_Response extends org.chromium.mojo.bindings.Callbacks.Callback5<Integer, IpEndPoint, IpEndPoint, org.chromium.mojo.system.DataPipe.ConsumerHandle, org.chromium.mojo.system.DataPipe.ProducerHandle> { }


    void createTcpBoundSocket(
IpEndPoint localAddr, MutableNetworkTrafficAnnotationTag trafficAnnotation, org.chromium.mojo.bindings.InterfaceRequest<TcpBoundSocket> socket, 
CreateTcpBoundSocket_Response callback);

    interface CreateTcpBoundSocket_Response extends org.chromium.mojo.bindings.Callbacks.Callback2<Integer, IpEndPoint> { }


    void createProxyResolvingSocketFactory(
org.chromium.mojo.bindings.InterfaceRequest<ProxyResolvingSocketFactory> factory);


    void lookUpProxyForUrl(
org.chromium.url.mojom.Url url, NetworkAnonymizationKey networkAnonymizationKey, ProxyLookupClient proxyLookupClient);


    void forceReloadProxyConfig(

ForceReloadProxyConfig_Response callback);

    interface ForceReloadProxyConfig_Response extends org.chromium.mojo.bindings.Callbacks.Callback0 { }


    void clearBadProxiesCache(

ClearBadProxiesCache_Response callback);

    interface ClearBadProxiesCache_Response extends org.chromium.mojo.bindings.Callbacks.Callback0 { }


    void createWebSocket(
org.chromium.url.mojom.Url url, String[] requestedProtocols, SiteForCookies siteForCookies, IsolationInfo isolationInfo, HttpHeader[] additionalHeaders, int processId, org.chromium.url.internal.mojom.Origin origin, int options, MutableNetworkTrafficAnnotationTag trafficAnnotation, WebSocketHandshakeClient handshakeClient, UrlLoaderNetworkServiceObserver urlLoaderNetworkObserver, WebSocketAuthenticationHandler authHandler, TrustedHeaderClient headerClient, org.chromium.mojo_base.mojom.UnguessableToken throttlingProfileId);


    void createWebTransport(
org.chromium.url.mojom.Url url, org.chromium.url.internal.mojom.Origin origin, NetworkAnonymizationKey networkAnonymizationKey, WebTransportCertificateFingerprint[] fingerprints, WebTransportHandshakeClient handshakeClient);


    void createNetLogExporter(
org.chromium.mojo.bindings.InterfaceRequest<NetLogExporter> receiver);


    void preconnectSockets(
int numStreams, org.chromium.url.mojom.Url url, boolean allowCredentials, NetworkAnonymizationKey networkAnonymizationKey);


    void createP2pSocketManager(
NetworkAnonymizationKey networkAnonymizationKey, P2pTrustedSocketManagerClient client, org.chromium.mojo.bindings.InterfaceRequest<P2pTrustedSocketManager> trustedSocketManager, org.chromium.mojo.bindings.InterfaceRequest<P2pSocketManager> socketManager);


    void createMdnsResponder(
org.chromium.mojo.bindings.InterfaceRequest<MdnsResponder> responderReceiver);


    void resolveHost(
HostResolverHost host, NetworkAnonymizationKey networkAnonymizationKey, ResolveHostParameters optionalParameters, ResolveHostClient responseClient);


    void createHostResolver(
DnsConfigOverrides configOverrides, org.chromium.mojo.bindings.InterfaceRequest<HostResolver> hostResolver);


    void verifyCertForSignedExchange(
X509Certificate certificate, org.chromium.url.mojom.Url url, NetworkAnonymizationKey networkAnonymizationKey, String ocspResponse, String sctList, 
VerifyCertForSignedExchange_Response callback);

    interface VerifyCertForSignedExchange_Response extends org.chromium.mojo.bindings.Callbacks.Callback4<Integer, CertVerifyResult, Boolean, String> { }


    void verifyIpProtectionConfigGetterForTesting(

VerifyIpProtectionConfigGetterForTesting_Response callback);

    interface VerifyIpProtectionConfigGetterForTesting_Response extends org.chromium.mojo.bindings.Callbacks.Callback2<BlindSignedAuthToken, org.chromium.mojo_base.mojom.Time> { }


    void invalidateIpProtectionConfigCacheTryAgainAfterTime(
);


    void addHsts(
String host, org.chromium.mojo_base.mojom.Time expiry, boolean includeSubdomains, 
AddHsts_Response callback);

    interface AddHsts_Response extends org.chromium.mojo.bindings.Callbacks.Callback0 { }


    void isHstsActiveForHost(
String host, 
IsHstsActiveForHost_Response callback);

    interface IsHstsActiveForHost_Response extends org.chromium.mojo.bindings.Callbacks.Callback1<Boolean> { }


    void getHstsState(
String domain, 
GetHstsState_Response callback);

    interface GetHstsState_Response extends org.chromium.mojo.bindings.Callbacks.Callback1<org.chromium.mojo_base.mojom.DictionaryValue> { }


    void setCorsOriginAccessListsForOrigin(
org.chromium.url.internal.mojom.Origin sourceOrigin, CorsOriginPattern[] allowPatterns, CorsOriginPattern[] blockPatterns, 
SetCorsOriginAccessListsForOrigin_Response callback);

    interface SetCorsOriginAccessListsForOrigin_Response extends org.chromium.mojo.bindings.Callbacks.Callback0 { }


    void deleteDynamicDataForHost(
String host, 
DeleteDynamicDataForHost_Response callback);

    interface DeleteDynamicDataForHost_Response extends org.chromium.mojo.bindings.Callbacks.Callback1<Boolean> { }


    void setSplitAuthCacheByNetworkAnonymizationKey(
boolean splitAuthCacheByNetworkAnonymizationKey);


    void saveHttpAuthCacheProxyEntries(

SaveHttpAuthCacheProxyEntries_Response callback);

    interface SaveHttpAuthCacheProxyEntries_Response extends org.chromium.mojo.bindings.Callbacks.Callback1<org.chromium.mojo_base.mojom.UnguessableToken> { }


    void loadHttpAuthCacheProxyEntries(
org.chromium.mojo_base.mojom.UnguessableToken cacheKey, 
LoadHttpAuthCacheProxyEntries_Response callback);

    interface LoadHttpAuthCacheProxyEntries_Response extends org.chromium.mojo.bindings.Callbacks.Callback0 { }


    void addAuthCacheEntry(
AuthChallengeInfo challenge, NetworkAnonymizationKey networkAnonymizationKey, AuthCredentials credentials, 
AddAuthCacheEntry_Response callback);

    interface AddAuthCacheEntry_Response extends org.chromium.mojo.bindings.Callbacks.Callback0 { }


    void setCorsNonWildcardRequestHeadersSupport(
boolean value);


    void lookupServerBasicAuthCredentials(
org.chromium.url.mojom.Url url, NetworkAnonymizationKey networkAnonymizationKey, 
LookupServerBasicAuthCredentials_Response callback);

    interface LookupServerBasicAuthCredentials_Response extends org.chromium.mojo.bindings.Callbacks.Callback1<AuthCredentials> { }


    void enableStaticKeyPinningForTesting(

EnableStaticKeyPinningForTesting_Response callback);

    interface EnableStaticKeyPinningForTesting_Response extends org.chromium.mojo.bindings.Callbacks.Callback0 { }


    void verifyCertificateForTesting(
X509Certificate certificate, String hostname, String ocspResponse, String sctList, 
VerifyCertificateForTesting_Response callback);

    interface VerifyCertificateForTesting_Response extends org.chromium.mojo.bindings.Callbacks.Callback1<Integer> { }


    void addDomainReliabilityContextForTesting(
org.chromium.url.internal.mojom.Origin origin, org.chromium.url.mojom.Url uploadUrl, 
AddDomainReliabilityContextForTesting_Response callback);

    interface AddDomainReliabilityContextForTesting_Response extends org.chromium.mojo.bindings.Callbacks.Callback0 { }


    void forceDomainReliabilityUploadsForTesting(

ForceDomainReliabilityUploadsForTesting_Response callback);

    interface ForceDomainReliabilityUploadsForTesting_Response extends org.chromium.mojo.bindings.Callbacks.Callback0 { }


    void setCtLogListAlwaysTimelyForTesting(
);


    void setSctAuditingMode(
int mode);


    void addReportingApiObserver(
ReportingApiObserver observer);


    void getSharedDictionaryUsageInfo(

GetSharedDictionaryUsageInfo_Response callback);

    interface GetSharedDictionaryUsageInfo_Response extends org.chromium.mojo.bindings.Callbacks.Callback1<SharedDictionaryUsageInfo[]> { }


    void getSharedDictionaryInfo(
SharedDictionaryIsolationKey isolationKey, 
GetSharedDictionaryInfo_Response callback);

    interface GetSharedDictionaryInfo_Response extends org.chromium.mojo.bindings.Callbacks.Callback1<SharedDictionaryInfo[]> { }


    void getSharedDictionaryOriginsBetween(
org.chromium.mojo_base.mojom.Time startTime, org.chromium.mojo_base.mojom.Time endTime, 
GetSharedDictionaryOriginsBetween_Response callback);

    interface GetSharedDictionaryOriginsBetween_Response extends org.chromium.mojo.bindings.Callbacks.Callback1<org.chromium.url.internal.mojom.Origin[]> { }


    void setSharedDictionaryCacheMaxSize(
long cacheMaxSize);


    void resourceSchedulerClientVisibilityChanged(
org.chromium.mojo_base.mojom.UnguessableToken clientToken, boolean visible);


    void flushCachedClientCertIfNeeded(
HostPortPair host, X509Certificate certificate);


    void setCookieDeprecationLabel(
String label);


}
