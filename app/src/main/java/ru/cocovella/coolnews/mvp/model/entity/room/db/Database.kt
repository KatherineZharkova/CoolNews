package ru.cocovella.coolnews.mvp.model.entity.room.db

import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import ru.cocovella.coolnews.mvp.model.entity.room.RoomEverything
import ru.cocovella.coolnews.mvp.model.entity.room.RoomPublishers
import ru.cocovella.coolnews.mvp.model.entity.room.RoomHeadlines
import ru.cocovella.coolnews.mvp.model.entity.room.dao.EverythingDao
import ru.cocovella.coolnews.mvp.model.entity.room.dao.PublishersDao
import ru.cocovella.coolnews.mvp.model.entity.room.dao.HeadlinesDao

@androidx.room.Database(
    entities = [
        RoomPublishers::class,
        RoomHeadlines::class,
        RoomEverything::class
    ],
    exportSchema = false,
    version = 1
)
@TypeConverters(RoomConverter::class)
abstract class Database : RoomDatabase() {
    abstract val publishersDao: PublishersDao
    abstract val headlinesDao: HeadlinesDao
    abstract val everythingDao: EverythingDao

    companion object {
        const val DB_NAME = "database.db"
    }
}