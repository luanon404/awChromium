// Copyright 2018 The Chromium Authors. All rights reserved.
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.
package org.chromium.base.compat

import android.annotation.TargetApi
import android.content.ClipboardManager
import android.content.pm.PackageInfo
import android.content.pm.PackageManager
import android.location.LocationManager
import android.net.LinkProperties
import android.os.Build
import android.telephony.SignalStrength
import android.telephony.TelephonyManager
import org.chromium.base.annotations.VerifiesOnP

/**
 * Utility class to use new APIs that were added in P (API level 28). These need to exist in a
 * separate class so that Android framework can successfully verify classes without
 * encountering the new APIs.
 */
@VerifiesOnP
@TargetApi(Build.VERSION_CODES.P)
object ApiHelperForP {
    /** See [LinkProperties.isPrivateDnsActive].  */
    @JvmStatic
    fun isPrivateDnsActive(linkProperties: LinkProperties): Boolean {
        return linkProperties.isPrivateDnsActive
    }

    /** See [LinkProperties.getPrivateDnsServerName].  */
    @JvmStatic
    fun getPrivateDnsServerName(linkProperties: LinkProperties): String? {
        return linkProperties.privateDnsServerName
    }

    /** See [PackageInfo.getLongVersionCode].  */
    @JvmStatic
    fun getLongVersionCode(packageInfo: PackageInfo): Long {
        return packageInfo.longVersionCode
    }

    /** See [LocationManager.isLocationEnabled].  */
    @JvmStatic
    fun isLocationEnabled(locationManager: LocationManager): Boolean {
        return locationManager.isLocationEnabled
    }

    /** See [TelephonyManager.getSignalStrength].  */
    @JvmStatic
    fun getSignalStrength(telephonyManager: TelephonyManager): SignalStrength? {
        return telephonyManager.signalStrength
    }

    /** See [ClipboardManager.clearPrimaryClip].  */
    @JvmStatic
    fun clearPrimaryClip(clipboardManager: ClipboardManager) {
        clipboardManager.clearPrimaryClip()
    }

    /** See [PackageManager.hasSigningCertificate].  */
    fun hasSigningCertificate(
        pm: PackageManager, packageName: String?, certificate: ByteArray?, type: Int
    ): Boolean {
        return pm.hasSigningCertificate(packageName!!, certificate!!, type)
    }
}