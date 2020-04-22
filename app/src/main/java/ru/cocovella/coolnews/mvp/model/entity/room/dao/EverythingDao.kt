package ru.cocovella.coolnews.mvp.model.entity.room.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import ru.cocovella.coolnews.mvp.model.entity.room.RoomEverything

@Dao
interface EverythingDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(roomEverything: RoomEverything)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(vararg roomEverything: RoomEverything)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(roomEverythingList: List<RoomEverything>)

    @Update
    fun update(roomEverything: RoomEverything)

    @Update
    fun update(vararg roomEverything: RoomEverything)

    @Update
    fun update(roomEverythingList: List<RoomEverything>)

    @Delete
    fun delete(roomEverything: RoomEverything)

    @Delete
    fun delete(vararg roomEverything: RoomEverything)

    @Delete
    fun delete(roomEverythingList: List<RoomEverything>)

    @Query("SELECT * FROM RoomEverything")
    fun getAll(): List<RoomEverything>

    @Query("SELECT * FROM RoomEverything WHERE sourceId = :sourceId")
    fun findEverything(sourceId: String): RoomEverything?
}
