// Copyright 2020 The Chromium Authors. All rights reserved.
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.
package org.chromium.android_webview.gfx

import android.graphics.Rect
import androidx.annotation.IntDef
import java.util.Arrays

/**
 * Utility functions for calculating Rectangle properties (i.e. Area of a single Rect)
 */
object RectUtils {
    @JvmStatic
    fun getRectArea(rect: Rect): Int {
        return rect.width() * rect.height()
    }

    /** Creates a new [Rect] with the same bounds as the given [Rect].  */
    @JvmStatic
    fun copyRect(rect: Rect): Rect {
        return Rect(rect.left, rect.top, rect.right, rect.bottom)
    }

    private fun compareSegmentTypes(s1: Int, s2: Int): Int {
        return if (s1 == s2) {
            0
        } else if (s1 == SegmentType.START && s2 == SegmentType.END) {
            -1
        } else {
            1
        }
    }

    private fun insertSorted(
        arr: Array<VerticalSegment?>, n: Int, verticalSegment: VerticalSegment, capacity: Int
    ) {
        assert(n < capacity)
        var i: Int = n - 1
        while (i >= 0 && arr[i]!! > verticalSegment) {
            arr[i + 1]!!.set(arr[i])
            i--
        }
        val insert_index = i + 1
        assert(insert_index in 0..<capacity)
        arr[insert_index]!!.set(verticalSegment)
    }

    private fun deleteElement(
        arr: Array<VerticalSegment?>, n: Int, verticalSegment: VerticalSegment
    ): Int {
        val pos = Arrays.binarySearch(arr, 0, n, verticalSegment)
        if (pos < 0) {
            return -1
        }

        // In the case of duplicate values, either one can be removed
        for (i in pos + 1 until n) {
            arr[i - 1]!!.set(arr[i])
        }
        return n - 1
    }

    private fun getCoverageOfVerticalSegments(
        vSegments: Array<VerticalSegment?>, numVerticalSegments: Int
    ): Int {
        var scanCount = 0
        var coveredPixels = 0
        var start = -1
        for (i in 0 until numVerticalSegments) {
            val verticalSegment = vSegments[i]
            if (scanCount == 0 && verticalSegment!!.mSegmentType == SegmentType.START) {
                start = verticalSegment.mY
            } else if (scanCount == 1 && verticalSegment!!.mSegmentType == SegmentType.END) {
                coveredPixels += verticalSegment.mY - start
            }
            scanCount += if (verticalSegment!!.mSegmentType == SegmentType.START) 1 else -1
        }
        return coveredPixels
    }

    private var sHorizontalSegments: Array<HorizontalSegment?>? = null
    private var sVerticalSegments: Array<VerticalSegment?> = emptyArray()
    private val sVerticalSegment1 = VerticalSegment()
    private val sVerticalSegment2 = VerticalSegment()
    private var sClippedRects: Array<Rect?>? = null

