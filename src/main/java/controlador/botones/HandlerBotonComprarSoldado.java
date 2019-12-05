package controlador.botones;

import excepciones.NoAlcanzanLasMonedasException;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.media.AudioClip;
import modelo.juego.Juego;

import java.nio.file.Paths;

public class HandlerBotonComprarSoldado implements EventHandler <ActionEvent> {

    private Juego partida;

    public HandlerBotonComprarSoldado(Juego partida){
        this.partida = partida;
    }

    @Override
    public void handle(ActionEvent evento){
        try{
            this.partida.getTienda().venderSoldado(this.partida.getRonda().getJugadorActual());
            /*Primero ubico*///this.partida.getRonda().avanzar();
            AudioClip audioJugar = new AudioClip(Paths.get("src/main/java/vista/audio/soldado.wav").toUri().toString());
            audioJugar.play();
        }catch (NoAlcanzanLasMonedasException e){
            AudioClip audioJugar = new AudioClip(Paths.get("src/main/java/vista/audio/noMoney.wav").toUri().toString());
            audioJugar.play();
        }

    }
}
