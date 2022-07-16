package com.example.androidplayground.activities.permission

import android.Manifest
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.example.androidplayground.databinding.ActivityPermissionBinding

class PermissionActivity : AppCompatActivity() {

    companion object {
        private const val REQUEST_CONTACTS = 21321

        fun createIntent(context: Context) = Intent(context, PermissionActivity::class.java)
    }

    private lateinit var binding: ActivityPermissionBinding
    private var permissionManager: PermissionManager? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPermissionBinding.inflate(layoutInflater)
        setContentView(binding.root)



        checkPermissions()

    }


    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        when (requestCode) {
            REQUEST_CONTACTS -> {

            }
            else -> {}
        }
    }

    private fun checkPermissions() {
        if (permissionManager == null) {
            permissionManager = PermissionManager(SessionManager(this))
        }

        permissionManager!!.checkPermission(this,  Manifest.permission.READ_CONTACTS, object : PermissionManager.PermissionAskListener {
            override fun onPermissionPreviousDeniedWithNeverAskAgain() {
                TODO("Not yet implemented")
            }

            override fun onPermissionNeeded() {
                ActivityCompat.requestPermissions(this@PermissionActivity, arrayOf(Manifest.permission.READ_CONTACTS), REQUEST_CONTACTS)
            }

            override fun onPermissionPreviousDenied() {
                Toast.makeText(this@PermissionActivity, "Permission Denied", Toast.LENGTH_SHORT).show()
            }

            override fun onPermissionGranted() {
                // do nothing
            }
        })



    }
}