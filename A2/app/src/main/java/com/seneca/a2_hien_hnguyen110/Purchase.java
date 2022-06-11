package com.seneca.a2_hien_hnguyen110;

import androidx.annotation.NonNull;

public class Purchase {
    private String storeName;
    private Double purchaseAmount;
    private boolean paidStatus;

    public Purchase(String storeName, Double purchaseAmount, boolean paidStatus) {
        this.storeName = storeName;
        this.purchaseAmount = purchaseAmount;
        this.paidStatus = paidStatus;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public Double getPurchaseAmount() {
        return purchaseAmount;
    }

    public void setPurchaseAmount(Double purchaseAmount) {
        this.purchaseAmount = purchaseAmount;
    }

    public boolean getPaidStatus() {
        return paidStatus;
    }

    public void setPaidStatus(boolean paidStatus) {
        this.paidStatus = paidStatus;
    }

    @NonNull
    @Override
    public String toString() {
        return "Purchase{" +
                "storeName='" + storeName + '\'' +
                ", purchaseAmount=" + purchaseAmount +
                ", paidStatus=" + paidStatus +
                '}';
    }
}
