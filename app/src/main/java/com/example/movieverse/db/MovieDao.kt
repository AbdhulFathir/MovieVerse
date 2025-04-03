package com.example.movieverse.db

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface MovieDao {
    @Query("SELECT * FROM movies ORDER BY id DESC")
    fun getAllMovies(): LiveData<List<Movie>>

    @Insert
    fun addMovie(item: Movie)

//    @Query("SELECT * FROM movies WHERE actors LIKE '%' || :actor || '%' COLLATE NOCASE")
//    suspend fun searchByActor(actor: String): List<MovieEntity>
//
//    @Query("SELECT * FROM movies")
//    suspend fun getAll(): List<MovieEntity>

}
