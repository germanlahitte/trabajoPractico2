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
    private TableroView tableroView;
    private BorderPane ventana;
    private PanelBatalla panelBatalla;
    private Direccion direccion;

    public HandlerMover(Pieza piezaMueve, Posicion posicionCasillero, Posicion posicionPieza, Ronda ronda, TableroView tableroView, BorderPane ventana, PanelBatalla batallaView) {
        this.pieza = (Movible) piezaMueve;
        this.ronda = ronda;
        this.tableroView = tableroView;
        this.ventana = ventana;
        this.panelBatalla = batallaView;
        this.direccion = Direccion.direccionDesdeHasta(posicionPieza, posicionCasillero);

    }

    @Override
    public void handle(ActionEvent actionEvent) {
        try {
            this.pieza.mover(this.direccion);
            this.panelBatalla.setVisible(false);
            AudioClip audioMover = new AudioClip(Paths.get("src/main/java/vista/audio/click.wav").toUri().toString());
            audioMover.play();
            this.ronda.avanzar();
            this.tableroView.prepararElegir(this.ronda.getJugadorActual().getEquipo(), this.ventana, this.ronda);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
