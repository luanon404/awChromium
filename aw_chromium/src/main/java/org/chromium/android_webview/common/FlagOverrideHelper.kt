// Copyright 2019 The Chromium Authors. All rights reserved.
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.
package org.chromium.android_webview.common

/**
 * Helper class to apply multiple features/flags to the global CommandLine singleton. This class and
 * its static methods assume the CommandLine has already been initialized.
 */
class FlagOverrideHelper(flagList: Array<Flag>) {
    private val mFlagMap: MutableMap<String, Flag> = HashMap()

    init {
        for (flag in flagList) {
            mFlagMap[flag.name] = flag
        }
    }

    /**
     * Fetches a [Flag] corresponding to `name`, based on the Flag array passed to the
     * constructor.
     *
     * @param name the name of the [Flag] to look up.
     * @return the desired [Flag].
     * @throws RuntimeException if this cannot find `name` in the list.
     */
    fun getFlagForName(name: String): Flag? {
        if (mFlagMap.containsKey(name)) {
            return mFlagMap[name]
        }
        throw RuntimeException("Unable to find flag '$name' in the list.")
    }

}