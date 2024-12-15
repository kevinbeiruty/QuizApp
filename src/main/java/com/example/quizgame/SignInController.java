package com.example.quizgame;

import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.io.BufferedWriter;
import java.io.FileWriter;

public class SignInController {

    @FXML
    private TextField usernameField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private PasswordField confirmPasswordField;

    @FXML
    private Button signUpButton;

    @FXML
    private Button logInButton;

    @FXML
    private Button backButton;


    private UserService userService;

    public SignInController() {
        // Initialize the UserService
        this.userService = new UserService();
    }

    @FXML
    private void goToStartQuizPage() {
        String username = usernameField.getText();
        String password = passwordField.getText();
        String confirmPassword = confirmPasswordField.getText();

        // Validate input fields
        if (username.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()) {
            System.out.println("Please fill in all fields.");
            return;
        }

        if (!password.equals(confirmPassword)) {
            System.out.println("Passwords do not match.");
            return;
        }

        if (!userService.validateCredentials(username, password)) {
            System.out.println("Invalid credentials. Ensure the password is between 5 and 15 characters.");
        } else {
            // Save credentials using UserService
            if (userService.saveUserCredentials(username, password)) {
                System.out.println("Sign up successful for user: " + username);

                try {
                    // Load the StartQuizPage FXML file
                    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/example/quizgame/StartQuiz.fxml"));
                    Scene scene = new Scene(fxmlLoader.load(), 500, 600);

                    // Get the current stage and set the new scene
                    Stage stage = (Stage) signUpButton.getScene().getWindow();
                    stage.setTitle("Start Quiz - Quiz Game");
                    stage.setScene(scene);
                } catch (IOException e) {
                    e.printStackTrace();
                    System.out.println("Error loading the Start Quiz page.");
                }
            } else {
                System.out.println("Error saving credentials.");
            }
        }
    }

    // Navigate to the Log In page
    @FXML
    private void goToLogInPage() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/example/quizgame/Login.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 500, 600);
            Stage stage = (Stage) logInButton.getScene().getWindow();
            stage.setTitle("Log In - Quiz Game");
            stage.setScene(scene);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Navigate back to the Home page
    @FXML
    private void goToHomePage() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/example/quizgame/hello-view.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 500, 600);
            Stage stage = (Stage) backButton.getScene().getWindow();
            stage.setTitle("Home - Quiz Game");
            stage.setScene(scene);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
