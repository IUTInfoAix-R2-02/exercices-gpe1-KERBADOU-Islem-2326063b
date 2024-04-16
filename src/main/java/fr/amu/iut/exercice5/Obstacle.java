package fr.amu.iut.exercice5;

import javafx.scene.Node;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Obstacle extends Rectangle {
    public Obstacle(){
        super(40, 50, Color.RED);
        super.setLayoutX(59);
        super.setLayoutY(59);
    }

}
