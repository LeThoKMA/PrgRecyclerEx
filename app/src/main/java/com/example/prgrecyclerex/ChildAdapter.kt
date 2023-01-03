package com.example.prgrecyclerex

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView

class ChildAdapter() :
    ListAdapter<Int, RecyclerView.ViewHolder>(object : DiffUtil.ItemCallback<Int>() {
        override fun areItemsTheSame(oldItem: Int, newItem: Int): Boolean {
            return true
        }

        override fun areContentsTheSame(oldItem: Int, newItem: Int): Boolean {
            return true

        }

    }) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return ViewHoder.create(parent)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
    }

    class ViewHoder(view: View) : RecyclerView.ViewHolder(view) {
        fun bind() {

        }

        companion object {
            fun create(parent: ViewGroup): ViewHoder {
                val view = LayoutInflater.from(parent.context)
                    .inflate(R.layout.image_item, parent, false)
                return ViewHoder(view)
            }
        }

    }


}