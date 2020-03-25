package com.example.demo;

//import javax.persistence.Entity;
//import javax.persistence.Id;

//@Entity
public class Login {
    //@Id
    private String id;
    private String user;
    private String pass;
    private String tier;

    public Login(String user, String pass, String tier){
        this.user = user;
        this.pass = pass;
        this.tier = tier;
    }

    public Login(){}

    //getters
    public String getUser(){
        return user;
    }

    public String getPass(){
        return pass;
    }

    public String getTier(){return tier;}

    public String getId() {
        return id;
    }

    //setters
    public void setUser(String user){
        this.user = user;
    }

    public void setPass(String pass){
        this.pass = pass;
    }

    public void setTier(String tier) {this.tier = tier;}

    public void setId(String id) {
        this.id = id;
    }
}
