package controlador.buttonHandlers;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.layout.BorderPane;
import javafx.scene.media.AudioClip;
import modelo.juego.Ronda;
import modelo.piezas.Batallon;
import modelo.piezas.Pieza;
import modelo.piezas.Soldado;
import modelo.ubicacion.Direccion;
import modelo.ubicacion.Posicion;
import vista.contenedores.PanelBatalla;
import vista.contenedores.TableroView;

import java.nio.file.Paths;
import java.util.ArrayList;

public class HandlerMoverBatallon implements EventHandler<ActionEvent> {

    private Soldado pieza;
    private Ronda ronda;
    private Direccion direccion;

    public HandlerMoverBatallon(Pieza piezaMueve, Posicion posicionCasillero, Posicion posicionPieza, Ronda ronda) {

        this.ronda = ronda;
        this.pieza = (Soldado) piezaMueve;
        this.direccion = Direccion.direccionDesdeHasta(posicionPieza, posicionCasillero);
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        try {
            Batallon batallon = new Batallon(this.pieza);
            ArrayList<Pieza> vecinos = this.pieza.getCasillero().piezasAliadasVecinas(this.pieza.getEquipo());
            for (Pieza pieza: vecinos) {
                if (pieza.getClass() == Soldado.class){
                    batallon.enlistar((Soldado)pieza);
                }
            }
            batallon.mover(this.direccion);
            AudioClip audioMover = new AudioClip(Paths.get("src/main/java/vista/audio/click.wav").toUri().toString());
            audioMover.play();
            /*Se puede mover y atacar*///this.ronda.avanzar();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}
