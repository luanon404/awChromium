// NetLogExporter.java is auto generated by mojom_bindings_generator.py, do not edit


// Copyright 2014 The Chromium Authors
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.

// This file is autogenerated by:
//     mojo/public/tools/bindings/mojom_bindings_generator.py
// For:
//     services/network/public/mojom/net_log.mojom
//

package org.chromium.network.mojom;

import androidx.annotation.IntDef;


public interface NetLogExporter extends org.chromium.mojo.bindings.Interface {


    
    public static final long UNLIMITED_FILE_SIZE = (long) -1;




    public interface Proxy extends NetLogExporter, org.chromium.mojo.bindings.Interface.Proxy {
    }

    Manager<NetLogExporter, NetLogExporter.Proxy> MANAGER = NetLogExporter_Internal.MANAGER;

    void start(
org.chromium.mojo_base.mojom.File destination, org.chromium.mojo_base.mojom.DictionaryValue extraConstants, int captureMode, long maxFileSize, 
Start_Response callback);

    interface Start_Response extends org.chromium.mojo.bindings.Callbacks.Callback1<Integer> { }


    void stop(
org.chromium.mojo_base.mojom.DictionaryValue polledValues, 
Stop_Response callback);

    interface Stop_Response extends org.chromium.mojo.bindings.Callbacks.Callback1<Integer> { }


}
