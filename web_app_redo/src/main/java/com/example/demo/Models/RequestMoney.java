package com.example.demo.Models;

public class RequestMoney {
    private String id;
    private String user_requesting_id;
    private String justification;
    private Float amount_needed;
    private Float amount_given_so_far;

    public RequestMoney(String user_requesting_id, String justification, Float amount_needed, Float amount_given_so_far){
        this.user_requesting_id = user_requesting_id;
        this.justification = justification;
        this.amount_needed = amount_needed;
        this.amount_given_so_far = amount_given_so_far;
    }

    // getters and setters

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUser_requesting_id() {
        return user_requesting_id;
    }

    public void setUser_requesting_id(String user_requesting_id) {
        this.user_requesting_id = user_requesting_id;
    }

    public String getJustification() {
        return justification;
    }

    public void setJustification(String justification) {
        this.justification = justification;
    }

    public Float getAmount_needed() {
        return amount_needed;
    }

    public void setAmount_needed(Float amount_needed) {
        this.amount_needed = amount_needed;
    }

    public Float getAmount_given_so_far() {
        return amount_given_so_far;
    }

    public void setAmount_given_so_far(Float amount_given_so_far) {
        this.amount_given_so_far = amount_given_so_far;
    }
}