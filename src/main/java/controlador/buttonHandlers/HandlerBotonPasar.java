package controlador.buttonHandlers;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.layout.BorderPane;
import modelo.juego.Ronda;
import vista.contenedores.MenuBatalla;
import vista.contenedores.TableroView;

public class HandlerBotonPasar implements EventHandler<ActionEvent> {

    private MenuBatalla menuBatalla;
    private BorderPane ventana;
    private TableroView vistaTablero;
    private Ronda ronda;

    public HandlerBotonPasar(TableroView vistaTablero, Ronda ronda, BorderPane ventana, MenuBatalla menuBatalla) {

        this.ronda = ronda;
        this.vistaTablero = vistaTablero;
        this.ventana = ventana;
        this.menuBatalla = menuBatalla;
    }

    @Override
    public void handle(ActionEvent actionEvent) {

        this.menuBatalla.setVisible(false);
        this.ronda.avanzar();
        this.vistaTablero.prepararElegir(this.ronda.getJugadorActual().getEquipo(), this.ventana, this.ronda);
    }
}
