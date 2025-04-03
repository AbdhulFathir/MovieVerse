package com.example.movieverse

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.movieverse.ui.theme.MovieVerseTheme

class SearchByTitle : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MovieVerseTheme {
                SearchByTitleScreen()
            }
        }
    }
}

@Composable
fun SearchByTitleScreen() {
    var movieTitle by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Search By Title", fontSize = 20.sp)
        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = movieTitle,
            onValueChange = { movieTitle = it },
            label = { Text("Enter movie title") }
        )

        Spacer(modifier = Modifier.height(16.dp))

        CustomButton(text = "Retrieve Movie") {
            // TODO: Fetch from API
        }

        Spacer(modifier = Modifier.height(8.dp))

        CustomButton(text = "Save Movie to DB") {
            // TODO: Save to Room
        }
    }
}
