package ru.cocovella.coolnews.mvp.presenter

import org.ocpsoft.prettytime.PrettyTime
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*


class DateFormatter {

    fun formatDateToTime(dateTime: String?): String? = dateTime?.let {
        try {
            val sdf = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.ENGLISH)
            PrettyTime(Locale(getCountry())).format(sdf.parse(dateTime))
        } catch (e: ParseException) {
            val sdf = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'+00:00'", Locale.ENGLISH)
            PrettyTime(Locale(getCountry())).format(sdf.parse(dateTime))
        }
    }

    fun formatDate(dateTime: String?): String? = dateTime?.let {
        try {
            SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.ENGLISH)
                .parse(dateTime)
                ?.let {
                    SimpleDateFormat("E, d MMM yyyy", Locale(getCountry())).format(it)
                }
        } catch (e: ParseException) {
            SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'+00:00'", Locale.ENGLISH)
            .parse(dateTime)?.let{
                SimpleDateFormat("E, d MMM yyyy", Locale(getCountry())).format(it)
            }
        }
    }

    private fun getCountry(): String {
        val locale: Locale = Locale.getDefault()
        val country: String = java.lang.String.valueOf(locale.country)
        return country.toLowerCase(Locale.getDefault())
    }

}