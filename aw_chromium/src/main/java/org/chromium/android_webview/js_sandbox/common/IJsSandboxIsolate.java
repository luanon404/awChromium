/*
 * This file is auto-generated.  DO NOT MODIFY.
 */
package org.chromium.android_webview.js_sandbox.common;

/**
 * Used by the embedding app to execute JavaScript in a sandboxed environment.
 */
@androidx.annotation.RestrictTo(androidx.annotation.RestrictTo.Scope.LIBRARY)
public interface IJsSandboxIsolate extends android.os.IInterface {
    /**
     * Default implementation for IJsSandboxIsolate.
     */
    class Default implements org.chromium.android_webview.js_sandbox.common.IJsSandboxIsolate {
        /**
         * @param code     the JavaScript code
         *                 to be evaluated in the sandbox.
         * @param callback used to pass the information back to the embedding app
         *                 from the sandbox.
         */
        @Override
        public void evaluateJavascript(java.lang.String code, org.chromium.android_webview.js_sandbox.common.IJsSandboxIsolateCallback callback) throws android.os.RemoteException {
        }

        /**
         * Stop the execution of the Isolate as soon as possible and destroy it.
         */
        @Override
        public void close() throws android.os.RemoteException {
        }

        /**
         * Provides the data represented by afd such that it can be
         * retrieved in the JS code by calling `consumeNamedDataAs*(name)` APIs.
         *
         * @param name the id used to refer to the data in JS.
         * @param afd  input AssetFileDescriptor which will be read to retrieve data.
         * @return true if data with the given name can be retrieved
         * in JS code, else false.
         */
        @Override
        public boolean provideNamedData(java.lang.String name, android.content.res.AssetFileDescriptor afd) throws android.os.RemoteException {
            return false;
        }

        /**
         * @param afd      input AssetFileDescriptor containing the JavaScript code to be evaluated
         * @param callback used to pass the information back to the embedding app
         *                 from the sandbox.
         */
        @Override
        public void evaluateJavascriptWithFd(android.content.res.AssetFileDescriptor afd, org.chromium.android_webview.js_sandbox.common.IJsSandboxIsolateSyncCallback callback) throws android.os.RemoteException {
        }

        /**
         * Set or unset a console callback to receive console messages from the isolate.
         *
         * @param callback The callback to receive messages, or null to unset.
         */
        @Override
        public void setConsoleCallback(org.chromium.android_webview.js_sandbox.common.IJsSandboxConsoleCallback callback) throws android.os.RemoteException {
        }

        @Override
        public android.os.IBinder asBinder() {
            return null;
        }
    }

    /**
     * Local-side IPC implementation stub class.
     */
    abstract class Stub extends android.os.Binder implements org.chromium.android_webview.js_sandbox.common.IJsSandboxIsolate {
        /**
         * Construct the stub at attach it to the interface.
         */
        public Stub() {
            this.attachInterface(this, DESCRIPTOR);
        }

        /**
         * Cast an IBinder object into an org.chromium.android_webview.js_sandbox.common.IJsSandboxIsolate interface,
         * generating a proxy if needed.
         */
        public static org.chromium.android_webview.js_sandbox.common.IJsSandboxIsolate asInterface(android.os.IBinder obj) {
            if ((obj == null)) {
                return null;
            }
            android.os.IInterface iin = obj.queryLocalInterface(DESCRIPTOR);
            if (((iin != null) && (iin instanceof org.chromium.android_webview.js_sandbox.common.IJsSandboxIsolate))) {
                return ((org.chromium.android_webview.js_sandbox.common.IJsSandboxIsolate) iin);
            }
            return new org.chromium.android_webview.js_sandbox.common.IJsSandboxIsolate.Stub.Proxy(obj);
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
                case TRANSACTION_evaluateJavascript: {
                    java.lang.String _arg0;
                    _arg0 = data.readString();
                    org.chromium.android_webview.js_sandbox.common.IJsSandboxIsolateCallback _arg1;
                    _arg1 = org.chromium.android_webview.js_sandbox.common.IJsSandboxIsolateCallback.Stub.asInterface(data.readStrongBinder());
                    this.evaluateJavascript(_arg0, _arg1);
                    reply.writeNoException();
                    break;
                }
                case TRANSACTION_close: {
                    this.close();
                    reply.writeNoException();
                    break;
                }
                case TRANSACTION_provideNamedData: {
                    java.lang.String _arg0;
                    _arg0 = data.readString();
                    android.content.res.AssetFileDescriptor _arg1;
                    _arg1 = _Parcel.readTypedObject(data, android.content.res.AssetFileDescriptor.CREATOR);
                    boolean _result = this.provideNamedData(_arg0, _arg1);
                    reply.writeNoException();
                    reply.writeInt(((_result) ? (1) : (0)));
                    break;
                }
                case TRANSACTION_evaluateJavascriptWithFd: {
                    android.content.res.AssetFileDescriptor _arg0;
                    _arg0 = _Parcel.readTypedObject(data, android.content.res.AssetFileDescriptor.CREATOR);
                    org.chromium.android_webview.js_sandbox.common.IJsSandboxIsolateSyncCallback _arg1;
                    _arg1 = org.chromium.android_webview.js_sandbox.common.IJsSandboxIsolateSyncCallback.Stub.asInterface(data.readStrongBinder());
                    this.evaluateJavascriptWithFd(_arg0, _arg1);
                    reply.writeNoException();
                    break;
                }
                case TRANSACTION_setConsoleCallback: {
                    org.chromium.android_webview.js_sandbox.common.IJsSandboxConsoleCallback _arg0;
                    _arg0 = org.chromium.android_webview.js_sandbox.common.IJsSandboxConsoleCallback.Stub.asInterface(data.readStrongBinder());
                    this.setConsoleCallback(_arg0);
                    reply.writeNoException();
                    break;
                }
                default: {
                    return super.onTransact(code, data, reply, flags);
                }
            }
            return true;
        }

