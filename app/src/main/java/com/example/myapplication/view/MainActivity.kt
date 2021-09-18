package com.example.myapplication.view

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.R
import com.example.myapplication.databinding.ActivityMainBinding
import com.example.myapplication.model.models.MovieItem
import com.example.myapplication.viewmodel.MoviePopularViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MoviePopularViewModel

    private val list = mutableListOf<MovieItem>()
    private val adapter = MovieAdapter(list)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this).get(MoviePopularViewModel::class.java)

        binding.recyclerViewXml.adapter = adapter
        binding.recyclerViewXml.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)

        viewModel.getPopularMovies()

        viewModel.movieResult.observe(this, Observer {
            adapter.updateList(it.results)
        })
    }
}