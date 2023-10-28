/*
 * This file is auto-generated.  DO NOT MODIFY.
 */
package org.chromium.base.process_launcher;
public interface IParentProcess extends android.os.IInterface
{
  /** Default implementation for IParentProcess. */
  public static class Default implements org.chromium.base.process_launcher.IParentProcess
  {
    // Sends the child pid and information from the app zygote (if any) to the
    // parent process. This will be called before any third-party code is
    // loaded, and will be a no-op after the first call.
    //
    // The |zygotePid| must be 0 if the process does not inherit from an app zygote
    // or its app zygote did not produce a usable shared region containing
    // linker relocations (RELRO FD).
    @Override public void finishSetupConnection(int pid, int zygotePid, long zygoteStartupTimeMillis, android.os.Bundle relroBundle) throws android.os.RemoteException
    {
    }
    // Reports exception before calling into native main method. This is before
    // crash reporting is initialized, which means this exception would
    // otherwise not be reported.
    // Not oneway to ensure the browser receives the message before child exits.
    @Override public void reportExceptionInInit(java.lang.String exception) throws android.os.RemoteException
    {
    }
    // Tells the parent proces the child exited cleanly. Not oneway to ensure
    // the browser receives the message before child exits.
    @Override public void reportCleanExit() throws android.os.RemoteException
    {
    }
    @Override
    public android.os.IBinder asBinder() {
      return null;
    }
  }
  /** Local-side IPC implementation stub class. */
  public static abstract class Stub extends android.os.Binder implements org.chromium.base.process_launcher.IParentProcess
  {
    /** Construct the stub at attach it to the interface. */
    public Stub()
    {
      this.attachInterface(this, DESCRIPTOR);
    }
    /**
     * Cast an IBinder object into an org.chromium.base.process_launcher.IParentProcess interface,
     * generating a proxy if needed.
     */
    public static org.chromium.base.process_launcher.IParentProcess asInterface(android.os.IBinder obj)
    {
      if ((obj==null)) {
        return null;
      }
      android.os.IInterface iin = obj.queryLocalInterface(DESCRIPTOR);
      if (((iin!=null)&&(iin instanceof org.chromium.base.process_launcher.IParentProcess))) {
        return ((org.chromium.base.process_launcher.IParentProcess)iin);
      }
      return new org.chromium.base.process_launcher.IParentProcess.Stub.Proxy(obj);
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
        case TRANSACTION_finishSetupConnection:
        {
          int _arg0;
          _arg0 = data.readInt();
          int _arg1;
          _arg1 = data.readInt();
          long _arg2;
          _arg2 = data.readLong();
          android.os.Bundle _arg3;
          _arg3 = _Parcel.readTypedObject(data, android.os.Bundle.CREATOR);
          this.finishSetupConnection(_arg0, _arg1, _arg2, _arg3);
          break;
        }
        case TRANSACTION_reportExceptionInInit:
        {
          java.lang.String _arg0;
          _arg0 = data.readString();
          this.reportExceptionInInit(_arg0);
          reply.writeNoException();
          break;
        }
        case TRANSACTION_reportCleanExit:
        {
          this.reportCleanExit();
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
    private static class Proxy implements org.chromium.base.process_launcher.IParentProcess
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
      // Sends the child pid and information from the app zygote (if any) to the
      // parent process. This will be called before any third-party code is
      // loaded, and will be a no-op after the first call.
      //
      // The |zygotePid| must be 0 if the process does not inherit from an app zygote
      // or its app zygote did not produce a usable shared region containing
      // linker relocations (RELRO FD).
      @Override public void finishSetupConnection(int pid, int zygotePid, long zygoteStartupTimeMillis, android.os.Bundle relroBundle) throws android.os.RemoteException
      {
        android.os.Parcel _data = android.os.Parcel.obtain();
        try {
          _data.writeInterfaceToken(DESCRIPTOR);
          _data.writeInt(pid);
          _data.writeInt(zygotePid);
          _data.writeLong(zygoteStartupTimeMillis);
          _Parcel.writeTypedObject(_data, relroBundle, 0);
          boolean _status = mRemote.transact(Stub.TRANSACTION_finishSetupConnection, _data, null, android.os.IBinder.FLAG_ONEWAY);
        }
        finally {
          _data.recycle();
        }
      }
      // Reports exception before calling into native main method. This is before
      // crash reporting is initialized, which means this exception would
      // otherwise not be reported.
      // Not oneway to ensure the browser receives the message before child exits.
      @Override public void reportExceptionInInit(java.lang.String exception) throws android.os.RemoteException
      {
        android.os.Parcel _data = android.os.Parcel.obtain();
        android.os.Parcel _reply = android.os.Parcel.obtain();
        try {
          _data.writeInterfaceToken(DESCRIPTOR);
          _data.writeString(exception);
          boolean _status = mRemote.transact(Stub.TRANSACTION_reportExceptionInInit, _data, _reply, 0);
          _reply.readException();
        }
        finally {
          _reply.recycle();
          _data.recycle();
        }
      }
      // Tells the parent proces the child exited cleanly. Not oneway to ensure
      // the browser receives the message before child exits.
      @Override public void reportCleanExit() throws android.os.RemoteException
      {
        android.os.Parcel _data = android.os.Parcel.obtain();
        android.os.Parcel _reply = android.os.Parcel.obtain();
        try {
          _data.writeInterfaceToken(DESCRIPTOR);
          boolean _status = mRemote.transact(Stub.TRANSACTION_reportCleanExit, _data, _reply, 0);
          _reply.readException();
        }
        finally {
          _reply.recycle();
          _data.recycle();
        }
      }
    }
    static final int TRANSACTION_finishSetupConnection = (android.os.IBinder.FIRST_CALL_TRANSACTION + 0);
    static final int TRANSACTION_reportExceptionInInit = (android.os.IBinder.FIRST_CALL_TRANSACTION + 1);
    static final int TRANSACTION_reportCleanExit = (android.os.IBinder.FIRST_CALL_TRANSACTION + 2);
  }
  public static final java.lang.String DESCRIPTOR = "org.chromium.base.process_launcher.IParentProcess";
  // Sends the child pid and information from the app zygote (if any) to the
  // parent process. This will be called before any third-party code is
  // loaded, and will be a no-op after the first call.
  //
  // The |zygotePid| must be 0 if the process does not inherit from an app zygote
  // or its app zygote did not produce a usable shared region containing
  // linker relocations (RELRO FD).
  public void finishSetupConnection(int pid, int zygotePid, long zygoteStartupTimeMillis, android.os.Bundle relroBundle) throws android.os.RemoteException;
  // Reports exception before calling into native main method. This is before
  // crash reporting is initialized, which means this exception would
  // otherwise not be reported.
  // Not oneway to ensure the browser receives the message before child exits.
  public void reportExceptionInInit(java.lang.String exception) throws android.os.RemoteException;
  // Tells the parent proces the child exited cleanly. Not oneway to ensure
  // the browser receives the message before child exits.
  public void reportCleanExit() throws android.os.RemoteException;
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
