// Copyright 2018 The Chromium Authors. All rights reserved.
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.
package org.chromium.ui.modelutil

/**
 * A minimal subset of the functionality of [List], to allow easier implementation in
 * classes that already extend another class and therefore can't inherit from [AbstractList].
 * @param <T> The type of list item.
</T> */
interface SimpleList<T> : Iterable<T> {
    /**
     * @return The size of the list.
     * @see List.size
     */
    fun size(): Int

    /**
     * Returns the item at the given position.
     * @param index The position to get the item from.
     * @return Returns the found item.
     * @see List.get
     */
    operator fun get(index: Int): T

    /**
     * @return An iterator over elements in the list. The iterator is not safe for concurrent
     * modifications and does not check whether the underlying list is being modified.
     */
    override fun iterator(): MutableIterator<T> {
        return object : MutableIterator<T> {
            private var mI = 0
            override fun hasNext(): Boolean {
                return mI < size()
            }

            override fun next(): T {
                return get(mI++)
            }

            override fun remove() {
                TODO("Not yet implemented")
            }
        }
    }
}