package controlador.buttonHandlers;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.layout.BorderPane;
import modelo.juego.Ronda;
import modelo.piezas.Pieza;
import vista.contenedores.PanelBatalla;
import vista.contenedores.TableroView;

public class HandlerPrepararMoverBatallon implements EventHandler<ActionEvent> {
    private TableroView vistaTablero;
    private Pieza pieza;

    public HandlerPrepararMoverBatallon(Pieza pieza, TableroView vistaTablero) {
        this.pieza = pieza;
        this.vistaTablero = vistaTablero;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        this.vistaTablero.prepararMoverBatallon(this.pieza);
    }
}
