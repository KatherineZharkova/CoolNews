package ru.cocovella.coolnews.mvp.model.entity

import android.os.Parcelable
import com.google.gson.annotations.Expose
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Headlines(
    var sourceId: String,
    @Expose var status: String,
    @Expose var articles: List<Article>
) : Parcelable