package controlador.botones;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import modelo.Jugador;
import modelo.ProveedorConstantes;
import vista.contenedores.PantallaDeJuego;


public class BotonJugar implements EventHandler<ActionEvent> {

    Stage ventana;
    Scene proximaEscena;
    PantallaDeJuego pantalla;

    public BotonJugar(Stage ventana, TextField nombreRojo, TextField nombreAzul){
        this.ventana = ventana;
        this.pantalla = new PantallaDeJuego(ventana, nombreRojo, nombreAzul);
        this.proximaEscena = new Scene(pantalla, ProveedorConstantes.getAnchoVentana(),ProveedorConstantes.getAltoVentana());
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        ventana.setScene(proximaEscena);
        ventana.setFullScreen(false);
    }
}