package controlador.buttonHandlers;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import vista.contenedores.PanelBatalla;
import vista.contenedores.TableroView;

public class HandlerBotonCancelar implements EventHandler<ActionEvent> {
    private PanelBatalla panelBatalla;
    private TableroView vistaTablero;

    public HandlerBotonCancelar(TableroView vistaTablero, PanelBatalla panelBatalla) {
        this.vistaTablero = vistaTablero;
        this.panelBatalla = panelBatalla;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        this.panelBatalla.setVisible(false);
        this.vistaTablero.change();
    }

}
