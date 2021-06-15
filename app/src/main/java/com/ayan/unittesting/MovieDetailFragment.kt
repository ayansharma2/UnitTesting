package com.ayan.unittesting

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.fragment_movie_detail.*

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"



class MovieDetailFragment(private val movieSource: MovieSource) : Fragment() {

    private lateinit var movie: Movie

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let { it ->
            it.getInt("movie_id").let {
                    movieSource.getMovie(it)?.let { it ->
                        movie=it
                    }
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        activity?.title="Movie Details"
        return inflater.inflate(R.layout.fragment_movie_detail, container, false);
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        setMovieDetails()
        cast_card_view.setOnClickListener {
            val bundle = Bundle()
            bundle.putStringArrayList("args_cast", movie.actors)
            activity?.supportFragmentManager?.beginTransaction()
                ?.replace(R.id.fragment_container, CastDetailfragment::class.java, bundle)
                ?.addToBackStack("CastDetailfragment")
                ?.commit()
        }
    }

    private fun setMovieDetails() {
        Glide.with(this@MovieDetailFragment)
            .load(movie.image)
            .into(thumbnail)
        title.text=movie.name
        description.text=movie.description
    }


}