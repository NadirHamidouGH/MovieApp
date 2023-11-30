package com.example.movieapp.screens.pages.details

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.rememberImagePainter
import coil.transform.CircleCropTransformation
import com.example.movieapp.model.getMovies

@OptIn(ExperimentalMaterial3Api::class)

@Composable
fun DetailsScreen(navController: NavController, movieId: String?){
    val scrollState = rememberScrollState()

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
                    .fillMaxSize()
            ){
                //++++++++++++++++++++++++++++++++++++++++++
                Column(
                    modifier = Modifier
                        .padding(16.dp)
                        .fillMaxHeight()
                        .verticalScroll(state = scrollState)


                ) {

                    ///////////////////////////////////

                    Image(
                        modifier = Modifier
                            .fillMaxWidth()
                            .sizeIn(maxHeight = 200.dp)
                        //    .height(intrinsicHeight)
                        ,
                        painter = rememberImagePainter(
                            data = newMovieList[0].images?.get(0),
                        ),
                        contentDescription = "Movie poster",

                    )

                    LazyRow{
                        items(newMovieList[0].images){
                                image -> Surface(
                            modifier = Modifier
                                .padding(12.dp)
                                .size(150.dp)
                                .background(Color.Transparent) // Set transparent background
                        ){
                            Image(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .sizeIn(maxHeight = 200.dp)
                                //    .height(intrinsicHeight)
                                ,
                                painter = rememberImagePainter(
                                    data = image,
                                    ),
                                contentDescription = "Movie poster",
                                )
                        }
                        }
                    }
                    ///////////////////////////////////

                    Spacer(modifier = Modifier.height(16.dp))

                    Text(
                        text = "Title: ${newMovieList[0].Title ?: ""}",
                        style = MaterialTheme.typography.headlineMedium
                    )

                    Spacer(modifier = Modifier.height(8.dp))

                    Text(
                        text = "Year: ${newMovieList[0].year ?: ""}",
                        style = MaterialTheme.typography.bodyMedium
                    )

                    Spacer(modifier = Modifier.height(8.dp))

                    Text(
                        text = "Genre: ${newMovieList[0].genre ?: ""}",
                        style = MaterialTheme.typography.bodyMedium
                    )

                    Spacer(modifier = Modifier.height(8.dp))

                    Text(
                        text = "Director: ${newMovieList[0].director ?: ""}",
                        style = MaterialTheme.typography.bodyMedium
                    )

                    Spacer(modifier = Modifier.height(8.dp))

                    Text(
                        text = "Actors: ${newMovieList[0].actors ?: ""}",
                        style = MaterialTheme.typography.bodyMedium
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    Text(
                        text = "Plot:",
                        style = MaterialTheme.typography.bodyLarge
                    )

                    Spacer(modifier = Modifier.height(8.dp))

                    Text(
                        text = newMovieList[0].plot ?: "",
                        style = MaterialTheme.typography.bodyMedium
                    )
                }
            }
        }
    }
}