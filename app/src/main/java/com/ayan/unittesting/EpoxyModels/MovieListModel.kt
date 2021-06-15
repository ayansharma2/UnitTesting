package com.ayan.unittesting.EpoxyModels

import android.content.Context
import android.media.Image
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import com.airbnb.epoxy.EpoxyHolder
import com.airbnb.epoxy.EpoxyModelClass
import com.airbnb.epoxy.EpoxyModelWithHolder
import com.ayan.unittesting.Movie
import com.ayan.unittesting.R
import com.bumptech.glide.Glide


@EpoxyModelClass(layout = R.layout.movie_list_item)
abstract class MovieListModel(private val movie: Movie,private val context: Context,private val movieSelected: MovieSelected):EpoxyModelWithHolder<MovieListModel.Holder>() {


    override fun bind(holder: Holder) {
        super.bind(holder)
        Glide.with(context).load(movie.image).into(holder.thumbnail)
        holder.title.text=movie.name
        holder.parentLayout.setOnClickListener {
            movieSelected.onItemSelected(movie.id)
        }
    }

    class Holder : EpoxyHolder() {

        lateinit var title:TextView
        lateinit var thumbnail:ImageView
        lateinit var parentLayout:CardView
        override fun bindView(itemView: View) {
            title=itemView.findViewById(R.id.title)
            thumbnail=itemView.findViewById(R.id.thumbnail)
            parentLayout=itemView.findViewById(R.id.parent_layout)
        }

    }
}

interface MovieSelected{
    fun onItemSelected(id:Int)
}