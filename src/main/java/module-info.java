module com.example.quizgame {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.dlsc.formsfx;
    requires java.sql;

    opens com.example.quizgame to javafx.fxml;
    exports com.example.quizgame;
}