package com.example.androidplayground.activities.spotify

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.bumptech.glide.RequestManager
import com.example.androidplayground.R
import com.example.androidplayground.databinding.ActivitySpotifyBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class SpotifyActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySpotifyBinding
    private val viewModel: SpotifyViewModel by viewModels()

    @Inject lateinit var glide: RequestManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySpotifyBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}