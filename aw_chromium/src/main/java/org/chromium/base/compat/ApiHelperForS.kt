// Copyright 2021 The Chromium Authors. All rights reserved.
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.
package org.chromium.base.compat

import android.annotation.TargetApi
import android.content.ClipData
import android.content.ClipDescription
import android.content.pm.PackageManager
import android.os.Process
import android.view.textclassifier.TextLinks
import org.chromium.base.ApiCompatibilityUtils
import org.chromium.base.BuildInfo
import org.chromium.base.ContextUtils
import org.chromium.base.Log
import org.chromium.base.annotations.VerifiesOnS
import java.lang.reflect.InvocationTargetException

/**
 * Utility class to use new APIs that were added in S (API level 31). These need to exist in a
 * separate class so that Android framework can successfully verify classes without
 * encountering the new APIs.
 */
@VerifiesOnS
@TargetApi(BuildInfo.ANDROID_S_API_SDK_INT)
object ApiHelperForS {
    private const val TAG = "ApiHelperForS"

    /**
     * See [ClipDescription.isStyledText].
     */
    @JvmStatic
    fun isStyleText(clipDescription: ClipDescription?): Boolean {
        return try {
            val isStyledTextMethod = ClipDescription::class.java.getDeclaredMethod("isStyledText")
            isStyledTextMethod.invoke(clipDescription) as Boolean
        } catch (e: InvocationTargetException) {
            Log.e(TAG, "Failed to invoke ClipDescription#isStyledText() ", e)
            false
        } catch (e: NoSuchMethodException) {
            Log.e(TAG, "Failed to invoke ClipDescription#isStyledText() ", e)
            false
        } catch (e: IllegalAccessException) {
            Log.e(TAG, "Failed to invoke ClipDescription#isStyledText() ", e)
            false
        }
    }

    /**
     * See [ClipDescription.getConfidenceScore].
     */
    @JvmStatic
    fun getConfidenceScore(
        clipDescription: ClipDescription?, entityType: String
    ): Float {
        return try {
            val getConfidenceScoreMethod = ClipDescription::class.java.getDeclaredMethod(
                "getConfidenceScore", String::class.java
            )
            getConfidenceScoreMethod.invoke(clipDescription, entityType) as Float
        } catch (e: InvocationTargetException) {
            Log.e(TAG, "Failed to invoke ClipDescription#getConfidenceScore() ", e)
            0f
        } catch (e: NoSuchMethodException) {
            Log.e(TAG, "Failed to invoke ClipDescription#getConfidenceScore() ", e)
            0f
        } catch (e: IllegalAccessException) {
            Log.e(TAG, "Failed to invoke ClipDescription#getConfidenceScore() ", e)
            0f
        } catch (e: IllegalStateException) {
            Log.e(TAG, "Failed to invoke ClipDescription#getConfidenceScore() ", e)
            0f
        }
    }

    /**
     * See [ClipData.Item.getTextLinks].
     */
    @JvmStatic
    fun getTextLinks(item: ClipData.Item?): TextLinks? {
        return try {
            val getTextLinksMethod = ClipData.Item::class.java.getDeclaredMethod("getTextLinks")
            getTextLinksMethod.invoke(item) as TextLinks
        } catch (e: InvocationTargetException) {
            Log.e(TAG, "Failed to invoke ClipData.Item#getTextLinks() ", e)
            null
        } catch (e: NoSuchMethodException) {
            Log.e(TAG, "Failed to invoke ClipData.Item#getTextLinks() ", e)
            null
        } catch (e: IllegalAccessException) {
            Log.e(TAG, "Failed to invoke ClipData.Item#getTextLinks() ", e)
            null
        }
    }

    @JvmStatic
    fun hasBluetoothConnectPermission(): Boolean {
        // TODO(b/183501112): Replace the permission string with the actual Manfifest constant once
        // Chrome starts compiling against the S SDK.
        return (ApiCompatibilityUtils.checkPermission(
            ContextUtils.getApplicationContext(),
            "android.permission.BLUETOOTH_CONNECT",
            Process.myPid(),
            Process.myUid()
        ) == PackageManager.PERMISSION_GRANTED)
    }
}