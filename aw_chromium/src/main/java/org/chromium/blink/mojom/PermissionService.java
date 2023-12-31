// PermissionService.java is auto generated by mojom_bindings_generator.py, do not edit


// Copyright 2014 The Chromium Authors
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.

// This file is autogenerated by:
//     mojo/public/tools/bindings/mojom_bindings_generator.py
// For:
//     third_party/blink/public/mojom/permissions/permission.mojom
//

package org.chromium.blink.mojom;

import androidx.annotation.IntDef;


public interface PermissionService extends org.chromium.mojo.bindings.Interface {



    public interface Proxy extends PermissionService, org.chromium.mojo.bindings.Interface.Proxy {
    }

    Manager<PermissionService, PermissionService.Proxy> MANAGER = PermissionService_Internal.MANAGER;

    void hasPermission(
PermissionDescriptor permission, 
HasPermission_Response callback);

    interface HasPermission_Response extends org.chromium.mojo.bindings.Callbacks.Callback1<Integer> { }


    void requestPageEmbeddedPermission(
EmbeddedPermissionRequestDescriptor descriptor, 
RequestPageEmbeddedPermission_Response callback);

    interface RequestPageEmbeddedPermission_Response extends org.chromium.mojo.bindings.Callbacks.Callback1<Integer> { }


    void requestPermission(
PermissionDescriptor permission, boolean userGesture, 
RequestPermission_Response callback);

    interface RequestPermission_Response extends org.chromium.mojo.bindings.Callbacks.Callback1<Integer> { }


    void requestPermissions(
PermissionDescriptor[] permission, boolean userGesture, 
RequestPermissions_Response callback);

    interface RequestPermissions_Response extends org.chromium.mojo.bindings.Callbacks.Callback1<int[]> { }


    void revokePermission(
PermissionDescriptor permission, 
RevokePermission_Response callback);

    interface RevokePermission_Response extends org.chromium.mojo.bindings.Callbacks.Callback1<Integer> { }


    void addPermissionObserver(
PermissionDescriptor permission, int lastKnownStatus, PermissionObserver observer);


    void notifyEventListener(
PermissionDescriptor permission, String eventType, boolean isAdded);


}
