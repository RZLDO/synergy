package id.synergy.activitybase.data

data class DataCategoryMovieModel (
    val image : String,
    val title : String,
    val subtitle : String
)
val categoryMovieList = listOf(
    DataCategoryMovieModel(
        "https://storygrid.com/wp-content/uploads/2022/07/Action-Genre.png",
        "Action",
        "Subtitle 1"
    ),
    DataCategoryMovieModel(
        "https://dnm.nflximg.net/api/v6/BvVbc2Wxr2w6QuoANoSpJKEIWjQ/AAAAQbErmC_YVqIeZttnP8OQMpJPiHN9d9aJz1sqL12wtQCZB2Xpzc6fAqNtdhBTwOb5l-PzCusxBHdfA0vP7AfYzTjGo7NiB47OhyOoWCcClt8M8R1Dd9EFkNfrnEwNmMjwqIJ11Vz6HdEPQUJvzYI238U_.jpg?r=936",
        "Comedy",
        "Subtitle 2"
    ),
    DataCategoryMovieModel(
        "https://storygrid.com/wp-content/uploads/2022/05/Love-Genre.jpg",
        "Romance",
        "Subtitle 3"
    ),
    DataCategoryMovieModel(
        "https://storygrid.com/wp-content/uploads/2022/05/Copy-of-Love-Genre-1-1024x1024.png",
        "Thriller",
        "Subtitle 3"
    ),
)