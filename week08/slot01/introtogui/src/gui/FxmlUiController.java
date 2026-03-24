package gui;

import java.util.Random;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class FxmlUiController {

    Random random;
    int num1 = 0, num2 = 0;

    @FXML
    private Label resultLabel, num1Label, num2Label;
    @FXML
    private TextField answerTextField;

    public void initialize() {
        random = new Random();
        num1 = random.nextInt(100);
        num2 = random.nextInt(100);
        num1Label.setText(Integer.toString(num1));
        num2Label.setText(Integer.toString(num2));
    }

    public void answer() {
        try {
            int answer = Integer.parseInt(answerTextField.getText());
            if (answer == num1 + num2) {
                resultLabel.setText("Correct!");
            } else {
                resultLabel.setText("Wrong!");
            }
        } catch (Exception e) {
            resultLabel.setText("Invalid");
        }
        
    }
    
}
