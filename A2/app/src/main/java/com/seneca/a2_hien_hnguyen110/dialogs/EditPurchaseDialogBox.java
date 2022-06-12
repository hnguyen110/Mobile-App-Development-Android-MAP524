package com.seneca.a2_hien_hnguyen110.dialogs;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import com.seneca.a2_hien_hnguyen110.databinding.EditPurchaseDialogLayoutBinding;

public class EditPurchaseDialogBox extends DialogFragment {
    EditPurchaseDialogLayoutBinding binding;

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        binding = EditPurchaseDialogLayoutBinding.inflate(LayoutInflater.from(getContext()));
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setView(binding.getRoot());
        builder.setNegativeButton("Cancel", (dialogInterface, i) -> {

        });
        builder.setPositiveButton("Update", (dialogInterface, i) -> {

        });
        return builder.create();
    }
}
