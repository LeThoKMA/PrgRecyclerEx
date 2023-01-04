package com.example.prgrecyclerex

sealed class MovieItem(id: String) {
    class TopBanner(id: String) : MovieItem(id)
    class Top10(id: String) : MovieItem(id)
    class TvShow(id: String) : MovieItem(id)
    class Trending(id: String) : MovieItem(id)
    class Anime(id: String) : MovieItem(id)

}

enum class MovieType {
    TOP_BANNER,
    TOP_10,
    TV_SHOW,
    TRENDING,
    ANIME
}
