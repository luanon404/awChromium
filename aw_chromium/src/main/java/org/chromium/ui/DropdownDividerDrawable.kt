// Copyright 2014 The Chromium Authors. All rights reserved.
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.
package org.chromium.ui

import android.graphics.Canvas
import android.graphics.ColorFilter
import android.graphics.Paint
import android.graphics.PixelFormat
import android.graphics.Rect
import android.graphics.drawable.Drawable

/**
 * A drawable divider to be used by dropdown adapters.
 */
class DropdownDividerDrawable(private val mBackgroundColor: Int?) : Drawable() {
    private val mPaint: Paint = Paint()
    private val mDividerRect: Rect = Rect()

    override fun draw(canvas: Canvas) {
        if (mBackgroundColor != null) canvas.drawColor(mBackgroundColor)
        canvas.drawRect(mDividerRect, mPaint)
    }

    public override fun onBoundsChange(bounds: Rect) {
        mDividerRect[0, 0, bounds.width()] = mDividerRect.height()
    }

    fun setHeight(height: Int) {
        mDividerRect[0, 0, mDividerRect.right] = height
    }

    fun setDividerColor(color: Int) {
        mPaint.color = color
    }

    override fun setAlpha(alpha: Int) {}
    override fun setColorFilter(cf: ColorFilter?) {}

    @Deprecated(
        "Deprecated in Java", ReplaceWith("PixelFormat.TRANSPARENT", "android.graphics.PixelFormat")
    )
    override fun getOpacity(): Int {
        return PixelFormat.TRANSPARENT
    }
}