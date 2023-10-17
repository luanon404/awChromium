// Copyright 2015 The Chromium Authors. All rights reserved.
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.
package org.chromium.android_webview.permission

import org.chromium.android_webview.AwContents
import org.chromium.android_webview.AwGeolocationPermissions
import org.chromium.android_webview.CleanupReference
import org.chromium.base.Log
import org.chromium.base.ThreadUtils
import java.lang.ref.WeakReference

/**
 * This class implements AwGeolocationPermissions.Callback, and will be sent to
 * WebView applications through WebChromeClient.onGeolocationPermissionsShowPrompt().
 */
class AwGeolocationCallback(origin: String, awContents: AwContents) :
    AwGeolocationPermissions.Callback {
    private var mCleanupRunable: CleanupRunable?
    private var mCleanupReference: CleanupReference?

    private class CleanupRunable(awContents: AwContents, private var mOrigin: String?) : Runnable {
        private val mAwContents: WeakReference<AwContents>
        private var mAllow = false
        private var mRetain = false

        init {
            mAwContents = WeakReference(awContents)
        }

        override fun run() {
            assert(ThreadUtils.runningOnUiThread())
            val awContents = mAwContents.get() ?: return
            if (mRetain) {
                if (mAllow) {
                    awContents.geolocationPermissions.allow(mOrigin)
                } else {
                    awContents.geolocationPermissions.deny(mOrigin)
                }
            }
            awContents.invokeGeolocationCallback(mAllow, mOrigin)
        }

        fun setResponse(origin: String?, allow: Boolean, retain: Boolean) {
            mOrigin = origin
            mAllow = allow
            mRetain = retain
        }
    }

    init {
        mCleanupRunable = CleanupRunable(awContents, origin)
        mCleanupReference = CleanupReference(this, mCleanupRunable)
    }

    override fun invoke(origin: String?, allow: Boolean, retain: Boolean) {
        if (mCleanupRunable == null || mCleanupReference == null) {
            Log.w(
                TAG,
                "Response for this geolocation request has been received." + " Ignoring subsequent responses"
            )
            return
        }
        mCleanupRunable!!.setResponse(origin, allow, retain)
        mCleanupReference!!.cleanupNow()
        mCleanupReference = null
        mCleanupRunable = null
    }

    companion object {
        private const val TAG = "Geolocation"
    }
}