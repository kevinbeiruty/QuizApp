package com.example.quizgame;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import java.io.IOException;
import javafx.scene.Parent;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;


public class QuestionsController {

    @FXML
    private Label questionLabel;
    @FXML
    private Button answer1, answer2, answer3, answer4;
    @FXML
    private Label progressLabel;
    @FXML
    private Button backButton;

    private String topic;
    private int currentQuestionIndex = 0;
    private int score = 0;

    @FXML
    private void handleBackButton() throws IOException {
        // Load the StartQuiz scene
        Parent startQuizParent = FXMLLoader.load(getClass().getResource("StartQuiz.fxml")); // Replace with your StartQuiz FXML file path
        Scene startQuizScene = new Scene(startQuizParent);

        // Get the current stage and set the new scene
        Stage window = (Stage) backButton.getScene().getWindow();
        window.setScene(startQuizScene);
        window.show();
    }

    private final String[][] generalKnowledgeQuestions = {
            {"What is the capital of France?", "Paris", "London", "Berlin", "Madrid", "1"},
            {"Who wrote 'Hamlet'?", "Mark Twain", "Charles Dickens", "William Shakespeare", "Jane Austen", "3"},
            {"What is the largest planet in our Solar System?", "Earth", "Mars", "Jupiter", "Saturn", "3"},
            {"What is the chemical symbol for water?", "H2O", "O2", "CO2", "NaCl", "1"},
            {"What year did World War II end?", "1942", "1945", "1948", "1950", "2"},
            {"Which element has the atomic number 1?", "Hydrogen", "Helium", "Oxygen", "Carbon", "1"},
            {"Who painted the Mona Lisa?", "Vincent van Gogh", "Leonardo da Vinci", "Pablo Picasso", "Claude Monet", "2"},
            {"What is the smallest continent by land area?", "Africa", "Australia", "Europe", "Antarctica", "2"},
            {"What is the capital city of Japan?", "Seoul", "Beijing", "Bangkok", "Tokyo", "4"},
            {"Which planet is known as the Red Planet?", "Venus", "Mars", "Jupiter", "Mercury", "2"},
            {"What is the freezing point of water in Celsius?", "0", "32", "100", "-1", "1"},
            {"Who discovered gravity?", "Isaac Newton", "Albert Einstein", "Galileo Galilei", "Nikola Tesla", "1"},
            {"Which country is known as the Land of the Rising Sun?", "China", "South Korea", "Japan", "Thailand", "3"},
            {"What is the largest ocean in the world?", "Atlantic", "Indian", "Arctic", "Pacific", "4"},
            {"What is the currency of the United Kingdom?", "Euro", "Dollar", "Yen", "Pound Sterling", "4"},
            {"What is the tallest mountain in the world?", "K2", "Kangchenjunga", "Mount Everest", "Makalu", "3"},
            {"Who developed the theory of relativity?", "Isaac Newton", "Albert Einstein", "Stephen Hawking", "Marie Curie", "2"},
            {"Which organ in the human body pumps blood?", "Lungs", "Kidney", "Heart", "Brain", "3"},
            {"What is the national sport of Canada?", "Basketball", "Ice Hockey", "Baseball", "Cricket", "2"},
            {"Which gas do plants use in photosynthesis?", "Oxygen", "Nitrogen", "Carbon Dioxide", "Hydrogen", "3"}
    };

