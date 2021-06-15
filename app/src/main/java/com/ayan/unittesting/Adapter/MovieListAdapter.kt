package com.ayan.unittesting.Adapter

import android.content.Context
import com.airbnb.epoxy.EpoxyAdapter
import com.ayan.unittesting.EpoxyModels.MovieListModel_
import com.ayan.unittesting.EpoxyModels.MovieSelected
import com.ayan.unittesting.Movie

class MovieListAdapter(private val context: Context, val movies: List<Movie>,movieSelected: MovieSelected): EpoxyAdapter() {


    init {
        movies.forEach {
            addModel(MovieListModel_(it,context,movieSelected))
        }
    }
}