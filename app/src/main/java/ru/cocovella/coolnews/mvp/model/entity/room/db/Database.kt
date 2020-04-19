package ru.cocovella.coolnews.mvp.model.entity.room.db

import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import ru.cocovella.coolnews.mvp.model.entity.room.RoomPublishers
import ru.cocovella.coolnews.mvp.model.entity.room.RoomHeadlines
import ru.cocovella.coolnews.mvp.model.entity.room.dao.PublishersDao
import ru.cocovella.coolnews.mvp.model.entity.room.dao.HeadlinesDao

@androidx.room.Database(
    entities = [
        RoomHeadlines::class,
        RoomPublishers::class
    ],
    exportSchema = false,
    version = 1
)
@TypeConverters(RoomConverter::class)
abstract class Database : RoomDatabase() {
    abstract val headlinesDao: HeadlinesDao
    abstract val publishersDao: PublishersDao

    companion object {
        const val DB_NAME = "database.db"
    }
}