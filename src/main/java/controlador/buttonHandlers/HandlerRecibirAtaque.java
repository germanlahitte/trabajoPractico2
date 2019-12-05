package controlador.buttonHandlers;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.layout.BorderPane;
import modelo.juego.Ronda;
import modelo.piezas.Pieza;
import vista.contenedores.TableroView;

public class HandlerRecibirAtaque implements EventHandler<ActionEvent> {
    private BorderPane ventana;
    private TableroView vistaTablero;
    private Ronda ronda;
    private Pieza piezaAtaca, piezaRecibe;


    public HandlerRecibirAtaque(Pieza piezaAtaca, Pieza piezaRecibe, Ronda ronda, TableroView tableroView, BorderPane ventana) {
        this.piezaAtaca = piezaAtaca;
        this.piezaRecibe = piezaRecibe;
        this.ronda = ronda;
        this.vistaTablero = tableroView;
        this.ventana = ventana;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        try {
            this.piezaAtaca.atacar(this.piezaRecibe);
            this.ronda.avanzar();
            this.vistaTablero.prepararElegir(this.ronda.getJugadorActual().getEquipo(), this.ventana, this.ronda);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}