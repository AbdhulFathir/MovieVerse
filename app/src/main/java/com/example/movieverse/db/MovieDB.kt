package com.example.movieverse.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters

@Database(entities = [Movie::class], version = 1)
@TypeConverters(Converter::class)
abstract class MovieDB: RoomDatabase() {
    companion object {
        const val NAME = "movie_db"
    }

    abstract fun getMovieDAO(): MovieDao
}
