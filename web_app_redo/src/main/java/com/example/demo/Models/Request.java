package com.example.demo.Models;

public class Request {
    private String id;
    private String item;
    private String requester;
    private String reason;
    private String amount;

    public Request(String id, String item, String requester, String reason, String amount){
        this.id = id;
        this.item = item;
        this.requester = requester;
        this.reason = reason;
        this.amount = amount;
    }

    public String getRequester(){
        return this.requester;
    }

    public String getItem(){
        return this.item;
    }

    public String getAmount(){
        return this.amount;
    }

    public String getReason(){
        return this.reason;
    }
}
