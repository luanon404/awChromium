// FileSystemAccessAccessHandleFile.java is auto generated by mojom_bindings_generator.py, do not edit


// Copyright 2014 The Chromium Authors
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.

// This file is autogenerated by:
//     mojo/public/tools/bindings/mojom_bindings_generator.py
// For:
//     third_party/blink/public/mojom/file_system_access/file_system_access_file_handle.mojom
//

package org.chromium.blink.mojom;

import androidx.annotation.IntDef;


public final class FileSystemAccessAccessHandleFile extends org.chromium.mojo.bindings.Union {

    public static final class Tag {
        public static final int RegularFile = 0;
        public static final int IncognitoFileDelegate = 1;
    };
    private FileSystemAccessRegularFile mRegularFile;
    private FileSystemAccessFileDelegateHost mIncognitoFileDelegate;

    public void setRegularFile(FileSystemAccessRegularFile regularFile) {
        this.mTag = Tag.RegularFile;
        this.mRegularFile = regularFile;
    }

    public FileSystemAccessRegularFile getRegularFile() {
        assert this.mTag == Tag.RegularFile;
        return this.mRegularFile;
    }

    public void setIncognitoFileDelegate(FileSystemAccessFileDelegateHost incognitoFileDelegate) {
        this.mTag = Tag.IncognitoFileDelegate;
        this.mIncognitoFileDelegate = incognitoFileDelegate;
    }

    public FileSystemAccessFileDelegateHost getIncognitoFileDelegate() {
        assert this.mTag == Tag.IncognitoFileDelegate;
        return this.mIncognitoFileDelegate;
    }


    @Override
    protected final void encode(org.chromium.mojo.bindings.Encoder encoder0, int offset) {
        encoder0.encode(org.chromium.mojo.bindings.BindingsHelper.UNION_SIZE, offset);
        encoder0.encode(this.mTag, offset + 4);
        switch (mTag) {
            case Tag.RegularFile: {
                
                encoder0.encode(this.mRegularFile, offset + 8, false);
                break;
            }
            case Tag.IncognitoFileDelegate: {
                
                encoder0.encode(this.mIncognitoFileDelegate, offset + 8, false, FileSystemAccessFileDelegateHost.MANAGER);
                break;
            }
            default: {
                break;
            }
        }
    }

    public static FileSystemAccessAccessHandleFile deserialize(org.chromium.mojo.bindings.Message message) {
        return decode(new org.chromium.mojo.bindings.Decoder(message).decoderForSerializedUnion(), 0);
    }

    public static final FileSystemAccessAccessHandleFile decode(org.chromium.mojo.bindings.Decoder decoder0, int offset) {
        org.chromium.mojo.bindings.DataHeader dataHeader = decoder0.readDataHeaderForUnion(offset);
        if (dataHeader.size == 0) {
            return null;
        }
        FileSystemAccessAccessHandleFile result = new FileSystemAccessAccessHandleFile();
        switch (dataHeader.elementsOrVersion) {
            case Tag.RegularFile: {
                
                org.chromium.mojo.bindings.Decoder decoder1 = decoder0.readPointer(offset + org.chromium.mojo.bindings.DataHeader.HEADER_SIZE, false);
                result.mRegularFile = FileSystemAccessRegularFile.decode(decoder1);
                result.mTag = Tag.RegularFile;
                break;
            }
            case Tag.IncognitoFileDelegate: {
                
                result.mIncognitoFileDelegate = decoder0.readServiceInterface(offset + org.chromium.mojo.bindings.DataHeader.HEADER_SIZE, false, FileSystemAccessFileDelegateHost.MANAGER);
                result.mTag = Tag.IncognitoFileDelegate;
                break;
            }
            default: {
                break;
            }
        }
        return result;
    }
}