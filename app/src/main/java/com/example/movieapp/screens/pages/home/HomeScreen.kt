package com.example.movieapp.screens.pages.home

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SmallTopAppBar
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.movieapp.components.MovieCard
import com.example.movieapp.model.Movie
import com.example.movieapp.model.getMovies
import com.example.movieapp.navigation.MovieScreens

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(navController: NavController){
    Scaffold(
        topBar = {
            Surface(shadowElevation = 3.dp) {
                SmallTopAppBar(title = {
                    Text(
                        text = "Movies"
                    )
                })
            }
        },
    ) {
            innerPadding ->
        Box(modifier = Modifier.padding(innerPadding)){
           MainContent(navController = navController)


        }
    }
}

@Composable
fun MainContent(
    navController: NavController,
    movieList:List<Movie> = getMovies()
){
    Surface(color = MaterialTheme.colorScheme.background){
        LazyColumn {
            items(items = movieList) {
                MovieCard(it){
                        movie->
                    try {
                        navController.navigate(MovieScreens.DetailsScreen.name+"/${it.id}")
                    }catch (e : Exception ){
                        print("exception navigate to --------> details " + e )
                    }
                }
            }
        }
    }
}