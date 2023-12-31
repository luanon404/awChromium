//
// This file was generated by third_party/jni_zero/jni_generator.py
//
package org.chromium.components.permissions;

import org.jni_zero.CheckDiscard;
import org.jni_zero.JniStaticTestMocker;
import org.jni_zero.NativeLibraryLoadedStatus;
import org.jni_zero.GEN_JNI;
import org.jni_zero.JNINamespace;
import org.jni_zero.NativeMethods;
import org.chromium.base.FeatureMap;

@CheckDiscard("crbug.com/993421")
public class PermissionsAndroidFeatureMapJni implements PermissionsAndroidFeatureMap.Natives {
  private static PermissionsAndroidFeatureMap.Natives testInstance;

  public static final JniStaticTestMocker<PermissionsAndroidFeatureMap.Natives> TEST_HOOKS =
      new JniStaticTestMocker<PermissionsAndroidFeatureMap.Natives>() {
    @Override
    public void setInstanceForTesting(PermissionsAndroidFeatureMap.Natives instance) {
      if (!GEN_JNI.TESTING_ENABLED) {
        throw new RuntimeException(
            "Tried to set a JNI mock when mocks aren't enabled!");
      }
      testInstance = instance;
    }
  };

  @Override
  public long getNativeMap() {
    return (long) GEN_JNI.org_chromium_components_permissions_PermissionsAndroidFeatureMap_getNativeMap();
  }

  public static PermissionsAndroidFeatureMap.Natives get() {
    if (GEN_JNI.TESTING_ENABLED) {
      if (testInstance != null) {
        return testInstance;
      }
      if (GEN_JNI.REQUIRE_MOCK) {
        throw new UnsupportedOperationException(
            "No mock found for the native implementation of PermissionsAndroidFeatureMap.Natives. "
            + "The current configuration requires implementations be mocked.");
      }
    }
    NativeLibraryLoadedStatus.checkLoaded();
    return new PermissionsAndroidFeatureMapJni();
  }
}
