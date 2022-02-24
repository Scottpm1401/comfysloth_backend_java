package com.demobackend.database.model;

public class BillingDetails {
    private String name;
    private String email;
    private String phone;
    private Address address;

    public BillingDetails(String name, String email, String phone, Address address) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public Address getAddress() {
        return address;
    }
}
