package com.ayan.unittesting

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.airbnb.epoxy.EpoxyRecyclerView
import com.ayan.unittesting.Adapter.MovieListAdapter
import com.ayan.unittesting.EpoxyModels.MovieListModel
import com.ayan.unittesting.EpoxyModels.MovieSelected

private const val ARG_PARAM1 = "param1"


class MoviesListFragment(
        val movieSource: MovieSource
) : Fragment(),MovieSelected {

    private var param1: String? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
        }
    }
    lateinit var recyclerView:EpoxyRecyclerView
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        activity?.title="Movies"
        val view= inflater.inflate(R.layout.fragment_movies_list, container, false)
        val movies=movieSource.getMovies()
        val movieAdapter=MovieListAdapter(requireContext(),movies,this)
        recyclerView=view.findViewById(R.id.recycler_view)
        recyclerView.apply {
             adapter=movieAdapter
        }
        return view;
    }

    override fun onItemSelected(id: Int) {
        activity?.run {
            val bundle=Bundle()
            bundle.putInt("movie_id",id)
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container,MovieDetailFragment::class.java,bundle)
                .addToBackStack("MovieDetailFragment")
                .commit()
        }
    }


}