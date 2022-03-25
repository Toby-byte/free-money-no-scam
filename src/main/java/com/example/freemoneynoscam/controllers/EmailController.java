package com.example.freemoneynoscam.controllers;

import com.example.freemoneynoscam.EmailRepository;
import com.example.freemoneynoscam.Models.SingleEmail;
import com.example.freemoneynoscam.services.ValidateEmailService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.context.request.WebRequest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

@Controller
public class EmailController {

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/success")
    public String success() {
        return "success";
    }

    @PostMapping("/test")
    public String email(WebRequest dataFromForm){
        // Denne kode virker nu lad vær med at røre ved den!
        ValidateEmailService validateEmailService = new ValidateEmailService();
        try {
            String emailData = dataFromForm.getParameter("email");

                boolean validateEmail = validateEmailService.isEmailValid(emailData);

                if (validateEmail == true) {
                    Connection myConnection = DriverManager.getConnection("jdbc:mysql://localhost:3306/toby", "Tobias KEA", "Bl@kie2349");

                    PreparedStatement statement = myConnection.prepareStatement("INSERT INTO free_money.emails (emails) VALUES (?)");
                    statement.setString(1,emailData);
                    statement.executeUpdate();
                } else if (validateEmail == false) {
                    return "redirect:/";
                }



        } catch (Exception e) {
            e.printStackTrace();
        }
        return "redirect:/success";

    }
}
