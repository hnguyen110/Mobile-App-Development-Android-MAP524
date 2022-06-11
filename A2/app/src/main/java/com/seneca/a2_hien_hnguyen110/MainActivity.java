package com.seneca.a2_hien_hnguyen110;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.seneca.a2_hien_hnguyen110.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    private ArrayList<Purchase> purchases = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.submitButton.setOnClickListener(view -> {
            String storeName = binding.storeName.getText().toString();
            String purchaseAmount = binding.purchaseAmount.getText().toString();
            boolean paidStatus = binding.paidStatus.isChecked();
            if (storeName.isEmpty()) {
                binding.errorMessage.setVisibility(View.VISIBLE);
                binding.errorMessage.setText(R.string.store_name_required_message);
            } else if (purchaseAmount.isEmpty()) {
                binding.errorMessage.setVisibility(View.VISIBLE);
                binding.errorMessage.setText(R.string.purchase_amount_required_message);
            } else {
                binding.errorMessage.setVisibility(View.GONE);
                binding.errorMessage.setText("");
                Purchase purchase = new Purchase(storeName, Double.valueOf(purchaseAmount), paidStatus);
                purchases.add(purchase);
            }
        });

        binding.loadDataButton.setOnClickListener(view -> {
            purchases.add(new Purchase("The Beer Store", 50.5, true));
            purchases.add(new Purchase("No Frills", 80.5, true));
            purchases.add(new Purchase("Shoppers Drug Mart", 50.35, true));
            purchases.add(new Purchase("Seneca College", 7000.75, false));
            purchases.add(new Purchase("Starbucks", 10.64, true));
        });
    }
}

// Testing PR