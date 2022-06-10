package com.seneca.a1_hien_hnguyen110;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.seneca.a1_hien_hnguyen110.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private final Double morningRate = 0.132;
    private final Double afternoonRate = 0.065;
    private final Double eveningRate = 0.094;
    private final Double taxRate = 0.13;
    private final Double environmentalRebateRate = 0.08;
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        reset(binding);
        setContentView(binding.getRoot());

        binding.calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Double morningUsage = getDoubleValueFromInputField(binding.morningUsageInputField.getText().toString());
                Double afternoonUsage = getDoubleValueFromInputField(binding.afternoonUsageInputField.getText().toString());
                Double eveningUsage = getDoubleValueFromInputField(binding.eveningUsageInputField.getText().toString());
                Double morningCharge = morningUsage * morningRate;
                Double afternoonCharge = afternoonUsage * afternoonRate;
                Double eveningCharge = eveningUsage * eveningRate;
                Double totalCharge = morningCharge + afternoonCharge + eveningCharge;
                Double saleTax = totalCharge * taxRate;
                Double environmentRebate = binding.renewableEnergySwitch.isChecked() ? totalCharge * environmentalRebateRate : 0;
                Double totalRegulatoryCharge = saleTax - environmentRebate;
                Double totalBillAmount = totalCharge + totalRegulatoryCharge;

                binding.morningUsage.setText(String.format("Morning usage charges: $%.2f", morningCharge));
                binding.afternoonUsage.setText(String.format("Afternoon usage charges: $%.2f", afternoonCharge));
                binding.eveningUsage.setText(String.format("Evening usage charges: $%.2f", eveningCharge));
                binding.totalUsage.setText(String.format("Total Usage Charges: $%.2f", totalCharge));
                binding.saleTax.setText(String.format("Sale Tax: $%.2f", saleTax));
                binding.environmentRebate.setText(String.format("Environment Rebate: -$%.2f", environmentRebate));
                binding.totalRegulatoryCharges.setText(String.format("Total Regulatory Charges: $%.2f", totalRegulatoryCharge));
                binding.totalBillAmount.setText(String.format("Total Bill Amount: $%.2f", totalBillAmount));
            }
        });
        binding.resetButton.setOnClickListener(view -> reset(binding));
    }

    private void reset(ActivityMainBinding binding) {
        binding.morningUsageInputField.setText("");
        binding.afternoonUsageInputField.setText("");
        binding.eveningUsageInputField.setText("");
        binding.renewableEnergySwitch.setChecked(false);
        binding.morningUsage.setText("Morning usage charges: $0.00");
        binding.afternoonUsage.setText("Afternoon usage charges: $0.00");
        binding.eveningUsage.setText("Evening usage charges: $0.00");
        binding.totalUsage.setText("Total usage charges: $0.00");
        binding.saleTax.setText("Sales Tax: $0.00");
        binding.environmentRebate.setText("Environment Rebate: $0.00");
        binding.totalRegulatoryCharges.setText("Total Regulatory Charges: $0.00");
        binding.totalBillAmount.setText("Total Bill Amount: $0.00");
    }

    private Double getDoubleValueFromInputField(String value) {
        if (value.isEmpty()) {
            return Double.valueOf(0);
        } else {
            return Double.valueOf(value);
        }
    }
}