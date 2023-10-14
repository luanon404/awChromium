// Copyright 2014 The Chromium Authors. All rights reserved.
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.
package org.chromium.url

import org.chromium.base.annotations.CalledByNative
import org.chromium.base.annotations.JNINamespace
import java.net.IDN

/**
 * This class is used to convert unicode IDN domain names to ASCII, when not
 * building with ICU.
 */
@JNINamespace("url::android")
object IDNStringUtil {
    /**
     * Attempts to convert a Unicode string to an ASCII string using IDN rules.
     * As of May 2014, the underlying Java function IDNA2003.
     * @param src String to convert.
     * @return: String containing only ASCII characters on success, null on
     * failure.
     */
    @CalledByNative
    private fun idnToASCII(src: String): String? {
        return try {
            IDN.toASCII(src, IDN.USE_STD3_ASCII_RULES)
        } catch (e: Exception) {
            null
        }
    }
}