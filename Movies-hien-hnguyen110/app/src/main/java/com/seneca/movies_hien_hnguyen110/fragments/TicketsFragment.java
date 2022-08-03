package com.seneca.movies_hien_hnguyen110.fragments;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.google.android.material.snackbar.Snackbar;
import com.seneca.movies_hien_hnguyen110.R;
import com.seneca.movies_hien_hnguyen110.adapters.TicketRowAdapter;
import com.seneca.movies_hien_hnguyen110.database.Database;
import com.seneca.movies_hien_hnguyen110.databinding.TicketsFragmentBinding;
import com.seneca.movies_hien_hnguyen110.listeners.TicketRowEventListener;
import com.seneca.movies_hien_hnguyen110.models.Purchase;

import java.util.ArrayList;

public class TicketsFragment extends Fragment implements TicketRowEventListener {
    TicketsFragmentBinding binding;
    TicketRowAdapter adapter;
    Database database;
    ArrayList<Purchase> purchases = new ArrayList<>();

    public TicketsFragment() {
        super(R.layout.tickets_fragment);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        database = Database.getDatabase(getContext());
        purchases.addAll(database.purchaseDAO().getPurchases());
        binding = TicketsFragmentBinding.inflate(inflater, container, false);
        adapter = new TicketRowAdapter(getContext(), this, purchases);
        binding.purchases.setLayoutManager(new LinearLayoutManager(getContext()));
        binding.purchases.addItemDecoration(new DividerItemDecoration(requireContext(), DividerItemDecoration.VERTICAL));
        binding.purchases.setAdapter(adapter);
        showEmptyMessageIfDatasetIsNull();
        return binding.getRoot();
    }

    @SuppressLint("NotifyDataSetChanged")
    @Override
    public void onClick(Purchase purchase) {
        database.purchaseDAO().deletePurchase(purchase);
        purchases.remove(purchase);
        adapter.notifyDataSetChanged();
        showEmptyMessageIfDatasetIsNull();
        Snackbar snackbar = Snackbar.make(binding.getRoot(), "Ticket Deleted", Snackbar.LENGTH_SHORT);
        snackbar.show();
    }

    private void showEmptyMessageIfDatasetIsNull() {
        if (this.purchases.isEmpty()) {
            this.binding.purchases.setVisibility(View.GONE);
            this.binding.emptyMessage.setVisibility(View.VISIBLE);
        }
    }
}