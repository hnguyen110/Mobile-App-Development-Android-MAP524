package com.seneca.a2_hien_hnguyen110;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.seneca.a2_hien_hnguyen110.databinding.ActivityMainBinding;
import com.seneca.a2_hien_hnguyen110.models.Purchase;

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
                binding.storeName.setText("");
                binding.purchaseAmount.setText("");
                binding.paidStatus.setChecked(false);
                Purchase purchase = new Purchase(storeName, Double.valueOf(purchaseAmount), paidStatus);
                purchases.add(purchase);
                Toast.makeText(getApplicationContext(), R.string.purchase_record_created_successfully_message, Toast.LENGTH_SHORT).show();
            }
        });

        binding.loadDataButton.setOnClickListener(view -> {
            purchases.add(new Purchase("The Beer Store", 50.5, true));
            purchases.add(new Purchase("No Frills", 80.5, true));
            purchases.add(new Purchase("Shoppers Drug Mart", 50.35, true));
            purchases.add(new Purchase("Seneca College", 7000.75, false));
            purchases.add(new Purchase("Starbucks", 10.64, true));
            Toast.makeText(getApplicationContext(), R.string.purchase_records_populated_successfully_message, Toast.LENGTH_SHORT).show();
        });

        binding.showPurchasesButton.setOnClickListener(view -> {
            Intent intent = new Intent(getApplicationContext(), ListOfPurchasesActivity.class);
            intent.putExtra("EXTRA_PURCHASES", purchases);
            startActivity(intent);
        });
    }
}