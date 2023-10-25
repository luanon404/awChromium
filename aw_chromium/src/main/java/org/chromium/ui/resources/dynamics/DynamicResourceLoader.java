// Copyright 2014 The Chromium Authors
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.

package org.chromium.ui.resources.dynamics;

import android.util.SparseArray;

import org.chromium.base.Callback;
import org.chromium.ui.resources.Resource;
import org.chromium.ui.resources.ResourceLoader;

/**
 * Handles managing dynamic resources. Because {@link DynamicResource} decide when they are dirty
 * and should return a loaded resource, this class mostly just passes through notifications when
 * render frames are happening, and hands the captured {@link org.chromium.ui.resources.Resource}
 * back in our {@link ResourceLoaderCallback}.
 */
public class DynamicResourceLoader extends ResourceLoader {
    /**
     * Adapter for holding a callback and {@link DynamicResource}. The callback must be held so
     * it can be unregistered when the {@link DynamicResource} is no longer in use.
     */
    private static class DynamicResourceHolder {
        private final DynamicResource mDynamicResource;

        public DynamicResourceHolder(DynamicResource dynamicResource, Callback<Resource> callback) {
            mDynamicResource = dynamicResource;
            mDynamicResource.addOnResourceReadyCallback(callback);
        }

        DynamicResource getDynamicResource() {
            return mDynamicResource;
        }

    }

    private final SparseArray<DynamicResourceHolder> mDynamicResourceHolders = new SparseArray<>();

    /**
     * Builds a {@link DynamicResourceLoader} instance.
     *
     * @param resourceType The resource type this loader is responsible for loading.
     * @param callback     A {@link ResourceLoaderCallback} to be notified when the dynamic resource
     *                     has changed.  The callback will only be notified if
     *                     {@link #loadResource(int)} is called.
     */
    public DynamicResourceLoader(int resourceType, ResourceLoaderCallback callback) {
        super(resourceType, callback);
    }

    /**
     * Called when a {@link DynamicResource} was requested.  This will notify the
     * {@link ResourceLoaderCallback} if the resource has new contents.
     *
     * @param resId The Android id representing the {@link DynamicResource}.
     */
    @Override
    public void loadResource(int resId) {
        DynamicResourceHolder dynamicResourceHolder = mDynamicResourceHolders.get(resId);
        if (dynamicResourceHolder == null) return;
        dynamicResourceHolder.getDynamicResource().onResourceRequested();
    }

    /**
     * Since this class relies solely on registration it does not support preloading resources.
     */
    @Override
    public void preloadResource(int resId) {
        // Not implemented.
        assert false : "Preloading dynamic resources isn't supported.";
    }
}
