//
// This file was generated by third_party/jni_zero/jni_generator.py
//
package org.chromium.android_webview;

import org.jni_zero.CheckDiscard;
import org.jni_zero.JniStaticTestMocker;
import org.jni_zero.NativeLibraryLoadedStatus;
import org.jni_zero.GEN_JNI;
import android.content.Context;
import android.content.res.AssetManager;
import android.net.Uri;
import android.util.Log;
import android.util.TypedValue;
import org.jni_zero.CalledByNative;
import org.jni_zero.JNINamespace;
import org.jni_zero.NativeMethods;
import org.chromium.android_webview.common.Lifetime;
import org.chromium.base.ContextUtils;
import org.chromium.url.GURL;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLConnection;
import java.util.List;
import java.util.zip.GZIPInputStream;

@CheckDiscard("crbug.com/993421")
class AndroidProtocolHandlerJni implements AndroidProtocolHandler.Natives {
  private static AndroidProtocolHandler.Natives testInstance;

  public static final JniStaticTestMocker<AndroidProtocolHandler.Natives> TEST_HOOKS =
      new JniStaticTestMocker<AndroidProtocolHandler.Natives>() {
    @Override
    public void setInstanceForTesting(AndroidProtocolHandler.Natives instance) {
      if (!GEN_JNI.TESTING_ENABLED) {
        throw new RuntimeException(
            "Tried to set a JNI mock when mocks aren't enabled!");
      }
      testInstance = instance;
    }
  };

  @Override
  public String getAndroidAssetPath() {
    return (String) GEN_JNI.org_chromium_android_1webview_AndroidProtocolHandler_getAndroidAssetPath();
  }

  @Override
  public String getAndroidResourcePath() {
    return (String) GEN_JNI.org_chromium_android_1webview_AndroidProtocolHandler_getAndroidResourcePath();
  }

  @Override
  public String getWellKnownMimeType(String path) {
    return (String) GEN_JNI.org_chromium_android_1webview_AndroidProtocolHandler_getWellKnownMimeType(path);
  }

  public static AndroidProtocolHandler.Natives get() {
    if (GEN_JNI.TESTING_ENABLED) {
      if (testInstance != null) {
        return testInstance;
      }
      if (GEN_JNI.REQUIRE_MOCK) {
        throw new UnsupportedOperationException(
            "No mock found for the native implementation of AndroidProtocolHandler.Natives. "
            + "The current configuration requires implementations be mocked.");
      }
    }
    NativeLibraryLoadedStatus.checkLoaded();
    return new AndroidProtocolHandlerJni();
  }
}
