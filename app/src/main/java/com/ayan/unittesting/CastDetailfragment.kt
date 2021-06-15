package com.ayan.unittesting

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_cast_detailfragment.*
import java.lang.StringBuilder


class CastDetailfragment : Fragment() {
    private var cast: ArrayList<String>? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            cast = it.getStringArrayList("args_cast")

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        activity?.title="Cast Details"
        return inflater.inflate(R.layout.fragment_cast_detailfragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val castString:String=arrayToString(cast)
       cast_text_view.text=castString
    }

   companion object{
       fun arrayToString(cast: java.util.ArrayList<String>?): String {
           var result=StringBuilder()
           cast?.forEach {
               result.append(it+"\n")
           }
           return result.toString()
       }
   }


}