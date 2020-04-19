package ru.cocovella.coolnews.di.app.modules

import androidx.room.Room
import dagger.Module
import dagger.Provides
import ru.cocovella.coolnews.mvp.model.entity.room.db.Database
import ru.cocovella.coolnews.ui.App
import javax.inject.Singleton

@Module
class DatabaseModule {

    @Singleton
    @Provides
    fun database(app: App): Database {
        return Room.databaseBuilder(app, Database::class.java, Database.DB_NAME).build()
    }

}