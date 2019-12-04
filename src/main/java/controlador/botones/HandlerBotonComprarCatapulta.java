package controlador.botones;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.media.AudioClip;
import modelo.juego.Ronda;

import java.nio.file.Paths;

public class HandlerBotonComprarCatapulta implements EventHandler<ActionEvent> {

    private Ronda ronda;

    public HandlerBotonComprarCatapulta(Ronda ronda){
        this.ronda = ronda;
    }

    @Override
    public void handle(ActionEvent evento){
        this.ronda.getJugadorActual().comprarCatapulta();
        this.ronda.avanzar();
        AudioClip audioJugar = new AudioClip(Paths.get("src/main/java/vista/audio/catapulta.wav").toUri().toString());
        audioJugar.play();
    }
}
