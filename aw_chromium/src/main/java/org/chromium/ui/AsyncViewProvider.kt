// Copyright 2018 The Chromium Authors. All rights reserved.
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.
package org.chromium.ui

import android.view.View
import org.chromium.base.Callback
import org.chromium.base.ThreadUtils

/**
 * A provider that encapsulates a [View] that is in the view hierarchy to be inflated by
 * an [AsyncViewStub].
 * @param <T> type of the [View] that this provider encapsulates.
</T> */
@Suppress("UNCHECKED_CAST")
class AsyncViewProvider<T : View?> : Callback<View?>, ViewProvider<T> {
    private var mResId = 0

    // Exactly one of mView and mViewStub is non-null at any point.
    private var mView: T? = null
    private var mViewStub: AsyncViewStub? = null
    private var mDestroyed = false

    private constructor(viewStub: AsyncViewStub?, resId: Int) {
        assert(viewStub != null)
        mResId = resId
        mViewStub = viewStub
    }

    private constructor(view: View?) {
        assert(view != null)
        mView = view as T?
    }

    override fun onResult(view: View?) {
        mView = view!!.findViewById(mResId)
        mViewStub = null
    }

    /**
     * @return the [View] encapsulated by this provider or null (if the view has not been
     * inflated yet).
     */
    fun get(): T? {
        return mView
    }

    override fun inflate() {
        mViewStub!!.inflate()
    }

    override fun whenLoaded(callback: Callback<T>?) {
        ThreadUtils.assertOnUiThread()
        if (mDestroyed) return
        if (mView != null) {
            // fire right now if view already inflated.
            callback!!.onResult(mView)
        } else {
            mViewStub!!.addOnInflateListener {
                if (mDestroyed) return@addOnInflateListener
                // listeners are called in order so mView should be set correctly at this point.
                callback!!.onResult(mView)
            }
        }
    }
    /**
     * Same as [.destroy] but takes a callback that is ensured to be run (either immediately
     * if the view is already inflated or after inflation of the [AsyncViewStub])).
     */
    /**
     * Destroy the provider making sure that all queued up after inflate callbacks are no longer
     * called.
     */
    @JvmOverloads
    fun destroy(destroyCallback: Callback<T?>? = null) {
        mDestroyed = true
        if (mView != null) {
            destroyCallback!!.onResult(mView)
            mView = null
        }
        if (mViewStub != null) {
            mViewStub!!.addOnInflateListener { destroyCallback!!.onResult(mView) }
            mViewStub = null
        }
    }

    companion object {
        /**
         * Returns a provider for a view in the view hierarchy that is to be inflated by {@param
         * * viewStub}.
         * @param viewStub the [AsyncViewStub] that will inflate the view hierarchy containing the
         * [View].
         * @param resId The resource id of the view that this provider should provide/encapsulate.
         * @return an [AsyncViewProvider] that encapsulates a view with id {@param resId}.
         */
        fun <E : View?> of(viewStub: AsyncViewStub?, resId: Int): AsyncViewProvider<E?> {
            ThreadUtils.assertOnUiThread()
            if (viewStub!!.inflatedView != null) {
                return AsyncViewProvider(viewStub.inflatedView!!.findViewById(resId))
            }
            val provider = AsyncViewProvider<E?>(viewStub, resId)
            viewStub.addOnInflateListener(provider)
            return provider
        }

        /**
         * Get a provider for a view with id {@param viewResId} that is (or going to be) in the view
         * hierarchy inflated by the AsyncViewStub with id {@param viewStubResId}.
         * @param root the [View] to use as the context for finding the View/ViewStub that the
         * provider encapsulates.
         * @param viewStubResId the resource id of the AsyncViewStub that inflates the view hierarchy
         * where the encapsulated View lives.
         * @param viewResId the resource id of the view that the provider should provide/encapsulate.
         * @return an [AsyncViewProvider] that encapsulates a view with id {@param viewResId}.
         */
        fun <E : View?> of(
            root: View, viewStubResId: Int, viewResId: Int
        ): AsyncViewProvider<E?> {
            ThreadUtils.assertOnUiThread()
            val viewStub = root.findViewById<View>(viewStubResId)
            return if (viewStub != null && viewStub is AsyncViewStub) {
                // view stub not yet inflated
                of(viewStub, viewResId)
            } else AsyncViewProvider(root.findViewById(viewResId))
            // view stub already inflated, return pre-loaded provider
        }
    }
}