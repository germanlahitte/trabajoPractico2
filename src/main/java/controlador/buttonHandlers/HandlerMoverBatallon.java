package controlador.buttonHandlers;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.media.AudioClip;
import modelo.juego.Ronda;
import modelo.piezas.Batallon;
import modelo.piezas.Pieza;
import modelo.piezas.Soldado;
import modelo.ubicacion.Direccion;
import modelo.ubicacion.Posicion;
import vista.contenedores.TableroView;

import java.nio.file.Paths;
import java.util.ArrayList;

public class HandlerMoverBatallon implements EventHandler<ActionEvent> {

    private Soldado soldado;
    private Ronda ronda;
    private Direccion direccion;
    private TableroView vistaTablero;

    public HandlerMoverBatallon(Pieza piezaMueve, Posicion posicionCasillero, Posicion posicionPieza, Ronda ronda,TableroView vistaTablero) {

        this.ronda = ronda;
        this.soldado = (Soldado) piezaMueve;
        this.direccion = Direccion.direccionDesdeHasta(posicionPieza, posicionCasillero);
        this.vistaTablero = vistaTablero;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        try {
            Batallon batallon = new Batallon(this.soldado);
            ArrayList<Pieza> vecinos = this.soldado.getCasillero().piezasAliadasVecinas(this.soldado.getEquipo());
            for (Pieza pieza: vecinos) {
                if (pieza.getClass() == Soldado.class && pieza.getEquipo().getClass() == this.soldado.getEquipo().getClass() ){
                    batallon.enlistar((Soldado)pieza);
                }
            }
            batallon.mover(this.direccion);
            AudioClip audioMover = new AudioClip(Paths.get("src/main/java/vista/audio/click.wav").toUri().toString());
            audioMover.play();
            /*Se puede mover y atacar*//*this.ronda.avanzar();*/
            this.vistaTablero.movimiento();
            this.vistaTablero.change();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}
