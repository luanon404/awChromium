// Copyright 2017 The Chromium Authors. All rights reserved.
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.
package org.chromium.android_webview.safe_browsing

import android.os.Build
import android.webkit.WebViewClient
import androidx.annotation.RequiresApi
import org.chromium.base.ContextUtils
import org.chromium.components.safe_browsing.SBThreatType

/**
 * This is a helper class to map native SafeBrowsingActions and SAFE_BROWSING_THREATs to the
 * constants in WebViewClient.
 */
object AwSafeBrowsingConversionHelper {
    // These values are used for UMA. Entries should not be renumbered and
    // numeric values should never be reused. The BOUNDARY constant should be
    // updated when adding new constants.
    /** The resource was blocked for an unknown reason.  */
    @RequiresApi(Build.VERSION_CODES.O_MR1)
    const val SAFE_BROWSING_THREAT_UNKNOWN = WebViewClient.SAFE_BROWSING_THREAT_UNKNOWN

    /** The resource was blocked because it contains malware.  */
    @RequiresApi(Build.VERSION_CODES.O_MR1)
    const val SAFE_BROWSING_THREAT_MALWARE = WebViewClient.SAFE_BROWSING_THREAT_MALWARE

    /** The resource was blocked because it contains deceptive content.  */
    @RequiresApi(Build.VERSION_CODES.O_MR1)
    const val SAFE_BROWSING_THREAT_PHISHING = WebViewClient.SAFE_BROWSING_THREAT_PHISHING

    /** The resource was blocked because it contains unwanted software.  */
    @RequiresApi(Build.VERSION_CODES.O_MR1)
    const val SAFE_BROWSING_THREAT_UNWANTED_SOFTWARE =
        WebViewClient.SAFE_BROWSING_THREAT_UNWANTED_SOFTWARE

    /** The resource was blocked because it may trick the user into a billing agreement.  */ // TODO(ntfschr): replace this with the named constant when we roll the Q SDK
    // (http://crbug.com/887186).
    private const val SAFE_BROWSING_THREAT_BILLING = 4

    /**
     * Converts the threat type value from SafeBrowsing code to the WebViewClient constant.
     *
     *
     * **Note:** this output may depend upon the embedding application's `targetSdk` value if `chromiumThreatType` refers to a threat type added after [ ][Build.VERSION_CODES.O_MR1] (when we added the original Safe Browisng threat type constants).
     */
    @RequiresApi(Build.VERSION_CODES.O_MR1)
    @JvmStatic
    fun convertThreatType(chromiumThreatType: Int): Int {
        return when (chromiumThreatType) {
            SBThreatType.URL_MALWARE -> SAFE_BROWSING_THREAT_MALWARE
            SBThreatType.URL_PHISHING -> SAFE_BROWSING_THREAT_PHISHING
            SBThreatType.URL_UNWANTED -> SAFE_BROWSING_THREAT_UNWANTED_SOFTWARE
            SBThreatType.BILLING -> if (ContextUtils.getApplicationContext().applicationInfo.targetSdkVersion >= Build.VERSION_CODES.Q) SAFE_BROWSING_THREAT_BILLING else SAFE_BROWSING_THREAT_UNKNOWN

            else -> SAFE_BROWSING_THREAT_UNKNOWN
        }
    }
}