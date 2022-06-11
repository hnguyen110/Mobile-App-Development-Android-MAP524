package com.seneca.a2_hien_hnguyen110;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.seneca.a2_hien_hnguyen110.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;

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
            }
        });
    }
}