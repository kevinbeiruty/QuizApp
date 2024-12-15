package com.example.quizgame;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressBar;
import javafx.stage.Stage;

import java.io.IOException;

public class ProgressController {
    @FXML
    private ProgressBar progressGeneralKnowledge;

    @FXML
    private ProgressBar progressSports;

    @FXML
    private ProgressBar progressHistory;

    @FXML
    private ProgressBar progressScience;

    @FXML
    private Button backButton;

    @FXML
    public void initialize() {
        progressGeneralKnowledge.setProgress(0.5);
        progressSports.setProgress(0.7);
        progressHistory.setProgress(0.3);
        progressScience.setProgress(0.9);
    }

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
}
