package com.example.newsapp.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.newsapp.model.ArticleEntity

@Database(
    entities = [
        ArticleEntity::class
    ],
    version = 1,
    exportSchema = false
)
abstract class AppDb : RoomDatabase() {

    abstract fun articleDao(): ArticleDao
}
