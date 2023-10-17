// Copyright 2018 The Chromium Authors. All rights reserved.
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.
package org.chromium.android_webview.common

/**
 * Instantiable version of [PlatformServiceBridge], don't add anything to this class!
 * Downstream targets may provide a different implementation. In GN, we specify that
 * [PlatformServiceBridge] is compiled separately from its implementation; other
 * projects may specify a different PlatformServiceBridgeImpl via GN.
 */
class PlatformServiceBridgeImpl : PlatformServiceBridge()