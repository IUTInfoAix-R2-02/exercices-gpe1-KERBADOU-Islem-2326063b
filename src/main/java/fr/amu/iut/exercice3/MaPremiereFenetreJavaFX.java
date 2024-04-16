package fr.amu.iut.exercice3;

import javafx.application.Application;
import javafx.stage.Stage;

public class MaPremiereFenetreJavaFX extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setWidth(400);
        primaryStage.setHeight(400);
        primaryStage.setTitle("La page d'un Pro de JavaFX");
        primaryStage.show();
    }
}
