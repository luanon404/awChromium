// SubAppsService.java is auto generated by mojom_bindings_generator.py, do not edit


// Copyright 2014 The Chromium Authors
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.

// This file is autogenerated by:
//     mojo/public/tools/bindings/mojom_bindings_generator.py
// For:
//     third_party/blink/public/mojom/subapps/sub_apps_service.mojom
//

package org.chromium.blink.mojom;

import androidx.annotation.IntDef;


public interface SubAppsService extends org.chromium.mojo.bindings.Interface {



    public interface Proxy extends SubAppsService, org.chromium.mojo.bindings.Interface.Proxy {
    }

    Manager<SubAppsService, SubAppsService.Proxy> MANAGER = SubAppsService_Internal.MANAGER;

    void add(
SubAppsServiceAddParameters[] subAppsToAdd, 
Add_Response callback);

    interface Add_Response extends org.chromium.mojo.bindings.Callbacks.Callback1<SubAppsServiceAddResult[]> { }


    void list(

List_Response callback);

    interface List_Response extends org.chromium.mojo.bindings.Callbacks.Callback1<SubAppsServiceListResult> { }


    void remove(
String[] manifestIdPaths, 
Remove_Response callback);

    interface Remove_Response extends org.chromium.mojo.bindings.Callbacks.Callback1<SubAppsServiceRemoveResult[]> { }


}
