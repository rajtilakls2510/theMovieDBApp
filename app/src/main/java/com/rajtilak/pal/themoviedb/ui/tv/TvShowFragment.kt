package com.rajtilak.pal.themoviedb.ui.tv

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.rajtilak.pal.themoviedb.R
import com.rajtilak.pal.themoviedb.databinding.FragmentTvShowBinding


class TvShowFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<FragmentTvShowBinding>(inflater, R.layout.fragment_tv_show, container, false)
        return binding.root
    }


}