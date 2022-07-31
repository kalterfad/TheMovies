package com.kalterfad.movietest.screens.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.kalterfad.movietest.R
import com.kalterfad.movietest.network.APIResponse
import com.kalterfad.movietest.network.Movie
import com.kalterfad.movietest.utils.APP_ACTIVITY
import kotlinx.android.synthetic.main.movie_card.view.*


class HomeAdapter(
    private var mListMovies: MutableList<Movie>,
    val getMovies: (Int) -> MutableLiveData<APIResponse>
) : RecyclerView.Adapter<HomeAdapter.MainHolder>() {

    class MainHolder(view: View) : RecyclerView.ViewHolder(view) {
        val movieImage: ImageView = view.movie_poster
        val movieName: TextView = view.movie_name
        val movieDescription: TextView = view.movie_description
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.movie_card, parent, false)
        return MainHolder(view)
    }

    override fun onBindViewHolder(holder: MainHolder, position: Int) {
        holder.movieImage.load(mListMovies[position].multimedia.src)
        holder.movieName.text = mListMovies[position].display_title
        holder.movieDescription.text = mListMovies[position].summary_short

        if (position == mListMovies.size - 9) {

            getMovies(mListMovies.size).observe(APP_ACTIVITY) {
                mListMovies.addAll(it.results)
                notifyItemRangeInserted(mListMovies.lastIndex, it.results.size)
            }
        }
    }

    override fun getItemCount(): Int = mListMovies.size
}