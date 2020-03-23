package com.example.demo;

public class Login {
    private String user;
    private String pass;
    private String tier;

    public Login(String user, String pass, String tier){
        this.user = user;
        this.pass = pass;
        this.tier = tier;
    }

    public Login(){}

    public String getUser(){
        return user;
    }

    public String getPass(){
        return pass;
    }

    public String getTier(){return tier;}

    public void setUser(String user){
        this.user = user;
    }

    public void setPass(String pass){
        this.pass = pass;
    }

    public void setTier(String tier) {this.tier = tier;}
}
