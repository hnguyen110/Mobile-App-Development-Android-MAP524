package com.seneca.a2_hien_hnguyen110.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.seneca.a2_hien_hnguyen110.R;
import com.seneca.a2_hien_hnguyen110.databinding.PurchaseRowLayoutBinding;
import com.seneca.a2_hien_hnguyen110.models.Purchase;

import java.util.List;

public class PurchaseRowAdapter extends ArrayAdapter {
    private List<Purchase> purchases;

    public PurchaseRowAdapter(@NonNull Context context, List<Purchase> purchases) {
        super(context, 0);
        this.purchases = purchases;
    }

    @Override
    public int getCount() {
        return purchases.size();
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.purchase_row_layout, parent, false);
        }
        Purchase purchase = purchases.get(position);
        PurchaseRowLayoutBinding binding = PurchaseRowLayoutBinding.bind(convertView);
        binding.storeName.setText(purchase.getStoreName());
        binding.purchaseAmount.setText(String.valueOf(purchase.getPurchaseAmount()));
        binding.paidStatus.setText(String.valueOf(purchase.getPaidStatus()));
        return convertView;
    }
}
