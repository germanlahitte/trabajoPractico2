package controlador.buttonHandlers;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import modelo.juego.Ronda;
import vista.contenedores.MenuTienda;
import vista.contenedores.TableroView;
import vista.contenedores.PanelTurno;

public class HandlerBotonBatalla implements EventHandler<ActionEvent> {

    private PanelTurno panelTurno;
    private BorderPane ventana;
    private MenuTienda vistaTienda;
    private Ronda ronda;
    private TableroView vistaTablero;
    private Button boton;

    public HandlerBotonBatalla(BorderPane ventana, MenuTienda tiendaView, Ronda ronda, TableroView tableroView, Button boton, PanelTurno panelTurno) {
        this.ventana = ventana;
        this.vistaTienda = tiendaView;
        this.ronda = ronda;
        this.vistaTablero = tableroView;
        this.boton = boton;
        this.panelTurno = panelTurno;
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
            this.panelTurno.setDescripcion("Fase de batalla: A pelear!");
            this.vistaTablero.prepararElegir(this.ronda.getJugadorActual().getEquipo(), this.ventana, this.ronda);
        }

    }
}
