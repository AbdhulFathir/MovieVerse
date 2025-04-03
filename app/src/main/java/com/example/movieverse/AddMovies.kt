package com.example.movieverse

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.lifecycle.lifecycleScope
import com.example.movieverse.db.MovieDatabase
import com.example.movieverse.db.MovieEntity
import com.example.movieverse.ui.theme.MovieVerseTheme
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.launch

class AddMovies : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MovieVerseTheme {
                AddMoviesScreen { insertMoviesToDB() }
            }
        }
    }

    private fun insertMoviesToDB() {
        val db = MovieDatabase.getDatabase(this)
        val dao = db.movieDao()

        val hardcodedMovies = listOf(
            MovieEntity(
                imdbID = "tt0111161",
                title = "The Shawshank Redemption",
                year = "1994",
                rated = "R",
                released = "14 Oct 1994",
                runtime = "142 min",
                genre = "Drama",
                director = "Frank Darabont",
                writer = "Stephen King, Frank Darabont",
                actors = "Tim Robbins, Morgan Freeman, Bob Gunton",
                plot = "Two imprisoned men bond over a number of years, finding solace and eventual redemption through acts of common decency."
            ),
            MovieEntity(
                imdbID = "tt0068646",
                title = "The Godfather",
                year = "1972",
                rated = "R",
                released = "24 Mar 1972",
                runtime = "175 min",
                genre = "Crime, Drama",
                director = "Francis Ford Coppola",
                writer = "Mario Puzo, Francis Ford Coppola",
                actors = "Marlon Brando, Al Pacino, James Caan",
                plot = "An organized crime dynasty's aging patriarch transfers control of his clandestine empire to his reluctant son."
            )
            // Add more movies if needed
        )

//        lifecycleScope.launch {
//            dao.insertAll(hardcodedMovies)
//            Toast.makeText(applicationContext, "Movies inserted!", Toast.LENGTH_SHORT).show()
//        }
    }
}

@Composable
fun AddMoviesScreen(onAddMovies: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Add Hardcoded Movies to Local DB", fontSize = 20.sp)
        Spacer(modifier = Modifier.height(24.dp))

        Button(onClick = onAddMovies) {
            Text("Add Movies")
        }
    }
}
