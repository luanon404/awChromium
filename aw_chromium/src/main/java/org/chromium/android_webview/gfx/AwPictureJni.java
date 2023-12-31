//
// This file was generated by third_party/jni_zero/jni_generator.py
//
package org.chromium.android_webview.gfx;

import org.jni_zero.CheckDiscard;
import org.jni_zero.JniStaticTestMocker;
import org.jni_zero.NativeLibraryLoadedStatus;
import org.jni_zero.GEN_JNI;
import android.graphics.Canvas;
import android.graphics.Picture;
import org.jni_zero.JNINamespace;
import org.jni_zero.NativeMethods;
import org.chromium.android_webview.CleanupReference;
import java.io.OutputStream;

@CheckDiscard("crbug.com/993421")
class AwPictureJni implements AwPicture.Natives {
  private static AwPicture.Natives testInstance;

  public static final JniStaticTestMocker<AwPicture.Natives> TEST_HOOKS =
      new JniStaticTestMocker<AwPicture.Natives>() {
    @Override
    public void setInstanceForTesting(AwPicture.Natives instance) {
      if (!GEN_JNI.TESTING_ENABLED) {
        throw new RuntimeException(
            "Tried to set a JNI mock when mocks aren't enabled!");
      }
      testInstance = instance;
    }
  };

  @Override
  public void destroy(long nativeAwPicture) {
    GEN_JNI.org_chromium_android_1webview_gfx_AwPicture_destroy(nativeAwPicture);
  }

  @Override
  public void draw(long nativeAwPicture, AwPicture caller, Canvas canvas) {
    GEN_JNI.org_chromium_android_1webview_gfx_AwPicture_draw(nativeAwPicture, caller, canvas);
  }

  @Override
  public int getHeight(long nativeAwPicture, AwPicture caller) {
    return (int) GEN_JNI.org_chromium_android_1webview_gfx_AwPicture_getHeight(nativeAwPicture, caller);
  }

  @Override
  public int getWidth(long nativeAwPicture, AwPicture caller) {
    return (int) GEN_JNI.org_chromium_android_1webview_gfx_AwPicture_getWidth(nativeAwPicture, caller);
  }

  public static AwPicture.Natives get() {
    if (GEN_JNI.TESTING_ENABLED) {
      if (testInstance != null) {
        return testInstance;
      }
      if (GEN_JNI.REQUIRE_MOCK) {
        throw new UnsupportedOperationException(
            "No mock found for the native implementation of AwPicture.Natives. "
            + "The current configuration requires implementations be mocked.");
      }
    }
    NativeLibraryLoadedStatus.checkLoaded();
    return new AwPictureJni();
  }
}
