package com.vickikbt.devtyme.utils

import com.github.mikephil.charting.formatter.ValueFormatter

class LineChartValueFormatter: ValueFormatter() {
    val xAxisValues = arrayListOf("Mon", "Tue", "Wedn", "Thur", "Fri", "Sart", "Sun")

    override fun getFormattedValue(value: Float): String {
        return xAxisValues[value.toInt()]
    }
}