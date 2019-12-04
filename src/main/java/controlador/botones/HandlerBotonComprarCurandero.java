package controlador.botones;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.media.AudioClip;
import modelo.juego.Ronda;

import java.nio.file.Paths;

public class HandlerBotonComprarCurandero implements EventHandler<ActionEvent> {

    private Ronda ronda;

    public HandlerBotonComprarCurandero(Ronda ronda){
        this.ronda = ronda;
    }

    @Override
    public void handle(ActionEvent evento){
        this.ronda.getJugadorActual().comprarCurandero();
        AudioClip audioJugar = new AudioClip(Paths.get("src/main/java/vista/audio/crearCurandero.wav").toUri().toString());
        audioJugar.play();
    }
}
