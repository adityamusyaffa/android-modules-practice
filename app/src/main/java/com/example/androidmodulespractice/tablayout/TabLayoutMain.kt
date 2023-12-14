package com.example.androidmodulespractice.tablayout

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager2.widget.ViewPager2
import com.example.androidmodulespractice.databinding.ActivityTabLayoutMainBinding
import com.example.androidmodulespractice.tablayout.fragments.FragmentAdapter
import com.example.androidmodulespractice.tablayout.fragments.PopularMovieFragment
import com.example.androidmodulespractice.tablayout.fragments.RecentMovieFragment
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class TabLayoutMain : AppCompatActivity() {
    lateinit var binding: ActivityTabLayoutMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTabLayoutMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val viewPager: ViewPager2 = binding.viewPager
        val tabLayout: TabLayout = binding.tabLayout

        val fragmentAdapter = FragmentAdapter(this)
        fragmentAdapter.addFragment(RecentMovieFragment(), "Recent")
        fragmentAdapter.addFragment(PopularMovieFragment(), "Popular")

        viewPager.adapter = fragmentAdapter

        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            tab.text = fragmentAdapter.getPageTitle(position)
        }.attach()
    }
}
