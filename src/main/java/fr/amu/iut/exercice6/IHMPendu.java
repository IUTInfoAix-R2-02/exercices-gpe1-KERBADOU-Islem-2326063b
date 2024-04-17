package fr.amu.iut.exercice6;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class IHMPendu extends Application {
    private int nbVie = 7;
    private int nbTrouves = 0;
    private Dico dico;
    private VBox vboxForButtons;
    private HBox hboxForButtons1;
    private HBox hboxForButtons2;
    private HBox hboxForButtons3;
    private Label vieString;
    private Label motString;
    private String mot = "";
    private String motFinal;
    private Image image;
    private ImageView imageview;
    private Button rejouer;
    char[] liste1 = {'a', 'e', 'i', 'o', 'u', 'y'};
    char[] liste2 = {'b', 'c', 'd', 'f', 'g', 'h', 'j', 'k', 'l', 'm'};
    char[] liste3 = {'n', 'p', 'q', 'r', 's', 't', 'v', 'w', 'x', 'z'};



    @Override
    public void start(Stage primaryStage) throws Exception {
        InitializeGame();

        UpdateGame();

        primaryStage.setTitle("Jeu du pendu");
        primaryStage.setWidth(500);
        primaryStage.setHeight(550);

        VBox root = new VBox();
        root.setAlignment(Pos.CENTER);
        root.setSpacing(20);

        root.getChildren().addAll(imageview, vieString, motString, vboxForButtons, rejouer);
        root.setStyle("-fx-background-color: #dafdf7");
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);

        primaryStage.show();
    }


    public void InitializeGame(){
        dico = new Dico();
        mot = dico.getMot();
        motFinal = mot;
        String motAfficher = "";
        System.out.println(mot);

        for (int i = 0; i < mot.length(); ++i){
            motAfficher += '*';
        }

        // Nombre de vie
        vieString = new Label("Nombre de vies : " + nbVie);
        motString = new Label(motAfficher);
        vieString.setStyle("-fx-font-weight: bold");
        motString.setStyle("-fx-font-weight: bold");
        vieString.setFont(new Font(20.0));
        motString.setFont(new Font(20.0));

        vboxForButtons = new VBox();
        hboxForButtons1 = new HBox();
        hboxForButtons2 = new HBox();
        hboxForButtons3 = new HBox();

        hboxForButtons1.setAlignment(Pos.CENTER);
        hboxForButtons1.setSpacing(5);
        hboxForButtons2.setAlignment(Pos.CENTER);
        hboxForButtons2.setSpacing(5);
        hboxForButtons3.setAlignment(Pos.CENTER);
        hboxForButtons3.setSpacing(5);
        vboxForButtons.setAlignment(Pos.CENTER);
        vboxForButtons.getChildren().addAll(hboxForButtons1, hboxForButtons2, hboxForButtons3);

        image = new Image(IHMPendu.class.getResource("/exercice6/pendu" + nbVie + ".png").toString());
        imageview = new ImageView();
        imageview.setImage(image);

        rejouer = new Button("Rejouer");

    }
    public void UpdateGame(){
        for (int i = 0; i < liste1.length; ++i) {
            char letter = liste1[i];

            Button btnNumber = new Button();
            btnNumber.setPrefWidth(50);
            btnNumber.setText(String.valueOf(letter));
            btnNumber.setStyle("-fx-background-color: transparent;-fx-font-size:22;" +
                    "-fx-border-color: orange;" +
                    "-fx-border-radius: 10;" +
                    "-fx-text-fill: #5ec9b7");
            btnNumber.setOnAction((ActionEvent)->{
                ButtonClickHandler(ActionEvent, letter, btnNumber);

            });
            hboxForButtons1.getChildren().add(btnNumber);
        }

        for (int i = 0; i < liste2.length; ++i) {
            char letter = liste2[i];

            Button btnNumber = new Button();
            btnNumber.setPrefWidth(50);
            btnNumber.setText(String.valueOf(letter));
            btnNumber.setStyle("-fx-background-color: transparent;-fx-font-size:22;" +
                    "-fx-border-color: orange;" +
                    "-fx-border-radius: 10;" +
                    "-fx-text-fill: #5ec9b7");
            btnNumber.setOnAction((ActionEvent)->{
                ButtonClickHandler(ActionEvent, letter, btnNumber);

            });
            hboxForButtons2.getChildren().add(btnNumber);
        }

        for (int i = 0; i < liste3.length; ++i) {
            char letter = liste3[i];

            Button btnNumber = new Button();
            btnNumber.setPrefWidth(50);
            btnNumber.setText(String.valueOf(letter));
            btnNumber.setStyle("-fx-background-color: transparent;-fx-font-size:22;" +
                    "-fx-border-color: orange;" +
                    "-fx-border-radius: 10;" +
                    "-fx-text-fill: #5ec9b7");
            btnNumber.setOnAction((ActionEvent)->{
                ButtonClickHandler(ActionEvent, letter, btnNumber);

            });
            hboxForButtons3.getChildren().add(btnNumber);
        }

        rejouer.setOnAction((ActionEvent) -> {
            ReplayClickHandler(ActionEvent);
        });

    }

    public void ReplayClickHandler(Event e){
        nbVie = 0;
        image = new Image(IHMPendu.class.getResource("/exercice6/pendu0.png").toString());
        imageview.setImage(image);
        mot = dico.getMot();
    }
    public void ButtonClickHandler(Event e, char letter, Button btn){
        btn.setStyle("-fx-background-color: transparent;-fx-font-size:22;" +
                "-fx-border-color: orange;" +
                "-fx-border-radius: 10;" +
                "-fx-text-fill: #5ec9b7;" +
                "-fx-opacity: 0.25");

        btn.setDisable(true);

        int index = mot.indexOf(letter);

        if (mot.indexOf(letter) >= 0){
            while (mot.indexOf(letter) >= 0) {
                index = mot.indexOf(letter);
                ++nbTrouves;
                mot = mot.substring(0, index) + '#' + mot.substring(index + 1);
                motString.setText(motString.getText().substring(0, index) + letter + motString.getText().substring(index + 1));
            }
        }
        else if (nbVie > 1){
            --nbVie;
            vieString.setText("Nombre de vies : " + nbVie);
            image = new Image(IHMPendu.class.getResource("/exercice6/pendu" + nbVie + ".png").toString());
            imageview.setImage(image);
        }

        else {
            vieString.setText("VOUS AVEZ PERDU !");
            motString.setText("Skill Issue " + motFinal);
            image = new Image(IHMPendu.class.getResource("/exercice6/pendu0.png").toString());
            imageview.setImage(image);
        }

        if (nbTrouves == mot.length()){
            vieString.setText("VOUS AVEZ GAGNE !");
            motString.setText("GROS GG : " + motFinal);
            image = new Image(IHMPendu.class.getResource("/exercice6/penduWin.png").toString());
            imageview.setImage(image);
        }

    }

    public static void main(String[] args) {
        launch(args);
    }
}
