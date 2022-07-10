package com.example.customjalalicalendar

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.GridLayoutManager
import com.abcdandroid.hiltinandroid.PersianDate
import com.example.customjalalicalendar.databinding.ActivityMainBinding
import java.time.LocalDate
import java.util.*

class MainActivity : AppCompatActivity() {

    lateinit var bindview: ActivityMainBinding

    private val persianDate = PersianDate()
    private val adapter = CalendarAdapter()
    private var monthDay: Int = 0
    private var yearMonth: Int = 0
    val monthDayList = arrayListOf<Any>()

    //private val startCalFrom = Date(1577824200)
    private val startCalFrom = PersianDate(1577824200000)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindview = DataBindingUtil.setContentView(this, R.layout.activity_main)


        //Log.d("MainActivity", "onCreate: $d")

        persianDate.let { pd ->
            monthDay = startCalFrom.shDay
            yearMonth = startCalFrom.shMonth
        }

        monthDayList.add("ش")
        monthDayList.add("ی")
        monthDayList.add("د")
        monthDayList.add("س")
        monthDayList.add("چ")
        monthDayList.add("پ")
        monthDayList.add("ج")

        monthDayList.add("space")
        monthDayList.add("space")
        monthDayList.add("space")
        monthDayList.add("space")
        monthDayList.add("space")
        for (item in 1..monthDay) {
            monthDayList.add(item)
        }
        monthDayList.add("space")
        monthDayList.add("space")
        monthDayList.add("space")
        monthDayList.add("space")
        monthDayList.add("space")
        monthDayList.add("space")

        monthDayList.add("ش")
        monthDayList.add("ی")
        monthDayList.add("د")
        monthDayList.add("س")
        monthDayList.add("چ")
        monthDayList.add("پ")
        monthDayList.add("ج")


        val gridLm = GridLayoutManager(this, 7)
        bindview.monthGrid.let { rv ->
            rv.layoutManager = gridLm
            rv.adapter = adapter
        }
        adapter.submitList(monthDayList)

    }
}