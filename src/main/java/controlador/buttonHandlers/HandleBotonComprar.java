package controlador.buttonHandlers;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;
import modelo.juego.Jugador;
import modelo.juego.Ronda;
import modelo.piezas.Pieza;

public class HandleBotonComprar implements EventHandler<ActionEvent> {

    Ronda ronda;
    //Jugador jugador;
    int pieza;


    public HandleBotonComprar(Ronda ronda, int pieza) {
        this.ronda = ronda;
        this.pieza= pieza;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        Pieza newPieza;
        switch(this.pieza){
            case 1:
                newPieza = this.ronda.getJugadorActual().comprarSoldado();
                break;
            case 2:
                newPieza = this.ronda.getJugadorActual().comprarJinete();
                break;
            case 3:
                newPieza = this.ronda.getJugadorActual().comprarCurandero();
                break;
            case 4:
                newPieza = this.ronda.getJugadorActual().comprarCatapulta();
                break;
        }
        this.ronda.avanzar();
    }
}
