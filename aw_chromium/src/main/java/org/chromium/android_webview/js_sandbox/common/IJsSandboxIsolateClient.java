/*
 * This file is auto-generated.  DO NOT MODIFY.
 */
package org.chromium.android_webview.js_sandbox.common;
/**
 * Callbacks for isolate events, not specific to evaluations.
 * @hide
 */
public interface IJsSandboxIsolateClient extends android.os.IInterface
{
  /** Default implementation for IJsSandboxIsolateClient. */
  public static class Default implements org.chromium.android_webview.js_sandbox.common.IJsSandboxIsolateClient
  {
    /**
     * Informs the client that the isolate should now be considered terminated.
     * 
     * @param status  A status code describing the reason for the termination. Must be one of the
     *                constants beginning "TERMINATE_".
     * @param message Unstructured information about the termination. May be null.
     */
    @Override public void onTerminated(int status, java.lang.String message) throws android.os.RemoteException
    {
    }
    @Override
    public android.os.IBinder asBinder() {
      return null;
    }
  }
  /** Local-side IPC implementation stub class. */
  public static abstract class Stub extends android.os.Binder implements org.chromium.android_webview.js_sandbox.common.IJsSandboxIsolateClient
  {
    /** Construct the stub at attach it to the interface. */
    public Stub()
    {
      this.attachInterface(this, DESCRIPTOR);
    }
    /**
     * Cast an IBinder object into an org.chromium.android_webview.js_sandbox.common.IJsSandboxIsolateClient interface,
     * generating a proxy if needed.
     */
    public static org.chromium.android_webview.js_sandbox.common.IJsSandboxIsolateClient asInterface(android.os.IBinder obj)
    {
      if ((obj==null)) {
        return null;
      }
      android.os.IInterface iin = obj.queryLocalInterface(DESCRIPTOR);
      if (((iin!=null)&&(iin instanceof org.chromium.android_webview.js_sandbox.common.IJsSandboxIsolateClient))) {
        return ((org.chromium.android_webview.js_sandbox.common.IJsSandboxIsolateClient)iin);
      }
      return new org.chromium.android_webview.js_sandbox.common.IJsSandboxIsolateClient.Stub.Proxy(obj);
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
        case TRANSACTION_onTerminated:
        {
          int _arg0;
          _arg0 = data.readInt();
          java.lang.String _arg1;
          _arg1 = data.readString();
          this.onTerminated(_arg0, _arg1);
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
    private static class Proxy implements org.chromium.android_webview.js_sandbox.common.IJsSandboxIsolateClient
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
      /**
       * Informs the client that the isolate should now be considered terminated.
       * 
       * @param status  A status code describing the reason for the termination. Must be one of the
       *                constants beginning "TERMINATE_".
       * @param message Unstructured information about the termination. May be null.
       */
      @Override public void onTerminated(int status, java.lang.String message) throws android.os.RemoteException
      {
        android.os.Parcel _data = android.os.Parcel.obtain();
        android.os.Parcel _reply = android.os.Parcel.obtain();
        try {
          _data.writeInterfaceToken(DESCRIPTOR);
          _data.writeInt(status);
          _data.writeString(message);
          boolean _status = mRemote.transact(Stub.TRANSACTION_onTerminated, _data, _reply, 0);
          _reply.readException();
        }
        finally {
          _reply.recycle();
          _data.recycle();
        }
      }
    }
    static final int TRANSACTION_onTerminated = (android.os.IBinder.FIRST_CALL_TRANSACTION + 1);
  }
  public static final java.lang.String DESCRIPTOR = "org.chromium.android_webview.js_sandbox.common.IJsSandboxIsolateClient";
  // These crash codes may be generated on either the client or service side.
  // The isolate terminated for an unknown reason.
  public static final int TERMINATE_UNKNOWN_ERROR = 1;
  // The sandbox died.
  //
  // This is typically generated client-side as the service may die before it gets a chance to
  // send a message to the client.
  public static final int TERMINATE_SANDBOX_DEAD = 2;
  // The isolate exceeded its heap size limit.
  public static final int TERMINATE_MEMORY_LIMIT_EXCEEDED = 3;
  /**
   * Informs the client that the isolate should now be considered terminated.
   * 
   * @param status  A status code describing the reason for the termination. Must be one of the
   *                constants beginning "TERMINATE_".
   * @param message Unstructured information about the termination. May be null.
   */
  public void onTerminated(int status, java.lang.String message) throws android.os.RemoteException;
}
