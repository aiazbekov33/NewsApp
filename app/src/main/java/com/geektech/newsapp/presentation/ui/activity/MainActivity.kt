package com.geektech.newsapp.presentation.ui.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI.setupWithNavController
import com.geektech.newsapp.R
import com.geektech.newsapp.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity(R.layout.activity_main) {

    private lateinit var navController: NavController

    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupNavigation()
    }

    private fun setupNavigation() {
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        navController = navHostFragment.navController
        val appBarConfiguration = AppBarConfiguration.Builder(
            R.id.navigation_top_headlines,
            R.id.navigation_new,
            R.id.navigation_setting,
            R.id.navigation_source
        ).build()
        setupWithNavController(binding.bottomNav, navController)
        setupActionBarWithNavController(this, navController, appBarConfiguration)
    }

    private fun setupActionBarWithNavController(
        activity: MainActivity,
        navController: NavController,
        appBarConfiguration: AppBarConfiguration
    ) {

    }

    override fun onSupportNavigateUp(): Boolean {
        return super.onSupportNavigateUp() || super.onSupportNavigateUp()
    }
}
