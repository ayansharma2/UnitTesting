package com.ayan.unittesting

import android.graphics.Movie
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory

class CustomFragmentFactory(private val movieSource: MovieSource): FragmentFactory() {

    override fun instantiate(classLoader: ClassLoader, className: String): Fragment =
        when(className){
            MoviesListFragment::class.java.name->{
                if(movieSource!=null){
                    MoviesListFragment(movieSource)
                }else{
                    super.instantiate(classLoader, className)
                }
            }
            MovieDetailFragment::class.java.name->{
                if(movieSource!=null){
                    MovieDetailFragment(movieSource)
                }else{
                    super.instantiate(classLoader, className)
                }
            }

            CastDetailfragment::class.java.name->{
                if(movieSource!=null){
                    CastDetailfragment()
                }else{
                    super.instantiate(classLoader, className)
                }
            }
            else ->{
                super.instantiate(classLoader, className)
            }
        }


}