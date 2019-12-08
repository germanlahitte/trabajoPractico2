package vista.contenedores;

import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.layout.VBox;
import javafx.scene.media.AudioClip;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import modelo.equipos.EquipoAzul;
import modelo.juego.Jugador;
import modelo.juego.Observer;
import modelo.juego.Ronda;

import java.nio.file.Paths;

public class PanelTurno extends VBox implements Observer {

    Text jugadorText;
    Text descripcionText;
    Ronda ronda;
    Scene escenaFinal;
    Stage ventana;

    public PanelTurno(Ronda ronda, Stage ventana) {
        this.setAlignment(Pos.CENTER);
        this.ronda = ronda;
        this.jugadorText = new Text();
        jugadorText.setFont(Font.loadFont("file:src/main/java/vista/imagenes/fuente.ttf", 16));
        this.jugadorText.setStroke(Color.WHITE);
        this.descripcionText = new Text();
        descripcionText.setFont(Font.loadFont("file:src/main/java/vista/imagenes/fuente.ttf", 16));
        this.descripcionText.setStroke(Color.WHITE);
        ronda.addObserver(this);
        this.getChildren().addAll(this.jugadorText, this.descripcionText);
        this.ventana = ventana;
    }

    public void setEscenaFinal(Scene escenaFinal) {
        this.escenaFinal = escenaFinal;
    }

    public void setDescripcion(String descripcion) {
        this.descripcionText.setText(descripcion);
    }

    @Override
    public void change() {
        if (this.juegoTerminado() && !this.ronda.puedenComprar()){
            AudioClip audioInicio = new AudioClip(Paths.get("src/main/java/vista/audio/jingle2.wav").toUri().toString());
            audioInicio.play();
            this.ventana.setScene(this.escenaFinal);
        }
        Jugador jugadorActual = this.ronda.getJugadorActual();
        if (jugadorActual.getEquipo().getClass() == EquipoAzul.class) {
            jugadorText.setFill(Color.DARKBLUE);
            descripcionText.setFill(Color.DARKBLUE);
        } else {
            jugadorText.setFill(Color.FIREBRICK);
            descripcionText.setFill(Color.FIREBRICK);
        }
        this.jugadorText.setText("Turno Jugador: " + jugadorActual.getNombre() + " [" + jugadorActual.getEquipo().getNombre() + "]");
        if (this.ronda.puedenComprar()) {
            this.descripcionText.setText("Primera Fase: Compren y ubiquen sus piezas");
        }
    }

    private Jugador getGanador(){
        Jugador ganador=null;
        for (Jugador jugador : this.ronda.getJugadores()) {
            if (!jugador.esPerdedor()){
                ganador = jugador;
            }
        }
        return ganador;
    }

    private boolean juegoTerminado() {
        for (Jugador jugador : this.ronda.getJugadores()) {
            if (jugador.esPerdedor()) {
                return true;
            }
        }
        return false;
    }
}
