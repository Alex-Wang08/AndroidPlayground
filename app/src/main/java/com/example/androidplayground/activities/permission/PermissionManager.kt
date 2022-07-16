package com.example.androidplayground.activities.permission

import android.content.Context
import android.content.pm.PackageManager
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat

class PermissionManager(
    private val sessionManager: SessionManager
) {

    private fun shouldAskPermission() = Build.VERSION.SDK_INT >= Build.VERSION_CODES.M


    private fun shouldAskPermission(context: Context, permission: String): Boolean {
        if (shouldAskPermission()) {
            return ActivityCompat.checkSelfPermission(context, permission) != PackageManager.PERMISSION_DENIED
        }

        return false
    }

    fun checkPermission(
        context: Context,
        permission: String,
        listener: PermissionAskListener
    ) {
        if (!shouldAskPermission(context, permission)) {
            listener.onPermissionGranted()
            return
        }

        if (ActivityCompat.shouldShowRequestPermissionRationale(context as AppCompatActivity, permission)) {
            listener.onPermissionPreviousDenied()
            return
        }

        if (sessionManager.isFirstTimeAsking(permission)) {
            sessionManager.firstTimeAsking(permission, false)
            listener.onPermissionNeeded()
            return
        }

        listener.onPermissionPreviousDeniedWithNeverAskAgain()
    }

    interface PermissionAskListener {
        fun onPermissionNeeded()
        fun onPermissionPreviousDenied()
        fun onPermissionPreviousDeniedWithNeverAskAgain()
        fun onPermissionGranted()
    }
}