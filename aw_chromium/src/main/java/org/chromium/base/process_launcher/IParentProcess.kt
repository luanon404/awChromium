/*
 * This file is auto-generated.  DO NOT MODIFY.
 */
package org.chromium.base.process_launcher

import android.os.Binder
import android.os.IBinder
import android.os.IInterface
import android.os.Parcel
import android.os.RemoteException

interface IParentProcess : IInterface {
    /** Default implementation for IParentProcess.  */
    class Default : IParentProcess {
        // Sends the child pid to the parent process. This will be called before any
        // third-party code is loaded, and will be a no-op after the first call.
        @Throws(RemoteException::class)
        override fun sendPid(pid: Int) {
        }

        // Report exception before calling into native main method. This is before
        // crash reporting is initialized, which means this exception would
        // otherwise not be reported.
        // Not oneway to ensure the browser receives the message before child exits.
        @Throws(RemoteException::class)
        override fun reportExceptionInInit(exception: String?) {
        }

        // Tells the parent proces the child exited cleanly. Not oneway to ensure
        // the browser receives the message before child exits.
        @Throws(RemoteException::class)
        override fun reportCleanExit() {
        }

        // Sends the PID and startup time of the app zygote if available.
        @Throws(RemoteException::class)
        override fun sendZygoteInfo(zygotePid: Int, startupTimeMillis: Long) {
        }

        override fun asBinder(): IBinder? {
            return null
        }
    }

    /** Local-side IPC implementation stub class.  */
    abstract class Stub : Binder(), IParentProcess {
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

                TRANSACTION_sendPid -> {
                    data.enforceInterface(descriptor)
                    val _arg0: Int = data.readInt()
                    sendPid(_arg0)
                    true
                }

                TRANSACTION_reportExceptionInInit -> {
                    data.enforceInterface(descriptor)
                    val _arg0: String? = data.readString()
                    reportExceptionInInit(_arg0)
                    reply!!.writeNoException()
                    true
                }

                TRANSACTION_reportCleanExit -> {
                    data.enforceInterface(descriptor)
                    reportCleanExit()
                    reply!!.writeNoException()
                    true
                }

                TRANSACTION_sendZygoteInfo -> {
                    data.enforceInterface(descriptor)
                    val _arg0: Int = data.readInt()
                    val _arg1: Long = data.readLong()
                    sendZygoteInfo(_arg0, _arg1)
                    true
                }

                else -> {
                    super.onTransact(code, data, reply, flags)
                }
            }
        }

        private class Proxy(private val mRemote: IBinder) : IParentProcess {
            override fun asBinder(): IBinder {
                return mRemote
            }

            // Sends the child pid to the parent process. This will be called before any
            // third-party code is loaded, and will be a no-op after the first call.
            @Throws(RemoteException::class)
            override fun sendPid(pid: Int) {
                val _data = Parcel.obtain()
                try {
                    _data.writeInterfaceToken(interfaceDescriptor)
                    _data.writeInt(pid)
                    val _status = mRemote.transact(TRANSACTION_sendPid, _data, null, FLAG_ONEWAY)
                    if (!_status && defaultImpl != null) {
                        defaultImpl!!.sendPid(pid)
                    }
                } finally {
                    _data.recycle()
                }
            }

            // Report exception before calling into native main method. This is before
            // crash reporting is initialized, which means this exception would
            // otherwise not be reported.
            // Not oneway to ensure the browser receives the message before child exits.
            @Throws(RemoteException::class)
            override fun reportExceptionInInit(exception: String?) {
                val _data = Parcel.obtain()
                val _reply = Parcel.obtain()
                try {
                    _data.writeInterfaceToken(interfaceDescriptor)
                    _data.writeString(exception)
                    val _status =
                        mRemote.transact(TRANSACTION_reportExceptionInInit, _data, _reply, 0)
                    if (!_status && defaultImpl != null) {
                        defaultImpl!!.reportExceptionInInit(exception)
                        return
                    }
                    _reply.readException()
                } finally {
                    _reply.recycle()
                    _data.recycle()
                }
            }

            // Tells the parent proces the child exited cleanly. Not oneway to ensure
            // the browser receives the message before child exits.
            @Throws(RemoteException::class)
            override fun reportCleanExit() {
                val _data = Parcel.obtain()
                val _reply = Parcel.obtain()
                try {
                    _data.writeInterfaceToken(interfaceDescriptor)
                    val _status = mRemote.transact(TRANSACTION_reportCleanExit, _data, _reply, 0)
                    if (!_status && defaultImpl != null) {
                        defaultImpl!!.reportCleanExit()
                        return
                    }
                    _reply.readException()
                } finally {
                    _reply.recycle()
                    _data.recycle()
                }
            }

            // Sends the PID and startup time of the app zygote if available.
            @Throws(RemoteException::class)
            override fun sendZygoteInfo(zygotePid: Int, startupTimeMillis: Long) {
                val _data = Parcel.obtain()
                try {
                    _data.writeInterfaceToken(interfaceDescriptor)
                    _data.writeInt(zygotePid)
                    _data.writeLong(startupTimeMillis)
                    val _status =
                        mRemote.transact(TRANSACTION_sendZygoteInfo, _data, null, FLAG_ONEWAY)
                    if (!_status && defaultImpl != null) {
                        defaultImpl!!.sendZygoteInfo(zygotePid, startupTimeMillis)
                    }
                } finally {
                    _data.recycle()
                }
            }

            companion object {
                var defaultImpl: IParentProcess? = null
            }
        }

        /** Construct the stub at attach it to the interface.  */
        init {
            this.attachInterface(this, Companion.interfaceDescriptor)
        }

        companion object {
            const val interfaceDescriptor = "org.chromium.base.process_launcher.IParentProcess"

            /**
             * Cast an IBinder object into an org.chromium.base.process_launcher.IParentProcess interface,
             * generating a proxy if needed.
             */
            fun asInterface(obj: IBinder?): IParentProcess? {
                if (obj == null) {
                    return null
                }
                val iin = obj.queryLocalInterface(interfaceDescriptor)
                return if (iin is IParentProcess) {
                    iin
                } else Proxy(obj)
            }

            const val TRANSACTION_sendPid = FIRST_CALL_TRANSACTION
            const val TRANSACTION_reportExceptionInInit = FIRST_CALL_TRANSACTION + 1
            const val TRANSACTION_reportCleanExit = FIRST_CALL_TRANSACTION + 2
            const val TRANSACTION_sendZygoteInfo = FIRST_CALL_TRANSACTION + 3
            fun setDefaultImpl(impl: IParentProcess?): Boolean {
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

    // Sends the child pid to the parent process. This will be called before any
    // third-party code is loaded, and will be a no-op after the first call.
    @Throws(RemoteException::class)
    fun sendPid(pid: Int)

    // Report exception before calling into native main method. This is before
    // crash reporting is initialized, which means this exception would
    // otherwise not be reported.
    // Not oneway to ensure the browser receives the message before child exits.
    @Throws(RemoteException::class)
    fun reportExceptionInInit(exception: String?)

    // Tells the parent proces the child exited cleanly. Not oneway to ensure
    // the browser receives the message before child exits.
    @Throws(RemoteException::class)
    fun reportCleanExit()

    // Sends the PID and startup time of the app zygote if available.
    @Throws(RemoteException::class)
    fun sendZygoteInfo(zygotePid: Int, startupTimeMillis: Long)
}