package controlador.botones;

import modelo.juego.Juego;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.media.AudioClip;
import javafx.stage.Stage;
import modelo.juego.Jugador;
import modelo.equipos.EquipoAzul;
import modelo.equipos.EquipoRojo;

import java.nio.file.Paths;


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
        AudioClip jugar = new AudioClip(Paths.get("src/main/java/vista/audio/redobleSimple.wav").toUri().toString());
        jugar.play();
    }
}