package controlador.botones;

import excepciones.NoAlcanzanLasMonedasException;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.media.AudioClip;
import modelo.juego.Juego;

import java.nio.file.Paths;

public class HandlerBotonComprarJinete implements EventHandler<ActionEvent> {

    private Juego partida;

    public HandlerBotonComprarJinete(Juego partida){
        this.partida = partida;
    }

    @Override
    public void handle(ActionEvent evento){
        try{
            this.partida.getTienda().venderJinete(this.partida.getRonda().getJugadorActual());
            this.partida.getRonda().avanzar();
            AudioClip audioJugar = new AudioClip(Paths.get("src/main/java/vista/audio/crearJinete.wav").toUri().toString());
            audioJugar.play();
        }catch (NoAlcanzanLasMonedasException e){
            //sonidito
        }

    }
}