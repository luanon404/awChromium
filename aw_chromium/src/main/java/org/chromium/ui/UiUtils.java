// Copyright 2013 The Chromium Authors
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.

package org.chromium.ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.StrictMode;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ListAdapter;

import androidx.annotation.DrawableRes;
import androidx.annotation.Nullable;
import androidx.annotation.StyleableRes;
import androidx.appcompat.content.res.AppCompatResources;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Utility functions for common Android UI tasks.
 * This class is not supposed to be instantiated.
 */
public class UiUtils {

    // Keep this variable in sync with the value defined in file_paths.xml.
    public static final String IMAGE_FILE_PATH = "images";

    /**
     * A static map of manufacturers to the version where theming Android UI is completely
     * supported. If there is no entry, it means the manufacturer supports theming at the same
     * version Android did.
     *
     * @noinspection MismatchedQueryAndUpdateOfCollection
     */
    private static final Map<String, Integer> sAndroidUiThemeBlocklist = new HashMap<>();

    static {
        // HTC doesn't respect theming flags on activity restart until Android O; this affects both
        // the system nav and status bar. More info at https://crbug.com/831737.
        sAndroidUiThemeBlocklist.put("htc", Build.VERSION_CODES.O);
    }

    /**
     * Guards this class from being instantiated.
     */
    private UiUtils() {
    }

    /**
     * Get a directory for the image capture operation. For devices with JB MR2
     * or latter android versions, the directory is IMAGE_FILE_PATH directory.
     * For ICS devices, the directory is CAPTURE_IMAGE_DIRECTORY.
     *
     * @param context The application context.
     * @return directory for the captured image to be stored.
     */
    public static File getDirectoryForImageCapture(Context context) throws IOException {
        // Temporarily allowing disk access while fixing. TODO: http://crbug.com/562173
        StrictMode.ThreadPolicy oldPolicy = StrictMode.allowThreadDiskReads();
        try {
            File path;
            path = new File(context.getFilesDir(), IMAGE_FILE_PATH);
            if (!path.exists() && !path.mkdir()) {
                throw new IOException("Folder cannot be created.");
            }
            return path;
        } finally {
            StrictMode.setThreadPolicy(oldPolicy);
        }
    }

    /**
     * Iterates through all items in the specified ListAdapter (including header and footer views)
     * and returns the width of the widest item (when laid out with height and width set to
     * WRAP_CONTENT).
     * <p>
     * WARNING: do not call this on a ListAdapter with more than a handful of items, the performance
     * will be terrible since it measures every single item.
     *
     * @param adapter    The ListAdapter whose widest item's width will be returned.
     * @param parentView The parent view. This can be null.
     * @return The measured width (in pixels) of the widest item in the passed-in ListAdapter.
     */
    public static int computeMaxWidthOfListAdapterItems(ListAdapter adapter, ViewGroup parentView) {
        final int widthMeasureSpec = MeasureSpec.makeMeasureSpec(0, MeasureSpec.UNSPECIFIED);
        final int heightMeasureSpec = MeasureSpec.makeMeasureSpec(0, MeasureSpec.UNSPECIFIED);
        AbsListView.LayoutParams params = new AbsListView.LayoutParams(AbsListView.LayoutParams.WRAP_CONTENT, AbsListView.LayoutParams.WRAP_CONTENT);

        int maxWidth = 0;
        View[] itemViews = new View[adapter.getViewTypeCount()];
        for (int i = 0; i < adapter.getCount(); ++i) {
            View itemView;
            int type = adapter.getItemViewType(i);
            if (type < 0) {
                // Type is negative for header/footer views, or views the adapter does not want
                // recycled.
                itemView = adapter.getView(i, null, parentView);
            } else {
                itemViews[type] = adapter.getView(i, itemViews[type], parentView);
                itemView = itemViews[type];
            }

            itemView.setLayoutParams(params);
            itemView.measure(widthMeasureSpec, heightMeasureSpec);
            maxWidth = Math.max(maxWidth, itemView.getMeasuredWidth());
        }

        return maxWidth;
    }

    /**
     * Loads a {@link Drawable} from an attribute.  Uses {@link AppCompatResources} to support all
     * modern {@link Drawable} types.
     *
     * @param context The associated context.
     * @param attrs   The attributes from which to load the drawable resource.
     * @param attrId  The attribute id that holds the drawable resource.
     * @return A new {@link Drawable} or {@code null} if the attribute wasn't set.
     */
    public static @Nullable Drawable getDrawable(Context context, @Nullable TypedArray attrs, @StyleableRes int attrId) {
        if (attrs == null) return null;

        @DrawableRes int resId = attrs.getResourceId(attrId, -1);
        if (resId == -1) return null;
        return AppCompatResources.getDrawable(context, resId);
    }

}
