package com.seneca.movies_hien_hnguyen110.adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.seneca.movies_hien_hnguyen110.databinding.MovieRowBinding;
import com.seneca.movies_hien_hnguyen110.models.Movie;

import java.util.ArrayList;

public class MovieRowAdapter extends RecyclerView.Adapter<MovieRowAdapter.ItemViewHolder> {
    private final Context context;
    private final ArrayList<Movie> movies;
    MovieRowBinding binding;

    public MovieRowAdapter(Context context, ArrayList<Movie> items) {
        this.movies = items;
        this.context = context;
    }

    @SuppressLint("NotifyDataSetChanged")
    public void resetDataSet(ArrayList<Movie> items) {
        movies.clear();
        movies.addAll(items);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ItemViewHolder(MovieRowBinding.inflate(LayoutInflater.from(context), parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {
        Movie currentItem = movies.get(position);
        holder.bind(context, currentItem);
    }

    @Override
    public int getItemCount() {
        return this.movies.size();
    }

    public static class ItemViewHolder extends RecyclerView.ViewHolder {
        MovieRowBinding itemBinding;

        public ItemViewHolder(MovieRowBinding binding) {
            super(binding.getRoot());
            this.itemBinding = binding;
        }

        @SuppressLint("DefaultLocale")
        public void bind(Context context, Movie currentItem) {
            Glide
                    .with(context)
                    .load(String.format("https://image.tmdb.org/t/p/w500%s", currentItem.getBackdropPath()))
                    .into(itemBinding.image);
            itemBinding.title.setText(currentItem.getTitle());
            itemBinding.rating.setText(String.format("%s%%", String.format("%f", currentItem.getVoteAverage())));
            itemBinding.releaseDate.setText(String.format("Released: %s", currentItem.getReleaseDate()));
            itemBinding.overview.setText(currentItem.getOverview());
        }
    }
}
