package com.example.quizgame;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;

import java.io.IOException;

public class TopicsController {

    @FXML
    private RadioButton GeneralKnowledge_;

    @FXML
    private RadioButton History_;

    @FXML
    private RadioButton Sports_;

    @FXML
    private RadioButton Science_;

    @FXML
    private Button Confirmation_;
    @FXML
    private Button backButton;

    private String selectedTopic;


    @FXML
    private void goToStartQuiz() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/example/quizgame/StartQuiz.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 500, 600);
            Stage stage = (Stage) backButton.getScene().getWindow();
            stage.setTitle("Home - Quiz Game");
            stage.setScene(scene);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @FXML
    public void initialize() {
        // Group RadioButtons to allow only one selection
        ToggleGroup topicGroup = new ToggleGroup();
        GeneralKnowledge_.setToggleGroup(topicGroup);
        History_.setToggleGroup(topicGroup);
        Sports_.setToggleGroup(topicGroup);
        Science_.setToggleGroup(topicGroup);

        // Add listener to store the selected topic
        topicGroup.selectedToggleProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                selectedTopic = ((RadioButton) newValue).getText();
            }
        });
    }

    // Handle Confirm button click
    @FXML
    private void ConfirmSelection() {
        if (selectedTopic == null) {
            System.out.println("No topic selected!"); // Optional: Show an alert to the user
            return;
        }

        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/example/quizgame/StartQuiz.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 500, 600);

            // Get the current stage and set the new scene
            Stage stage = (Stage) Confirmation_.getScene().getWindow();
            stage.setTitle("Start Quiz - Quiz Game");
            stage.setScene(scene);

            // Pass the selected topic to the StartQuizController
            StartQuizController controller = fxmlLoader.getController();
            controller.setSelectedTopic(selectedTopic); // This method exists in StartQuizController

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
