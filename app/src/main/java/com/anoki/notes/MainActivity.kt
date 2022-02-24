package com.anoki.notes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.viewpager2.widget.ViewPager2
import com.anoki.notes.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

val tabsList = listOf<String>(
    "Insert note",
    "Notes list"
)

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    var viewModel: NotesViewModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        setupUi()
        setupViewModel()
    }

    private fun setupUi() {
        setupTabLayout()
    }

    private fun setupViewModel() {
        val viewModelFactory = NotesViewModelFactory(this.application)
        this.viewModel = ViewModelProvider(this, viewModelFactory)
            .get(NotesViewModel::class.java)
    }

    private fun setupTabLayout() {
        val viewPager = binding.viewPager
        val tabLayout = binding.tabLayout
        val adapter = ViewPagerAdapter(supportFragmentManager, lifecycle)
        viewPager.adapter = adapter

        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            tab.text = tabsList[position]
        }.attach()
    }
}