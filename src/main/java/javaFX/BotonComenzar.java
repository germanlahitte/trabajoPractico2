package javaFX;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;

public class BotonComenzar implements EventHandler<ActionEvent> {
    private TextField textField;
    private Label label;

    public BotonComenzar(TextField textField, Label label) {
        this.textField = textField;
        this.label = label;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        if (this.textField.getText().trim().equals("")) {

            this.label.setText("Comenzar el juego");
            this.label.setTextFill(Color.web("#FF0000"));

        } else {

            this.label.setText(this.textField.getText());
            this.label.setTextFill(Color.web("#336600"));
        }
    }

    }






