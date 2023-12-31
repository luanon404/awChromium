// IdleMonitor.java is auto generated by mojom_bindings_generator.py, do not edit


// Copyright 2014 The Chromium Authors
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.

// This file is autogenerated by:
//     mojo/public/tools/bindings/mojom_bindings_generator.py
// For:
//     third_party/blink/public/mojom/idle/idle_manager.mojom
//

package org.chromium.blink.mojom;

import androidx.annotation.IntDef;


public interface IdleMonitor extends org.chromium.mojo.bindings.Interface {



    public interface Proxy extends IdleMonitor, org.chromium.mojo.bindings.Interface.Proxy {
    }

    Manager<IdleMonitor, IdleMonitor.Proxy> MANAGER = IdleMonitor_Internal.MANAGER;

    void update(
IdleState state, boolean isOverriddenByDevtools);


}
