//
// This file was generated by third_party/jni_zero/jni_generator.py
//
package org.chromium.base.process_launcher;

import org.jni_zero.CheckDiscard;
import org.jni_zero.JniStaticTestMocker;
import org.jni_zero.NativeLibraryLoadedStatus;
import org.jni_zero.GEN_JNI;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.os.Binder;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Parcelable;
import android.os.Process;
import android.os.RemoteException;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.SparseArray;
import org.jni_zero.JNINamespace;
import org.jni_zero.NativeMethods;
import org.chromium.base.BaseSwitches;
import org.chromium.base.CommandLine;
import org.chromium.base.ContextUtils;
import org.chromium.base.EarlyTraceEvent;
import org.chromium.base.Log;
import org.chromium.base.MemoryPressureLevel;
import org.chromium.base.ThreadUtils;
import org.chromium.base.compat.ApiHelperForN;
import org.chromium.base.library_loader.LibraryLoader;
import org.chromium.base.memory.MemoryPressureMonitor;
import org.chromium.base.metrics.RecordHistogram;
import java.util.List;
import javax.annotation.concurrent.GuardedBy;

@CheckDiscard("crbug.com/993421")
class ChildProcessServiceJni implements ChildProcessService.Natives {
  private static ChildProcessService.Natives testInstance;

  public static final JniStaticTestMocker<ChildProcessService.Natives> TEST_HOOKS =
      new JniStaticTestMocker<ChildProcessService.Natives>() {
    @Override
    public void setInstanceForTesting(ChildProcessService.Natives instance) {
      if (!GEN_JNI.TESTING_ENABLED) {
        throw new RuntimeException(
            "Tried to set a JNI mock when mocks aren't enabled!");
      }
      testInstance = instance;
    }
  };

  @Override
  public void dumpProcessStack() {
    GEN_JNI.org_chromium_base_process_1launcher_ChildProcessService_dumpProcessStack();
  }

  @Override
  public void exitChildProcess() {
    GEN_JNI.org_chromium_base_process_1launcher_ChildProcessService_exitChildProcess();
  }

  @Override
  public void registerFileDescriptors(String[] keys, int[] id, int[] fd, long[] offset, long[] size) {
    GEN_JNI.org_chromium_base_process_1launcher_ChildProcessService_registerFileDescriptors(keys, id, fd, offset, size);
  }

  public static ChildProcessService.Natives get() {
    if (GEN_JNI.TESTING_ENABLED) {
      if (testInstance != null) {
        return testInstance;
      }
      if (GEN_JNI.REQUIRE_MOCK) {
        throw new UnsupportedOperationException(
            "No mock found for the native implementation of ChildProcessService.Natives. "
            + "The current configuration requires implementations be mocked.");
      }
    }
    NativeLibraryLoadedStatus.checkLoaded();
    return new ChildProcessServiceJni();
  }
}
