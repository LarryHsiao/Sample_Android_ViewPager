package com.silverhetch.viewpager

import android.graphics.Color
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentPagerAdapter
import android.support.v4.view.ViewPager
import android.support.v7.app.AppCompatActivity
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.ViewGroup.LayoutParams.MATCH_PARENT
import android.widget.TextView

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
            viewPage.setCurrentItem((viewPage.currentItem+2) % 10,true)
        }
    }

    class Page : Fragment() {
        override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
            val colors:Array<Int> = arrayOf(Color.BLACK, Color.GREEN,Color.CYAN,Color.YELLOW,Color.LTGRAY)
            val view = TextView(context)
            view.layoutParams = ViewGroup.LayoutParams(MATCH_PARENT, MATCH_PARENT)
            view.text = arguments.getString("title")
            view.gravity = Gravity.CENTER
            view.setBackgroundColor(colors[Integer.valueOf(view.text.toString())%colors.size])
            return view
        }
    }
}
