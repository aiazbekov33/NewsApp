package com.geektech.newsapp.presentation.ui.activity

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.Menu
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI.setupWithNavController
import com.geektech.newsapp.R
import com.geektech.newsapp.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint
import java.util.*

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var navController: NavController

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupNavigation()
        setupListener()
    }

    private fun setupNavigation() {
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        navController = navHostFragment.navController
        val appBarConfiguration = AppBarConfiguration.Builder(
            R.id.navigation_top_headlines,
            R.id.navigation_new,
            R.id.navigation_source,
            R.id.searchFragment

        ).build()
        setupWithNavController(binding.bottomNav, navController)
        setupActionBarWithNavController(this, navController, appBarConfiguration)
    }

    private fun setupListener() {
        searchClick()
    }

    private fun searchClick() {
        binding.topAppBar.setOnMenuItemClickListener { menuItem ->
            when (menuItem.itemId) {
                R.id.searchFragment -> {
                    navController.navigate(R.id.searchFragment)
                    true
                }
                else -> false
            }
        }
    }


    private fun setupActionBarWithNavController(
        activity: MainActivity,
        navController: NavController,
        appBarConfiguration: AppBarConfiguration
    ) {
    }
}
