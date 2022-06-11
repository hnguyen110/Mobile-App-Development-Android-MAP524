package com.seneca.a2_hien_hnguyen110;

public class Purchase {
    private String storeName;
    private String purchaseAmount;
    private String paidStatus;

    public Purchase(String storeName, String purchaseAmount, String paidStatus) {
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

    public String getPurchaseAmount() {
        return purchaseAmount;
    }

    public void setPurchaseAmount(String purchaseAmount) {
        this.purchaseAmount = purchaseAmount;
    }

    public String getPaidStatus() {
        return paidStatus;
    }

    public void setPaidStatus(String paidStatus) {
        this.paidStatus = paidStatus;
    }
}
