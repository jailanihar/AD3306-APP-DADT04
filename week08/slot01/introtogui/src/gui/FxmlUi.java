package gui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class FxmlUi extends Application {

    @Override
    public void start(Stage arg0) throws Exception {
        FXMLLoader loader = 
            new FXMLLoader(getClass().getResource("FxmlUi.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        arg0.setScene(scene);
        arg0.setTitle("Addition Quiz");
        arg0.show();
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
    
}
