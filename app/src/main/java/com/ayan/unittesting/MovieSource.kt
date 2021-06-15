package com.ayan.unittesting

interface MovieSource {
    fun getMovies():List<Movie>
    fun getMovie(id:Int):Movie?
}