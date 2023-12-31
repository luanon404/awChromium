//
// This file was generated by third_party/jni_zero/jni_generator.py
//
package org.chromium.content.browser;

import org.jni_zero.CheckDiscard;
import org.jni_zero.JniStaticTestMocker;
import org.jni_zero.NativeLibraryLoadedStatus;
import org.jni_zero.GEN_JNI;
import org.jni_zero.CalledByNative;
import org.jni_zero.CalledByNativeForTesting;
import org.jni_zero.JNINamespace;
import org.jni_zero.NativeMethods;
import org.chromium.base.MathUtils;
import org.chromium.base.ResettersForTesting;
import org.chromium.content_public.browser.BrowserContextHandle;
import org.chromium.content_public.browser.ContentFeatureList;
import org.chromium.content_public.browser.ContentFeatureMap;
import org.chromium.content_public.browser.HostZoomMap;
import org.chromium.content_public.browser.SiteZoomInfo;
import org.chromium.content_public.browser.WebContents;
import java.util.HashMap;

@CheckDiscard("crbug.com/993421")
public class HostZoomMapImplJni implements HostZoomMapImpl.Natives {
  private static HostZoomMapImpl.Natives testInstance;

  public static final JniStaticTestMocker<HostZoomMapImpl.Natives> TEST_HOOKS =
      new JniStaticTestMocker<HostZoomMapImpl.Natives>() {
    @Override
    public void setInstanceForTesting(HostZoomMapImpl.Natives instance) {
      if (!GEN_JNI.TESTING_ENABLED) {
        throw new RuntimeException(
            "Tried to set a JNI mock when mocks aren't enabled!");
      }
      testInstance = instance;
    }
  };

  @Override
  public SiteZoomInfo[] getAllHostZoomLevels(BrowserContextHandle context) {
    return (SiteZoomInfo[]) GEN_JNI.org_chromium_content_browser_HostZoomMapImpl_getAllHostZoomLevels(context);
  }

  @Override
  public double getDefaultZoomLevel(BrowserContextHandle context) {
    return (double) GEN_JNI.org_chromium_content_browser_HostZoomMapImpl_getDefaultZoomLevel(context);
  }

  @Override
  public double getDesktopSiteZoomScale(WebContents webContents) {
    return (double) GEN_JNI.org_chromium_content_browser_HostZoomMapImpl_getDesktopSiteZoomScale(webContents);
  }

  @Override
  public double getZoomLevel(WebContents webContents) {
    return (double) GEN_JNI.org_chromium_content_browser_HostZoomMapImpl_getZoomLevel(webContents);
  }

  @Override
  public void setDefaultZoomLevel(BrowserContextHandle context, double newDefaultZoomLevel) {
    GEN_JNI.org_chromium_content_browser_HostZoomMapImpl_setDefaultZoomLevel(context, newDefaultZoomLevel);
  }

  @Override
  public void setZoomLevel(WebContents webContents, double newZoomLevel, double adjustedZoomLevel) {
    GEN_JNI.org_chromium_content_browser_HostZoomMapImpl_setZoomLevel(webContents, newZoomLevel, adjustedZoomLevel);
  }

  @Override
  public void setZoomLevelForHost(BrowserContextHandle context, String host, double level) {
    GEN_JNI.org_chromium_content_browser_HostZoomMapImpl_setZoomLevelForHost(context, host, level);
  }

  public static HostZoomMapImpl.Natives get() {
    if (GEN_JNI.TESTING_ENABLED) {
      if (testInstance != null) {
        return testInstance;
      }
      if (GEN_JNI.REQUIRE_MOCK) {
        throw new UnsupportedOperationException(
            "No mock found for the native implementation of HostZoomMapImpl.Natives. "
            + "The current configuration requires implementations be mocked.");
      }
    }
    NativeLibraryLoadedStatus.checkLoaded();
    return new HostZoomMapImplJni();
  }
}
