// Copyright 2014 The Chromium Authors. All rights reserved.
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.
package org.chromium.android_webview

import java.security.PrivateKey
import java.util.Arrays

/**
 * Store user's client certificate decision for a host and port pair. Not
 * thread-safe. All accesses are done on UI thread.
 */
class ClientCertLookupTable {
    /**
     * A container for the certificate data.
     */
    class Cert(@JvmField var mPrivateKey: PrivateKey, certChain: Array<ByteArray>) {
        @JvmField
        var mCertChain: Array<ByteArray?>

        init {
            val newChain = arrayOfNulls<ByteArray>(certChain.size)
            for (i in certChain.indices) {
                newChain[i] = certChain[i].copyOf(certChain[i].size)
            }
            mCertChain = newChain
        }
    }

    private val mCerts: MutableMap<String, Cert>
    private val mDenieds: MutableSet<String>

    // Clear client certificate preferences
    fun clear() {
        mCerts.clear()
        mDenieds.clear()
    }

    init {
        mCerts = HashMap()
        mDenieds = HashSet()
    }

    fun allow(host: String, port: Int, privateKey: PrivateKey, chain: Array<ByteArray>) {
        val host_and_port = hostAndPort(host, port)
        mCerts[host_and_port] = Cert(privateKey, chain)
        mDenieds.remove(host_and_port)
    }

    fun deny(host: String, port: Int) {
        val host_and_port = hostAndPort(host, port)
        mCerts.remove(host_and_port)
        mDenieds.add(host_and_port)
    }

    fun getCertData(host: String, port: Int): Cert? {
        return mCerts[hostAndPort(host, port)]
    }

    fun isDenied(host: String, port: Int): Boolean {
        return mDenieds.contains(hostAndPort(host, port))
    }

    companion object {
        // TODO(sgurun) add a test for this. Not separating host and pair properly will be
        // a security issue.
        private fun hostAndPort(host: String, port: Int): String {
            return "$host:$port"
        }
    }
}