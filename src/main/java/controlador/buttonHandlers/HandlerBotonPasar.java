package controlador.buttonHandlers;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.layout.BorderPane;
import modelo.juego.Ronda;
import vista.contenedores.PanelBatalla;
import vista.contenedores.TableroView;

public class HandlerBotonPasar implements EventHandler<ActionEvent> {

    private PanelBatalla panelBatalla;
    private BorderPane ventana;
    private TableroView vistaTablero;
    private Ronda ronda;

    public HandlerBotonPasar(TableroView vistaTablero, Ronda ronda, BorderPane ventana, PanelBatalla panelBatalla) {

        this.ronda = ronda;
        this.vistaTablero = vistaTablero;
        this.ventana = ventana;
        this.panelBatalla = panelBatalla;
    }

    @Override
    public void handle(ActionEvent actionEvent) {

        this.panelBatalla.setVisible(false);
        this.ronda.avanzar();
        this.vistaTablero.prepararElegir(this.ronda.getJugadorActual().getEquipo(), this.ventana, this.ronda);
    }
}
