// LeakDetector.java is auto generated by mojom_bindings_generator.py, do not edit


// Copyright 2014 The Chromium Authors
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.

// This file is autogenerated by:
//     mojo/public/tools/bindings/mojom_bindings_generator.py
// For:
//     third_party/blink/public/mojom/leak_detector/leak_detector.mojom
//

package org.chromium.blink.mojom;

import androidx.annotation.IntDef;


public interface LeakDetector extends org.chromium.mojo.bindings.Interface {



    public interface Proxy extends LeakDetector, org.chromium.mojo.bindings.Interface.Proxy {
    }

    Manager<LeakDetector, LeakDetector.Proxy> MANAGER = LeakDetector_Internal.MANAGER;

    void performLeakDetection(

PerformLeakDetection_Response callback);

    interface PerformLeakDetection_Response extends org.chromium.mojo.bindings.Callbacks.Callback1<LeakDetectionResult> { }


}
