package com.example.quizgame;

import javafx.fxml.FXML;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.Scene;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloController {

    @FXML
    private Button userAccountCreation;  // Button for account creation

    @FXML
    private Button userLogIn;  // Button for login

    @FXML
    private Button GuestButton;

    @FXML
    private void LogInInfoRequired(ActionEvent event) {
        System.out.println("Log In button clicked.");
        // Add logic to navigate to the login screen or process login
    }

    @FXML
    public void goToLogInPage() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/example/quizgame/Login.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 500, 600);
            Stage stage = (Stage) userLogIn .getScene().getWindow(); // Update reference to `userLogIn`
            stage.setTitle("Log In - Quiz Game");
            stage.setScene(scene);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void goToStartQuizPage() {
        try {
            // Load the StartQuizPage FXML file
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/example/quizgame/StartQuiz.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 500, 600);

            // Get the current stage and set the new scene
            Stage stage = (Stage) GuestButton.getScene().getWindow();
            stage.setTitle("Start Quiz - Quiz Game");
            stage.setScene(scene);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void goToSignInPage() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/example/quizgame/SignIn.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 500, 600);
            Stage stage = (Stage) userAccountCreation.getScene().getWindow();
            stage.setTitle("Sign In - Quiz Game");
            stage.setScene(scene);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void NoLogInInfo(ActionEvent event) {
        System.out.println("Guest button clicked.");
        // Add logic to proceed without login
    }
}
