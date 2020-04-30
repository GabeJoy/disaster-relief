package com.example.demo.Models;

public class Request {
    private String id;
    private String item;
    private String requester;
    private String reason;
    private String amount;
    private String city;
    private String state;
    private String country;

    public Request(String id, String item, String requester, String reason, String amount, String city, String state, String country){
        this.id = id;
        this.item = item;
        this.requester = requester;
        this.reason = reason;
        this.amount = amount;
        this.city = city;
        this.state = state;
        this.country = country;
    }

    public Request(){}

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

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getId(){ return this.id; }

    public String getRequester(){
        return this.requester;
    }

    public void setRequester(String username){ this.requester = username; }

    public String getItem(){
        return this.item;
    }

    public void setAmount(String amount){
        this.amount = amount;
    }

    public String getAmount(){
        return this.amount;
    }

    public String getReason(){
        return this.reason;
    }
}
