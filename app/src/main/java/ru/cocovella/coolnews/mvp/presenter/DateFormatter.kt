package ru.cocovella.coolnews.mvp.presenter

import org.ocpsoft.prettytime.PrettyTime
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*


class DateFormatter {

    fun formatDateToTime(dateTime: String?): String? = dateTime?.take(19)?.let {
        try {
            val sdf = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale.ENGLISH)
            PrettyTime(Locale(getCountry())).format(sdf.parse(it))
        } catch (e: ParseException) {
            ""
        }
    }

    fun formatDate(dateTime: String?): String? = dateTime?.take(19)?.let {
        try {
            SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale.ENGLISH).run {
                parse(it)?.let {
                    SimpleDateFormat("E, d MMM yyyy", Locale(getCountry())).format(it)
                }
            }
        } catch (e: ParseException) {
            ""
        }
    }

    private fun getCountry(): String {
        val locale: Locale = Locale.getDefault()
        val country: String = java.lang.String.valueOf(locale.country)
        return country.toLowerCase(Locale.getDefault())
    }

}