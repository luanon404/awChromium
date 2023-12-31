//
// This file was generated by third_party/jni_zero/jni_generator.py
//
package org.chromium.content_public.common;

import org.jni_zero.CheckDiscard;
import org.jni_zero.JniStaticTestMocker;
import org.jni_zero.NativeLibraryLoadedStatus;
import org.jni_zero.GEN_JNI;
import org.jni_zero.CalledByNative;
import org.jni_zero.JNINamespace;
import org.jni_zero.NativeMethods;

@CheckDiscard("crbug.com/993421")
class ResourceRequestBodyJni implements ResourceRequestBody.Natives {
  private static ResourceRequestBody.Natives testInstance;

  public static final JniStaticTestMocker<ResourceRequestBody.Natives> TEST_HOOKS =
      new JniStaticTestMocker<ResourceRequestBody.Natives>() {
    @Override
    public void setInstanceForTesting(ResourceRequestBody.Natives instance) {
      if (!GEN_JNI.TESTING_ENABLED) {
        throw new RuntimeException(
            "Tried to set a JNI mock when mocks aren't enabled!");
      }
      testInstance = instance;
    }
  };

  @Override
  public byte[] createResourceRequestBodyFromBytes(byte[] httpBody) {
    return (byte[]) GEN_JNI.org_chromium_content_1public_common_ResourceRequestBody_createResourceRequestBodyFromBytes(httpBody);
  }

  public static ResourceRequestBody.Natives get() {
    if (GEN_JNI.TESTING_ENABLED) {
      if (testInstance != null) {
        return testInstance;
      }
      if (GEN_JNI.REQUIRE_MOCK) {
        throw new UnsupportedOperationException(
            "No mock found for the native implementation of ResourceRequestBody.Natives. "
            + "The current configuration requires implementations be mocked.");
      }
    }
    NativeLibraryLoadedStatus.checkLoaded();
    return new ResourceRequestBodyJni();
  }
}
