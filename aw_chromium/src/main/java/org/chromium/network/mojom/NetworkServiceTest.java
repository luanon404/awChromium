// NetworkServiceTest.java is auto generated by mojom_bindings_generator.py, do not edit


// Copyright 2014 The Chromium Authors
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.

// This file is autogenerated by:
//     mojo/public/tools/bindings/mojom_bindings_generator.py
// For:
//     services/network/public/mojom/network_service_test.mojom
//

package org.chromium.network.mojom;

import androidx.annotation.IntDef;


public interface NetworkServiceTest extends org.chromium.mojo.bindings.Interface {



    public static final class RequireCt {
        private static final boolean IS_EXTENSIBLE = false;
        @IntDef({

            RequireCt.DEFAULT,
            RequireCt.REQUIRE})
        public @interface EnumType {}

        public static final int DEFAULT = 0;
        public static final int REQUIRE = 1;
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

        private RequireCt() {}
    }


    public interface Proxy extends NetworkServiceTest, org.chromium.mojo.bindings.Interface.Proxy {
    }

    Manager<NetworkServiceTest, NetworkServiceTest.Proxy> MANAGER = NetworkServiceTest_Internal.MANAGER;

    void addRules(
Rule[] rules, 
AddRules_Response callback);

    interface AddRules_Response extends org.chromium.mojo.bindings.Callbacks.Callback0 { }


    void simulateNetworkChange(
int type, 
SimulateNetworkChange_Response callback);

    interface SimulateNetworkChange_Response extends org.chromium.mojo.bindings.Callbacks.Callback0 { }


    void simulateNetworkQualityChange(
int type, 
SimulateNetworkQualityChange_Response callback);

    interface SimulateNetworkQualityChange_Response extends org.chromium.mojo.bindings.Callbacks.Callback0 { }


    void forceNetworkQualityEstimatorReportWifiAsSlow2G(

ForceNetworkQualityEstimatorReportWifiAsSlow2G_Response callback);

    interface ForceNetworkQualityEstimatorReportWifiAsSlow2G_Response extends org.chromium.mojo.bindings.Callbacks.Callback0 { }


    void simulateCrash(
);


    void mockCertVerifierSetDefaultResult(
int defaultResult, 
MockCertVerifierSetDefaultResult_Response callback);

    interface MockCertVerifierSetDefaultResult_Response extends org.chromium.mojo.bindings.Callbacks.Callback0 { }


    void mockCertVerifierAddResultForCertAndHost(
X509Certificate cert, String hostPattern, CertVerifyResult verifyResult, int rv, 
MockCertVerifierAddResultForCertAndHost_Response callback);

    interface MockCertVerifierAddResultForCertAndHost_Response extends org.chromium.mojo.bindings.Callbacks.Callback0 { }


    void setRequireCt(
int required, 
SetRequireCt_Response callback);

    interface SetRequireCt_Response extends org.chromium.mojo.bindings.Callbacks.Callback0 { }


    void setTransportSecurityStateSource(
short reportingPort, 
SetTransportSecurityStateSource_Response callback);

    interface SetTransportSecurityStateSource_Response extends org.chromium.mojo.bindings.Callbacks.Callback0 { }


    void setAllowNetworkAccessToHostResolutions(

SetAllowNetworkAccessToHostResolutions_Response callback);

    interface SetAllowNetworkAccessToHostResolutions_Response extends org.chromium.mojo.bindings.Callbacks.Callback0 { }


    void replaceSystemDnsConfig(

ReplaceSystemDnsConfig_Response callback);

    interface ReplaceSystemDnsConfig_Response extends org.chromium.mojo.bindings.Callbacks.Callback0 { }


    void setTestDohConfig(
int secureDnsMode, DnsOverHttpsConfig dohConfig, 
SetTestDohConfig_Response callback);

    interface SetTestDohConfig_Response extends org.chromium.mojo.bindings.Callbacks.Callback0 { }


    void crashOnResolveHost(
String host);


    void crashOnGetCookieList(
);


    void getLatestMemoryPressureLevel(

GetLatestMemoryPressureLevel_Response callback);

    interface GetLatestMemoryPressureLevel_Response extends org.chromium.mojo.bindings.Callbacks.Callback1<Integer> { }


    void getPeerToPeerConnectionsCountChange(

GetPeerToPeerConnectionsCountChange_Response callback);

    interface GetPeerToPeerConnectionsCountChange_Response extends org.chromium.mojo.bindings.Callbacks.Callback1<Integer> { }


    void getEnvironmentVariableValue(
String name, 
GetEnvironmentVariableValue_Response callback);

    interface GetEnvironmentVariableValue_Response extends org.chromium.mojo.bindings.Callbacks.Callback1<String> { }


    void log(
String message, 
Log_Response callback);

    interface Log_Response extends org.chromium.mojo.bindings.Callbacks.Callback0 { }


    void activateFieldTrial(
String fieldTrialName);


    void setSctAuditingRetryDelay(
org.chromium.mojo_base.mojom.TimeDelta delay, 
SetSctAuditingRetryDelay_Response callback);

    interface SetSctAuditingRetryDelay_Response extends org.chromium.mojo.bindings.Callbacks.Callback0 { }


    void openFile(
org.chromium.mojo_base.mojom.FilePath path, 
OpenFile_Response callback);

    interface OpenFile_Response extends org.chromium.mojo.bindings.Callbacks.Callback1<Boolean> { }


    void enumerateFiles(
org.chromium.mojo_base.mojom.FilePath path, HttpCacheBackendFileOperationsFactory factory, 
EnumerateFiles_Response callback);

    interface EnumerateFiles_Response extends org.chromium.mojo.bindings.Callbacks.Callback2<FileEnumerationEntry[], Boolean> { }


    void createSimpleCache(
HttpCacheBackendFileOperationsFactory factory, org.chromium.mojo_base.mojom.FilePath path, boolean reset, 
CreateSimpleCache_Response callback);

    interface CreateSimpleCache_Response extends org.chromium.mojo.bindings.Callbacks.Callback1<SimpleCache> { }


    void makeRequestToServer(
TransferableSocket s, IpEndPoint endpoint, 
MakeRequestToServer_Response callback);

    interface MakeRequestToServer_Response extends org.chromium.mojo.bindings.Callbacks.Callback1<Boolean> { }


    void resolveOwnHostnameWithSystemDns(

ResolveOwnHostnameWithSystemDns_Response callback);

    interface ResolveOwnHostnameWithSystemDns_Response extends org.chromium.mojo.bindings.Callbacks.Callback3<AddressList, Integer, Integer> { }


    void setIPv6ProbeResult(
boolean success, 
SetIPv6ProbeResult_Response callback);

    interface SetIPv6ProbeResult_Response extends org.chromium.mojo.bindings.Callbacks.Callback0 { }


}
