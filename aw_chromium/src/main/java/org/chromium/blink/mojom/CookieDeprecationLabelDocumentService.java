// CookieDeprecationLabelDocumentService.java is auto generated by mojom_bindings_generator.py, do not edit


// Copyright 2014 The Chromium Authors
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.

// This file is autogenerated by:
//     mojo/public/tools/bindings/mojom_bindings_generator.py
// For:
//     third_party/blink/public/mojom/cookie_deprecation_label/cookie_deprecation_label.mojom
//

package org.chromium.blink.mojom;


public interface CookieDeprecationLabelDocumentService extends org.chromium.mojo.bindings.Interface {



    interface Proxy extends CookieDeprecationLabelDocumentService, org.chromium.mojo.bindings.Interface.Proxy {
    }

    Manager<CookieDeprecationLabelDocumentService, CookieDeprecationLabelDocumentService.Proxy> MANAGER = CookieDeprecationLabelDocumentService_Internal.MANAGER;

    void getValue(

GetValue_Response callback);

    interface GetValue_Response extends org.chromium.mojo.bindings.Callbacks.Callback1<String> { }


}