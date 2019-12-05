package vista.contenedores;

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
    private TableroComprarView vistaTablero;

    public PantallaDeJuego(Stage ventana, Juego batalla) {
        super();

        this.ventana = ventana;

        this.partida = batalla;
        this.tablero = this.partida.getTablero();

        //this.vistaTablero = new TableroView(this.tablero);

        //this.getChildren().add(this.vistaTablero);

    }
}
