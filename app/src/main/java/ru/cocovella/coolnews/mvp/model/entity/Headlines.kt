package ru.cocovella.coolnews.mvp.model.entity

import android.os.Parcelable
import com.google.gson.annotations.Expose
import kotlinx.android.parcel.Parcelize

@Parcelize
class Headlines (
    @Expose val status: String,
    @Expose val totalResult: Int,
    @Expose val articles: List<Article>
) : Parcelable