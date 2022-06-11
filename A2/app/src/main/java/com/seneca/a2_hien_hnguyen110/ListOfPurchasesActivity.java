package com.seneca.a2_hien_hnguyen110;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.seneca.a2_hien_hnguyen110.databinding.ActivityMainBinding;
import com.seneca.a2_hien_hnguyen110.models.Purchase;

import java.io.Serializable;
import java.util.ArrayList;

public class ListOfPurchasesActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_of_purchases);

        Intent intent = getIntent();
        if (intent != null) {
            Serializable serializablePurchases = intent.getSerializableExtra("EXTRA_PURCHASES");
            ArrayList<Purchase> purchases = (ArrayList<Purchase>) serializablePurchases;
        }
    }
}