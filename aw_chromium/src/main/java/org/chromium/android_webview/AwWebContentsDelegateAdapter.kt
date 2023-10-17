// Copyright 2013 The Chromium Authors. All rights reserved.
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.
package org.chromium.android_webview

import android.annotation.SuppressLint
import android.content.Context
import android.media.AudioManager
import android.net.Uri
import android.os.Handler
import android.os.Message
import android.provider.MediaStore
import android.text.TextUtils
import android.util.Log
import android.view.KeyEvent
import android.view.View
import android.webkit.URLUtil
import android.widget.FrameLayout
import org.chromium.android_webview.AwContentsClient.FileChooserParamsImpl
import org.chromium.base.Callback
import org.chromium.base.ContentUriUtils
import org.chromium.base.ThreadUtils
import org.chromium.base.task.AsyncTask
import org.chromium.content_public.browser.InvalidateTypes
import org.chromium.content_public.common.ContentUrlConstants
import org.chromium.content_public.common.ResourceRequestBody
import org.chromium.url.GURL

/**
 * Adapts the AwWebContentsDelegate interface to the AwContentsClient interface.
 * This class also serves a secondary function of routing certain callbacks from the content layer
 * to specific listener interfaces.
 */
internal class AwWebContentsDelegateAdapter(
    private val mAwContents: AwContents, private val mContentsClient: AwContentsClient,
    private val mAwSettings: AwSettings?, private val mContext: Context, containerView: View?
) : AwWebContentsDelegate() {
    private var mContainerView: View? = null
    private var mCustomView: FrameLayout? = null

    init {
        setContainerView(containerView)
    }

    fun setContainerView(containerView: View?) {
        mContainerView = containerView
        mContainerView!!.isClickable = true
    }

    override fun handleKeyboardEvent(event: KeyEvent) {
        if (event.action == KeyEvent.ACTION_DOWN) {
            val direction: Int = when (event.keyCode) {
                KeyEvent.KEYCODE_DPAD_DOWN -> View.FOCUS_DOWN
                KeyEvent.KEYCODE_DPAD_UP -> View.FOCUS_UP
                KeyEvent.KEYCODE_DPAD_LEFT -> View.FOCUS_LEFT
                KeyEvent.KEYCODE_DPAD_RIGHT -> View.FOCUS_RIGHT
                else -> 0
            }
            if (direction != 0 && tryToMoveFocus(direction)) return
        }
        handleMediaKey(event)
        mContentsClient.onUnhandledKeyEvent(event)
    }

    /**
     * Redispatches unhandled media keys. This allows bluetooth headphones with play/pause or
     * other buttons to function correctly.
     */
    private fun handleMediaKey(e: KeyEvent) {
        when (e.keyCode) {
            KeyEvent.KEYCODE_MUTE, KeyEvent.KEYCODE_HEADSETHOOK, KeyEvent.KEYCODE_MEDIA_PLAY, KeyEvent.KEYCODE_MEDIA_PAUSE, KeyEvent.KEYCODE_MEDIA_PLAY_PAUSE, KeyEvent.KEYCODE_MEDIA_STOP, KeyEvent.KEYCODE_MEDIA_NEXT, KeyEvent.KEYCODE_MEDIA_PREVIOUS, KeyEvent.KEYCODE_MEDIA_REWIND, KeyEvent.KEYCODE_MEDIA_RECORD, KeyEvent.KEYCODE_MEDIA_FAST_FORWARD, KeyEvent.KEYCODE_MEDIA_CLOSE, KeyEvent.KEYCODE_MEDIA_EJECT, KeyEvent.KEYCODE_MEDIA_AUDIO_TRACK -> {
                val am = mContext.getSystemService(Context.AUDIO_SERVICE) as AudioManager
                am.dispatchMediaKeyEvent(e)
            }

            else -> {}
        }
    }

    override fun takeFocus(reverse: Boolean): Boolean {
        var direction =
            if (reverse == (mContainerView!!.layoutDirection == View.LAYOUT_DIRECTION_RTL)) View.FOCUS_RIGHT else View.FOCUS_LEFT
        if (tryToMoveFocus(direction)) return true
        direction = if (reverse) View.FOCUS_BACKWARD else View.FOCUS_FORWARD
        return tryToMoveFocus(direction)
    }

    private fun tryToMoveFocus(direction: Int): Boolean {
        val focus = mContainerView!!.focusSearch(direction)
        return focus != null && focus !== mContainerView && focus.requestFocus()
    }

    override fun addMessageToConsole(
        level: Int, message: String, lineNumber: Int,
        sourceId: String
    ): Boolean {
        @AwConsoleMessage.MessageLevel var messageLevel =
            AwConsoleMessage.MESSAGE_LEVEL_DEBUG
        when (level) {
            LOG_LEVEL_TIP -> messageLevel =
                AwConsoleMessage.MESSAGE_LEVEL_TIP

            LOG_LEVEL_LOG -> messageLevel =
                AwConsoleMessage.MESSAGE_LEVEL_LOG

            LOG_LEVEL_WARNING -> messageLevel =
                AwConsoleMessage.MESSAGE_LEVEL_WARNING

            LOG_LEVEL_ERROR -> messageLevel =
                AwConsoleMessage.MESSAGE_LEVEL_ERROR

            else -> Log.w(
                TAG,
                "Unknown message level, defaulting to DEBUG"
            )
        }
        return mContentsClient.onConsoleMessage(
            AwConsoleMessage(message, messageLevel)
        )
    }

    override fun onUpdateUrl(url: GURL) {
        // TODO: implement
    }

    override fun openNewTab(
        url: GURL, extraHeaders: String, postData: ResourceRequestBody,
        disposition: Int, isRendererInitiated: Boolean
    ) {
        // This is only called in chrome layers.
        assert(false)
    }

    override fun closeContents() {
        mContentsClient.onCloseWindow()
    }

    @SuppressLint("HandlerLeak")
    override fun showRepostFormWarningDialog() {
        // TODO(mkosiba) We should be using something akin to the JsResultReceiver as the
        // callback parameter (instead of WebContents) and implement a way of converting
        // that to a pair of messages.
        val msgContinuePendingReload = 1
        val msgCancelPendingReload = 2

        // TODO(sgurun) Remember the URL to cancel the reload behavior
        // if it is different than the most recent NavigationController entry.
        val handler: Handler = object : Handler(ThreadUtils.getUiThreadLooper()) {
            @SuppressLint("VisibleForTests")
            override fun handleMessage(msg: Message) {
                if (mAwContents.navigationController == null) return
                when (msg.what) {
                    msgContinuePendingReload -> {
                        mAwContents.navigationController.continuePendingReload()
                    }

                    msgCancelPendingReload -> {
                        mAwContents.navigationController.cancelPendingReload()
                    }

                    else -> throw IllegalStateException(
                        "WebContentsDelegateAdapter: unhandled message " + msg.what
                    )
                }
            }
        }
        val resend = handler.obtainMessage(msgContinuePendingReload)
        val dontResend = handler.obtainMessage(msgCancelPendingReload)
        mContentsClient.callbackHelper!!.postOnFormResubmission(dontResend, resend)
    }

    override fun runFileChooser(
        processId: Int, renderId: Int, modeFlags: Int,
        acceptTypes: String?, title: String?, defaultFilename: String?, capture: Boolean
    ) {
        val params = FileChooserParamsImpl(
            modeFlags, title.toString()
        )
        mContentsClient.showFileChooser(object : Callback<Array<String?>?> {
            var mCompleted = false
            @SuppressLint("VisibleForTests")
            override fun onResult(results: Array<String?>?) {
                check(!mCompleted) { "Duplicate showFileChooser result" }
                mCompleted = true
                if (results == null) {
                    AwWebContentsDelegateJni.get().filesSelectedInChooser(
                        processId, renderId, modeFlags, null, null
                    )
                    return
                }
                val task = GetDisplayNameTask(mContext, processId, renderId, modeFlags, results)
                task.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR)
            }
        }, params)
    }
    override fun addNewContents(isDialog: Boolean, isUserGesture: Boolean): Boolean {
        return mContentsClient.onCreateWindow(isDialog, isUserGesture)
    }

    override fun activateContents() {
        mContentsClient.onRequestFocus()
    }

    override fun navigationStateChanged(flags: Int) {
        if (flags and InvalidateTypes.URL != 0 && mAwContents.isPopupWindow
            && mAwContents.hasAccessedInitialDocument()
        ) {
            // Hint the client to show the last committed url, as it may be unsafe to show
            // the pending entry.
            var url = mAwContents.lastCommittedUrl
            url = if (TextUtils.isEmpty(url)) ContentUrlConstants.ABOUT_BLANK_DISPLAY_URL else url
            mContentsClient.callbackHelper!!.postSynthesizedPageLoadingForUrlBarUpdate(url)
        }
    }

    override fun enterFullscreenModeForTab(prefersNavigationBar: Boolean) {
        enterFullscreen()
    }

    override fun exitFullscreenModeForTab() {
        exitFullscreen()
    }

    override fun getDisplayMode(): Int {
        return mAwContents.displayMode
    }

    override fun loadingStateChanged() {
        mContentsClient.updateTitle(mAwContents.title, false)
    }

    /**
     * Called to show the web contents in fullscreen mode.
     *
     *
     * If entering fullscreen on a video element the web contents will contain just
     * the html5 video controls. [.enterFullscreenVideo] will be called later
     * once the ContentVideoView, which contains the hardware accelerated fullscreen video,
     * is ready to be shown.
     */
    private fun enterFullscreen() {
        if (mAwContents.isFullScreen) {
            return
        }
        val fullscreenView = mAwContents.enterFullScreen() ?: return
        val cb = object : AwContentsClient.CustomViewCallback {
            override fun onCustomViewHidden() {
                if (mCustomView != null) {
                    mAwContents.requestExitFullscreen()
                }
            }
        }
        mCustomView = FrameLayout(mContext)
        mCustomView!!.addView(fullscreenView)
        mContentsClient.onShowCustomView(mCustomView, cb)
    }

    /**
     * Called to show the web contents in embedded mode.
     */
    private fun exitFullscreen() {
        if (mCustomView != null) {
            mCustomView = null
            mAwContents.exitFullScreen()
            mContentsClient.onHideCustomView()
        }
    }

    override fun shouldBlockMediaRequest(url: GURL): Boolean {
        return mAwSettings == null || mAwSettings.blockNetworkLoads && URLUtil.isNetworkUrl(url.spec)
    }

    private class GetDisplayNameTask(
        // The task doesn't run long, so we don't gain anything from a weak ref.
        @field:SuppressLint("StaticFieldLeak") val mContext: Context,
        val mProcessId: Int,
        val mRenderId: Int,
        val mModeFlags: Int,
        val mFilePaths: Array<String?>
    ) : AsyncTask<Array<String?>?>() {
        override fun doInBackground(): Array<String?> {
            val displayNames = arrayOfNulls<String>(mFilePaths.size)
            for (i in mFilePaths.indices) {
                displayNames[i] = resolveFileName(mFilePaths[i])
            }
            return displayNames
        }

        @SuppressLint("VisibleForTests")
        override fun onPostExecute(result: Array<String?>?) {
            AwWebContentsDelegateJni.get().filesSelectedInChooser(
                mProcessId, mRenderId, mModeFlags, mFilePaths, result
            )
        }

        /**
         * @return the display name of a path if it is a content URI and is present in the database
         * or an empty string otherwise.
         */
        private fun resolveFileName(filePath: String?): String {
            if (filePath == null) return ""
            val uri = Uri.parse(filePath)
            return ContentUriUtils.getDisplayName(
                uri, mContext, MediaStore.MediaColumns.DISPLAY_NAME
            )
        }
    }

    companion object {
        private const val TAG = "AwWebContentsDelegateAdapter"
    }
}