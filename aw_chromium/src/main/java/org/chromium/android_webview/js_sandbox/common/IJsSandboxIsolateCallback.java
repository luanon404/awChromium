/*
 * This file is auto-generated.  DO NOT MODIFY.
 */
package org.chromium.android_webview.js_sandbox.common;
/**
 * Used to communicate the result of the JavaScript evaluation from the
 * sandbox to the embedding app.
 * DEPRECATED INTERFACE! Do not add methods or constants into this file.
 */
@androidx.annotation.RestrictTo(androidx.annotation.RestrictTo.Scope.LIBRARY)
public interface IJsSandboxIsolateCallback extends android.os.IInterface
{
  /** Default implementation for IJsSandboxIsolateCallback. */
  public static class Default implements org.chromium.android_webview.js_sandbox.common.IJsSandboxIsolateCallback
  {
    @Override public void reportResult(java.lang.String result) throws android.os.RemoteException
    {
    }
    // errorType is one of the error constants above.
    @Override public void reportError(int errorType, java.lang.String error) throws android.os.RemoteException
    {
    }
    @Override
    public android.os.IBinder asBinder() {
      return null;
    }
  }
  /** Local-side IPC implementation stub class. */
  public static abstract class Stub extends android.os.Binder implements org.chromium.android_webview.js_sandbox.common.IJsSandboxIsolateCallback
  {
    /** Construct the stub at attach it to the interface. */
    public Stub()
    {
      this.attachInterface(this, DESCRIPTOR);
    }
    /**
     * Cast an IBinder object into an org.chromium.android_webview.js_sandbox.common.IJsSandboxIsolateCallback interface,
     * generating a proxy if needed.
     */
    public static org.chromium.android_webview.js_sandbox.common.IJsSandboxIsolateCallback asInterface(android.os.IBinder obj)
    {
      if ((obj==null)) {
        return null;
      }
      android.os.IInterface iin = obj.queryLocalInterface(DESCRIPTOR);
      if (((iin!=null)&&(iin instanceof org.chromium.android_webview.js_sandbox.common.IJsSandboxIsolateCallback))) {
        return ((org.chromium.android_webview.js_sandbox.common.IJsSandboxIsolateCallback)iin);
      }
      return new org.chromium.android_webview.js_sandbox.common.IJsSandboxIsolateCallback.Stub.Proxy(obj);
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
        case TRANSACTION_reportResult:
        {
          java.lang.String _arg0;
          _arg0 = data.readString();
          this.reportResult(_arg0);
          break;
        }
        case TRANSACTION_reportError:
        {
          int _arg0;
          _arg0 = data.readInt();
          java.lang.String _arg1;
          _arg1 = data.readString();
          this.reportError(_arg0, _arg1);
          break;
        }
        default:
        {
          return super.onTransact(code, data, reply, flags);
        }
      }
      return true;
    }
    private static class Proxy implements org.chromium.android_webview.js_sandbox.common.IJsSandboxIsolateCallback
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
      @Override public void reportResult(java.lang.String result) throws android.os.RemoteException
      {
        android.os.Parcel _data = android.os.Parcel.obtain();
        try {
          _data.writeInterfaceToken(DESCRIPTOR);
          _data.writeString(result);
          boolean _status = mRemote.transact(Stub.TRANSACTION_reportResult, _data, null, android.os.IBinder.FLAG_ONEWAY);
        }
        finally {
          _data.recycle();
        }
      }
      // errorType is one of the error constants above.
      @Override public void reportError(int errorType, java.lang.String error) throws android.os.RemoteException
      {
        android.os.Parcel _data = android.os.Parcel.obtain();
        try {
          _data.writeInterfaceToken(DESCRIPTOR);
          _data.writeInt(errorType);
          _data.writeString(error);
          boolean _status = mRemote.transact(Stub.TRANSACTION_reportError, _data, null, android.os.IBinder.FLAG_ONEWAY);
        }
        finally {
          _data.recycle();
        }
      }
    }
    static final int TRANSACTION_reportResult = (android.os.IBinder.FIRST_CALL_TRANSACTION + 0);
    static final int TRANSACTION_reportError = (android.os.IBinder.FIRST_CALL_TRANSACTION + 1);
  }
  public static final java.lang.String DESCRIPTOR = "org.chromium.android_webview.js_sandbox.common.IJsSandboxIsolateCallback";
  // An exception was thrown during the JS evaluation.
  public static final int JS_EVALUATION_ERROR = 0;
  // The evaluation failed and the isolate crashed due to running out of heap memory.
  public static final int MEMORY_LIMIT_EXCEEDED = 1;
  public void reportResult(java.lang.String result) throws android.os.RemoteException;
  // errorType is one of the error constants above.
  public void reportError(int errorType, java.lang.String error) throws android.os.RemoteException;
}
