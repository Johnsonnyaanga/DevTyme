package com.vickikbt.devtyme.ui.activity

import android.os.Bundle
import android.view.View.GONE
import android.view.View.VISIBLE
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.vickikbt.devtyme.R
import com.vickikbt.devtyme.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        val navController = findNavController(R.id.nav_host_fragment)

        binding.bottomNav.background = null
        binding.bottomNav.menu.getItem(2).isEnabled = false

        navController.addOnDestinationChangedListener { _, destination, _ ->
            when (destination.id) {
                R.id.navigation_login -> {
                    binding.bottomBar.visibility = GONE
                    binding.fabAddTask.visibility = GONE
                }
                else -> {
                    binding.bottomBar.visibility = VISIBLE
                    binding.fabAddTask.visibility = VISIBLE
                }
            }
        }

    }
}