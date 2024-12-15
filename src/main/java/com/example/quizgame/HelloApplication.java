package com.example.quizgame;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/com/example/quizgame/hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 500, 600);
        stage.setTitle("Quiz Game - Home");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.setMinWidth(500);
        stage.setMinHeight(600);
        stage.setMaxWidth(500);
        stage.setMaxHeight(600);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}