// Copyright 2019 The Chromium Authors. All rights reserved.
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.
package org.chromium.url

import android.os.SystemClock
import android.text.TextUtils
import org.chromium.base.Log
import org.chromium.base.ThreadUtils
import org.chromium.base.annotations.CalledByNative
import org.chromium.base.annotations.JNINamespace
import org.chromium.base.annotations.MainDex
import org.chromium.base.annotations.NativeMethods
import org.chromium.base.library_loader.LibraryLoader
import org.chromium.base.metrics.RecordHistogram
import org.chromium.base.task.PostTask
import org.chromium.base.task.TaskTraits
import java.util.Random

/**
 * An immutable Java wrapper for GURL, Chromium's URL parsing library.
 *
 * This class is safe to use during startup, but will block on the native library being sufficiently
 * loaded to use native GURL (and will not wait for content initialization). In practice it's very
 * unlikely that this will actually block startup unless used extremely early, in which case you
 * should probably seek an alternative solution to using GURL.
 *
 * The design of this class avoids destruction/finalization by caching all values necessary to
 * reconstruct a GURL in Java, allowing it to be much faster in the common case and easier to use.
 */
@JNINamespace("url")
@MainDex
open class GURL {
    fun interface ReportDebugThrowableCallback {
        fun run(throwable: Throwable?)
    }

    /**
     * See native GURL::possibly_invalid_spec().
     */
    // TODO(https://crbug.com/1039841): Right now we return a new String with each request for a
    //      GURL component other than the spec itself. Should we cache return Strings (as
    //      WeakReference?) so that callers can share String memory?
    var possiblyInvalidSpec: String? = null
        private set

    /**
     * See native GURL::is_valid().
     */
    var isValid = false
        private set
    private var mParsed: Parsed? = null

    private object Holder {
        val sEmptyGURL = GURL("")
    }

    /**
     * Create a new GURL.
     *
     * @param uri The string URI representation to parse into a GURL.
     */
    constructor(uri: String?) {
        // Avoid a jni hop (and initializing the native library) for empty GURLs.
        if (TextUtils.isEmpty(uri)) {
            possiblyInvalidSpec = ""
            mParsed = Parsed.createEmpty()
            return
        }
        ensureNativeInitializedForGURL()
        GURLJni.get()!!.init(uri, this)
    }

    @CalledByNative
    protected constructor()

    @CalledByNative
    private fun init(spec: String?, isValid: Boolean, parsed: Parsed) {
        possiblyInvalidSpec = spec
        assert(possiblyInvalidSpec!!.matches("\\A\\p{ASCII}*\\z".toRegex()))
        this.isValid = isValid
        mParsed = parsed
    }

    @CalledByNative
    private fun toNativeGURL(): Long {
        return GURLJni.get()!!
            .createNative(possiblyInvalidSpec, isValid, mParsed!!.toNativeParsed())
    }

    val spec: String?
        /**
         * See native GURL::spec().
         */
        get() {
            if (isValid || possiblyInvalidSpec!!.isEmpty()) return possiblyInvalidSpec
            assert(false) { "Trying to get the spec of an invalid URL!" }
            return ""
        }
    val validSpecOrEmpty: String?
        /**
         * @return Either a valid Spec (see [.getSpec]), or an empty string.
         */
        get() = if (isValid) possiblyInvalidSpec else ""

    private fun getComponent(begin: Int, length: Int): String {
        return if (length <= 0) "" else possiblyInvalidSpec!!.substring(begin, begin + length)
    }

    val scheme: String
        /**
         * See native GURL::scheme().
         */
        get() = getComponent(mParsed!!.mSchemeBegin, mParsed!!.mSchemeLength)
    val username: String
        /**
         * See native GURL::username().
         */
        get() = getComponent(mParsed!!.mUsernameBegin, mParsed!!.mUsernameLength)
    val password: String
        /**
         * See native GURL::password().
         */
        get() = getComponent(mParsed!!.mPasswordBegin, mParsed!!.mPasswordLength)
    val host: String
        /**
         * See native GURL::host().
         */
        get() = getComponent(mParsed!!.mHostBegin, mParsed!!.mHostLength)
    val port: String
        /**
         * See native GURL::port().
         *
         * Note: Do not convert this to an integer yourself. See native GURL::IntPort().
         */
        get() = getComponent(mParsed!!.mPortBegin, mParsed!!.mPortLength)
    val path: String
        /**
         * See native GURL::path().
         */
        get() = getComponent(mParsed!!.mPathBegin, mParsed!!.mPathLength)
    val query: String
        /**
         * See native GURL::query().
         */
        get() = getComponent(mParsed!!.mQueryBegin, mParsed!!.mQueryLength)
    val ref: String
        /**
         * See native GURL::ref().
         */
        get() = getComponent(mParsed!!.mRefBegin, mParsed!!.mRefLength)
    val isEmpty: Boolean
        /**
         * @return Whether the GURL is the empty String.
         */
        get() = possiblyInvalidSpec!!.isEmpty()
    open val origin: GURL
        /**
         * See native GURL::GetOrigin().
         */
        get() {
            val target = GURL()
            getOriginInternal(target)
            return target
        }

    protected fun getOriginInternal(target: GURL?) {
        GURLJni.get()!!
            .getOrigin(possiblyInvalidSpec, isValid, mParsed!!.toNativeParsed(), target)
    }

    /**
     * See native GURL::DomainIs().
     */
    fun domainIs(domain: String?): Boolean {
        return GURLJni.get()!!
            .domainIs(possiblyInvalidSpec, isValid, mParsed!!.toNativeParsed(), domain)
    }

