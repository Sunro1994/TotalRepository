package com.sunro.rest.webservices.restfulwebservices.exception;

import java.time.LocalDate;

public class ErrorDetails {

    //timestamp
    private LocalDate timestamp;
    //message
    private String message;
    //details
    private String details;


    public ErrorDetails(LocalDate timestamp, String message, String details) {
        this.timestamp = timestamp;
        this.message = message;
        this.details = details;
    }

    public LocalDate getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDate timestamp) {
        this.timestamp = timestamp;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }



}
