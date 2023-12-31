//
// This file was generated by third_party/jni_zero/jni_generator.py
//
package org.chromium.components.variations;

import org.jni_zero.CheckDiscard;
import org.jni_zero.JniStaticTestMocker;
import org.jni_zero.NativeLibraryLoadedStatus;
import org.jni_zero.GEN_JNI;
import org.jni_zero.JNINamespace;
import org.jni_zero.NativeMethods;
import java.util.HashMap;

@CheckDiscard("crbug.com/993421")
class VariationsAssociatedDataJni implements VariationsAssociatedData.Natives {
  private static VariationsAssociatedData.Natives testInstance;

  public static final JniStaticTestMocker<VariationsAssociatedData.Natives> TEST_HOOKS =
      new JniStaticTestMocker<VariationsAssociatedData.Natives>() {
    @Override
    public void setInstanceForTesting(VariationsAssociatedData.Natives instance) {
      if (!GEN_JNI.TESTING_ENABLED) {
        throw new RuntimeException(
            "Tried to set a JNI mock when mocks aren't enabled!");
      }
      testInstance = instance;
    }
  };

  @Override
  public String getFeedbackVariations() {
    return (String) GEN_JNI.org_chromium_components_variations_VariationsAssociatedData_getFeedbackVariations();
  }

  @Override
  public String getGoogleAppVariations() {
    return (String) GEN_JNI.org_chromium_components_variations_VariationsAssociatedData_getGoogleAppVariations();
  }

  @Override
  public String getVariationParamValue(String trialName, String paramName) {
    return (String) GEN_JNI.org_chromium_components_variations_VariationsAssociatedData_getVariationParamValue(trialName, paramName);
  }

  public static VariationsAssociatedData.Natives get() {
    if (GEN_JNI.TESTING_ENABLED) {
      if (testInstance != null) {
        return testInstance;
      }
      if (GEN_JNI.REQUIRE_MOCK) {
        throw new UnsupportedOperationException(
            "No mock found for the native implementation of VariationsAssociatedData.Natives. "
            + "The current configuration requires implementations be mocked.");
      }
    }
    NativeLibraryLoadedStatus.checkLoaded();
    return new VariationsAssociatedDataJni();
  }
}
