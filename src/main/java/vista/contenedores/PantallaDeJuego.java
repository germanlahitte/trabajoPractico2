package vista.contenedores;

import javafx.scene.control.MenuBar;
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
    private BarraDeMenu menu;

    public PantallaDeJuego(Stage ventana, Juego batalla) {
        super();

        this.ventana = ventana;

        this.partida = batalla;
        this.tablero = this.partida.getTablero();

        this.vistaTablero = new TableroView(this.tablero);

        this.menu = new BarraDeMenu(ventana);


        this.getChildren().addAll(this.vistaTablero, this.menu);

    }
}
