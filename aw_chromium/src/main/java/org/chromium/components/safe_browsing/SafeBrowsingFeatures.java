// Copyright 2023 The Chromium Authors
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.

package org.chromium.components.safe_browsing;

/**
 * Contains constants for names of Safe Browsing features.
 */
public final class SafeBrowsingFeatures {


    // This following string constants were inserted by
    //     java_cpp_features.py
    // From
    //     ../../components/safe_browsing/core/common/features.cc
    // Into
    //     ../../components/safe_browsing/android/java/src/org/chromium/components/safe_browsing/SafeBrowsingFeatures.java.tmpl


    public static final String AD_SAMPLER_TRIGGER_FEATURE = "SafeBrowsingAdSamplerTrigger";


    public static final String ANTI_PHISHING_TELEMETRY = "AntiPhishingTelemetry";


    public static final String CLIENT_SIDE_DETECTION_KILLSWITCH = "ClientSideDetectionKillswitch";


    public static final String CLIENT_SIDE_DETECTION_MODEL_IS_FLAT_BUFFER = "ClientSideDetectionModelIsFlatBuffer";


    public static final String CLIENT_SIDE_DETECTION_MODEL_TAG = "ClientSideDetectionTag";


    public static final String CLIENT_SIDE_DETECTION_TYPE_FORCE_REQUEST = "ClientSideDetectionTypeForceRequest";


    public static final String DEEP_SCANNING_UPDATED_UX = "SafeBrowsingDeepScanningUpdatedUX";


    public static final String DEEP_SCANNING_ENCRYPTED_ARCHIVES = "SafeBrowsingDeepScanningEncryptedArchives";


    public static final String DELAYED_WARNINGS = "SafeBrowsingDelayedWarnings";


    public static final String DOWNLOAD_BUBBLE = "DownloadBubble";


    public static final String DOWNLOAD_BUBBLE_V2 = "DownloadBubbleV2";


    public static final String DOWNLOAD_TAILORED_WARNINGS = "DownloadTailoredWarnings";


    public static final String EVALUATE_PROTECTED_PASSWORD_LENGTH_MINIMUM = "EvaluateProtectedPasswordLengthMinimum";


    public static final String EXTENSION_TELEMETRY_CONFIGURATION = "SafeBrowsingExtensionTelemetryConfiguration";


    public static final String EXTENSION_TELEMETRY_FILE_DATA = "SafeBrowsingExtensionTelemetryFileData";


    public static final String EXTENSION_TELEMETRY_POTENTIAL_PASSWORD_THEFT = "SafeBrowsingExtensionTelemetryPotentialPasswordTheft";


    public static final String EXTENSION_TELEMETRY_REPORT_CONTACTED_HOSTS = "SafeBrowsingExtensionTelemetryReportContactedHosts";


    public static final String EXTENSION_TELEMETRY_REPORT_HOSTS_CONTACTED_VIA_WEB_SOCKET = "SafeBrowsingExtensionTelemetryReportHostsContactedViaWebsocket";


    public static final String EXTENSION_TELEMETRY_TABS_API_SIGNAL = "SafeBrowsingExtensionTelemetryTabsApiSignal";


    public static final String EXTENSION_TELEMETRY_TABS_EXECUTE_SCRIPT_SIGNAL = "SafeBrowsingExtensionTelemetryTabsExecuteScriptSignal";


    public static final String EXTENSION_TELEMETRY_DISABLE_OFFSTORE_EXTENSIONS = "SafeBrowsingExtensionTelemetryDisableOffstoreExtensions";


    public static final String FRIENDLIER_SAFE_BROWSING_SETTINGS_ENHANCED_PROTECTION = "FriendlierSafeBrowsingSettingsEnhancedProtection";


    public static final String FRIENDLIER_SAFE_BROWSING_SETTINGS_STANDARD_PROTECTION = "FriendlierSafeBrowsingSettingsStandardProtection";


    public static final String HASH_PREFIX_REAL_TIME_LOOKUPS = "SafeBrowsingHashPrefixRealTimeLookups";


    public static final String HASH_REAL_TIME_OVER_OHTTP = "SafeBrowsingHashRealTimeOverOhttp";


