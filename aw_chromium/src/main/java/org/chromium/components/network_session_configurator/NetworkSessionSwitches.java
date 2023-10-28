// Copyright 2022 The Chromium Authors
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.

package org.chromium.components.network_session_configurator;

/**
* Contains command line switches that are specific to
* configuring network sessions via network_session_configurator.
*/
public final class NetworkSessionSwitches {


    // This following string constants were inserted by
    //     java_cpp_strings.py
    // From
    //     ../../components/network_session_configurator/common/network_switches.cc
    // Into
    //     ../../components/network_session_configurator/android/NetworkSessionSwitches.java.tmpl

    // `kEnableHttp2GreaseSettings` does not include the word "enable" for
    // historical reasons.
    public static final String ENABLE_HTTP2_GREASE_SETTINGS = "http2-grease-settings";


    public static final String DISABLE_HTTP2_GREASE_SETTINGS = "disable-http2-grease-settings";

   // Prevents instantiation.
   private NetworkSessionSwitches() {}
}

