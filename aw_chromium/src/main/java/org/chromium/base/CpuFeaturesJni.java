//
// This file was generated by third_party/jni_zero/jni_generator.py
//
package org.chromium.base;

import org.jni_zero.CheckDiscard;
import org.jni_zero.JniStaticTestMocker;
import org.jni_zero.NativeLibraryLoadedStatus;
import org.jni_zero.GEN_JNI;
import org.jni_zero.JNINamespace;
import org.jni_zero.NativeMethods;

@CheckDiscard("crbug.com/993421")
class CpuFeaturesJni implements CpuFeatures.Natives {
  private static CpuFeatures.Natives testInstance;

  public static final JniStaticTestMocker<CpuFeatures.Natives> TEST_HOOKS =
      new JniStaticTestMocker<CpuFeatures.Natives>() {
    @Override
    public void setInstanceForTesting(CpuFeatures.Natives instance) {
      if (!GEN_JNI.TESTING_ENABLED) {
        throw new RuntimeException(
            "Tried to set a JNI mock when mocks aren't enabled!");
      }
      testInstance = instance;
    }
  };

  @Override
  public int getCoreCount() {
    return (int) GEN_JNI.org_chromium_base_CpuFeatures_getCoreCount();
  }

  @Override
  public long getCpuFeatures() {
    return (long) GEN_JNI.org_chromium_base_CpuFeatures_getCpuFeatures();
  }

  public static CpuFeatures.Natives get() {
    if (GEN_JNI.TESTING_ENABLED) {
      if (testInstance != null) {
        return testInstance;
      }
      if (GEN_JNI.REQUIRE_MOCK) {
        throw new UnsupportedOperationException(
            "No mock found for the native implementation of CpuFeatures.Natives. "
            + "The current configuration requires implementations be mocked.");
      }
    }
    NativeLibraryLoadedStatus.checkLoaded();
    return new CpuFeaturesJni();
  }
}
