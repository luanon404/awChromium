// Copyright 2020 The Chromium Authors. All rights reserved.
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.
package org.chromium.cc.base

/**
 * Contains all of the command line switches that are specific to the cc/ layer.
 */
object CcSwitches {

    // Renders a border around compositor layers to help debug and study
    // layer compositing.
    const val SHOW_COMPOSITED_LAYER_BORDERS = "show-composited-layer-borders"

}