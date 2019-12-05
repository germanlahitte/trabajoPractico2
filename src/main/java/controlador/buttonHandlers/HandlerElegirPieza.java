package controlador.buttonHandlers;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.layout.BorderPane;
import modelo.equipos.Equipo;
import modelo.piezas.Pieza;
import modelo.ubicacion.Posicion;
import vista.contenedores.MenuBatalla;

public class HandlerElegirPieza implements EventHandler<ActionEvent> {
    Pieza pieza;
    BorderPane ventana;
    public HandlerElegirPieza(Pieza pieza, BorderPane ventana) {
        this.pieza = pieza;
        this.ventana = ventana;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        this.ventana.setRight(new MenuBatalla(this.pieza));
    }

}
