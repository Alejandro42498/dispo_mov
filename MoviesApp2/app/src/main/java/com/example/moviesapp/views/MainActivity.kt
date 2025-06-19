package com.example.moviesapp.views

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.moviesapp.R
import com.example.moviesapp.databinding.ActivityMainBinding
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import com.example.moviesapp.viewmodels.MoviesViewModel
import androidx.recyclerview.widget.GridLayoutManager
import com.example.moviesapp.views.AdapterMovies


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MoviesViewModel
    private lateinit var btnGetAll: Button
    private lateinit var btnGetPopular: Button
    private lateinit var btnGetTopRated: Button
    private lateinit var btnGetUpcoming: Button
    private lateinit var tvCategory: TextView
    private lateinit var adapterMovies: AdapterMovies

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Controles
        btnGetAll = findViewById(R.id.btnGetAll)
        btnGetPopular = findViewById(R.id.btnGetPopular)
        btnGetTopRated = findViewById(R.id.btnGetTopRated)
        btnGetUpcoming = findViewById(R.id.btnGetUpcoming)
        tvCategory = findViewById(R.id.tvCategory)

        // viewModel
        viewModel = ViewModelProvider(this)[MoviesViewModel::class.java]
        setupRecyclerView()

        //Método inicial
        tvCategory.text = "Premiere"
        viewModel.getAllMovies()

        // Observador
        viewModel.moviesList.observe(this) {
            adapterMovies.moviesList = it
            adapterMovies.notifyDataSetChanged()
        }

        btnGetAll.setOnClickListener {
            tvCategory.text = "Premiere"
            viewModel.getAllMovies()
        }
        viewModel.getAllMovies()
        btnGetTopRated.setOnClickListener {
            tvCategory.text = "Top Rated"
            viewModel.getTopRate()
        }
        btnGetPopular.setOnClickListener {
            tvCategory.text = "Popular"
            viewModel.getPopular()
        }
        btnGetUpcoming.setOnClickListener {
            tvCategory.text = "Upcoming"
            viewModel.getUpcoming()
        }


    }

    private fun setupRecyclerView() {
        val layoutManager = GridLayoutManager(this, 3)
        binding.rvMovies.layoutManager = layoutManager
        adapterMovies = AdapterMovies(this, arrayListOf())
        binding.rvMovies.adapter = adapterMovies

    }
}
