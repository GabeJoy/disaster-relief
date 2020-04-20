package com.example.demo;

public class RequestHumanResource {
    private String id;
    private String user_requesting_id;
    private String description_of_volunteer_duties;
    private String justification;
    private Float estimated_hours_needed;
    private Boolean expired;

    public RequestHumanResource(String user_requesting_id, String description_of_volunteer_duties,
                                String justification, Float estimated_hours_needed, Boolean expired){
        this.user_requesting_id = user_requesting_id;
        this.description_of_volunteer_duties = description_of_volunteer_duties;
        this.justification = justification;
        this.estimated_hours_needed = estimated_hours_needed;
        this.expired = expired;
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

    public String getDescription_of_volunteer_duties() {
        return description_of_volunteer_duties;
    }

    public void setDescription_of_volunteer_duties(String description_of_volunteer_duties) {
        this.description_of_volunteer_duties = description_of_volunteer_duties;
    }

    public String getJustification() {
        return justification;
    }

    public void setJustification(String justification) {
        this.justification = justification;
    }

    public Float getEstimated_hours_needed() {
        return estimated_hours_needed;
    }

    public void setEstimated_hours_needed(Float estimated_hours_needed) {
        this.estimated_hours_needed = estimated_hours_needed;
    }

    public Boolean getExpired() {
        return expired;
    }

    public void setExpired(Boolean expired) {
        this.expired = expired;
    }
}