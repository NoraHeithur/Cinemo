package com.nora.cinemoapp.ui.detail

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.core.view.isGone
import androidx.core.view.isVisible
import androidx.navigation.fragment.navArgs
import coil.load
import com.nora.cinemoapp.R
import com.nora.cinemoapp.databinding.FragmentMovieDetailBinding
import org.koin.androidx.viewmodel.ext.android.viewModel
import java.util.Locale

class MovieDetailFragment : Fragment() {

    private val binding: FragmentMovieDetailBinding by lazy {
        FragmentMovieDetailBinding.inflate(layoutInflater)
    }

    private val args: MovieDetailFragmentArgs by navArgs()

    private val viewModel: MovieDetailViewModel by viewModel()

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

    private fun initView() {
        binding.sivMoviePosterDetail.load(args.movie.posterUrl)
        binding.tvMovieGenreDetail.text = args.movie.genre

        if (Locale.getDefault() == Locale("th")) {
            binding.tvMovieName.text = args.movie.titleTh
            binding.tvMovieDetail.text = args.movie.synopsisTh
        } else {
            binding.tvMovieName.text = args.movie.titleEn
            binding.tvMovieDetail.text = args.movie.synopsisEn
        }

        viewModel.initIsFavorite(args.movie.favorite)

        binding.btnAddFavorite.setOnClickListener {
            viewModel.addFavoriteMovie(args.movie)
            displayToast(getString(R.string.label_add_movie_to_favorite))
        }

        binding.btnRemoveFavorite.setOnClickListener {
            viewModel.removeFromFavorite(args.movie.id)
            displayToast(getString(R.string.label_remove_movie_from_favorite))
        }
    }

    private fun observeViewModel() {
        viewModel.addToFavorite.observe(viewLifecycleOwner) {
            handleMovieIsAddToFavorite(it)
            handleButtonFavoriteState(it)
        }
    }

    private fun handleMovieIsAddToFavorite(isFavorite: Boolean) {
        binding.btnAddFavorite.isEnabled = !isFavorite
    }

    private fun handleButtonFavoriteState(isFavorite: Boolean) {
        if (isFavorite) {
            binding.btnAddFavorite.isGone = true
            binding.btnRemoveFavorite.isVisible = true
        } else {
            binding.btnAddFavorite.isVisible = true
            binding.btnRemoveFavorite.isGone = true
        }
    }

    private fun displayToast(string: String) {
        Toast.makeText(requireContext(), string, Toast.LENGTH_SHORT).show()
    }
}