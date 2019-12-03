package controlador.buttonHandlers;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;
import modelo.juego.Jugador;

public class HandleBotonComprar implements EventHandler<ActionEvent> {

    Jugador jugador;
    int pieza;


    public HandleBotonComprar(Jugador jugador, int pieza) {
        this.jugador = jugador;
        this.pieza= pieza;
    }

    @Override
    public void handle(ActionEvent actionEvent) {

    }
}
