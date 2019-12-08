package controlador.buttonHandlers;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.layout.BorderPane;
import modelo.juego.Ronda;
import vista.contenedores.PanelBatalla;
import vista.contenedores.TableroView;

public class HandlerBotonPasar implements EventHandler<ActionEvent> {
    private Ronda ronda;

    public HandlerBotonPasar(Ronda ronda) {
        this.ronda = ronda;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        this.ronda.avanzar();
    }
}
