package com.demobackend.database.model;

public class PaymentResponse {
    private String message;
    private Boolean success;
    private String status;
    private PurchaseForm purchaseForm;
    private Number ok;

    public PaymentResponse(String message, Boolean success, String status, PurchaseForm purchaseForm, Number ok) {
        this.message = message;
        this.success = success;
        this.status = status;
        this.purchaseForm = purchaseForm;
        this.ok = ok;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public PurchaseForm getPurchaseForm() {
        return purchaseForm;
    }

    public void setPurchaseForm(PurchaseForm purchaseForm) {
        this.purchaseForm = purchaseForm;
    }

    public Number getOk() {
        return ok;
    }

    public void setOk(Number ok) {
        this.ok = ok;
    }
}
