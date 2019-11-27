package controlador.botones;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class BotonAvanzar implements EventHandler<ActionEvent> {

    Stage ventana;
    Scene proximaEscena;

    public BotonAvanzar(Stage ventana, Scene proximaEscena){
        this.ventana = ventana;
        this.proximaEscena = proximaEscena;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        ventana.setScene(proximaEscena);
        ventana.setFullScreen(false);
    }
}

