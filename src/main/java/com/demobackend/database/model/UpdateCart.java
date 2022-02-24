package com.demobackend.database.model;

public class UpdateCart {
    private String _id;
    private String color;
    private Double prices;

    public UpdateCart(String _id, String color, Double prices) {
        this._id = _id;
        this.color = color;
        this.prices = prices;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Double getPrices() {
        return prices;
    }

    public void setPrices(Double prices) {
        this.prices = prices;
    }
}
