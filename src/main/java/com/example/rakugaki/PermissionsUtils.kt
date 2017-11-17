package com.example.rakugaki

import android.Manifest.permission.*
import android.app.Activity
import android.content.pm.PackageManager
import android.support.v4.app.ActivityCompat
import android.support.v4.app.Fragment
import android.support.v4.content.ContextCompat
import me.iwf.photopicker.utils.PermissionsConstant

/**
 * Created by daisuke on 2017/10/23.
 */
object PermissionsUtils {

    fun checkReadStoragePermission(activity: Activity): Boolean {
        if (android.os.Build.VERSION.SDK_INT < android.os.Build.VERSION_CODES.JELLY_BEAN) {
            return true
        }
        val readStoragePermissionState = ContextCompat.checkSelfPermission(activity, READ_EXTERNAL_STORAGE)

        val readStoragePermissionGranted = readStoragePermissionState == PackageManager.PERMISSION_GRANTED

        if (!readStoragePermissionGranted) {
            ActivityCompat.requestPermissions(activity,
                    PermissionsConstant.PERMISSIONS_EXTERNAL_READ,
                    PermissionsConstant.REQUEST_EXTERNAL_READ)
        }
        return readStoragePermissionGranted
    }

    fun checkWriteStoragePermission(activity: Activity): Boolean {

        val writeStoragePermissionState = ContextCompat.checkSelfPermission(activity, WRITE_EXTERNAL_STORAGE)

        val writeStoragePermissionGranted = writeStoragePermissionState == PackageManager.PERMISSION_GRANTED

        if (!writeStoragePermissionGranted) {
            ActivityCompat.requestPermissions(activity,
                    PermissionsConstant.PERMISSIONS_EXTERNAL_WRITE,
                    PermissionsConstant.REQUEST_EXTERNAL_WRITE)
        }
        return writeStoragePermissionGranted
    }

    fun checkWriteStoragePermission(fragment: Fragment): Boolean {

        val writeStoragePermissionState = ContextCompat.checkSelfPermission(fragment.getContext(), WRITE_EXTERNAL_STORAGE)

        val writeStoragePermissionGranted = writeStoragePermissionState == PackageManager.PERMISSION_GRANTED

        if (!writeStoragePermissionGranted) {
            fragment.requestPermissions(PermissionsConstant.PERMISSIONS_EXTERNAL_WRITE,
                    PermissionsConstant.REQUEST_EXTERNAL_WRITE)
        }
        return writeStoragePermissionGranted
    }

    fun checkCameraPermission(activity: Activity): Boolean {
        val cameraPermissionState = ContextCompat.checkSelfPermission(activity, CAMERA)

        val cameraPermissionGranted = cameraPermissionState == PackageManager.PERMISSION_GRANTED

        if (!cameraPermissionGranted) {
            ActivityCompat.requestPermissions(activity,PermissionsConstant.PERMISSIONS_CAMERA,
                    PermissionsConstant.REQUEST_CAMERA)
        }
        return cameraPermissionGranted
    }

    fun checkCameraPermission(fragment: Fragment): Boolean {
        val cameraPermissionState = ContextCompat.checkSelfPermission(fragment.getContext(), CAMERA)

        val cameraPermissionGranted = cameraPermissionState == PackageManager.PERMISSION_GRANTED

        if (!cameraPermissionGranted) {
            fragment.requestPermissions(PermissionsConstant.PERMISSIONS_CAMERA,
                    PermissionsConstant.REQUEST_CAMERA)
        }
        return cameraPermissionGranted
    }

}