package gui;

import java.util.Random;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class Main extends Application {

    private static final String[] ANSWER = {
        "Yes",
        "Go for it",
        "Yes, definitely",
        "For sure",
        "I would say yes",
        "Most likely yes",
        "No",
        "I wouldn't",
        "In my opinion, no",
        "Definitely not",
        "Probably not",
        "It is very doubtful"
    };

    @Override
    public void start(Stage arg0) throws Exception {
        Random rand = new Random();
        int chooseAnswer = rand.nextInt(ANSWER.length);
        String answer = ANSWER[chooseAnswer];
        // Label label = new Label("Hello World");
        Label label = new Label();
        label.setText(answer);
        Font font = Font.font("Times New Roman", FontWeight.BOLD, FontPosture.ITALIC, 32);
        label.setFont(font);
        // Scene scene = new Scene(label, 200, 100);
        Scene scene = new Scene(label);
        arg0.setScene(scene);
        arg0.sizeToScene();
        arg0.setResizable(false);
        arg0.setTitle("Yes/No");
        arg0.show();
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
    
}
