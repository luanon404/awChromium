// FilePickerStartInOptionsUnion.java is auto generated by mojom_bindings_generator.py, do not edit


// Copyright 2014 The Chromium Authors
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.

// This file is autogenerated by:
//     mojo/public/tools/bindings/mojom_bindings_generator.py
// For:
//     third_party/blink/public/mojom/file_system_access/file_system_access_manager.mojom
//

package org.chromium.blink.mojom;

import androidx.annotation.IntDef;


public final class FilePickerStartInOptionsUnion extends org.chromium.mojo.bindings.Union {

    public static final class Tag {
        public static final int WellKnownDirectory = 0;
        public static final int DirectoryToken = 1;
    };
    private int mWellKnownDirectory;
    private FileSystemAccessTransferToken mDirectoryToken;

    public void setWellKnownDirectory(int wellKnownDirectory) {
        this.mTag = Tag.WellKnownDirectory;
        this.mWellKnownDirectory = wellKnownDirectory;
    }

    public int getWellKnownDirectory() {
        assert this.mTag == Tag.WellKnownDirectory;
        return this.mWellKnownDirectory;
    }

    public void setDirectoryToken(FileSystemAccessTransferToken directoryToken) {
        this.mTag = Tag.DirectoryToken;
        this.mDirectoryToken = directoryToken;
    }

    public FileSystemAccessTransferToken getDirectoryToken() {
        assert this.mTag == Tag.DirectoryToken;
        return this.mDirectoryToken;
    }


    @Override
    protected final void encode(org.chromium.mojo.bindings.Encoder encoder0, int offset) {
        encoder0.encode(org.chromium.mojo.bindings.BindingsHelper.UNION_SIZE, offset);
        encoder0.encode(this.mTag, offset + 4);
        switch (mTag) {
            case Tag.WellKnownDirectory: {
                
                encoder0.encode(this.mWellKnownDirectory, offset + 8);
                break;
            }
            case Tag.DirectoryToken: {
                
                encoder0.encode(this.mDirectoryToken, offset + 8, false, FileSystemAccessTransferToken.MANAGER);
                break;
            }
            default: {
                break;
            }
        }
    }

    public static FilePickerStartInOptionsUnion deserialize(org.chromium.mojo.bindings.Message message) {
        return decode(new org.chromium.mojo.bindings.Decoder(message).decoderForSerializedUnion(), 0);
    }

    public static final FilePickerStartInOptionsUnion decode(org.chromium.mojo.bindings.Decoder decoder0, int offset) {
        org.chromium.mojo.bindings.DataHeader dataHeader = decoder0.readDataHeaderForUnion(offset);
        if (dataHeader.size == 0) {
            return null;
        }
        FilePickerStartInOptionsUnion result = new FilePickerStartInOptionsUnion();
        switch (dataHeader.elementsOrVersion) {
            case Tag.WellKnownDirectory: {
                
                result.mWellKnownDirectory = decoder0.readInt(offset + org.chromium.mojo.bindings.DataHeader.HEADER_SIZE);
                    WellKnownDirectory.validate(result.mWellKnownDirectory);
                    result.mWellKnownDirectory = WellKnownDirectory.toKnownValue(result.mWellKnownDirectory);
                result.mTag = Tag.WellKnownDirectory;
                break;
            }
            case Tag.DirectoryToken: {
                
                result.mDirectoryToken = decoder0.readServiceInterface(offset + org.chromium.mojo.bindings.DataHeader.HEADER_SIZE, false, FileSystemAccessTransferToken.MANAGER);
                result.mTag = Tag.DirectoryToken;
                break;
            }
            default: {
                break;
            }
        }
        return result;
    }
}