package com.demobackend.database.model;

public class UpdateCart {
    private String id;
    private String color;
    private Double prices;

    public UpdateCart(String id, String color, Double prices) {
        this.id = id;
        this.color = color;
        this.prices = prices;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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
