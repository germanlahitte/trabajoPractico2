package vista.contenedores;

import controlador.buttonHandlers.HandlerBotonBatalla;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import modelo.juego.Juego;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import modelo.juego.Jugador;
import modelo.ubicacion.Tablero;


public class PantallaDeJuego extends VBox {
    private Juego partida;
    private Jugador jugadorRojo;
    private Jugador jugadorAzul;
    private Stage ventana;
    private Tablero tablero;
    private TableroView vistaTablero;
    private MenuTienda tiendaView;
    private TurnoView turnoView;

    public PantallaDeJuego(Stage ventana, Juego batalla) {
        super();
        BorderPane border = new BorderPane();
        border.setPadding(new Insets(10, 20, 10, 20));
        this.ventana = ventana;

        this.partida = batalla;
        this.tablero = this.partida.getTablero();

        this.vistaTablero = new TableroView(this.tablero);

        this.tiendaView = new MenuTienda(this.partida.getRonda(), this.vistaTablero);

        this.turnoView = new TurnoView(this.partida.getRonda());

        Button botonPelear = new Button("Comenzar la batalla");
        HandlerBotonBatalla eventoComenzarBatalla = new HandlerBotonBatalla(border, tiendaView, this.partida.getRonda(), this.vistaTablero, botonPelear, this.turnoView);
        botonPelear.setOnAction(eventoComenzarBatalla);
        VBox vbox = new VBox(botonPelear);
        vbox.setAlignment(Pos.CENTER_LEFT);

        this.turnoView.setDescripcion("Primera Fase: compren y ubiquen sus piezas.");

        border.setTop(turnoView);
        border.setLeft(vbox);
        border.setCenter(vistaTablero);
        border.setRight(tiendaView);

        this.getChildren().add(border);

    }
}
