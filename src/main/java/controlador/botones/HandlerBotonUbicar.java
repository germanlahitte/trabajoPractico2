package controlador.botones;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.media.AudioClip;
import modelo.piezas.Curandero;
import modelo.piezas.Jinete;
import modelo.piezas.Soldado;
import modelo.ubicacion.Posicion;
import modelo.ubicacion.Tablero;
import vista.botones.*;
import vista.contenedores.MenuTienda;

import java.nio.file.Paths;

public class HandlerBotonUbicar implements EventHandler<ActionEvent> {

    private Posicion posicion;
    private MenuTienda menuTienda;
    private Tablero tablero;
    private Button boton;


    public HandlerBotonUbicar(Posicion posicionEnTablero, Tablero tablero, MenuTienda menuTienda, Button boton) {
        this.posicion = posicionEnTablero;
        this.tablero = tablero;
        this.menuTienda = menuTienda;
        this.boton = boton;
    }

    @Override
    public void handle(ActionEvent evento) {
        try {
            tablero.ubicar(menuTienda.getPiezaParaUbicar(), posicion);
            AudioClip audioJugar = new AudioClip(Paths.get("src/main/java/vista/audio/sePudoUbicar.wav").toUri().toString());
            audioJugar.play();
            this.cambiarVista();
            menuTienda.resetPiezaAUbicar();
            menuTienda.getPartida().getRonda().avanzar();
        } catch (RuntimeException rtEx) {
            AudioClip audioJugar = new AudioClip(Paths.get("src/main/java/vista/audio/nonono.wav").toUri().toString());
            audioJugar.play();
        }
    }

    private void cambiarVista() {
        if (menuTienda.getPiezaParaUbicar().getClass() == Soldado.class) {
            VistaPiezaSoldado vistaBotonSoldado = new VistaPiezaSoldado(this.boton);
        } else {
            if (menuTienda.getPiezaParaUbicar().getClass() == Jinete.class) {
                VistaPiezaJinete vistaBotonJinete = new VistaPiezaJinete(this.boton);
            } else {
                if (menuTienda.getPiezaParaUbicar().getClass() == Curandero.class) {
                    VistaPiezaCurandero vistaBotonCurandero = new VistaPiezaCurandero(this.boton);
                } else {
                    VistaPiezaCatapulta vistaBotonCatapulta = new VistaPiezaCatapulta(this.boton);
                }
            }
        }
    }


}
