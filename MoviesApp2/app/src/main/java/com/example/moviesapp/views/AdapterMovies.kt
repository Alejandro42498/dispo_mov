package com.example.moviesapp.views

import android.content.Context
import android.text.Html
import androidx.recyclerview.widget.RecyclerView
import com.example.moviesapp.models.MovieModel
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.example.moviesapp.R
import androidx.cardview.widget.CardView
import android.widget.TextView
import androidx.core.text.HtmlCompat
import android.view.LayoutInflater
import androidx.appcompat.app.AlertDialog
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.moviesapp.core.Constants
import com.example.moviesapp.core.Constants.API_URL_IMAGE
import com.example.moviesapp.core.Constants.IMAGE_HEIGHT
import com.example.moviesapp.core.Constants.IMAGE_WIDTH

class AdapterMovies (

    val context: Context,
    var moviesList: List<MovieModel>,

): RecyclerView.Adapter<AdapterMovies.ViewHolder>() {


    // ViewHolder class to hold the views for each movie item
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        // Initialize views here
        val cvMovie = itemView.findViewById(R.id.cvMovie) as CardView
        val ivImage = itemView.findViewById(R.id.ivImage) as ImageView
        val tvInfo = itemView.findViewById(R.id.tvInfo) as TextView
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_rvmovie, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(
        holder: ViewHolder,
        position: Int
    ) {

        val movie = moviesList[position]

        Glide.with(context)
            .load("${Constants.API_URL_IMAGE}${movie.image}")
            .apply(RequestOptions().override(Constants.IMAGE_WIDTH, Constants.IMAGE_HEIGHT))
            .into(holder.ivImage)


        holder.tvInfo.text = HtmlCompat.fromHtml(
            "<b>Title:</b>" + movie.title +
                    "<br><b>Popularuty:</b>" + movie.popularity +
                    "<br><b>Raiting:</b>" + movie.rating,
            HtmlCompat.FROM_HTML_MODE_LEGACY
        )

        holder.cvMovie.setOnClickListener {
            showOverview(movie.title, movie.overview)

        }
    }
    override fun getItemCount(): Int {
        return moviesList.size
    }

    private fun showOverview(title: String, overview: String) {

        val builder = AlertDialog.Builder(context)
        builder.setTitle(title)
        builder.setMessage(overview)
        builder.show()
    }

}