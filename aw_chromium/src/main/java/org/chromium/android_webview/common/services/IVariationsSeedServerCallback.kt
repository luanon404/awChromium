/*
 * This file is auto-generated.  DO NOT MODIFY.
 */
package org.chromium.android_webview.common.services

import android.os.Binder
import android.os.Bundle
import android.os.IBinder
import android.os.IInterface
import android.os.Parcel
import android.os.RemoteException

/**
 * Used to communicate variations seed related information from WebView's
 * service to an embedding app.
 */
interface IVariationsSeedServerCallback : IInterface {
    /** Default implementation for IVariationsSeedServerCallback.  */
    class Default : IVariationsSeedServerCallback {
        // Notifies the embedding app that metrics related to the variations
        // service are available for reporting. See VariationsServiceMetricsHelper
        // for information on the contents of the |metrics| parameter.
        @Throws(RemoteException::class)
        override fun reportVariationsServiceMetrics(metrics: Bundle?) {
        }

        override fun asBinder(): IBinder? {
            return null
        }
    }

    /** Local-side IPC implementation stub class.  */
    abstract class Stub : Binder(), IVariationsSeedServerCallback {
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

                TRANSACTION_reportVariationsServiceMetrics -> {
                    data.enforceInterface(descriptor)
                    val _arg0: Bundle? = if (0 != data.readInt()) {
                        Bundle.CREATOR.createFromParcel(data)
                    } else {
                        null
                    }
                    reportVariationsServiceMetrics(_arg0)
                    true
                }

                else -> {
                    super.onTransact(code, data, reply, flags)
                }
            }
        }

        private class Proxy(private val mRemote: IBinder) :
            IVariationsSeedServerCallback {
            override fun asBinder(): IBinder {
                return mRemote
            }

            // Notifies the embedding app that metrics related to the variations
            // service are available for reporting. See VariationsServiceMetricsHelper
            // for information on the contents of the |metrics| parameter.
            @Throws(RemoteException::class)
            override fun reportVariationsServiceMetrics(metrics: Bundle?) {
                val _data = Parcel.obtain()
                try {
                    _data.writeInterfaceToken(interfaceDescriptor)
                    if (metrics != null) {
                        _data.writeInt(1)
                        metrics.writeToParcel(_data, 0)
                    } else {
                        _data.writeInt(0)
                    }
                    val _status = mRemote.transact(
                        TRANSACTION_reportVariationsServiceMetrics,
                        _data,
                        null,
                        FLAG_ONEWAY
                    )
                    if (!_status && defaultImpl != null) {
                        defaultImpl!!.reportVariationsServiceMetrics(metrics)
                    }
                } finally {
                    _data.recycle()
                }
            }

            companion object {
                var defaultImpl: IVariationsSeedServerCallback? = null
            }
        }

        /** Construct the stub at attach it to the interface.  */
        init {
            this.attachInterface(this, Companion.interfaceDescriptor)
        }

        companion object {
            const val interfaceDescriptor =
                "org.chromium.android_webview.common.services.IVariationsSeedServerCallback"

            /**
             * Cast an IBinder object into an org.chromium.android_webview.common.services.IVariationsSeedServerCallback interface,
             * generating a proxy if needed.
             */
            fun asInterface(obj: IBinder?): IVariationsSeedServerCallback? {
                if (obj == null) {
                    return null
                }
                val iin = obj.queryLocalInterface(interfaceDescriptor)
                return if (iin is IVariationsSeedServerCallback) {
                    iin
                } else Proxy(
                    obj
                )
            }

            const val TRANSACTION_reportVariationsServiceMetrics = FIRST_CALL_TRANSACTION
            fun setDefaultImpl(impl: IVariationsSeedServerCallback?): Boolean {
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

    // Notifies the embedding app that metrics related to the variations
    // service are available for reporting. See VariationsServiceMetricsHelper
    // for information on the contents of the |metrics| parameter.
    @Throws(RemoteException::class)
    fun reportVariationsServiceMetrics(metrics: Bundle?)
}