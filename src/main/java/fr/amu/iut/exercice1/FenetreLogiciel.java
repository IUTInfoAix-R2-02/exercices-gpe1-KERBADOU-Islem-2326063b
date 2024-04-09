package fr.amu.iut.exercice1;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;

import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

public class FenetreLogiciel extends Application {

    @Override
    public void start(Stage primaryStage) {
        BorderPane root = new BorderPane();

        // Menu top left

        // Creation du menu File
        Menu fileMenu = new Menu("File");
        Menu editMenu = new Menu("Edit");
        Menu helpMenu = new Menu("Help");

        // Création des items
        // Fichier
        MenuItem item1 = new MenuItem("New");
        MenuItem item2 = new MenuItem("Open");
        MenuItem item3 = new MenuItem("Save");
        MenuItem item4 = new MenuItem("Close");

        // Edit
        MenuItem item5 = new MenuItem("Cut");
        MenuItem item6 = new MenuItem("Copy");
        MenuItem item7 = new MenuItem("Paste");

        // Ajout des items
        fileMenu.getItems().addAll(item1, item2, item3, item4);
        editMenu.getItems().addAll(item5, item6, item7);

        MenuBar menuBar = new MenuBar(fileMenu, editMenu, helpMenu);

        root.setTop(menuBar);

        // Boutons midLeft
        HBox midControls = new HBox();
        VBox h1 = new VBox();



        Label text = new Label("Boutons :");

        Button btn1 = new Button("Bouton 1");
        Button btn2 = new Button("Bouton 2");
        Button btn3 = new Button("Bouton 3");
        Separator sepa =  new Separator(Orientation.VERTICAL);



        h1.setSpacing(10);
        midControls.setSpacing(10);
        h1.getChildren().addAll(text, btn1, btn2, btn3);

        h1.setAlignment(Pos.CENTER_LEFT);
        h1.setAlignment(Pos.CENTER);
        text.setAlignment(Pos.CENTER);

        midControls.getChildren().addAll(h1, new Separator(Orientation.VERTICAL));

        root.setLeft(midControls);

        // FORM

        VBox millieu = new VBox();
        HBox form = new HBox();
        HBox boutton = new HBox();

        form.setAlignment(Pos.CENTER);
        form.setSpacing(10);

        GridPane gridpane = new GridPane();
        gridpane.setVgap(10);
        millieu.setSpacing(10);

        gridpane.add(new TextField(), 2, 0);
        gridpane.add(new Label("Name:"), 1, 0);

        gridpane.add(new TextField(), 2, 1);
        gridpane.add(new Label("Email:"), 1, 1);

        gridpane.add(new TextField(), 2, 2);
        gridpane.add(new Label("Password:"), 1, 2);

        Button btn4 = new Button("Submit");
        Button btn5 = new Button("Cancel");

        form.getChildren().addAll(gridpane);
        boutton.getChildren().addAll(btn4, btn5);
        millieu.getChildren().addAll(form, boutton);

        gridpane.setAlignment(Pos.CENTER);
        boutton.setAlignment(Pos.CENTER);
        boutton.setSpacing(10);
        millieu.setAlignment(Pos.CENTER);

        root.setCenter(millieu);

        // Label du bas

        VBox labelhBox = new VBox();
        labelhBox.setAlignment(Pos.CENTER);
        Text label = new Text("Ceci est un label de base de page");
        labelhBox.getChildren().addAll(new Separator(), label);
        root.setBottom(labelhBox);


        // Ajout dans vBox et création du stage

        Scene scene = new Scene( root );

        primaryStage.setScene( scene );
        primaryStage.setWidth( 800 );
        primaryStage.setHeight( 600 );
        primaryStage.setTitle("Premier exemple manipulant les conteneurs");

        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);

    }
}

