/*
 * This file is auto-generated.  DO NOT MODIFY.
 */
package org.chromium.android_webview.common.services

import android.os.Binder
import android.os.IBinder
import android.os.IInterface
import android.os.Parcel
import android.os.ParcelFileDescriptor
import android.os.RemoteException

interface IVariationsSeedServer : IInterface {
    /** Default implementation for IVariationsSeedServer.  */
    class Default : IVariationsSeedServer {
        // Apps request variations seeds from WebView's service by calling this interface. They should
        // pass the "date" field of their current seed as oldSeedDate (in milliseconds since epoch), or
        // Long.MIN_VALUE to indicate they have no seed. If the service's latest seed is newer than
        // oldSeedDate, the service will write it to newSeedFile. callback may be used to pass
        // information back to the embedding app from the service.
        @Throws(RemoteException::class)
        override fun getSeed(
            newSeedFile: ParcelFileDescriptor?,
            oldSeedDate: Long,
            callback: IVariationsSeedServerCallback?
        ) {
        }

        override fun asBinder(): IBinder? {
            return null
        }
    }

    /** Local-side IPC implementation stub class.  */
    abstract class Stub : Binder(), IVariationsSeedServer {
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

                TRANSACTION_getSeed -> {
                    data.enforceInterface(descriptor)
                    val _arg0: ParcelFileDescriptor? = if (0 != data.readInt()) {
                        ParcelFileDescriptor.CREATOR.createFromParcel(data)
                    } else {
                        null
                    }
                    val _arg1: Long = data.readLong()
                    val _arg2: IVariationsSeedServerCallback = IVariationsSeedServerCallback.Stub.asInterface(
                            data.readStrongBinder()
                        )!!
                    getSeed(_arg0, _arg1, _arg2)
                    true
                }

                else -> {
                    super.onTransact(code, data, reply, flags)
                }
            }
        }

        private class Proxy(private val mRemote: IBinder) :
            IVariationsSeedServer {
            override fun asBinder(): IBinder {
                return mRemote
            }

            // Apps request variations seeds from WebView's service by calling this interface. They should
            // pass the "date" field of their current seed as oldSeedDate (in milliseconds since epoch), or
            // Long.MIN_VALUE to indicate they have no seed. If the service's latest seed is newer than
            // oldSeedDate, the service will write it to newSeedFile. callback may be used to pass
            // information back to the embedding app from the service.
            @Throws(RemoteException::class)
            override fun getSeed(
                newSeedFile: ParcelFileDescriptor?,
                oldSeedDate: Long,
                callback: IVariationsSeedServerCallback?
            ) {
                val _data = Parcel.obtain()
                try {
                    _data.writeInterfaceToken(interfaceDescriptor)
                    if (newSeedFile != null) {
                        _data.writeInt(1)
                        newSeedFile.writeToParcel(_data, 0)
                    } else {
                        _data.writeInt(0)
                    }
                    _data.writeLong(oldSeedDate)
                    _data.writeStrongBinder(callback?.asBinder())
                    val _status = mRemote.transact(TRANSACTION_getSeed, _data, null, FLAG_ONEWAY)
                    if (!_status && defaultImpl != null) {
                        defaultImpl!!.getSeed(newSeedFile, oldSeedDate, callback)
                    }
                } finally {
                    _data.recycle()
                }
            }

            companion object {
                var defaultImpl: IVariationsSeedServer? = null
            }
        }

        /** Construct the stub at attach it to the interface.  */
        init {
            this.attachInterface(this, Companion.interfaceDescriptor)
        }

        companion object {
            const val interfaceDescriptor =
                "org.chromium.android_webview.common.services.IVariationsSeedServer"

            /**
             * Cast an IBinder object into an org.chromium.android_webview.common.services.IVariationsSeedServer interface,
             * generating a proxy if needed.
             */
            fun asInterface(obj: IBinder?): IVariationsSeedServer? {
                if (obj == null) {
                    return null
                }
                val iin = obj.queryLocalInterface(interfaceDescriptor)
                return if (iin is IVariationsSeedServer) {
                    iin
                } else Proxy(obj)
            }

            const val TRANSACTION_getSeed = FIRST_CALL_TRANSACTION
            fun setDefaultImpl(impl: IVariationsSeedServer?): Boolean {
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

    // Apps request variations seeds from WebView's service by calling this interface. They should
    // pass the "date" field of their current seed as oldSeedDate (in milliseconds since epoch), or
    // Long.MIN_VALUE to indicate they have no seed. If the service's latest seed is newer than
    // oldSeedDate, the service will write it to newSeedFile. callback may be used to pass
    // information back to the embedding app from the service.
    @Throws(RemoteException::class)
    fun getSeed(
        newSeedFile: ParcelFileDescriptor?,
        oldSeedDate: Long,
        callback: IVariationsSeedServerCallback?
    )
}