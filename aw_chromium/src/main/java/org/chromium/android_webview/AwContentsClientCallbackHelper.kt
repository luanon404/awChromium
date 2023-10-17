// Copyright 2013 The Chromium Authors. All rights reserved.
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.
package org.chromium.android_webview

import android.graphics.Picture
import android.os.Build
import android.os.Handler
import android.os.Looper
import android.os.Message
import android.os.SystemClock
import androidx.annotation.RequiresApi
import org.chromium.android_webview.AwContentsClient.AwWebResourceError
import org.chromium.android_webview.AwContentsClient.AwWebResourceRequest
import org.chromium.android_webview.safe_browsing.AwSafeBrowsingResponse
import org.chromium.base.Callback
import org.chromium.components.embedder_support.util.WebResourceResponseInfo
import java.util.concurrent.Callable
import kotlin.math.max

/**
 * This class is responsible for calling certain client callbacks on the UI thread.
 *
 * Most callbacks do no go through here, but get forwarded to AwContentsClient directly. The
 * messages processed here may originate from the IO or UI thread.
 */
class AwContentsClientCallbackHelper(looper: Looper, contentsClient: AwContentsClient) {
    /**
     * Interface to tell CallbackHelper to cancel posted callbacks.
     */
    interface CancelCallbackPoller {
        fun shouldCancelAllCallbacks(): Boolean
    }

    // TODO(boliu): Consider removing DownloadInfo and LoginRequestInfo by using native
    // MessageLoop to post directly to AwContents.
    private class DownloadInfo(
        val mUrl: String,
        val mUserAgent: String,
        val mContentDisposition: String,
        val mMimeType: String,
        val mContentLength: Long
    )

    private class LoginRequestInfo(
        val mRealm: String,
        val mAccount: String,
        val mArgs: String
    )

    private class OnReceivedErrorInfo(
        val mRequest: AwWebResourceRequest,
        val mError: AwWebResourceError
    )

    private class OnSafeBrowsingHitInfo(
        val mRequest: AwWebResourceRequest, val mThreatType: Int,
        val mCallback: Callback<AwSafeBrowsingResponse?>
    )

    private class OnReceivedHttpErrorInfo(
        val mRequest: AwWebResourceRequest, val mResponse: WebResourceResponseInfo
    )

    private class DoUpdateVisitedHistoryInfo(
        val mUrl: String,
        val mIsReload: Boolean
    )

    private class OnFormResubmissionInfo(
        val mDontResend: Message,
        val mResend: Message
    )

    // Timestamp of the most recent onNewPicture callback.
    private var mLastPictureTime: Long = 0

    // True when a onNewPicture callback is currenly in flight.
    private var mHasPendingOnNewPicture = false
    private val mContentsClient: AwContentsClient
    private val mHandler: Handler

    // Public for tests.
    var cancelCallbackPoller: CancelCallbackPoller? = null

