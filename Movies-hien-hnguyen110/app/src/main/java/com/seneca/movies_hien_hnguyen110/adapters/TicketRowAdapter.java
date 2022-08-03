package com.seneca.movies_hien_hnguyen110.adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.seneca.movies_hien_hnguyen110.databinding.TicketRowBinding;
import com.seneca.movies_hien_hnguyen110.listeners.TicketRowEventListener;
import com.seneca.movies_hien_hnguyen110.models.Purchase;

import java.util.ArrayList;

public class TicketRowAdapter extends RecyclerView.Adapter<TicketRowAdapter.ItemViewHolder> {
    private final Context context;
    private final TicketRowEventListener listener;
    private final ArrayList<Purchase> purchases;

    public TicketRowAdapter(Context context, TicketRowEventListener listener, ArrayList<Purchase> items) {
        this.purchases = items;
        this.context = context;
        this.listener = listener;
    }

    @NonNull
    @Override
    public TicketRowAdapter.ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new TicketRowAdapter.ItemViewHolder(TicketRowBinding.inflate(LayoutInflater.from(context), parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull TicketRowAdapter.ItemViewHolder holder, int position) {
        Purchase currentItem = purchases.get(position);
        holder.bind(context, currentItem, listener);
    }

    @Override
    public int getItemCount() {
        return this.purchases.size();
    }

    public static class ItemViewHolder extends RecyclerView.ViewHolder {
        TicketRowBinding itemBinding;

        public ItemViewHolder(TicketRowBinding binding) {
            super(binding.getRoot());
            this.itemBinding = binding;
        }

        @SuppressLint("DefaultLocale")
        public void bind(Context context, Purchase currentItem, TicketRowEventListener listener) {
            itemBinding.title.setText(currentItem.getTitle());
            itemBinding.quantity.setText(String.format("Tickets Purchased: %d", currentItem.getQuantity()));
            itemBinding.getRoot().setOnClickListener(view -> {
                listener.onClick(currentItem);
            });
        }
    }
}
