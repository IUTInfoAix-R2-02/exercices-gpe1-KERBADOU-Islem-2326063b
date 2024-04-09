package com.example.partiel;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Separator;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class VBoxAndHBoxApp extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        VBox vbox = new VBox();

        HBox topControls = new HBox();
        Button btnRefresh = new Button("Refresh");

        HBox topRightControls = new HBox();
        Hyperlink signOutLink = new Hyperlink("Sign out");
        topRightControls.getChildren().add(signOutLink);

        topControls.getChildren().addAll(btnRefresh, topRightControls);

        // Création du tableau
        TableView<Object> tblCustomers = new TableView<>();
        // TableColumn<Object, String> lastNa


        // Ajout dans la classe VBox
        vbox.getChildren().addAll(topControls);

        // Création de la page
        Scene scene = new Scene(vbox );

        primaryStage.setScene( scene );
        primaryStage.setWidth( 800 );
        primaryStage.setHeight( 600 );
        primaryStage.setTitle("Premier exemple manipulant les conteneurs");

        primaryStage.show();
    }
}
