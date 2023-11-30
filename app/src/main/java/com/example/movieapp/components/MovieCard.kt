package com.example.movieapp.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Card
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberImagePainter
import coil.transform.CircleCropTransformation
import com.example.movieapp.R
import com.example.movieapp.model.Movie
import com.example.movieapp.model.getMovies

@Preview
@Composable
fun MovieCard(movieTitle: Movie = getMovies()[1], onItemClick: (String) -> Unit = {}) {
    var expanded by remember {
        mutableStateOf(false)
    }
    // Create a card with elevation shadow
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .shadow(8.dp)
            .clickable {
                onItemClick(movieTitle.Title.toString())
            },
    ) {
        // Row to contain the text and any other content
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Example: Icon on the left side of the text
            Surface(
                modifier = Modifier
                    .padding(0.dp)
                    .size(150.dp),
                    shape = RectangleShape,
                    color = Color.Transparent,
            ){
                Image(painter = rememberImagePainter(
                    data = movieTitle.images?.get(0),
                    builder = {
                              crossfade(true)
                              transformations(CircleCropTransformation())
                              },
                    ),
                    modifier = Modifier
                        .size(150.dp)
                        .shadow(
                            elevation = 10.dp,
                            shape = CircleShape
                        ),
                    contentDescription = "Movie image" )
            }


            // Spacer to add some space between the icon and the text
            Spacer(modifier = Modifier.width(16.dp))

            Column(
                modifier = Modifier.fillMaxWidth()
            ){
                Row{

                    Text(

                        text = movieTitle.Title?.take(20) ?: "",
                        style = MaterialTheme.typography.titleMedium,
                        color = MaterialTheme.colorScheme.primary,

                    )

                    Spacer(modifier = Modifier.width(8.dp))

                    Icon(imageVector =if(expanded) Icons.Filled.KeyboardArrowUp else  Icons.Filled.KeyboardArrowDown,
                        contentDescription = "Down Arrow",
                        tint = MaterialTheme.colorScheme.primary,

                        modifier =  Modifier.size(25.dp)
                            .align(CenterVertically)
                            .clickable{
                                expanded = !expanded
                            })
                }


                Spacer(modifier = Modifier.width(16.dp))

                Text(
                    text = "${movieTitle.genre ?: ""}, ${movieTitle.year ?: ""}",
                    style = MaterialTheme.typography.titleMedium,
                    color = MaterialTheme.colorScheme.secondary
                )

                Spacer(modifier = Modifier.width(16.dp))

                Text(
                    text = "Rating: ${movieTitle.rating ?: ""}",
                    style = MaterialTheme.typography.titleMedium,
                    color = MaterialTheme.colorScheme.secondary
                )
                
                AnimatedVisibility(visible = expanded){
                    Column {

                        Spacer(modifier = Modifier.height(8.dp))


                            Text(
                                text = "Plot",
                                style = MaterialTheme.typography.labelMedium,
                                color = MaterialTheme.colorScheme.primary
                            )

                            Text(
                                text = movieTitle.plot ?: "",
                                style = MaterialTheme.typography.labelMedium,
                                color = MaterialTheme.colorScheme.secondary
                            )

                        Spacer(modifier = Modifier.height(8.dp))


                            Text(
                                text = "Director",
                                style = MaterialTheme.typography.labelMedium,
                                color = MaterialTheme.colorScheme.primary
                            )

                            Text(
                                text = movieTitle.director ?: "",
                                style = MaterialTheme.typography.labelMedium,
                                color = MaterialTheme.colorScheme.secondary
                            )

                        Spacer(modifier = Modifier.height(8.dp))

                            Text(
                                text = "Actors",
                                style = MaterialTheme.typography.labelMedium,
                                color = MaterialTheme.colorScheme.primary
                            )
                            Text(
                                text = movieTitle.actors ?: "",
                                style = MaterialTheme.typography.labelMedium,
                                color = MaterialTheme.colorScheme.secondary
                            )

                        Divider(modifier = Modifier.padding(3.dp))

                        Text(
                                buildAnnotatedString{
                                withStyle(
                                    style = SpanStyle(
                                        color = Color.DarkGray,
                                        fontSize = 13.sp,
                                        fontWeight = FontWeight.Bold)){
                                    append("Director ")
                                }
                                withStyle(
                                    style = SpanStyle(
                                        color = Color.DarkGray,
                                        fontSize = 13.sp,
                                        fontWeight = FontWeight.Bold)){
                                    append(movieTitle.director)
                                }
                            }
                        )
                    }
                }

            }
            // Text with the provided string parameter
        }
    }
}

