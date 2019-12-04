package controlador.botones;

import excepciones.NoAlcanzanLasMonedasException;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.media.AudioClip;
import modelo.juego.Juego;

import java.nio.file.Paths;

public class HandlerBotonComprarCurandero implements EventHandler<ActionEvent> {

    private Juego partida;

    public HandlerBotonComprarCurandero(Juego partida){
        this.partida = partida;
    }

    @Override
    public void handle(ActionEvent evento){
        try{
            this.partida.getTienda().venderCurandero(this.partida.getRonda().getJugadorActual());
            this.partida.getRonda().avanzar();
            AudioClip audioJugar = new AudioClip(Paths.get("src/main/java/vista/audio/crearCurandero.wav").toUri().toString());
            audioJugar.play();
        } catch(NoAlcanzanLasMonedasException e){
            //sonidito
        }

    }
}
