package ru.cocovella.coolnews.mvp.presenter

import android.annotation.SuppressLint
import org.ocpsoft.prettytime.PrettyTime
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*


class DateFormatter {

    fun formatDateToTime(dateTime: String): String? = try {
        val sdf = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.ENGLISH)
        PrettyTime(Locale(getCountry())).format(sdf.parse(dateTime))
    } catch (e: ParseException) {
        e.printStackTrace()
        dateTime
    }

    @SuppressLint("SimpleDateFormat")
    fun formatDate(dateTime: String): String? = try {
        SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'")
            .parse(dateTime)
            ?.let { SimpleDateFormat(
                "E, d MMM yyyy",
                Locale(getCountry())).format(it)
            }
    } catch (e: ParseException) {
        e.printStackTrace()
        dateTime
    }

    fun getCountry(): String {
        val locale: Locale = Locale.getDefault()
        val country: String = java.lang.String.valueOf(locale.country)
        return country.toLowerCase(Locale.getDefault())
    }

}
