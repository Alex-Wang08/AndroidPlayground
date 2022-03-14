package com.example.androidplayground.weatherreport

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.example.androidplayground.R
import com.example.androidplayground.databinding.ActivityWeatherReportBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class WeatherReportActivity : AppCompatActivity() {

    private lateinit var binding: ActivityWeatherReportBinding
    private val viewModel: WeatherReportViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivityWeatherReportBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel.weatherResp.observe(this) { weather ->
            binding.apply {
                tvTemperature.text = weather.temperature

            }
        }

    }
}