package fr.amu.iut.exercice16;

import javafx.application.Application;
import javafx.beans.binding.*;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.converter.NumberStringConverter;

public class ConvertisseurTemperatures extends Application {
    private static DoubleBinding celsiusBinding;

    private static DoubleBinding fahrenheitBinding;

    private DoubleProperty cel;

    private DoubleProperty fah;
    @Override
    public void start(Stage primaryStage) {

        VBox panneauCelsius = new VBox(30);
        VBox panneauFahrenheit = new VBox(30);

        Label labelCelsius = new Label("°C");
        labelCelsius.setStyle("-fx-font-weight: bold;-fx-font-size: 15px");

        Slider celsius = new Slider(0, 100, 25);
        celsius.setShowTickMarks(true);
        celsius.setShowTickLabels(true);
        celsius.setMajorTickUnit(10);
        celsius.setBlockIncrement(0.1f);
        celsius.setOrientation(Orientation.VERTICAL);
        celsius.setMinHeight(500.0);

        TextField celsiusText = new TextField();
        celsiusText.setMaxWidth(50);

        Label labelFahreinheit = new Label("°F");
        labelFahreinheit.setStyle("-fx-font-weight: bold;-fx-font-size: 15px");

        Slider fahrenheit = new Slider(0, 212, 95);
        fahrenheit.setShowTickMarks(true);
        fahrenheit.setShowTickLabels(true);
        fahrenheit.setMajorTickUnit(15);
        fahrenheit.setBlockIncrement(0.1f);
        fahrenheit.setOrientation(Orientation.VERTICAL);
        fahrenheit.setMinHeight(500.0);

        TextField fahrenheitText = new TextField();
        fahrenheitText.setMaxWidth(50);

        /*
        celsiusBinding = new DoubleBinding() {
            {
                this.bind(fahrenheit.getProperties());
            }

            @Override
            protected double computeValue() {
                return fahrenheit.getValue() - 32 * 5/9;
            }
        };
        fahrenheitBinding = new DoubleBinding() {
            {
                this.bind(celsius.getProperties());
            }

            @Override
            protected double computeValue() {
                return celsius.getValue() * 9/5 + 32;
            }
        };
         */

        cel = new SimpleDoubleProperty();
        fah = new SimpleDoubleProperty();

        celsius.valueProperty().addListener((observable, oldVal, newVal) -> fahrenheit.setValue(newVal.doubleValue() * 9/5 + 32));
        fahrenheit.valueProperty().addListener((observable, oldVal, newVal) -> celsius.setValue((newVal.doubleValue() - 32) * 5/9));

        Bindings.bindBidirectional(celsiusText.textProperty(), celsius.valueProperty(), new NumberStringConverter());
        Bindings.bindBidirectional(fahrenheitText.textProperty(), fahrenheit.valueProperty(), new NumberStringConverter());

        panneauCelsius.getChildren().addAll(labelCelsius, celsius, celsiusText);
        panneauFahrenheit.getChildren().addAll(labelFahreinheit, fahrenheit, fahrenheitText);

        HBox root = new HBox(30, panneauCelsius, panneauFahrenheit);
        root.setPadding(new Insets(20));

        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

}