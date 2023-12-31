//
// This file was generated by third_party/jni_zero/jni_generator.py
//
package org.chromium.android_webview;

import org.jni_zero.CheckDiscard;
import org.jni_zero.JniStaticTestMocker;
import org.jni_zero.NativeLibraryLoadedStatus;
import org.jni_zero.GEN_JNI;
import androidx.annotation.NonNull;
import org.jni_zero.CalledByNative;
import org.jni_zero.JNINamespace;
import org.jni_zero.NativeMethods;
import org.chromium.base.task.PostTask;
import org.chromium.base.task.TaskTraits;
import org.chromium.content_public.browser.MessagePayload;

@CheckDiscard("crbug.com/993421")
class JsReplyProxyJni implements JsReplyProxy.Natives {
  private static JsReplyProxy.Natives testInstance;

  public static final JniStaticTestMocker<JsReplyProxy.Natives> TEST_HOOKS =
      new JniStaticTestMocker<JsReplyProxy.Natives>() {
    @Override
    public void setInstanceForTesting(JsReplyProxy.Natives instance) {
      if (!GEN_JNI.TESTING_ENABLED) {
        throw new RuntimeException(
            "Tried to set a JNI mock when mocks aren't enabled!");
      }
      testInstance = instance;
    }
  };

  @Override
  public void postMessage(long nativeJsReplyProxy, MessagePayload payload) {
    GEN_JNI.org_chromium_android_1webview_JsReplyProxy_postMessage(nativeJsReplyProxy, payload);
  }

  public static JsReplyProxy.Natives get() {
    if (GEN_JNI.TESTING_ENABLED) {
      if (testInstance != null) {
        return testInstance;
      }
      if (GEN_JNI.REQUIRE_MOCK) {
        throw new UnsupportedOperationException(
            "No mock found for the native implementation of JsReplyProxy.Natives. "
            + "The current configuration requires implementations be mocked.");
      }
    }
    NativeLibraryLoadedStatus.checkLoaded();
    return new JsReplyProxyJni();
  }
}
