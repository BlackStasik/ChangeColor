package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;


public class Main extends Application {

    static Scene scene;
    static Parent root;

    @Override
    public void start(Stage primaryStage) throws IOException {
        String fxmlFile = "sample.fxml";
        FXMLLoader loader = new FXMLLoader();
        root = loader.load(getClass().getResourceAsStream(fxmlFile));
        primaryStage.setTitle("Trying CSS");
        scene = new Scene(root,300,200);
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public static void main(String[] args) {

        launch(args);

    }
}
