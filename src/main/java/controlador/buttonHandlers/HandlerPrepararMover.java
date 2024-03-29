package controlador.buttonHandlers;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import modelo.juego.Ronda;
import modelo.piezas.Pieza;
import vista.contenedores.PanelBatalla;
import vista.contenedores.TableroView;

public class HandlerPrepararMover implements EventHandler<ActionEvent> {
    private TableroView vistaTablero;
    private Pieza pieza;

    public HandlerPrepararMover(Pieza pieza, TableroView vistaTablero) {
        this.pieza = pieza;
        this.vistaTablero = vistaTablero;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        this.vistaTablero.prepararMover(this.pieza);
    }
}
