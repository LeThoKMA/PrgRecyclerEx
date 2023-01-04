package com.example.prgrecyclerex

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private val adapter by lazy {
        HomeAdapter()
    }
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val rc = findViewById<RecyclerView>(R.id.rc_home)
        val list = mutableListOf<MovieItem>()
        list.add(MovieItem.TopBanner(MovieType.TOP_BANNER.ordinal.toString()))
        list.add(MovieItem.Top10(MovieType.TOP_10.ordinal.toString()))
        list.add(MovieItem.TvShow(MovieType.TV_SHOW.ordinal.toString()))
        list.add(MovieItem.Trending(MovieType.TRENDING.ordinal.toString()))
        list.add(MovieItem.Anime(MovieType.ANIME.ordinal.toString()))
        adapter.submitList(list)
        rc.adapter = adapter
    }
}