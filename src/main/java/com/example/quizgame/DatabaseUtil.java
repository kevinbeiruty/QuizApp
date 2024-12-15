package com.example.quizgame;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


//this code was not needed since i had an error connecting the database to the project so i used files instead!!

public class DatabaseUtil {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/quiz_game";
        String user = "yourUsername";
        String password = "yourPassword";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url, user, password);
            System.out.println("Connection established successfully!");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}
