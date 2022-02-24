package com.demobackend.database.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "products")
public class Product {
    @Id
    private String id;

    private String img;
    private List<String> gallery;
    private String title;
    private Double stars;
    private Integer review;
    private String category;
    private Double price;

    private String description;
    private Boolean available;
    private String sku;
    private String brand;
    private List<String> colors;
    private Boolean freeship;
    private Integer __v;

    public Product(String id, String img, List<String> gallery, String title, Double stars, Integer review, String category, Double price, String description, Boolean available, String sku, String brand, List<String> colors, Boolean freeship, Integer __v) {
        this.id = id;
        this.img = img;
        this.gallery = gallery;
        this.title = title;
        this.stars = stars;
        this.review = review;
        this.category = category;
        this.price = price;
        this.description = description;
        this.available = available;
        this.sku = sku;
        this.brand = brand;
        this.colors = colors;
        this.freeship = freeship;
        this.__v = __v;
    }

    public String getId() {
        return id;
    }

    public String getImg() {
        return img;
    }

    public List<String> getGallery() {
        return gallery;
    }

    public String getTitle() {
        return title;
    }

    public Double getStars() {
        return stars;
    }

    public Integer getReview() {
        return review;
    }

    public String getCategory() {
        return category;
    }

    public Double getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }

    public Boolean getAvailable() {
        return available;
    }

    public String getSku() {
        return sku;
    }

    public String getBrand() {
        return brand;
    }

    public List<String> getColors() {
        return colors;
    }

    public Boolean getFreeship() {
        return freeship;
    }

    public Integer get__v() {
        return __v;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public void setGallery(List<String> gallery) {
        this.gallery = gallery;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setStars(Double stars) {
        this.stars = stars;
    }

    public void setReview(Integer review) {
        this.review = review;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setAvailable(Boolean available) {
        this.available = available;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setColors(List<String> colors) {
        this.colors = colors;
    }

    public void setFreeship(Boolean freeship) {
        this.freeship = freeship;
    }

    public void set__v(Integer __v) {
        this.__v = __v;
    }
}