package controlador.botones;

import controlador.juego.Juego;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import modelo.Jugador;
import modelo.ProveedorConstantes;
import modelo.equipos.EquipoAzul;
import modelo.equipos.EquipoRojo;
import vista.contenedores.PantallaDeJuego;


public class BotonJugar implements EventHandler<ActionEvent> {

    Stage ventana;
    Scene proximaEscena;
    Juego partida;
    TextField campoNombreRojo, campoNombreAzul;

    public BotonJugar(Stage ventana, TextField nombreRojo, TextField nombreAzul, Juego partida, Scene proximaEscena){
        this.ventana = ventana;
        this.proximaEscena = proximaEscena;

        this.partida = partida;
        this.campoNombreAzul = nombreAzul;
        this.campoNombreRojo = nombreRojo;

    }

    @Override
    public void handle(ActionEvent actionEvent) {
        ventana.setScene(proximaEscena);
        ventana.setFullScreen(false);
        this.partida.agregar(new Jugador(this.campoNombreRojo.getText(), new EquipoRojo()));
        this.partida.agregar(new Jugador(this.campoNombreAzul.getText(), new EquipoAzul()));
    }
}