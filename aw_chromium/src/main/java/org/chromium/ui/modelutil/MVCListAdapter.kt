// Copyright 2019 The Chromium Authors. All rights reserved.
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.
package org.chromium.ui.modelutil

import android.view.View
import android.view.ViewGroup

/**
 * An interface that defined a simple API for list adapters in MVC. This class also contains a small
 * number of common utilities shared between implementations. In general, the only means of
 * interaction with these kinds of list adapters post-initialization should be to register the
 * different types of views that can be shown by the list, i.e.:
 * [.registerType].
 */
interface MVCListAdapter {
    /** A basic container for [PropertyModel]s with a type.  */
    class ListItem
    /**
     * Build a new item to managed by a [ModelListAdapter].
     * @param type The view type the model will bind to.
     * @param model The model that will be bound to a view.
     */(
        /** The type of view that the `model` is associated with.  */
        val type: Int,
        /** The model to be managed by a list.  */
        val model: PropertyModel
    )

    /** A basic observable list for this adapter to use. This more or less acts as a typedef.  */
    class ModelList : ListModelBase<ListItem?, Void?>()

    /**
     * An interface to provide a means to build specific view types.
     * @param <T> The type of view that the implementor will build.
    </T> */
    interface ViewBuilder<T : View?> {
        /**
         * @param parent Parent view.
         * @return A new view to show in the list.
         */
        fun buildView(parent: ViewGroup): T
    }

    /**
     * Register a new view type that this adapter knows how to show.
     * @param typeId The ID of the view type. This should not match any other view type registered
     * in this adapter.
     * @param builder A mechanism for building new views of the specified type.
     * @param binder A means of binding a model to the provided view.
     */
    fun <T : View?> registerType(
        typeId: Int,
        builder: ViewBuilder<T>?,
        binder: PropertyModelChangeProcessor.ViewBinder<PropertyModel?, T, PropertyKey?>?
    )
}