// ImageDownloader.java is auto generated by mojom_bindings_generator.py, do not edit


// Copyright 2014 The Chromium Authors
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.

// This file is autogenerated by:
//     mojo/public/tools/bindings/mojom_bindings_generator.py
// For:
//     third_party/blink/public/mojom/image_downloader/image_downloader.mojom
//

package org.chromium.blink.mojom;

import androidx.annotation.IntDef;


public interface ImageDownloader extends org.chromium.mojo.bindings.Interface {



    public interface Proxy extends ImageDownloader, org.chromium.mojo.bindings.Interface.Proxy {
    }

    Manager<ImageDownloader, ImageDownloader.Proxy> MANAGER = ImageDownloader_Internal.MANAGER;

    void downloadImage(
org.chromium.url.mojom.Url url, boolean isFavicon, org.chromium.gfx.mojom.Size preferredSize, int maxBitmapSize, boolean bypassCache, 
DownloadImage_Response callback);

    interface DownloadImage_Response extends org.chromium.mojo.bindings.Callbacks.Callback3<Integer, org.chromium.skia.mojom.BitmapN32[], org.chromium.gfx.mojom.Size[]> { }


}
