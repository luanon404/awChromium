//
// This file was generated by third_party/jni_zero/jni_generator.py
//
package org.chromium.components.autofill;

import org.jni_zero.CheckDiscard;
import org.jni_zero.JniStaticTestMocker;
import org.jni_zero.NativeLibraryLoadedStatus;
import org.jni_zero.GEN_JNI;
import android.text.format.DateUtils;
import org.jni_zero.CalledByNative;
import org.jni_zero.JNINamespace;
import org.jni_zero.NativeMethods;
import org.chromium.base.ResettersForTesting;
import org.chromium.base.ThreadUtils;

@CheckDiscard("crbug.com/993421")
class SubKeyRequesterJni implements SubKeyRequester.Natives {
  private static SubKeyRequester.Natives testInstance;

  public static final JniStaticTestMocker<SubKeyRequester.Natives> TEST_HOOKS =
      new JniStaticTestMocker<SubKeyRequester.Natives>() {
    @Override
    public void setInstanceForTesting(SubKeyRequester.Natives instance) {
      if (!GEN_JNI.TESTING_ENABLED) {
        throw new RuntimeException(
            "Tried to set a JNI mock when mocks aren't enabled!");
      }
      testInstance = instance;
    }
  };

  @Override
  public void cancelPendingGetSubKeys(long nativeSubKeyRequester) {
    GEN_JNI.org_chromium_components_autofill_SubKeyRequester_cancelPendingGetSubKeys(nativeSubKeyRequester);
  }

  @Override
  public void loadRulesForSubKeys(long nativeSubKeyRequester, String regionCode) {
    GEN_JNI.org_chromium_components_autofill_SubKeyRequester_loadRulesForSubKeys(nativeSubKeyRequester, regionCode);
  }

  @Override
  public void startRegionSubKeysRequest(long nativeSubKeyRequester, String regionCode, int timeoutSeconds, SubKeyRequester.GetSubKeysRequestDelegate delegate) {
    GEN_JNI.org_chromium_components_autofill_SubKeyRequester_startRegionSubKeysRequest(nativeSubKeyRequester, regionCode, timeoutSeconds, delegate);
  }

  public static SubKeyRequester.Natives get() {
    if (GEN_JNI.TESTING_ENABLED) {
      if (testInstance != null) {
        return testInstance;
      }
      if (GEN_JNI.REQUIRE_MOCK) {
        throw new UnsupportedOperationException(
            "No mock found for the native implementation of SubKeyRequester.Natives. "
            + "The current configuration requires implementations be mocked.");
      }
    }
    NativeLibraryLoadedStatus.checkLoaded();
    return new SubKeyRequesterJni();
  }
}
