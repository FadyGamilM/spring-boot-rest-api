package com.socialmediarestapi.utils;

public class ErrorDetails {
    private String Description;
    private String message;
    public ErrorDetails(){}
    public ErrorDetails(String message, String Desc){
        this.message = message;
        this.Description = Desc;
    }

    public String getDescription() {
        return Description;
    }

    public String getMessage() {
        return message;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "ErrorDetails{" +
                "Description='" + Description + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
