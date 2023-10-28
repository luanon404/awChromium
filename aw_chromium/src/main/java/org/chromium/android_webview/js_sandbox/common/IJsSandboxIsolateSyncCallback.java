/*
 * This file is auto-generated.  DO NOT MODIFY.
 */
package org.chromium.android_webview.js_sandbox.common;
/**
 * Used to communicate the result of the JavaScript evaluation from the
 * sandbox to the embedding app.
 * This interface is not marked 'oneway' like IJsSandboxIsolateCallback and should be preferred for
 * ordering correctness.
 */
@androidx.annotation.RestrictTo(androidx.annotation.RestrictTo.Scope.LIBRARY)
public interface IJsSandboxIsolateSyncCallback extends android.os.IInterface
{
  /** Default implementation for IJsSandboxIsolateSyncCallback. */
  public static class Default implements org.chromium.android_webview.js_sandbox.common.IJsSandboxIsolateSyncCallback
  {
    /** @param afd      input AssetFileDescriptor containing the return value of JS evaluation */
    @Override public void reportResultWithFd(android.content.res.AssetFileDescriptor afd) throws android.os.RemoteException
    {
    }
    /**
     * @param errorType denotes the type of error. Should be one of the constants in this file
     * @param afd       input AssetFileDescriptor containing the returned error of the JS evaluation
     */
    @Override public void reportErrorWithFd(int errorType, android.content.res.AssetFileDescriptor afd) throws android.os.RemoteException
    {
    }
    @Override
    public android.os.IBinder asBinder() {
      return null;
    }
  }
  /** Local-side IPC implementation stub class. */
  public static abstract class Stub extends android.os.Binder implements org.chromium.android_webview.js_sandbox.common.IJsSandboxIsolateSyncCallback
  {
    /** Construct the stub at attach it to the interface. */
    public Stub()
    {
      this.attachInterface(this, DESCRIPTOR);
    }
    /**
     * Cast an IBinder object into an org.chromium.android_webview.js_sandbox.common.IJsSandboxIsolateSyncCallback interface,
     * generating a proxy if needed.
     */
    public static org.chromium.android_webview.js_sandbox.common.IJsSandboxIsolateSyncCallback asInterface(android.os.IBinder obj)
    {
      if ((obj==null)) {
        return null;
      }
      android.os.IInterface iin = obj.queryLocalInterface(DESCRIPTOR);
      if (((iin!=null)&&(iin instanceof org.chromium.android_webview.js_sandbox.common.IJsSandboxIsolateSyncCallback))) {
        return ((org.chromium.android_webview.js_sandbox.common.IJsSandboxIsolateSyncCallback)iin);
      }
      return new org.chromium.android_webview.js_sandbox.common.IJsSandboxIsolateSyncCallback.Stub.Proxy(obj);
    }
    @Override public android.os.IBinder asBinder()
    {
      return this;
    }
    @Override public boolean onTransact(int code, android.os.Parcel data, android.os.Parcel reply, int flags) throws android.os.RemoteException
    {
      java.lang.String descriptor = DESCRIPTOR;
      if (code >= android.os.IBinder.FIRST_CALL_TRANSACTION && code <= android.os.IBinder.LAST_CALL_TRANSACTION) {
        data.enforceInterface(descriptor);
      }
      switch (code)
      {
        case INTERFACE_TRANSACTION:
        {
          reply.writeString(descriptor);
          return true;
        }
      }
      switch (code)
      {
        case TRANSACTION_reportResultWithFd:
        {
          android.content.res.AssetFileDescriptor _arg0;
          _arg0 = _Parcel.readTypedObject(data, android.content.res.AssetFileDescriptor.CREATOR);
          this.reportResultWithFd(_arg0);
          reply.writeNoException();
          break;
        }
        case TRANSACTION_reportErrorWithFd:
        {
          int _arg0;
          _arg0 = data.readInt();
          android.content.res.AssetFileDescriptor _arg1;
          _arg1 = _Parcel.readTypedObject(data, android.content.res.AssetFileDescriptor.CREATOR);
          this.reportErrorWithFd(_arg0, _arg1);
          reply.writeNoException();
          break;
        }
        default:
        {
          return super.onTransact(code, data, reply, flags);
        }
      }
      return true;
    }
    private static class Proxy implements org.chromium.android_webview.js_sandbox.common.IJsSandboxIsolateSyncCallback
    {
      private android.os.IBinder mRemote;
      Proxy(android.os.IBinder remote)
      {
        mRemote = remote;
      }
      @Override public android.os.IBinder asBinder()
      {
        return mRemote;
      }
      public java.lang.String getInterfaceDescriptor()
      {
        return DESCRIPTOR;
      }
      /** @param afd      input AssetFileDescriptor containing the return value of JS evaluation */
      @Override public void reportResultWithFd(android.content.res.AssetFileDescriptor afd) throws android.os.RemoteException
      {
        android.os.Parcel _data = android.os.Parcel.obtain();
        android.os.Parcel _reply = android.os.Parcel.obtain();
        try {
          _data.writeInterfaceToken(DESCRIPTOR);
          _Parcel.writeTypedObject(_data, afd, 0);
          boolean _status = mRemote.transact(Stub.TRANSACTION_reportResultWithFd, _data, _reply, 0);
          _reply.readException();
        }
        finally {
          _reply.recycle();
          _data.recycle();
        }
      }
      /**
       * @param errorType denotes the type of error. Should be one of the constants in this file
       * @param afd       input AssetFileDescriptor containing the returned error of the JS evaluation
       */
      @Override public void reportErrorWithFd(int errorType, android.content.res.AssetFileDescriptor afd) throws android.os.RemoteException
      {
        android.os.Parcel _data = android.os.Parcel.obtain();
        android.os.Parcel _reply = android.os.Parcel.obtain();
        try {
          _data.writeInterfaceToken(DESCRIPTOR);
          _data.writeInt(errorType);
          _Parcel.writeTypedObject(_data, afd, 0);
          boolean _status = mRemote.transact(Stub.TRANSACTION_reportErrorWithFd, _data, _reply, 0);
          _reply.readException();
        }
        finally {
          _reply.recycle();
          _data.recycle();
        }
      }
    }
    static final int TRANSACTION_reportResultWithFd = (android.os.IBinder.FIRST_CALL_TRANSACTION + 2);
    static final int TRANSACTION_reportErrorWithFd = (android.os.IBinder.FIRST_CALL_TRANSACTION + 3);
  }
  public static final java.lang.String DESCRIPTOR = "org.chromium.android_webview.js_sandbox.common.IJsSandboxIsolateSyncCallback";
  // An exception was thrown during the JS evaluation.
  public static final int JS_EVALUATION_ERROR = 0;
  // The evaluation failed and the isolate crashed due to running out of heap memory.
  public static final int MEMORY_LIMIT_EXCEEDED = 1;
  // The evaluation failed due to IO errors while reading from the file descriptor.
  public static final int FILE_DESCRIPTOR_IO_ERROR = 2;
  /** @param afd      input AssetFileDescriptor containing the return value of JS evaluation */
  public void reportResultWithFd(android.content.res.AssetFileDescriptor afd) throws android.os.RemoteException;
  /**
   * @param errorType denotes the type of error. Should be one of the constants in this file
   * @param afd       input AssetFileDescriptor containing the returned error of the JS evaluation
   */
  public void reportErrorWithFd(int errorType, android.content.res.AssetFileDescriptor afd) throws android.os.RemoteException;
  /** @hide */
  static class _Parcel {
    static private <T> T readTypedObject(
        android.os.Parcel parcel,
        android.os.Parcelable.Creator<T> c) {
      if (parcel.readInt() != 0) {
          return c.createFromParcel(parcel);
      } else {
          return null;
      }
    }
    static private <T extends android.os.Parcelable> void writeTypedObject(
        android.os.Parcel parcel, T value, int parcelableFlags) {
      if (value != null) {
        parcel.writeInt(1);
        value.writeToParcel(parcel, parcelableFlags);
      } else {
        parcel.writeInt(0);
      }
    }
  }
}
