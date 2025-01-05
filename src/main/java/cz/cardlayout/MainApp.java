package cz.cardlayout;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class MainApp extends Application {

    @Override
    public void start(Stage stage) throws IOException {


        int minWidth = 1920;
        int minHeight = 1200;


        FXMLLoader fxmlLoader = new FXMLLoader(MainApp.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), minWidth, minHeight);
        stage.setTitle("JavaFX Obrázky");
        stage.setScene(scene);

        stage.setMinWidth(minWidth);
        stage.setMinHeight(minHeight);

        stage.setFullScreen(false);
        stage.show();

    }



    public static void main(String[] args) {
        launch();
    }
}