        private static class Proxy implements org.chromium.android_webview.js_sandbox.common.IJsSandboxIsolate {
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
             * @param code     the JavaScript code
             *                 to be evaluated in the sandbox.
             * @param callback used to pass the information back to the embedding app
             *                 from the sandbox.
             */
            @Override
            public void evaluateJavascript(java.lang.String code, org.chromium.android_webview.js_sandbox.common.IJsSandboxIsolateCallback callback) throws android.os.RemoteException {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeString(code);
                    _data.writeStrongInterface(callback);
                    boolean _status = mRemote.transact(Stub.TRANSACTION_evaluateJavascript, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            /**
             * Stop the execution of the Isolate as soon as possible and destroy it.
             */
            @Override
            public void close() throws android.os.RemoteException {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    boolean _status = mRemote.transact(Stub.TRANSACTION_close, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            /**
             * Provides the data represented by afd such that it can be
             * retrieved in the JS code by calling `consumeNamedDataAs*(name)` APIs.
             *
             * @param name the id used to refer to the data in JS.
             * @param afd  input AssetFileDescriptor which will be read to retrieve data.
             * @return true if data with the given name can be retrieved
             * in JS code, else false.
             */
            @Override
            public boolean provideNamedData(java.lang.String name, android.content.res.AssetFileDescriptor afd) throws android.os.RemoteException {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                boolean _result;
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeString(name);
                    _Parcel.writeTypedObject(_data, afd, 0);
                    boolean _status = mRemote.transact(Stub.TRANSACTION_provideNamedData, _data, _reply, 0);
                    _reply.readException();
                    _result = (0 != _reply.readInt());
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
                return _result;
            }

            /**
             * @param afd      input AssetFileDescriptor containing the JavaScript code to be evaluated
             * @param callback used to pass the information back to the embedding app
             *                 from the sandbox.
             */
            @Override
            public void evaluateJavascriptWithFd(android.content.res.AssetFileDescriptor afd, org.chromium.android_webview.js_sandbox.common.IJsSandboxIsolateSyncCallback callback) throws android.os.RemoteException {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _Parcel.writeTypedObject(_data, afd, 0);
                    _data.writeStrongInterface(callback);
                    boolean _status = mRemote.transact(Stub.TRANSACTION_evaluateJavascriptWithFd, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            /**
             * Set or unset a console callback to receive console messages from the isolate.
             *
             * @param callback The callback to receive messages, or null to unset.
             */
            @Override
            public void setConsoleCallback(org.chromium.android_webview.js_sandbox.common.IJsSandboxConsoleCallback callback) throws android.os.RemoteException {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeStrongInterface(callback);
                    boolean _status = mRemote.transact(Stub.TRANSACTION_setConsoleCallback, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }
        }

        static final int TRANSACTION_evaluateJavascript = (android.os.IBinder.FIRST_CALL_TRANSACTION + 0);
        static final int TRANSACTION_close = (android.os.IBinder.FIRST_CALL_TRANSACTION + 1);
        static final int TRANSACTION_provideNamedData = (android.os.IBinder.FIRST_CALL_TRANSACTION + 2);
        static final int TRANSACTION_evaluateJavascriptWithFd = (android.os.IBinder.FIRST_CALL_TRANSACTION + 3);
        static final int TRANSACTION_setConsoleCallback = (android.os.IBinder.FIRST_CALL_TRANSACTION + 4);
    }

    java.lang.String DESCRIPTOR = "org.chromium.android_webview.js_sandbox.common.IJsSandboxIsolate";

    /**
     * @param code     the JavaScript code
     *                 to be evaluated in the sandbox.
     * @param callback used to pass the information back to the embedding app
     *                 from the sandbox.
     */
    void evaluateJavascript(java.lang.String code, org.chromium.android_webview.js_sandbox.common.IJsSandboxIsolateCallback callback) throws android.os.RemoteException;

    /**
     * Stop the execution of the Isolate as soon as possible and destroy it.
     */
    void close() throws android.os.RemoteException;

    /**
     * Provides the data represented by afd such that it can be
     * retrieved in the JS code by calling `consumeNamedDataAs*(name)` APIs.
     *
     * @param name the id used to refer to the data in JS.
     * @param afd  input AssetFileDescriptor which will be read to retrieve data.
     * @return true if data with the given name can be retrieved
     * in JS code, else false.
     */
    boolean provideNamedData(java.lang.String name, android.content.res.AssetFileDescriptor afd) throws android.os.RemoteException;

    /**
     * @param afd      input AssetFileDescriptor containing the JavaScript code to be evaluated
     * @param callback used to pass the information back to the embedding app
     *                 from the sandbox.
     */
    void evaluateJavascriptWithFd(android.content.res.AssetFileDescriptor afd, org.chromium.android_webview.js_sandbox.common.IJsSandboxIsolateSyncCallback callback) throws android.os.RemoteException;

    /**
     * Set or unset a console callback to receive console messages from the isolate.
     *
     * @param callback The callback to receive messages, or null to unset.
     */
    void setConsoleCallback(org.chromium.android_webview.js_sandbox.common.IJsSandboxConsoleCallback callback) throws android.os.RemoteException;

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
