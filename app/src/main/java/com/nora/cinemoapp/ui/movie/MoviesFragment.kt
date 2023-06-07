package com.nora.cinemoapp.ui.movie

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.doOnTextChanged
import androidx.fragment.app.Fragment
import androidx.navigation.NavDirections
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.nora.cinemoapp.databinding.FragmentMoviesBinding
import com.nora.cinemoapp.domain.model.Movie
import com.nora.cinemoapp.ui.MoviesAdapter
import com.nora.cinemoapp.ui.MoviesListener
import okhttp3.internal.notifyAll
import org.koin.androidx.viewmodel.ext.android.viewModel

class MoviesFragment : Fragment(), MoviesListener {

    private val binding: FragmentMoviesBinding by lazy {
        FragmentMoviesBinding.inflate(layoutInflater)
    }

    private val viewModel: MoviesViewModel by viewModel()
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
        val directions = MoviesFragmentDirections.actionMoviesFragmentToMovieDetailFragment(movie)
        navigateToDirection(directions)
    }

    private fun initView() {
        binding.rvMovieList.apply {
            layoutManager = LinearLayoutManager(requireContext(), RecyclerView.VERTICAL, false)
            adapter = moviesAdapter
        }

        binding.ibtnFavorite.setOnClickListener {
            navigateToDirection(MoviesFragmentDirections.actionMoviesFragmentToMyFavoriteFragment())
        }

        binding.swipeMovie.setOnRefreshListener {
            viewModel.getRefreshData()
        }
    }

    private fun observeViewModel() {
        viewModel.movieList.observe(viewLifecycleOwner) {
            submitMovieListData(it.movies)
            initFilterText(it.movies)
        }
    }

    private fun submitMovieListData(movies: List<Movie>) {
        moviesAdapter.submitList(movies)
        disableRefreshing()
    }

    private fun initFilterText(movies: List<Movie>) {
        binding.edtMovieSearch.doOnTextChanged { text, _, _, _ ->
            if (text.isNullOrEmpty()) {
                submitMovieListData(movies)
            } else {
                submitMovieListData(
                    movies.filter {
                        it.titleEn.startsWith(text, true) ||
                        it.titleTh.startsWith(text, true)
                    }
                )
            }
        }
    }

    private fun navigateToDirection(directions: NavDirections) {
        findNavController().navigate(directions)
    }

    private fun disableRefreshing() {
        binding.swipeMovie.isRefreshing = false
    }
}