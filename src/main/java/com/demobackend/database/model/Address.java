package com.demobackend.database.model;

public class Address {
    private String line1;
    private String city;
    private String state;

    public Address(String line1, String city, String state) {
        this.line1 = line1;
        this.city = city;
        this.state = state;
    }

    public String getLine1() {
        return line1;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }
}
