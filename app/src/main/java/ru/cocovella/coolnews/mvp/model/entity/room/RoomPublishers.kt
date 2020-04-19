package ru.cocovella.coolnews.mvp.model.entity.room

import androidx.room.Entity
import androidx.room.PrimaryKey
import ru.cocovella.coolnews.mvp.model.entity.Sources

@Entity
data class RoomPublishers(
    var status: String,
    var sources: List<Sources>,
    @PrimaryKey(autoGenerate = true)
    var primaryKey: Long? = 1L

)