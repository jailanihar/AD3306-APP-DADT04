package gui.controllers;

import javafx.animation.AnimationTimer;
import javafx.fxml.FXML;
import javafx.scene.layout.Pane;

public class FlightPaneController {

    private static final double GRAVITY = 900;

    private double velocityY;

    @FXML Pane birdPane, flightPane;
    @FXML BirdPaneController birdPaneController;
    AnimationTimer animation;

    public void initialize() {
        birdPane.setLayoutX(10);
        birdPane.setLayoutY(300);
        animation = new AnimationTimer() {
            private long previousTime;
            
            @Override
            public void handle(long now) {
                if(previousTime == 0) {
                    previousTime = now;
                    return;
                }
                double deltaSeconds = (now - previousTime) / 1000000000.0;
                previousTime = now;

                velocityY += GRAVITY * deltaSeconds;

                double maxY = 
                    flightPane.getHeight() - birdPane.getBoundsInParent().getHeight();
                double nextY = birdPane.getLayoutY() + velocityY * deltaSeconds;

                if(nextY < 0) {
                    nextY = 0;
                    velocityY = 0;
                } else if (nextY > maxY) {
                    nextY = maxY;
                    velocityY = 0;
                }

                birdPane.setLayoutY(nextY);
            }
        };
        animation.start();
    }

    public void moveBirdUp() {
        velocityY = -350;
    }

}
