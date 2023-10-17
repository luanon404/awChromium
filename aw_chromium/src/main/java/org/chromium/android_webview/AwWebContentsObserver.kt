// Copyright 2014 The Chromium Authors. All rights reserved.
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.
package org.chromium.android_webview

import org.chromium.base.task.PostTask
import org.chromium.content_public.browser.NavigationHandle
import org.chromium.content_public.browser.UiThreadTaskTraits
import org.chromium.content_public.browser.WebContents
import org.chromium.content_public.browser.WebContentsObserver
import org.chromium.content_public.common.ContentUrlConstants
import org.chromium.net.NetError
import org.chromium.ui.base.PageTransition
import org.chromium.url.GURL
import java.lang.ref.WeakReference
import kotlin.math.roundToInt

/**
 * Routes notifications from WebContents to AwContentsClient and other listeners.
 */
class AwWebContentsObserver(
    webContents: WebContents?, awContents: AwContents, awContentsClient: AwContentsClient
) : WebContentsObserver(webContents) {
    // TODO(tobiasjs) similarly to WebContentsObserver.mWebContents, mAwContents
    // needs to be a WeakReference, which suggests that there exists a strong
    // reference to an AwWebContentsObserver instance. This is not intentional,
    // and should be found and cleaned up.
    private val mAwContents: WeakReference<AwContents>
    private val mAwContentsClient: WeakReference<AwContentsClient>

    // Whether this webcontents has ever committed any navigation.
    private var mCommittedNavigation = false

    // Temporarily stores the URL passed the last time to didFinishLoad callback.
    private var mLastDidFinishLoadUrl: String? = null

    init {
        mAwContents = WeakReference(awContents)
        mAwContentsClient = WeakReference(awContentsClient)
    }

    private fun getClientIfNeedToFireCallback(validatedUrl: String?): AwContentsClient? {
        val client = mAwContentsClient.get()
        if (client != null) {
            val unreachableWebDataUrl = AwContentsStatics.getUnreachableWebDataUrl()
            if (unreachableWebDataUrl == null || unreachableWebDataUrl != validatedUrl) {
                return client
            }
        }
        return null
    }

    override fun didFinishLoad(
        frameId: Long,
        url: GURL,
        isKnownValid: Boolean,
        isMainFrame: Boolean
    ) {
        val validatedUrl = if (isKnownValid) url.spec else url.possiblyInvalidSpec
        if (isMainFrame && getClientIfNeedToFireCallback(validatedUrl) != null) {
            mLastDidFinishLoadUrl = validatedUrl
        }
    }

    override fun didStopLoading(gurl: GURL, isKnownValid: Boolean) {
        var url = if (isKnownValid) gurl.spec else gurl.possiblyInvalidSpec
        if (url!!.isEmpty()) url = ContentUrlConstants.ABOUT_BLANK_DISPLAY_URL
        val client = getClientIfNeedToFireCallback(url)
        if (client != null && url == mLastDidFinishLoadUrl) {
            client.callbackHelper!!.postOnPageFinished(url)
            mLastDidFinishLoadUrl = null
        }
    }

    override fun loadProgressChanged(progress: Float) {
        val client = mAwContentsClient.get() ?: return
        client.callbackHelper!!.postOnProgressChanged((progress * 100).roundToInt())
    }

    override fun didFailLoad(isMainFrame: Boolean, @NetError errorCode: Int, failingGurl: GURL) {
        val failingUrl = failingGurl.possiblyInvalidSpec
        val client = mAwContentsClient.get() ?: return
        val unreachableWebDataUrl = AwContentsStatics.getUnreachableWebDataUrl()
        val isErrorUrl = unreachableWebDataUrl != null && unreachableWebDataUrl == failingUrl
        if (isMainFrame && !isErrorUrl) {
            if (errorCode == NetError.ERR_ABORTED) {
                // Need to call onPageFinished for backwards compatibility with the classic webview.
                // See also AwContentsClientBridge.onReceivedError.
                client.callbackHelper!!.postOnPageFinished(failingUrl)
            } else if (errorCode == NetError.ERR_HTTP_RESPONSE_CODE_FAILURE) {
                // This is a HTTP error that results in an error page. We need to call onPageStarted
                // and onPageFinished to have the same behavior with HTTP error navigations that
                // don't result in an error page. See also
                // AwContentsClientBridge.onReceivedHttpError.
                client.callbackHelper!!.postOnPageStarted(failingUrl)
                client.callbackHelper!!.postOnPageFinished(failingUrl)
            }
        }
    }

    override fun titleWasSet(title: String) {
        val client = mAwContentsClient.get() ?: return
        client.updateTitle(title, true)
    }

    override fun didFinishNavigation(navigation: NavigationHandle) {
        val url = navigation.url.possiblyInvalidSpec
        if (navigation.errorCode() != NetError.OK && !navigation.isDownload) {
            didFailLoad(navigation.isInMainFrame, navigation.errorCode(), navigation.url)
        }
        if (!navigation.hasCommitted()) return
        mCommittedNavigation = true
        if (!navigation.isInMainFrame) return
        val client = mAwContentsClient.get()
        if (client != null) {
            // OnPageStarted is not called for in-page navigations, which include fragment
            // navigations and navigation from history.push/replaceState.
            // Error page is handled by AwContentsClientBridge.onReceivedError.
            if (!navigation.isSameDocument && !navigation.isErrorPage
                && AwFeatureList.pageStartedOnCommitEnabled(navigation.isRendererInitiated)
            ) {
                client.callbackHelper!!.postOnPageStarted(url)
            }
            val isReload = (navigation.pageTransition() != null
                    && (navigation.pageTransition() and PageTransition.CORE_MASK
                    == PageTransition.RELOAD))
            client.callbackHelper!!.postDoUpdateVisitedHistory(url!!, isReload)
        }

        // Only invoke the onPageCommitVisible callback when navigating to a different document,
        // but not when navigating to a different fragment within the same document.
        if (!navigation.isSameDocument) {
            PostTask.postTask(UiThreadTaskTraits.DEFAULT) {
                val awContents = mAwContents.get()
                awContents?.insertVisualStateCallbackIfNotDestroyed(
                    0, object : AwContents.VisualStateCallback() {
                        override fun onComplete(requestId: Long) {
                            val client1 = mAwContentsClient.get() ?: return
                            client1.onPageCommitVisible(url)
                        }
                    })
            }
        }
        if (client != null && navigation.isFragmentNavigation) {
            // Note fragment navigations do not have a matching onPageStarted.
            client.callbackHelper!!.postOnPageFinished(url)
        }
    }

    fun didEverCommitNavigation(): Boolean {
        return mCommittedNavigation
    }
}