package gui;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage arg0) throws Exception {
        Scene scene = new Scene(new Button("ABC"), 480, 200);
        arg0.setScene(scene);
        arg0.show();
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
    
}
