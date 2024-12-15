package com.example.quizgame;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class StartQuizController {

    @FXML
    private Button SignningOut_;
    @FXML
    private Button QuizStart;
    @FXML
    private Button SelectTopic;
    @FXML
    private Button QuizProgress_;

    private String selectedTopic;

    // This method is used to set the selected topic from the topic selection page
    public void setSelectedTopic(String topic) {
        this.selectedTopic = topic;
        System.out.println("Selected Topic: " + selectedTopic); // Optional: Debugging purpose
    }

    // Handle the "Back" button click (UserLogOut)
    @FXML
    private void UserLogOut() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/example/quizgame/hello-view.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 500, 600);

            Stage stage = (Stage) SignningOut_.getScene().getWindow();
            stage.setTitle("Home - Quiz Game");
            stage.setScene(scene);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Handle the "Start Quiz" button click
    @FXML
    private void StartsTheQuiz() {
        if (selectedTopic == null || selectedTopic.isEmpty()) {
            System.out.println("Error: No topic selected!");
            return; // Optionally show a warning to the user
        }

        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/example/quizgame/Questions.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 500, 600);

            Stage stage = (Stage) QuizStart.getScene().getWindow();
            stage.setTitle("Quiz - Quiz Game");
            stage.setScene(scene);

            // Pass the selected topic to the QuizPageController
            QuestionsController quizPageController = fxmlLoader.getController();
            quizPageController.setTopic(selectedTopic);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Handle the "Progress" button click
    @FXML
    private void UserQuizProgress() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/example/quizgame/Progress.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 500, 600);

            Stage stage = (Stage) QuizProgress_.getScene().getWindow();
            stage.setTitle("Progress - Quiz Game");
            stage.setScene(scene);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Navigate to the Topic Selection page
    @FXML
    private void navigateToTopicSelection() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/example/quizgame/Topics.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 500, 600);

            Stage stage = (Stage) SelectTopic.getScene().getWindow();
            stage.setTitle("Topic Selection - Quiz Game");
            stage.setScene(scene);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
