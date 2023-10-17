// Copyright 2013 The Chromium Authors. All rights reserved.
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.
package org.chromium.android_webview

import android.net.http.SslCertificate
import android.net.http.SslError
import android.util.Log
import org.chromium.net.NetError
import org.chromium.net.X509Util
import java.security.KeyStoreException
import java.security.NoSuchAlgorithmException
import java.security.cert.CertificateException

internal object SslUtil {
    private const val TAG = "SslUtil"

    /**
     * Creates an SslError object from a chromium net error code.
     */
    @JvmStatic
    fun sslErrorFromNetErrorCode(
        @NetError error: Int, cert: SslCertificate?, url: String?
    ): SslError {
        assert(error >= NetError.ERR_CERT_END && error <= NetError.ERR_CERT_COMMON_NAME_INVALID)
        when (error) {
            NetError.ERR_CERT_COMMON_NAME_INVALID -> return SslError(
                SslError.SSL_IDMISMATCH,
                cert,
                url
            )

            NetError.ERR_CERT_DATE_INVALID -> return SslError(SslError.SSL_DATE_INVALID, cert, url)
            NetError.ERR_CERT_KNOWN_INTERCEPTION_BLOCKED, NetError.ERR_CERT_AUTHORITY_INVALID -> return SslError(
                SslError.SSL_UNTRUSTED,
                cert,
                url
            )

            else -> {}
        }
        // Map all other codes to SSL_INVALID.
        return SslError(SslError.SSL_INVALID, cert, url)
    }

    @JvmStatic
    fun getCertificateFromDerBytes(derBytes: ByteArray?): SslCertificate? {
        if (derBytes == null) {
            return null
        }
        try {
            val x509Certificate = X509Util.createCertificateFromBytes(derBytes)
            return SslCertificate(x509Certificate)
        } catch (e: CertificateException) {
            // A SSL related exception must have occurred.  This shouldn't happen.
            Log.w(TAG, "Could not read certificate: $e")
        } catch (e: KeyStoreException) {
            // A SSL related exception must have occurred.  This shouldn't happen.
            Log.w(TAG, "Could not read certificate: $e")
        } catch (e: NoSuchAlgorithmException) {
            // A SSL related exception must have occurred.  This shouldn't happen.
            Log.w(TAG, "Could not read certificate: $e")
        }
        return null
    }
}