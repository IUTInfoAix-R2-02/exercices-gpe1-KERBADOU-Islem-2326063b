package fr.amu.iut.exercice6;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class IHMPendu extends Application {
    private int nbVie = 7;
    private String mot = "******";

    private Node[] nodes = {a, b, c, d, e, f, g, h, i, j, k, l, m, n, o, p, q, r, s, t, u, v, w, x, y, z};

    for (int index = 0; index <= 26; ++index){
        private Button nodes[index] = new Button(nodes.toString(nodes[index]));
    }




    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Jeu du pendu");
        primaryStage.setWidth(500);
        primaryStage.setHeight(550);

        VBox root = new VBox();
        root.setAlignment(Pos.CENTER);
        root.setSpacing(15);

        Label vieString = new Label("Nombre de vies : " + nbVie);
        Label motString = new Label(mot);
        vieString.setStyle("-fx-font-weight: bold");
        motString.setStyle("-fx-font-weight: bold");
        vieString.setFont(new Font(20.0));
        motString.setFont(new Font(20.0));


        for (char letter = 'a'; letter <= 'z'; letter++) {
            String style = String.format("-fx-background-color: transparent; -fx-text-fill: %s;", letter);
            a.setStyle(style);
        }


        HBox boutons = new HBox();
        boutons.setAlignment(Pos.CENTER);
        boutons.getChildren().addAll(a, e, i, o, u , y, b, c, d, f, g, h, j, k, l, m, n, p, q, r, s, t, v, w, x, z);


        root.getChildren().addAll(vieString, motString, boutons);
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);

        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
