package ru.cocovella.coolnews.mvp.model.entity.room

import androidx.room.Entity
import androidx.room.PrimaryKey
import ru.cocovella.coolnews.mvp.model.entity.Article

@Entity
data class RoomEverything(
    @PrimaryKey
    var sourceId: String,
    var status: String,
    var totalResult: Int,
    var articlesList: List<Article>
)