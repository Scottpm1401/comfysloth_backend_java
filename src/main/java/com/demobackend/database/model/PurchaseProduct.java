package com.demobackend.database.model;

public class PurchaseProduct {
    private String _id;
    private String img;
    private String title;
    private Double price;
    private String color;
    private Integer quantity;

    public String get_id() {
        return _id;
    }

    public String getImg() {
        return img;
    }

    public String getTitle() {
        return title;
    }

    public Double getPrice() {
        return price;
    }

    public String getColor() {
        return color;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public PurchaseProduct(String _id, String img, String title, Double price, String color, Integer quantity) {
        this._id = _id;
        this.img = img;
        this.title = title;
        this.price = price;
        this.color = color;
        this.quantity = quantity;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
