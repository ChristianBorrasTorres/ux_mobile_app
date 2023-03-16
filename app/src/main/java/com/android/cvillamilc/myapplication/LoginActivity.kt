package com.android.cvillamilc.myapplication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.android.cvillamilc.myapplication.databinding.ActivityMainBinding


class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    //private lateinit var binding: LoginGoogleActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }
}