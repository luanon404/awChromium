// AbortableAdAuction.java is auto generated by mojom_bindings_generator.py, do not edit


// Copyright 2014 The Chromium Authors
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.

// This file is autogenerated by:
//     mojo/public/tools/bindings/mojom_bindings_generator.py
// For:
//     third_party/blink/public/mojom/interest_group/ad_auction_service.mojom
//

package org.chromium.blink.mojom;


public interface AbortableAdAuction extends org.chromium.mojo.bindings.Interface {



    interface Proxy extends AbortableAdAuction, org.chromium.mojo.bindings.Interface.Proxy {
    }

    Manager<AbortableAdAuction, AbortableAdAuction.Proxy> MANAGER = AbortableAdAuction_Internal.MANAGER;

    void resolvedPromiseParam(
AuctionAdConfigAuctionId auction, int field, String jsonValue);


    void resolvedPerBuyerSignalsPromise(
AuctionAdConfigAuctionId auction, java.util.Map<org.chromium.url.internal.mojom.Origin, String> perBuyerSignals);


    void resolvedBuyerTimeoutsPromise(
AuctionAdConfigAuctionId auction, int field, AuctionAdConfigBuyerTimeouts buyerTimeouts);


    void resolvedBuyerCurrenciesPromise(
AuctionAdConfigAuctionId auction, AuctionAdConfigBuyerCurrencies perBuyerCurrencies);


    void resolvedDirectFromSellerSignalsPromise(
AuctionAdConfigAuctionId auction, DirectFromSellerSignals directFromSellerSignals);


    void resolvedDirectFromSellerSignalsHeaderAdSlotPromise(
AuctionAdConfigAuctionId auction, String directFromSellerSignalsHeaderAdSlot);


    void resolvedAuctionAdResponsePromise(
AuctionAdConfigAuctionId auction, org.chromium.mojo_base.mojom.BigBuffer result);


    void resolvedAdditionalBids(
AuctionAdConfigAuctionId auction);


    void abort(
);


}