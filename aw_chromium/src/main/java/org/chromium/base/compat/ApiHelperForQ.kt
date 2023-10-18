// Copyright 2019 The Chromium Authors. All rights reserved.
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.
package org.chromium.base.compat

import android.annotation.SuppressLint
import android.annotation.TargetApi
import android.app.Notification
import android.app.Service
import android.content.Context
import android.content.Intent
import android.content.ServiceConnection
import android.hardware.biometrics.BiometricManager
import android.net.NetworkCapabilities
import android.net.TransportInfo
import android.net.Uri
import android.os.Build
import android.os.FileUtils
import android.provider.MediaStore
import android.telephony.CellInfo
import android.telephony.TelephonyManager
import android.telephony.TelephonyManager.CellInfoCallback
import android.view.MotionEvent
import org.chromium.base.Callback
import org.chromium.base.annotations.VerifiesOnQ
import org.chromium.base.task.AsyncTask
import java.io.IOException
import java.io.InputStream
import java.io.OutputStream
import java.util.concurrent.Executor

/**
 * Utility class to use new APIs that were added in Q (API level 29). These need to exist in a
 * separate class so that Android framework can successfully verify classes without
 * encountering the new APIs.
 */
@VerifiesOnQ
@TargetApi(Build.VERSION_CODES.Q)
object ApiHelperForQ {
    /** See [].  */
    @SuppressLint("MissingPermission")
    fun requestCellInfoUpdate(
        telephonyManager: TelephonyManager, callback: Callback<List<CellInfo>?>
    ) {
        telephonyManager.requestCellInfoUpdate(AsyncTask.THREAD_POOL_EXECUTOR,
            object : CellInfoCallback() {
                @SuppressLint("Override")
                override fun onCellInfo(cellInfos: List<CellInfo>) {
                    callback.onResult(cellInfos)
                }
            })
    }

    @JvmStatic
    fun bindIsolatedService(
        context: Context,
        intent: Intent?,
        flags: Int,
        instanceName: String?,
        executor: Executor?,
        connection: ServiceConnection?
    ): Boolean {
        return context.bindIsolatedService(
            intent!!, flags, instanceName!!, executor!!, connection!!
        )
    }

    @JvmStatic
    fun updateServiceGroup(
        context: Context, connection: ServiceConnection?, group: Int, importance: Int
    ) {
        context.updateServiceGroup(connection!!, group, importance)
    }

    /** See [MotionEvent.getClassification].  */
    @JvmStatic
    fun getClassification(event: MotionEvent): Int {
        return event.classification
    }

    /** See [&lt;][Context.getSystemService].  */
    fun getBiometricManagerSystemService(context: Context): BiometricManager {
        return context.getSystemService(BiometricManager::class.java)
    }

    /** See [Service.startForeground].  */
    fun startForeground(
        service: Service, id: Int, notification: Notification?, foregroundServiceType: Int
    ) {
        service.startForeground(id, notification!!, foregroundServiceType)
    }

    /** See [FileUtils.copy].  */
    @Throws(IOException::class)
    fun copy(`in`: InputStream?, out: OutputStream?): Long {
        return FileUtils.copy(`in`!!, out!!)
    }

    /** See [MediaStore.setIncludePending].  */
    fun setIncludePending(uri: Uri?): Uri {
        return MediaStore.setRequireOriginal(uri!!)
    }

    /** See [MediaStore.getExternalVolumeNames].  */
    @JvmStatic
    fun getExternalVolumeNames(context: Context?): Set<String> {
        return MediaStore.getExternalVolumeNames(context!!)
    }

    /** See [BiometricManager.canAuthenticate].  */
    fun canAuthenticate(manager: BiometricManager): Int {
        return manager.canAuthenticate()
    }

    /** See [NetworkCapabilities.getTransportInfo]  */
    @JvmStatic
    fun getTransportInfo(networkCapabilities: NetworkCapabilities): TransportInfo? {
        return networkCapabilities.transportInfo
    }
}