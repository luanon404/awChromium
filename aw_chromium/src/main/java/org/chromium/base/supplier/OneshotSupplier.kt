// Copyright 2020 The Chromium Authors. All rights reserved.
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.
package org.chromium.base.supplier

import org.chromium.base.Callback

/**
 * OneshotSupplier wraps an asynchronously provided, non-null object `T`, notifying
 * observers a single time when the dependency becomes available. Note that null is the un-set
 * value; a fulfilled supplier will never have a null underlying value.
 *
 *
 * This allows classes dependent on `T` to be provided with a
 * OneshotSupplier during construction and register a `Callback<T>` to be notified when the
 * needed dependency is available, but without the need to un-register that Callback upon
 * destruction. Contrast to [ObservableSupplier], which requires un-registration to prevent
 * post-destruction callback invocation because the object can change an arbitrary number of times.
 *
 *
 *
 * This class must only be accessed from a single thread. Unless a particular thread designation
 * is given by the owner of the OneshotSupplier, clients should assume it must only be accessed on
 * the UI thread.
 *
 *
 * If you want to create a supplier, see an implementation in [OneshotSupplierImpl].
 *
 *
 * For classes using a OneshotSupplier to receive a dependency:
 *
 *  * To be notified when the object is available, call [.onAvailable].
 *  * If the object is already available, the Callback will be posted immediately on the handler
 * for the thread the supplier was created on.
 *  * The object held by this supplier will also be returned at the end of [    ][.onAvailable].
 *  * The Callback will be called at most once. It's still
 * recommended to use [org.chromium.base.CallbackController] for safety.
 *
 *
 * @param <T> The type of the wrapped object.
</T> */
interface OneshotSupplier<T> : Supplier<T> {
    /**
     * Add a callback that's called when the object owned by this supplier is available.
     * If the object is already available, the callback will be called at the end of the
     * current message loop.
     *
     * @param callback The callback to be called.
     * @return The value for this supplier if already available. Null otherwise.
     */
    fun onAvailable(callback: Callback<T>?): T?
}