/*
 * This file is auto-generated.  DO NOT MODIFY.
 */
package org.chromium.android_webview.common.services;
/** The service is exported and this interface is available to WebViews embedded in all apps to use. */
public interface IMetricsUploadService extends android.os.IInterface
{
  /** Default implementation for IMetricsUploadService. */
  public static class Default implements org.chromium.android_webview.common.services.IMetricsUploadService
  {
    /**
     * Send the given UMA log to the clearcut service in GMS core on the device.
     * 
     * @param serializedLog the serialized bytes of the ChromeUserMetricsExtension proto message.
     * @param useDefaultUploadQos whether to use an experimental change that increases upload
     *         frequency.
     * 
     * @returns an integer HTTP status code indicating the success state of sending the log to the
     *       platform.
     */
    @Override public int uploadMetricsLog(byte[] serializedLog, boolean useDefaultUploadQos) throws android.os.RemoteException
    {
      return 0;
    }
    @Override
    public android.os.IBinder asBinder() {
      return null;
    }
  }
  /** Local-side IPC implementation stub class. */
  public static abstract class Stub extends android.os.Binder implements org.chromium.android_webview.common.services.IMetricsUploadService
  {
    /** Construct the stub at attach it to the interface. */
    public Stub()
    {
      this.attachInterface(this, DESCRIPTOR);
    }
    /**
     * Cast an IBinder object into an org.chromium.android_webview.common.services.IMetricsUploadService interface,
     * generating a proxy if needed.
     */
    public static org.chromium.android_webview.common.services.IMetricsUploadService asInterface(android.os.IBinder obj)
    {
      if ((obj==null)) {
        return null;
      }
      android.os.IInterface iin = obj.queryLocalInterface(DESCRIPTOR);
      if (((iin!=null)&&(iin instanceof org.chromium.android_webview.common.services.IMetricsUploadService))) {
        return ((org.chromium.android_webview.common.services.IMetricsUploadService)iin);
      }
      return new org.chromium.android_webview.common.services.IMetricsUploadService.Stub.Proxy(obj);
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
        case TRANSACTION_uploadMetricsLog:
        {
          byte[] _arg0;
          _arg0 = data.createByteArray();
          boolean _arg1;
          _arg1 = (0!=data.readInt());
          int _result = this.uploadMetricsLog(_arg0, _arg1);
          reply.writeNoException();
          reply.writeInt(_result);
          break;
        }
        default:
        {
          return super.onTransact(code, data, reply, flags);
        }
      }
      return true;
    }
    private static class Proxy implements org.chromium.android_webview.common.services.IMetricsUploadService
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
       * Send the given UMA log to the clearcut service in GMS core on the device.
       * 
       * @param serializedLog the serialized bytes of the ChromeUserMetricsExtension proto message.
       * @param useDefaultUploadQos whether to use an experimental change that increases upload
       *         frequency.
       * 
       * @returns an integer HTTP status code indicating the success state of sending the log to the
       *       platform.
       */
      @Override public int uploadMetricsLog(byte[] serializedLog, boolean useDefaultUploadQos) throws android.os.RemoteException
      {
        android.os.Parcel _data = android.os.Parcel.obtain();
        android.os.Parcel _reply = android.os.Parcel.obtain();
        int _result;
        try {
          _data.writeInterfaceToken(DESCRIPTOR);
          _data.writeByteArray(serializedLog);
          _data.writeInt(((useDefaultUploadQos)?(1):(0)));
          boolean _status = mRemote.transact(Stub.TRANSACTION_uploadMetricsLog, _data, _reply, 0);
          _reply.readException();
          _result = _reply.readInt();
        }
        finally {
          _reply.recycle();
          _data.recycle();
        }
        return _result;
      }
    }
    static final int TRANSACTION_uploadMetricsLog = (android.os.IBinder.FIRST_CALL_TRANSACTION + 0);
  }
  public static final java.lang.String DESCRIPTOR = "org.chromium.android_webview.common.services.IMetricsUploadService";
  /**
   * Send the given UMA log to the clearcut service in GMS core on the device.
   * 
   * @param serializedLog the serialized bytes of the ChromeUserMetricsExtension proto message.
   * @param useDefaultUploadQos whether to use an experimental change that increases upload
   *         frequency.
   * 
   * @returns an integer HTTP status code indicating the success state of sending the log to the
   *       platform.
   */
  public int uploadMetricsLog(byte[] serializedLog, boolean useDefaultUploadQos) throws android.os.RemoteException;
}
