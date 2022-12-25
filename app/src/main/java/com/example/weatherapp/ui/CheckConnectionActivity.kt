package com.example.weatherapp.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.weatherapp.databinding.ActivityCheckConnectionBinding


class CheckConnectionActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCheckConnectionBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    binding=ActivityCheckConnectionBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.activityCheckConnectionBtnCheck.setOnClickListener(
            {
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            }
        )
    }
}