package com.example.demo;
import javax.persistence.*;

@Entity
@Table(name = "users")
public class Login {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;
    @Column(name="username")
    private String username;
    @Column(name="password")
    private String password;
    @Column(name="tier")
    private String tier;

//    public Login(String user, String pass, String tier){
//        this.username = user;
//        this.pass = pass;
//        this.tier = tier;
//    }

    public Login(){}

    //getters
    public String getUser(){
        return username;
    }

    public String getPass(){
        return password;
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
        this.password = pass;
    }

    public void setTier(String tier) {this.tier = tier;}

    public void setId(String id) {
        this.id = id;
    }
}
