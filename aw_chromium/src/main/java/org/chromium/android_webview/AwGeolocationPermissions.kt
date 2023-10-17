// Copyright 2012 The Chromium Authors. All rights reserved.
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.
package org.chromium.android_webview

import android.content.SharedPreferences
import org.chromium.net.GURLUtils

/**
 * This class is used to manage permissions for the WebView's Geolocation JavaScript API.
 *
 * Callbacks are posted on the UI thread.
 */
class AwGeolocationPermissions(private val mSharedPreferences: SharedPreferences) {
    /** See [android.webkit.GeolocationPermissions].  */
    interface Callback {
        /* See {@link android.webkit.GeolocationPermissions}. */
        operator fun invoke(origin: String?, allow: Boolean, retain: Boolean)
    }

    /**
     * Set one origin to be allowed.
     */
    fun allow(origin: String?) {
        val key = getOriginKey(origin)
        if (key != null) {
            mSharedPreferences.edit().putBoolean(key, true).apply()
        }
    }

    /**
     * Set one origin to be denied.
     */
    fun deny(origin: String?) {
        val key = getOriginKey(origin)
        if (key != null) {
            mSharedPreferences.edit().putBoolean(key, false).apply()
        }
    }

    /**
     * Clear the stored permission for a particular origin.
     */
    fun clear(origin: String) {
        val key = getOriginKey(origin)
        if (key != null) {
            mSharedPreferences.edit().remove(key).apply()
        }
    }

    /**
     * Synchronous method to get if an origin is set to be allowed.
     */
    fun isOriginAllowed(origin: String): Boolean {
        return mSharedPreferences.getBoolean(getOriginKey(origin), false)
    }

    /**
     * Returns true if the origin is either set to allowed or denied.
     */
    fun hasOrigin(origin: String): Boolean {
        return mSharedPreferences.contains(getOriginKey(origin))
    }

    /**
     * Get the domain of an URL using the GURL library.
     */
    private fun getOriginKey(url: String?): String? {
        val origin = GURLUtils.getOrigin(url)
        return if (origin.isEmpty()) {
            null
        } else PREF_PREFIX + origin
    }

    companion object {
        private const val PREF_PREFIX = "AwGeolocationPermissions%"

        /* package */
        @JvmStatic
        fun migrateGeolocationPreferences(
            oldPrefs: SharedPreferences, newPrefs: SharedPreferences
        ) {
            val oldPrefsEditor = oldPrefs.edit()
            val newPrefsEditor = newPrefs.edit()
            for (name in oldPrefs.all.keys) {
                if (name.startsWith(PREF_PREFIX)) {
                    newPrefsEditor.putBoolean(name, oldPrefs.getBoolean(name, false)).apply()
                    oldPrefsEditor.remove(name).apply()
                }
            }
        }
    }
}