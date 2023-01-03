package com.example.prgrecyclerex

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var list: ArrayList<MovieItem> = arrayListOf()
        list.add(MovieItem.TopBanner())
        list.add(MovieItem.Top10())
        list.add(MovieItem.TvShow())
        list.add(MovieItem.Trending())
        list.add(MovieItem.Anime())

        var rc = findViewById<RecyclerView>(R.id.rc_home)
        var adapter = HomeAdapter()
        adapter.submitList(list)
        rc.layoutManager = LinearLayoutManager(this)
        rc.adapter = adapter
    }
}