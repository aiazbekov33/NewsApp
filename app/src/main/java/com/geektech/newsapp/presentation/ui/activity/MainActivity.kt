package com.geektech.newsapp.presentation.ui.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import androidx.viewpager.widget.PagerAdapter
import com.geektech.newsapp.R
import com.geektech.newsapp.databinding.ActivityMainBinding
import com.geektech.newsapp.presentation.ui.adapter.page.PageAdapter
import com.geektech.newsapp.presentation.ui.fragments.everything.NewsFragment
import com.google.android.material.tabs.TabLayout
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupNavigation()
        setupScrollable()
    }

    private fun setupNavigation() {
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        val navController = navHostFragment.navController
        NavigationUI.setupWithNavController(binding.bottomNav, navController)
    }

    private fun setupScrollable() = with(binding){
        var pageAdapter = PageAdapter(supportFragmentManager)
        pageAdapter.addFragment(NewsFragment(), "All news")
        pageAdapter.addFragment(NewsFragment(), "Business")
        pageAdapter.addFragment(NewsFragment(), "Magazine")
        pageAdapter.addFragment(NewsFragment(), "World")

        viewPager.adapter = pageAdapter
        tabLayout.setupWithViewPager(viewPager)
    }
}
