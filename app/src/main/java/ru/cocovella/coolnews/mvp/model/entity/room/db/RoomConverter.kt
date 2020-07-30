package ru.cocovella.coolnews.mvp.model.entity.room.db

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import ru.cocovella.coolnews.mvp.model.entity.Article
import ru.cocovella.coolnews.mvp.model.entity.Sources
import java.util.*


class RoomConverter {

    var gson = Gson()

    @TypeConverter
    fun toArticlesList(data: String?): List<Article>  =
        data?.let { gson.fromJson<List<Article>>(it, object : TypeToken<List<Article>>() {}.type) }
            ?: Collections.emptyList()

    @TypeConverter
    fun fromArticlesList(someObjects: List<Article>): String = gson.toJson(someObjects)

    @TypeConverter
    fun toSourcesList(data: String?): List<Sources>  =
        data?.let { gson.fromJson<List<Sources>>(it, object : TypeToken<List<Sources>>() {}.type) }
            ?: Collections.emptyList()

    @TypeConverter
    fun fromSourcesList(someObjects: List<Sources>): String = gson.toJson(someObjects)

}
