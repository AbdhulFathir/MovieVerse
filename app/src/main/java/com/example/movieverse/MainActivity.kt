package com.example.movieverse

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat.startActivity
import com.example.movieverse.ui.theme.MovieVerseTheme

class MainActivity : ComponentActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MovieVerseTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    Image(
                        painter = painterResource(id = R.drawable.bg_image),
                        contentDescription = "Background Image",
                        modifier = Modifier.fillMaxSize(),
                        contentScale = ContentScale.Crop
                    )
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(24.dp),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        CustomButton(text = "Add Movies to DB") {
                            val intent = Intent(this@MainActivity, AddMovies::class.java)
                            startActivity(intent)
                        }
                        Spacer(modifier = Modifier.height(16.dp))

                        CustomButton(text = "Search for Movies") {
                            val intent = Intent(this@MainActivity, SearchMovies::class.java)
                            startActivity(intent)
                        }
                        Spacer(modifier = Modifier.height(16.dp))

                        CustomButton(text = "Search for Actors") {
                            val intent = Intent(this@MainActivity, SearchActors::class.java)
                            startActivity(intent)
                        }
                        Spacer(modifier = Modifier.height(16.dp))

                        CustomButton(text = "Search by Title ") {
                            val intent = Intent(this@MainActivity, SearchByTitle::class.java)
                            startActivity(intent)
                        }
                    }
                }
            }
        }
    }
}



@Composable
fun CustomButton(text: String, onClick: () -> Unit) {
    Button(
        onClick = onClick,
        modifier = Modifier
            .width(300.dp)
            .height(50.dp),
        shape = RoundedCornerShape(20.dp)
    ) {
        Text(text, fontSize = 18.sp)
    }
}
