// Copyright 2019 The Chromium Authors. All rights reserved.
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.
package org.chromium.url

import java.net.URISyntaxException

/**
 * An API shim around GURL that mostly matches the java.net.URI API.
 *
 */
@Deprecated("Please use GURL directly in new code.")
class URI : GURL {
    /**
     * Create a new GURL with a java.net.URI API shim.
     */
    constructor(uri: String?) : super(uri) {
        if (!isValid) {
            throw URISyntaxException(uri, "Uri could not be parsed as a valid GURL")
        }
    }

    private constructor()

    override val origin: GURL
        get() {
            val target = URI()
            getOriginInternal(target)
            return target
        }
    val fragment
        /** See [GURL.getRef]  */
        get() = ref
    val isAbsolute: Boolean
        /** See [java.net.URI.isAbsolute]  */
        get() = scheme.isNotEmpty()

    override fun toString(): String {
        return possiblyInvalidSpec.toString()
    }

    companion object {
        /**
         * This function is a convenience wrapper around [URI.URI], that wraps the thrown
         * thrown URISyntaxException in an IllegalArgumentException and throws that instead.
         */
        fun create(str: String?): URI {
            return try {
                URI(str)
            } catch (e: URISyntaxException) {
                throw IllegalArgumentException(e)
            }
        }
    }
}