package gui.controllers;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.VBox;

public class MainController {

    @FXML
    ScorePaneController currentScorePaneController,
        previousScorePaneController, spacePressedScorePaneController;
    @FXML VBox rootPane;
    @FXML FlightPaneController flightPaneController;

    public void initialize() {
        currentScorePaneController.setScoreTitle("Current Score");
        previousScorePaneController.setScoreTitle("Previous Score");
        spacePressedScorePaneController.setScoreTitle("Space Pressed");
        Platform.runLater(rootPane::requestFocus);
    }

    public void handleKeyPressed(KeyEvent event) {
        if(event.getCode() == KeyCode.SPACE) {
            flightPaneController.moveBirdUp();
            flightPaneController.birdPaneController.wingUp();
        }
    }

    public void handleKeyReleased(KeyEvent event) {
        if(event.getCode() == KeyCode.SPACE) {
            flightPaneController.birdPaneController.wingDown();
        }
    }

}
