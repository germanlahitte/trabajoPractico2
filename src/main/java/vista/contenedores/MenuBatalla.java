package vista.contenedores;

import controlador.buttonHandlers.HandlerBotonComprar;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import modelo.juego.Ronda;
import modelo.ubicacion.Tablero;

public class MenuBatalla extends VBox {

    Ronda ronda;
    TableroView vistaTablero;

    public MenuBatalla(Ronda ronda, TableroView vistaTablero) {
        this.setAlignment(Pos.CENTER_LEFT);
        this.setWidth(200);
        this.ronda = ronda;
        this.vistaTablero = vistaTablero;

        Button botonMover = new Button("Mover");
        Button botonAtacar = new Button("Atacar");
        Button botonPasar = new Button("Pasar");

        this.setSpacing(5);
        this.getChildren().addAll(botonAtacar,botonMover,botonPasar);
    }
}
