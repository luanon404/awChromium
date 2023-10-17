// Copyright 2020 The Chromium Authors. All rights reserved.
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.
package org.chromium.android_webview

import android.os.Build
import android.webkit.WebViewClient
import androidx.annotation.IntDef
import androidx.annotation.RequiresApi

@RequiresApi(Build.VERSION_CODES.O)
@Retention(AnnotationRetention.SOURCE)
@IntDef(
    WebviewErrorCode.ERROR_OK,
    WebviewErrorCode.ERROR_UNKNOWN,
    WebviewErrorCode.ERROR_HOST_LOOKUP,
    WebviewErrorCode.ERROR_UNSUPPORTED_AUTH_SCHEME,
    WebviewErrorCode.ERROR_AUTHENTICATION,
    WebviewErrorCode.ERROR_PROXY_AUTHENTICATION,
    WebviewErrorCode.ERROR_CONNECT,
    WebviewErrorCode.ERROR_IO,
    WebviewErrorCode.ERROR_TIMEOUT,
    WebviewErrorCode.ERROR_REDIRECT_LOOP,
    WebviewErrorCode.ERROR_UNSUPPORTED_SCHEME,
    WebviewErrorCode.ERROR_FAILED_SSL_HANDSHAKE,
    WebviewErrorCode.ERROR_BAD_URL,
    WebviewErrorCode.ERROR_FILE,
    WebviewErrorCode.ERROR_FILE_NOT_FOUND,
    WebviewErrorCode.ERROR_TOO_MANY_REQUESTS,
    WebviewErrorCode.ERROR_UNSAFE_RESOURCE
)
annotation class WebviewErrorCode {
    companion object {
        // Success
        const val ERROR_OK = 0

        // Generic error
        const val ERROR_UNKNOWN = WebViewClient.ERROR_UNKNOWN

        // Server or proxy hostname lookup failed
        const val ERROR_HOST_LOOKUP = WebViewClient.ERROR_HOST_LOOKUP

        // Unsupported authentication scheme (not basic or digest)
        const val ERROR_UNSUPPORTED_AUTH_SCHEME = WebViewClient.ERROR_UNSUPPORTED_AUTH_SCHEME

        // User authentication failed on server
        const val ERROR_AUTHENTICATION = WebViewClient.ERROR_AUTHENTICATION

        // User authentication failed on proxy
        const val ERROR_PROXY_AUTHENTICATION = WebViewClient.ERROR_PROXY_AUTHENTICATION

        // Failed to connect to the server
        const val ERROR_CONNECT = WebViewClient.ERROR_CONNECT

        // Failed to read or write to the server
        const val ERROR_IO = WebViewClient.ERROR_IO

        // Connection timed out
        const val ERROR_TIMEOUT = WebViewClient.ERROR_TIMEOUT

        // Too many redirects
        const val ERROR_REDIRECT_LOOP = WebViewClient.ERROR_REDIRECT_LOOP

        // Unsupported URI scheme
        const val ERROR_UNSUPPORTED_SCHEME = WebViewClient.ERROR_UNSUPPORTED_SCHEME

        // Failed to perform SSL handshake
        const val ERROR_FAILED_SSL_HANDSHAKE = WebViewClient.ERROR_FAILED_SSL_HANDSHAKE

        // Malformed URL
        const val ERROR_BAD_URL = WebViewClient.ERROR_BAD_URL

        // Generic file error
        const val ERROR_FILE = WebViewClient.ERROR_FILE

        // File not found
        const val ERROR_FILE_NOT_FOUND = WebViewClient.ERROR_FILE_NOT_FOUND

        // Too many requests during this load
        const val ERROR_TOO_MANY_REQUESTS = WebViewClient.ERROR_TOO_MANY_REQUESTS

        // Request was identified as a bad url by safebrowsing.
        const val ERROR_UNSAFE_RESOURCE = WebViewClient.ERROR_UNSAFE_RESOURCE
    }
}