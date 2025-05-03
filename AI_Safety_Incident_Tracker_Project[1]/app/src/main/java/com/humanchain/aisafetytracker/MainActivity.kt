package com.humanchain.aisafetytracker

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.humanchain.aisafetytracker.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Inflate the layout using ViewBinding
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Set the toolbar as the ActionBar
        setSupportActionBar(binding.toolbar)

        // Optional: If you want to add a title to the ActionBar
        supportActionBar?.title = "AI Safety Tracker"
    }
}
