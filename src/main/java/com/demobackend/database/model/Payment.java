package com.demobackend.database.model;

import java.util.List;

public class Payment {
    private Long amount;
    private String id;
    private String user_id;
    private List<PurchaseProduct> cart;
    private BillingDetails billing_details;
    private Double total;

    public Payment(Long amount, String id, String user_id, List<PurchaseProduct> cart, BillingDetails billing_details, Double total) {
        this.amount = amount;
        this.id = id;
        this.user_id = user_id;
        this.cart = cart;
        this.billing_details = billing_details;
        this.total = total;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public List<PurchaseProduct> getCart() {
        return cart;
    }

    public void setCart(List<PurchaseProduct> cart) {
        this.cart = cart;
    }

    public BillingDetails getBilling_details() {
        return billing_details;
    }

    public void setBilling_details(BillingDetails billing_details) {
        this.billing_details = billing_details;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }
}
