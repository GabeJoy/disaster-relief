package com.example.demo;

public class RequestItem {
    private String id;
    private String item_name;
    private Float amount_needed;
    private String user_requesting_id;
    private String reason_needed;
    private Boolean expired;
    private String identifier1;  // identifiers are details about the particular items, can be things like
    private String identifier2;  // color, size, or anything that specifies what they need.  Can be null.
    private String identifier3;

    public RequestItem(String item_name, String user_requesting_id, String reason_needed, String identifier1, String identifier2,
                String identifier3, Float amount_needed, Boolean expired){
        this.item_name = item_name;
        this.user_requesting_id = user_requesting_id;
        this.reason_needed = reason_needed;
        this.identifier1 = identifier1;
        this.identifier2 = identifier2;
        this.identifier3 = identifier3;
        this.amount_needed = amount_needed;
        this.expired = expired;
    }

    //getters and setters

    public String getItem_name() {
        return item_name;
    }

    public void setItem_name(String item_name) {
        this.item_name = item_name;
    }

    public Float getAmount_needed() {
        return amount_needed;
    }

    public void setAmount_needed(Float amount_needed) {
        this.amount_needed = amount_needed;
    }

    public String getUser_requesting_id() {
        return user_requesting_id;
    }

    public void setUser_requesting_id(String user_requesting_id) {
        this.user_requesting_id = user_requesting_id;
    }

    public String getReason_needed() {
        return reason_needed;
    }

    public void setReason_needed(String reason_needed) {
        this.reason_needed = reason_needed;
    }

    public Boolean getExpired() {
        return expired;
    }

    public void setExpired(Boolean expired) {
        this.expired = expired;
    }

    public String getIdentifier1() {
        return identifier1;
    }

    public void setIdentifier1(String identifier1) {
        this.identifier1 = identifier1;
    }

    public String getIdentifier2() {
        return identifier2;
    }

    public void setIdentifier2(String identifier2) {
        this.identifier2 = identifier2;
    }

    public String getIdentifier3() {
        return identifier3;
    }

    public void setIdentifier3(String identifier3) {
        this.identifier3 = identifier3;
    }

}