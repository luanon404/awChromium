// Copyright 2019 The Chromium Authors. All rights reserved.
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.
package org.chromium.android_webview.common

/**
 * Class to represent a commandline flag. This is used by the developer UI to pass flags-to-toggle
 * over to the WebView implementation.
 */
class Flag
/**
 * Calls should use [.baseFeature] or [ ][.commandLine] instead.
 */ private constructor(
    val name: String, val description: String,
    /**
     * Fetch the value to apply to the flag when enabled, or `null` if the flag doesn't take a
     * value.
     */
    val enabledStateValue: String?,
    /**
     * Indicates whether this is a `base::Feature` or a commandline flag.
     *
     * @return `true` if this is a `base::Feature`, `false` if this is a
     * commandline flag.
     */
    val isBaseFeature: Boolean
) {

    companion object {
        /**
         * Creates a Flag which represents a `base::Feature`.
         */
        fun baseFeature(name: String, description: String): Flag {
            return Flag(name, description,  /*enabledStateValue=*/null, true)
        }

        /**
         * Creates a Flag which represents a commandline switch.
         */
        fun commandLine(name: String, description: String): Flag {
            return Flag(name, description,  /*enabledStateValue=*/null, false)
        }

        /**
         * Creates a Flag which represents a commandline switch with a value applied when enabled.
         */
        fun commandLine(
            name: String, description: String, enabledStateValue: String
        ): Flag {
            return Flag(name, description, enabledStateValue, false)
        }
    }
}