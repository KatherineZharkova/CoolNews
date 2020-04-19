package ru.cocovella.coolnews.mvp.model.entity

import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Headlines(
    var sourceId: String,
    @SerializedName("status")
    @Expose var status: String,
    @SerializedName("totalResult")
    @Expose val totalResult: Int,
    @SerializedName("articles")
    @Expose var articles: List<Article>
) : Parcelable