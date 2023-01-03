package com.example.prgrecyclerex

sealed class MovieItem() {
    class TopBanner() : MovieItem()
    class Top10() : MovieItem()
    class TvShow() : MovieItem()
    class Trending() : MovieItem()
    class Anime() : MovieItem()

}

enum class MovieType(var value: Int) {
    TOP_BANNER(0),
    TOP_10(1),
    TV_SHOW(2),
    TRENDING(3),
    ANIME(4)
}
