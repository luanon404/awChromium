// Copyright 2018 The Chromium Authors
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.

package org.chromium.ui;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

import androidx.annotation.NonNull;
import androidx.asynclayoutinflater.view.AsyncLayoutInflater;

import org.chromium.android_webview.R;
import org.chromium.base.Callback;
import org.chromium.base.ObserverList;
import org.chromium.base.ThreadUtils;
import org.chromium.base.TraceEvent;

/**
 * An implementation of ViewStub that inflates the view in a background thread. Callbacks are still
 * called on the UI thread.
 */
public class AsyncViewStub extends View implements AsyncLayoutInflater.OnInflateFinishedListener {
    private final int mLayoutResource;
    private View mInflatedView;

    private static AsyncLayoutInflater sAsyncLayoutInflater;

    private final ObserverList<Callback<View>> mListeners = new ObserverList<>();

    public AsyncViewStub(Context context, AttributeSet attrs) {
        super(context, attrs);
        final TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.AsyncViewStub);
        mLayoutResource = a.getResourceId(R.styleable.AsyncViewStub_layout, 0);
        a.recycle();

        setVisibility(GONE);
        setWillNotDraw(true);

        if (sAsyncLayoutInflater == null) {
            sAsyncLayoutInflater = new AsyncLayoutInflater(getContext());
        }
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        setMeasuredDimension(0, 0);
    }

    @SuppressLint("MissingSuperCall")
    @Override
    public void draw(@NonNull Canvas canvas) {
    }

    @Override
    protected void dispatchDraw(@NonNull Canvas canvas) {
    }

    @Override
    public void onInflateFinished(@NonNull View view, int resId, ViewGroup parent) {
        mInflatedView = view;
        replaceSelfWithView(view, parent);
        callListeners(view);
    }

    /**
     * Starts background inflation for the stub, the AsyncViewStub must be attached to the window
     * (ie have a parent) before you call inflate on it. Must be called on the UI thread.
     */
    public void inflate() {
        try (TraceEvent ignored = TraceEvent.scoped("AsyncViewStub.inflate")) {
            ThreadUtils.assertOnUiThread();
            final ViewParent viewParent = getParent();
            assert viewParent != null;
            assert viewParent instanceof ViewGroup;
            assert mLayoutResource != 0;
            ViewGroup inflatedView = (ViewGroup) LayoutInflater.from(getContext()).inflate(mLayoutResource, (ViewGroup) viewParent, false);
            onInflateFinished(inflatedView, mLayoutResource, (ViewGroup) viewParent);
        }
    }

    private void callListeners(View view) {
        try (TraceEvent ignored = TraceEvent.scoped("AsyncViewStub.callListeners")) {
            ThreadUtils.assertOnUiThread();
            for (Callback<View> listener : mListeners) {
                listener.onResult(view);
            }
            mListeners.clear();
        }
    }

    /**
     * This should only be used by {@link AsyncViewProvider}, use {@link
     * AsyncViewProvider#whenLoaded} instead.
     * <p>
     * Adds listener that gets called once the view is inflated and added to the view hierarchy. The
     * listeners are called on the UI thread. This method can only be called on the UI thread.
     *
     * @param listener the listener to add.
     */
    void addOnInflateListener(Callback<View> listener) {
        ThreadUtils.assertOnUiThread();
        if (mInflatedView != null) {
            listener.onResult(mInflatedView);
        } else {
            mListeners.addObserver(listener);
        }
    }

    /**
     * @return the inflated view or null if inflation is not complete yet.
     */
    View getInflatedView() {
        return mInflatedView;
    }

    private void replaceSelfWithView(View view, ViewGroup parent) {
        try (TraceEvent ignored = TraceEvent.scoped("AsyncViewStub.replaceSelfWithView")) {
            int index = parent.indexOfChild(this);
            parent.removeViewInLayout(this);
            final ViewGroup.LayoutParams layoutParams = getLayoutParams();
            if (layoutParams != null) {
                parent.addView(view, index, layoutParams);
            } else {
                parent.addView(view, index);
            }
        }
    }

}
