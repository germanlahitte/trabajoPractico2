package controlador.buttonHandlers;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.layout.BorderPane;
import modelo.juego.Ronda;
import modelo.piezas.Pieza;
import vista.contenedores.PanelBatalla;
import vista.contenedores.TableroView;

public class HandlerPrepararMoverBatallon implements EventHandler<ActionEvent> {

    private PanelBatalla batallaView;
    private BorderPane ventana;
    private Ronda ronda;
    private TableroView vistaTablero;
    private Pieza pieza;

    public HandlerPrepararMoverBatallon(Pieza pieza, TableroView vistaTablero, Ronda ronda, BorderPane ventana, PanelBatalla panelBatalla) {
        this.pieza = pieza;
        this.vistaTablero = vistaTablero;
        this.ronda = ronda;
        this.ventana = ventana;
        this.batallaView = panelBatalla;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        this.vistaTablero.prepararMoverBatallon(this.pieza, this.ronda, this.ventana, this.batallaView);
    }
}
