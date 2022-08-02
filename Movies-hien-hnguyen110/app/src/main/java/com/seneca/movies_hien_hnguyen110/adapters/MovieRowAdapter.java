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
            Glide.with(context).load(currentItem.getPoster_path()).into(itemBinding.image);
//            itemBinding.title.setText(currentItem.getTitle());
//            itemBinding.rating.setText(currentItem.getVote_average());
//            String name = currentItem.getName();
//            itemBinding.name.setText(String.format("%s%s", name.substring(0, 1).toUpperCase(), name.substring(1)));
//            itemBinding.description.setText(currentItem.getDescription());
//            itemBinding.attack.setText(String.format("Attack: %d", currentItem.getAttack()));
//            itemBinding.defense.setText(String.format("Defense: %d", currentItem.getDefense()));
        }
    }
}
