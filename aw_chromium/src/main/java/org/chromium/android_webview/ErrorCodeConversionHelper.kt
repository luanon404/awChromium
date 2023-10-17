// Copyright 2012 The Chromium Authors. All rights reserved.
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.
package org.chromium.android_webview

import org.chromium.net.NetError

/**
 * This is a helper class to map native error code about loading a page to Android specific ones.
 */
object ErrorCodeConversionHelper {
    @JvmStatic
    @WebviewErrorCode
    fun convertErrorCode(@NetError netError: Int): Int {
        // Note: many NetError.Error constants don't have an obvious mapping.
        // These will be handled by the default case, ERROR_UNKNOWN.
        return when (netError) {
            NetError.ERR_UNSUPPORTED_AUTH_SCHEME -> WebviewErrorCode.ERROR_UNSUPPORTED_AUTH_SCHEME
            NetError.ERR_INVALID_AUTH_CREDENTIALS, NetError.ERR_MISSING_AUTH_CREDENTIALS, NetError.ERR_MISCONFIGURED_AUTH_ENVIRONMENT -> WebviewErrorCode.ERROR_AUTHENTICATION
            NetError.ERR_TOO_MANY_REDIRECTS -> WebviewErrorCode.ERROR_REDIRECT_LOOP
            NetError.ERR_UPLOAD_FILE_CHANGED -> WebviewErrorCode.ERROR_FILE_NOT_FOUND
            NetError.ERR_INVALID_URL -> WebviewErrorCode.ERROR_BAD_URL
            NetError.ERR_DISALLOWED_URL_SCHEME, NetError.ERR_UNKNOWN_URL_SCHEME -> WebviewErrorCode.ERROR_UNSUPPORTED_SCHEME
            NetError.ERR_IO_PENDING, NetError.ERR_NETWORK_IO_SUSPENDED -> WebviewErrorCode.ERROR_IO
            NetError.ERR_CONNECTION_TIMED_OUT, NetError.ERR_TIMED_OUT -> WebviewErrorCode.ERROR_TIMEOUT
            NetError.ERR_FILE_TOO_BIG -> WebviewErrorCode.ERROR_FILE
            NetError.ERR_HOST_RESOLVER_QUEUE_TOO_LARGE, NetError.ERR_INSUFFICIENT_RESOURCES, NetError.ERR_OUT_OF_MEMORY -> WebviewErrorCode.ERROR_TOO_MANY_REQUESTS
            NetError.ERR_BLOCKED_BY_ADMINISTRATOR, NetError.ERR_CONNECTION_CLOSED, NetError.ERR_CONNECTION_RESET, NetError.ERR_CONNECTION_REFUSED, NetError.ERR_CONNECTION_ABORTED, NetError.ERR_CONNECTION_FAILED, NetError.ERR_SOCKET_NOT_CONNECTED -> WebviewErrorCode.ERROR_CONNECT
            NetError.ERR_INTERNET_DISCONNECTED, NetError.ERR_ADDRESS_INVALID, NetError.ERR_ADDRESS_UNREACHABLE, NetError.ERR_NAME_NOT_RESOLVED, NetError.ERR_NAME_RESOLUTION_FAILED, NetError.ERR_ICANN_NAME_COLLISION -> WebviewErrorCode.ERROR_HOST_LOOKUP
            NetError.ERR_SSL_PROTOCOL_ERROR, NetError.ERR_SSL_CLIENT_AUTH_CERT_NEEDED, NetError.ERR_TUNNEL_CONNECTION_FAILED, NetError.ERR_NO_SSL_VERSIONS_ENABLED, NetError.ERR_SSL_VERSION_OR_CIPHER_MISMATCH, NetError.ERR_SSL_RENEGOTIATION_REQUESTED, NetError.ERR_CERT_ERROR_IN_SSL_RENEGOTIATION, NetError.ERR_BAD_SSL_CLIENT_AUTH_CERT, NetError.ERR_SSL_NO_RENEGOTIATION, NetError.ERR_SSL_DECOMPRESSION_FAILURE_ALERT, NetError.ERR_SSL_BAD_RECORD_MAC_ALERT, NetError.ERR_SSL_CLIENT_AUTH_PRIVATE_KEY_ACCESS_DENIED, NetError.ERR_SSL_CLIENT_AUTH_CERT_NO_PRIVATE_KEY -> WebviewErrorCode.ERROR_FAILED_SSL_HANDSHAKE
            NetError.ERR_PROXY_AUTH_UNSUPPORTED, NetError.ERR_PROXY_AUTH_REQUESTED, NetError.ERR_PROXY_CONNECTION_FAILED, NetError.ERR_UNEXPECTED_PROXY_AUTH -> WebviewErrorCode.ERROR_PROXY_AUTHENTICATION
            NetError.ERR_CERT_KNOWN_INTERCEPTION_BLOCKED, NetError.ERR_CERT_COMMON_NAME_INVALID, NetError.ERR_CERT_DATE_INVALID, NetError.ERR_CERT_AUTHORITY_INVALID, NetError.ERR_CERT_CONTAINS_ERRORS, NetError.ERR_CERT_NO_REVOCATION_MECHANISM, NetError.ERR_CERT_UNABLE_TO_CHECK_REVOCATION, NetError.ERR_CERT_REVOKED, NetError.ERR_CERT_INVALID, NetError.ERR_CERT_WEAK_SIGNATURE_ALGORITHM, NetError.ERR_CERT_NON_UNIQUE_NAME -> WebviewErrorCode.ERROR_OK
            else -> WebviewErrorCode.ERROR_UNKNOWN
        }
    }
}