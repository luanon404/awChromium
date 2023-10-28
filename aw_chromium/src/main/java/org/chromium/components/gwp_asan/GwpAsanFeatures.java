// Copyright 2023 The Chromium Authors
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.

package org.chromium.components.gwp_asan;

/**
 * Contains features that are specific to GWP-ASan.
 */
public final class GwpAsanFeatures {


    // This following string constants were inserted by
    //     java_cpp_features.py
    // From
    //     ../../components/gwp_asan/client/gwp_asan_features.cc
    // Into
    //     ../../components/gwp_asan/client/android/org/chromium/components/gwp_asan/GwpAsanFeatures.java.tmpl


    public static final String GWP_ASAN_MALLOC = "GwpAsanMalloc";


    public static final String GWP_ASAN_PARTITION_ALLOC = "GwpAsanPartitionAlloc";

    // Prevents instantiation.
    private GwpAsanFeatures() {}
}
