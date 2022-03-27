package com.example.androidplayground

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.Text
import com.example.androidplayground.activities.flow.FlowActivity
import com.example.androidplayground.activities.qrcode.QrCodeActivity
import com.example.androidplayground.activities.retrofit.RetrofitActivity
import com.example.androidplayground.ui.theme.AndroidPlaygroundTheme
import com.example.androidplayground.activities.weatherreport.WeatherReportActivity

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val flowIntent = Intent(this, FlowActivity::class.java)
        val qrCodeIntent = Intent(this, QrCodeActivity::class.java)
        val retrofitIntent = Intent(this, RetrofitActivity::class.java)
        val weatherReportIntent = Intent(this, WeatherReportActivity::class.java)

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

                    Button(onClick = {
                        startActivity(weatherReportIntent)
                    }) {
                        Text(text = "Weather Report")
                    }
                }


            }
        }
    }
}