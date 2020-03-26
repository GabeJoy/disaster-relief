package com.example.demo;

//import javax.persistence.Entity;
//import javax.persistence.Id;

//@Entity
public class Login {
    //@Id
    private String id;
    private String username;
    private String pass;
    private String tier;

    public Login(String user, String pass, String tier){
        this.username = user;
        this.pass = pass;
        this.tier = tier;
    }

    public Login(){}

    //getters
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

    //setters
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
}
