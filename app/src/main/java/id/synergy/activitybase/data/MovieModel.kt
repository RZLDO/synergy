package id.synergy.activitybase.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import java.io.Serializable

data class DataCategoryMovieModel (
    val image : String,
    val title : String,
    val subtitle : String,
    val listMovie : ArrayList<MovieModel>
)
@Parcelize
data class MovieModel (
    val image : String,
    val title : String,
    val subtitle : String
) : Parcelable
val actionMovieList = arrayListOf(
    MovieModel(
        "https://m.media-amazon.com/images/M/MV5BNDg5NTE0OGMtNDBlMC00YTRlLTgzOGEtY2MxZDVhNzdjZTM5XkEyXkFqcGdeQXVyNjgyMTI1MDE@._V1_.jpg",
        "Decibel",
        "Description",
    ),
    MovieModel(
        "https://www.syfy.com/sites/syfy/files/2019/05/john-wick-2017-image-3840x2400.jpg",
        "Keanu reeves",
        "Description",
    ),
    MovieModel(
        "https://akcdn.detik.net.id/visual/2022/02/17/film-the-batman-2022-6_169.jpeg?w=650",
        "Batman",
        "Description",
    )

)
val ComedyMovieList = arrayListOf(
    MovieModel(
        "https://m.media-amazon.com/images/S/pv-target-images/5537248546e7b180bb7c131cd6693bf48d7cc82c1b5daead2dc69fd49e7f6e7a.jpg",
        "Dead Silence",
        "Description",
    ),
    MovieModel(
        "https://cdns.klimg.com/resized/670x335/p/headline/siap-siap-sekuel-the-ring-akan-menerorm-4ff90e.jpg",
        "The Ring",
        "Description",
    ),
    MovieModel(
        "https://www.goldderby.com/wp-content/uploads/2018/05/Michael-Shannon-movies-ranked-Midnight-Special.jpg?w=620",
        "Shannon 4",
        "Description",
    )
)
val loveList = arrayListOf(
    MovieModel(
        "https://pbblogassets.s3.amazonaws.com/uploads/2020/04/01141054/titanic-cover.jpg",
        "Titanic",
        ""
    ),
    MovieModel(
        "https://m.media-amazon.com/images/M/MV5BNDk3NTEwNjc0MV5BMl5BanBnXkFtZTgwNzYxNTMwMzI@._V1_FMjpg_UX1000_.jpg",
        "Call me by your name",
        ""
    ),
    MovieModel(
        "https://media.newyorker.com/photos/59097c742179605b11ad90e2/master/w_2560%2Cc_limit/Brody-La-La-Land.jpg",
        "La la land",
        ""
    )

)
val categoryMovieList = listOf(
    DataCategoryMovieModel(
        "https://storygrid.com/wp-content/uploads/2022/07/Action-Genre.png",
        "Action",
        "Subtitle 1",
        actionMovieList
    ),
    DataCategoryMovieModel(
        "https://storygrid.com/wp-content/uploads/2022/05/Copy-of-Love-Genre.png.webp",
        "Horror",
        "Subtitle 2",
        ComedyMovieList
    ),
    DataCategoryMovieModel(
        "https://storygrid.com/wp-content/uploads/2022/05/Love-Genre.jpg",
        "Romance",
        "Subtitle 3",
        loveList
    ),
    DataCategoryMovieModel(
        "https://storygrid.com/wp-content/uploads/2022/05/Copy-of-Love-Genre-1-1024x1024.png",
        "Thriller",
        "Subtitle 3",
        actionMovieList
    ),
    DataCategoryMovieModel(
        "https://storygrid.com/wp-content/uploads/2022/06/Copy-of-Love-Genre-2.png.webp",
        "War",
        "Subtitle 3",
        loveList
    ),
    DataCategoryMovieModel(
        "https://storygrid.com/wp-content/uploads/2022/05/Crime-Genre.jpg.webp",
        "Crime",
        "Subtitle 3",
        ComedyMovieList
    ),
    DataCategoryMovieModel(
        "https://storygrid.com/wp-content/uploads/2022/07/Action-Genre-2.png.webp",
        "western & eastern",
        "Subtitle 3",
        loveList
    ),
    DataCategoryMovieModel(
        "https://storygrid.com/wp-content/uploads/2022/04/What-is-a.jpg",
        "performance",
        "Subtitle 3",
        actionMovieList
    ),
    DataCategoryMovieModel(
        "https://storygrid.com/wp-content/uploads/2022/05/Worldview-Genre.jpg.webp",
        "World View",
        "Subtitle 3",
        ComedyMovieList
    ),

)