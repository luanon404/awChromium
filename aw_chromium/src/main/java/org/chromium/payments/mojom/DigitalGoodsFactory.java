// DigitalGoodsFactory.java is auto generated by mojom_bindings_generator.py, do not edit


// Copyright 2014 The Chromium Authors
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.

// This file is autogenerated by:
//     mojo/public/tools/bindings/mojom_bindings_generator.py
// For:
//     third_party/blink/public/mojom/digital_goods/digital_goods.mojom
//

package org.chromium.payments.mojom;

public interface DigitalGoodsFactory extends org.chromium.mojo.bindings.Interface {


    interface Proxy extends DigitalGoodsFactory, org.chromium.mojo.bindings.Interface.Proxy {
    }

    Manager<DigitalGoodsFactory, DigitalGoodsFactory.Proxy> MANAGER = DigitalGoodsFactory_Internal.MANAGER;

    void createDigitalGoods(String paymentMethod, CreateDigitalGoods_Response callback);

    interface CreateDigitalGoods_Response extends org.chromium.mojo.bindings.Callbacks.Callback2<Integer, DigitalGoods> {
    }


}