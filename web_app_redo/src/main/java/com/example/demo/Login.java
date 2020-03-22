package com.example.demo;

public class Login {
    private String user;
    private String pass;

    public Login(String user, String pass){
        this.user = user;
        this.pass = pass;
    }

    public Login(){}

    public String getUser(){
        return user;
    }

    public String getPass(){
        return pass;
    }

    public void setUser(String user){
        this.user = user;
    }

    public void setPass(String pass){
        this.pass = pass;
    }
}
