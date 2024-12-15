package com.example.quizgame;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class UserService {

    // Method to save user credentials to a file
    public boolean saveUserCredentials(String username, String password) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("user_credentials.txt", true))) {
            writer.write("Username: " + username + ", Password: " + password);
            writer.newLine();
            System.out.println("Credentials saved.");
            return true;
        } catch (IOException e) {
            System.out.println("Error saving credentials: " + e.getMessage());
            return false;
        }
    }

    // Method to validate username and password (for this example, just checks if both are non-empty)
    public boolean validateCredentials(String username, String password) {
        // Add more complex validation logic here (e.g., checking against a database)
        return !username.isEmpty() && !password.isEmpty() && password.length() >= 5 && password.length() <= 15;
    }
}
