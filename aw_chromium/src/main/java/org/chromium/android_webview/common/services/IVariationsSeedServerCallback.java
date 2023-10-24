/*
 * This file is auto-generated.  DO NOT MODIFY.
 */
package org.chromium.android_webview.common.services;

/**
 * Used to communicate variations seed related information from WebView's
 * service to an embedding app.
 */
public interface IVariationsSeedServerCallback extends android.os.IInterface {
    /**
     * Default implementation for IVariationsSeedServerCallback.
     */
    class Default implements org.chromium.android_webview.common.services.IVariationsSeedServerCallback {
        // Notifies the embedding app that metrics related to the variations
        // service are available for reporting. See VariationsServiceMetricsHelper
        // for information on the contents of the |metrics| parameter.
        @Override
        public void reportVariationsServiceMetrics(android.os.Bundle metrics) throws android.os.RemoteException {
        }

        @Override
        public android.os.IBinder asBinder() {
            return null;
        }
    }

    /**
     * Local-side IPC implementation stub class.
     */
    abstract class Stub extends android.os.Binder implements org.chromium.android_webview.common.services.IVariationsSeedServerCallback {
        /**
         * Construct the stub at attach it to the interface.
         */
        public Stub() {
            this.attachInterface(this, DESCRIPTOR);
        }

        /**
         * Cast an IBinder object into an org.chromium.android_webview.common.services.IVariationsSeedServerCallback interface,
         * generating a proxy if needed.
         */
        public static org.chromium.android_webview.common.services.IVariationsSeedServerCallback asInterface(android.os.IBinder obj) {
            if ((obj == null)) {
                return null;
            }
            android.os.IInterface iin = obj.queryLocalInterface(DESCRIPTOR);
            if (((iin != null) && (iin instanceof org.chromium.android_webview.common.services.IVariationsSeedServerCallback))) {
                return ((org.chromium.android_webview.common.services.IVariationsSeedServerCallback) iin);
            }
            return new org.chromium.android_webview.common.services.IVariationsSeedServerCallback.Stub.Proxy(obj);
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
                case TRANSACTION_reportVariationsServiceMetrics: {
                    android.os.Bundle _arg0;
                    _arg0 = _Parcel.readTypedObject(data, android.os.Bundle.CREATOR);
                    this.reportVariationsServiceMetrics(_arg0);
                    break;
                }
                default: {
                    return super.onTransact(code, data, reply, flags);
                }
            }
            return true;
        }

        private static class Proxy implements org.chromium.android_webview.common.services.IVariationsSeedServerCallback {
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

            // Notifies the embedding app that metrics related to the variations
            // service are available for reporting. See VariationsServiceMetricsHelper
            // for information on the contents of the |metrics| parameter.
            @Override
            public void reportVariationsServiceMetrics(android.os.Bundle metrics) throws android.os.RemoteException {
                android.os.Parcel _data = android.os.Parcel.obtain();
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _Parcel.writeTypedObject(_data, metrics, 0);
                    boolean _status = mRemote.transact(Stub.TRANSACTION_reportVariationsServiceMetrics, _data, null, android.os.IBinder.FLAG_ONEWAY);
                } finally {
                    _data.recycle();
                }
            }
        }

        static final int TRANSACTION_reportVariationsServiceMetrics = (android.os.IBinder.FIRST_CALL_TRANSACTION + 0);
    }

    java.lang.String DESCRIPTOR = "org.chromium.android_webview.common.services.IVariationsSeedServerCallback";

    // Notifies the embedding app that metrics related to the variations
    // service are available for reporting. See VariationsServiceMetricsHelper
    // for information on the contents of the |metrics| parameter.
    void reportVariationsServiceMetrics(android.os.Bundle metrics) throws android.os.RemoteException;

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
