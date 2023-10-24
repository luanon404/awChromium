// Copyright 2023 The Chromium Authors
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.

// This file is autogenerated by
//     java_cpp_enum.py
// From
//     ../../android_webview/browser/safe_browsing/aw_url_checker_delegate_impl.h

package org.chromium.android_webview;

import androidx.annotation.IntDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@IntDef({SafeBrowsingAction.SHOW_INTERSTITIAL, SafeBrowsingAction.PROCEED, SafeBrowsingAction.BACK_TO_SAFETY})
@Retention(RetentionPolicy.SOURCE)
public @interface SafeBrowsingAction {
    int SHOW_INTERSTITIAL = 0;
    int PROCEED = 1;
    int BACK_TO_SAFETY = 2;
}