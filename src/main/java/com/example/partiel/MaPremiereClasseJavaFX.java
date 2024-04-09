package com.example.partiel;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class MaPremiereClasseJavaFX extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Parameters params = getParameters();
        int width = 300;
        int height = 150;

        if (params.getRaw().size() > 0) {
            width = Integer.parseInt(params.getRaw().get(0));
        }

        if (params.getRaw().size() > 1) {
            height = Integer.parseInt(params.getRaw().get(1));
        }

        StackPane root = new StackPane();
        Scene scene = new Scene(root, width, height);

        primaryStage.setScene(scene);
        primaryStage.setTitle("Exemple d'utilisation des arguments en ligne de commande");
        primaryStage.show();

    }
}
