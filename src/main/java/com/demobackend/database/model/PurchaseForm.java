package com.demobackend.database.model;

import java.util.List;

public class PurchaseForm {
    private String _id;
    private String status;
    private BillingDetails billing_details;
    private List<PurchaseProduct> products;
    private Double total_bill;
    private String date;
    private String payment_method;

    public PurchaseForm(String _id, String status, BillingDetails billing_details, List<PurchaseProduct> products, Double total_bill, String date, String payment_method) {
        this._id = _id;
        this.status = status;
        this.billing_details = billing_details;
        this.products = products;
        this.total_bill = total_bill;
        this.date = date;
        this.payment_method = payment_method;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public BillingDetails getBilling_details() {
        return billing_details;
    }

    public void setBilling_details(BillingDetails billing_details) {
        this.billing_details = billing_details;
    }

    public List<PurchaseProduct> getProducts() {
        return products;
    }

    public void setProducts(List<PurchaseProduct> products) {
        this.products = products;
    }

    public Double getTotal_bill() {
        return total_bill;
    }

    public void setTotal_bill(Double total_bill) {
        this.total_bill = total_bill;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getPayment_method() {
        return payment_method;
    }

    public void setPayment_method(String payment_method) {
        this.payment_method = payment_method;
    }
}
