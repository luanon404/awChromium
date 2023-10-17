// Copyright 2019 The Chromium Authors. All rights reserved.
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.
package org.chromium.url

import org.chromium.base.annotations.CalledByNative
import org.chromium.base.annotations.JNINamespace
import org.chromium.base.annotations.MainDex
import org.chromium.base.annotations.NativeMethods

/**
 * A java wrapper for Parsed, GURL's internal parsed URI representation.
 */
@MainDex
@JNINamespace("url")
internal class Parsed @CalledByNative private constructor(/* package */
                                                          val mSchemeBegin: Int, /* package */
                                                          val mSchemeLength: Int, /* package */
                                                          val mUsernameBegin: Int, /* package */
                                                          val mUsernameLength: Int,/* package */
                                                          val mPasswordBegin: Int, /* package */
                                                          val mPasswordLength: Int, /* package */
                                                          val mHostBegin: Int, /* package */
                                                          val mHostLength: Int, /* package */
                                                          val mPortBegin: Int,/* package */
                                                          val mPortLength: Int, /* package */
                                                          val mPathBegin: Int, /* package */
                                                          val mPathLength: Int, /* package */
                                                          val mQueryBegin: Int, /* package */
                                                          val mQueryLength: Int,/* package */
                                                          val mRefBegin: Int, /* package */
                                                          val mRefLength: Int,
                                                          private val mPotentiallyDanglingMarkup: Boolean,
                                                          private val mInnerUrl: Parsed?
) {
    /* package */
    fun toNativeParsed(): Long {
        var inner: Long = 0
        if (mInnerUrl != null) {
            inner = mInnerUrl.toNativeParsed()
        }
        return ParsedJni.get()!!.createNative(
            mSchemeBegin,
            mSchemeLength,
            mUsernameBegin,
            mUsernameLength,
            mPasswordBegin,
            mPasswordLength,
            mHostBegin,
            mHostLength,
            mPortBegin,
            mPortLength,
            mPathBegin,
            mPathLength,
            mQueryBegin,
            mQueryLength,
            mRefBegin,
            mRefLength,
            mPotentiallyDanglingMarkup,
            inner
        )
    }

    /* package */
    fun serialize(): String {
        val builder = StringBuilder()
        builder.append(mSchemeBegin).append(GURL.SERIALIZER_DELIMITER)
        builder.append(mSchemeLength).append(GURL.SERIALIZER_DELIMITER)
        builder.append(mUsernameBegin).append(GURL.SERIALIZER_DELIMITER)
        builder.append(mUsernameLength).append(GURL.SERIALIZER_DELIMITER)
        builder.append(mPasswordBegin).append(GURL.SERIALIZER_DELIMITER)
        builder.append(mPasswordLength).append(GURL.SERIALIZER_DELIMITER)
        builder.append(mHostBegin).append(GURL.SERIALIZER_DELIMITER)
        builder.append(mHostLength).append(GURL.SERIALIZER_DELIMITER)
        builder.append(mPortBegin).append(GURL.SERIALIZER_DELIMITER)
        builder.append(mPortLength).append(GURL.SERIALIZER_DELIMITER)
        builder.append(mPathBegin).append(GURL.SERIALIZER_DELIMITER)
        builder.append(mPathLength).append(GURL.SERIALIZER_DELIMITER)
        builder.append(mQueryBegin).append(GURL.SERIALIZER_DELIMITER)
        builder.append(mQueryLength).append(GURL.SERIALIZER_DELIMITER)
        builder.append(mRefBegin).append(GURL.SERIALIZER_DELIMITER)
        builder.append(mRefLength).append(GURL.SERIALIZER_DELIMITER)
        builder.append(mPotentiallyDanglingMarkup).append(GURL.SERIALIZER_DELIMITER)
        builder.append(mInnerUrl != null)
        if (mInnerUrl != null) {
            builder.append(GURL.SERIALIZER_DELIMITER).append(mInnerUrl.serialize())
        }
        return builder.toString()
    }

    @NativeMethods
    internal interface Natives {
        /**
         * Create and return the pointer to a native Parsed.
         */
        fun createNative(
            schemeBegin: Int,
            schemeLength: Int,
            usernameBegin: Int,
            usernameLength: Int,
            passwordBegin: Int,
            passwordLength: Int,
            hostBegin: Int,
            hostLength: Int,
            portBegin: Int,
            portLength: Int,
            pathBegin: Int,
            pathLength: Int,
            queryBegin: Int,
            queryLength: Int,
            refBegin: Int,
            refLength: Int,
            potentiallyDanglingMarkup: Boolean,
            innerUrl: Long
        ): Long
    }

    companion object {
        /* packaged */
        fun createEmpty(): Parsed {
            return Parsed(0, -1, 0, -1, 0, -1, 0, -1, 0, -1, 0, -1, 0, -1, 0, -1, false, null)
        }

        /* package */
        fun deserialize(tokens: Array<String>, startIndex: Int): Parsed {
            /** Origin name is startIndex */
            var startIndexIncrease = startIndex
            val schemeBegin = tokens[startIndexIncrease++].toInt()
            val schemeLength = tokens[startIndexIncrease++].toInt()
            val usernameBegin = tokens[startIndexIncrease++].toInt()
            val usernameLength = tokens[startIndexIncrease++].toInt()
            val passwordBegin = tokens[startIndexIncrease++].toInt()
            val passwordLength = tokens[startIndexIncrease++].toInt()
            val hostBegin = tokens[startIndexIncrease++].toInt()
            val hostLength = tokens[startIndexIncrease++].toInt()
            val portBegin = tokens[startIndexIncrease++].toInt()
            val portLength = tokens[startIndexIncrease++].toInt()
            val pathBegin = tokens[startIndexIncrease++].toInt()
            val pathLength = tokens[startIndexIncrease++].toInt()
            val queryBegin = tokens[startIndexIncrease++].toInt()
            val queryLength = tokens[startIndexIncrease++].toInt()
            val refBegin = tokens[startIndexIncrease++].toInt()
            val refLength = tokens[startIndexIncrease++].toInt()
            val potentiallyDanglingMarkup = java.lang.Boolean.parseBoolean(tokens[startIndexIncrease++])
            var innerParsed: Parsed? = null
            if (java.lang.Boolean.parseBoolean(tokens[startIndexIncrease++])) {
                innerParsed = deserialize(tokens, startIndexIncrease)
            }
            return Parsed(
                schemeBegin,
                schemeLength,
                usernameBegin,
                usernameLength,
                passwordBegin,
                passwordLength,
                hostBegin,
                hostLength,
                portBegin,
                portLength,
                pathBegin,
                pathLength,
                queryBegin,
                queryLength,
                refBegin,
                refLength,
                potentiallyDanglingMarkup,
                innerParsed
            )
        }
    }
}