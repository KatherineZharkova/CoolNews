package ru.cocovella.coolnews.mvp.model.entity.room.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import ru.cocovella.coolnews.mvp.model.entity.room.RoomPublishers

@Dao
interface PublishersDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(roomPublishers: RoomPublishers)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(vararg roomPublishers: RoomPublishers)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(roomPublishersList: List<RoomPublishers>)

    @Update
    fun update(roomPublishers: RoomPublishers)

    @Update
    fun update(vararg roomPublishers: RoomPublishers)

    @Update
    fun update(roomPublishersList: List<RoomPublishers>)

    @Delete
    fun delete(roomPublishers: RoomPublishers)

    @Delete
    fun delete(vararg roomPublishers: RoomPublishers)

    @Delete
    fun delete(roomPublishersList: List<RoomPublishers>)

    @Query("SELECT * FROM RoomPublishers")
    fun getAll(): RoomPublishers

}