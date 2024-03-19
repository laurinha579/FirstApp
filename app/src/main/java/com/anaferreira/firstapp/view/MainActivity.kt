package com.anaferreira.firstapp.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.anaferreira.firstapp.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private var _binding: ActivityMainBinding? = null
    private val  binding:ActivityMainBinding get() = _binding!!
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }
}