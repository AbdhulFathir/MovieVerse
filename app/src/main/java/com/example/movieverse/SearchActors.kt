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

class SearchActors : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MovieVerseTheme {
                SearchActorsScreen()
            }
        }
    }
}

@Composable
fun SearchActorsScreen() {
    var actorQuery by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Search Movies by Actor", fontSize = 20.sp)
        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = actorQuery,
            onValueChange = { actorQuery = it },
            label = { Text("Enter actor name") }
        )

        Spacer(modifier = Modifier.height(16.dp))

        CustomButton(text = "Search") {
            // TODO: Query Room DB for matching actor
        }
    }
}
