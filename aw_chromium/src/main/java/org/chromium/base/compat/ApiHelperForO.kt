// Copyright 2018 The Chromium Authors. All rights reserved.
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.
package org.chromium.base.compat

import android.animation.ValueAnimator
import android.annotation.TargetApi
import android.app.Activity
import android.app.Notification
import android.content.ClipDescription
import android.content.Context
import android.content.pm.ApplicationInfo
import android.content.pm.PackageManager
import android.content.res.Configuration
import android.net.ConnectivityManager
import android.net.ConnectivityManager.NetworkCallback
import android.net.NetworkRequest
import android.os.Build
import android.os.Handler
import android.view.Display
import android.view.View
import android.view.Window
import android.view.autofill.AutofillManager
import org.chromium.base.StrictModeContext
import org.chromium.base.annotations.VerifiesOnO

/**
 * Utility class to use new APIs that were added in O (API level 26). These need to exist in a
 * separate class so that Android framework can successfully verify classes without
 * encountering the new APIs.
 */
@VerifiesOnO
@TargetApi(Build.VERSION_CODES.O)
object ApiHelperForO {
    /** See [Display.isWideColorGamut].  */
    @JvmStatic
    fun isWideColorGamut(display: Display): Boolean {
        return display.isWideColorGamut
    }

    /** See [Window.setColorMode].  */
    @JvmStatic
    fun setColorMode(window: Window, colorMode: Int) {
        window.colorMode = colorMode
    }

    /** See [Configuration.isScreenWideColorGamut].  */
    @JvmStatic
    fun isScreenWideColorGamut(configuration: Configuration): Boolean {
        return configuration.isScreenWideColorGamut
    }

    /** See [PackageManager.isInstantApp].  */
    fun isInstantApp(packageManager: PackageManager): Boolean {
        return packageManager.isInstantApp
    }

    /** See [View.setDefaultFocusHighlightEnabled].  */
    fun setDefaultFocusHighlightEnabled(view: View, enabled: Boolean) {
        view.defaultFocusHighlightEnabled = enabled
    }

    /** See [ClipDescription.getTimestamp].  */
    @JvmStatic
    fun getTimestamp(clipDescription: ClipDescription): Long {
        return clipDescription.timestamp
    }

    /** See [ApplicationInfo.splitNames].  */
    @JvmStatic
    fun getSplitNames(info: ApplicationInfo): Array<String>? {
        return info.splitNames
    }

    /**
     * See []. Be careful about adding new uses of
     * this, most split Contexts should be created through [ ][]
     */
    @JvmStatic
    @Throws(PackageManager.NameNotFoundException::class)
    fun createContextForSplit(context: Context, name: String?): Context {
        StrictModeContext.allowDiskReads()
            .use { return context.createContextForSplit(name) }
    }

    /** See [AutofillManager.cancel].  */
    fun cancelAutofillSession(activity: Activity) {
        // The AutofillManager has to be retrieved from an activity context.
        // https://cs.android.com/android/platform/superproject/+/master:frameworks/base/core/java/android/app/Application.java;l=624;drc=5d123b67756dffcfdebdb936ab2de2b29c799321
        val afm = activity.getSystemService(AutofillManager::class.java)
        afm?.cancel()
    }

    /** See [AutofillManager.notifyValueChanged].  */
    fun notifyValueChangedForAutofill(view: View) {
        val afm = view.context.getSystemService(
            AutofillManager::class.java
        )
        afm?.notifyValueChanged(view)
    }

    /**
     * See [ConnectivityManager.registerNetworkCallback].
     */
    @JvmStatic
    fun registerNetworkCallback(
        connectivityManager: ConnectivityManager,
        networkRequest: NetworkRequest?, networkCallback: NetworkCallback?, handler: Handler?
    ) {
        connectivityManager.registerNetworkCallback(networkRequest!!, networkCallback!!, handler!!)
    }

    /** See [ValueAnimator.areAnimatorsEnabled].  */
    fun areAnimatorsEnabled(): Boolean {
        return ValueAnimator.areAnimatorsEnabled()
    }

    /** See [Notification.Builder.setChannelId].  */
    fun setChannelId(
        builder: Notification.Builder, channelId: String?
    ): Notification.Builder {
        return builder.setChannelId(channelId)
    }

    /** See [Notification.Builder.setTimeoutAfter].  */
    fun setTimeoutAfter(builder: Notification.Builder, ms: Long): Notification.Builder {
        return builder.setTimeoutAfter(ms)
    }

    /**
     * See [ ][ConnectivityManager.registerDefaultNetworkCallback].
     */
    @JvmStatic
    fun registerDefaultNetworkCallback(
        connectivityManager: ConnectivityManager,
        networkCallback: NetworkCallback?, handler: Handler?
    ) {
        connectivityManager.registerDefaultNetworkCallback(networkCallback!!, handler!!)
    }

    /** See [Notification.getChannelId].  */
    fun getNotificationChannelId(notification: Notification): String {
        return notification.channelId
    }
}