    private final String[][] sportsQuestions = {
            {"Which country won the FIFA World Cup in 2018?", "Brazil", "France", "Germany", "Argentina", "2"},
            {"What is the national sport of Japan?", "Baseball", "Sumo Wrestling", "Karate", "Judo", "2"},
            {"How many players are there in a soccer team on the field?", "9", "10", "11", "12", "3"},
            {"In tennis, what is a score of zero called?", "Zero", "Love", "Ace", "Deuce", "2"},
            {"Which sport is known as the 'King of Sports'?", "Basketball", "Soccer", "Cricket", "Tennis", "2"},
            {"What is the maximum score in a single frame of bowling?", "200", "300", "400", "500", "2"},
            {"Which country is home to the All Blacks rugby team?", "Australia", "South Africa", "New Zealand", "England", "3"},
            {"Who holds the record for the most Olympic gold medals?", "Carl Lewis", "Michael Phelps", "Usain Bolt", "Mark Spitz", "2"},
            {"Which country hosted the first modern Olympic Games in 1896?", "France", "USA", "Greece", "Germany", "3"},
            {"What is the length of a standard marathon?", "21.1 km", "42.2 km", "50 km", "35 km", "2"},
            {"In which sport would you perform a slam dunk?", "Soccer", "Basketball", "Volleyball", "Rugby", "2"},
            {"Who is often considered the greatest basketball player of all time?", "LeBron James", "Kobe Bryant", "Michael Jordan", "Magic Johnson", "3"},
            {"What is the term for three consecutive strikes in bowling?", "Double", "Spare", "Turkey", "Hat-trick", "3"},
            {"Which sport uses a puck?", "Soccer", "Ice Hockey", "Field Hockey", "Tennis", "2"},
            {"What is the top prize in the Wimbledon tennis tournament?", "Silver Trophy", "Gold Cup", "Challenge Cup", "Rosewater Dish", "4"},
            {"In cricket, how many runs is a century?", "50", "100", "150", "200", "2"},
            {"What is the highest governing body for soccer?", "FIFA", "UEFA", "IOC", "NBA", "1"},
            {"Which country is famous for the sport of cricket?", "USA", "India", "France", "Japan", "2"},
            {"In golf, what is a hole completed one stroke under par called?", "Eagle", "Birdie", "Bogey", "Par", "2"},
            {"What is the name of the NFL championship game?", "World Series", "Super Bowl", "Stanley Cup", "NBA Finals", "2"}
    };

    private final String[][] historyQuestions = {
            {"Who was the first President of the United States?", "George Washington", "Thomas Jefferson", "Abraham Lincoln", "John Adams", "1"},
            {"In which year did the Titanic sink?", "1908", "1912", "1916", "1920", "2"},
            {"Who was known as the 'Iron Lady'?", "Margaret Thatcher", "Indira Gandhi", "Angela Merkel", "Queen Elizabeth II", "1"},
            {"Which empire was ruled by Julius Caesar?", "Roman Empire", "Greek Empire", "Ottoman Empire", "Persian Empire", "1"},
            {"What was the name of the ship on which the Pilgrims traveled to America?", "Mayflower", "Santa Maria", "Endeavour", "Beagle", "1"},
            {"What year marked the end of World War I?", "1914", "1916", "1918", "1920", "3"},
            {"Who discovered America in 1492?", "Vasco da Gama", "Christopher Columbus", "Ferdinand Magellan", "James Cook", "2"},
            {"Which ancient civilization built the pyramids?", "Mesopotamians", "Egyptians", "Romans", "Aztecs", "2"},
            {"Who was the first woman to win a Nobel Prize?", "Marie Curie", "Florence Nightingale", "Amelia Earhart", "Jane Austen", "1"},
            {"Which famous wall was built to protect the northern border of the Roman Empire in Britain?", "Berlin Wall", "Hadrian's Wall", "Great Wall of China", "Iron Curtain", "2"},
            {"What was the name of the last queen of France?", "Marie Antoinette", "Anne Boleyn", "Catherine de' Medici", "Elizabeth I", "1"},
            {"Which event marked the start of World War II?", "Attack on Pearl Harbor", "German invasion of Poland", "Battle of Stalingrad", "D-Day landing", "2"},
            {"Who was the leader of the Soviet Union during World War II?", "Vladimir Lenin", "Joseph Stalin", "Mikhail Gorbachev", "Nikita Khrushchev", "2"},
            {"What was the name of the ship that Charles Darwin traveled on during his research?", "Endeavour", "Mayflower", "Beagle", "Victoria", "3"},
            {"Which year did the Berlin Wall fall?", "1987", "1989", "1991", "1993", "2"},
            {"Who was the first emperor of China?", "Kublai Khan", "Qin Shi Huang", "Sun Yat-sen", "Liu Bang", "2"},
            {"What was the name of the first artificial satellite launched into space?", "Sputnik 1", "Explorer 1", "Apollo 11", "Voyager 1", "1"},
            {"Who was the British Prime Minister during World War II?", "Neville Chamberlain", "Winston Churchill", "Margaret Thatcher", "Clement Attlee", "2"},
            {"Which ancient city is known as the 'Lost City of the Incas'?", "Machu Picchu", "Tenochtitlan", "Petra", "Angkor Wat", "1"},
            {"Which battle marked Napoleon's final defeat?", "Battle of Trafalgar", "Battle of Austerlitz", "Battle of Leipzig", "Battle of Waterloo", "4"}
    };

