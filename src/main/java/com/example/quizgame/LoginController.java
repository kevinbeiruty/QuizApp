package com.example.quizgame;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginController {

    @FXML
    private TextField usernameField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Button loginButton;

    @FXML
    private Button signUpButton;

    @FXML
    private Button backButton;

    private UserService userService;

    public LoginController() {
        // Initialize the UserService
        this.userService = new UserService();
    }

    // Navigate to the Sign-Up page
    @FXML
    private void goToSignInPage() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/example/quizgame/SignIn.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 500, 600);
            Stage stage = (Stage) signUpButton.getScene().getWindow();
            stage.setTitle("Sign Up - Quiz Game");
            stage.setScene(scene);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Navigate to the Home page
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

    // Navigate to the Start Quiz page and save credentials to a file
    @FXML
    private void goToStartQuizPage() {
        String username = usernameField.getText();
        String password = passwordField.getText();

        // Validate inputs using UserService
        if (!userService.validateCredentials(username, password)) {
            System.out.println("Please enter valid username and password (password between 5 and 15 characters).");
        } else {
            System.out.println("Login successful for user: " + username);

            // Save credentials using UserService
            if (userService.saveUserCredentials(username, password)) {
                try {
                    // Load the StartQuizPage FXML file
                    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/example/quizgame/StartQuiz.fxml"));
                    Scene scene = new Scene(fxmlLoader.load(), 500, 600);

                    // Get the current stage and set the new scene
                    Stage stage = (Stage) loginButton.getScene().getWindow();
                    stage.setTitle("Start Quiz - Quiz Game");
                    stage.setScene(scene);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else {
                System.out.println("Error saving credentials.");
            }
        }
    }
}
