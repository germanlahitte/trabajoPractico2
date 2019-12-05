package vista.contenedores;

import javafx.geometry.Pos;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import modelo.juego.Jugador;
import modelo.juego.Observer;
import modelo.juego.Ronda;

public class TurnoView extends VBox implements Observer {

    Text jugadorText;
    Text descripcionText;
    Ronda ronda;

    public TurnoView(Ronda ronda) {
        this.setAlignment(Pos.CENTER);
        this.ronda = ronda;
        this.jugadorText = new Text();
        this.descripcionText = new Text();
        ronda.addObserver(this);
        this.getChildren().addAll(this.jugadorText, this.descripcionText);
    }

    public void setDescripcion(String descripcion) {
        this.descripcionText.setText(descripcion);
    }

    @Override
    public void change() {
        Jugador jugadorActual = this.ronda.getJugadorActual();
        this.jugadorText.setText("Turno Jugador: " + jugadorActual.getNombre() + " [" + jugadorActual.getEquipo().getNombre() + "]");
    }
}
