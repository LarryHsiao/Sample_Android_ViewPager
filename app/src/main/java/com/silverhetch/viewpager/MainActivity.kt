package com.silverhetch.viewpager

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentPagerAdapter
import android.support.v4.view.ViewPager
import android.support.v7.app.AppCompatActivity
import android.view.View

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val viewPage = findViewById<ViewPager>(R.id.main_viewPager)
        viewPage.adapter = object : FragmentPagerAdapter(supportFragmentManager) {
            override fun getItem(position: Int): Fragment {
                val bundle = Bundle()
                bundle.putString("title", position.toString())

                val page = Page()
                page.arguments = bundle
                return page
            }

            override fun getCount(): Int = 10
        }

        findViewById<View>(R.id.main_jump).setOnClickListener {
            viewPage.setCurrentItem((viewPage.currentItem + 2) % 10, true)
        }
    }
}
