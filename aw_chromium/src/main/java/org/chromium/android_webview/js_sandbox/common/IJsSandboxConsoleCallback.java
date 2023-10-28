/*
 * This file is auto-generated.  DO NOT MODIFY.
 */
package org.chromium.android_webview.js_sandbox.common;
/** Used to relay console messages to the embedding app. */
@androidx.annotation.RestrictTo(androidx.annotation.RestrictTo.Scope.LIBRARY)
public interface IJsSandboxConsoleCallback extends android.os.IInterface
{
  /** Default implementation for IJsSandboxConsoleCallback. */
  public static class Default implements org.chromium.android_webview.js_sandbox.common.IJsSandboxConsoleCallback
  {
    /**
     * Notification of a console message.
     * @param contextGroupId Context group ID.
     * @param level The message (error/verbosity) level.
     * @param message The message body.
     * @param source The source file/expression where the message was generated.
     * @param line Line number of where the message was generated.
     * @param column Column number of where the message was generated.
     * @param trace Stack trace of where the message was generated, which may be null.
     */
    @Override public void consoleMessage(int contextGroupId, int level, java.lang.String message, java.lang.String source, int line, int column, java.lang.String trace) throws android.os.RemoteException
    {
    }
    /**
     * Notification of a console.clear()
     * @param contextGroupId context group ID.
     */
    @Override public void consoleClear(int contextGroupId) throws android.os.RemoteException
    {
    }
    @Override
    public android.os.IBinder asBinder() {
      return null;
    }
  }
  /** Local-side IPC implementation stub class. */
  public static abstract class Stub extends android.os.Binder implements org.chromium.android_webview.js_sandbox.common.IJsSandboxConsoleCallback
  {
    /** Construct the stub at attach it to the interface. */
    public Stub()
    {
      this.attachInterface(this, DESCRIPTOR);
    }
    /**
     * Cast an IBinder object into an org.chromium.android_webview.js_sandbox.common.IJsSandboxConsoleCallback interface,
     * generating a proxy if needed.
     */
    public static org.chromium.android_webview.js_sandbox.common.IJsSandboxConsoleCallback asInterface(android.os.IBinder obj)
    {
      if ((obj==null)) {
        return null;
      }
      android.os.IInterface iin = obj.queryLocalInterface(DESCRIPTOR);
      if (((iin!=null)&&(iin instanceof org.chromium.android_webview.js_sandbox.common.IJsSandboxConsoleCallback))) {
        return ((org.chromium.android_webview.js_sandbox.common.IJsSandboxConsoleCallback)iin);
      }
      return new org.chromium.android_webview.js_sandbox.common.IJsSandboxConsoleCallback.Stub.Proxy(obj);
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
        case TRANSACTION_consoleMessage:
        {
          int _arg0;
          _arg0 = data.readInt();
          int _arg1;
          _arg1 = data.readInt();
          java.lang.String _arg2;
          _arg2 = data.readString();
          java.lang.String _arg3;
          _arg3 = data.readString();
          int _arg4;
          _arg4 = data.readInt();
          int _arg5;
          _arg5 = data.readInt();
          java.lang.String _arg6;
          _arg6 = data.readString();
          this.consoleMessage(_arg0, _arg1, _arg2, _arg3, _arg4, _arg5, _arg6);
          reply.writeNoException();
          break;
        }
        case TRANSACTION_consoleClear:
        {
          int _arg0;
          _arg0 = data.readInt();
          this.consoleClear(_arg0);
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
    private static class Proxy implements org.chromium.android_webview.js_sandbox.common.IJsSandboxConsoleCallback
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
       * Notification of a console message.
       * @param contextGroupId Context group ID.
       * @param level The message (error/verbosity) level.
       * @param message The message body.
       * @param source The source file/expression where the message was generated.
       * @param line Line number of where the message was generated.
       * @param column Column number of where the message was generated.
       * @param trace Stack trace of where the message was generated, which may be null.
       */
      @Override public void consoleMessage(int contextGroupId, int level, java.lang.String message, java.lang.String source, int line, int column, java.lang.String trace) throws android.os.RemoteException
      {
        android.os.Parcel _data = android.os.Parcel.obtain();
        android.os.Parcel _reply = android.os.Parcel.obtain();
        try {
          _data.writeInterfaceToken(DESCRIPTOR);
          _data.writeInt(contextGroupId);
          _data.writeInt(level);
          _data.writeString(message);
          _data.writeString(source);
          _data.writeInt(line);
          _data.writeInt(column);
          _data.writeString(trace);
          boolean _status = mRemote.transact(Stub.TRANSACTION_consoleMessage, _data, _reply, 0);
          _reply.readException();
        }
        finally {
          _reply.recycle();
          _data.recycle();
        }
      }
      /**
       * Notification of a console.clear()
       * @param contextGroupId context group ID.
       */
      @Override public void consoleClear(int contextGroupId) throws android.os.RemoteException
      {
        android.os.Parcel _data = android.os.Parcel.obtain();
        android.os.Parcel _reply = android.os.Parcel.obtain();
        try {
          _data.writeInterfaceToken(DESCRIPTOR);
          _data.writeInt(contextGroupId);
          boolean _status = mRemote.transact(Stub.TRANSACTION_consoleClear, _data, _reply, 0);
          _reply.readException();
        }
        finally {
          _reply.recycle();
          _data.recycle();
        }
      }
    }
    static final int TRANSACTION_consoleMessage = (android.os.IBinder.FIRST_CALL_TRANSACTION + 0);
    static final int TRANSACTION_consoleClear = (android.os.IBinder.FIRST_CALL_TRANSACTION + 1);
  }
  public static final java.lang.String DESCRIPTOR = "org.chromium.android_webview.js_sandbox.common.IJsSandboxConsoleCallback";
  // These must be individual bits so that they can be trivially filtered using a bitmask.
  public static final int CONSOLE_MESSAGE_LEVEL_LOG = 1;
  public static final int CONSOLE_MESSAGE_LEVEL_DEBUG = 2;
  public static final int CONSOLE_MESSAGE_LEVEL_INFO = 4;
  public static final int CONSOLE_MESSAGE_LEVEL_ERROR = 8;
  public static final int CONSOLE_MESSAGE_LEVEL_WARNING = 16;
  /**
   * Notification of a console message.
   * @param contextGroupId Context group ID.
   * @param level The message (error/verbosity) level.
   * @param message The message body.
   * @param source The source file/expression where the message was generated.
   * @param line Line number of where the message was generated.
   * @param column Column number of where the message was generated.
   * @param trace Stack trace of where the message was generated, which may be null.
   */
  public void consoleMessage(int contextGroupId, int level, java.lang.String message, java.lang.String source, int line, int column, java.lang.String trace) throws android.os.RemoteException;
  /**
   * Notification of a console.clear()
   * @param contextGroupId context group ID.
   */
  public void consoleClear(int contextGroupId) throws android.os.RemoteException;
}
