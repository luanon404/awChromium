/*
 * This file is auto-generated.  DO NOT MODIFY.
 */
package org.chromium.base.process_launcher;
public interface IChildProcessService extends android.os.IInterface
{
  /** Default implementation for IChildProcessService. */
  public static class Default implements org.chromium.base.process_launcher.IChildProcessService
  {
    // |clazz| identifies the ClassLoader of the caller.
    // On the first call to this method, the service will record the calling PID
    // and |clazz| and return true. Subsequent calls will only return true if the
    // calling PID and |clazz| matches the recorded values.
    @Override public boolean bindToCaller(java.lang.String clazz) throws android.os.RemoteException
    {
      return false;
    }
    // Get the ApplicationInfo object used to load the code and resources of the
    // child process, for validating that the parent is talking to a "matching"
    // process.
    @Override public android.content.pm.ApplicationInfo getAppInfo() throws android.os.RemoteException
    {
      return null;
    }
    // Sets up the initial IPC channel.
    @Override public void setupConnection(android.os.Bundle args, org.chromium.base.process_launcher.IParentProcess parentProcess, java.util.List<android.os.IBinder> clientInterfaces) throws android.os.RemoteException
    {
    }
    // Forcefully kills the child process.
    @Override public void forceKill() throws android.os.RemoteException
    {
    }
    // Notifies about memory pressure. The argument is MemoryPressureLevel enum.
    @Override public void onMemoryPressure(int pressure) throws android.os.RemoteException
    {
    }
    // Dumps the stack for the child process without crashing it.
    @Override public void dumpProcessStack() throws android.os.RemoteException
    {
    }
    // Takes the |bundle| potentially containing the shared memory region and
    // uses it to replace the memory behind read only relocations in the child
    // process. On error the bundle is silently ignored, disabling the memory
    // optimization.
    @Override public void consumeRelroBundle(android.os.Bundle bundle) throws android.os.RemoteException
    {
    }
    @Override
    public android.os.IBinder asBinder() {
      return null;
    }
  }
  /** Local-side IPC implementation stub class. */
  public static abstract class Stub extends android.os.Binder implements org.chromium.base.process_launcher.IChildProcessService
  {
    /** Construct the stub at attach it to the interface. */
    public Stub()
    {
      this.attachInterface(this, DESCRIPTOR);
    }
    /**
     * Cast an IBinder object into an org.chromium.base.process_launcher.IChildProcessService interface,
     * generating a proxy if needed.
     */
    public static org.chromium.base.process_launcher.IChildProcessService asInterface(android.os.IBinder obj)
    {
      if ((obj==null)) {
        return null;
      }
      android.os.IInterface iin = obj.queryLocalInterface(DESCRIPTOR);
      if (((iin!=null)&&(iin instanceof org.chromium.base.process_launcher.IChildProcessService))) {
        return ((org.chromium.base.process_launcher.IChildProcessService)iin);
      }
      return new org.chromium.base.process_launcher.IChildProcessService.Stub.Proxy(obj);
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
        case TRANSACTION_bindToCaller:
        {
          java.lang.String _arg0;
          _arg0 = data.readString();
          boolean _result = this.bindToCaller(_arg0);
          reply.writeNoException();
          reply.writeInt(((_result)?(1):(0)));
          break;
        }
        case TRANSACTION_getAppInfo:
        {
          android.content.pm.ApplicationInfo _result = this.getAppInfo();
          reply.writeNoException();
          _Parcel.writeTypedObject(reply, _result, android.os.Parcelable.PARCELABLE_WRITE_RETURN_VALUE);
          break;
        }
        case TRANSACTION_setupConnection:
        {
          android.os.Bundle _arg0;
          _arg0 = _Parcel.readTypedObject(data, android.os.Bundle.CREATOR);
          org.chromium.base.process_launcher.IParentProcess _arg1;
          _arg1 = org.chromium.base.process_launcher.IParentProcess.Stub.asInterface(data.readStrongBinder());
          java.util.List<android.os.IBinder> _arg2;
          _arg2 = data.createBinderArrayList();
          this.setupConnection(_arg0, _arg1, _arg2);
          break;
        }
        case TRANSACTION_forceKill:
        {
          this.forceKill();
          break;
        }
        case TRANSACTION_onMemoryPressure:
        {
          int _arg0;
          _arg0 = data.readInt();
          this.onMemoryPressure(_arg0);
          break;
        }
        case TRANSACTION_dumpProcessStack:
        {
          this.dumpProcessStack();
          break;
        }
        case TRANSACTION_consumeRelroBundle:
        {
          android.os.Bundle _arg0;
          _arg0 = _Parcel.readTypedObject(data, android.os.Bundle.CREATOR);
          this.consumeRelroBundle(_arg0);
          break;
        }
        default:
        {
          return super.onTransact(code, data, reply, flags);
        }
      }
      return true;
    }
    private static class Proxy implements org.chromium.base.process_launcher.IChildProcessService
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
      // |clazz| identifies the ClassLoader of the caller.
      // On the first call to this method, the service will record the calling PID
      // and |clazz| and return true. Subsequent calls will only return true if the
      // calling PID and |clazz| matches the recorded values.
      @Override public boolean bindToCaller(java.lang.String clazz) throws android.os.RemoteException
      {
        android.os.Parcel _data = android.os.Parcel.obtain();
        android.os.Parcel _reply = android.os.Parcel.obtain();
        boolean _result;
        try {
          _data.writeInterfaceToken(DESCRIPTOR);
          _data.writeString(clazz);
          boolean _status = mRemote.transact(Stub.TRANSACTION_bindToCaller, _data, _reply, 0);
          _reply.readException();
          _result = (0!=_reply.readInt());
        }
        finally {
          _reply.recycle();
          _data.recycle();
        }
        return _result;
      }
      // Get the ApplicationInfo object used to load the code and resources of the
      // child process, for validating that the parent is talking to a "matching"
      // process.
      @Override public android.content.pm.ApplicationInfo getAppInfo() throws android.os.RemoteException
      {
        android.os.Parcel _data = android.os.Parcel.obtain();
        android.os.Parcel _reply = android.os.Parcel.obtain();
        android.content.pm.ApplicationInfo _result;
        try {
          _data.writeInterfaceToken(DESCRIPTOR);
          boolean _status = mRemote.transact(Stub.TRANSACTION_getAppInfo, _data, _reply, 0);
          _reply.readException();
          _result = _Parcel.readTypedObject(_reply, android.content.pm.ApplicationInfo.CREATOR);
        }
        finally {
          _reply.recycle();
          _data.recycle();
        }
        return _result;
      }
      // Sets up the initial IPC channel.
      @Override public void setupConnection(android.os.Bundle args, org.chromium.base.process_launcher.IParentProcess parentProcess, java.util.List<android.os.IBinder> clientInterfaces) throws android.os.RemoteException
      {
        android.os.Parcel _data = android.os.Parcel.obtain();
        try {
          _data.writeInterfaceToken(DESCRIPTOR);
          _Parcel.writeTypedObject(_data, args, 0);
          _data.writeStrongInterface(parentProcess);
          _data.writeBinderList(clientInterfaces);
          boolean _status = mRemote.transact(Stub.TRANSACTION_setupConnection, _data, null, android.os.IBinder.FLAG_ONEWAY);
        }
        finally {
          _data.recycle();
        }
      }
      // Forcefully kills the child process.
      @Override public void forceKill() throws android.os.RemoteException
      {
        android.os.Parcel _data = android.os.Parcel.obtain();
        try {
          _data.writeInterfaceToken(DESCRIPTOR);
          boolean _status = mRemote.transact(Stub.TRANSACTION_forceKill, _data, null, android.os.IBinder.FLAG_ONEWAY);
        }
        finally {
          _data.recycle();
        }
      }
      // Notifies about memory pressure. The argument is MemoryPressureLevel enum.
      @Override public void onMemoryPressure(int pressure) throws android.os.RemoteException
      {
        android.os.Parcel _data = android.os.Parcel.obtain();
        try {
          _data.writeInterfaceToken(DESCRIPTOR);
          _data.writeInt(pressure);
          boolean _status = mRemote.transact(Stub.TRANSACTION_onMemoryPressure, _data, null, android.os.IBinder.FLAG_ONEWAY);
        }
        finally {
          _data.recycle();
        }
      }
      // Dumps the stack for the child process without crashing it.
      @Override public void dumpProcessStack() throws android.os.RemoteException
      {
        android.os.Parcel _data = android.os.Parcel.obtain();
        try {
          _data.writeInterfaceToken(DESCRIPTOR);
          boolean _status = mRemote.transact(Stub.TRANSACTION_dumpProcessStack, _data, null, android.os.IBinder.FLAG_ONEWAY);
        }
        finally {
          _data.recycle();
        }
      }
      // Takes the |bundle| potentially containing the shared memory region and
      // uses it to replace the memory behind read only relocations in the child
      // process. On error the bundle is silently ignored, disabling the memory
      // optimization.
      @Override public void consumeRelroBundle(android.os.Bundle bundle) throws android.os.RemoteException
      {
        android.os.Parcel _data = android.os.Parcel.obtain();
        try {
          _data.writeInterfaceToken(DESCRIPTOR);
          _Parcel.writeTypedObject(_data, bundle, 0);
          boolean _status = mRemote.transact(Stub.TRANSACTION_consumeRelroBundle, _data, null, android.os.IBinder.FLAG_ONEWAY);
        }
        finally {
          _data.recycle();
        }
      }
    }
    static final int TRANSACTION_bindToCaller = (android.os.IBinder.FIRST_CALL_TRANSACTION + 0);
    static final int TRANSACTION_getAppInfo = (android.os.IBinder.FIRST_CALL_TRANSACTION + 1);
    static final int TRANSACTION_setupConnection = (android.os.IBinder.FIRST_CALL_TRANSACTION + 2);
    static final int TRANSACTION_forceKill = (android.os.IBinder.FIRST_CALL_TRANSACTION + 3);
    static final int TRANSACTION_onMemoryPressure = (android.os.IBinder.FIRST_CALL_TRANSACTION + 4);
    static final int TRANSACTION_dumpProcessStack = (android.os.IBinder.FIRST_CALL_TRANSACTION + 5);
    static final int TRANSACTION_consumeRelroBundle = (android.os.IBinder.FIRST_CALL_TRANSACTION + 6);
  }
  public static final java.lang.String DESCRIPTOR = "org.chromium.base.process_launcher.IChildProcessService";
  // |clazz| identifies the ClassLoader of the caller.
  // On the first call to this method, the service will record the calling PID
  // and |clazz| and return true. Subsequent calls will only return true if the
  // calling PID and |clazz| matches the recorded values.
  public boolean bindToCaller(java.lang.String clazz) throws android.os.RemoteException;
  // Get the ApplicationInfo object used to load the code and resources of the
  // child process, for validating that the parent is talking to a "matching"
  // process.
  public android.content.pm.ApplicationInfo getAppInfo() throws android.os.RemoteException;
  // Sets up the initial IPC channel.
  public void setupConnection(android.os.Bundle args, org.chromium.base.process_launcher.IParentProcess parentProcess, java.util.List<android.os.IBinder> clientInterfaces) throws android.os.RemoteException;
  // Forcefully kills the child process.
  public void forceKill() throws android.os.RemoteException;
  // Notifies about memory pressure. The argument is MemoryPressureLevel enum.
  public void onMemoryPressure(int pressure) throws android.os.RemoteException;
  // Dumps the stack for the child process without crashing it.
  public void dumpProcessStack() throws android.os.RemoteException;
  // Takes the |bundle| potentially containing the shared memory region and
  // uses it to replace the memory behind read only relocations in the child
  // process. On error the bundle is silently ignored, disabling the memory
  // optimization.
  public void consumeRelroBundle(android.os.Bundle bundle) throws android.os.RemoteException;
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
