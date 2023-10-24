// Copyright 2023 The Chromium Authors
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.

// This file is autogenerated by
//     java_cpp_enum.py
// From
//     ../../ui/gfx/overlay_transform.h

package org.chromium.ui.gfx;

import androidx.annotation.IntDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@IntDef({OverlayTransform.INVALID, OverlayTransform.NONE, OverlayTransform.FLIP_HORIZONTAL, OverlayTransform.FLIP_VERTICAL, OverlayTransform.ROTATE_90, OverlayTransform.ROTATE_180, OverlayTransform.ROTATE_270, OverlayTransform.LAST})
@Retention(RetentionPolicy.SOURCE)
public @interface OverlayTransform {
    int INVALID = 0;
    int NONE = 1;
    int FLIP_HORIZONTAL = 2;
    int FLIP_VERTICAL = 3;
    int ROTATE_90 = 4;
    int ROTATE_180 = 5;
    int ROTATE_270 = 6;
    int LAST = ROTATE_270;
}