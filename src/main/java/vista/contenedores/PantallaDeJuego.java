package vista.contenedores;

import controlador.juego.Juego;
import javafx.scene.Node;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import modelo.Jugador;
import modelo.equipos.EquipoAzul;
import modelo.equipos.EquipoRojo;
import modelo.ubicacion.Tablero;


public class PantallaDeJuego extends VBox {
    private Juego partida;
    private Jugador jugadorRojo;
    private Jugador jugadorAzul;
    private Stage ventana;
    private Tablero tablero;
    private TableroView vistaTablero;

    public PantallaDeJuego(Stage ventana, TextField nombreRojo, TextField nombreAzul) {
        super();

        this.ventana = ventana;

        this.partida = new Juego();
        this.tablero = this.partida.getTablero();

        this.jugadorRojo = new Jugador(nombreRojo.getText(), new EquipoRojo());
        this.jugadorAzul = new Jugador(nombreAzul.getText(), new EquipoAzul());

        this.partida.agregar(jugadorRojo);
        this.partida.agregar(jugadorAzul);

        this.vistaTablero = new TableroView(this.tablero);

        this.getChildren().add(this.vistaTablero);

    }
}
