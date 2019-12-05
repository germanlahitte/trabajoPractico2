package controlador.buttonHandlers;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.layout.BorderPane;
import modelo.juego.Ronda;
import modelo.piezas.Pieza;
import vista.contenedores.PanelBatalla;
import vista.contenedores.TableroView;

public class HandlerElegirPieza implements EventHandler<ActionEvent> {
    private Ronda ronda;
    private TableroView vistaTablero;
    Pieza pieza;
    BorderPane ventana;

    public HandlerElegirPieza(Pieza pieza, BorderPane ventana, TableroView tableroView, Ronda ronda) {
        this.pieza = pieza;
        this.ventana = ventana;
        this.vistaTablero = tableroView;
        this.ronda = ronda;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        this.ventana.setRight(new PanelBatalla(this.pieza, this.vistaTablero, this.ronda, this.ventana));
    }

}
