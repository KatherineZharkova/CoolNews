package ru.cocovella.coolnews.mvp.model.entity

import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Sources (
    @Expose val id: String,
    @Expose val name: String,
    @Expose val description: String,
    @Expose val url: String,
    @Expose val category: String,
    @Expose val language: String,
    @Expose val country: String
) : Parcelable