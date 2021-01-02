package com.rajtilak.pal.themoviedb.ui.movie

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.rajtilak.pal.themoviedb.R
import com.rajtilak.pal.themoviedb.databinding.FragmentMovieBinding

class MovieFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding= DataBindingUtil.inflate<FragmentMovieBinding>(inflater,R.layout.fragment_movie ,container, false)
        val activity = requireNotNull(this.activity) {
            "You can only access the viewModel after onActivityCreated()"
        }
        val factory = MovieFragmentViewModel.Factory(activity.application)
        val viewModel = ViewModelProvider(this, factory).get(MovieFragmentViewModel::class.java)
        binding.lifecycleOwner = this
        binding.viewModel = viewModel

        binding.upcomingMoviesRecyclerView.adapter = UpcomingMoviesAdapter()

        return binding.root
    }


}