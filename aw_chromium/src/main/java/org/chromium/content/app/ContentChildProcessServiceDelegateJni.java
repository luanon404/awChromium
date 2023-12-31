//
// This file was generated by third_party/jni_zero/jni_generator.py
//
package org.chromium.content.app;

import org.jni_zero.CheckDiscard;
import org.jni_zero.JniStaticTestMocker;
import org.jni_zero.NativeLibraryLoadedStatus;
import org.jni_zero.GEN_JNI;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.SparseArray;
import android.view.Surface;
import org.jni_zero.CalledByNative;
import org.jni_zero.JNINamespace;
import org.jni_zero.NativeMethods;
import org.chromium.base.Log;
import org.chromium.base.ThreadUtils;
import org.chromium.base.UnguessableToken;
import org.chromium.base.library_loader.LibraryLoader;
import org.chromium.base.memory.MemoryPressureUma;
import org.chromium.base.process_launcher.ChildProcessServiceDelegate;
import org.chromium.content.browser.ChildProcessCreationParamsImpl;
import org.chromium.content.browser.ContentChildProcessConstants;
import org.chromium.content.common.IGpuProcessCallback;
import org.chromium.content.common.SurfaceWrapper;
import org.chromium.content_public.common.ContentProcessInfo;
import java.util.List;

@CheckDiscard("crbug.com/993421")
class ContentChildProcessServiceDelegateJni implements ContentChildProcessServiceDelegate.Natives {
  private static ContentChildProcessServiceDelegate.Natives testInstance;

  public static final JniStaticTestMocker<ContentChildProcessServiceDelegate.Natives> TEST_HOOKS =
      new JniStaticTestMocker<ContentChildProcessServiceDelegate.Natives>() {
    @Override
    public void setInstanceForTesting(ContentChildProcessServiceDelegate.Natives instance) {
      if (!GEN_JNI.TESTING_ENABLED) {
        throw new RuntimeException(
            "Tried to set a JNI mock when mocks aren't enabled!");
      }
      testInstance = instance;
    }
  };

  @Override
  public void initChildProcess(ContentChildProcessServiceDelegate caller, int cpuCount, long cpuFeatures) {
    GEN_JNI.org_chromium_content_app_ContentChildProcessServiceDelegate_initChildProcess(caller, cpuCount, cpuFeatures);
  }

  @Override
  public void initMemoryPressureListener() {
    GEN_JNI.org_chromium_content_app_ContentChildProcessServiceDelegate_initMemoryPressureListener();
  }

  @Override
  public void retrieveFileDescriptorsIdsToKeys(ContentChildProcessServiceDelegate caller) {
    GEN_JNI.org_chromium_content_app_ContentChildProcessServiceDelegate_retrieveFileDescriptorsIdsToKeys(caller);
  }

  public static ContentChildProcessServiceDelegate.Natives get() {
    if (GEN_JNI.TESTING_ENABLED) {
      if (testInstance != null) {
        return testInstance;
      }
      if (GEN_JNI.REQUIRE_MOCK) {
        throw new UnsupportedOperationException(
            "No mock found for the native implementation of ContentChildProcessServiceDelegate.Natives. "
            + "The current configuration requires implementations be mocked.");
      }
    }
    NativeLibraryLoadedStatus.checkLoaded();
    return new ContentChildProcessServiceDelegateJni();
  }
}
