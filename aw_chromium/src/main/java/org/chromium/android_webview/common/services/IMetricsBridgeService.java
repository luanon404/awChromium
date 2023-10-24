/*
 * This file is auto-generated.  DO NOT MODIFY.
 */
package org.chromium.android_webview.common.services;

/**
 * Interface to record UMA API calls inside non-embedded WebView processes and retrieve theses
 * records back in an embedded WebView.
 */
public interface IMetricsBridgeService extends android.os.IInterface {
    /**
     * Default implementation for IMetricsBridgeService.
     */
    class Default implements org.chromium.android_webview.common.services.IMetricsBridgeService {
        /**
         * Record a UMA API method call from a non-embedded WebView processes. This should only be
         * called by WebView's non-embedded processes (which are trusted). This is a blocking IPC,
         * although its work (including disk IO) happens asynchronously.
         *
         * @param methodCall a byte array serialization of
         *                   org.chromium.android_webview.proto.HistogramRecord proto message object.
         */
        @Override
        public void recordMetrics(byte[] methodCall) throws android.os.RemoteException {
        }

        /**
         * Get a list of recorded UMA method calls through the callback. This a blocking call.
         * This should only be called from a process that can call UMA APIs directly (e.g embedded
         * WebView).
         *
         * @returns a List<byte[]> of byte array serialization of
         * org.chromium.android_webview.proto.HistogramRecord proto message object.
         */
        @Override
        public java.util.List retrieveNonembeddedMetrics() throws android.os.RemoteException {
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
    abstract class Stub extends android.os.Binder implements org.chromium.android_webview.common.services.IMetricsBridgeService {
        /**
         * Construct the stub at attach it to the interface.
         */
        public Stub() {
            this.attachInterface(this, DESCRIPTOR);
        }

        /**
         * Cast an IBinder object into an org.chromium.android_webview.common.services.IMetricsBridgeService interface,
         * generating a proxy if needed.
         */
        public static org.chromium.android_webview.common.services.IMetricsBridgeService asInterface(android.os.IBinder obj) {
            if ((obj == null)) {
                return null;
            }
            android.os.IInterface iin = obj.queryLocalInterface(DESCRIPTOR);
            if (((iin != null) && (iin instanceof org.chromium.android_webview.common.services.IMetricsBridgeService))) {
                return ((org.chromium.android_webview.common.services.IMetricsBridgeService) iin);
            }
            return new org.chromium.android_webview.common.services.IMetricsBridgeService.Stub.Proxy(obj);
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
                case TRANSACTION_recordMetrics: {
                    byte[] _arg0;
                    _arg0 = data.createByteArray();
                    this.recordMetrics(_arg0);
                    reply.writeNoException();
                    break;
                }
                case TRANSACTION_retrieveNonembeddedMetrics: {
                    java.util.List _result = this.retrieveNonembeddedMetrics();
                    reply.writeNoException();
                    reply.writeList(_result);
                    break;
                }
                default: {
                    return super.onTransact(code, data, reply, flags);
                }
            }
            return true;
        }

        private static class Proxy implements org.chromium.android_webview.common.services.IMetricsBridgeService {
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
             * Record a UMA API method call from a non-embedded WebView processes. This should only be
             * called by WebView's non-embedded processes (which are trusted). This is a blocking IPC,
             * although its work (including disk IO) happens asynchronously.
             *
             * @param methodCall a byte array serialization of
             *                   org.chromium.android_webview.proto.HistogramRecord proto message object.
             */
            @Override
            public void recordMetrics(byte[] methodCall) throws android.os.RemoteException {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeByteArray(methodCall);
                    boolean _status = mRemote.transact(Stub.TRANSACTION_recordMetrics, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            /**
             * Get a list of recorded UMA method calls through the callback. This a blocking call.
             * This should only be called from a process that can call UMA APIs directly (e.g embedded
             * WebView).
             *
             * @returns a List<byte[]> of byte array serialization of
             * org.chromium.android_webview.proto.HistogramRecord proto message object.
             */
            @Override
            public java.util.List retrieveNonembeddedMetrics() throws android.os.RemoteException {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                java.util.List _result;
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    boolean _status = mRemote.transact(Stub.TRANSACTION_retrieveNonembeddedMetrics, _data, _reply, 0);
                    _reply.readException();
                    java.lang.ClassLoader cl = (java.lang.ClassLoader) this.getClass().getClassLoader();
                    _result = _reply.readArrayList(cl);
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
                return _result;
            }
        }

        static final int TRANSACTION_recordMetrics = (android.os.IBinder.FIRST_CALL_TRANSACTION + 0);
        static final int TRANSACTION_retrieveNonembeddedMetrics = (android.os.IBinder.FIRST_CALL_TRANSACTION + 1);
    }

    java.lang.String DESCRIPTOR = "org.chromium.android_webview.common.services.IMetricsBridgeService";

    /**
     * Record a UMA API method call from a non-embedded WebView processes. This should only be
     * called by WebView's non-embedded processes (which are trusted). This is a blocking IPC,
     * although its work (including disk IO) happens asynchronously.
     *
     * @param methodCall a byte array serialization of
     *                   org.chromium.android_webview.proto.HistogramRecord proto message object.
     */
    void recordMetrics(byte[] methodCall) throws android.os.RemoteException;

    /**
     * Get a list of recorded UMA method calls through the callback. This a blocking call.
     * This should only be called from a process that can call UMA APIs directly (e.g embedded
     * WebView).
     *
     * @returns a List<byte[]> of byte array serialization of
     * org.chromium.android_webview.proto.HistogramRecord proto message object.
     */
    java.util.List retrieveNonembeddedMetrics() throws android.os.RemoteException;
}
