package com.example.freemoneynoscam.services;

import java.sql.*;
import java.util.ArrayList;

public class EmailRepository {

    public ArrayList<String> getEmailFromDB() {
        ArrayList<String> dbEmails = new ArrayList<>();

        try {
            // forbindelse bliver oprettet til database
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/toby", "Tobias KEA", "Bl@kie2349");

            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery("SELECT * FROM free_money.emails");

            while (resultSet.next()) {
                String emails = resultSet.getString("emails");
                dbEmails.add(emails);
            }
            System.out.println(dbEmails);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return dbEmails;
    }
}
