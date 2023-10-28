// Copyright 2023 The Chromium Authors
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.

package org.chromium.ui.base;

/**
 * Constants for the names of Ui Android Features.
 */
public final class UiAndroidFeatures {


    // This following string constants were inserted by
    //     java_cpp_features.py
    // From
    //     ../../ui/android/ui_android_features.cc
    // Into
    //     ../../ui/android/java_templates/UiAndroidFeatures.java.tmpl


    public static final String ANDROID_HDR = "AndroidHDR";


    public static final String CONVERT_TRACKPAD_EVENTS_TO_MOUSE = "ConvertTrackpadEventsToMouse";


    public static final String DEPRECATED_EXTERNAL_PICKER_FUNCTION = "DeprecatedExternalPickerFunction";


    public static final String PWA_RESTORE_UI = "PwaRestoreUi";


    public static final String REPORT_ALL_AVAILABLE_POINTER_TYPES = "ReportAllAvailablePointerTypes";

    // Do not instantiate this class.
    private UiAndroidFeatures() {}
}
