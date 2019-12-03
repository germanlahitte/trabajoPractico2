package controlador.buttonHandlers;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.MenuItem;
import javafx.stage.Stage;

public class HandlerBotonPantallaCompleta implements EventHandler <ActionEvent> {

    Stage stage;
    MenuItem opcionPantallaCompleta;

    public HandlerBotonPantallaCompleta(Stage stage, MenuItem opcionPantallaCompleta) {
        this.stage = stage;
        this.opcionPantallaCompleta = opcionPantallaCompleta;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        if (!stage.isFullScreen()) {
            stage.hide();
            stage.setFullScreen(true);
            opcionPantallaCompleta.setDisable(true);
            stage.show();
        }
    }
}
