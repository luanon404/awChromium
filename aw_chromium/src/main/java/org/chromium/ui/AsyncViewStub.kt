// Copyright 2018 The Chromium Authors. All rights reserved.
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.
package org.chromium.ui

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Canvas
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.asynclayoutinflater.view.AsyncLayoutInflater
import androidx.asynclayoutinflater.view.AsyncLayoutInflater.OnInflateFinishedListener
import org.chromium.android_webview.R
import org.chromium.base.Callback
import org.chromium.base.ObserverList
import org.chromium.base.ThreadUtils
import org.chromium.base.TraceEvent

/**
 * An implementation of ViewStub that inflates the view in a background thread. Callbacks are still
 * called on the UI thread.
 */
class AsyncViewStub(context: Context, attrs: AttributeSet?) : View(context, attrs),
    OnInflateFinishedListener {
    private var mLayoutResource: Int

    /**
     * @return the inflated view or null if inflation is not complete yet.
     */
    var inflatedView: View? = null
        private set
    private val mListeners = ObserverList<Callback<View?>>()
    private var mOnBackground = false

    init {
        val a = context.obtainStyledAttributes(attrs, R.styleable.AsyncViewStub)
        mLayoutResource = a.getResourceId(R.styleable.AsyncViewStub_layout, 0)
        a.recycle()
        visibility = GONE
        setWillNotDraw(true)
        if (sAsyncLayoutInflater == null) {
            sAsyncLayoutInflater = AsyncLayoutInflater(getContext())
        }
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        setMeasuredDimension(0, 0)
    }

    @SuppressLint("MissingSuperCall")
    override fun draw(canvas: Canvas) {
    }

    override fun dispatchDraw(canvas: Canvas) {}
    override fun onInflateFinished(view: View, resId: Int, parent: ViewGroup?) {
        inflatedView = view
        replaceSelfWithView(view, parent)
        callListeners(view)
    }

    /**
     * Starts background inflation for the stub, the AsyncViewStub must be attached to the window
     * (ie have a parent) before you call inflate on it. Must be called on the UI thread.
     */
    fun inflate() {
        TraceEvent.scoped("AsyncViewStub.inflate").use {
            ThreadUtils.assertOnUiThread()
            val viewParent = parent!!
            assert(viewParent is ViewGroup)
            assert(mLayoutResource != 0)
            if (mOnBackground) {
                // AsyncLayoutInflater uses its own thread and cannot inflate <merge> elements. It
                // might be a good idea to write our own version to use our scheduling primitives
                // and to handle <merge> inflations.
                sAsyncLayoutInflater!!.inflate(mLayoutResource, viewParent as ViewGroup, this)
            } else {
                val inflatedView = LayoutInflater.from(context)
                    .inflate(mLayoutResource, viewParent as ViewGroup, false) as ViewGroup
                onInflateFinished(inflatedView, mLayoutResource, viewParent)
            }
        }
    }

    private fun callListeners(view: View) {
        TraceEvent.scoped("AsyncViewStub.callListeners").use {
            ThreadUtils.assertOnUiThread()
            for (listener in mListeners) {
                listener.onResult(view)
            }
            mListeners.clear()
        }
    }

    /**
     * This should only be used by [AsyncViewProvider], use [ ][AsyncViewProvider.whenLoaded] instead.
     *
     * Adds listener that gets called once the view is inflated and added to the view hierarchy. The
     * listeners are called on the UI thread. This method can only be called on the UI thread.
     *
     * @param listener the listener to add.
     */
    fun addOnInflateListener(listener: Callback<View?>) {
        ThreadUtils.assertOnUiThread()
        if (inflatedView != null) {
            listener.onResult(inflatedView)
        } else {
            mListeners.addObserver(listener)
        }
    }

    private fun replaceSelfWithView(view: View, parent: ViewGroup?) {
        TraceEvent.scoped("AsyncViewStub.replaceSelfWithView").use {
            val index = parent!!.indexOfChild(this)
            parent.removeViewInLayout(this)
            val layoutParams = layoutParams
            if (layoutParams != null) {
                parent.addView(view, index, layoutParams)
            } else {
                parent.addView(view, index)
            }
        }
    }

    companion object {
        private var sAsyncLayoutInflater: AsyncLayoutInflater? = null
    }
}