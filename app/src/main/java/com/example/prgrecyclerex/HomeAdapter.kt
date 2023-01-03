package com.example.prgrecyclerex

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.prgrecyclerex.MovieItem.TopBanner

class HomeAdapter() :
    ListAdapter<MovieItem, RecyclerView.ViewHolder>(object : DiffUtil.ItemCallback<MovieItem>() {
        override fun areItemsTheSame(oldItem: MovieItem, newItem: MovieItem): Boolean {
            return true
        }

        override fun areContentsTheSame(oldItem: MovieItem, newItem: MovieItem): Boolean {
            return true
        }

    }) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            MovieType.TOP_BANNER.value -> TopBannerViewHolder.create(parent)
            MovieType.TOP_10.value -> Top10ViewHolder.create(parent)
            MovieType.TV_SHOW.value -> TvShowViewHolder.create(parent)

            MovieType.TRENDING.value -> TrendingViewHolder.create(parent)

            MovieType.ANIME.value -> AnimeViewHolder.create(parent)

            else -> EmptyViewHolder.create(parent)
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (position == MovieType.TOP_BANNER.value) {

        } else if (position == MovieType.TOP_10.value) {
            (holder as Top10ViewHolder).bind()
        } else if (position == MovieType.TV_SHOW.value) {
            (holder as TvShowViewHolder).bind()
        } else if (position == MovieType.TRENDING.value) {
            (holder as TrendingViewHolder).bind()
        } else if (position == MovieType.ANIME.value) {
            (holder as AnimeViewHolder).bind()
        } else {

        }
    }

    override fun getItemViewType(position: Int): Int {
        Log.e("TAG", position.toString())
        return when (getItem(position)) {
            is TopBanner -> {
                MovieType.TOP_BANNER.value
            }
            is MovieItem.Top10 -> {
                MovieType.TOP_10.value
            }
            is MovieItem.TvShow -> {
                MovieType.TV_SHOW.value
            }
            is MovieItem.Trending -> {
                MovieType.TRENDING.value
            }
            is MovieItem.Anime -> {
                MovieType.ANIME.value
            }

        }
    }

    class TopBannerViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        companion object {
            fun create(parent: ViewGroup): TopBannerViewHolder {
                val view = LayoutInflater.from(parent.context)
                    .inflate(R.layout.top_banner_item, parent, false)
                return TopBannerViewHolder(view)
            }
        }
    }

    class Top10ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var title = view.findViewById<TextView>(R.id.tv_title)
        var rc = view.findViewById<RecyclerView>(R.id.rc_child)
        fun bind() {
            title.text = "Top 10 TV Show in VietNam Today"
            var list: ArrayList<Int> = arrayListOf()
            for (i in 0 until 8) {
                list.add(i)
            }
            var adapter = ChildAdapter()
            adapter.submitList(list)
            rc.layoutManager =
                LinearLayoutManager(rc.rootView.context, RecyclerView.HORIZONTAL, false)

            rc.adapter = adapter


        }

        companion object {
            fun create(parent: ViewGroup): Top10ViewHolder {
                val view = LayoutInflater.from(parent.context)
                    .inflate(R.layout.tv_show_item, parent, false)
                return Top10ViewHolder(view)
            }
        }
    }

    class TvShowViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var title = view.findViewById<TextView>(R.id.tv_title)

        var rc = view.findViewById<RecyclerView>(R.id.rc_child)
        fun bind() {
            title.text = "TV Show"

            var list: ArrayList<Int> = arrayListOf()
            for (i in 0 until 8) {
                list.add(i)
            }
            var adapter = ChildAdapter()
            adapter.submitList(list)
            rc.layoutManager =
                LinearLayoutManager(rc.rootView.context, RecyclerView.HORIZONTAL, false)

            rc.adapter = adapter


        }

        companion object {
            fun create(parent: ViewGroup): TvShowViewHolder {
                val view = LayoutInflater.from(parent.context)
                    .inflate(R.layout.tv_show_item, parent, false)
                return TvShowViewHolder(view)
            }
        }
    }

    class TrendingViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var title = view.findViewById<TextView>(R.id.tv_title)

        var rc = view.findViewById<RecyclerView>(R.id.rc_child)
        fun bind() {
            title.text = "Trending"

            var list: ArrayList<Int> = arrayListOf()
            for (i in 0 until 8) {
                list.add(i)
            }
            var adapter = ChildAdapter()
            adapter.submitList(list)
            rc.layoutManager =
                LinearLayoutManager(rc.rootView.context, RecyclerView.HORIZONTAL, false)
            rc.adapter = adapter


        }

        companion object {
            fun create(parent: ViewGroup): TrendingViewHolder {
                val view = LayoutInflater.from(parent.context)
                    .inflate(R.layout.tv_show_item, parent, false)
                return TrendingViewHolder(view)
            }
        }
    }

    class AnimeViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var title = view.findViewById<TextView>(R.id.tv_title)

        var rc = view.findViewById<RecyclerView>(R.id.rc_child)
        fun bind() {
            title.text = "Anime"

            var list: ArrayList<Int> = arrayListOf()
            for (i in 0 until 8) {
                list.add(i)
            }
            var adapter = ChildAdapter()
            adapter.submitList(list)
            rc.layoutManager =
                LinearLayoutManager(rc.rootView.context, RecyclerView.HORIZONTAL, false)
            rc.adapter = adapter


        }

        companion object {
            fun create(parent: ViewGroup): AnimeViewHolder {
                val view = LayoutInflater.from(parent.context)
                    .inflate(R.layout.tv_show_item, parent, false)
                return AnimeViewHolder(view)
            }
        }
    }

    class EmptyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        companion object {
            fun create(parent: ViewGroup): EmptyViewHolder {
                val view = LayoutInflater.from(parent.context)
                    .inflate(R.layout.null_item, parent, false)
                return EmptyViewHolder(view)
            }
        }
    }
}