package controlador.buttonHandlers;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import vista.contenedores.TableroView;

public class HandlerBotonCancelar implements EventHandler<ActionEvent> {
    private TableroView vistaTablero;

    public HandlerBotonCancelar(TableroView vistaTablero) {
        this.vistaTablero = vistaTablero;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        this.vistaTablero.change();
    }

}
