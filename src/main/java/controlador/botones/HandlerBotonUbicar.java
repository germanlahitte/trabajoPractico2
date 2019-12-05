package controlador.botones;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.media.AudioClip;
import modelo.ubicacion.Posicion;
import modelo.ubicacion.Tablero;
import vista.contenedores.MenuTienda;

import java.nio.file.Paths;

public class HandlerBotonUbicar implements EventHandler<ActionEvent> {

    private Posicion posicion;
    private MenuTienda menuTienda;
    private Tablero tablero;

    public HandlerBotonUbicar(Posicion posicionEnTablero,Tablero tablero,MenuTienda menuTienda){
        this.posicion = posicionEnTablero;
        this.tablero = tablero;
        this.menuTienda = menuTienda;
    }

    @Override
    public void handle (ActionEvent evento){
        try {
            tablero.ubicar(menuTienda.getPiezaParaUbicar(), posicion);
            AudioClip audioJugar = new AudioClip(Paths.get("src/main/java/vista/audio/sePudoUbicar.wav").toUri().toString());
            audioJugar.play();
            menuTienda.getPartida().getRonda().avanzar();
        } catch (RuntimeException rtEx) {
            AudioClip audioJugar = new AudioClip(Paths.get("src/main/java/vista/audio/nonono.wav").toUri().toString());
            audioJugar.play();
        }
    }
}