    public static final String IMPROVED_DOWNLOAD_BUBBLE_WARNINGS = "ImprovedDownloadBubbleWarnings";


    public static final String IMPROVED_DOWNLOAD_PAGE_WARNINGS = "ImprovedDownloadPageWarnings";


    public static final String LOG_ACCOUNT_ENHANCED_PROTECTION_STATE_IN_PROTEGO_PINGS = "TailoredSecurityLogAccountEnhancedProtectionStateInProtegoPings";


    public static final String MMAP_SAFE_BROWSING_DATABASE = "MmapSafeBrowsingDatabase";


    public static final String NESTED_ARCHIVES = "SafeBrowsingArchiveImprovements";


    public static final String RED_WARNING_SURVEY = "RedWarningSurvey";


    public static final String RED_INTERSTITIAL_FACELIFT = "RedInterstitialFacelift";


    public static final String REFERRER_CHAIN_PARAMETERS = "SafeBrowsingReferrerChainParameters";


    public static final String SAFE_BROWSING_CSBRR_NEW_DOWNLOAD_TRIGGER = "SafeBrowsingCsbrrNewDownloadTrigger";


    public static final String SAFE_BROWSING_LOOKUP_MECHANISM_EXPERIMENT = "SafeBrowsingLookupMechanismExperiment";


    public static final String SAFE_BROWSING_NEW_GMS_API_FOR_BROWSE_URL_DATABASE_CHECK = "SafeBrowsingNewGmsApiForBrowseUrlDatabaseCheck";


    public static final String SAFE_BROWSING_ON_UI_THREAD = "SafeBrowsingOnUIThread";


    public static final String SAFE_BROWSING_REFERRER_CHAIN_WITH_COPY_PASTE_NAVIGATION = "SafeBrowsingReferrerChainWithCopyPasteNavigation";


    public static final String SAFE_BROWSING_REMOVE_COOKIES_IN_AUTH_REQUESTS = "SafeBrowsingRemoveCookiesInAuthRequests";


    public static final String SAFE_BROWSING_SKIP_IMAGE_CSS_FONT = "SafeBrowsingSkipImageCssFont";


    public static final String SAFE_BROWSING_SKIP_SUBRESOURCES = "SafeBrowsingSkipSubResources";


    public static final String SAFE_BROWSING_SKIP_SUBRESOURCES2 = "SafeBrowsingSkipSubResources2";


    public static final String SEVEN_ZIP_EVALUATION_ENABLED = "SafeBrowsingSevenZipEvaluationEnabled";


    public static final String SIMPLIFIED_URL_DISPLAY = "SimplifiedUrlDisplay";


    public static final String STRICT_DOWNLOAD_TIMEOUT = "SafeBrowsingStrictDownloadtimeout";


    public static final String SUSPICIOUS_SITE_TRIGGER_QUOTA_FEATURE = "SafeBrowsingSuspiciousSiteTriggerQuota";


    public static final String TAILORED_SECURITY_RETRY_FOR_SYNC_USERS = "TailoredSecurityRetryForSyncUsers";


    public static final String TAILORED_SECURITY_OBSERVER_RETRIES = "TailoredSecurityObserverRetries";


    public static final String TAILORED_SECURITY_INTEGRATION = "TailoredSecurityIntegration";


    public static final String TAILORED_SECURITY_UPDATED_MESSAGES = "TailoredSecurityUpdatedMessages";


    public static final String THREAT_DOM_DETAILS_TAG_AND_ATTRIBUTE_FEATURE = "ThreatDomDetailsTagAttributes";


    public static final String VISUAL_FEATURES_SIZES = "VisualFeaturesSizes";


    public static final String CLIENT_SIDE_DETECTION_MODEL_IMAGE_EMBEDDER = "ClientSideDetectionModelImageEmbedder";


    public static final String SAFE_BROWSING_PHISHING_CLASSIFICATION_ESB_THRESHOLD = "SafeBrowsingPhishingClassificationESBThreshold";


    public static final String SAFE_BROWSING_DAILY_PHISHING_REPORTS_LIMIT = "SafeBrowsingDailyPhishingReportsLimit";

    // Prevents instantiation.
    private SafeBrowsingFeatures() {}
}
