//
// This file was generated by third_party/jni_zero/jni_generator.py
//
package org.chromium.ui.base;

import org.jni_zero.CheckDiscard;
import org.jni_zero.JniStaticTestMocker;
import org.jni_zero.NativeLibraryLoadedStatus;
import org.jni_zero.GEN_JNI;
import android.Manifest;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.ClipData;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.ParcelFileDescriptor;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.webkit.MimeTypeMap;
import androidx.annotation.IntDef;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.VisibleForTesting;
import androidx.core.content.ContextCompat;
import org.jni_zero.CalledByNative;
import org.jni_zero.JNINamespace;
import org.jni_zero.NativeMethods;
import org.chromium.base.ContentUriUtils;
import org.chromium.base.ContextUtils;
import org.chromium.base.FileUtils;
import org.chromium.base.Log;
import org.chromium.base.PackageManagerUtils;
import org.chromium.base.ResettersForTesting;
import org.chromium.base.StrictModeContext;
import org.chromium.base.ThreadUtils;
import org.chromium.base.metrics.RecordHistogram;
import org.chromium.base.task.AsyncTask;
import org.chromium.base.task.PostTask;
import org.chromium.base.task.TaskTraits;
import org.chromium.android_webview.R;
import org.chromium.ui.UiUtils;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

@CheckDiscard("crbug.com/993421")
class SelectFileDialogJni implements SelectFileDialog.Natives {
  private static SelectFileDialog.Natives testInstance;

  public static final JniStaticTestMocker<SelectFileDialog.Natives> TEST_HOOKS =
      new JniStaticTestMocker<SelectFileDialog.Natives>() {
    @Override
    public void setInstanceForTesting(SelectFileDialog.Natives instance) {
      if (!GEN_JNI.TESTING_ENABLED) {
        throw new RuntimeException(
            "Tried to set a JNI mock when mocks aren't enabled!");
      }
      testInstance = instance;
    }
  };

  @Override
  public void onContactsSelected(long nativeSelectFileDialogImpl, SelectFileDialog caller, String contacts) {
    GEN_JNI.org_chromium_ui_base_SelectFileDialog_onContactsSelected(nativeSelectFileDialogImpl, caller, contacts);
  }

  @Override
  public void onFileNotSelected(long nativeSelectFileDialogImpl, SelectFileDialog caller) {
    GEN_JNI.org_chromium_ui_base_SelectFileDialog_onFileNotSelected(nativeSelectFileDialogImpl, caller);
  }

  @Override
  public void onFileSelected(long nativeSelectFileDialogImpl, SelectFileDialog caller, String filePath, String displayName) {
    GEN_JNI.org_chromium_ui_base_SelectFileDialog_onFileSelected(nativeSelectFileDialogImpl, caller, filePath, displayName);
  }

  @Override
  public void onMultipleFilesSelected(long nativeSelectFileDialogImpl, SelectFileDialog caller, String[] filePathArray, String[] displayNameArray) {
    GEN_JNI.org_chromium_ui_base_SelectFileDialog_onMultipleFilesSelected(nativeSelectFileDialogImpl, caller, filePathArray, displayNameArray);
  }

  public static SelectFileDialog.Natives get() {
    if (GEN_JNI.TESTING_ENABLED) {
      if (testInstance != null) {
        return testInstance;
      }
      if (GEN_JNI.REQUIRE_MOCK) {
        throw new UnsupportedOperationException(
            "No mock found for the native implementation of SelectFileDialog.Natives. "
            + "The current configuration requires implementations be mocked.");
      }
    }
    NativeLibraryLoadedStatus.checkLoaded();
    return new SelectFileDialogJni();
  }
}