    private inner class MyHandler(looper: Looper) : Handler(looper) {
        @RequiresApi(Build.VERSION_CODES.O)
        override fun handleMessage(msg: Message) {
            if (cancelCallbackPoller != null && cancelCallbackPoller!!.shouldCancelAllCallbacks()) {
                removeCallbacksAndMessages(null)
                return
            }
            when (msg.what) {
                MSG_ON_LOAD_RESOURCE -> {
                    val url = msg.obj as String
                    mContentsClient.onLoadResource(url)
                }

                MSG_ON_PAGE_STARTED -> {
                    val url = msg.obj as String
                    mContentsClient.onPageStarted(url)
                }

                MSG_ON_DOWNLOAD_START -> {
                    val info = msg.obj as DownloadInfo
                    mContentsClient.onDownloadStart(
                        info.mUrl, info.mUserAgent,
                        info.mContentDisposition, info.mMimeType, info.mContentLength
                    )
                }

                MSG_ON_RECEIVED_LOGIN_REQUEST -> {
                    val info = msg.obj as LoginRequestInfo
                    mContentsClient.onReceivedLoginRequest(info.mRealm, info.mAccount, info.mArgs)
                }

                MSG_ON_RECEIVED_ERROR -> {
                    val info = msg.obj as OnReceivedErrorInfo
                    mContentsClient.onReceivedError(info.mRequest, info.mError)
                }

                MSG_ON_SAFE_BROWSING_HIT -> {
                    val info = msg.obj as OnSafeBrowsingHitInfo
                    mContentsClient.onSafeBrowsingHit(
                        info.mRequest, info.mThreatType, info.mCallback
                    )
                }

                MSG_ON_NEW_PICTURE -> {
                    var picture: Picture? = null
                    try {
                        if (msg.obj != null) picture = (msg.obj as Callable<*>).call() as Picture
                    } catch (e: Exception) {
                        throw RuntimeException("Error getting picture", e)
                    }
                    mContentsClient.onNewPicture(picture)
                    mLastPictureTime = SystemClock.uptimeMillis()
                    mHasPendingOnNewPicture = false
                }

                MSG_ON_SCALE_CHANGED_SCALED -> {
                    val oldScale = java.lang.Float.intBitsToFloat(msg.arg1)
                    val newScale = java.lang.Float.intBitsToFloat(msg.arg2)
                    mContentsClient.onScaleChangedScaled(oldScale, newScale)
                }

                MSG_ON_RECEIVED_HTTP_ERROR -> {
                    val info = msg.obj as OnReceivedHttpErrorInfo
                    mContentsClient.onReceivedHttpError(info.mRequest, info.mResponse)
                }

                MSG_ON_PAGE_FINISHED -> {
                    val url = msg.obj as String
                    mContentsClient.onPageFinished(url)
                }

                MSG_ON_RECEIVED_TITLE -> {
                    val title = msg.obj as String
                    mContentsClient.onReceivedTitle(title)
                }

                MSG_ON_PROGRESS_CHANGED -> {
                    mContentsClient.onProgressChanged(msg.arg1)
                }

                MSG_SYNTHESIZE_PAGE_LOADING -> {
                    val url = msg.obj as String
                    mContentsClient.onPageStarted(url)
                    mContentsClient.onLoadResource(url)
                    mContentsClient.onProgressChanged(100)
                    mContentsClient.onPageFinished(url)
                }

                MSG_DO_UPDATE_VISITED_HISTORY -> {
                    val info = msg.obj as DoUpdateVisitedHistoryInfo
                    mContentsClient.doUpdateVisitedHistory(info.mUrl, info.mIsReload)
                }

                MSG_ON_FORM_RESUBMISSION -> {
                    val info = msg.obj as OnFormResubmissionInfo
                    mContentsClient.onFormResubmission(info.mDontResend, info.mResend)
                }

                else -> throw IllegalStateException(
                    "AwContentsClientCallbackHelper: unhandled message " + msg.what
                )
            }
        }
    }

    init {
        mHandler = MyHandler(looper)
        mContentsClient = contentsClient
    }

    fun postOnLoadResource(url: String?) {
        mHandler.sendMessage(mHandler.obtainMessage(MSG_ON_LOAD_RESOURCE, url))
    }

    fun postOnPageStarted(url: String?) {
        mHandler.sendMessage(mHandler.obtainMessage(MSG_ON_PAGE_STARTED, url))
    }

    fun postOnDownloadStart(
        url: String, userAgent: String, contentDisposition: String,
        mimeType: String, contentLength: Long
    ) {
        val info = DownloadInfo(
            url, userAgent, contentDisposition, mimeType,
            contentLength
        )
        mHandler.sendMessage(mHandler.obtainMessage(MSG_ON_DOWNLOAD_START, info))
    }

    fun postOnReceivedLoginRequest(realm: String, account: String, args: String) {
        val info = LoginRequestInfo(realm, account, args)
        mHandler.sendMessage(mHandler.obtainMessage(MSG_ON_RECEIVED_LOGIN_REQUEST, info))
    }

    fun postOnReceivedError(
        request: AwWebResourceRequest,
        error: AwWebResourceError
    ) {
        val info = OnReceivedErrorInfo(request, error)
        mHandler.sendMessage(mHandler.obtainMessage(MSG_ON_RECEIVED_ERROR, info))
    }

    fun postOnSafeBrowsingHit(
        request: AwWebResourceRequest, threatType: Int,
        callback: Callback<AwSafeBrowsingResponse?>
    ) {
        val info = OnSafeBrowsingHitInfo(request, threatType, callback)
        mHandler.sendMessage(mHandler.obtainMessage(MSG_ON_SAFE_BROWSING_HIT, info))
    }

