package com.silverhetch.viewpager

import android.graphics.Color
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.ViewGroup.LayoutParams.MATCH_PARENT
import android.widget.TextView

class Page : Fragment() {
    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val colors: Array<Int> = arrayOf(Color.BLACK, Color.GREEN, Color.CYAN, Color.YELLOW, Color.LTGRAY)
        val view = TextView(context)
        view.layoutParams = ViewGroup.LayoutParams(MATCH_PARENT, MATCH_PARENT)
        view.text = arguments.getString("title")
        view.gravity = Gravity.CENTER
        view.setBackgroundColor(colors[Integer.valueOf(view.text.toString()) % colors.size])
        return view
    }
}