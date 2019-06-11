package br.com.hussan.enjoeitest.ui.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import br.com.hussan.enjoeitest.R
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    private val titles: List<String> by lazy {
        listOf<String>(
            getString(R.string.search),
            getString(R.string.camera),
            getString(R.string.mail),
            getString(R.string.user)
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupTabLayout()
    }

    private fun setupTabLayout() {
        val adapter = TabAdapter(supportFragmentManager)
        adapter.add(ListProductsFragment())
        titles.forEach {
            adapter.add(SelectionFragment.newInstance(it))
        }
        viewPager.adapter = adapter
        viewPager.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(tabLayout))
        tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabReselected(tab: TabLayout.Tab?) {
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
            }

            override fun onTabSelected(tab: TabLayout.Tab?) {
                viewPager.currentItem = tab?.position ?: 0
            }

        })
    }

}

