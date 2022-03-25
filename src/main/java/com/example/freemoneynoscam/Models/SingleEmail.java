package com.example.freemoneynoscam.Models;

public class SingleEmail {
    String email;

    public SingleEmail(String email){
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return "SingleEmail{" +
                "email='" + email + '\'' +
                '}';
    }
}
