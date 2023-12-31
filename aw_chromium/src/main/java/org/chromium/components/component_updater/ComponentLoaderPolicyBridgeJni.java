//
// This file was generated by third_party/jni_zero/jni_generator.py
//
package org.chromium.components.component_updater;

import org.jni_zero.CheckDiscard;
import org.jni_zero.JniStaticTestMocker;
import org.jni_zero.NativeLibraryLoadedStatus;
import org.jni_zero.GEN_JNI;
import android.os.ParcelFileDescriptor;
import org.jni_zero.CalledByNative;
import org.jni_zero.JNINamespace;
import org.jni_zero.NativeMethods;
import org.chromium.base.LifetimeAssert;
import org.chromium.base.ThreadUtils;
import java.util.Map;

@CheckDiscard("crbug.com/993421")
class ComponentLoaderPolicyBridgeJni implements ComponentLoaderPolicyBridge.Natives {
  private static ComponentLoaderPolicyBridge.Natives testInstance;

  public static final JniStaticTestMocker<ComponentLoaderPolicyBridge.Natives> TEST_HOOKS =
      new JniStaticTestMocker<ComponentLoaderPolicyBridge.Natives>() {
    @Override
    public void setInstanceForTesting(ComponentLoaderPolicyBridge.Natives instance) {
      if (!GEN_JNI.TESTING_ENABLED) {
        throw new RuntimeException(
            "Tried to set a JNI mock when mocks aren't enabled!");
      }
      testInstance = instance;
    }
  };

  @Override
  public void componentLoadFailed(long nativeAndroidComponentLoaderPolicy, int errorCode) {
    GEN_JNI.org_chromium_components_component_1updater_ComponentLoaderPolicyBridge_componentLoadFailed(nativeAndroidComponentLoaderPolicy, errorCode);
  }

  @Override
  public void componentLoaded(long nativeAndroidComponentLoaderPolicy, String[] fileNames, int[] fds) {
    GEN_JNI.org_chromium_components_component_1updater_ComponentLoaderPolicyBridge_componentLoaded(nativeAndroidComponentLoaderPolicy, fileNames, fds);
  }

  @Override
  public String getComponentId(long nativeAndroidComponentLoaderPolicy) {
    return (String) GEN_JNI.org_chromium_components_component_1updater_ComponentLoaderPolicyBridge_getComponentId(nativeAndroidComponentLoaderPolicy);
  }

  public static ComponentLoaderPolicyBridge.Natives get() {
    if (GEN_JNI.TESTING_ENABLED) {
      if (testInstance != null) {
        return testInstance;
      }
      if (GEN_JNI.REQUIRE_MOCK) {
        throw new UnsupportedOperationException(
            "No mock found for the native implementation of ComponentLoaderPolicyBridge.Natives. "
            + "The current configuration requires implementations be mocked.");
      }
    }
    NativeLibraryLoadedStatus.checkLoaded();
    return new ComponentLoaderPolicyBridgeJni();
  }
}
