// Copyright 2019 The Chromium Authors. All rights reserved.
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.
package org.chromium.android_webview.common.services

/**
 * Defines constants containing the fully-qualified names of WebView services.
 *
 * This class exists to avoid having to depend on service classes just to get
 * their name.
 */
object ServiceNames {
    const val CRASH_RECEIVER_SERVICE = "org.chromium.android_webview.services.CrashReceiverService"
    const val METRICS_BRIDGE_SERVICE = "org.chromium.android_webview.services.MetricsBridgeService"
    const val VARIATIONS_SEED_SERVER = "org.chromium.android_webview.services.VariationsSeedServer"
    const val COMPONENTS_PROVIDER_SERVICE =
        "org.chromium.android_webview.services.ComponentsProviderService"
}