package com.seneca.a2_hien_hnguyen110.dialogs;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import com.seneca.a2_hien_hnguyen110.databinding.EditPurchaseDialogLayoutBinding;
import com.seneca.a2_hien_hnguyen110.models.Purchase;

public class EditPurchaseDialogBox extends DialogFragment {
    private EditPurchaseDelegate delegate;
    private EditPurchaseDialogLayoutBinding binding;
    private int index;
    private Purchase purchase;

    public EditPurchaseDialogBox(int index, Purchase purchase) {
        this.index = index;
        this.purchase = purchase;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        binding = EditPurchaseDialogLayoutBinding.inflate(LayoutInflater.from(getContext()));
        binding.storeName.setText(purchase.getStoreName());
        binding.purchaseAmount.setText(String.valueOf(purchase.getPurchaseAmount()));
        binding.paidStatus.setChecked(purchase.getPaidStatus());
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setView(binding.getRoot());
        builder.setNegativeButton("Cancel", (dialogInterface, i) -> {
        });
        builder.setPositiveButton("Update", (dialogInterface, i) -> {
            String storeName = binding.storeName.getText().toString();
            String purchaseAmount = binding.purchaseAmount.getText().toString();
            boolean paidStatus = binding.paidStatus.isChecked();
            delegate.updatePurchase(index, storeName, purchaseAmount, paidStatus);
        });
        return builder.create();
    }

    public interface EditPurchaseDelegate {
        void updatePurchase(int index, String storeName, String purchaseAmount, boolean paidStatus);
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        try {
            delegate = (EditPurchaseDelegate) context;
        } catch (Exception exception) {
            throw new ClassCastException("The delegate method to update the purchase is not implemented");
        }
    }
}
