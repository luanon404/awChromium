// DomStorage.java is auto generated by mojom_bindings_generator.py, do not edit


// Copyright 2014 The Chromium Authors
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.

// This file is autogenerated by:
//     mojo/public/tools/bindings/mojom_bindings_generator.py
// For:
//     third_party/blink/public/mojom/dom_storage/dom_storage.mojom
//

package org.chromium.blink.mojom;

import androidx.annotation.IntDef;


public interface DomStorage extends org.chromium.mojo.bindings.Interface {



    public interface Proxy extends DomStorage, org.chromium.mojo.bindings.Interface.Proxy {
    }

    Manager<DomStorage, DomStorage.Proxy> MANAGER = DomStorage_Internal.MANAGER;

    void openLocalStorage(
StorageKey storageKey, LocalFrameToken localFrameToken, org.chromium.mojo.bindings.InterfaceRequest<StorageArea> area);


    void bindSessionStorageNamespace(
String namespaceId, org.chromium.mojo.bindings.InterfaceRequest<SessionStorageNamespace> receiver);


    void bindSessionStorageArea(
StorageKey storageKey, LocalFrameToken localFrameToken, String namespaceId, org.chromium.mojo.bindings.InterfaceRequest<StorageArea> sessionNamespace);


}
