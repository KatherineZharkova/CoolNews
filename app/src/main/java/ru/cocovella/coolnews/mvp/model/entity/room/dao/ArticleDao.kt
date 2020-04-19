package ru.cocovella.coolnews.mvp.model.entity.room.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import ru.cocovella.coolnews.mvp.model.entity.room.RoomArticle

@Dao
interface ArticleDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(roomArticle: RoomArticle)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(vararg roomArticle: RoomArticle)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(roomArticleList: List<RoomArticle>)

    @Update
    fun update(roomArticle: RoomArticle)

    @Update
    fun update(vararg roomArticle: RoomArticle)

    @Update
    fun update(roomArticleList: List<RoomArticle>)

    @Delete
    fun delete(roomArticle: RoomArticle)

    @Delete
    fun delete(vararg roomArticle: RoomArticle)

    @Delete
    fun delete(roomArticleList: List<RoomArticle>)

    @Query("SELECT * FROM RoomArticle")
    fun getAll(): List<RoomArticle>

    @Query("SELECT * FROM RoomArticle WHERE sourceId = :sourceId")
    fun findArticles(sourceId: String): List<RoomArticle>?
}
