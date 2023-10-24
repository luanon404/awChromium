// Copyright 2018 The Chromium Authors
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.

package org.chromium.components.version_info;

// Constants shared by Android Chrome and WebView. Chrome specific constants are
// in ChromeVersionConstants.
public class VersionConstants {
    public static final String PRODUCT_VERSION = "120.0.6076.4";
    @SuppressWarnings({"ComplexBooleanConstant", "IdentityBinaryExpression"})
    public static final boolean IS_OFFICIAL_BUILD = 0 == 1;

    public static final int PRODUCT_MAJOR_VERSION = 120;
    public static final int PRODUCT_BUILD_VERSION = 6076;

    public static final int CHANNEL = Channel.DEFAULT;
}
