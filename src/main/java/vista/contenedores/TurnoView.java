package vista.contenedores;

import javafx.geometry.Pos;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import modelo.juego.Observer;
import modelo.juego.Ronda;

public class TurnoView extends VBox implements Observer {

    Text jugadorText;
    Text creditosText;
    Ronda ronda;

    public TurnoView(Ronda ronda) {
        this.setAlignment(Pos.CENTER);
        this.ronda = ronda;

        this.jugadorText = new Text();
        jugadorText.setFont(Font.loadFont("file:src/main/java/vista/imagenes/fuente.ttf",16));
        jugadorText.setFill(Color.GOLD);

        this.creditosText = new Text();
        creditosText.setFont(Font.loadFont("file:src/main/java/vista/imagenes/fuente.ttf",16));
        creditosText.setFill(Color.GOLD);

        ronda.addObserver(this);
        this.getChildren().addAll(this.jugadorText, this.creditosText);
    }

    @Override
    public void change() {
        this.jugadorText.setText("Turno Jugador:" + this.ronda.getJugadorActual().getNombre());
        this.creditosText.setText("Créditos disponibles:" + this.ronda.getJugadorActual().getCredito());
    }
}