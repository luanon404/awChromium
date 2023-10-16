// Copyright 2018 The Chromium Authors. All rights reserved.
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.
package org.chromium.ui.modelutil

/**
 * An interface for models notifying about changes to a list of items. Note that ListObservable
 * models do not need to be implemented as a list. Internally they may use any structure to organize
 * their items. Note also that this class on purpose does not expose an item type (it only exposes a
 * *payload* type for partial change notifications), nor does it give access to the list
 * contents. This is because the list might not be homogeneous -- it could represent items of vastly
 * different types that don't share a common base class. Use the [ListModel]
 * subclass for homogeneous lists.
 * @param <P> The parameter type for the payload for partial updates. Use [Void] for
 * implementations that don't support partial updates.
</P> */
interface ListObservable<P> {
    /**
     * @param observer An observer to be notified of changes to the model.
     */
    fun addObserver(observer: ListObserver<P>?)

    /** @param observer The observer to remove.
     */
    fun removeObserver(observer: ListObserver<P>?)

    /**
     * An observer to be notified of changes to a [ListObservable].
     * @param <P> The parameter type for the payload for partial updates. Use [Void] for
     * implementations that don't support partial updates.
    </P> */
    interface ListObserver<P> {
        /**
         * Notifies that `count` items starting at position `index` under the
         * `source` have been added.
         *
         * @param source The list to which items have been added.
         * @param index The starting position of the range of added items.
         * @param count The number of added items.
         */
        fun onItemRangeInserted(source: ListObservable<*>?, index: Int, count: Int) {}

        /**
         * Notifies that `count` items starting at position `index` under the
         * `source` have been removed.
         *
         * @param source The list from which items have been removed.
         * @param index The starting position of the range of removed items.
         * @param count The number of removed items.
         */
        fun onItemRangeRemoved(source: ListObservable<*>?, index: Int, count: Int) {}

        /**
         * Notifies that `count` items starting at position `index` under the
         * `source` have changed, with an optional payload object.
         *
         * @param source The list whose items have changed.
         * @param index The starting position of the range of changed items.
         * @param count The number of changed items.
         * @param payload Optional parameter, use `null` to identify a "full" update.
         */
        fun onItemRangeChanged(
            source: ListObservable<P>?, index: Int, count: Int, payload: P?
        ) {
        }

        /**
         * Notifies that item at position `curIndex` will be moved to `newIndex`.
         *
         * @param curIndex Current position of the moved item.
         * @param newIndex New position of the moved item.
         */
        fun onItemMoved(source: ListObservable<*>?, curIndex: Int, newIndex: Int) {}
    }
}