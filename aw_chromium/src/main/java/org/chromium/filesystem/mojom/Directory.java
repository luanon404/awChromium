// Directory.java is auto generated by mojom_bindings_generator.py, do not edit


// Copyright 2014 The Chromium Authors
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.

// This file is autogenerated by:
//     mojo/public/tools/bindings/mojom_bindings_generator.py
// For:
//     components/services/filesystem/public/mojom/directory.mojom
//

package org.chromium.filesystem.mojom;

import androidx.annotation.IntDef;


public interface Directory extends org.chromium.mojo.bindings.Interface {



    public interface Proxy extends Directory, org.chromium.mojo.bindings.Interface.Proxy {
    }

    Manager<Directory, Directory.Proxy> MANAGER = Directory_Internal.MANAGER;

    void read(

Read_Response callback);

    interface Read_Response extends org.chromium.mojo.bindings.Callbacks.Callback2<Integer, DirectoryEntry[]> { }


    void openFileHandle(
String path, int openFlags, 
OpenFileHandle_Response callback);

    interface OpenFileHandle_Response extends org.chromium.mojo.bindings.Callbacks.Callback2<Integer, org.chromium.mojo_base.mojom.File> { }


    void openFileHandles(
FileOpenDetails[] files, 
OpenFileHandles_Response callback);

    interface OpenFileHandles_Response extends org.chromium.mojo.bindings.Callbacks.Callback1<FileOpenResult[]> { }


    void openDirectory(
String path, org.chromium.mojo.bindings.InterfaceRequest<Directory> directory, int openFlags, 
OpenDirectory_Response callback);

    interface OpenDirectory_Response extends org.chromium.mojo.bindings.Callbacks.Callback1<Integer> { }


    void rename(
String path, String newPath, 
Rename_Response callback);

    interface Rename_Response extends org.chromium.mojo.bindings.Callbacks.Callback1<Integer> { }


    void replace(
String path, String newPath, 
Replace_Response callback);

    interface Replace_Response extends org.chromium.mojo.bindings.Callbacks.Callback1<Integer> { }


    void delete(
String path, int deleteFlags, 
Delete_Response callback);

    interface Delete_Response extends org.chromium.mojo.bindings.Callbacks.Callback1<Integer> { }


    void exists(
String path, 
Exists_Response callback);

    interface Exists_Response extends org.chromium.mojo.bindings.Callbacks.Callback2<Integer, Boolean> { }


    void isWritable(
String path, 
IsWritable_Response callback);

    interface IsWritable_Response extends org.chromium.mojo.bindings.Callbacks.Callback2<Integer, Boolean> { }


    void flush(

Flush_Response callback);

    interface Flush_Response extends org.chromium.mojo.bindings.Callbacks.Callback1<Integer> { }


    void statFile(
String path, 
StatFile_Response callback);

    interface StatFile_Response extends org.chromium.mojo.bindings.Callbacks.Callback2<Integer, FileInformation> { }


    void clone(
org.chromium.mojo.bindings.InterfaceRequest<Directory> directory);


    void readEntireFile(
String path, 
ReadEntireFile_Response callback);

    interface ReadEntireFile_Response extends org.chromium.mojo.bindings.Callbacks.Callback2<Integer, byte[]> { }


    void writeFile(
String path, byte[] data, 
WriteFile_Response callback);

    interface WriteFile_Response extends org.chromium.mojo.bindings.Callbacks.Callback1<Integer> { }


}
