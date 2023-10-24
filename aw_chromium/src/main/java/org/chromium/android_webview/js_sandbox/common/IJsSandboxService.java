/*
 * This file is auto-generated.  DO NOT MODIFY.
 */
package org.chromium.android_webview.js_sandbox.common;

/**
 * Used by the embedding app to execute JavaScript in a sandboxed environment.
 */
@androidx.annotation.RestrictTo(androidx.annotation.RestrictTo.Scope.LIBRARY)
public interface IJsSandboxService extends android.os.IInterface {
    /**
     * Default implementation for IJsSandboxService.
     */
    class Default implements org.chromium.android_webview.js_sandbox.common.IJsSandboxService {
        @Override
        public org.chromium.android_webview.js_sandbox.common.IJsSandboxIsolate createIsolate() throws android.os.RemoteException {
            return null;
        }

        /**
         * @return A list of feature names supported by this implementation.
         */
        @Override
        public java.util.List<java.lang.String> getSupportedFeatures() throws android.os.RemoteException {
            return null;
        }

        @Override
        public org.chromium.android_webview.js_sandbox.common.IJsSandboxIsolate createIsolateWithMaxHeapSizeBytes(long maxHeapSize) throws android.os.RemoteException {
            return null;
        }

        /**
         * Create an isolate with a given heap size and service-to-client interface.
         */
        @Override
        public org.chromium.android_webview.js_sandbox.common.IJsSandboxIsolate createIsolate2(long maxHeapSize, org.chromium.android_webview.js_sandbox.common.IJsSandboxIsolateClient isolateClient) throws android.os.RemoteException {
            return null;
        }

        @Override
        public android.os.IBinder asBinder() {
            return null;
        }
    }

    /**
     * Local-side IPC implementation stub class.
     */
    abstract class Stub extends android.os.Binder implements org.chromium.android_webview.js_sandbox.common.IJsSandboxService {
        /**
         * Construct the stub at attach it to the interface.
         */
        public Stub() {
            this.attachInterface(this, DESCRIPTOR);
        }

        /**
         * Cast an IBinder object into an org.chromium.android_webview.js_sandbox.common.IJsSandboxService interface,
         * generating a proxy if needed.
         */
        public static org.chromium.android_webview.js_sandbox.common.IJsSandboxService asInterface(android.os.IBinder obj) {
            if ((obj == null)) {
                return null;
            }
            android.os.IInterface iin = obj.queryLocalInterface(DESCRIPTOR);
            if (((iin != null) && (iin instanceof org.chromium.android_webview.js_sandbox.common.IJsSandboxService))) {
                return ((org.chromium.android_webview.js_sandbox.common.IJsSandboxService) iin);
            }
            return new org.chromium.android_webview.js_sandbox.common.IJsSandboxService.Stub.Proxy(obj);
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
                case TRANSACTION_createIsolate: {
                    org.chromium.android_webview.js_sandbox.common.IJsSandboxIsolate _result = this.createIsolate();
                    reply.writeNoException();
                    reply.writeStrongInterface(_result);
                    break;
                }
                case TRANSACTION_getSupportedFeatures: {
                    java.util.List<java.lang.String> _result = this.getSupportedFeatures();
                    reply.writeNoException();
                    reply.writeStringList(_result);
                    break;
                }
                case TRANSACTION_createIsolateWithMaxHeapSizeBytes: {
                    long _arg0;
                    _arg0 = data.readLong();
                    org.chromium.android_webview.js_sandbox.common.IJsSandboxIsolate _result = this.createIsolateWithMaxHeapSizeBytes(_arg0);
                    reply.writeNoException();
                    reply.writeStrongInterface(_result);
                    break;
                }
                case TRANSACTION_createIsolate2: {
                    long _arg0;
                    _arg0 = data.readLong();
                    org.chromium.android_webview.js_sandbox.common.IJsSandboxIsolateClient _arg1;
                    _arg1 = org.chromium.android_webview.js_sandbox.common.IJsSandboxIsolateClient.Stub.asInterface(data.readStrongBinder());
                    org.chromium.android_webview.js_sandbox.common.IJsSandboxIsolate _result = this.createIsolate2(_arg0, _arg1);
                    reply.writeNoException();
                    reply.writeStrongInterface(_result);
                    break;
                }
                default: {
                    return super.onTransact(code, data, reply, flags);
                }
            }
            return true;
        }

        private static class Proxy implements org.chromium.android_webview.js_sandbox.common.IJsSandboxService {
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

            @Override
            public org.chromium.android_webview.js_sandbox.common.IJsSandboxIsolate createIsolate() throws android.os.RemoteException {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                org.chromium.android_webview.js_sandbox.common.IJsSandboxIsolate _result;
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    boolean _status = mRemote.transact(Stub.TRANSACTION_createIsolate, _data, _reply, 0);
                    _reply.readException();
                    _result = org.chromium.android_webview.js_sandbox.common.IJsSandboxIsolate.Stub.asInterface(_reply.readStrongBinder());
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
                return _result;
            }

