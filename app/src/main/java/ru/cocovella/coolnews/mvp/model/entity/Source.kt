package ru.cocovella.coolnews.mvp.model.entity

import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Source (
    @SerializedName("id")
    @Expose val id: String,
    @SerializedName("name")
    @Expose val name: String
) : Parcelable {

}