package com.example.movieapp.screens.pages.details

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SmallTopAppBar
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.movieapp.model.getMovies

@OptIn(ExperimentalMaterial3Api::class)

@Composable
fun DetailsScreen(navController: NavController, movieId: String?){

val newMovieList = getMovies().filter{
    movie-> movie.id == movieId
}
    Scaffold(
        topBar = {
            Surface(shadowElevation = 3.dp) {
                SmallTopAppBar(
                    title = {
                        Row(
                            horizontalArrangement = Arrangement.Start
                        ){
                            Icon(imageVector = Icons.Default.ArrowBack,
                             contentDescription = "back button",
                             modifier = Modifier
                                 .clickable{
                                 navController.popBackStack()
                             })

                            Spacer(modifier = Modifier.width(16.dp))

                            Text(
                                text = newMovieList[0].Title.toString(),
                            )
                        }
                }
                )
            }
        },
    ) { innerPadding ->
        Box(modifier = Modifier.padding(innerPadding)){
            Surface(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight()
            ){
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ){
                    Text(text = "The movie id is ${newMovieList[0].id}",
                        style = MaterialTheme.typography.bodyLarge
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    Text(text = "Movie Title : ${newMovieList[0].Title}",
                        style = MaterialTheme.typography.bodyLarge
                    )
                }
            }
        }
    }
}