    override fun hashCode(): Int {
        return possiblyInvalidSpec.hashCode()
    }

    override fun equals(other: Any?): Boolean {
        if (other === this) return true
        return if (other !is GURL) false else possiblyInvalidSpec == other.possiblyInvalidSpec
    }

    /**
     * Serialize a GURL to a String, to be used with [GURL.deserialize].
     *
     * Note that a serialized GURL should only be used internally to Chrome, and should *never* be
     * used if coming from an untrusted source.
     *
     * @return A serialzed GURL.
     */
    fun serialize(): String {
        val serialization = SERIALIZER_VERSION.toString() + SERIALIZER_DELIMITER +
                isValid + SERIALIZER_DELIMITER +
                mParsed!!.serialize() + SERIALIZER_DELIMITER +
                possiblyInvalidSpec
        return serialization.length.toString() + SERIALIZER_DELIMITER + serialization
    }

    @NativeMethods
    internal interface Natives {
        /**
         * Initializes the provided |target| by parsing the provided |uri|.
         */
        fun init(uri: String?, target: GURL?)

        /**
         * Reconstructs the native GURL for this Java GURL and initializes |target| with its Origin.
         */
        fun getOrigin(spec: String?, isValid: Boolean, nativeParsed: Long, target: GURL?)

        /**
         * Reconstructs the native GURL for this Java GURL, and calls GURL.DomainIs.
         */
        fun domainIs(spec: String?, isValid: Boolean, nativeParsed: Long, domain: String?): Boolean

        /**
         * Reconstructs the native GURL for this Java GURL, returning its native pointer.
         */
        fun createNative(spec: String?, isValid: Boolean, nativeParsed: Long): Long
    }

    companion object {
        private const val TAG = "GURL"

        /* package */
        const val SERIALIZER_VERSION = 1

        /* package */
        const val SERIALIZER_DELIMITER = '\u0000'

        // Right now this is only collecting reports on Canary which has a relatively small population.
        private const val DEBUG_REPORT_PERCENTAGE = 10
        private var sReportCallback: ReportDebugThrowableCallback? = null
        @JvmStatic
        @CalledByNative
        fun emptyGURL(): GURL {
            return Holder.sEmptyGURL
        }

        /**
         * Enables debug stack trace gathering for GURL.
         */
        fun setReportDebugThrowableCallback(callback: ReportDebugThrowableCallback?) {
            sReportCallback = callback
        }

        /**
         * Ensures that the native library is sufficiently loaded for GURL usage.
         *
         * This function is public so that GURL-related usage like the UrlFormatter also counts towards
         * the "Startup.Android.GURLEnsureMainDexInitialized" histogram.
         */
        @JvmStatic
        fun ensureNativeInitializedForGURL() {
            if (LibraryLoader.getInstance().isInitialized) return
            val time = SystemClock.elapsedRealtime()
            LibraryLoader.getInstance().ensureMainDexInitialized()
            // Record metrics only for the UI thread where the delay in loading the library is relevant.
            if (ThreadUtils.runningOnUiThread()) {
                RecordHistogram.recordTimesHistogram(
                    "Startup.Android.GURLEnsureMainDexInitialized",
                    SystemClock.elapsedRealtime() - time
                )
                if (sReportCallback != null && Random().nextInt(100) < DEBUG_REPORT_PERCENTAGE) {
                    val throwable =
                        Throwable("This is not a crash, please ignore. See crbug.com/1065377.")
                    // This isn't an assert, because by design this is possible, but we would prefer
                    // this path does not get hit more than necessary and getting stack traces from the
                    // wild will help find issues.
                    PostTask.postTask(
                        TaskTraits.BEST_EFFORT_MAY_BLOCK
                    ) { sReportCallback!!.run(throwable) }
                }
            }
        }

        /** @return true if the GURL is null, empty, or invalid.
         */
        @JvmStatic
        fun isEmptyOrInvalid(gurl: GURL?): Boolean {
            return gurl == null || gurl.isEmpty || !gurl.isValid
        }

        /**
         * Deserialize a GURL serialized with [GURL.serialize].
         *
         * This function should *never* be used on a String coming from an untrusted source.
         *
         * @return The deserialized GURL (or null if the input is empty).
         */
        fun deserialize(gurl: String?): GURL {
            return try {
                if (TextUtils.isEmpty(gurl)) return emptyGURL()
                val tokens = gurl!!.split(SERIALIZER_DELIMITER.toString().toRegex())
                    .dropLastWhile { it.isEmpty() }
                    .toTypedArray()

                // First token MUST always be the length of the serialized data.
                val length = tokens[0]
                require(gurl.length == length.toInt() + length.length + 1) { "Serialized GURL had the wrong length." }

                // Last token MUST always be the original spec - just re-parse the GURL on version
                // changes.
                var spec = tokens[tokens.size - 1]
                // Special case for empty spec - it won't get its own token.
                if (gurl.endsWith(SERIALIZER_DELIMITER.toString())) spec = ""

                // Second token MUST always be the version number.
                val version = tokens[1].toInt()
                if (version != SERIALIZER_VERSION) return GURL(spec)
                val isValid = java.lang.Boolean.parseBoolean(tokens[2])
                val parsed: Parsed = Parsed.deserialize(tokens, 3)
                val result = GURL()
                result.init(spec, isValid, parsed)
                result
            } catch (e: Exception) {
                // This is unexpected, maybe the storage got corrupted somehow?
                Log.w(TAG, "Exception while deserializing a GURL: $gurl", e)
                emptyGURL()
            }
        }
    }
}