package com.demobackend.database.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "users")
public class User {
    @Id
    private String id;

    private String username;
    private String img;
    private String address;
    private String sex;
    private String payment;
    private List<PurchaseProduct> cart;
    private Double cart_total;
    private String phone;

    private Boolean admin;
    private String name;
    private String email;
    private String password;
    private List<Purchase> purchase;
    private String city;
    private String state;
    private Integer __v;

    public User(String id,String username, String img, String address, String sex, String payment, List<PurchaseProduct> cart, Double cart_total, String phone, Boolean admin, String name, String email, String password, List<Purchase> purchase, String city, String state, Integer __v) {
        this.id = id;
        this.username = username;
        this.img = img;
        this.address = address;
        this.sex = sex;
        this.payment = payment;
        this.cart = cart;
        this.cart_total = cart_total;
        this.phone = phone;
        this.admin = admin;
        this.name = name;
        this.email = email;
        this.password = password;
        this.purchase = purchase;
        this.city = city;
        this.state = state;
        this.__v = __v;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getPayment() {
        return payment;
    }

    public void setPayment(String payment) {
        this.payment = payment;
    }

    public List<PurchaseProduct> getCart() {
        return cart;
    }

    public void setCart(List<PurchaseProduct> cart) {
        this.cart = cart;
    }

    public Double getCart_total() {
        return cart_total;
    }

    public void setCart_total(Double cart_total) {
        this.cart_total = cart_total;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Boolean getAdmin() {
        return admin;
    }

    public void setAdmin(Boolean admin) {
        this.admin = admin;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Purchase> getPurchase() {
        return purchase;
    }

    public void setPurchase(List<Purchase> purchase) {
        this.purchase = purchase;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Integer get__v() {
        return __v;
    }

    public void set__v(Integer __v) {
        this.__v = __v;
    }
}
