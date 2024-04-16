package fr.amu.iut.exercice4;

import javafx.application.Application;
import javafx.event.Event;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Palette extends Application {
    private int nbVert = 0;
    private int nbRouge = 0;
    private int nbBleu = 0;

    private String choix;

    private int nombreChoisi;

    private Button vert = new Button("Vert");
    private Button rouge = new Button("Rouge");
    private Button bleu = new Button("Bleu");

    private BorderPane root = new BorderPane();
    private Label label = new Label("Aucune couleur choisi");
    private Pane panneau = new Pane();
    private HBox bas = new HBox();

    public void changeColor(Event e, char choix){
        switch(choix){
            case 'v':
                ++nbVert;
                label.setText("Vert choisi " + nbVert);
                break;
            case 'r':
                ++nbRouge;
                label.setText("Rouge choisi " + nbRouge);
                break;
            case 'b':
                ++nbBleu;
                label.setText("Bleu choisi " + nbBleu);
                break;
        }

        int redIntensity = Math.min(255, nbRouge * 40);
        int greenIntensity = Math.min(255, nbVert * 40);
        int blueIntensity = Math.min(255, nbBleu * 40);
        panneau.setStyle("-fx-background-color: rgb(" + redIntensity + "," + greenIntensity + "," + blueIntensity + ");");
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        HBox haut = new HBox();
        haut.setAlignment(Pos.TOP_CENTER);

        haut.getChildren().addAll(label);

        vert.setOnAction(e -> {
            changeColor(e, 'v');
        });

        rouge.setOnAction(e -> {
            changeColor(e, 'r');
        });

        bleu.setOnAction(e -> {
            changeColor(e, 'b');
        });

        bas.getChildren().addAll(vert, rouge, bleu);
        bas.setSpacing(10);
        bas.setAlignment(Pos.CENTER);

        root.setTop(haut);
        root.setCenter(panneau);
        root.setBottom(bas);

        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setWidth(500);
        primaryStage.setHeight(500);
        primaryStage.show();
    }
}

