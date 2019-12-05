package controlador.buttonHandlers;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.layout.BorderPane;
import modelo.juego.Ronda;
import modelo.piezas.Pieza;
import vista.contenedores.MenuBatalla;
import vista.contenedores.TableroView;

public class HandlerPrepararAtacar implements EventHandler<ActionEvent> {

    private MenuBatalla batallaView;
    private BorderPane ventana;
    private Ronda ronda;
    private TableroView vistaTablero;
    private Pieza pieza;

    public HandlerPrepararAtacar(Pieza pieza, TableroView vistaTablero, Ronda ronda, BorderPane ventana, MenuBatalla menuBatalla) {
        this.pieza = pieza;
        this.vistaTablero = vistaTablero;
        this.ronda = ronda;
        this.ventana = ventana;
        this.batallaView = menuBatalla;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        this.vistaTablero.prepararAtacar(this.pieza, this.ronda, this.ventana, this.batallaView);
    }
}
