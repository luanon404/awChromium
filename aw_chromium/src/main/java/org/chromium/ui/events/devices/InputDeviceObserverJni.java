//
// This file was generated by third_party/jni_zero/jni_generator.py
//
package org.chromium.ui.events.devices;

import org.jni_zero.CheckDiscard;
import org.jni_zero.JniStaticTestMocker;
import org.jni_zero.NativeLibraryLoadedStatus;
import org.jni_zero.GEN_JNI;
import android.content.Context;
import android.hardware.input.InputManager;
import android.hardware.input.InputManager.InputDeviceListener;
import android.util.ArrayMap;
import android.view.InputDevice;
import org.jni_zero.CalledByNative;
import org.jni_zero.JNINamespace;
import org.jni_zero.NativeMethods;
import org.chromium.base.ContextUtils;
import org.chromium.base.ThreadUtils;
import org.chromium.base.metrics.RecordHistogram;

@CheckDiscard("crbug.com/993421")
class InputDeviceObserverJni implements InputDeviceObserver.Natives {
  private static InputDeviceObserver.Natives testInstance;

  public static final JniStaticTestMocker<InputDeviceObserver.Natives> TEST_HOOKS =
      new JniStaticTestMocker<InputDeviceObserver.Natives>() {
    @Override
    public void setInstanceForTesting(InputDeviceObserver.Natives instance) {
      if (!GEN_JNI.TESTING_ENABLED) {
        throw new RuntimeException(
            "Tried to set a JNI mock when mocks aren't enabled!");
      }
      testInstance = instance;
    }
  };

  @Override
  public void inputConfigurationChanged(InputDeviceObserver caller) {
    GEN_JNI.org_chromium_ui_events_devices_InputDeviceObserver_inputConfigurationChanged(caller);
  }

  public static InputDeviceObserver.Natives get() {
    if (GEN_JNI.TESTING_ENABLED) {
      if (testInstance != null) {
        return testInstance;
      }
      if (GEN_JNI.REQUIRE_MOCK) {
        throw new UnsupportedOperationException(
            "No mock found for the native implementation of InputDeviceObserver.Natives. "
            + "The current configuration requires implementations be mocked.");
      }
    }
    NativeLibraryLoadedStatus.checkLoaded();
    return new InputDeviceObserverJni();
  }
}
