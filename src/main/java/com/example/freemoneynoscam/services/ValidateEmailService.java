package com.example.freemoneynoscam.services;

public class ValidateEmailService {
    public boolean isEmailValid(String email){
        //TODO implement logic such that we verify an e-mail is valid
        if (email.contains("@") && email.contains(".")) {
            System.out.println("email is valid");
            return true;
        } else {
            System.out.println("email is not valid");
            return false;
        }
    }
}
