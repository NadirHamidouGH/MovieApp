package com.example.movieapp.model

import android.os.Parcel
import android.os.Parcelable

data class Movie(
    val id: String?,
    val Title: String?,
    val year: String?,
    val genre: String?,
    val director: String?,
    val actors: String?,
    val plot: String?,
    val poster: String?,
    val images: List<String>,
    val rating: String?,
)

fun getMovies():List<Movie>{
    return listOf(
        Movie(
            "1",
            "Die Hard",
            "1988",
            "Action",
            "John McTiernan",
            "Bruce Willis, Alan Rickman",
            "A New York cop battles terrorists in a Los Angeles skyscraper.",
            "die_hard_poster.jpg",
            listOf("https://m.media-amazon.com/images/I/A1awJg9glEL._AC_UF1000,1000_QL80_.jpg",
                "https://borntowatch.fr/wp-content/uploads/2013/02/EnfantsDieHard_lead.jpg",
                "https://www.ecranlarge.com/uploads/image/001/013/die-hard-4-retour-en-enfer-photo-bruce-willis-justin-long-1013327.jpg",
                "https://img.hulu.com/user/v3/artwork/efc8250c-aeed-4ab7-a492-07064c826bc1?base_image_bucket_name=image_manager&base_image=d39b1f8f-863d-4b86-aacc-0cd06446cb0e&size=600x338&format=jpeg"),
            "8.2"
        ),

        // Example 2
        Movie(
            "2",
            "Mad Max: Fury Road",
            "2015",
            "Action",
            "George Miller",
            "Tom Hardy, Charlize Theron",
            "In a post-apocalyptic wasteland, Max teams up with a rebel warrior to escape a cult leader.",
            "mad_max_poster.jpg",
            listOf("https://images.bfmtv.com/2SFv7NG-qa4a0em5wBvaAMq6XGg=/0x0:1280x720/1280x0/images/-334272.jpg",
                "https://www.francetvinfo.fr/pictures/euQT9Curd_qzwwlvEF8_B_j1IeQ/1200x900/2019/04/12/madmaxfury_road.jpg",
                "https://www.google.com/url?sa=i&url=https%3A%2F%2Fwww.20minutes.fr%2Fcinema%2F1604507-20150511-vu-mad-max-fury-road-trois-raisons-lesquelles-film-demenage-peu&psig=AOvVaw0s9msImwmiB_dQdlzClxUJ&ust=1701441056398000&source=images&cd=vfe&opi=89978449&ved=0CBEQjRxqFwoTCPjwg4H464IDFQAAAAAdAAAAABAE",
                "https://m.media-amazon.com/images/I/A1fz-BF96tL._AC_UF1000,1000_QL80_.jpg"),
            "8.1"
        ),

        // Example 3
        Movie(
            "3",
            "The Dark Knight",
            "2008",
            "Action",
            "Christopher Nolan",
            "Christian Bale, Heath Ledger",
            "Batman faces off against the Joker, a criminal mastermind seeking chaos in Gotham City.",
            "dark_knight_poster.jpg",
            listOf("https://pelliculte.com/wp-content/uploads/2022/09/the_dark_knight_le_chevalier_noir.webp",
                "https://www.premiere.fr/sites/default/files/styles/scale_crop_1280x720/public/2021-07/E7I663yX0AYg_wm.jpeg",
                "https://www.lepoint.fr/images/2018/07/19/15859017lpw-15859081-article-jpg_5427311_1250x625.jpg",
                "https://images.ladepeche.fr/api/v1/images/view/5c34d2f53e454659430d33a5/large/image.jpg"),
            "9.0"
        )
    )
}