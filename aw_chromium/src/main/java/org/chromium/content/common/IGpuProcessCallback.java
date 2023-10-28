/*
 * This file is auto-generated.  DO NOT MODIFY.
 */
package org.chromium.content.common;
public interface IGpuProcessCallback extends android.os.IInterface
{
  /** Default implementation for IGpuProcessCallback. */
  public static class Default implements org.chromium.content.common.IGpuProcessCallback
  {
    @Override public void forwardSurfaceForSurfaceRequest(org.chromium.base.UnguessableToken requestToken, android.view.Surface surface) throws android.os.RemoteException
    {
    }
    @Override public org.chromium.content.common.SurfaceWrapper getViewSurface(int surfaceId) throws android.os.RemoteException
    {
      return null;
    }
    @Override
    public android.os.IBinder asBinder() {
      return null;
    }
  }
  /** Local-side IPC implementation stub class. */
  public static abstract class Stub extends android.os.Binder implements org.chromium.content.common.IGpuProcessCallback
  {
    /** Construct the stub at attach it to the interface. */
    public Stub()
    {
      this.attachInterface(this, DESCRIPTOR);
    }
    /**
     * Cast an IBinder object into an org.chromium.content.common.IGpuProcessCallback interface,
     * generating a proxy if needed.
     */
    public static org.chromium.content.common.IGpuProcessCallback asInterface(android.os.IBinder obj)
    {
      if ((obj==null)) {
        return null;
      }
      android.os.IInterface iin = obj.queryLocalInterface(DESCRIPTOR);
      if (((iin!=null)&&(iin instanceof org.chromium.content.common.IGpuProcessCallback))) {
        return ((org.chromium.content.common.IGpuProcessCallback)iin);
      }
      return new org.chromium.content.common.IGpuProcessCallback.Stub.Proxy(obj);
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
        case TRANSACTION_forwardSurfaceForSurfaceRequest:
        {
          org.chromium.base.UnguessableToken _arg0;
          _arg0 = _Parcel.readTypedObject(data, org.chromium.base.UnguessableToken.CREATOR);
          android.view.Surface _arg1;
          _arg1 = _Parcel.readTypedObject(data, android.view.Surface.CREATOR);
          this.forwardSurfaceForSurfaceRequest(_arg0, _arg1);
          break;
        }
        case TRANSACTION_getViewSurface:
        {
          int _arg0;
          _arg0 = data.readInt();
          org.chromium.content.common.SurfaceWrapper _result = this.getViewSurface(_arg0);
          reply.writeNoException();
          _Parcel.writeTypedObject(reply, _result, android.os.Parcelable.PARCELABLE_WRITE_RETURN_VALUE);
          break;
        }
        default:
        {
          return super.onTransact(code, data, reply, flags);
        }
      }
      return true;
    }
    private static class Proxy implements org.chromium.content.common.IGpuProcessCallback
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
      @Override public void forwardSurfaceForSurfaceRequest(org.chromium.base.UnguessableToken requestToken, android.view.Surface surface) throws android.os.RemoteException
      {
        android.os.Parcel _data = android.os.Parcel.obtain();
        try {
          _data.writeInterfaceToken(DESCRIPTOR);
          _Parcel.writeTypedObject(_data, requestToken, 0);
          _Parcel.writeTypedObject(_data, surface, 0);
          boolean _status = mRemote.transact(Stub.TRANSACTION_forwardSurfaceForSurfaceRequest, _data, null, android.os.IBinder.FLAG_ONEWAY);
        }
        finally {
          _data.recycle();
        }
      }
      @Override public org.chromium.content.common.SurfaceWrapper getViewSurface(int surfaceId) throws android.os.RemoteException
      {
        android.os.Parcel _data = android.os.Parcel.obtain();
        android.os.Parcel _reply = android.os.Parcel.obtain();
        org.chromium.content.common.SurfaceWrapper _result;
        try {
          _data.writeInterfaceToken(DESCRIPTOR);
          _data.writeInt(surfaceId);
          boolean _status = mRemote.transact(Stub.TRANSACTION_getViewSurface, _data, _reply, 0);
          _reply.readException();
          _result = _Parcel.readTypedObject(_reply, org.chromium.content.common.SurfaceWrapper.CREATOR);
        }
        finally {
          _reply.recycle();
          _data.recycle();
        }
        return _result;
      }
    }
    static final int TRANSACTION_forwardSurfaceForSurfaceRequest = (android.os.IBinder.FIRST_CALL_TRANSACTION + 0);
    static final int TRANSACTION_getViewSurface = (android.os.IBinder.FIRST_CALL_TRANSACTION + 1);
  }
  public static final java.lang.String DESCRIPTOR = "org.chromium.content.common.IGpuProcessCallback";
  public void forwardSurfaceForSurfaceRequest(org.chromium.base.UnguessableToken requestToken, android.view.Surface surface) throws android.os.RemoteException;
  public org.chromium.content.common.SurfaceWrapper getViewSurface(int surfaceId) throws android.os.RemoteException;
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