    fun postOnNewPicture(pictureProvider: Callable<Picture?>?) {
        if (mHasPendingOnNewPicture) return
        mHasPendingOnNewPicture = true
        val pictureTime = max(
            mLastPictureTime + ON_NEW_PICTURE_MIN_PERIOD_MILLIS,
            SystemClock.uptimeMillis()
        )
        mHandler.sendMessageAtTime(
            mHandler.obtainMessage(MSG_ON_NEW_PICTURE, pictureProvider),
            pictureTime
        )
    }

    fun postOnScaleChangedScaled(oldScale: Float, newScale: Float) {
        // The float->int->float conversion here is to avoid unnecessary allocations. The
        // documentation states that intBitsToFloat(floatToIntBits(a)) == a for all values of a
        // (except for NaNs which are collapsed to a single canonical NaN, but we don't care for
        // that case).
        mHandler.sendMessage(
            mHandler.obtainMessage(
                MSG_ON_SCALE_CHANGED_SCALED,
                java.lang.Float.floatToIntBits(oldScale), java.lang.Float.floatToIntBits(newScale)
            )
        )
    }

    fun postOnReceivedHttpError(
        request: AwWebResourceRequest, response: WebResourceResponseInfo
    ) {
        val info = OnReceivedHttpErrorInfo(request, response)
        mHandler.sendMessage(mHandler.obtainMessage(MSG_ON_RECEIVED_HTTP_ERROR, info))
    }

    fun postOnPageFinished(url: String?) {
        mHandler.sendMessage(mHandler.obtainMessage(MSG_ON_PAGE_FINISHED, url))
    }

    fun postOnReceivedTitle(title: String?) {
        mHandler.sendMessage(mHandler.obtainMessage(MSG_ON_RECEIVED_TITLE, title))
    }

    fun postOnProgressChanged(progress: Int) {
        mHandler.sendMessage(mHandler.obtainMessage(MSG_ON_PROGRESS_CHANGED, progress, 0))
    }

    fun postSynthesizedPageLoadingForUrlBarUpdate(url: String?) {
        mHandler.sendMessage(mHandler.obtainMessage(MSG_SYNTHESIZE_PAGE_LOADING, url))
    }

    fun postDoUpdateVisitedHistory(url: String, isReload: Boolean) {
        val info = DoUpdateVisitedHistoryInfo(url, isReload)
        mHandler.sendMessage(mHandler.obtainMessage(MSG_DO_UPDATE_VISITED_HISTORY, info))
    }

    fun postOnFormResubmission(dontResend: Message, resend: Message) {
        val info = OnFormResubmissionInfo(dontResend, resend)
        mHandler.sendMessage(mHandler.obtainMessage(MSG_ON_FORM_RESUBMISSION, info))
    }

    fun removeCallbacksAndMessages() {
        mHandler.removeCallbacksAndMessages(null)
    }

    companion object {
        private const val MSG_ON_LOAD_RESOURCE = 1
        private const val MSG_ON_PAGE_STARTED = 2
        private const val MSG_ON_DOWNLOAD_START = 3
        private const val MSG_ON_RECEIVED_LOGIN_REQUEST = 4
        private const val MSG_ON_RECEIVED_ERROR = 5
        private const val MSG_ON_NEW_PICTURE = 6
        private const val MSG_ON_SCALE_CHANGED_SCALED = 7
        private const val MSG_ON_RECEIVED_HTTP_ERROR = 8
        private const val MSG_ON_PAGE_FINISHED = 9
        private const val MSG_ON_RECEIVED_TITLE = 10
        private const val MSG_ON_PROGRESS_CHANGED = 11
        private const val MSG_SYNTHESIZE_PAGE_LOADING = 12
        private const val MSG_DO_UPDATE_VISITED_HISTORY = 13
        private const val MSG_ON_FORM_RESUBMISSION = 14
        private const val MSG_ON_SAFE_BROWSING_HIT = 15

        // Minimum period allowed between consecutive onNewPicture calls, to rate-limit the callbacks.
        private const val ON_NEW_PICTURE_MIN_PERIOD_MILLIS: Long = 500
    }
}