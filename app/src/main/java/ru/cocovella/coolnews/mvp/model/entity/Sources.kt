package ru.cocovella.coolnews.mvp.model.entity

import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Sources (
    @SerializedName("id")
    @Expose val id: String,
    @SerializedName("name")
    @Expose val name: String,
    @SerializedName("description")
    @Expose val description: String,
    @SerializedName("url")
    @Expose val url: String,
    @SerializedName("category")
    @Expose val category: String,
    @SerializedName("language")
    @Expose val language: String,
    @SerializedName("country")
    @Expose val country: String
) : Parcelable