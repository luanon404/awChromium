//
// This file was generated by third_party/jni_zero/jni_generator.py
//
package org.chromium.base.library_loader;

import org.jni_zero.CheckDiscard;
import org.jni_zero.JniStaticTestMocker;
import org.jni_zero.NativeLibraryLoadedStatus;
import org.jni_zero.GEN_JNI;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import android.os.Bundle;
import android.system.Os;
import androidx.annotation.IntDef;
import androidx.annotation.VisibleForTesting;
import org.jni_zero.JNINamespace;
import org.jni_zero.NativeLibraryLoadedStatus;
import org.jni_zero.NativeLibraryLoadedStatus.NativeLibraryLoadedStatusProvider;
import org.jni_zero.NativeMethods;
import org.chromium.base.BaseSwitches;
import org.chromium.base.Callback;
import org.chromium.base.CommandLine;
import org.chromium.base.ContextUtils;
import org.chromium.base.Log;
import org.chromium.base.ResettersForTesting;
import org.chromium.base.StrictModeContext;
import org.chromium.base.TimeUtils.CurrentThreadTimeMillisTimer;
import org.chromium.base.TimeUtils.UptimeMillisTimer;
import org.chromium.base.TraceEvent;
import org.chromium.base.metrics.RecordHistogram;
import org.chromium.base.metrics.UmaRecorderHolder;
import org.chromium.build.BuildConfig;
import org.chromium.build.NativeLibraries;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import javax.annotation.concurrent.GuardedBy;

@CheckDiscard("crbug.com/993421")
class LibraryLoaderJni implements LibraryLoader.Natives {
  private static LibraryLoader.Natives testInstance;

  public static final JniStaticTestMocker<LibraryLoader.Natives> TEST_HOOKS =
      new JniStaticTestMocker<LibraryLoader.Natives>() {
    @Override
    public void setInstanceForTesting(LibraryLoader.Natives instance) {
      if (!GEN_JNI.TESTING_ENABLED) {
        throw new RuntimeException(
            "Tried to set a JNI mock when mocks aren't enabled!");
      }
      testInstance = instance;
    }
  };

  @Override
  public boolean libraryLoaded(int processType) {
    return (boolean) GEN_JNI.org_chromium_base_library_1loader_LibraryLoader_libraryLoaded(processType);
  }

  public static LibraryLoader.Natives get() {
    if (GEN_JNI.TESTING_ENABLED) {
      if (testInstance != null) {
        return testInstance;
      }
      if (GEN_JNI.REQUIRE_MOCK) {
        throw new UnsupportedOperationException(
            "No mock found for the native implementation of LibraryLoader.Natives. "
            + "The current configuration requires implementations be mocked.");
      }
    }
    NativeLibraryLoadedStatus.checkLoaded();
    return new LibraryLoaderJni();
  }
}
