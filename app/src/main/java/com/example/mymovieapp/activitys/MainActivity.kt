package com.example.mymovieapp.activitys


import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.core.os.bundleOf
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.mymovieapp.R
import com.example.mymovieapp.adapter.PopularMovieAdapter
import com.example.mymovieapp.adapter.BestFromYearAdapter
import com.example.mymovieapp.adapter.FromTurkeyAdapter
import com.example.mymovieapp.adapter.UpComingAdapter
import com.example.mymovieapp.model.*
import com.example.mymovieapp.service.MovieApiInterfaces
import com.example.mymovieapp.service.MovieApiService
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.popular_movie_card.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.fragmentContainerView) as NavHostFragment
        NavigationUI.setupWithNavController(bottomNavigationView, navHostFragment.navController)

    }


}









