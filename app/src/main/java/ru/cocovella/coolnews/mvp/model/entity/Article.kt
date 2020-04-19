package ru.cocovella.coolnews.mvp.model.entity

import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Article(
    @SerializedName("source")
    @Expose val source: Source,
    @SerializedName("author")
    @Expose val author: String,
    @SerializedName("title")
    @Expose val title: String,
    @SerializedName("description")
    @Expose val description: String,
    @SerializedName("url")
    @Expose val url: String,
    @SerializedName("urlToImage")
    @Expose val urlToImage: String,
    @SerializedName("publishedAt")
    @Expose val publishedAt: String
) : Parcelable