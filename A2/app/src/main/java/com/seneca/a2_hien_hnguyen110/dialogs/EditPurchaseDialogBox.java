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
    private Purchase purchase;

    public EditPurchaseDialogBox(Purchase purchase) {
        this.purchase = purchase;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        binding = EditPurchaseDialogLayoutBinding.inflate(LayoutInflater.from(getContext()));
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setView(binding.getRoot());
        builder.setNegativeButton("Cancel", (dialogInterface, i) -> {

        });
        builder.setPositiveButton("Update", (dialogInterface, i) -> {
            delegate.updatePurchase(purchase);
        });
        return builder.create();
    }

    public interface EditPurchaseDelegate {
        public void updatePurchase(Purchase purchase);
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
