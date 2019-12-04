package controlador.botones;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.media.AudioClip;
import modelo.juego.Juego;

import java.nio.file.Paths;

public class HandlerBotonComprarCatapulta implements EventHandler<ActionEvent> {

    private Juego partida;

    public HandlerBotonComprarCatapulta(Juego partida){
        this.partida = partida;
    }

    @Override
    public void handle(ActionEvent evento){
        this.partida.getRonda().getJugadorActual().comprarCatapulta(this.partida.getTienda());
        this.partida.getRonda().avanzar();
        AudioClip audioJugar = new AudioClip(Paths.get("src/main/java/vista/audio/catapulta.wav").toUri().toString());
        audioJugar.play();
    }
}
