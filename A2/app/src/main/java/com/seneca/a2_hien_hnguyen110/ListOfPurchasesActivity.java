package com.seneca.a2_hien_hnguyen110;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.seneca.a2_hien_hnguyen110.adapters.PurchaseRowAdapter;
import com.seneca.a2_hien_hnguyen110.databinding.ActivityListOfPurchasesBinding;
import com.seneca.a2_hien_hnguyen110.models.Purchase;

import java.io.Serializable;
import java.util.ArrayList;

public class ListOfPurchasesActivity extends AppCompatActivity {
    private ActivityListOfPurchasesBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityListOfPurchasesBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Intent intent = getIntent();
        if (intent != null) {
            Serializable serializablePurchases = intent.getSerializableExtra("EXTRA_PURCHASES");
            ArrayList<Purchase> purchases = (ArrayList<Purchase>) serializablePurchases;
            PurchaseRowAdapter adapter = new PurchaseRowAdapter(this, purchases);
            binding.listOfPurchases.setAdapter(adapter);
            binding.listOfPurchases.setOnItemClickListener((adapterView, view, i, l) -> {
            });
        }
    }
}