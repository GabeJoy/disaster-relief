package com.example.demo.Models;

public class User {
    private String id;
    private String first;
    private String last;
    private String username;
    private String pass;
    private String tier;
    private String email;
    private String city;
    private String state;
    private String country;

    public User(String first, String last, String username, String pass, String tier, String email, String city, String state, String country){
        this.first = first;
        this.last = last;
        this.username = username;
        this.pass = pass;
        this.tier = tier;
        this.email = email;
        this.city = city;
        this.state = state;
        this.country = country;
    }

    public User(){}

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

    //getters
    public String getFirst() {return first;}
    public String getLast() {return last;}
    public String getUser(){
        return username;
    }

    public String getPass(){
        return pass;
    }

    public String getTier(){return tier;}

    public String getId() {
        return id;
    }

    public String getEmail(){
        return email;
    }

    //setters
    public void setFirst(String first){
        this.first = first;
    }
    public void setLast(String last){
        this.last = last;
    }
    public void setUser(String username){
        this.username = username;
    }

    public void setPass(String pass){
        this.pass = pass;
    }

    public void setTier(String tier) {this.tier = tier;}

    public void setId(String id) {
        this.id = id;
    }

    public void setEmail(String email){
        this.email = email;
    }
}