    /*
        This is a 2d extension of the 1d range intersection problem.
        In one dimension we are interested in calculating the
        intersected set of ranges for an input. To do this we decompose
        each input range into a start and an end position, plus whether
        it is entering a range or leaving it. Once these decomposed
        positions are sorted, we can compute the intersection by
        iterating over the list and recording transitions from not being
        in a range to being in a range, and vice versa.

        E.g. [1,4] U [2,5] U [7,9] -> [1,+1] [2,+1] [4,-1] [5,-1]
        [7,+1] [9,-1]. Then, summing the second component as we
        traverse, and looking for 0->1 and 1->0 transitions, we end up
        finding the union ranges [1,5], [7,9]

        In order to extend this to 2d axis aligned rectangles, we
        decompose rectangles into top and bottom edges that add or
        remove a range from the 1d data data structure. Before we add or
        remove a range to the 1d data structure we accumulate area equal
        to the current 1d coverage multiplied by the delta-y from the
        last point at which we updated the coverage.

1  4  7   11 14  18
1     +------+         [4,+1], [11,-1] cov=7 area += 0
2  +----------------+  [1,+1], [4,+1], [11,-1], [18,-1], cov=17, rea += 7*1
3  |  |  +------+   |  [1,+1], [4,+1], [7,+1], [11,-1], [14,-1], [18,-1], cov=17 area += 17*1
4  |  +------+  |   |  [1,+1], [7,+1], [14,-1], [18,-1], cov=17 area += 17*1
5  +----------------+  [7,+1], [14,-1] cov=7 area += 17*1
6        +------+      [] area += 7*1
    */
    @JvmStatic
    fun calculatePixelsOfCoverage(screenRect: Rect?, coverageRects: List<Rect>): Int {
        if (coverageRects.isEmpty()) {
            return 0
        }

        // Always allocate enough space for all passed rects and never trim allocations as a result
        // of clipping
        if ((if (sClippedRects == null) 0 else sClippedRects!!.size) < coverageRects.size) {
            sClippedRects = arrayOfNulls(coverageRects.size)
        }
        var numClippedRects = 0
        for (i in coverageRects.indices) {
            val clipRect = coverageRects[i]
            if (clipRect.intersect(screenRect!!)) { // This line may modify he the value of the passed
                // in coverage rects
                sClippedRects!![numClippedRects++] = clipRect
            }
        }
        if (numClippedRects == 0) {
            return 0
        }
        val maxSegments = numClippedRects * 2
        var numVerticalSegments = 0
        if ((if (sHorizontalSegments == null) 0 else sHorizontalSegments!!.size) < maxSegments) {
            sHorizontalSegments = arrayOfNulls(maxSegments)
            sVerticalSegments = arrayOfNulls(maxSegments)
            for (i in 0 until maxSegments) {
                sHorizontalSegments!![i] = HorizontalSegment()
                sVerticalSegments[i] = VerticalSegment()
            }
        }
        run {
            var i = 0
            while (i < maxSegments) {
                val coverageRect = sClippedRects!![i / 2]
                sHorizontalSegments!![i]!![coverageRect!!.left, coverageRect.top, coverageRect.bottom] =
                    SegmentType.START
                sHorizontalSegments!![i + 1]!![coverageRect.right, coverageRect.top, coverageRect.bottom] =
                    SegmentType.END
                i += 2
            }
        }
        Arrays.sort(sHorizontalSegments!!, 0, maxSegments)
        var prev_x = -1
        var coveredPixels = 0
        for (i in 0 until maxSegments) {
            val hSegment = sHorizontalSegments!![i]
            coveredPixels += (getCoverageOfVerticalSegments(
                sVerticalSegments, numVerticalSegments
            ) * (hSegment!!.mX - prev_x))
            sVerticalSegment1[hSegment.mTop] = SegmentType.START
            sVerticalSegment2[hSegment.mBottom] = SegmentType.END
            if (hSegment.mSegmentType == SegmentType.START) {
                insertSorted(
                    sVerticalSegments, numVerticalSegments, sVerticalSegment1, maxSegments
                )
                numVerticalSegments++
                insertSorted(
                    sVerticalSegments, numVerticalSegments, sVerticalSegment2, maxSegments
                )
                numVerticalSegments++
            } else {
                var ret: Int =
                    deleteElement(sVerticalSegments, numVerticalSegments, sVerticalSegment1)
                assert(ret != -1)
                numVerticalSegments = ret
                ret = deleteElement(sVerticalSegments, numVerticalSegments, sVerticalSegment2)
                assert(ret != -1)
                numVerticalSegments = ret
            }
            prev_x = hSegment.mX
        }
        return coveredPixels
    }

    /**
     * Segment Type Constants
     */
    @Retention(AnnotationRetention.SOURCE)
    @IntDef(SegmentType.START, SegmentType.END)
    private annotation class SegmentType {
        companion object {
            const val START = 0
            const val END = 1
        }
    }

    private class HorizontalSegment : Comparable<HorizontalSegment> {
        var mX = 0
        var mTop = 0
        var mBottom = 0

        @SegmentType
        var mSegmentType = 0

        init {
            set(0, 0, 0, SegmentType.START)
        }

        operator fun set(x: Int, top: Int, bottom: Int, @SegmentType segmentType: Int) {
            mX = x
            mTop = top
            mBottom = bottom
            mSegmentType = segmentType
        }

        override fun compareTo(other: HorizontalSegment): Int {
            return if (mX == other.mX) {
                compareSegmentTypes(mSegmentType, other.mSegmentType)
            } else mX - other.mX
        }
    }

    private class VerticalSegment : Comparable<VerticalSegment> {
        var mY = 0

        @SegmentType
        var mSegmentType = 0

        init {
            set(0, SegmentType.START)
        }

        operator fun set(y: Int, @SegmentType segmentType: Int) {
            mY = y
            mSegmentType = segmentType
        }

        fun set(other: VerticalSegment?) {
            set(other!!.mY, other.mSegmentType)
        }

        override fun compareTo(other: VerticalSegment): Int {
            return if (mY == other.mY) {
                compareSegmentTypes(mSegmentType, other.mSegmentType)
            } else mY - other.mY
        }
    }
}