package ru.cocovella.coolnews.mvp.model.entity.room.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import ru.cocovella.coolnews.mvp.model.entity.room.RoomHeadlines

@Dao
interface HeadlinesDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(roomHeadlines: RoomHeadlines)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(vararg roomHeadlines: RoomHeadlines)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(roomHeadlinesList: List<RoomHeadlines>)

    @Update
    fun update(roomHeadlines: RoomHeadlines)

    @Update
    fun update(vararg roomHeadlines: RoomHeadlines)

    @Update
    fun update(roomHeadlinesList: List<RoomHeadlines>)

    @Delete
    fun delete(roomHeadlines: RoomHeadlines)

    @Delete
    fun delete(vararg roomHeadlines: RoomHeadlines)

    @Delete
    fun delete(roomHeadlinesList: List<RoomHeadlines>)

    @Query("SELECT * FROM RoomHeadlines")
    fun getAll(): List<RoomHeadlines>

    @Query("SELECT * FROM RoomHeadlines WHERE sourceId = :sourceId")
    fun findHeadlines(sourceId: String): RoomHeadlines?
}
