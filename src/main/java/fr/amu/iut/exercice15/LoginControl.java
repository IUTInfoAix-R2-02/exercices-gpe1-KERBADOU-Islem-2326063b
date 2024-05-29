package fr.amu.iut.exercice15;

import javafx.beans.binding.Bindings;
import javafx.beans.binding.BooleanBinding;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

import static javafx.beans.binding.Bindings.concat;

public class LoginControl extends GridPane {
    @FXML
    private TextField userId;

    @FXML
    private PasswordField pwd;

    @FXML
    private Button cancelBtn;
    @FXML
    public void initialize(){
        createBindings();
    }

    @FXML
    private Button okBtn;

    private static BooleanBinding edit;


    private static BooleanBinding cancel;

    private static BooleanBinding ok;


    @FXML
    private void createBindings() {
        edit = new BooleanBinding() {
            {
                this.bind(userId.textProperty());
            }
            @Override
            protected boolean computeValue() {
                if (userId.getLength() >= 6) {
                    return true;
                }

                else {
                    return false;
                }
            }
        };

        pwd.editableProperty().bind(edit);

        cancel = new BooleanBinding() {

            {
                this.bind(userId.textProperty(), pwd.textProperty());
            }
            @Override
            protected boolean computeValue() {
                if (userId.getLength() > 0 || pwd.getLength() > 0) {
                    return false;
                }
                else return true;
            }
        };

        cancelBtn.disableProperty().bind(cancel);

        ok = new BooleanBinding() {

            {
                this.bind(pwd.textProperty());
            }
            @Override
            protected boolean computeValue() {
                String letters = pwd.getText();
                boolean maj = false;
                boolean chiffre = false;

                if (pwd.getLength()>=8) {
                    for (int i = 0; i < pwd.getLength(); ++i) {
                        char Character = letters.charAt(i);
                        if ((Character >= 65 && Character <= 90)) {
                            maj = true;

                        } else if (Character >= 48 && Character <= 57) {
                            chiffre = true;
                        }

                        if (maj && chiffre) {
                            return false;
                        }
                    }
                }
                return true;
            }
        };

        okBtn.disableProperty().bind(ok);

    }

    @FXML
    private void okClicked() {
        System.out.print(userId.getText() + " ");
        for (char c : pwd.getText().toCharArray()) {
            System.out.print("*");
        }
        System.out.println();
    }

    @FXML
    private void cancelClicked() {
        userId.setText("");
        pwd.setText("");
    }
}