package com.example.task02;

public class DiscountBill extends Bill {
    private long discount;

    public void setDiscount(long discount) {
        this.discount = discount;
    }



    public DiscountBill(long discount) {
        this.discount = discount;
    }
}
