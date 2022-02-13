package com.example.androidplayground

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.Role.Companion.Button
import androidx.compose.ui.tooling.preview.Preview
import com.example.androidplayground.flow.FlowActivity
import com.example.androidplayground.qrcode.QrCodeActivity
import com.example.androidplayground.retrofit.RetrofitActivity
import com.example.androidplayground.ui.theme.AndroidPlaygroundTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val flowIntent = Intent(this, FlowActivity::class.java)
        val qrCodeIntent = Intent(this, QrCodeActivity::class.java)
        val retrofitIntent = Intent(this, RetrofitActivity::class.java)

        setContent {
            AndroidPlaygroundTheme {
                Column() {
                    // flow
                    Button(onClick = {
                        startActivity(flowIntent)
                    }) {
                        Text(text = "Flow")
                    }

                    // QR code
                    Button(onClick = {
                        startActivity(qrCodeIntent)
                    }) {
                        Text(text = "QR Code")
                    }

                    // Retrofit
                    Button(onClick = {
                        startActivity(retrofitIntent)
                    }) {
                        Text(text = "Retrofit")
                    }
                }


            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    AndroidPlaygroundTheme {
        Greeting("Android")
    }
}