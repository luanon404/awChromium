// Copyright 2013 The Chromium Authors. All rights reserved.
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.
package org.chromium.android_webview

import android.graphics.Bitmap
import android.util.Log
import org.chromium.base.task.PostTask
import org.chromium.base.task.TaskTraits
import org.chromium.components.embedder_support.util.WebResourceResponseInfo
import org.chromium.content_public.browser.UiThreadTaskTraits
import java.io.IOException
import java.io.InputStream
import java.io.OutputStream
import java.io.PipedInputStream
import java.io.PipedOutputStream
import java.util.Random

/**
 * This class takes advantage of shouldInterceptRequest(), returns the bitmap from
 * WebChromeClient.getDefaultVidoePoster() when the mDefaultVideoPosterURL is requested.
 *
 * The shouldInterceptRequest is used to get the default video poster, if the url is
 * the mDefaultVideoPosterURL.
 */
class DefaultVideoPosterRequestHandler(private val mContentClient: AwContentsClient) {
    val defaultVideoPosterURL: String = generateDefaulVideoPosterURL()

    /**
     * Used to get the image if the url is mDefaultVideoPosterURL.
     *
     * @param url the url requested
     * @return WebResourceResponseInfo which caller can get the image if the url is
     * the default video poster URL, otherwise null is returned.
     */
    fun shouldInterceptRequest(url: String): WebResourceResponseInfo? {
        return if (defaultVideoPosterURL != url) null else try {
            WebResourceResponseInfo("image/png", null, getInputStream(mContentClient))
        } catch (e: IOException) {
            Log.e(TAG, null, e)
            null
        }
    }

    companion object {
        @Throws(IOException::class)
        private fun getInputStream(contentClient: AwContentsClient): InputStream {
            val inputStream = PipedInputStream()
            val outputStream = PipedOutputStream(inputStream)

            // Send the request to UI thread to callback to the client, and if it provides a
            // valid bitmap bounce on to the worker thread pool to compress it into the piped
            // input/output stream.
            PostTask.runOrPostTask(UiThreadTaskTraits.DEFAULT) {
                val defaultVideoPoster: Bitmap? = contentClient.defaultVideoPoster
                if (defaultVideoPoster == null) {
                    closeOutputStream(outputStream)
                    return@runOrPostTask
                }
                PostTask.postTask(TaskTraits.BEST_EFFORT_MAY_BLOCK) {
                    try {
                        defaultVideoPoster.compress(
                            Bitmap.CompressFormat.PNG, 100,
                            outputStream
                        )
                        outputStream.flush()
                    } catch (e: IOException) {
                        Log.e(TAG, null, e)
                    } finally {
                        closeOutputStream(outputStream)
                    }
                }
            }
            return inputStream
        }

        private fun closeOutputStream(outputStream: OutputStream) {
            try {
                outputStream.close()
            } catch (e: IOException) {
                Log.e(TAG, null, e)
            }
        }

        private const val TAG = "DefaultVideoPosterRequestHandler"

        /**
         * @return a unique URL which has little chance to be used by application.
         */
        private fun generateDefaulVideoPosterURL(): String {
            val randomGenerator = Random()
            val path = randomGenerator.nextLong().toString()
            // The scheme of this URL should be kept in sync with kAndroidWebViewVideoPosterScheme
            // on the native side (see android_webview/common/url_constants.h)
            return "android-webview-video-poster:default_video_poster/$path"
        }
    }
}