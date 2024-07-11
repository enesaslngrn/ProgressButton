package com.example.progressindicators

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.progressindicators.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val handler = Handler(Looper.getMainLooper())
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Progress Button

        binding.btnProgress.setOnClickListener {
            binding.btnProgress.showProgress()
            simulateDownload()
        }
    }
    private fun simulateDownload(){
        handler.postDelayed({
            binding.btnProgress.hideProgress(getString(R.string.open))
        },5000)
    }
}