//
// This file was generated by third_party/jni_zero/jni_generator.py
//
package org.chromium.components.autofill;

import org.chromium.content_public.browser.WebContents;
import org.jni_zero.CheckDiscard;
import org.jni_zero.GEN_JNI;
import org.jni_zero.JniStaticTestMocker;
import org.jni_zero.NativeLibraryLoadedStatus;

@CheckDiscard("crbug.com/993421")
class AutofillProviderTestHelperJni implements AutofillProviderTestHelper.Natives {
    private static AutofillProviderTestHelper.Natives testInstance;

    public static final JniStaticTestMocker<AutofillProviderTestHelper.Natives> TEST_HOOKS = new JniStaticTestMocker<AutofillProviderTestHelper.Natives>() {
        @Override
        public void setInstanceForTesting(AutofillProviderTestHelper.Natives instance) {
            if (!GEN_JNI.TESTING_ENABLED) {
                throw new RuntimeException("Tried to set a JNI mock when mocks aren't enabled!");
            }
            testInstance = instance;
        }
    };

    @Override
    public void disableDownloadServerForTesting() {
        GEN_JNI.org_chromium_components_autofill_AutofillProviderTestHelper_disableDownloadServerForTesting();
    }

    @Override
    public void simulateMainFrameAutofillQueryFailedForTesting(WebContents webContents) {
        GEN_JNI.org_chromium_components_autofill_AutofillProviderTestHelper_simulateMainFrameAutofillQueryFailedForTesting(webContents);
    }

    @Override
    public boolean simulateMainFrameAutofillServerResponseForTesting(WebContents webContents, String[] fieldIds, int[] fieldTypes) {
        return (boolean) GEN_JNI.org_chromium_components_autofill_AutofillProviderTestHelper_simulateMainFrameAutofillServerResponseForTesting(webContents, fieldIds, fieldTypes);
    }

    @Override
    public boolean simulateMainFramePredictionsAutofillServerResponseForTesting(WebContents webContents, String[] fieldIds, int[][] fieldTypes) {
        return (boolean) GEN_JNI.org_chromium_components_autofill_AutofillProviderTestHelper_simulateMainFramePredictionsAutofillServerResponseForTesting(webContents, fieldIds, fieldTypes);
    }

    public static AutofillProviderTestHelper.Natives get() {
        if (GEN_JNI.TESTING_ENABLED) {
            if (testInstance != null) {
                return testInstance;
            }
            if (GEN_JNI.REQUIRE_MOCK) {
                throw new UnsupportedOperationException("No mock found for the native implementation of AutofillProviderTestHelper.Natives. " + "The current configuration requires implementations be mocked.");
            }
        }
        NativeLibraryLoadedStatus.checkLoaded();
        return new AutofillProviderTestHelperJni();
    }
}