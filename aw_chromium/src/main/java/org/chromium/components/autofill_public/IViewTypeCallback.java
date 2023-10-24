/*
 * This file is auto-generated.  DO NOT MODIFY.
 */
package org.chromium.components.autofill_public;

/**
 * The interface for AutofillHintsService to provide the type of view.
 */
public interface IViewTypeCallback extends android.os.IInterface {
    /**
     * Default implementation for IViewTypeCallback.
     */
    class Default implements org.chromium.components.autofill_public.IViewTypeCallback {
        // Invoked when the query succeeds, though the server might not have the
        // prediction of the views.
        @Override
        public void onViewTypeAvailable(java.util.List<org.chromium.components.autofill_public.ViewType> viewTypes) throws android.os.RemoteException {
        }

        // Invoked when the query fails, mostly because of the connection or server
        // error.
        @Override
        public void onQueryFailed() throws android.os.RemoteException {
        }

        @Override
        public android.os.IBinder asBinder() {
            return null;
        }
    }

    /**
     * Local-side IPC implementation stub class.
     */
    abstract class Stub extends android.os.Binder implements org.chromium.components.autofill_public.IViewTypeCallback {
        /**
         * Construct the stub at attach it to the interface.
         */
        public Stub() {
            this.attachInterface(this, DESCRIPTOR);
        }

        /**
         * Cast an IBinder object into an org.chromium.components.autofill_public.IViewTypeCallback interface,
         * generating a proxy if needed.
         */
        public static org.chromium.components.autofill_public.IViewTypeCallback asInterface(android.os.IBinder obj) {
            if ((obj == null)) {
                return null;
            }
            android.os.IInterface iin = obj.queryLocalInterface(DESCRIPTOR);
            if (((iin != null) && (iin instanceof org.chromium.components.autofill_public.IViewTypeCallback))) {
                return ((org.chromium.components.autofill_public.IViewTypeCallback) iin);
            }
            return new org.chromium.components.autofill_public.IViewTypeCallback.Stub.Proxy(obj);
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
                case TRANSACTION_onViewTypeAvailable: {
                    java.util.List<org.chromium.components.autofill_public.ViewType> _arg0;
                    _arg0 = data.createTypedArrayList(org.chromium.components.autofill_public.ViewType.CREATOR);
                    this.onViewTypeAvailable(_arg0);
                    reply.writeNoException();
                    break;
                }
                case TRANSACTION_onQueryFailed: {
                    this.onQueryFailed();
                    reply.writeNoException();
                    break;
                }
                default: {
                    return super.onTransact(code, data, reply, flags);
                }
            }
            return true;
        }

        private static class Proxy implements org.chromium.components.autofill_public.IViewTypeCallback {
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

            // Invoked when the query succeeds, though the server might not have the
            // prediction of the views.
            @Override
            public void onViewTypeAvailable(java.util.List<org.chromium.components.autofill_public.ViewType> viewTypes) throws android.os.RemoteException {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _Parcel.writeTypedList(_data, viewTypes, 0);
                    boolean _status = mRemote.transact(Stub.TRANSACTION_onViewTypeAvailable, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            // Invoked when the query fails, mostly because of the connection or server
            // error.
            @Override
            public void onQueryFailed() throws android.os.RemoteException {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    boolean _status = mRemote.transact(Stub.TRANSACTION_onQueryFailed, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }
        }

        static final int TRANSACTION_onViewTypeAvailable = (android.os.IBinder.FIRST_CALL_TRANSACTION + 0);
        static final int TRANSACTION_onQueryFailed = (android.os.IBinder.FIRST_CALL_TRANSACTION + 1);
    }

    java.lang.String DESCRIPTOR = "org.chromium.components.autofill_public.IViewTypeCallback";

    // Invoked when the query succeeds, though the server might not have the
    // prediction of the views.
    void onViewTypeAvailable(java.util.List<org.chromium.components.autofill_public.ViewType> viewTypes) throws android.os.RemoteException;

    // Invoked when the query fails, mostly because of the connection or server
    // error.
    void onQueryFailed() throws android.os.RemoteException;

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

        static private <T extends android.os.Parcelable> void writeTypedList(android.os.Parcel parcel, java.util.List<T> value, int parcelableFlags) {
            if (value == null) {
                parcel.writeInt(-1);
            } else {
                int N = value.size();
                int i = 0;
                parcel.writeInt(N);
                while (i < N) {
                    writeTypedObject(parcel, value.get(i), parcelableFlags);
                    i++;
                }
            }
        }
    }
}
