package com.seneca.movies_hien_hnguyen110.fragments;

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

    public TicketsFragment() {
        super(R.layout.tickets_fragment);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Database database = Database.getDatabase(getContext());
        ArrayList<Purchase> purchases = (ArrayList<Purchase>) database.purchaseDAO().getPurchases();
        binding = TicketsFragmentBinding.inflate(inflater, container, false);
        TicketRowAdapter adapter = new TicketRowAdapter(getContext(), this, purchases);
        binding.purchases.setLayoutManager(new LinearLayoutManager(getContext()));
        binding.purchases.addItemDecoration(new DividerItemDecoration(requireContext(), DividerItemDecoration.VERTICAL));
        binding.purchases.setAdapter(adapter);
        return binding.getRoot();
    }

    @Override
    public void onClick(Purchase purchase) {
        Snackbar snackbar = Snackbar.make(binding.getRoot(), "Ticket Purchased", Snackbar.LENGTH_SHORT);
        snackbar.show();
    }
}