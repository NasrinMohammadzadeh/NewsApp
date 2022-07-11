package com.example.newsapp.db

import androidx.room.*
import com.example.newsapp.model.ArticleEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface ArticleDao {

    @Transaction
    @Query("SELECT * FROM ArticleEntity")
    fun getArticleList(): Flow<List<ArticleEntity>?>

    @Transaction
    @Query("SELECT * FROM ArticleEntity WHERE id = :articleId")
    fun getArticle(articleId: Int): Flow<ArticleEntity?>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertArticleList(articleList: List<ArticleEntity>?)

    @Query("DELETE FROM ArticleEntity")
    suspend fun deleteArticleList()
}
