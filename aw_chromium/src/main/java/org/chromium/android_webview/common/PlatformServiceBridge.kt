// Copyright 2015 The Chromium Authors. All rights reserved.
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.
package org.chromium.android_webview.common

import android.os.Handler
import android.os.HandlerThread
import org.chromium.base.Callback
import org.chromium.base.Consumer
import org.chromium.base.ThreadUtils
import org.chromium.components.metrics.AndroidMetricsLogUploader
import org.chromium.content_public.browser.trusttokens.TrustTokenFulfillerManager

/**
 * This class manages platform-specific services. (i.e. Google Services) The platform
 * should extend this class and use this base class to fetch their specialized version.
 */
abstract class PlatformServiceBridge protected constructor() {
    init {
        AndroidMetricsLogUploader.setUploader(object : Consumer<ByteArray?> {
            override fun accept(t: ByteArray?) {
                logMetrics()
            }
        })
    }

    // Overriding implementations may call "callback" asynchronously, on any thread.
    fun querySafeBrowsingUserConsent(callback: Callback<Boolean?>) {
        // User opt-in preference depends on a SafetyNet API. In purely upstream builds (which don't
        // communicate with GMS), assume the user has not opted in.
        callback.onResult(false)
    }

    // Overriding implementations may call "callback" asynchronously. For simplicity (and not
    // because of any technical limitation) we require that "queryMetricsSetting" and "callback"
    // both get called on WebView's UI thread.
    fun queryMetricsSetting(callback: Callback<Boolean?>) {
        ThreadUtils.assertOnUiThread()
        callback.onResult(false)
    }

    fun setSafeBrowsingHandler() {
        // We don't have this specialized service.
    }

    fun warmUpSafeBrowsing(callback: Callback<Boolean?>) {
        callback.onResult(false)
    }

    // Takes an uncompressed, serialized UMA proto and logs it via a platform-specific mechanism.
    private fun logMetrics() {}
    val localTrustTokenFulfillerFactory: TrustTokenFulfillerManager.Factory?
        // Returns a TrustTokenFulfillerManager.Factory if appropriate, else returns null.
        get() = null

    companion object {
        private var sInstance: PlatformServiceBridge? = null
        private val sInstanceLock = Any()
        private var sHandlerThread: HandlerThread? = null
        private var sHandler: Handler? = null
        private val sHandlerLock = Any()

        @JvmStatic
        @get:Suppress("unused")
        val instance: PlatformServiceBridge?
            get() {
                synchronized(sInstanceLock) {
                    if (sInstance == null) {
                        // Load an instance of PlatformServiceBridgeImpl. Because this can change
                        // depending on the GN configuration, this may not be the PlatformServiceBridgeImpl
                        // defined upstream.
                        sInstance = PlatformServiceBridgeImpl()
                    }
                    return sInstance
                }
            }

        val handler: Handler?
            // Return a handler appropriate for executing blocking Platform Service tasks.
            get() {
                synchronized(sHandlerLock) {
                    if (sHandler == null) {
                        sHandlerThread = HandlerThread("PlatformServiceBridgeHandlerThread")
                        sHandlerThread!!.start()
                        sHandler = Handler(sHandlerThread!!.looper)
                    }
                }
                return sHandler
            }
    }
}