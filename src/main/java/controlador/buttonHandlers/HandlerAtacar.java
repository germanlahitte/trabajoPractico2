package controlador.buttonHandlers;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.layout.BorderPane;
import modelo.juego.Ronda;
import modelo.piezas.Pieza;
import vista.contenedores.TableroView;

public class HandlerAtacar implements EventHandler<ActionEvent> {

    private BorderPane ventana;
    private Ronda ronda;
    private TableroView vistaTablero;
    private Pieza pieza;

    public HandlerAtacar(Pieza pieza, TableroView vistaTablero, Ronda ronda, BorderPane ventana) {
        this.pieza = pieza;
        this.vistaTablero = vistaTablero;
        this.ronda = ronda;
        this.ventana = ventana;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        this.vistaTablero.prepararAtacar(this.pieza, this.ronda, this.ventana);
    }
}
