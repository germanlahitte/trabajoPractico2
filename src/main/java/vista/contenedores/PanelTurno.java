package vista.contenedores;

import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import modelo.juego.Jugador;
import modelo.juego.Observer;
import modelo.juego.Ronda;

public class PanelTurno extends VBox implements Observer {

    Text jugadorText;
    Text descripcionText;
    Ronda ronda;

    public PanelTurno(Ronda ronda) {
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
        if (this.juegoTerminado() && !this.ronda.puedenComprar()){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Juego Terminado");

            Jugador ganador = this.getGanador();
            if (ganador != null) {
                alert.setHeaderText("Victoria!");
                alert.setContentText( "Ganador: " + ganador.getNombre() + " [" + ganador.getEquipo().getNombre() + "]");
                alert.showAndWait();
            } else {
                alert.setHeaderText("Empate!");
                alert.setContentText("Los equipos han empatado");
                alert.showAndWait();
            }
            Platform.exit();
        }
        Jugador jugadorActual = this.ronda.getJugadorActual();
        this.jugadorText.setText("Turno Jugador: " + jugadorActual.getNombre() + " [" + jugadorActual.getEquipo().getNombre() + "]");
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
        boolean hayGanador = false;
        for (Jugador jugador : this.ronda.getJugadores()) {
            hayGanador = jugador.esPerdedor();
        }
        return hayGanador;
    }
}
