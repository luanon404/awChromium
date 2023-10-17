/*
 * This file is auto-generated.  DO NOT MODIFY.
 */
package org.chromium.android_webview.common.services

import android.os.Binder
import android.os.Build
import android.os.IBinder
import android.os.IInterface
import android.os.Parcel
import android.os.ParcelFileDescriptor
import android.os.RemoteException

interface ICrashReceiverService : IInterface {
    /** Default implementation for ICrashReceiverService.  */
    class Default : ICrashReceiverService {
        @Throws(RemoteException::class)
        override fun transmitCrashes(
            fileDescriptors: Array<ParcelFileDescriptor>?, crashInfo: List<*>?
        ) {
        }

        override fun asBinder(): IBinder? {
            return null
        }
    }

    /** Local-side IPC implementation stub class.  */
    abstract class Stub : Binder(), ICrashReceiverService {
        override fun asBinder(): IBinder {
            return this
        }

        @Throws(RemoteException::class)
        public override fun onTransact(
            code: Int, data: Parcel, reply: Parcel?, flags: Int
        ): Boolean {
            val descriptor = Companion.interfaceDescriptor
            return when (code) {
                INTERFACE_TRANSACTION -> {
                    reply!!.writeString(descriptor)
                    true
                }

                TRANSACTION_transmitCrashes -> {
                    data.enforceInterface(descriptor)
                    val _arg0: Array<ParcelFileDescriptor>? =
                        data.createTypedArray(ParcelFileDescriptor.CREATOR)
                    val _arg1: List<*>? =
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
                            data.readArrayList(this.javaClass.classLoader, Any::class.java)
                        } else {
                            @Suppress("DEPRECATION")
                            /** Don't know why still deprecated when use if else */
                            data.readArrayList(this.javaClass.classLoader)
                        }
                    transmitCrashes(_arg0, _arg1)
                    reply!!.writeNoException()
                    true
                }

                else -> {
                    super.onTransact(code, data, reply, flags)
                }
            }
        }

        private class Proxy(private val mRemote: IBinder) : ICrashReceiverService {
            override fun asBinder(): IBinder {
                return mRemote
            }

            @Throws(RemoteException::class)
            override fun transmitCrashes(
                fileDescriptors: Array<ParcelFileDescriptor>?, crashInfo: List<*>?
            ) {
                val _data = Parcel.obtain()
                val _reply = Parcel.obtain()
                try {
                    _data.writeInterfaceToken(interfaceDescriptor)
                    _data.writeTypedArray(fileDescriptors, 0)
                    _data.writeList(crashInfo)
                    val _status = mRemote.transact(TRANSACTION_transmitCrashes, _data, _reply, 0)
                    if (!_status && defaultImpl != null) {
                        defaultImpl!!.transmitCrashes(fileDescriptors, crashInfo)
                        return
                    }
                    _reply.readException()
                } finally {
                    _reply.recycle()
                    _data.recycle()
                }
            }

            companion object {
                var defaultImpl: ICrashReceiverService? = null
            }
        }

        /** Construct the stub at attach it to the interface.  */
        init {
            this.attachInterface(this, Companion.interfaceDescriptor)
        }

        companion object {
            const val interfaceDescriptor =
                "org.chromium.android_webview.common.services.ICrashReceiverService"

            /**
             * Cast an IBinder object into an org.chromium.android_webview.common.services.ICrashReceiverService interface,
             * generating a proxy if needed.
             */
            fun asInterface(obj: IBinder?): ICrashReceiverService? {
                if (obj == null) {
                    return null
                }
                val iin = obj.queryLocalInterface(interfaceDescriptor)
                return if (iin is ICrashReceiverService) {
                    iin
                } else Proxy(obj)
            }

            const val TRANSACTION_transmitCrashes = FIRST_CALL_TRANSACTION
            fun setDefaultImpl(impl: ICrashReceiverService?): Boolean {
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

    @Throws(RemoteException::class)
    fun transmitCrashes(fileDescriptors: Array<ParcelFileDescriptor>?, crashInfo: List<*>?)
}