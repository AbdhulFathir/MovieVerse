package com.example.movieverse.db

import androidx.room.*

@Dao
interface MovieDao {
//
//    @Insert(onConflict = OnConflictStrategy.REPLACE)
//    suspend fun insertMovie(movie: MovieEntity)

    @Insert
    fun insertAll(item: MovieEntity)

//    @Query("SELECT * FROM movies WHERE actors LIKE '%' || :actor || '%' COLLATE NOCASE")
//    suspend fun searchByActor(actor: String): List<MovieEntity>
//
//    @Query("SELECT * FROM movies")
//    suspend fun getAll(): List<MovieEntity>
}
