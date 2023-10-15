// Copyright 2018 The Chromium Authors. All rights reserved.
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.
package org.chromium.ui

import org.chromium.base.Callback

/**
 * Interface to support asynchronous inflation of views.
 * @param <T> The view type.
</T> */
interface ViewProvider<T> {
    /**
     * Starts inflating the view.
     */
    fun inflate()

    /**
     * Add a callback that would be run (on the UI thread) once the [android.view.View] encapsulated by
     * this provider is inflated. The callback runs immediately (blocking) if the view has
     * already been inflated.
     */
    fun whenLoaded(callback: Callback<T>?)
}