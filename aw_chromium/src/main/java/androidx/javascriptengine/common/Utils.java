/*
 * Copyright 2023 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package androidx.javascriptengine.common;

import android.content.res.AssetFileDescriptor;

import androidx.annotation.NonNull;

/**
 * Utility methods for use in both service and client side of JavaScriptEngine.
 */
public class Utils {

    private Utils() {
        throw new AssertionError();
    }

    /**
     * Checks if the given AssetFileDescriptor passes certain conditions.
     */

    public static void checkAssetFileDescriptor(@NonNull AssetFileDescriptor afd, boolean allowUnknownLength) {
        if (afd.getStartOffset() < 0) {
            throw new IllegalArgumentException("AssetFileDescriptor offset should be >= 0");
        }
        if (afd.getLength() != AssetFileDescriptor.UNKNOWN_LENGTH && afd.getLength() < 0) {
            throw new IllegalArgumentException("AssetFileDescriptor should have valid length");
        }
        if (afd.getDeclaredLength() != AssetFileDescriptor.UNKNOWN_LENGTH && afd.getDeclaredLength() < 0) {
            throw new IllegalArgumentException("AssetFileDescriptor should have valid declared length");
        }
        if (afd.getLength() == AssetFileDescriptor.UNKNOWN_LENGTH && afd.getStartOffset() != 0) {
            throw new UnsupportedOperationException("AssetFileDescriptor offset should be 0 for unknown length");
        }

        if (!allowUnknownLength && afd.getLength() == AssetFileDescriptor.UNKNOWN_LENGTH) {
            throw new UnsupportedOperationException("AssetFileDescriptor should have known length");
        }
    }

}