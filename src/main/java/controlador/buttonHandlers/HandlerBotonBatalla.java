package controlador.buttonHandlers;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import modelo.juego.Jugador;
import modelo.juego.Ronda;
import modelo.ubicacion.Tablero;
import vista.contenedores.MenuBatalla;
import vista.contenedores.MenuTienda;
import vista.contenedores.TableroView;
import vista.contenedores.TurnoView;

public class HandlerBotonBatalla implements EventHandler<ActionEvent> {

    private TurnoView turnoView;
    private BorderPane ventana;
    private MenuTienda vistaTienda;
    private Ronda ronda;
    private TableroView vistaTablero;
    private Button boton;

    public HandlerBotonBatalla(BorderPane ventana, MenuTienda tiendaView, Ronda ronda, TableroView tableroView, Button boton, TurnoView turnoView) {
        this.ventana = ventana;
        this.vistaTienda = tiendaView;
        this.ronda = ronda;
        this.vistaTablero = tableroView;
        this.boton = boton;
        this.turnoView = turnoView;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        if (this.ronda.puedenComprar()){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Atencion");
            alert.setHeaderText("No pueden comenzar la batalla aún");
            alert.setContentText("Deben gastar todos los créditos");
            alert.showAndWait();
        } else {
            this.vistaTienda.setVisible(false);
            this.ronda.iniciarRonda();
            this.boton.setVisible(false);
            this.turnoView.setDescripcion("Fase de batalla: A pelear!");
            this.vistaTablero.prepararElegir(this.ronda.getJugadorActual().getEquipo(), this.ventana, this.ronda);
        }

    }
}