    private final String[][] scienceQuestions = {
            {"What is the chemical symbol for gold?", "Au", "Ag", "Fe", "Pb", "1"},
            {"What planet is closest to the Sun?", "Earth", "Venus", "Mercury", "Mars", "3"},
            {"What is the process by which plants make their food?", "Respiration", "Photosynthesis", "Transpiration", "Osmosis", "2"},
            {"Who is known as the father of modern physics?", "Isaac Newton", "Albert Einstein", "Galileo Galilei", "Nikola Tesla", "2"},
            {"What is the boiling point of water at sea level in Celsius?", "50", "100", "200", "150", "2"},
            {"What gas do humans exhale during respiration?", "Oxygen", "Carbon Dioxide", "Nitrogen", "Hydrogen", "2"},
            {"What is the hardest natural substance on Earth?", "Iron", "Diamond", "Granite", "Quartz", "2"},
            {"What is the unit of electrical resistance?", "Volt", "Ohm", "Watt", "Ampere", "2"},
            {"What is the largest organ in the human body?", "Heart", "Skin", "Liver", "Brain", "2"},
            {"What part of the cell contains the genetic material?", "Nucleus", "Ribosome", "Cytoplasm", "Mitochondria", "1"},
            {"Which planet is known as the 'Blue Planet'?", "Venus", "Mars", "Earth", "Neptune", "3"},
            {"What type of blood cells help fight infections?", "Red Blood Cells", "Platelets", "White Blood Cells", "Plasma", "3"},
            {"What is the chemical formula for table salt?", "NaCl", "H2O", "CO2", "KCl", "1"},
            {"What is the smallest particle of an element?", "Atom", "Molecule", "Electron", "Neutron", "1"},
            {"What is the name of the force that pulls objects toward the Earth's center?", "Magnetism", "Friction", "Gravity", "Momentum", "3"},
            {"What is the speed of light in a vacuum?", "300,000 km/s", "150,000 km/s", "500,000 km/s", "100,000 km/s", "1"},
            {"Which part of the brain controls voluntary actions?", "Cerebellum", "Cerebrum", "Medulla", "Hypothalamus", "2"},
            {"What is the primary gas found in Earth's atmosphere?", "Oxygen", "Nitrogen", "Carbon Dioxide", "Helium", "2"},
            {"What is the chemical symbol for the element with atomic number 1?", "H", "He", "Li", "O", "1"},
            {"Which scientist proposed the theory of evolution by natural selection?", "Charles Darwin", "Gregor Mendel", "Louis Pasteur", "James Watson", "1"}
    };

    private List<String[]> questions;

    public void setTopic(String topic) {
        this.topic = topic;
        questions = new ArrayList<>();

        switch (topic) {
            case "General Knowledge":
                Collections.addAll(questions, generalKnowledgeQuestions);
                break;
            case "Sports":
                Collections.addAll(questions, sportsQuestions);
                break;
            case "History":
                Collections.addAll(questions, historyQuestions);
                break;
            case "Science":
                Collections.addAll(questions, scienceQuestions);
                break;
            default:
                questions = new ArrayList<>();
        }

        Collections.shuffle(questions);
        loadQuestion();
    }

    private void loadQuestion() {
        if (currentQuestionIndex < questions.size()) {
            String[] current = questions.get(currentQuestionIndex);
            questionLabel.setText(current[0]);
            answer1.setText(current[1]);
            answer2.setText(current[2]);
            answer3.setText(current[3]);
            answer4.setText(current[4]);
            progressLabel.setText("Question " + (currentQuestionIndex + 1) + " of " + questions.size());
        } else {
            showResults();
        }
    }

    @FXML
    private void handleAnswer1() {
        checkAnswer(1);
    }

    @FXML
    private void handleAnswer2() {
        checkAnswer(2);
    }

    @FXML
    private void handleAnswer3() {
        checkAnswer(3);
    }

    @FXML
    private void handleAnswer4() {
        checkAnswer(4);
    }

    private void checkAnswer(int selectedAnswer) {
        String[] current = questions.get(currentQuestionIndex);
        int correctAnswerIndex = Integer.parseInt(current[5]);

        if (selectedAnswer == correctAnswerIndex) {
            score++;
        }

        currentQuestionIndex++;
        loadQuestion();
    }

    private void showResults() {
        questionLabel.setText("Quiz Completed! Your score is: " + score + "/" + questions.size());
        answer1.setVisible(false);
        answer2.setVisible(false);
        answer3.setVisible(false);
        answer4.setVisible(false);
        progressLabel.setText("Thank you for playing!");
        backButton.setVisible(true);
    }

}
