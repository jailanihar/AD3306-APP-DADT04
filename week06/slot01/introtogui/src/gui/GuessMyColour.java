package gui;

import java.util.Random;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class GuessMyColour extends Application {

    private Rectangle guessRectangle = new Rectangle();
    private Rectangle answerRectangle = new Rectangle();
    private Label counterLabel = new Label("0");

    private int guessRed = 0;
    private int guessGreen = 0;
    private int guessBlue = 0;

    private int answerRed = 0;
    private int answerGreen = 0;
    private int answerBlue = 0;

    private int counter = 0;

    private void initGUI(Stage arg0) {
        Label titleLabel = new Label();
        Font titleFont = Font.font("Serif", FontWeight.BOLD, 32);
        titleLabel.setFont(titleFont);
        titleLabel.setAlignment(Pos.CENTER);
        titleLabel.setText("Guess My Colour");
        titleLabel.setBackground(new Background(
            new BackgroundFill(Color.BLACK, null, null)
        ));
        titleLabel.setTextFill(Color.WHITE);

        BorderPane rootPane = new BorderPane();
        titleLabel.prefWidthProperty().bind(rootPane.widthProperty());
        rootPane.setTop(titleLabel);

        guessRectangle.setWidth(50);
        guessRectangle.setHeight(50);
        guessRectangle.setFill(Color.BLACK);

        answerRectangle.setWidth(50);
        answerRectangle.setHeight(50);
        answerRectangle.setFill(Color.CYAN);

        FlowPane centerPane = new FlowPane();
        centerPane.getChildren().add(guessRectangle);
        centerPane.getChildren().add(answerRectangle);
        centerPane.setAlignment(Pos.CENTER);
        centerPane.setHgap(10);

        rootPane.setCenter(centerPane);

        generateGuessColour();

        HBox buttonPane = new HBox();

        Font font = Font.font("Dialog", FontWeight.BOLD, 18);

        Button moreRedButton = new Button("+");
        moreRedButton.setBackground(new Background(
            new BackgroundFill(Color.RED, null, null)
        ));
        moreRedButton.setFont(font);
        moreRedButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent arg0) {
                if(answerRed <= 240) {
                    answerRed = answerRed + 15;
                    updateAnswerRectangle();
                }
            }
        });

        Button lessRedButton = new Button("-");
        lessRedButton.setBackground(new Background(
            new BackgroundFill(Color.RED, null, null)
        ));
        lessRedButton.setFont(font);
        lessRedButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent arg0) {
                if(answerRed >= 15) {
                    answerRed = answerRed - 15;
                    updateAnswerRectangle();
                }
            }
        });

        Button moreGreenButton = new Button("+");
        moreGreenButton.setBackground(new Background(
            new BackgroundFill(Color.GREEN, null, null)
        ));
        moreGreenButton.setFont(font);
        moreGreenButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent arg0) {
                if(answerGreen <= 240) {
                    answerGreen = answerGreen + 15;
                    updateAnswerRectangle();
                }
            }
        });

        Button lessGreenButton = new Button("-");
        lessGreenButton.setBackground(new Background(
            new BackgroundFill(Color.GREEN, null, null)
        ));
        lessGreenButton.setFont(font);
        lessGreenButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent arg0) {
                if(answerGreen >= 15) {
                    answerGreen = answerGreen - 15;
                    updateAnswerRectangle();
                }
            }
        });

        Button moreBlueButton = new Button("+");
        moreBlueButton.setBackground(new Background(
            new BackgroundFill(Color.BLUE, null, null)
        ));
        moreBlueButton.setFont(font);
        moreBlueButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent arg0) {
                if(answerBlue <= 240) {
                    answerBlue = answerBlue + 15;
                    updateAnswerRectangle();
                }
            }
        });

        Button lessBlueButton = new Button("-");
        lessBlueButton.setBackground(new Background(
            new BackgroundFill(Color.BLUE, null, null)
        ));
        lessBlueButton.setFont(font);
        lessBlueButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent arg0) {
                if(answerBlue >= 15) {
                    answerBlue = answerBlue - 15;
                    updateAnswerRectangle();
                }
            }
        });

        counterLabel.setTextFill(Color.WHITE);

        buttonPane.getChildren().addAll(
            moreRedButton, lessRedButton, moreGreenButton, lessGreenButton,
            moreBlueButton, lessBlueButton, counterLabel
        );
        buttonPane.setSpacing(10);

        Insets insets = new Insets(10);
        titleLabel.setPadding(insets);
        centerPane.setPadding(insets);
        buttonPane.setPadding(insets);
        buttonPane.setAlignment(Pos.CENTER);
        buttonPane.setBackground(
            new Background(
                new BackgroundFill(Color.BLACK, null, null))
        );

        rootPane.setBottom(buttonPane);

        Scene root = new Scene(rootPane);
        arg0.setScene(root);
    }

    private void generateGuessColour() {
        Random rand = new Random();
        guessRed = rand.nextInt(18) * 15;
        guessGreen = rand.nextInt(18) * 15;
        guessBlue = rand.nextInt(18) * 15;
        Color guessColor = Color.rgb(guessRed, guessGreen, guessBlue);
        guessRectangle.setFill(guessColor);

        answerRed = rand.nextInt(18) * 15;
        answerGreen = rand.nextInt(18) * 15;
        answerBlue = rand.nextInt(18) * 15;
        Color answerColor = Color.rgb(answerRed, answerGreen, answerBlue);
        answerRectangle.setFill(answerColor);
    }

    private void updateAnswerRectangle() {
        Color color = Color.rgb(answerRed, answerGreen, answerBlue);
        answerRectangle.setFill(color);
        System.out.println("guess red = " + guessRed + ", guess green = " + guessGreen + ", guess blue = " + guessBlue);
        System.out.println("answer red = " + answerRed + ", answer green = " + answerGreen + ", answer blue = " + answerBlue);
        if(guessRed == answerRed 
                && guessGreen == answerGreen 
                && guessBlue == answerBlue) {
            String message =
                "Congratulation! You guessed it! Red = "
                + guessRed + ", green = "
                + guessGreen + ", blue = "
                + guessBlue;
            Alert alert = new Alert(AlertType.CONFIRMATION);
            alert.setTitle("You did it");
            alert.setHeaderText(null);
            alert.setContentText(message);
            // alert.showAndWait();
            ButtonData buttonType = alert.showAndWait().get().getButtonData();
            if(buttonType == ButtonData.OK_DONE) {
                counter++;
                counterLabel.setText(Integer.toString(counter));
                generateGuessColour();
            } else {
                System.exit(0);
            }
        }
    }

    @Override
    public void start(Stage arg0) throws Exception {
        initGUI(arg0);

        arg0.setTitle("Guess My Colour");
        arg0.setResizable(false);
        arg0.sizeToScene();
        arg0.show();
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
    
}
