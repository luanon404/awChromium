// Copyright 2018 The Chromium Authors. All rights reserved.
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.
package org.chromium.base.compat

import android.app.Activity
import android.app.Notification
import android.app.job.JobInfo
import android.app.job.JobScheduler
import android.content.ClipData
import android.content.ComponentName
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.media.MediaCodec.CryptoInfo
import android.os.Process
import android.security.NetworkSecurityPolicy
import android.view.MotionEvent
import android.view.PointerIcon
import android.view.View
import android.view.View.DragShadowBuilder
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.RemoteViews
import org.chromium.base.annotations.VerifiesOnN

/**
 * Utility class to use new APIs that were added in N (API level 24). These need to exist in a
 * separate class so that Android framework can successfully verify classes without
 * encountering the new APIs.
 */
@VerifiesOnN
object ApiHelperForN {
    /**
     * See [WebViewClient.shouldOverrideUrlLoading], which was
     * added in N.
     */
    fun shouldOverrideUrlLoading(
        webViewClient: WebViewClient, webView: WebView?, request: WebResourceRequest?
    ): Boolean {
        return webViewClient.shouldOverrideUrlLoading(webView, request)
    }

    /** See [JobScheduler.getPendingJob].  */
    fun getPendingJob(scheduler: JobScheduler, jobId: Int): JobInfo? {
        return scheduler.getPendingJob(jobId)
    }

    /** See [View.startDragAndDrop].  */
    @JvmStatic
    fun startDragAndDrop(
        view: View, data: ClipData?,
        shadowBuilder: DragShadowBuilder?, myLocalState: Any?, flags: Int
    ): Boolean {
        return view.startDragAndDrop(data, shadowBuilder, myLocalState, flags)
    }

    /** See [View.setPointerIcon].  */
    @JvmStatic
    fun setPointerIcon(view: View, icon: PointerIcon?) {
        view.pointerIcon = icon
    }

    /** See [PointerIcon.create].  */
    @JvmStatic
    fun createPointerIcon(bitmap: Bitmap?, width: Float, height: Float): PointerIcon {
        return PointerIcon.create(bitmap!!, width, height)
    }

    /** See [CryptoInfo.setPattern].  */
    @JvmStatic
    fun setCryptoInfoPattern(cryptoInfo: CryptoInfo, encrypt: Int, skip: Int) {
        cryptoInfo.pattern = CryptoInfo.Pattern(encrypt, skip)
    }

    /** See [Activity.setVrModeEnabled].  */
    @Throws(PackageManager.NameNotFoundException::class)
    fun setVrModeEnabled(
        activity: Activity, enabled: Boolean,
        requestedComponent: ComponentName?
    ) {
        activity.setVrModeEnabled(enabled, requestedComponent!!)
    }

    /** See [NetworkSecurityPolicy.isCleartextTrafficPermitted].  */
    @JvmStatic
    fun isCleartextTrafficPermitted(host: String?): Boolean {
        return NetworkSecurityPolicy.getInstance().isCleartextTrafficPermitted(host)
    }

    /** See [View.onResolvePointerIcon].  */
    fun onResolvePointerIcon(view: View, event: MotionEvent?, pointerIndex: Int): PointerIcon {
        return view.onResolvePointerIcon(event, pointerIndex)
    }

    @JvmStatic
    val startUptimeMillis: Long
        /** See [Process.getStartUptimeMillis].  */
        get() = Process.getStartUptimeMillis()

    /** See [Notification.Builder.setCustomContentView].  */
    fun setCustomContentView(
        builder: Notification.Builder, views: RemoteViews?
    ): Notification.Builder {
        return builder.setCustomContentView(views)
    }

    /** See [Notification.Builder.setCustomBigContentView].  */
    fun setCustomBigContentView(
        builder: Notification.Builder, view: RemoteViews?
    ): Notification.Builder {
        return builder.setCustomBigContentView(view)
    }
}