package com.nora.cinemoapp.ui.favorite

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.doOnTextChanged
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.nora.cinemoapp.R
import com.nora.cinemoapp.databinding.FragmentMyFavoriteBinding
import com.nora.cinemoapp.domain.model.Movie
import com.nora.cinemoapp.domain.model.MovieList
import com.nora.cinemoapp.ui.MoviesAdapter
import com.nora.cinemoapp.ui.MoviesListener
import com.nora.cinemoapp.ui.movie.MoviesFragmentDirections
import org.koin.androidx.viewmodel.ext.android.viewModel

class MyFavoriteFragment : Fragment(), MoviesListener {

    private val binding: FragmentMyFavoriteBinding by lazy {
        FragmentMyFavoriteBinding.inflate(layoutInflater)
    }

    private val viewModel: MyFavoriteViewModel by viewModel()
    private val moviesAdapter = MoviesAdapter(this)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
        observeViewModel()
    }

    override fun onItemClicked(view: View, movie: Movie) {
        val directions = MyFavoriteFragmentDirections.actionMyFavoriteFragmentToMovieDetailFragment(movie)
        findNavController().navigate(directions)
    }

    private fun initView() {
        binding.rvFavList.apply {
            layoutManager = LinearLayoutManager(requireContext(), RecyclerView.VERTICAL, false)
            adapter = moviesAdapter
        }

        binding.swipeMovieFav.setOnRefreshListener {
            viewModel.refreshData()
        }
    }

    private fun observeViewModel() {
        viewModel.favoriteList.observe(viewLifecycleOwner) {
            submitMyFavoriteList(movie = it.movies)
            initFilterText(it.movies)
        }
    }

    private fun submitMyFavoriteList(movie: List<Movie>) {
        moviesAdapter.submitList(movie)
        disableRefreshing()
    }

    private fun initFilterText(movies: List<Movie>) {
        binding.edtMyFavorite.doOnTextChanged { text, _, _, _ ->
            if (text.isNullOrEmpty()) {
                submitMyFavoriteList(movies)
            } else {
                submitMyFavoriteList(
                    movies.filter {
                        it.titleEn.startsWith(text, true) ||
                        it.titleTh.startsWith(text, true)
                    }
                )
            }
        }
    }

    private fun disableRefreshing() {
        binding.swipeMovieFav.isRefreshing = false
    }
}
