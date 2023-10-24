/*
 * This file is auto-generated.  DO NOT MODIFY.
 */
package org.chromium.components.component_updater;

public interface IComponentsProviderService extends android.os.IInterface {
    /**
     * Default implementation for IComponentsProviderService.
     */
    class Default implements org.chromium.components.component_updater.IComponentsProviderService {
        /**
         * Request files for a component. The caller should expect that files may be missing and should
         * handle that.
         * <p>
         * This is an asynchronous call and there is no guarantee on the order of execution of multiple
         * calls. The caller should not unbind the service until all ResultReceivers are called.
         * <p>
         * The componentId is the unique name of the component as returned by
         * ComponentInstallerPolicy#getHash.
         * <p>
         * On success, the resultReceiver will be called with a return code of zero and the resultData
         * Bundle will contain a HashMap that maps file paths (relative to their component directory) to
         * an open ParcelFileDescriptor. The caller is responsible for closing these file descriptors.
         * The result map can be retrieved by calling
         * resultData.getSerializable(ComponentsProviderService.KEY_RESULT) and casting the result to a
         * (HashMap<String, ParcelFileDescriptor>).
         * On failure, a non-zero result code is sent with a null Bundle.
         *
         * @param componentId    the component for which to retrieve files
         * @param resultReceiver a callback to receive the result
         */
        @Override
        public void getFilesForComponent(java.lang.String componentId, android.os.ResultReceiver resultReceiver) throws android.os.RemoteException {
        }

        @Override
        public android.os.IBinder asBinder() {
            return null;
        }
    }

    /**
     * Local-side IPC implementation stub class.
     */
    abstract class Stub extends android.os.Binder implements org.chromium.components.component_updater.IComponentsProviderService {
        /**
         * Construct the stub at attach it to the interface.
         */
        public Stub() {
            this.attachInterface(this, DESCRIPTOR);
        }

        /**
         * Cast an IBinder object into an org.chromium.components.component_updater.IComponentsProviderService interface,
         * generating a proxy if needed.
         */
        public static org.chromium.components.component_updater.IComponentsProviderService asInterface(android.os.IBinder obj) {
            if ((obj == null)) {
                return null;
            }
            android.os.IInterface iin = obj.queryLocalInterface(DESCRIPTOR);
            if (((iin != null) && (iin instanceof org.chromium.components.component_updater.IComponentsProviderService))) {
                return ((org.chromium.components.component_updater.IComponentsProviderService) iin);
            }
            return new org.chromium.components.component_updater.IComponentsProviderService.Stub.Proxy(obj);
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
                case TRANSACTION_getFilesForComponent: {
                    java.lang.String _arg0;
                    _arg0 = data.readString();
                    android.os.ResultReceiver _arg1;
                    _arg1 = _Parcel.readTypedObject(data, android.os.ResultReceiver.CREATOR);
                    this.getFilesForComponent(_arg0, _arg1);
                    break;
                }
                default: {
                    return super.onTransact(code, data, reply, flags);
                }
            }
            return true;
        }

        private static class Proxy implements org.chromium.components.component_updater.IComponentsProviderService {
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

            /**
             * Request files for a component. The caller should expect that files may be missing and should
             * handle that.
             * <p>
             * This is an asynchronous call and there is no guarantee on the order of execution of multiple
             * calls. The caller should not unbind the service until all ResultReceivers are called.
             * <p>
             * The componentId is the unique name of the component as returned by
             * ComponentInstallerPolicy#getHash.
             * <p>
             * On success, the resultReceiver will be called with a return code of zero and the resultData
             * Bundle will contain a HashMap that maps file paths (relative to their component directory) to
             * an open ParcelFileDescriptor. The caller is responsible for closing these file descriptors.
             * The result map can be retrieved by calling
             * resultData.getSerializable(ComponentsProviderService.KEY_RESULT) and casting the result to a
             * (HashMap<String, ParcelFileDescriptor>).
             * On failure, a non-zero result code is sent with a null Bundle.
             *
             * @param componentId    the component for which to retrieve files
             * @param resultReceiver a callback to receive the result
             */
            @Override
            public void getFilesForComponent(java.lang.String componentId, android.os.ResultReceiver resultReceiver) throws android.os.RemoteException {
                android.os.Parcel _data = android.os.Parcel.obtain();
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeString(componentId);
                    _Parcel.writeTypedObject(_data, resultReceiver, 0);
                    boolean _status = mRemote.transact(Stub.TRANSACTION_getFilesForComponent, _data, null, android.os.IBinder.FLAG_ONEWAY);
                } finally {
                    _data.recycle();
                }
            }
        }

        static final int TRANSACTION_getFilesForComponent = (android.os.IBinder.FIRST_CALL_TRANSACTION + 0);
    }

    java.lang.String DESCRIPTOR = "org.chromium.components.component_updater.IComponentsProviderService";

    /**
     * Request files for a component. The caller should expect that files may be missing and should
     * handle that.
     * <p>
     * This is an asynchronous call and there is no guarantee on the order of execution of multiple
     * calls. The caller should not unbind the service until all ResultReceivers are called.
     * <p>
     * The componentId is the unique name of the component as returned by
     * ComponentInstallerPolicy#getHash.
     * <p>
     * On success, the resultReceiver will be called with a return code of zero and the resultData
     * Bundle will contain a HashMap that maps file paths (relative to their component directory) to
     * an open ParcelFileDescriptor. The caller is responsible for closing these file descriptors.
     * The result map can be retrieved by calling
     * resultData.getSerializable(ComponentsProviderService.KEY_RESULT) and casting the result to a
     * (HashMap<String, ParcelFileDescriptor>).
     * On failure, a non-zero result code is sent with a null Bundle.
     *
     * @param componentId    the component for which to retrieve files
     * @param resultReceiver a callback to receive the result
     */
    void getFilesForComponent(java.lang.String componentId, android.os.ResultReceiver resultReceiver) throws android.os.RemoteException;

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
