package ru.cocovella.coolnews.mvp.model.entity.room

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import ru.cocovella.coolnews.mvp.model.entity.Source

@Entity(
    foreignKeys = [ForeignKey(
        entity = RoomHeadlines::class,
        parentColumns = ["sourceId"],
        childColumns = ["sourceId"],
        onDelete = ForeignKey.CASCADE
    )]
)
data class RoomArticle(
    val sourceId: String,
    val source: Source,
    val author: String,
    val title: String,
    val description: String,
    @PrimaryKey
    val url: String,
    val urlToImage: String,
    val publishedAt: String,
    val content: String
)