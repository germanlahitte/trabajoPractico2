package controlador.botones;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.media.AudioClip;
import modelo.juego.Ronda;

import java.nio.file.Paths;

public class HandlerBotonComprarJinete implements EventHandler<ActionEvent> {

    private Ronda ronda;

    public HandlerBotonComprarJinete(Ronda ronda){
        this.ronda = ronda;
    }

    @Override
    public void handle(ActionEvent evento){
        this.ronda.getJugadorActual().comprarJinete();
        this.ronda.avanzar();
        AudioClip audioJugar = new AudioClip(Paths.get("src/main/java/vista/audio/crearJinete.wav").toUri().toString());
        audioJugar.play();
    }
}