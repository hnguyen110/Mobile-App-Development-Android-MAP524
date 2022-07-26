package com.seneca.a3_hien_hnguyen110.adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.seneca.a3_hien_hnguyen110.databinding.EquipmentRowBinding;
import com.seneca.a3_hien_hnguyen110.models.Equipment;

import java.util.ArrayList;

public class EquipmentAdapter extends RecyclerView.Adapter<EquipmentAdapter.ItemViewHolder> {

    private final Context context;
    private final ArrayList<Equipment> itemArrayList;
    EquipmentRowBinding binding;

    public EquipmentAdapter(Context context, ArrayList<Equipment> items) {
        this.itemArrayList = items;
        this.context = context;
    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ItemViewHolder(EquipmentRowBinding.inflate(LayoutInflater.from(context), parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {
        Equipment currentItem = itemArrayList.get(position);
        holder.bind(context, currentItem);
    }

    @Override
    public int getItemCount() {
        return this.itemArrayList.size();
    }

    public static class ItemViewHolder extends RecyclerView.ViewHolder {
        EquipmentRowBinding itemBinding;

        public ItemViewHolder(EquipmentRowBinding binding) {
            super(binding.getRoot());
            this.itemBinding = binding;
        }

        @SuppressLint("DefaultLocale")
        public void bind(Context context, Equipment currentItem) {
            Glide.with(context).load(currentItem.getImage()).into(itemBinding.equipmentImage);
            String name = currentItem.getName();
            itemBinding.name.setText(String.format("%s%s", name.substring(0, 1).toUpperCase(), name.substring(1)));
            itemBinding.description.setText(currentItem.getDescription());
            itemBinding.attack.setText(String.format("Attack: %d", currentItem.getAttack()));
            itemBinding.defense.setText(String.format("Defense: %d", currentItem.getDefense()));
        }
    }
}