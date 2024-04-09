package fr.amu.iut.exercice1;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class FenetreLogiciel extends Application {

    @Override
    public void start(Stage primaryStage) {
        BorderPane root = new BorderPane();

        // Top Menu

        // File menu creation
        Menu fileMenu = new Menu("File");
        Menu editMenu = new Menu("Edit");
        Menu helpMenu = new Menu("Help");

        // Creating menu items
        // File
        MenuItem newItem = new MenuItem("New");
        MenuItem openItem = new MenuItem("Open");
        MenuItem saveItem = new MenuItem("Save");
        MenuItem closeItem = new MenuItem("Close");

        // Edit
        MenuItem cutItem = new MenuItem("Cut");
        MenuItem copyItem = new MenuItem("Copy");
        MenuItem pasteItem = new MenuItem("Paste");

        // Adding items
        fileMenu.getItems().addAll(newItem, openItem, saveItem, closeItem);
        editMenu.getItems().addAll(cutItem, copyItem, pasteItem);

        MenuBar menuBar = new MenuBar(fileMenu, editMenu, helpMenu);

        root.setTop(menuBar);

        // Left Buttons
        HBox midControls = new HBox();
        VBox leftBox = new VBox();

        Label buttonLabel = new Label("Boutons:");

        Button button1 = new Button("Bouton 1");
        Button button2 = new Button("Bouton 2");
        Button button3 = new Button("Bouton 3");

        leftBox.setSpacing(10);
        midControls.setSpacing(10);
        leftBox.getChildren().addAll(buttonLabel, button1, button2, button3);

        leftBox.setAlignment(Pos.CENTER_LEFT);
        leftBox.setAlignment(Pos.CENTER);
        buttonLabel.setAlignment(Pos.CENTER);

        midControls.getChildren().addAll(leftBox, new Separator(Orientation.VERTICAL));

        root.setLeft(midControls);

        // Form

        VBox centerBox = new VBox();
        HBox formBox = new HBox();
        HBox buttonBox = new HBox();

        formBox.setAlignment(Pos.CENTER);
        formBox.setSpacing(10);

        GridPane gridPane = new GridPane();
        gridPane.setVgap(10);
        centerBox.setSpacing(10);

        gridPane.add(new TextField(), 2, 0);
        gridPane.add(new Label("Name:"), 1, 0);

        gridPane.add(new TextField(), 2, 1);
        gridPane.add(new Label("Email:"), 1, 1);

        gridPane.add(new TextField(), 2, 2);
        gridPane.add(new Label("Password:"), 1, 2);

        Button submitButton = new Button("Submit");
        Button cancelButton = new Button("Cancel");

        formBox.getChildren().addAll(gridPane);
        buttonBox.getChildren().addAll(submitButton, cancelButton);
        centerBox.getChildren().addAll(formBox, buttonBox);

        gridPane.setAlignment(Pos.CENTER);
        buttonBox.setAlignment(Pos.CENTER);
        buttonBox.setSpacing(10);
        centerBox.setAlignment(Pos.CENTER);

        root.setCenter(centerBox);

        // Bottom Label

        VBox bottomLabelBox = new VBox();
        bottomLabelBox.setAlignment(Pos.CENTER);
        Text bottomLabel = new Text("Ceci est un label de bas de page");
        bottomLabelBox.getChildren().addAll(new Separator(), bottomLabel);
        root.setBottom(bottomLabelBox);

        // Adding to VBox and creating the stage

        Scene scene = new Scene(root);

        primaryStage.setScene(scene);
        primaryStage.setWidth(800);
        primaryStage.setHeight(600);
        primaryStage.setTitle("Premier exemple manipulant les conteneur");

        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
