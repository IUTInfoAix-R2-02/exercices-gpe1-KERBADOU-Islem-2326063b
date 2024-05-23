package fr.amu.iut.exercice11;

import javafx.application.Application;
import javafx.beans.Observable;
import javafx.beans.binding.Bindings;
import javafx.beans.property.*;
import javafx.beans.value.ObservableBooleanValue;
import javafx.event.Event;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

import static javafx.beans.binding.Bindings.concat;

@SuppressWarnings("Duplicates")
public class Palette extends Application {

    private int nbVert = 0;
    private int nbRouge = 0;
    private int nbBleu = 0;

    private IntegerProperty nbFois;

    private StringProperty message;

    private StringProperty couleurPanneau;
    private Label texteDuHaut;

    private Button vert;
    private Button rouge;
    private Button bleu;

    private BorderPane root;
    private Pane panneau;
    private HBox boutons;

    private Label texteDuBas;

    public void createBindings(){
        BooleanProperty pasEncoreClic = new SimpleBooleanProperty();

        pasEncoreClic.bind(Bindings.equal(0, nbFois));
        texteDuHaut.textProperty().bind(Bindings.when(pasEncoreClic).then(concat("Pas Encore Cliqué ...")).otherwise(concat(message,  " choisi ", nbFois.asString(), " fois")));
        panneau.styleProperty().bind(concat("-fx-background-color:", couleurPanneau));

        texteDuBas.textProperty().bind(Bindings.when(pasEncoreClic).then(concat("Clique sur un bouton allez ...")).otherwise(concat(message, " est une jolie couleur !")));
        texteDuBas.styleProperty().bind(concat("-fx-text-fill: ", couleurPanneau));
    }
    @Override
    public void start(Stage primaryStage) {
        root = new BorderPane();

        texteDuHaut = new Label();
        texteDuHaut.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        BorderPane.setAlignment(texteDuHaut, Pos.CENTER);

        panneau = new Pane();
        panneau.setPrefSize(400, 200);

        VBox bas = new VBox();
        boutons = new HBox(10);
        boutons.setAlignment(Pos.CENTER);
        boutons.setPadding(new Insets(10, 5, 10, 5));
        texteDuBas = new Label();
        bas.setAlignment(Pos.CENTER_RIGHT);
        bas.getChildren().addAll(boutons, texteDuBas);

        vert = new Button("Vert");
        rouge = new Button("Rouge");
        bleu = new Button("Bleu");


        nbFois = new SimpleIntegerProperty();
        message = new SimpleStringProperty();
        couleurPanneau = new SimpleStringProperty("#000000");

        createBindings();

        vert.setOnAction(event -> {
            nbFois.setValue(++nbVert);
            // texteDuHaut.setText("Vert choisi " + nbFois.get() + " fois");

            message.setValue(vert.getText());
            couleurPanneau.setValue("#008000;");
        });

        rouge.setOnAction(event -> {
            nbFois.setValue(++nbRouge);
            // texteDuHaut.setText("Rouge choisi " + nbFois.get() + " fois");

            message.setValue(rouge.getText());
            couleurPanneau.setValue("#FF0000;");
        });

        bleu.setOnAction(event -> {
            nbFois.setValue(++nbBleu);;
            // texteDuHaut.setText("Bleu choisi " + nbFois.get() + " fois");

            message.setValue(bleu.getText());
            couleurPanneau.setValue("#0000ff;");
        });

        boutons.getChildren().addAll(vert, rouge, bleu);

        root.setCenter(panneau);
        root.setTop(texteDuHaut);
        root.setBottom(bas);

        Scene scene = new Scene(root);

        primaryStage.setScene(scene);
        primaryStage.show();
    }
}

