package com.example.demo.Models;

public class Response {
    private String id;
    private String username;
    private String item;
    private int amount;
    private String city;
    private String state;
    private String country;

    public Response(String id, String username, String item, int amount, String city, String state, String country){
        this.id = id;
        this.username = username;
        this.item = item;
        this.amount = amount;
        this.city = city;
        this.state = state;
        this.country = country;
    }

    public Response(){

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

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
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

    public void setCountry(String country){this.country = country;}

    public String getCountry(){ return this.country; }
}
