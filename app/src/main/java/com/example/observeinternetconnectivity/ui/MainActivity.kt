package com.example.observeinternetconnectivity.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.lifecycleScope
import com.example.observeinternetconnectivity.R
import com.example.observeinternetconnectivity.databinding.ActivityMainBinding
import com.example.observeinternetconnectivity.observeconnectivity.ConnectivityObserver
import com.example.observeinternetconnectivity.observeconnectivity.NetworkConnectivityObserver
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

class MainActivity : AppCompatActivity() {
    private lateinit var  binding : ActivityMainBinding
    private lateinit var connectivityObserver: ConnectivityObserver
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        connectivityObserver=NetworkConnectivityObserver(applicationContext)
        connectivityObserver.observe().onEach {
            binding.status.text=it.toString()
        }.launchIn(lifecycleScope)


    }
}