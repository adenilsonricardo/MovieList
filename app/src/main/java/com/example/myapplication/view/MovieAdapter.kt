package com.example.myapplication.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.databinding.MovieItemBinding
import com.example.myapplication.model.api.POSTER_BASE_URL
import com.example.myapplication.model.models.MovieItem
import com.squareup.picasso.Picasso

class MovieAdapter(var list: MutableList<MovieItem>):
    RecyclerView.Adapter<MovieAdapter.ViewHolder>(){

    class ViewHolder(val binding: MovieItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun onBind(moviePopular: MovieItem) {
            binding.movieName.text = moviePopular.title
            Picasso.get().load(POSTER_BASE_URL + moviePopular.posterPath).into(binding.movieImageView)
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(MovieItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val characters = list[position]
        holder.onBind(characters)
    }

    fun updateList(newList: MutableList<MovieItem>) {
        this.list.removeAll(list)
        if (newList != null) {
            this.list = newList
        }
        notifyDataSetChanged()
    }

}