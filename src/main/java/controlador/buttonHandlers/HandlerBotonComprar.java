package controlador.buttonHandlers;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import modelo.juego.Ronda;
import modelo.piezas.Pieza;
import vista.contenedores.MenuTienda;
import vista.contenedores.TableroView;

public class HandlerBotonComprar implements EventHandler<ActionEvent> {

    private Ronda ronda;
    private TableroView tableroView;
    private int pieza;
    private MenuTienda ventana;


    public HandlerBotonComprar(MenuTienda menuTienda, Ronda ronda, int pieza, TableroView vistaTablero) {
        this.ventana = menuTienda;
        this.ronda = ronda;
        this.tableroView = vistaTablero;
        this.pieza = pieza;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        try {
            Pieza newPieza;
            switch (this.pieza) {
                case 1:
                    newPieza = this.ronda.getJugadorActual().comprarSoldado();
                    break;
                case 2:
                    newPieza = this.ronda.getJugadorActual().comprarJinete();
                    break;
                case 3:
                    newPieza = this.ronda.getJugadorActual().comprarCurandero();
                    break;
                case 4:
                    newPieza = this.ronda.getJugadorActual().comprarCatapulta();
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + this.pieza);
            }
            this.tableroView.prepararUbicar(newPieza, this.ronda);
            this.ventana.setVisible(false);

        } catch (Exception e) {
            System.out.println(e.getMessage());
            if (!this.ronda.getJugadorActual().tieneSaldo()) {
                this.ronda.avanzar();
            }
        }
    }
}
