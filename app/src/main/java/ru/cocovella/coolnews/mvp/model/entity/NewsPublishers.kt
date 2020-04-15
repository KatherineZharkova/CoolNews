package ru.cocovella.coolnews.mvp.model.entity

import android.os.Parcelable
import com.google.gson.annotations.Expose
import kotlinx.android.parcel.Parcelize

@Parcelize
class NewsPublishers (
    @Expose val status: String,
    @Expose val sources: List<Sources>
) : Parcelable