            /**
             * @return A list of feature names supported by this implementation.
             */
            @Override
            public java.util.List<java.lang.String> getSupportedFeatures() throws android.os.RemoteException {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                java.util.List<java.lang.String> _result;
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    boolean _status = mRemote.transact(Stub.TRANSACTION_getSupportedFeatures, _data, _reply, 0);
                    _reply.readException();
                    _result = _reply.createStringArrayList();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
                return _result;
            }

            @Override
            public org.chromium.android_webview.js_sandbox.common.IJsSandboxIsolate createIsolateWithMaxHeapSizeBytes(long maxHeapSize) throws android.os.RemoteException {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                org.chromium.android_webview.js_sandbox.common.IJsSandboxIsolate _result;
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeLong(maxHeapSize);
                    boolean _status = mRemote.transact(Stub.TRANSACTION_createIsolateWithMaxHeapSizeBytes, _data, _reply, 0);
                    _reply.readException();
                    _result = org.chromium.android_webview.js_sandbox.common.IJsSandboxIsolate.Stub.asInterface(_reply.readStrongBinder());
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
                return _result;
            }

            /**
             * Create an isolate with a given heap size and service-to-client interface.
             */
            @Override
            public org.chromium.android_webview.js_sandbox.common.IJsSandboxIsolate createIsolate2(long maxHeapSize, org.chromium.android_webview.js_sandbox.common.IJsSandboxIsolateClient isolateClient) throws android.os.RemoteException {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                org.chromium.android_webview.js_sandbox.common.IJsSandboxIsolate _result;
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeLong(maxHeapSize);
                    _data.writeStrongInterface(isolateClient);
                    boolean _status = mRemote.transact(Stub.TRANSACTION_createIsolate2, _data, _reply, 0);
                    _reply.readException();
                    _result = org.chromium.android_webview.js_sandbox.common.IJsSandboxIsolate.Stub.asInterface(_reply.readStrongBinder());
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
                return _result;
            }
        }

        static final int TRANSACTION_createIsolate = (android.os.IBinder.FIRST_CALL_TRANSACTION + 0);
        static final int TRANSACTION_getSupportedFeatures = (android.os.IBinder.FIRST_CALL_TRANSACTION + 1);
        static final int TRANSACTION_createIsolateWithMaxHeapSizeBytes = (android.os.IBinder.FIRST_CALL_TRANSACTION + 2);
        static final int TRANSACTION_createIsolate2 = (android.os.IBinder.FIRST_CALL_TRANSACTION + 3);
    }

    java.lang.String DESCRIPTOR = "org.chromium.android_webview.js_sandbox.common.IJsSandboxService";
    /**
     * Feature flag indicating that closing an isolate will terminate its
     * execution as soon as possible, instead of allowing previously-requested
     * executions to run to completion first.
     */
    String ISOLATE_TERMINATION = "ISOLATE_TERMINATION";
    /**
     * Feature flag indicating that isolate creation can take a parameter
     * to set the maximum heap size limit of the isolate.
     */
    String ISOLATE_MAX_HEAP_SIZE_LIMIT = "ISOLATE_MAX_HEAP_SIZE_LIMIT";
    /**
     * This feature flag is a combination of three sub-features:
     * - If evaluateJavascript() returns a promise, we wait for the promise
     * to resolve and then return the resolved value.
     * - Supports Java API provideNamedData() and JS API
     * android.consumeNamedDataAsArrayBuffer().
     * - WebAssembly.compile() API is supported. Wasm can be compiled from
     * an array buffer.
     */
    String WASM_FROM_ARRAY_BUFFER = "WASM_FROM_ARRAY_BUFFER";
    /**
     * Feature flag indicating that JavaScript script evaluation is not bound
     * by the Binder transaction limit size.
     */
    String EVALUATE_WITHOUT_TRANSACTION_LIMIT = "EVALUATE_WITHOUT_TRANSACTION_LIMIT";
    /**
     * Feature flag indicating that an embedder can subscribe to console messages generated from the
     * isolate.
     */
    String CONSOLE_MESSAGING = "CONSOLE_MESSAGING";
    /**
     * Feature flag indicating that the client may provide the service side with an
     * IJsSandboxIsolateClient, allowing the service to call into the client regardless of ongoing
     * evaluations.
     */
    String ISOLATE_CLIENT = "ISOLATE_CLIENT";
    /**
     * Feature flag indicating that an embedder can evaluate JavaScript through
     * an AssetFileDescriptor or ParcelFileDescriptor with knwon or unknown length.
     */
    String EVALUATE_FROM_FD = "EVALUATE_FROM_FD";

    org.chromium.android_webview.js_sandbox.common.IJsSandboxIsolate createIsolate() throws android.os.RemoteException;

    /**
     * @return A list of feature names supported by this implementation.
     */
    java.util.List<java.lang.String> getSupportedFeatures() throws android.os.RemoteException;

    org.chromium.android_webview.js_sandbox.common.IJsSandboxIsolate createIsolateWithMaxHeapSizeBytes(long maxHeapSize) throws android.os.RemoteException;

    /**
     * Create an isolate with a given heap size and service-to-client interface.
     */
    org.chromium.android_webview.js_sandbox.common.IJsSandboxIsolate createIsolate2(long maxHeapSize, org.chromium.android_webview.js_sandbox.common.IJsSandboxIsolateClient isolateClient) throws android.os.RemoteException;
}
