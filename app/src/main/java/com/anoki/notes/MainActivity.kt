package com.anoki.notes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.anoki.notes.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayoutMediator

val tabsList = listOf<String>(
    "Insert note",
    "Notes list"
)

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        setupUi()
    }

    private fun setupUi() {
        val viewPager = binding.viewPager
        val tabLayout = binding.tabLayout

        val adapter = ViewPagerAdapter(supportFragmentManager, lifecycle)
        viewPager.adapter = adapter

        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            tab.text = tabsList[position]
        }.attach()
    }
}