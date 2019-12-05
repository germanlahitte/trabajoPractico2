package controlador.buttonHandlers;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.layout.BorderPane;
import modelo.juego.Jugador;
import modelo.juego.Ronda;
import vista.contenedores.MenuBatalla;
import vista.contenedores.TableroView;

public class HandlerBotonBatalla implements EventHandler<ActionEvent> {

    BorderPane ventana;
    MenuBatalla vistaBatalla;
    Ronda ronda;

    public HandlerBotonBatalla(BorderPane ventana, MenuBatalla batallaView, Ronda ronda) {
        this.ventana = ventana;
        this.vistaBatalla = batallaView;
        this.ronda = ronda;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        if (this.ronda.puedenComprar()){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Atencion");
            alert.setHeaderText("No pueden comenzar la batalla aún");
            alert.setContentText("Deben gastar todos los créditos");
            alert.showAndWait();
        } else {
            this.ventana.setRight(this.vistaBatalla);
        }

    }
}
