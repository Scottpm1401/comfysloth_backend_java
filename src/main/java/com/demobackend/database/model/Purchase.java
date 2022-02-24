package com.demobackend.database.model;

public class Purchase {
    private String _id;
    private String status;
    private Object billing_details;
    private PurchaseProduct[] products;
    private Double total_bill;
    private String date;
    private String payment_method;

    public Purchase(String _id, String status, Object billing_details, PurchaseProduct[] products, Double total_bill, String date, String payment_method) {
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

    public String getStatus() {
        return status;
    }

    public Object getBilling_details() {
        return billing_details;
    }

    public PurchaseProduct[] getProducts() {
        return products;
    }

    public Double getTotal_bill() {
        return total_bill;
    }

    public String getDate() {
        return date;
    }

    public String getPayment_method() {
        return payment_method;
    }
}
