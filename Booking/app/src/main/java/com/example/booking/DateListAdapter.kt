package com.example.booking

import android.content.Context
import android.view.View
import androidx.viewpager.widget.PagerAdapter
import com.example.booking.unit.DateInfo

class DateListAdapter(context: Context) : PagerAdapter() {
    private lateinit var dates: ArrayList<DateInfo>
    private val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE)
    private val currentItemPos = 0

    init {
//        dates.add
    }

    override fun getCount(): Int {
        TODO("Not yet implemented")
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        TODO("Not yet implemented")
    }
}