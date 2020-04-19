package ru.cocovella.coolnews.mvp.model.entity

import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Publishers(
    @SerializedName("status")
    @Expose val status: String,
    @SerializedName("sources")
    @Expose val sources: List<Sources>
) : Parcelable