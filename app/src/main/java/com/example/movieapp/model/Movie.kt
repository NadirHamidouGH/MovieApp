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
    val images: List<String>?,
    val rating: String?,
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.createStringArrayList(),
        parcel.readString()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(id)
        parcel.writeString(Title)
        parcel.writeString(year)
        parcel.writeString(genre)
        parcel.writeString(director)
        parcel.writeString(actors)
        parcel.writeString(plot)
        parcel.writeString(poster)
        parcel.writeStringList(images)
        parcel.writeString(rating)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Movie> {
        override fun createFromParcel(parcel: Parcel): Movie {
            return Movie(parcel)
        }

        override fun newArray(size: Int): Array<Movie?> {
            return arrayOfNulls(size)
        }
    }
}

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
                "https://images.ladepeche.fr/api/v1/images/view/5c34d2f53e454659430d33a5/large/image.jpg"),
            "9.0"
        )
    )
}