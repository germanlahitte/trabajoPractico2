package vista.contenedores;

import controlador.buttonHandlers.HandlerAtacar;
import controlador.buttonHandlers.HandlerBotonComprar;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import modelo.equipos.Equipo;
import modelo.juego.Ronda;
import modelo.piezas.Catapulta;
import modelo.piezas.Curandero;
import modelo.piezas.Pieza;
import modelo.piezas.Soldado;
import vista.ConstantesDeAplicacion;

public class MenuBatalla extends VBox {

    private BorderPane ventana;
    private Ronda ronda;
    private TableroView vistaTablero;

    public MenuBatalla(Pieza pieza, TableroView vistaTablero, Ronda ronda, BorderPane ventana) {
        this.setAlignment(Pos.CENTER_LEFT);
        this.setWidth(200);
        this.ronda = ronda;
        this.ventana = ventana;
        this.vistaTablero = vistaTablero;
        this.setSpacing(5);

        Text vidaText = new Text("Vida " + pieza.getNombre() + ": " + pieza.getVida());
        this.getChildren().add(vidaText);

        if (pieza.getClass() != Catapulta.class) {
            Button botonMover = new Button("Mover");
            botonMover.setMinWidth(ConstantesDeAplicacion.getAnchoBotones());
            this.getChildren().add(botonMover);
        }

        if (pieza.getClass() == Soldado.class) {
            Button botonMoverBatallon = new Button("Mover Batallon");
            botonMoverBatallon.setMinWidth(ConstantesDeAplicacion.getAnchoBotones());
            this.getChildren().add(botonMoverBatallon);
        }

        Button botonAtacar = new Button();
        if (pieza.getClass()== Curandero.class){
            botonAtacar.setText("Curar");
        } else {
            botonAtacar.setText("Atacar");
        }
        botonAtacar.setMinWidth(ConstantesDeAplicacion.getAnchoBotones());
        HandlerAtacar eventoAtacar = new HandlerAtacar(pieza, vistaTablero, ronda, ventana, this);
        botonAtacar.setOnAction(eventoAtacar);
        this.getChildren().add(botonAtacar);


        Button botonPasar = new Button("Pasar");
        botonPasar.setMinWidth(ConstantesDeAplicacion.getAnchoBotones());
        this.getChildren().add(botonPasar);

    }
}
