// Copyright 2013 The Chromium Authors. All rights reserved.
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.
package org.chromium.ui

import android.content.Context
import android.content.res.TypedArray
import android.graphics.drawable.Drawable
import android.os.Build
import android.os.StrictMode
import android.view.View
import android.view.View.MeasureSpec
import android.view.ViewGroup
import android.widget.AbsListView
import android.widget.ListAdapter
import androidx.annotation.DrawableRes
import androidx.annotation.StyleableRes
import androidx.appcompat.content.res.AppCompatResources
import java.io.File
import java.io.IOException
import kotlin.math.max

/**
 * Utility functions for common Android UI tasks.
 * This class is not supposed to be instantiated.
 */
object UiUtils {

    // Keep this variable in sync with the value defined in file_paths.xml.
    const val IMAGE_FILE_PATH = "images"

    /**
     * A static map of manufacturers to the version where theming Android UI is completely
     * supported. If there is no entry, it means the manufacturer supports theming at the same
     * version Android did.
     */
    private val sAndroidUiThemeBlocklist: MutableMap<String, Int> = HashMap()

    init {
        // Xiaomi doesn't support SYSTEM_UI_FLAG_LIGHT_STATUS_BAR until Android N; more info at
        // https://crbug.com/823264.
        sAndroidUiThemeBlocklist["xiaomi"] = Build.VERSION_CODES.N
        // HTC doesn't respect theming flags on activity restart until Android O; this affects both
        // the system nav and status bar. More info at https://crbug.com/831737.
        sAndroidUiThemeBlocklist["htc"] = Build.VERSION_CODES.O
    }

    /**
     * Get a directory for the image capture operation. For devices with JB MR2
     * or latter android versions, the directory is IMAGE_FILE_PATH directory.
     * For ICS devices, the directory is CAPTURE_IMAGE_DIRECTORY.
     *
     * @param context The application context.
     * @return directory for the captured image to be stored.
     */
    @Throws(IOException::class)
    fun getDirectoryForImageCapture(context: Context): File {
        // Temporarily allowing disk access while fixing. TODO: http://crbug.com/562173
        val oldPolicy = StrictMode.allowThreadDiskReads()
        return try {
            val path = File(context.filesDir, IMAGE_FILE_PATH)
            if (!path.exists() && !path.mkdir()) {
                throw IOException("Folder cannot be created.")
            }
            path
        } finally {
            StrictMode.setThreadPolicy(oldPolicy)
        }
    }

    /**
     * Iterates through all items in the specified ListAdapter (including header and footer views)
     * and returns the width of the widest item (when laid out with height and width set to
     * WRAP_CONTENT).
     *
     * WARNING: do not call this on a ListAdapter with more than a handful of items, the performance
     * will be terrible since it measures every single item.
     *
     * @param adapter The ListAdapter whose widest item's width will be returned.
     * @param parentView The parent view.
     * @return The measured width (in pixels) of the widest item in the passed-in ListAdapter.
     */
    @JvmOverloads
    fun computeMaxWidthOfListAdapterItems(
        adapter: ListAdapter?, parentView: ViewGroup? = null
    ): Int {
        val widthMeasureSpec = MeasureSpec.makeMeasureSpec(0, MeasureSpec.UNSPECIFIED)
        val heightMeasureSpec = MeasureSpec.makeMeasureSpec(0, MeasureSpec.UNSPECIFIED)
        val params = AbsListView.LayoutParams(
            AbsListView.LayoutParams.WRAP_CONTENT, AbsListView.LayoutParams.WRAP_CONTENT
        )
        var maxWidth = 0
        val itemViews = arrayOfNulls<View>(adapter!!.viewTypeCount)
        for (i in 0 until adapter.count) {
            var itemView: View?
            val type = adapter.getItemViewType(i)
            if (type < 0) {
                // Type is negative for header/footer views, or views the adapter does not want
                // recycled.
                itemView = adapter.getView(i, null, parentView)
            } else {
                itemViews[type] = adapter.getView(i, itemViews[type], parentView)
                itemView = itemViews[type]
            }
            itemView!!.layoutParams = params
            itemView.measure(widthMeasureSpec, heightMeasureSpec)
            maxWidth = max(maxWidth, itemView.measuredWidth)
        }
        return maxWidth
    }

    /**
     * Loads a [Drawable] from an attribute.  Uses [AppCompatResources] to support all
     * modern [Drawable] types.
     * @param context The associated context.
     * @param attrs The attributes from which to load the drawable resource.
     * @param attrId The attribute id that holds the drawable resource.
     * @return A new [Drawable] or `null` if the attribute wasn't set.
     */
    fun getDrawable(
        context: Context?, attrs: TypedArray?, @StyleableRes attrId: Int
    ): Drawable? {
        if (attrs == null) return null
        @DrawableRes val resId = attrs.getResourceId(attrId, -1)
        return if (resId == -1) null else AppCompatResources.getDrawable(context!!, resId)
    }

}