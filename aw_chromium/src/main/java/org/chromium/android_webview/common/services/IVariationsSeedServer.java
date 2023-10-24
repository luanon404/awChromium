/*
 * This file is auto-generated.  DO NOT MODIFY.
 */
package org.chromium.android_webview.common.services;

public interface IVariationsSeedServer extends android.os.IInterface {
    /**
     * Default implementation for IVariationsSeedServer.
     */
    class Default implements org.chromium.android_webview.common.services.IVariationsSeedServer {
        // Apps request variations seeds from WebView's service by calling this interface. They should
        // pass the "date" field of their current seed as oldSeedDate (in milliseconds since epoch), or
        // Long.MIN_VALUE to indicate they have no seed. If the service's latest seed is newer than
        // oldSeedDate, the service will write it to newSeedFile. callback may be used to pass
        // information back to the embedding app from the service.
        @Override
        public void getSeed(android.os.ParcelFileDescriptor newSeedFile, long oldSeedDate, org.chromium.android_webview.common.services.IVariationsSeedServerCallback callback) throws android.os.RemoteException {
        }

        @Override
        public android.os.IBinder asBinder() {
            return null;
        }
    }

    /**
     * Local-side IPC implementation stub class.
     */
    abstract class Stub extends android.os.Binder implements org.chromium.android_webview.common.services.IVariationsSeedServer {
        /**
         * Construct the stub at attach it to the interface.
         */
        public Stub() {
            this.attachInterface(this, DESCRIPTOR);
        }

        /**
         * Cast an IBinder object into an org.chromium.android_webview.common.services.IVariationsSeedServer interface,
         * generating a proxy if needed.
         */
        public static org.chromium.android_webview.common.services.IVariationsSeedServer asInterface(android.os.IBinder obj) {
            if ((obj == null)) {
                return null;
            }
            android.os.IInterface iin = obj.queryLocalInterface(DESCRIPTOR);
            if (((iin != null) && (iin instanceof org.chromium.android_webview.common.services.IVariationsSeedServer))) {
                return ((org.chromium.android_webview.common.services.IVariationsSeedServer) iin);
            }
            return new org.chromium.android_webview.common.services.IVariationsSeedServer.Stub.Proxy(obj);
        }

        @Override
        public android.os.IBinder asBinder() {
            return this;
        }

        @Override
        public boolean onTransact(int code, android.os.Parcel data, android.os.Parcel reply, int flags) throws android.os.RemoteException {
            java.lang.String descriptor = DESCRIPTOR;
            if (code >= android.os.IBinder.FIRST_CALL_TRANSACTION && code <= android.os.IBinder.LAST_CALL_TRANSACTION) {
                data.enforceInterface(descriptor);
            }
            switch (code) {
                case INTERFACE_TRANSACTION: {
                    reply.writeString(descriptor);
                    return true;
                }
            }
            switch (code) {
                case TRANSACTION_getSeed: {
                    android.os.ParcelFileDescriptor _arg0;
                    _arg0 = _Parcel.readTypedObject(data, android.os.ParcelFileDescriptor.CREATOR);
                    long _arg1;
                    _arg1 = data.readLong();
                    org.chromium.android_webview.common.services.IVariationsSeedServerCallback _arg2;
                    _arg2 = org.chromium.android_webview.common.services.IVariationsSeedServerCallback.Stub.asInterface(data.readStrongBinder());
                    this.getSeed(_arg0, _arg1, _arg2);
                    break;
                }
                default: {
                    return super.onTransact(code, data, reply, flags);
                }
            }
            return true;
        }

        private static class Proxy implements org.chromium.android_webview.common.services.IVariationsSeedServer {
            private android.os.IBinder mRemote;

            Proxy(android.os.IBinder remote) {
                mRemote = remote;
            }

            @Override
            public android.os.IBinder asBinder() {
                return mRemote;
            }

            public java.lang.String getInterfaceDescriptor() {
                return DESCRIPTOR;
            }

            // Apps request variations seeds from WebView's service by calling this interface. They should
            // pass the "date" field of their current seed as oldSeedDate (in milliseconds since epoch), or
            // Long.MIN_VALUE to indicate they have no seed. If the service's latest seed is newer than
            // oldSeedDate, the service will write it to newSeedFile. callback may be used to pass
            // information back to the embedding app from the service.
            @Override
            public void getSeed(android.os.ParcelFileDescriptor newSeedFile, long oldSeedDate, org.chromium.android_webview.common.services.IVariationsSeedServerCallback callback) throws android.os.RemoteException {
                android.os.Parcel _data = android.os.Parcel.obtain();
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _Parcel.writeTypedObject(_data, newSeedFile, 0);
                    _data.writeLong(oldSeedDate);
                    _data.writeStrongInterface(callback);
                    boolean _status = mRemote.transact(Stub.TRANSACTION_getSeed, _data, null, android.os.IBinder.FLAG_ONEWAY);
                } finally {
                    _data.recycle();
                }
            }
        }

        static final int TRANSACTION_getSeed = (android.os.IBinder.FIRST_CALL_TRANSACTION + 0);
    }

    java.lang.String DESCRIPTOR = "org.chromium.android_webview.common.services.IVariationsSeedServer";

    // Apps request variations seeds from WebView's service by calling this interface. They should
    // pass the "date" field of their current seed as oldSeedDate (in milliseconds since epoch), or
    // Long.MIN_VALUE to indicate they have no seed. If the service's latest seed is newer than
    // oldSeedDate, the service will write it to newSeedFile. callback may be used to pass
    // information back to the embedding app from the service.
    void getSeed(android.os.ParcelFileDescriptor newSeedFile, long oldSeedDate, org.chromium.android_webview.common.services.IVariationsSeedServerCallback callback) throws android.os.RemoteException;

    /**
     * @hide
     */
    class _Parcel {
        static private <T> T readTypedObject(android.os.Parcel parcel, android.os.Parcelable.Creator<T> c) {
            if (parcel.readInt() != 0) {
                return c.createFromParcel(parcel);
            } else {
                return null;
            }
        }

        static private <T extends android.os.Parcelable> void writeTypedObject(android.os.Parcel parcel, T value, int parcelableFlags) {
            if (value != null) {
                parcel.writeInt(1);
                value.writeToParcel(parcel, parcelableFlags);
            } else {
                parcel.writeInt(0);
            }
        }
    }
}
