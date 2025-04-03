package com.example.movieverse

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.movieverse.db.Movie
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MovieViewModel : ViewModel() {
    private val movieDao = MainApplication.database.getMovieDAO()
    val movieItems: LiveData<List<Movie>> = movieDao.getAllMovies()

    fun addMovieItem(title: String,
                     year: String,
                     rated: String,
                     released: String,
                     runtime: String,
                     genre: String,
                     director: String,
                     writer: String,
                     actors: String,
                     plot: String,
                     id: String) {
        viewModelScope.launch(Dispatchers.IO) {
            val item = Movie(
                title = title,
                year = year,
                rated = rated,
                released = released,
                runtime = runtime,
                genre = genre,
                director = director,
                writer = writer,
                actors = actors,
                plot = plot,
                id = id
            )

            movieDao.addMovie(item)
        }
    }


}