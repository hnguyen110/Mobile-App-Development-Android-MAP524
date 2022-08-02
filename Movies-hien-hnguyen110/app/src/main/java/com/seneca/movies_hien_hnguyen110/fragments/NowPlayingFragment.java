package com.seneca.movies_hien_hnguyen110.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.seneca.movies_hien_hnguyen110.R;
import com.seneca.movies_hien_hnguyen110.adapters.MovieRowAdapter;
import com.seneca.movies_hien_hnguyen110.databinding.NowPlayingFragmentBinding;
import com.seneca.movies_hien_hnguyen110.models.Movie;
import com.seneca.movies_hien_hnguyen110.view_models.MovieViewModel;

import java.util.ArrayList;

public class NowPlayingFragment extends Fragment {
    private final ArrayList<Movie> movies = new ArrayList<>();
    private MovieRowAdapter movieRowAdapter;

    public NowPlayingFragment() {
        super(R.layout.now_playing_fragment);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        NowPlayingFragmentBinding binding = NowPlayingFragmentBinding.inflate(inflater, container, false);
        movieRowAdapter = new MovieRowAdapter(getContext(), movies);
        binding.movies.setLayoutManager(new LinearLayoutManager(getContext()));
        binding.movies.addItemDecoration(new DividerItemDecoration(requireContext(), DividerItemDecoration.VERTICAL));
        binding.movies.setAdapter(movieRowAdapter);
        MovieViewModel model = new ViewModelProvider(this).get(MovieViewModel.class);
        model.getMovies().observe(getViewLifecycleOwner(), data -> {
            movieRowAdapter.resetDataSet(data);
        });
        return binding.getRoot();
    }
}