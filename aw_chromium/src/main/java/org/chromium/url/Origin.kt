// Copyright 2019 The Chromium Authors. All rights reserved.
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.
package org.chromium.url

import org.chromium.base.annotations.CalledByNative
import org.chromium.base.annotations.JNINamespace
import java.nio.ByteBuffer

/** An origin is either a (scheme, host, port) tuple or is opaque.  */
@JNINamespace("url")
class Origin {
    // The internal representation of the origin that should never be used directly.
    private val mInternal: org.chromium.url.internal.mojom.Origin?

    /**
     * This convenience constructor provides a way to wrap
     * `org.chromium.url.internal.mojom.Origin`s, which are provided by Mojo-generated
     * code but not intended for direct use (see crbug.com/1156866).
     *
     * @return An `Origin` providing user-friendly access to the origin represented by
     * `mojoOrigin`.
     */
    constructor(mojoOrigin: org.chromium.url.internal.mojom.Origin?) {
        mInternal = mojoOrigin
    }

    val scheme: String?
        /** @return The scheme of the origin. Returns an empty string for an opaque origin.
         */
        get() = if (!isOpaque) mInternal!!.scheme else ""
    val host: String?
        /** @return The host of the origin. Returns an empty string for an opaque origin.
         */
        get() = if (!isOpaque) mInternal!!.host else ""
    val port: Int
        /** @return The port of the origin. Returns 0 for an opaque origin.
         */
        get() = if (!isOpaque) mInternal!!.port.toInt() else 0
    val isOpaque: Boolean
        /** @return Whether the origin is opaque.
         */
        get() = mInternal!!.nonceIfOpaque != null

    /** Protected constructor, used for testing purposes only.  */
    protected constructor() {
        mInternal = null
    }

    @CalledByNative
    private constructor(byteBuffer: ByteBuffer) {
        mInternal = org.chromium.url.internal.mojom.Origin.Companion.deserialize(byteBuffer)
    }

    companion object {
        @CalledByNative
        private fun serialize(origin: Origin): ByteBuffer {
            return origin.mInternal!!.serialize()
        }
    }
}