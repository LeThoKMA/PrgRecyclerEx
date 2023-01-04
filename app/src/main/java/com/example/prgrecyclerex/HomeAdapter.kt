package com.example.prgrecyclerex

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
            MovieType.TOP_BANNER.ordinal -> TopBannerViewHolder.create(parent)
            MovieType.TOP_10.ordinal -> Top10ViewHolder.create(parent)
            MovieType.TV_SHOW.ordinal -> TvShowViewHolder.create(parent)
            MovieType.TRENDING.ordinal -> TrendingViewHolder.create(parent)
            MovieType.ANIME.ordinal -> AnimeViewHolder.create(parent)
            else -> EmptyViewHolder.create(parent)
        }
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        when (getItem(position)) {
            is TopBanner -> {
                (holder as TopBannerViewHolder).bind()
            }
            is MovieItem.TvShow -> {
                (holder as TvShowViewHolder).bind()
            }
            is MovieItem.Top10 -> {
                (holder as Top10ViewHolder).bind()
            }
            is MovieItem.Trending -> {
                (holder as TrendingViewHolder).bind()
            }
            else -> {
                (holder as AnimeViewHolder).bind()
            }
        }
    }

    override fun getItemViewType(position: Int): Int {
        return when (getItem(position)) {
            is TopBanner -> {
                MovieType.TOP_BANNER.ordinal
            }
            is MovieItem.Top10 -> {
                MovieType.TOP_10.ordinal
            }
            is MovieItem.TvShow -> {
                MovieType.TV_SHOW.ordinal
            }
            is MovieItem.Trending -> {
                MovieType.TRENDING.ordinal
            }
            is MovieItem.Anime -> {
                MovieType.ANIME.ordinal
            }
        }
    }

    class TopBannerViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun bind() {}

        companion object {
            fun create(parent: ViewGroup): TopBannerViewHolder {
                val view = LayoutInflater.from(parent.context)
                    .inflate(R.layout.top_banner_item, parent, false)
                return TopBannerViewHolder(view)
            }
        }
    }

    class Top10ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val title = view.findViewById<TextView>(R.id.tv_title)
        private val rc = view.findViewById<RecyclerView>(R.id.rc_child)
        private val adapter by lazy {
            ChildAdapter()
        }
        fun bind() {
            title.text = "Top 10 TV Show in VietNam Today"
            val list = mutableListOf(0, 1, 2, 3, 4, 5, 6, 7, 8)
            adapter.submitList(list)
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

    class TvShowViewHolder(view: View) : ViewHolder(view) {
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
