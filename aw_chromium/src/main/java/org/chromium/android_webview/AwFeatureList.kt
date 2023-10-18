// Copyright 2018 The Chromium Authors. All rights reserved.
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.
package org.chromium.android_webview

import android.content.pm.PackageManager
import android.os.Build
import android.util.Log
import org.chromium.base.ContextUtils
import org.chromium.base.annotations.JNINamespace
import org.chromium.base.annotations.MainDex
import org.chromium.base.annotations.NativeMethods

/**
 * Java accessor for base/feature_list.h state.
 */
@JNINamespace("android_webview")
@MainDex
object AwFeatureList {
    private const val GMS_PACKAGE = "com.google.android.gms"
    private var sPageStartedOnCommitForBrowserNavigations: Boolean? = null
    private fun computePageStartedOnCommitForBrowserNavigations(): Boolean {
        if (GMS_PACKAGE == ContextUtils.getApplicationContext().packageName) {
            try {
                val gmsPackage = ContextUtils.getApplicationContext().packageManager.getPackageInfo(
                    GMS_PACKAGE, 0
                )
                return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
                    gmsPackage.longVersionCode >= 15000000
                } else {
                    gmsPackage.versionCode >= 15000000
                }
            } catch (_: PackageManager.NameNotFoundException) {
            }
            return false
        }
        return true
    }

    @JvmStatic
    fun pageStartedOnCommitEnabled(isRendererInitiated: Boolean): Boolean {
        // Always enable for renderer-initiated navigations.
        if (isRendererInitiated) return true
        if (sPageStartedOnCommitForBrowserNavigations != null) {
            return sPageStartedOnCommitForBrowserNavigations!!
        }
        sPageStartedOnCommitForBrowserNavigations =
            computePageStartedOnCommitForBrowserNavigations()
        return sPageStartedOnCommitForBrowserNavigations!!
    }

    /**
     * Returns whether the specified feature is enabled or not.
     *
     * Note: Features queried through this API must be added to the array
     * |kFeaturesExposedToJava| in android_webview/browser/aw_feature_list.cc
     *
     * @param featureName The name of the feature to query.
     * @return Whether the feature is enabled or not.
     */
    @JvmStatic
    fun isEnabled(featureName: String?): Boolean {
        return AwFeatureListJni.get().isEnabled(featureName)
    }

    // Deprecated: Use AwFeatures.*
    // This constant is here temporarily to avoid breaking Clank.
    @Deprecated("")
    val WEBVIEW_CONNECTIONLESS_SAFE_BROWSING = "WebViewConnectionlessSafeBrowsing"

    @NativeMethods
    internal interface Natives {
        fun isEnabled(featureName: String?): Boolean
    }
}