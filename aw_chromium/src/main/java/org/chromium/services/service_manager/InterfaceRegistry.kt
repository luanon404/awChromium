// Copyright 2016 The Chromium Authors. All rights reserved.
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.
package org.chromium.services.service_manager

import org.chromium.mojo.bindings.Interface
import org.chromium.mojo.bindings.Interface.Manager
import org.chromium.mojo.system.MessagePipeHandle
import org.chromium.mojo.system.MojoException
import org.chromium.service_manager.mojom.InterfaceProvider

/**
 * A registry where interfaces may be registered to be exposed to another application.
 *
 * To use, define a class that implements your specific interface. Then
 * implement an InterfaceFactory that creates instances of your implementation
 * and register that on the registry with a Manager for the interface like this:
 *
 * registry.addInterface(InterfaceType.MANAGER, factory);
 */
class InterfaceRegistry internal constructor() : InterfaceProvider {
    private val mBinders: MutableMap<String, InterfaceBinder<*>> = HashMap()
    fun <I : Interface?> addInterface(
        manager: Manager<I, out Interface.Proxy?>, factory: InterfaceFactory<I>
    ) {
        mBinders[manager.name] = InterfaceBinder(manager, factory)
    }

    override fun getInterface(name: String, pipe: MessagePipeHandle) {
        val binder = mBinders[name] ?: return
        binder.bindToMessagePipe(pipe)
    }

    override fun close() {
        mBinders.clear()
    }

    override fun onConnectionError(e: MojoException) {
        close()
    }

    private class InterfaceBinder<I : Interface?>(
        private val mManager: Manager<I, out Interface.Proxy?>,
        private val mFactory: InterfaceFactory<I>
    ) {
        fun bindToMessagePipe(pipe: MessagePipeHandle) {
            val impl: I? = mFactory.createImpl()
            if (impl == null) {
                pipe.close()
                return
            }
            mManager.bind(impl, pipe)
        }
    }

    companion object {
        @JvmStatic
        fun create(pipe: MessagePipeHandle?): InterfaceRegistry {
            val registry = InterfaceRegistry()
            InterfaceProvider.MANAGER.bind(registry, pipe)
            return registry
        }
    }
}