// SessionStorageNamespace.java is auto generated by mojom_bindings_generator.py, do not edit


// Copyright 2014 The Chromium Authors
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.

// This file is autogenerated by:
//     mojo/public/tools/bindings/mojom_bindings_generator.py
// For:
//     third_party/blink/public/mojom/dom_storage/session_storage_namespace.mojom
//

package org.chromium.blink.mojom;

import androidx.annotation.IntDef;


public interface SessionStorageNamespace extends org.chromium.mojo.bindings.Interface {



    public interface Proxy extends SessionStorageNamespace, org.chromium.mojo.bindings.Interface.Proxy {
    }

    Manager<SessionStorageNamespace, SessionStorageNamespace.Proxy> MANAGER = SessionStorageNamespace_Internal.MANAGER;

    void clone(
String cloneToNamespace);


}
