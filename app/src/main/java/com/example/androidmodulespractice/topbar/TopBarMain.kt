package com.example.androidmodulespractice.topbar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.androidmodulespractice.R
import com.example.androidmodulespractice.databinding.ActivityTopBarMainBinding

class TopBarMain : AppCompatActivity() {
    lateinit var binding: ActivityTopBarMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTopBarMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}