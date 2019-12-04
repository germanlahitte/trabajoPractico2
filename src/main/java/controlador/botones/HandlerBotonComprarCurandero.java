package controlador.botones;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.media.AudioClip;
import modelo.juego.Juego;
import modelo.juego.Ronda;
import modelo.juego.Tienda;

import java.nio.file.Paths;

public class HandlerBotonComprarCurandero implements EventHandler<ActionEvent> {

    private Juego partida;

    public HandlerBotonComprarCurandero(Juego partida){
        this.partida = partida;
    }

    @Override
    public void handle(ActionEvent evento){
        this.partida.getRonda().getJugadorActual().comprarCurandero();
        this.partida.getTienda().venta();
        this.partida.getRonda().avanzar();
        AudioClip audioJugar = new AudioClip(Paths.get("src/main/java/vista/audio/crearCurandero.wav").toUri().toString());
        audioJugar.play();
    }
}
