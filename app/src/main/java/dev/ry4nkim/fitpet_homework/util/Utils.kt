package dev.ry4nkim.fitpet_homework.util

import java.text.SimpleDateFormat
import java.util.*

object Utils {
    fun dateFormat(str: String): String {
        val date = SimpleDateFormat("yyyy-MM-dd").parse(str)
        return SimpleDateFormat("EE dd MMM", Locale.ENGLISH).format(date)
    }
}