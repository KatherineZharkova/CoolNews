package ru.cocovella.coolnews.mvp.model.entity

import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Article(
    @Expose val source: Source,
    @Expose val author: String?,
    @Expose val title: String,
    @Expose val description: String,
    @Expose val url: String,
    @Expose val urlToImage: String,
    @Expose val publishedAt: String
) : Parcelable