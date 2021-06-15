package com.ayan.unittesting

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import com.bumptech.glide.request.RequestOptions

class MainActivity : AppCompatActivity() {


    lateinit var movieSource:MovieSource
    override fun onCreate(savedInstanceState: Bundle?) {
        initDependencies()
        super.onCreate(savedInstanceState)
        supportFragmentManager.fragmentFactory = CustomFragmentFactory(
            movieSource
        )
        setContentView(R.layout.activity_main)
        initialise()
    }

    private fun initialise() {
        if(supportFragmentManager.fragments.size == 0){
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, MoviesListFragment::class.java, null)
                .commit()
        }
    }

    private fun initDependencies(){

        if(!::movieSource.isInitialized){
            // Data Source
            movieSource=MovieRemoteDataSource()
        }
    }
}