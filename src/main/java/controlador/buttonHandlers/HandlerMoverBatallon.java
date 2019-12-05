package controlador.buttonHandlers;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.layout.BorderPane;
import modelo.juego.Ronda;
import modelo.piezas.Batallon;
import modelo.piezas.Pieza;
import modelo.piezas.Soldado;
import modelo.ubicacion.Direccion;
import modelo.ubicacion.Posicion;
import vista.contenedores.PanelBatalla;
import vista.contenedores.TableroView;

import java.util.ArrayList;

public class HandlerMoverBatallon implements EventHandler<ActionEvent> {

    private Soldado pieza;
    private Ronda ronda;
    private TableroView tableroView;
    private BorderPane ventana;
    private PanelBatalla panelBatalla;
    private Direccion direccion;

    public HandlerMoverBatallon(Pieza piezaMueve, Posicion posicionCasillero, Posicion posicionPieza, Ronda ronda, TableroView tableroView, BorderPane ventana, PanelBatalla batallaView) {

        this.ronda = ronda;
        this.tableroView = tableroView;
        this.ventana = ventana;
        this.panelBatalla = batallaView;
        this.pieza = (Soldado) piezaMueve;
        this.direccion = Direccion.direccionDesdeHasta(posicionPieza, posicionCasillero);
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        try {
            Batallon batallon = new Batallon(this.pieza);
            ArrayList<Pieza> vecinos = this.pieza.getCasillero().piezasVecinas();
            for (Pieza pieza: vecinos) {
                if (pieza.getClass() == Soldado.class){
                    batallon.enlistar((Soldado)pieza);
                }
            }
            batallon.mover(this.direccion);
            this.panelBatalla.setVisible(false);
            this.ronda.avanzar();
            this.tableroView.prepararElegir(this.ronda.getJugadorActual().getEquipo(), this.ventana, this.ronda);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}
