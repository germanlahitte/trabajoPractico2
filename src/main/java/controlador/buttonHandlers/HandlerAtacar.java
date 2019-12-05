package controlador.buttonHandlers;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import modelo.juego.Ronda;
import modelo.piezas.Pieza;
import vista.contenedores.TableroView;

public class HandlerAtacar implements EventHandler<ActionEvent> {

    private Ronda ronda;
    private TableroView vistaTablero;
    private Pieza pieza;

    public HandlerAtacar(Pieza pieza, TableroView vistaTablero, Ronda ronda) {
        this.pieza = pieza;
        this.vistaTablero = vistaTablero;
        this.ronda = ronda;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        this.vistaTablero.prepararAtacar(this.pieza.getEquipo(), this.ronda);
    }
}
