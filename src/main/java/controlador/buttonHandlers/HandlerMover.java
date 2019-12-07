package controlador.buttonHandlers;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.layout.BorderPane;
import javafx.scene.media.AudioClip;
import modelo.juego.Ronda;
import modelo.piezas.Movible;
import modelo.piezas.Pieza;
import modelo.ubicacion.Direccion;
import modelo.ubicacion.Posicion;
import vista.contenedores.PanelBatalla;
import vista.contenedores.TableroView;

import java.nio.file.Paths;

public class HandlerMover implements EventHandler<ActionEvent> {

    private Movible pieza;
    private Ronda ronda;
    private Direccion direccion;
    private TableroView vistaTablero;

    public HandlerMover(Pieza piezaMueve, Posicion posicionCasillero, Posicion posicionPieza,Ronda ronda, TableroView vistaTablero) {
        this.pieza = (Movible) piezaMueve;
        this.ronda = ronda;
        this.direccion = Direccion.direccionDesdeHasta(posicionPieza, posicionCasillero);
        this.vistaTablero = vistaTablero;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        try {
            this.pieza.mover(this.direccion);
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
