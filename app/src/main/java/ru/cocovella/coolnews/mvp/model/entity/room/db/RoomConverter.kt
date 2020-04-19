package ru.cocovella.coolnews.mvp.model.entity.room.db

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import ru.cocovella.coolnews.mvp.model.entity.Article
import ru.cocovella.coolnews.mvp.model.entity.Source
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
    fun toArticle(data: String?): Article  =
        data?.let { gson.fromJson<Article>(it, object : TypeToken<Article>() {}.type) }
            ?: Article( Source("", ""), "", "", "", "", "", "")

    @TypeConverter
    fun fromArticle(someObjects: Article): String = gson.toJson(someObjects)

    @TypeConverter
    fun toSourceList(data: String?): List<Source>  =
        data?.let { gson.fromJson<List<Source>>(it, object : TypeToken<List<Source>>() {}.type) }
            ?: Collections.emptyList()

    @TypeConverter
    fun fromSourceList(someObjects: List<Source>): String = gson.toJson(someObjects)

    @TypeConverter
    fun toSource(data: String?): Source =
        data?.let { gson.fromJson<Source>(it, object : TypeToken<Source?>() {}.type) }
            ?: Source("", "")

    @TypeConverter
    fun fromSource(someObjects: Source?): String = gson.toJson(someObjects)

    @TypeConverter
    fun toSourcesList(data: String?): List<Sources>  =
        data?.let { gson.fromJson<List<Sources>>(it, object : TypeToken<List<Sources>>() {}.type) }
            ?: Collections.emptyList()

    @TypeConverter
    fun fromSourcesList(someObjects: List<Sources>): String = gson.toJson(someObjects)

    @TypeConverter
    fun toSources(data: String?): Sources =
        data?.let { gson.fromJson<Sources>(it, object : TypeToken<Sources?>() {}.type) }
            ?: Sources("", "", "", "", "", "", "")

    @TypeConverter
    fun fromSources(someObjects: Sources?): String = gson.toJson(someObjects)

}
