// SerializedStaticBitmapImage.java is auto generated by mojom_bindings_generator.py, do not edit


// Copyright 2014 The Chromium Authors
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.

// This file is autogenerated by:
//     mojo/public/tools/bindings/mojom_bindings_generator.py
// For:
//     third_party/blink/public/mojom/messaging/static_bitmap_image.mojom
//

package org.chromium.blink.mojom;

import androidx.annotation.IntDef;


public final class SerializedStaticBitmapImage extends org.chromium.mojo.bindings.Union {

    public static final class Tag {
        public static final int Bitmap = 0;
        public static final int AcceleratedImage = 1;
    };
    private org.chromium.skia.mojom.BitmapN32 mBitmap;
    private AcceleratedStaticBitmapImage mAcceleratedImage;

    public void setBitmap(org.chromium.skia.mojom.BitmapN32 bitmap) {
        this.mTag = Tag.Bitmap;
        this.mBitmap = bitmap;
    }

    public org.chromium.skia.mojom.BitmapN32 getBitmap() {
        assert this.mTag == Tag.Bitmap;
        return this.mBitmap;
    }

    public void setAcceleratedImage(AcceleratedStaticBitmapImage acceleratedImage) {
        this.mTag = Tag.AcceleratedImage;
        this.mAcceleratedImage = acceleratedImage;
    }

    public AcceleratedStaticBitmapImage getAcceleratedImage() {
        assert this.mTag == Tag.AcceleratedImage;
        return this.mAcceleratedImage;
    }


    @Override
    protected final void encode(org.chromium.mojo.bindings.Encoder encoder0, int offset) {
        encoder0.encode(org.chromium.mojo.bindings.BindingsHelper.UNION_SIZE, offset);
        encoder0.encode(this.mTag, offset + 4);
        switch (mTag) {
            case Tag.Bitmap: {
                
                encoder0.encode(this.mBitmap, offset + 8, false);
                break;
            }
            case Tag.AcceleratedImage: {
                
                encoder0.encode(this.mAcceleratedImage, offset + 8, false);
                break;
            }
            default: {
                break;
            }
        }
    }

    public static SerializedStaticBitmapImage deserialize(org.chromium.mojo.bindings.Message message) {
        return decode(new org.chromium.mojo.bindings.Decoder(message).decoderForSerializedUnion(), 0);
    }

    public static final SerializedStaticBitmapImage decode(org.chromium.mojo.bindings.Decoder decoder0, int offset) {
        org.chromium.mojo.bindings.DataHeader dataHeader = decoder0.readDataHeaderForUnion(offset);
        if (dataHeader.size == 0) {
            return null;
        }
        SerializedStaticBitmapImage result = new SerializedStaticBitmapImage();
        switch (dataHeader.elementsOrVersion) {
            case Tag.Bitmap: {
                
                org.chromium.mojo.bindings.Decoder decoder1 = decoder0.readPointer(offset + org.chromium.mojo.bindings.DataHeader.HEADER_SIZE, false);
                result.mBitmap = org.chromium.skia.mojom.BitmapN32.decode(decoder1);
                result.mTag = Tag.Bitmap;
                break;
            }
            case Tag.AcceleratedImage: {
                
                org.chromium.mojo.bindings.Decoder decoder1 = decoder0.readPointer(offset + org.chromium.mojo.bindings.DataHeader.HEADER_SIZE, false);
                result.mAcceleratedImage = AcceleratedStaticBitmapImage.decode(decoder1);
                result.mTag = Tag.AcceleratedImage;
                break;
            }
            default: {
                break;
            }
        }
        return result;
    }
}