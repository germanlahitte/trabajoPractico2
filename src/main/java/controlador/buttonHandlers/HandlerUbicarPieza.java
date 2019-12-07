package controlador.buttonHandlers;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.media.AudioClip;
import modelo.juego.Jugador;
import modelo.juego.Ronda;
import modelo.piezas.Pieza;
import modelo.ubicacion.Casillero;
import modelo.ubicacion.Posicion;
import modelo.ubicacion.Tablero;
import vista.contenedores.TableroView;

import java.nio.file.Paths;

public class HandlerUbicarPieza implements EventHandler<ActionEvent> {

    Pieza pieza;
    Tablero tablero;
    Posicion posicion;
    Ronda ronda;

    public HandlerUbicarPieza(Pieza newPieza, TableroView tableroView, Ronda ronda) {
        this.tablero = tableroView.getTablero();
        this.pieza = newPieza;
        this.ronda = ronda;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        try {
            this.tablero.ubicar(this.pieza, this.posicion);
            AudioClip audioJugar = new AudioClip(Paths.get("src/main/java/vista/audio/sePudoUbicar.wav").toUri().toString());
            audioJugar.play();
            this.ronda.avanzar();
        }
        catch (Exception e) {
            AudioClip audioJugar = new AudioClip(Paths.get("src/main/java/vista/audio/nonono.wav").toUri().toString());
            audioJugar.play();
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Atencion");
            alert.setHeaderText("No se pudo colocar la pieza");
            alert.setContentText(e.getMessage());
            alert.showAndWait();
            System.out.println(e.getMessage());
        }
    }

    public void setPosicion(Posicion pos){
        this.posicion = pos;
    }
}
