/*
 * This file is auto-generated.  DO NOT MODIFY.
 */
package org.chromium.android_webview.common.services

import android.os.Binder
import android.os.IBinder
import android.os.IInterface
import android.os.Parcel
import android.os.RemoteException

/**
 * Interface to record UMA API calls inside non-embedded WebView processes and retrieve theses
 * records back in an embedded WebView.
 */
interface IMetricsBridgeService : IInterface {
    /** Default implementation for IMetricsBridgeService.  */
    class Default : IMetricsBridgeService {
        /**
         * Record a UMA API method call from a non-embedded WebView processes. This should only be
         * called by WebView's non-embedded processes (which are trusted). This is a blocking IPC,
         * although its work (including disk IO) happens asynchronously.
         *
         * @param methodCall a byte array serialization of
         * org.chromium.android_webview.proto.HistogramRecord proto message object.
         */
        @Throws(RemoteException::class)
        override fun recordMetrics(methodCall: ByteArray?) {
        }

        /**
         * Get a list of recorded UMA method calls through the callback. This a blocking call.
         * This should only be called from a process that can call UMA APIs directly (e.g embedded
         * WebView).
         *
         * @returns a List<byte></byte>[]> of byte array serialization of
         * org.chromium.android_webview.proto.HistogramRecord proto message object.
         */
        @Throws(RemoteException::class)
        override fun retrieveNonembeddedMetrics(): List<*>? {
            return null
        }

        override fun asBinder(): IBinder? {
            return null
        }
    }

    /** Local-side IPC implementation stub class.  */
    abstract class Stub : Binder(), IMetricsBridgeService {
        override fun asBinder(): IBinder {
            return this
        }

        @Throws(RemoteException::class)
        public override fun onTransact(
            code: Int,
            data: Parcel,
            reply: Parcel?,
            flags: Int
        ): Boolean {
            val descriptor = Companion.interfaceDescriptor
            return when (code) {
                INTERFACE_TRANSACTION -> {
                    reply!!.writeString(descriptor)
                    true
                }

                TRANSACTION_recordMetrics -> {
                    data.enforceInterface(descriptor)
                    val _arg0: ByteArray? = data.createByteArray()
                    recordMetrics(_arg0)
                    reply!!.writeNoException()
                    true
                }

                TRANSACTION_retrieveNonembeddedMetrics -> {
                    data.enforceInterface(descriptor)
                    val _result = retrieveNonembeddedMetrics()!!
                    reply!!.writeNoException()
                    reply.writeList(_result)
                    true
                }

                else -> {
                    super.onTransact(code, data, reply, flags)
                }
            }
        }

        private class Proxy(private val mRemote: IBinder) :
            IMetricsBridgeService {
            override fun asBinder(): IBinder {
                return mRemote
            }

            /**
             * Record a UMA API method call from a non-embedded WebView processes. This should only be
             * called by WebView's non-embedded processes (which are trusted). This is a blocking IPC,
             * although its work (including disk IO) happens asynchronously.
             *
             * @param methodCall a byte array serialization of
             * org.chromium.android_webview.proto.HistogramRecord proto message object.
             */
            @Throws(RemoteException::class)
            override fun recordMetrics(methodCall: ByteArray?) {
                val _data = Parcel.obtain()
                val _reply = Parcel.obtain()
                try {
                    _data.writeInterfaceToken(interfaceDescriptor)
                    _data.writeByteArray(methodCall)
                    val _status = mRemote.transact(TRANSACTION_recordMetrics, _data, _reply, 0)
                    if (!_status && defaultImpl != null) {
                        defaultImpl!!.recordMetrics(methodCall)
                        return
                    }
                    _reply.readException()
                } finally {
                    _reply.recycle()
                    _data.recycle()
                }
            }

            /**
             * Get a list of recorded UMA method calls through the callback. This a blocking call.
             * This should only be called from a process that can call UMA APIs directly (e.g embedded
             * WebView).
             *
             * @returns a List<byte></byte>[]> of byte array serialization of
             * org.chromium.android_webview.proto.HistogramRecord proto message object.
             */
            @Throws(RemoteException::class)
            override fun retrieveNonembeddedMetrics(): List<*>? {
                val _data = Parcel.obtain()
                val _reply = Parcel.obtain()
                val _result: List<*>? = try {
                    _data.writeInterfaceToken(interfaceDescriptor)
                    val _status = mRemote.transact(
                        TRANSACTION_retrieveNonembeddedMetrics,
                        _data,
                        _reply,
                        0
                    )
                    if (!_status && defaultImpl != null) {
                        return defaultImpl!!.retrieveNonembeddedMetrics()
                    }
                    _reply.readException()
                    val cl = this.javaClass.classLoader
                    _reply.readArrayList(cl)
                } finally {
                    _reply.recycle()
                    _data.recycle()
                }
                return _result
            }

            companion object {
                var defaultImpl: IMetricsBridgeService? = null
            }
        }

        /** Construct the stub at attach it to the interface.  */
        init {
            this.attachInterface(this, Companion.interfaceDescriptor)
        }

        companion object {
            const val interfaceDescriptor =
                "org.chromium.android_webview.common.services.IMetricsBridgeService"

            /**
             * Cast an IBinder object into an org.chromium.android_webview.common.services.IMetricsBridgeService interface,
             * generating a proxy if needed.
             */
            fun asInterface(obj: IBinder?): IMetricsBridgeService? {
                if (obj == null) {
                    return null
                }
                val iin = obj.queryLocalInterface(interfaceDescriptor)
                return if (iin is IMetricsBridgeService) {
                    iin
                } else Proxy(obj)
            }

            const val TRANSACTION_recordMetrics = FIRST_CALL_TRANSACTION
            const val TRANSACTION_retrieveNonembeddedMetrics = FIRST_CALL_TRANSACTION + 1
            fun setDefaultImpl(impl: IMetricsBridgeService?): Boolean {
                // Only one user of this interface can use this function
                // at a time. This is a heuristic to detect if two different
                // users in the same process use this function.
                check(Proxy.defaultImpl == null) { "setDefaultImpl() called twice" }
                if (impl != null) {
                    Proxy.defaultImpl = impl
                    return true
                }
                return false
            }
        }
    }

    /**
     * Record a UMA API method call from a non-embedded WebView processes. This should only be
     * called by WebView's non-embedded processes (which are trusted). This is a blocking IPC,
     * although its work (including disk IO) happens asynchronously.
     *
     * @param methodCall a byte array serialization of
     * org.chromium.android_webview.proto.HistogramRecord proto message object.
     */
    @Throws(RemoteException::class)
    fun recordMetrics(methodCall: ByteArray?)

    /**
     * Get a list of recorded UMA method calls through the callback. This a blocking call.
     * This should only be called from a process that can call UMA APIs directly (e.g embedded
     * WebView).
     *
     * @returns a List<byte></byte>[]> of byte array serialization of
     * org.chromium.android_webview.proto.HistogramRecord proto message object.
     */
    @Throws(RemoteException::class)
    fun retrieveNonembeddedMetrics(): List<*>?
}