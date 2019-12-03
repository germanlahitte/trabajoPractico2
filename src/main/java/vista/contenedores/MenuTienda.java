package vista.contenedores;

import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import modelo.juego.Ronda;


public class MenuTienda extends VBox {

    public MenuTienda(Ronda ronda){

        Button botonComprarSoldado = new Button("Comprar Soldado");

        this.getChildren().add(botonComprarSoldado);

    }
}
